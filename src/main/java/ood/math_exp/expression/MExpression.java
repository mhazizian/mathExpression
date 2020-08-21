package ood.math_exp.expression;

import ood.math_exp.function.Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MExpression implements Expression{
    private Function function;
    private List<Expression> inputArgs;

    public MExpression(Function function, List<Expression> args) {
        this.function = function;
        this.inputArgs = args;
    }

    public MExpression(Function function, Expression... args) {
        this.function = function;
        if (args != null)
            this.inputArgs = Arrays.asList(args);
    }

    public MExpression(String functionName, List<Expression> args) {
        // TODO add for custom functions.
    }

    public Expression evaluateVariable(Variable v, double value) {
        List<Expression> newArgs = new ArrayList<Expression>();

        for (Expression inputArg : inputArgs)
            newArgs.add(inputArg.evaluateVariable(v, value));

        return new MExpression(function, newArgs);
    }

    public double evaluate() {
        return this.function.apply(this.inputArgs);
    }

    public Expression derivative(Variable v) {
        return function.derivative(v, inputArgs);
    }
}
