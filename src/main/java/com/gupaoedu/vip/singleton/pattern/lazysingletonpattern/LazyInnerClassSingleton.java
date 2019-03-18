package com.gupaoedu.vip.singleton.pattern.lazysingletonpattern;

/*
* 懒汉式单例（静态内部类的方式）
* 有点：
* 1：完美解决了 单例模式内存消耗问题
* 2：同时也兼顾synchronized性能问题
* 3：这种情况下 当调用者通过java的反射机制  去创建这个类的话  就会对这个单例造成破坏  就会创建出多个实例对象
* */
public class LazyInnerClassSingleton {

    private LazyInnerClassSingleton(){
        //3的解决办法是 在构造方法中去判断这个对象  如果已经实例化这个对象  则强制抛个异常出去
        //告诉调用者 不可以创建多个实例
        if (LazyHoder.LAZY!=null) {
          throw new RuntimeException("不允许创建多个实例");
        }

    }

    //关键字的含义  static 是为了 能够共享这个方法
    //final  是保证这个方法不会被重新或覆盖
    //当外部调用这个方法的时候  会先加载内部类  如果没有外部调用 则不加载这个内部类
    public  static final   LazyInnerClassSingleton getInstance(){
        return LazyHoder.LAZY;
    }
    //默认是不会加载这个内部类的
    private  static class LazyHoder{
     private static  final  LazyInnerClassSingleton LAZY=new LazyInnerClassSingleton();
    }
}
