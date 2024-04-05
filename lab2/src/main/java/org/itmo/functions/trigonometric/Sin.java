package org.itmo.functions.trigonometric;

import org.itmo.functions.AbstractFunction;

public class Sin extends AbstractFunction {
    public double calculate(double x, double eps) {
        x = x % (2 * Math.PI);

        double term = x;
        double sum = term;

        int n = 1;

        while (Math.abs(term) > eps) {
            term = -term * x * x / ((2 * n) * (2 * n + 1));
            sum += term;
            n++;
        }

        return sum;
    }
}
