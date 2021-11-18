package com.stormliu.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
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

        area.forEach((key, value) -> {
            try {
                channel.basicPublish(RabbitConstant.EXCHANGE_WEATHER_TOPIC, key, null, value.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        channel.close();
        connection.close();
    }
}
