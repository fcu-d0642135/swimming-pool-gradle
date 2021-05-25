package main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class QueryAge {
    public static int query() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String tipMessage = "How old are you?";
        String errorMessage = "Please key in digital.";
        Method method = QueryAge.class.getMethod("query");
        InputNormalization.regularize(method, "int", tipMessage, errorMessage);
        return checkAge(InputNormalization.digital);
    }

    public static int checkAge(int age) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (age < 3) {
            System.out.println("Your age is too young.");
            query();
        } else if (age > 75) {
            System.out.println("Your age doesn't meet the requirements.");
            query();
        }
        return age;
    }
}
