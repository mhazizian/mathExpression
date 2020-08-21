package ood.math_exp.function;

public class Variable {
    private final String name;
    private double value;


    public Variable(String name) {
        this.name = name;
    }


    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
