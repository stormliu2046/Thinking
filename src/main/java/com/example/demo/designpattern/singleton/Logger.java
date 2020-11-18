package com.example.demo.designpattern.singleton;

import sun.rmi.runtime.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author robert
 */
public class Logger {
    private FileWriter writer;
    private static final Logger instance = new Logger();

   private Logger() {
       try {
           writer = new FileWriter("D:\\log.txt");
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   public void log(String log) {
       try {
           writer.write(log);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   public static Logger getInstance() {
       return instance;
   }
}

class UserController {
    public void login(String username, String password) {
        //...业务
        Logger.getInstance().log("用户登录" + username);
    }
}

class OrderController {
    public void create(OrderVo orderVo) {
        //...业务
        Logger.getInstance().log("下单" + orderVo.toString());
    }
}