package org.itmo.systems;

import org.itmo.exceptions.MathException;
import org.itmo.functions.AbstractFunction;
import org.itmo.functions.FirstFunction;
import org.itmo.functions.SecondFunction;
import org.itmo.functions.logarithmic.Ln;
import org.itmo.functions.logarithmic.Log;
import org.itmo.functions.trigonometric.Cos;
import org.itmo.functions.trigonometric.Cot;

public class FunctionsSystem extends AbstractFunction {
    private final FirstFunction firstFunction;
    private final SecondFunction secondFunction;

    public FunctionsSystem() {
        this.firstFunction = new FirstFunction();
        this.secondFunction = new SecondFunction();
    }

    public FunctionsSystem(Cos cos, Cot cot, Ln ln, Log log2, Log log3) {
        this.firstFunction = new FirstFunction(cos, cot);
        this.secondFunction = new SecondFunction(ln, log2, log3);
    }

    public FunctionsSystem(FirstFunction firstFunction, SecondFunction secondFunction) {
        this.firstFunction = firstFunction;
        this.secondFunction = secondFunction;
    }
    public double calculate(double x, double eps) throws MathException {
        if (x <= 0) {
            return firstFunction.calculate(x, eps);
        } else {
            return secondFunction.calculate(x, eps);
        }
    }
}
