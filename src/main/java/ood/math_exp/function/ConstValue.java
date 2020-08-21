package ood.math_exp.function;

import ood.math_exp.Expression;

import java.util.List;

public class ConstValue extends Function {
    private double value;

    public ConstValue(int value) {
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
