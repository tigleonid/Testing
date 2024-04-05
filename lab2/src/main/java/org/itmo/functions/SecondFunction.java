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

    public SecondFunction(Ln ln, Log log2, Log log3) {
        this.ln = ln;
        this.log2 = log2;
        this.log3 = log3;
    }

    public double calculate(double x, double eps) throws MathException {
        double lnX = ln.calculate(x, eps);
        double log2X = log2.calculate(x, eps);
        double log3X = log3.calculate(x,eps);

        return ((Math.pow(((lnX - log2X) - lnX), 3) - log2X) * log3X);
    }


    public static void main(String[] args) throws MathException {
        double x = 0.1;
        double eps = 1E-12;
        Ln ln = new Ln();
        Log log2 = new Log(2);
        Log log3 = new Log(3);

        double lnX = ln.calculate(x, eps);
        double log2X = log2.calculate(x, eps);
        double log3X = log3.calculate(x,eps);

        System.out.println(((Math.pow(((lnX - log2X) - lnX), 3) - log2X) * log3X));
    }
}
