package ood.math_exp.function;

import ood.math_exp.expression.Expression;

import java.util.List;

public class ConstValue extends Function {
    private double value;

    public ConstValue(double value) {
        super();
        this.value = value;
    }

    public double apply(List<Expression> args) {
        return this.value;
    }

    public Function derived(Variable variable) {
        return new ConstValue(0);
    }


}
