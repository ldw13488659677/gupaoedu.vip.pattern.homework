package com.gupaoedu.vip.singleton.pattern.ThreadLocal;

public class ThreadLocalSingletonTest {
    public static void main(String[] args) {

        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());

        Thread t1 = new Thread(new ThreadLocalExcutor());
        Thread t2 = new Thread(new ThreadLocalExcutor());
        t1.start();
        t2.start();
        System.out.println("End");

    }
}
