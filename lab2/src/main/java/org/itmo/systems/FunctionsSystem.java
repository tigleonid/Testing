package org.itmo.systems;

import org.itmo.exceptions.MathException;
import org.itmo.functions.AbstractFunction;
import org.itmo.functions.FirstFunction;
import org.itmo.functions.SecondFunction;
import org.itmo.functions.logarithmic.Ln;
import org.itmo.functions.logarithmic.Log;
import org.itmo.functions.trigonometric.Cot;
import org.itmo.functions.trigonometric.Sin;

public class FunctionsSystem extends AbstractFunction {
    private final FirstFunction firstFunction;
    private final SecondFunction secondFunction;

    public FunctionsSystem() {
        this.firstFunction = new FirstFunction();
        this.secondFunction = new SecondFunction();
    }

    public double calculate(double x, double eps) throws MathException {
        if (x <= 0) {
            return firstFunction.calculate(x, eps);
        } else {
            return secondFunction.calculate(x, eps);
        }
    }
}
