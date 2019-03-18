package com.gupaoedu.vip.singleton.pattern;

import com.gupaoedu.vip.singleton.pattern.hungrysingletonpattern.HungryPattern;
import com.gupaoedu.vip.singleton.pattern.lazysingletonpattern.LazyInnerClassSingleton;
import com.gupaoedu.vip.singleton.pattern.lazysingletonpattern.LazySingletonPattern;
import com.gupaoedu.vip.singleton.pattern.lazysingletonpattern.SeriableSingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class SingletonPatternTest {

    public static void main(String[] args) {
        /*
        * 恶汉模式测试
        *
        HungryPattern hp=HungryPattern.getInstance();
        System.out.println(hp);
       */

       /* Thread t0=new Thread(new ThreadExecutorTest());
        Thread t1=new Thread(new ThreadExecutorTest());
        t0.start();
        t1.start();*/

        //--------------------------------------
        /*LazySingletonPattern lsp=LazySingletonPattern.getInstance();
        System.out.println(lsp);
         Thread t0=new Thread(new ThreadExecutorTest());
         Thread t1=new Thread(new ThreadExecutorTest());
        t0.start();
        t1.start();*/


//        Object object=Class.forName("com.gupaoedu.vip.singleton.pattern.lazysingletonpattern.LazyInnerClassSingleton");
       /* try {
            //通过java的反射机制去破坏  单例  构造出两个不同的视力对象
            Class<?> clzz=LazyInnerClassSingleton.class;
            Constructor constructor=clzz.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            Object o=constructor.newInstance();
            System.out.println((LazyInnerClassSingleton)o);
            LazyInnerClassSingleton lazyInnerClassSingleton=LazyInnerClassSingleton.getInstance();
            System.out.println(lazyInnerClassSingleton);
        }catch (Exception e){
            e.printStackTrace();
        }*/
        SeriableSingleton s1=null;
        SeriableSingleton s2=SeriableSingleton.getInstance();
        FileOutputStream fos=null;
        try {
            fos=new FileOutputStream("seriableSingleton.obj");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            FileInputStream fis=new FileInputStream("seriableSingleton.obj");
            ObjectInputStream ois=new ObjectInputStream(fis);
            s1=(SeriableSingleton)ois.readObject();
            fis.close();
            ois.close();
            System.out.println("序列化之后的对象地址"+s1);
            System.out.println("序列化之前的对象地址"+s2);
            System.out.println(s1==s2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
