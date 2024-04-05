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
    public Cot(Cos cos){
        this.sin = new Sin();
        this.cos = cos;
    }

    public double calculate(double x, double eps) throws MathException {
        double sinX = sin.calculate(x, eps);
        if (Math.abs(sinX) < eps) {
//            throw new MathException("cot(x): sin(x) must not be equal to 0");
            return Double.NaN;
        }
        double cosX = cos.calculate(x, eps);
        return cosX / sinX;
    }
}
