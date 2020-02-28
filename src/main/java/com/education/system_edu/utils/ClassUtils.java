package com.education.system_edu.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

public class ClassUtils<T> {
    /**
     * 创建时添加用户Code和时间信息
     *
     * @param entry
     * @return
     */
    public T addUserCreateUseInfo(T entry, String code) {
        try {
            Class<?> aClass = entry.getClass();
            //获取所有属性
            Field[] field = aClass.getDeclaredFields();

            //遍历最后四个
            for (int i = field.length - 1; i >= field.length - 4; i--) {

                //设置可以访问私有变量
                field[i].setAccessible(true);
                String name = field[i].getName();
                name = StringUtils.capitalized(name);
                //整合出需要的方法
                if (name.contains("Date")) {
                    Method m = aClass.getMethod("set"+name,Date.class);
                    //执行方法
                    m.invoke(entry,new Date());
                }
                if (name.contains("By")) {
                    Method m = aClass.getMethod("set"+name,String.class);
                    //执行方法
                    m.invoke(entry,code);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entry;
    }

    public T addUserUpdateUseInfo(T entry,String code) {
        try {
            Class<?> aClass = entry.getClass();
            //获取所有属性
            Field[] field = aClass.getDeclaredFields();

            //遍历最后四个
            for (int i = field.length - 1; i >= field.length - 4; i--) {

                //设置可以访问私有变量
                field[i].setAccessible(true);
                String name = field[i].getName();
                name = StringUtils.capitalized(name);
                //整合出需要的方法
                if (name.contains("UpdateDate")) {
                    Method m = aClass.getMethod("set"+name,Date.class);
                    //执行方法
                    m.invoke(entry,new Date());
                }
                if (name.contains("UpdateBy")) {
                    Method m = aClass.getMethod("set"+name,String.class);
                    //执行方法
                    m.invoke(entry,code);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entry;
    }
}
