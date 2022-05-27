package ua.hillel.task21;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {
    public static void start(Class testClass) {
        Method[] methods = testClass.getDeclaredMethods();
        Method beforeMethod = null;
        Method afterMethod = null;
        int before = -1;
        int after = -1;
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].isAnnotationPresent(BeforeSuite.class)) {
                if (beforeMethod != null) {
                    throw new WrongSuiteCountException(testClass.getName() + " has more than one @BeforeSuite method");
                }
                beforeMethod = methods[i];
                before = i;
            }
            if (methods[i].isAnnotationPresent(AfterSuite.class)) {
                if (afterMethod != null) {
                    throw new WrongSuiteCountException(testClass.getName() + " has more than one @BeforeSuite method");
                }
                afterMethod = methods[i];
                after = i;
            }
        }
        if (before != -1) {
            methods[before] = null;
        }
        if (after != -1) {
            methods[after] = null;
        }
        //TODO Refactor loops & add priority to methods
        try {
            if (beforeMethod != null) {
                beforeMethod.invoke(testClass.newInstance());
            }
            for (Method method : methods) {
                if (method != null) {
                    method.invoke(testClass.newInstance());
                }
            }
            if (afterMethod != null) {
                afterMethod.invoke(testClass.newInstance());
            }
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
