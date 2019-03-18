package com.gupaoedu.vip.singleton.pattern.RegsiterSingletonPattern;

public class ContainerExecutor implements Runnable {
    @Override
    public void run() {
//        ContainerExecutor.
        Object obj=ContainerSingleton.getInstance("com.gupaoedu.vip.singleton.pattern.RegsiterSingletonPattern.ContainerSingleton");
        System.out.println(Thread.currentThread().getName()+obj);
    }
}
