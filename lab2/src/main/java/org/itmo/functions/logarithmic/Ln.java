package org.itmo.functions.logarithmic;

import org.itmo.exceptions.MathException;
import org.itmo.functions.AbstractFunction;

public class Ln extends AbstractFunction {
    public double calculate(double x, double eps) throws MathException {
        if (x <= 0) {
            throw new MathException("ln(): x must be a positive number");
        }

        int n = 1;
        double result = 0;
        double term = (x - 1)/(x + 1);
        double k = ((x - 1) * (x - 1))/((x + 1) * (x + 1));

        while(Math.abs(term) > eps / 1000) {
            result += term;
            term = term * k * (2 * n - 1) / (2 * n + 1);
            n++;
        }

        return result*2;
    }
}

