package ru.gb.java3.lesson7;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
public class Main {
    public static void main(String[] args) throws Exception {
        Method bfMethod = null;
        Method aftMethod = null;
        Class clss = TestClass.class;
        Object obj = clss.getDeclaredConstructor().newInstance();
        ArrayList<Method> methodList = new ArrayList<>();
        for (Method item : clss.getDeclaredMethods()) {
            if (item.isAnnotationPresent(BeforeSuite.class)) {
                if (bfMethod == null) bfMethod = item;
                else throw new RuntimeException("@BeforeSuite больше одного");
            }
            if (item.isAnnotationPresent(Test.class)) {
                methodList.add(item);
            }
            if (item.isAnnotationPresent(AfterSuite.class)) {
                if (aftMethod == null) aftMethod = item;
                else throw new RuntimeException("@AfterSuite больше одного");
            }
            methodList.sort(new Comparator<Method>() {
                @Override
                public int compare(Method testFirst, Method testLast) {
                    return ((testFirst.getAnnotation(Test.class).priority())-(testLast.getAnnotation(Test.class).priority()));
                }
            });
        }
        if (bfMethod != null) bfMethod.invoke(obj, null);
        for (Method item : methodList) item.invoke(obj, null);
        if (aftMethod != null) aftMethod.invoke(obj, null);
    }
}
