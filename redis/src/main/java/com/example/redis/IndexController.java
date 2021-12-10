package com.example.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author robert
 * @date 2021/12/7
 */
@Slf4j
@RestController
public class IndexController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/test_sentinel")
    public void testSentinel() {
        int i = 1;
        while (true) {
            try {
                stringRedisTemplate.opsForValue().set("zhuge" + i, i + "");
                System.out.println("设置key：" + "zhuge" + i);
                i++;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("错误：", e);
            }

        }
    }

    @RequestMapping("/test_cluster")
    public void testCluster() {
        stringRedisTemplate.opsForValue().set("robert", "666");
        System.out.println(stringRedisTemplate.opsForValue().get("robert"));
    }
}
