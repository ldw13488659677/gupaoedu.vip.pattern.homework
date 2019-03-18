package com.gupaoedu.vip.singleton.pattern.lazysingletonpattern;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.Serializable;

/*
* 通过序列化单例对象  讲对象存储到本地磁盘  然后再从本地磁盘将对象读取出来 这样的话 就破坏了单例
*
* 在从磁盘中读取 一个单例对象的时候  会检查 这个单例对象中是否存在readResolve()这个方法  如果没有怎么会去创建一个新的
* 对象  如果有  则会调用被读取类中的readResolve(方法)
*
* */
public class SeriableSingleton implements Serializable {

    private  static final  SeriableSingleton INSTANCE=new SeriableSingleton();

    private  SeriableSingleton(){}

    public  static  SeriableSingleton getInstance(){
        return  INSTANCE;
    }
    public Object readResolve(){
        return  INSTANCE;
    }
}
