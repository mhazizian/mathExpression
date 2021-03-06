package ood.math_exp.function;

import ood.math_exp.expression.Expression;
import ood.math_exp.expression.Variable;

import java.util.List;

public abstract class Function {
    private final String name;

    public Function(String name) {
        if (!isValidFunctionName(name)) {
            throw new IllegalArgumentException("function name(" + name + ") is invalid");
        }
        this.name = name;
    }

    public Function() {
        this(null);
    }

    public String getName() {
        return name;
    }

    public abstract double apply(List<Expression> args);
    public abstract Expression derivative(Variable variable, List<Expression> args);

    private static boolean isValidFunctionName(final String name) {
        return true;
    }
}