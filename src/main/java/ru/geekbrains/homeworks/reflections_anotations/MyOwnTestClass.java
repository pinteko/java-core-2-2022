package ru.geekbrains.homeworks.reflections_anotations;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class MyOwnTestClass {

    private static final ArrayList<Method> listAnnotationMethods = new ArrayList<>();

    public static void main(String[] args) {
        MyClass brain = new MyClass();
        start(brain);
        for (Method testMethod : listAnnotationMethods) {
            try {
                testMethod.invoke(brain);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        for (String s : brain.getGeneralResult()) {
            System.out.println(s);
        }

    }

    public static <T> void start(T object) {
        if (!object.getClass().isAnnotationPresent(Check.class)) {
            throw new RuntimeException("Class not annotated with @Check");
        }

        Method[] methods = object.getClass().getDeclaredMethods();
        int before = 0;
        int after = 0;
        Method lastMethod = null;

        for (Method method : methods) {
            method.setAccessible(true);

            if (method.isAnnotationPresent(BeforeSuite.class)) {
                before += 1;
                listAnnotationMethods.add(0, method);
                if (before > 1) {
                    throw new RuntimeException("More than one @BeforeSuite");
                }
            }

            if (method.isAnnotationPresent(AfterSuite.class)) {
                after += 1;
                lastMethod = method;
                if (after > 1) {
                    throw new RuntimeException("More than one @AfterSuite");
                }
            }

            if (method.isAnnotationPresent(Test.class)) {
                if (listAnnotationMethods.isEmpty() ||
                        method.getAnnotation(Test.class).priority() > listAnnotationMethods.size()) {
                    listAnnotationMethods.add(method);
                } else {
                    listAnnotationMethods.add(method.getAnnotation(Test.class).priority(), method);
                }
            }
        }
        listAnnotationMethods.add(lastMethod);
    }
}
