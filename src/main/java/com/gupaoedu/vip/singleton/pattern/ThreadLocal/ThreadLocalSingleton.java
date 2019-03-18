package com.gupaoedu.vip.singleton.pattern.ThreadLocal;

/*
* 伪线程安全的  指的是在单线程中实例化一次
* */
public class ThreadLocalSingleton {

    private  ThreadLocalSingleton(){}

    private static  final  ThreadLocal<ThreadLocalSingleton> threadLoacl=new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };
    public static ThreadLocalSingleton getInstance(){
        return threadLoacl.get();
    }
}
