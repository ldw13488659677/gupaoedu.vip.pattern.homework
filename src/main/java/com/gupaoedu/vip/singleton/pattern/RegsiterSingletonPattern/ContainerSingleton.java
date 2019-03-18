package com.gupaoedu.vip.singleton.pattern.RegsiterSingletonPattern;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
* spring中常用的注册式单例模式
* */
public class ContainerSingleton {

    private ContainerSingleton() {
    }

    private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    public static Object getInstance(String clazzNmae) {
            synchronized (ioc) {
                Object obj=null;
                if (!ioc.containsKey(clazzNmae)) {
                    try {
                        Class clazz = Class.forName(clazzNmae);
                        obj = clazz.newInstance();
                        ioc.put(clazzNmae,obj);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    return  obj;
                }
                else {
                    return ioc.get(clazzNmae);
                }
            }
    }

}
