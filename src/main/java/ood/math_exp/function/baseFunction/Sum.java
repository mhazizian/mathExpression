package ood.math_exp.function.baseFunction;

import ood.math_exp.Expression;
import ood.math_exp.function.Variable;
import ood.math_exp.function.Function;

import java.util.List;

public class Sum extends Function {

    public Sum() {
        super("sum");
    }

    public double apply(List<Expression> args) {
        double result = 0;
        for (Expression exp : args) {
            result += exp.evaluate();
        }
        return result;
    }


    public Function derived(Variable variable) {
        return null;
    }
}
