package com.gupaoedu.vip.singleton.pattern.hungrysingletonpattern;
/*
* 保证只实例化一次 缺点  占用JVM内存空间，每一个线程进来都要实例化，影响系统性能
* */
public class HungryPattern {

    private  static  final  HungryPattern INSTANCE=new HungryPattern();

    private HungryPattern(){}

    public  static  HungryPattern getInstance(){
        return  INSTANCE;
    }
}
