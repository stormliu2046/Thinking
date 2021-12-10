package com.example.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author robert
 * @date 2021/12/9
 */
public class JedisClusterTest {

    public static void main(String[] args) throws IOException {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(10);
        config.setMinIdle(5);

        Set<HostAndPort> jedisClusterNode = new HashSet<>();
        jedisClusterNode.add(new HostAndPort(JedisSingleTest.LOCAL_VIRTUAL, 8001));
        jedisClusterNode.add(new HostAndPort(JedisSingleTest.LOCAL_VIRTUAL, 8002));
        jedisClusterNode.add(new HostAndPort(JedisSingleTest.LOCAL_VIRTUAL, 8003));
        jedisClusterNode.add(new HostAndPort(JedisSingleTest.LOCAL_VIRTUAL, 8004));
        jedisClusterNode.add(new HostAndPort(JedisSingleTest.LOCAL_VIRTUAL, 8005));
        jedisClusterNode.add(new HostAndPort(JedisSingleTest.LOCAL_VIRTUAL, 8006));

        JedisCluster jedisCluster = null;
        try {
            jedisCluster = new JedisCluster(jedisClusterNode, 6000, 5000, 10, "root", config);
            System.out.println(jedisCluster.set("cluster", "root"));
            System.out.println(jedisCluster.get("cluster"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedisCluster != null) {
                jedisCluster.close();
            }
        }
    }
}
