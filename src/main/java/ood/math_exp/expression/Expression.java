package ood.math_exp.expression;

public interface Expression {
    public Expression evaluateVariable(Variable v, double value);
    public double evaluate();
}
