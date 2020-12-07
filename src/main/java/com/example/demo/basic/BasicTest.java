package com.example.demo.basic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author robert
 */
public class BasicTest {

    //void f() {}

    int f() {
        return 1;
    }

    public static void main(String[] args) throws IOException {
        String str = "{\"amount\":\"20\"}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(str);
        JsonNode amountNode = jsonNode.get("amount");
        System.out.println(amountNode.asInt());
        FileWriter writer = new FileWriter("D://filewriter.txt");
        writer.write("hello world");
    }
}
