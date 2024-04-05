package org.itmo.functions.trigonometric;

import org.itmo.functions.AbstractFunction;

public class Cos extends AbstractFunction {
    private final Sin sin;

    public Cos() {
        this.sin = new Sin();
    }

    public double calculate(double x, double eps) {
        return sin.calculate(Math.PI / 2 - x, eps);
    }
}
