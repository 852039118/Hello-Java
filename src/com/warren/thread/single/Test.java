package com.warren.thread.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws Exception {
        test3();
    }

    static void test3() throws Exception {
        for (int i = 1; i <= 10; i++) {
            // 多线程下访问也不会出现问题
            new Thread(()->{
                EnumSingle instance = EnumSingle.getInstance();
                instance.setNum(instance.getNum());
                System.out.println(instance.getNum());
            }).start();
        }

        // 尝试用反射破解
        Class<EnumSingle> enumSingle = EnumSingle.class;
        // java.lang.NoSuchMethodException
//        Constructor<EnumSingle> constructor = enumSingle.getDeclaredConstructor(null);

        // java.lang.IllegalArgumentException: Cannot reflectively create enum objects
        Constructor<EnumSingle> constructor = enumSingle.getDeclaredConstructor(String.class,int.class);
        constructor.setAccessible(true);

        EnumSingle instance = constructor.newInstance();
        System.out.println(instance.getNum());
        // 无法破解枚举单例

    }

    // 懒汉式单例，可用反射破解
    static void test2() throws InterruptedException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<LazyMan> constructor = LazyMan.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);

        LazyMan lazyMan = constructor.newInstance();
        LazyMan lazyMan2 = constructor.newInstance();

        System.out.println(lazyMan.hashCode());
        System.out.println(lazyMan2.hashCode());
    }

    // 饿汉式单例测试,可用反射破解
    static void test1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        new Thread(()->{ System.out.println(HungryMan.getInstance().hashCode()); }).start();
        new Thread(()->{ System.out.println(HungryMan.getInstance().hashCode()); }).start();

        // 利用反射可以使私有化构造器不私有
        Constructor<HungryMan> constructor = HungryMan.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        // 利用反射创建对象
        HungryMan hungryMan = constructor.newInstance();
        HungryMan hungryMan2 = constructor.newInstance();

        System.out.println(hungryMan.hashCode());   // 1023892928
        System.out.println(hungryMan2.hashCode());  // 558638686
    }


}
