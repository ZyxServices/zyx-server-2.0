package com.zyx.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserPointDubboProvider {

    private static final Log log = LogFactory.getLog(UserPointDubboProvider.class);

    public static void main(String[] args) {
        try {
            System.out.println("测试...");
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
            System.out.println(UserPointDubboProvider.class.getName() + " : start");
            context.start();
            System.in.read();
        } catch (Exception e) {
            log.error("== UserPointDubboProvider context start error:", e);
        }
//		synchronized (UserPointDubboProvider.class) {
//			while (true) {
//				try {
//					UserPointDubboProvider.class.wait();
//				} catch (InterruptedException e) {
//					log.error("== synchronized error:",e);
//				}
//			}
//		}
    }

}