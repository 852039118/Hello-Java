package com.warren.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解
public class Test03 {

    //注解可以显式赋值， 如果没有默认值，我们就必须给注解赋值
    @MyAnnotation2(name = "warren",age = 18)
    public void test03(){
    }

    @MyAnnotation3("只有参数名为value时才可以省略参数名的书写")
    public void test04(){

    }
}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    //注解的参数：参数类型 + 参数名() [default 默认值];
    String name() default "";

    int age();
    int id() default -1;    //如果默认值为-1，代表不存在

    String[] schools() default {"亡命之徒","纵贯线"};
}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    String value();
}
