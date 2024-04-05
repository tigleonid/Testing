package org.itmo;


import org.itmo.exceptions.MathException;
import org.itmo.functions.logarithmic.Ln;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LnTest {

    private static Ln ln;
    private final double eps = 0.0001;
    private final double accuracy = 0.0001;

    @BeforeAll
    public static void init() {
        ln = new Ln();
    }

    @ParameterizedTest(name = "positiveSmall")
    @ValueSource(doubles = {0.1, 0.3, 0.7, 1})
    public void ln_positiveSmall(double x) throws MathException {
        assertEquals(Math.log(x), ln.calculate(x, eps), accuracy);
    }

    @ParameterizedTest(name = "positiveBig")
    @ValueSource(doubles = {3, 5, 7, 10})
    public void ln_positiveBig(double x) throws MathException {
        assertEquals(Math.log(x), ln.calculate(x, eps), accuracy);
    }

    @ParameterizedTest(name = "negative")
    @ValueSource(doubles = {-0.1, -0.5, -1, -3})
    public void ln_negative(double x) {
        assertThrows(MathException.class, () -> ln.calculate(x, eps));
    }

}
