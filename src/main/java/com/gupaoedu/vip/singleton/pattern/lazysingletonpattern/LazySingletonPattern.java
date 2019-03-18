package com.gupaoedu.vip.singleton.pattern.lazysingletonpattern;
/*
* 懒汉式单例   节省内存空间，保证全局只有一个实例 但是有线程并发的安全问题
* 解决方案：
*
* 1:如果在方法上加synchronized关键字的话 容易导致对整个类锁死，如果并发量大的话，会影响系统性能 所以将
* synchronized关键字加到对外提供的访问点的方法区里面
* 2:如果将关键字加到方法里面 也会出现线程并发的安全问题 所以加双重校验 也就是双重锁来保证线程的安全问题
* 3：这种情况下 当调用者通过java的反射机制  去创建这个类的话  就会对这个单例造成破坏
*
* */
public class LazySingletonPattern {

    private  static    LazySingletonPattern INSTANCE=null;

    private  LazySingletonPattern(){

    }

    public static  LazySingletonPattern getInstance(){
        if (INSTANCE==null){
            synchronized (LazySingletonPattern.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazySingletonPattern();
                }
            }
        }
        return INSTANCE;
    }
}
