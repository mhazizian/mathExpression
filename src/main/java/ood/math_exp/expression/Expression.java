package ood.math_exp.expression;

public interface Expression {
    Expression evaluateVariable(Variable v, double value);
    double evaluate();

    Expression derivative(Variable v);
}
