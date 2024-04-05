package org.itmo;

import org.itmo.exceptions.MathException;
import org.itmo.functions.trigonometric.Cot;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CotTest {
    private static Cot cot;
    private final double eps = 0.0001;
    private final double accuracy = 0.0001;

    @BeforeAll
    public static void init() {
        cot = new Cot();
    }

    @ParameterizedTest(name = "integerPiFactor")
    @ValueSource(doubles = {-2 * PI, -PI, 0, PI, 2 * PI})
    public void cot_integerPiFactor(double x) {
        assertThrows(MathException.class, () -> cot.calculate(x, eps));
    }


    @ParameterizedTest(name = "realPiFactor")
    @ValueSource(doubles = {-1.5 * PI, -0.5 * PI, -0.25 * PI, 0.25 * PI, 0.5 * PI, 1.5 * PI})
    public void cot_realPiFactor(double x) throws MathException {
        assertEquals(1 / Math.tan(x), cot.calculate(x, eps), accuracy);
    }


    @ParameterizedTest(name = "closeToZero")
    @ValueSource(doubles = {0.001, 0.01, 0.1})
    public void cot_closeToZero(double x) throws MathException {
        assertEquals(1 / Math.tan(x), cot.calculate(x, eps), accuracy);
    }
}
