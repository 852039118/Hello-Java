package com.warren.reflection;

//类加载器
public class Test06 {
    public static void main(String[] args) {

        //获取系统类的加载器 sun.misc.Launcher$AppClassLoader@18b4aac2 最常用
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的父类加载器 ---> 扩展类加载器 sun.misc.Launcher$ExtClassLoader@74a14482
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取扩展类加载器的父类加载器 ---> 根加载器（C/C++） null Java平台核心库，无法直接获取
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);


        //测试当前类是哪个加载器加载的 sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoader classLoader = Test06.class.getClassLoader();
        System.out.println(classLoader);

        //测试JDK内置的类是谁加载的 null
        ClassLoader classLoader1 = Object.class.getClassLoader();
        System.out.println(classLoader1);

        //双亲委派机制：会一层一层的往上找 ，自定义类加载器 -> 系统类加载 -> 扩展类加载器 -> 根加载器
            //如果找到了，就不会用你的自定义类加载器

        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
        /*
        * E:\apache-jdk8\Java\jdk1.8.0_231\jre\lib\charsets.jar;
        * E:\apache-jdk8\Java\jdk1.8.0_231\jre\lib\deploy.jar;
        * E:\apache-jdk8\Java\jdk1.8.0_231\jre\lib\ext\access-bridge-64.jar;
        * E:\apache-jdk8\Java\jdk1.8.0_231\jre\lib\ext\cldrdata.jar;
        * E:\apache-jdk8\Java\jdk1.8.0_231\jre\lib\ext\dnsns.jar;
        * E:\apache-jdk8\Java\jdk1.8.0_231\jre\lib\ext\jaccess.jar;
        * E:\apache-jdk8\Java\jdk1.8.0_231\jre\lib\ext\jfxrt.jar;
        * E:\apache-jdk8\Java\jdk1.8.0_231\jre\lib\ext\localedata.jar;
        * E:\apache-jdk8\Java\jdk1.8.0_231\jre\lib\ext\nashorn.jar;
        * E:\apache-jdk8\Java\jdk1.8.0_231\jre\lib\ext\sunec.jar;
        * E:\apache-jdk8\Java\jdk1.8.0_231\jre\lib\ext\sunjce_provider.jar;
        * E:\apache-jdk8\Java\jdk1.8.0_231\jre\lib\ext\sunmscapi.jar;
        * E:\apache-jdk8\Java\jdk1.8.0_231\jre\lib\ext\sunpkcs11.jar;
        * E:\apache-jdk8\Java\jdk1.8.0_231\jre\lib\ext\zipfs.jar;
        * E:\apache-jdk8\Java\jdk1.8.0_231\jre\lib\javaws.jar;
        * E:\apache-jdk8\Java\jdk1.8.0_231\jre\lib\jce.jar;
        * E:\apache-jdk8\Java\jdk1.8.0_231\jre\lib\jfr.jar;
        * E:\apache-jdk8\Java\jdk1.8.0_231\jre\lib\jfxswt.jar;
        * E:\apache-jdk8\Java\jdk1.8.0_231\jre\lib\jsse.jar;
        * E:\apache-jdk8\Java\jdk1.8.0_231\jre\lib\management-agent.jar;
        * E:\apache-jdk8\Java\jdk1.8.0_231\jre\lib\plugin.jar;
        * E:\apache-jdk8\Java\jdk1.8.0_231\jre\lib\resources.jar;
        * E:\apache-jdk8\Java\jdk1.8.0_231\jre\lib\rt.jar;
        * E:\java_study\out\production\java_study;
        * E:\java_study\src\com\lib\commons-io-2.6.jar;
        * E:\IntelliJ IDEA 2019.2.3\lib\idea_rt.jar

         * */
    }
}
