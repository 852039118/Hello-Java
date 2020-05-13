package com.warren.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

//通过反射获取泛型
public class Test10 {

    public static void test01(Map<String,User> map, List<User> list){
    }

    public static Map<String,User> test02(){
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {

        Class test10Class = Test10.class;
        System.out.println("======getDeclaredMethod获取参数类型=====");
        Method method = test10Class.getDeclaredMethod("test01",Map.class,List.class);
        //获取泛型的参数类型
        Type[] genericParameterTypes = method.getGenericParameterTypes();

        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("#" + genericParameterType);
            //判断这个类型是不是参数化类型
            if (genericParameterType instanceof ParameterizedType){
                //如果是参数化类型就获取它的真实参数信息
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }

            }
        }

       System.out.println("======getGenericReturnType获取返回值类型=====");
       method = test10Class.getDeclaredMethod("test02",null);
        //获取泛型的参数类型
        Type genericReturnType = method.getGenericReturnType();

        //判断这个类型是不是参数化类型
        if (genericReturnType instanceof ParameterizedType){
            //如果是参数化类型就获取它的真实参数信息
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }

        }
    }
}
