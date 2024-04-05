package org.itmo;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.itmo.exceptions.MathException;
import org.itmo.functions.AbstractFunction;
import org.itmo.functions.FirstFunction;
import org.itmo.functions.SecondFunction;
import org.itmo.functions.logarithmic.Ln;
import org.itmo.functions.logarithmic.Log;
import org.itmo.functions.trigonometric.Cos;
import org.itmo.functions.trigonometric.Cot;
import org.itmo.systems.FunctionsSystem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SystemTest {
    private final static String path = "/system.csv";
    private final static double eps = 1E-12;
    private final double accuracy = 0.0001;
    private static Cos cosMock;
    private static Cot cotMock;
    private static Log log2Mock;
    private static Log log3Mock;
    private static Ln lnMock;
    private static FirstFunction firstFunctionMock;
    private static SecondFunction secondFunctionMock;

    static <T extends AbstractFunction> T setMock(String path, Class<T> mockClass) {
        T mockInstance = Mockito.mock(mockClass);
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classloader.getResourceAsStream(path);
            assert inputStream != null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);
            for (CSVRecord record : records) {
                double input = Double.parseDouble(record.get(0));
                double output;
                if (record.get(1).equals("NaN"))
                    output = Double.NaN;

                else {
                    output = Double.parseDouble(record.get(1));
                }
                Mockito.when(mockInstance.calculate(input, eps)).thenReturn(output);
            }

        } catch (IOException e) {
            throw new RuntimeException("Не найден файл или не удалось его распарсить!");
        } catch (MathException e) {
            throw new RuntimeException(e);
        }
        return mockInstance;
    }

    @BeforeAll
    static void init() {
        cosMock = setMock("cos.csv", Cos.class);
        cotMock = setMock("cot.csv", Cot.class);
        log2Mock = setMock("log2.csv", Log.class);
        log3Mock = setMock("log3.csv", Log.class);
        lnMock = setMock("ln.csv", Ln.class);
        firstFunctionMock = setMock("function1.csv", FirstFunction.class);
        secondFunctionMock = setMock("function2.csv", SecondFunction.class);
    }



    //Operations
    @ParameterizedTest(name = "all operations mock test")
    @CsvFileSource(resources = path)
    void testOp(double x, double y) throws MathException {
        FunctionsSystem functionsSystem = new FunctionsSystem(cosMock, cotMock, lnMock, log2Mock, log3Mock);
        assertEquals(y, functionsSystem.calculate(x, eps), accuracy);
    }


    @ParameterizedTest(name = "cos mock test")
    @CsvFileSource(resources = path)
    void testCos(double x, double y) throws MathException {
        FunctionsSystem functionsSystem = new FunctionsSystem(cosMock, new Cot(cosMock), new Ln(), new Log(2), new Log(3));
        assertEquals(y, functionsSystem.calculate(x, eps), accuracy);
    }

    @ParameterizedTest(name = "cot mock test")
    @CsvFileSource(resources = path)
    void testCot(double x, double y) throws MathException {
        FunctionsSystem functionsSystem = new FunctionsSystem(new Cos(), cotMock, new Ln(), new Log(2), new Log(3));
        assertEquals(y, functionsSystem.calculate(x, eps), accuracy);
    }

    @ParameterizedTest(name = "ln mock test")
    @CsvFileSource(resources = path)
    void testLn(double x, double y) throws MathException {
        FunctionsSystem functionsSystem = new FunctionsSystem(new Cos(), new Cot(), lnMock, new Log(2, lnMock), new Log(3, lnMock));
        assertEquals(y, functionsSystem.calculate(x, eps), accuracy);
    }
    @ParameterizedTest(name = "log2 mock test")
    @CsvFileSource(resources = path)
    void testLog2(double x, double y) throws MathException {
        FunctionsSystem functionsSystem = new FunctionsSystem(new Cos(), new Cot(), new Ln(), log2Mock, new Log(3));
        assertEquals(y, functionsSystem.calculate(x, eps), accuracy);
    }
    @ParameterizedTest(name = "log3 mock test")
    @CsvFileSource(resources = path)
    void testLog3(double x, double y) throws MathException {
        FunctionsSystem functionsSystem = new FunctionsSystem(new Cos(), new Cot(), new Ln(), new Log(2), log3Mock);
        assertEquals(y, functionsSystem.calculate(x, eps), accuracy);
    }

    @ParameterizedTest(name = "no operation mock test")
    @CsvFileSource(resources = path)
    void testNoOpMock(double x, double y) throws MathException {
        FunctionsSystem functionsSystem = new FunctionsSystem(new Cos(), new Cot(), new Ln(), new Log(2), new Log(3));
        assertEquals(y, functionsSystem.calculate(x, eps), accuracy);
    }



    //Functions
    @ParameterizedTest(name = "all functions mock test")
    @CsvFileSource(resources = path)
    void testFun(double x, double y) throws MathException {
        FunctionsSystem functionsSystem = new FunctionsSystem(firstFunctionMock, secondFunctionMock);
        assertEquals(y, functionsSystem.calculate(x, eps), accuracy);
    }

    @ParameterizedTest(name = "first functions mock test")
    @CsvFileSource(resources = path)
    void testFun1(double x, double y) throws MathException {
        FunctionsSystem functionsSystem = new FunctionsSystem(firstFunctionMock, new SecondFunction());
        assertEquals(y, functionsSystem.calculate(x, eps), accuracy);
    }
    @ParameterizedTest(name = "second functions mock test")
    @CsvFileSource(resources = path)
    void testFun2(double x, double y) throws MathException {
        FunctionsSystem functionsSystem = new FunctionsSystem(new FirstFunction(), secondFunctionMock);
        assertEquals(y, functionsSystem.calculate(x, eps), accuracy);
    }

    @ParameterizedTest(name = "no functions mock test")
    @CsvFileSource(resources = path)
    void testNoFunMock(double x, double y) throws MathException {
        FunctionsSystem functionsSystem = new FunctionsSystem(new FirstFunction(), new SecondFunction());
        assertEquals(y, functionsSystem.calculate(x, eps), accuracy);
    }
}