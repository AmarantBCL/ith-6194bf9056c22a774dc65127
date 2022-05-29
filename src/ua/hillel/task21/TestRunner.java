package ua.hillel.task21;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestRunner {
    public static void start(Class<?> testClass) {
        try {
            List<Method> beforeMethods = Arrays.stream(testClass.getDeclaredMethods())
                    .filter(m -> m.isAnnotationPresent(BeforeSuite.class))
                    .collect(Collectors.toList());
            if (beforeMethods.size() > 1) throw new WrongSuiteCountException(testClass.getName() + " has more than one @BeforeSuite method");
            List<Method> afterMethods = Arrays.stream(testClass.getDeclaredMethods())
                    .filter(m -> m.isAnnotationPresent(AfterSuite.class))
                    .collect(Collectors.toList());
            if (afterMethods.size() > 1) throw new WrongSuiteCountException(testClass.getName() + " has more than one @AfterSuite method");
            List<Method> testMethods = Arrays.stream(testClass.getDeclaredMethods())
                    .filter(m -> m.isAnnotationPresent(Test.class))
                    .sorted(Comparator.comparingInt(m -> m.getAnnotation(Test.class).priority()))
                    .collect(Collectors.toList());
            Object instance = testClass.getConstructor().newInstance();
            if (beforeMethods.size() == 1) {
                beforeMethods.get(0).invoke(instance);
            }
            for (Method method : testMethods) {
                method.invoke(instance);
            }
            if (afterMethods.size() == 1) {
                afterMethods.get(0).invoke(instance);
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException("Something went wrong with tests");
        }
    }
}
