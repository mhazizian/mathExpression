package ood.math_exp.expression;


public class ConstExp implements Expression {
    private double value;

    public ConstExp(double value) {
        this.value = value;
    }

    public Expression evaluateVariable(Variable v, double value) {
        return new ConstExp(this.value);
    }

    public double evaluate() {
        return this.value;
    }

    public Expression derivative(Variable v) {
        return new ConstExp(0);
    }
}
