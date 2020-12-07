package com.example.demo.designpattern.factory.dependencyinjection;

/**
 * @author robert
 */
public class RedisCounter {
    private String ipAddress;
    private int port;

    public RedisCounter(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
    } //...
}
