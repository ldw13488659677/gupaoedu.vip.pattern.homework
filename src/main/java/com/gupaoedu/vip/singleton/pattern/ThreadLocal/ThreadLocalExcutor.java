package com.gupaoedu.vip.singleton.pattern.ThreadLocal;

public class ThreadLocalExcutor implements Runnable {
    @Override
    public void run() {
        ThreadLocalSingleton tls=ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+"==threadLocalSingleton:"+tls);
    }
}
