package org.itmo;

import org.itmo.exceptions.MathException;
import org.itmo.functions.logarithmic.Log;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogTest {
    private final double eps = 0.0001;
    private final double accuracy = 0.0001;

    @ParameterizedTest(name = "positiveBase")
    @ValueSource(ints = {2, 3, 10})
    public void log_positiveBase(int base) throws MathException {
        Log log = new Log(base);
        assertEquals(Math.log(0.5) / Math.log(base), log.calculate(0.5, eps), accuracy);
    }

    @ParameterizedTest(name = "negativeBase")
    @ValueSource(ints = {-2, -3, -10})
    public void log_negativeBase(int base) {
        Log log = new Log(base);
        assertThrows(MathException.class, () -> log.calculate(0.5, eps));
    }
}
