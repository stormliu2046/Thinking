package com.example.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * @author robert
 * @date 2021/12/7
 */
public class JedisSentinelTest {

    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(10);
        config.setMinIdle(5);

        String masterName = "mymaster";
        Set<String> sentinels = new HashSet<>();
        sentinels.add(new HostAndPort(JedisSingleTest.LOCAL_VIRTUAL, 26379).toString());
        sentinels.add(new HostAndPort(JedisSingleTest.LOCAL_VIRTUAL, 26380).toString());
        sentinels.add(new HostAndPort(JedisSingleTest.LOCAL_VIRTUAL, 26381).toString());

        JedisSentinelPool jedisSentinelPool = new JedisSentinelPool(masterName, sentinels, config, 3000, null);
        Jedis jedis = null;

        try {
            jedis = jedisSentinelPool.getResource();

            System.out.println(jedis.set("sentinel1", "robert"));
            System.out.println(jedis.get("sentinel1"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
