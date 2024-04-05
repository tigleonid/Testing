package org.itmo.functions.logarithmic;

import org.itmo.exceptions.MathException;
import org.itmo.functions.AbstractFunction;

public class Log extends AbstractFunction {
    private final Ln ln;
    private final int base;

    public Log(int base) {
        this.ln = new Ln();
        this.base = base;
    }
    public Log(int base, Ln ln) {
        this.ln = ln;
        this.base = base;
    }

    public double calculate(double x, double eps) throws MathException {
        if (base <= 0 || base == 1) {
            throw new MathException("log(): base must be a positive number and not equal to 1");
        }
        if (x <= 0) {
            throw new MathException("log(): x must be a positive number");
        }
        return ln.calculate(x, eps) / ln.calculate(base, eps);
    }
}