package org.itmo;

import org.itmo.functions.trigonometric.Cos;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CosTest {

    private static Cos cos;
    private final double eps = 0.0001;
    private final double accuracy = 0.0001;

    @BeforeAll
    public static void init() {
        cos = new Cos();
    }

    @ParameterizedTest(name = "piFactor")
    @ValueSource(doubles = {-2 * PI, -PI, -0.5 * PI, 0.5 * PI, PI, 2 * PI})
    public void cos_piFactor(double x) {
        assertEquals(Math.cos(x), cos.calculate(x, eps), accuracy);
    }


    @ParameterizedTest(name = "real")
    @ValueSource(doubles = {0.5, 0.75, 1, 1.5, 2, 2.5})
    public void cos_real(double x) {
        assertEquals(Math.cos(x), cos.calculate(x, eps), accuracy);
    }


    @ParameterizedTest(name = "closeToZero")
    @ValueSource(doubles = {0.001, 0.01, 0.1, 0})
    public void cos_closeToZero(double x) {
        assertEquals(Math.cos(x), cos.calculate(x, eps), accuracy);
    }

}
