package main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class QueryGroup {
    public static boolean query() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String tipMessage = "Are you a group? (Y/N)";
        String errorMessage = "Please enter Y or N.";
        Method method = QueryGroup.class.getMethod("query");
        InputNormalization.regularize(method, "boolean", tipMessage, errorMessage);
        return InputNormalization.bool;
    }
}
