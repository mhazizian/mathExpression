package ood.math_exp.expression;

public class Variable implements Expression {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    public Expression evaluateVariable(Variable v, double value) {
        if (v == this)
            return new ConstExp(value);
        else
            return this;
    }

    public double evaluate() {
        throw new IllegalArgumentException("Variable " + this.name + " is NaN");
    }
}
