package com.gupaoedu.vip.singleton.pattern.RegsiterSingletonPattern;

public class ContainerSingletonTest {
    public static void main(String[] args) {
        Object obj=ContainerSingleton.getInstance("com.gupaoedu.vip.singleton.pattern.RegsiterSingletonPattern.ContainerSingleton");
        System.out.println(obj);
        Thread t0=new Thread(new ContainerExecutor());
        Thread t1=new Thread(new ContainerExecutor());
        t0.start();
        t1.start();
    }

}
