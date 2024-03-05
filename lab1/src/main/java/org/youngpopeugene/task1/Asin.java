package org.youngpopeugene.task1;

public class Asin {
    public static double calc(double x) {
        if (x < -1 || x > 1){
            return Double.NaN;
        }

        double n = 1;
        double a = x;
        double s = 1;
        double r = x;

        while (Math.abs(s) > 1.0E-12) {
            a = x * x * (a * (2 * n - 1)) / (2 * n);
            s = a / (2 * n + 1);
            r = r + s;
            n++;
        }
        return r;
    }
}
