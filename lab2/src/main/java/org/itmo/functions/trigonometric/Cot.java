package org.itmo.functions.trigonometric;

import org.itmo.exceptions.MathException;
import org.itmo.functions.AbstractFunction;

public class Cot extends AbstractFunction {

    private final Sin sin;
    private final Cos cos;

    public Cot() {
        this.sin = new Sin();
        this.cos = new Cos();
    }

    public double calculate(double x, double eps) throws MathException {
        double sinX = sin.calculate(x, eps);
        if (Math.abs(sinX) < eps) {
            throw new MathException("cot(x): sin(x) must not be equal to 0");
        }
        double cosX = cos.calculate(x, eps);
        return cosX / sinX;
    }
}
