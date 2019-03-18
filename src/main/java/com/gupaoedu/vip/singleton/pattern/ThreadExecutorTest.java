package com.gupaoedu.vip.singleton.pattern;

import com.gupaoedu.vip.singleton.pattern.hungrysingletonpattern.HungryPattern;
import com.gupaoedu.vip.singleton.pattern.lazysingletonpattern.LazySingletonPattern;

public class ThreadExecutorTest implements  Runnable{
    @Override
    public void run() {
       /* HungryPattern hungryPattern=HungryPattern.getInstance();
        System.out.println(hungryPattern);*/
        LazySingletonPattern lazySingletonPattern=LazySingletonPattern.getInstance();
        System.out.println(lazySingletonPattern);
    }
}
