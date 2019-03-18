package com.gupaoedu.vip.singleton.pattern.RegsiterSingletonPattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class EnumSingletonPatternTest {


    public static void main(String[] args) {
        //正常第一种
      /*  EnumSingletonPattern esp = EnumSingletonPattern.getInstance();
        esp.setData(new Object());
        System.out.println("正常的调用枚举单例" + esp.getData());*/

        //第二种通过java的反射机制 是否会破坏单例 java底层直接抛出异常 不让通过这种形式去创建单例
        //java.lang.NoSuchMethodException: com.gupaoedu.vip.singleton.pattern.RegsiterSingletonPattern.EnumSingletonPattern.<init>()
       /* EnumSingletonPattern esp1 = null;
        try {
            Class<?> clazz = EnumSingletonPattern.class;
            Constructor constructor = clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            esp1 = (EnumSingletonPattern) constructor.newInstance();
            esp1.setData(new Object());
            System.out.println("通过java的反射机制生成的单例" + esp1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(esp1 == esp);*/

        //第三种 通过序列化这个 去实例化这个对象也是可以保证只有一个对象
        EnumSingletonPattern enumSingletonPattern=EnumSingletonPattern.getInstance();
        enumSingletonPattern.setData(new Object());
        System.out.println(enumSingletonPattern.getData());

        EnumSingletonPattern enumSingletonPattern2=null;
        FileOutputStream fos=null;
       try {
          fos=new FileOutputStream("EnumSingletonPattern.obj");
           ObjectOutputStream oos=new ObjectOutputStream(fos);
           oos.writeObject(enumSingletonPattern);
           fos.close();
           oos.flush();
           oos.close();

           FileInputStream fis=new FileInputStream("EnumSingletonPattern.obj");
           ObjectInputStream ois=new ObjectInputStream(fis);
           enumSingletonPattern2=(EnumSingletonPattern)ois.readObject();
           fis.close();
           ois.close();
           System.out.println(enumSingletonPattern2.getData());
       }catch (Exception e){
           e.printStackTrace();
       }
        System.out.println(enumSingletonPattern.getData()==enumSingletonPattern2.getData());
    }
}
