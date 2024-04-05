package org.itmo.functions;

import org.itmo.exceptions.MathException;
import org.itmo.functions.trigonometric.Cos;
import org.itmo.functions.trigonometric.Cot;

public class FirstFunction extends AbstractFunction {
    private final Cos cos;
    private final Cot cot;

    public FirstFunction() {
        this.cos = new Cos();
        this.cot = new Cot();
    }
    public FirstFunction(Cos cos, Cot cot) {
        this.cos = cos;
        this.cot = cot;
    }
    public double calculate(double x, double eps) throws MathException {
        double cosX = cos.calculate(x, eps);
        double cotX = cot.calculate(x, eps);

        if (Math.abs(cotX) < eps) {
//            throw new MathException("FirstFunction: cot(x) must not be equal to 0");
            return Double.NaN;
        }

        return (((cosX + cotX) / cotX) * cotX);
    }
}