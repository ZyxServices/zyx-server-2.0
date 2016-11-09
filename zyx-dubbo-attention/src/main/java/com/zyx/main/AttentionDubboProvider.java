package com.zyx.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AttentionDubboProvider {

    private static final Log log = LogFactory.getLog(AttentionDubboProvider.class);

    public static void main(String[] args) {
        try {
            System.out.println("测试...");
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
            System.out.println(AttentionDubboProvider.class.getName() + " : start");
            context.start();
            System.in.read();
        } catch (Exception e) {
            log.error("== AttentionDubboProvider context start error:", e);
        }
    }
}