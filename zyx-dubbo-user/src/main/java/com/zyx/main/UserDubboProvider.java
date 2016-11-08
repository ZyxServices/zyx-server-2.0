package com.zyx.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDubboProvider {

    private static final Log log = LogFactory.getLog(UserDubboProvider.class);

    public static void main(String[] args) {
        try {
            System.out.println("测试...");
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
            System.out.println(UserDubboProvider.class.getName() + " : start");
            context.start();
            System.in.read();
        } catch (Exception e) {
            log.error("== UserDubboProvider context start error:", e);
        }
    }
}