package com.example.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author robert
 * @date 2021/12/6
 */
public class JedisSingleTest {

    public static final String TENCENT_SERVER = "101.35.177.122";
    public static final String LOCAL_VIRTUAL = "192.168.100.116";

    public static void main(String[] args) {
        JedisPoolConfig jedisPoolConfig  = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMinIdle(5);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, LOCAL_VIRTUAL, 6379, 3000, null);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            System.out.println(jedis.set("single", "robert"));
            System.out.println(jedis.get("single"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
