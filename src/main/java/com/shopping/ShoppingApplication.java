package com.shopping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoppingApplication {
    private static Logger logger = LoggerFactory.getLogger(ShoppingApplication.class);
    public static void main(String[] args) {
        logger.info("后台启动成功！");
        SpringApplication.run(ShoppingApplication.class, args);
    }

}
