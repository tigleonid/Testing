package org.youngpopeugene.task1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AsinTest {
    @ParameterizedTest
    @ValueSource(doubles = {0, 1, -1, 0.5, -0.5, 0.845, -0.845})
    void checkValidValues(double param){
        assertAll(
                () -> assertEquals(Math.asin(param), Asin.calc(param), 0.0001)
        );
    }

    @ParameterizedTest
    @ValueSource(doubles = {-2, 2})
    void checkInvalidValues(double param){
        assertAll(
                () -> assertEquals(Math.asin(param), Asin.calc(param), 0.0001)
        );
    }
}
