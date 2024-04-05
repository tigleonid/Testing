package org.itmo.functions;

import org.itmo.exceptions.MathException;
import org.itmo.functions.logarithmic.Ln;
import org.itmo.functions.logarithmic.Log;

public class SecondFunction extends AbstractFunction {
    private final Ln ln;
    private final Log log2;
    private final Log log3;

    public SecondFunction() {
        this.ln = new Ln();
        this.log2 = new Log(2);
        this.log3 = new Log(3);
    }

    public double calculate(double x, double eps) throws MathException {
        double lnX = ln.calculate(x, eps);
        double log2X = log2.calculate(x, eps);
        double log3X = log3.calculate(x,eps);

        return ((Math.pow(((lnX - log2X) - lnX), 3) - log2X) * log3X);
    }
}
