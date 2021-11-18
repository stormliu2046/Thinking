package com.stormliu.confirm;

import com.rabbitmq.client.*;
import com.stormliu.utils.RabbitConnectionHelper;
import com.stormliu.utils.RabbitConstant;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author robert
 * @date 2021/11/18
 */
public class WeatherBureau {

    public static void main(String[] args) throws IOException, TimeoutException {
        Map<String, String> area = new LinkedHashMap<>();
        area.put("china.hunan.changsha.20201127", "中国湖南长沙20201127天气数据");
        area.put("china.hubei.wuhan.20201127", "中国湖北武汉20201127天气数据");
        area.put("china.hunan.zhuzhou.20201127", "中国湖南株洲20201128天气数据");
        area.put("us.cal.lsj.20201127", "美国加州洛杉矶20201127天气数据");

        area.put("china.hebei.shijiazhuang.20201128", "中国河北石家庄20201128天气数据");
        area.put("china.hubei.wuhan.20201128", "中国湖北武汉20201128天气数据");
        area.put("china.henan.zhengzhou.20201128", "中国河南郑州20201128天气数据");
        area.put("us.cal.lsj.20201128", "美国加州洛杉矶20201128天气数据");

        Connection connection = RabbitConnectionHelper.getConnection();

        Channel channel = connection.createChannel();
        channel.exchangeDeclare(RabbitConstant.EXCHANGE_WEATHER_TOPIC, "topic");

        // 开启监听模式
        channel.confirmSelect();

        channel.addConfirmListener(new ConfirmListener() {

            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                System.out.println("消息已被Broker接收,Tag:" + deliveryTag);
            }

            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                System.out.println("消息已被Broker拒收,Tag:" + deliveryTag);
            }
        });

        channel.addReturnListener(r -> {
            System.err.println("===========================");
            System.err.println("Return编码：" + r.getReplyCode() + "-Return描述:" + r.getReplyText());
            System.err.println("交换机:" + r.getExchange() + "-路由key:" + r.getRoutingKey());
            System.err.println("Return主题：" + new String(r.getBody()));
            System.err.println("===========================");
        });

//        channel.addReturnListener((replyCode, replyText, exchange, routingKey, properties, body) -> System.out.println(
//                replyCode + ":" + replyText + ":" + exchange + ":" + routingKey + ":" + new String(body)));

        area.forEach((key, value) -> {
            try {
                channel.basicPublish(RabbitConstant.EXCHANGE_WEATHER_TOPIC, key, true,null, value.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        //如果关闭则无法进行监听，因此此处不需要关闭
        /*channel.close();
        connection.close();*/
    }
}
