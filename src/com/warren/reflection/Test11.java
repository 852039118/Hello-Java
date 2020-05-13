package com.warren.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

//练习反射操作注解

public class Test11 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.warren.reflection.Student2");
        //通过反射获取注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        //获得指定注解的value值
        TableWarren tableWarren = (TableWarren) c1.getAnnotation(TableWarren.class);//强转为注解
        System.out.println(tableWarren.value());

        //获得指定字段的注解
        Field f = c1.getDeclaredField("name");
        FieldWarren annotation = f.getAnnotation(FieldWarren.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }
}

@TableWarren("db_student")
class Student2{
    @FieldWarren(columnName = "db_id",type = "int",length = 10)
    private int id;
    @FieldWarren(columnName = "db_age",type = "int",length = 10)
    private int age;
    @FieldWarren(columnName = "db_name",type = "varchar",length = 14)
    private String name;

    public Student2() {
    }

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableWarren{
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldWarren{
    String columnName();
    String type();
    int length();
}