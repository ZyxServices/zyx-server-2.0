package com.zyx.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountDubboProvider {

    private static final Log log = LogFactory.getLog(AccountDubboProvider.class);

    public static void main(String[] args) {
        try {
            System.out.println("测试...");
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
            System.out.println(AccountDubboProvider.class.getName() + " : start");
            context.start();
            System.in.read();
        } catch (Exception e) {
            log.error("== AccountDubboProvider context start error:", e);
        }
//		synchronized (AccountDubboProvider.class) {
//			while (true) {
//				try {
//					AccountDubboProvider.class.wait();
//				} catch (InterruptedException e) {
//					log.error("== synchronized error:",e);
//				}
//			}
//		}
    }

}