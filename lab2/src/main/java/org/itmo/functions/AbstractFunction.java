package org.itmo.functions;

import org.itmo.exceptions.MathException;

public abstract class AbstractFunction {
    public abstract double calculate(double x, double eps) throws MathException;
}
