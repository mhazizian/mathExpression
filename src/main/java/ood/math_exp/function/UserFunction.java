package ood.math_exp.function;

import java.util.HashMap;
import java.util.Map;

public class UserFunction {
    private static Map<String, Function> userFunctions = new HashMap<String, Function>();

    public Function getFunction(String name) {
        if (userFunctions == null)
            throw new IllegalStateException("no function added yet.");
        return userFunctions.get(name);

    }
    public void addFunction(String name, Function function) {
        if (userFunctions == null)
            userFunctions = new HashMap<String, Function>();

        if (userFunctions.containsKey(name))
            throw new IllegalArgumentException("function name is already in use");

        userFunctions.put(name, function);
    }
}