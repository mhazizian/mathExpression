package ood.math_exp.expression;

import ood.math_exp.function.Function;
import ood.math_exp.function.Variable;

import java.util.Arrays;
import java.util.List;

public class Expression {
    protected Function function;
    private List<Expression> inputArgs;

//    public Expression(Function function, List<Expression> args) {
//        this.function = function;
//        this.inputArgs = args;
//    }

    public Expression(Function function, Expression... args) {
        this.function = function;
        if (args != null)
            this.inputArgs = Arrays.asList(args);
    }

    public Expression(String functionName, List<Expression> args) {
        // TODO add for custom functions.
    }

    public void evaluateVariable(Variable v, double value) {
        for (Expression inputArg : inputArgs) {
            inputArg.evaluateVariable(v, value);
        }
    }

    public double evaluate() {
        return this.function.apply(this.inputArgs);
    }
}
