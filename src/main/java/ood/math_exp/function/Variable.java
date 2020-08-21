package ood.math_exp.function;

import ood.math_exp.expression.Expression;

import java.util.List;

public class Variable extends Function{
    private final String name;

    public Variable(String name) {
        super();
        this.name = name;
    }

    public double apply(List<Expression> args) {
        throw new IllegalArgumentException("Variable " + this.name + " is NaN");
    }

}
