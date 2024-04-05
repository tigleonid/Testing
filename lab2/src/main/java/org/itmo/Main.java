package org.itmo;

import org.itmo.functions.FirstFunction;
import org.itmo.functions.SecondFunction;
import org.itmo.functions.logarithmic.Ln;
import org.itmo.functions.logarithmic.Log;
import org.itmo.functions.trigonometric.Cos;
import org.itmo.functions.trigonometric.Cot;
import org.itmo.functions.trigonometric.Sin;
import org.itmo.systems.FunctionsSystem;
import org.itmo.util.CsvWriter;

import java.io.IOException;

public class Main
{
    public static void main( String[] args ) throws IOException {
        Cos cos = new Cos();
        CsvWriter.write(
                "csv/cos.csv",
                cos,
                -1,
                1,
                0.1,
                1E-12);
        Sin sin = new Sin();
        CsvWriter.write(
                "csv/sin.csv",
                sin,
                -1,
                1,
                0.1,
                1E-12);
        Cot cot = new Cot();
        CsvWriter.write(
                "csv/cot.csv",
                cot,
                -1,
                1,
                0.1,
                1E-12);
        Ln ln = new Ln();
        CsvWriter.write(
                "csv/ln.csv",
                ln,
                1,
                20,
                0.1,
                1E-12);
        Log log2 = new Log(2);
        CsvWriter.write(
                "csv/log2.csv",
                log2,
                1,
                20,
                0.1,
                1E-12);
        Log log3 = new Log(3);
        CsvWriter.write(
                "csv/log3.csv",
                log3,
                1,
                20,
                0.1,
                1E-12);
        FirstFunction firstFunction = new FirstFunction();
        CsvWriter.write(
                "csv/function1.csv",
                firstFunction,
                -2,
                0,
                0.1,
                1E-12);
        SecondFunction secondFunction = new SecondFunction();
        CsvWriter.write(
                "csv/function2.csv",
                secondFunction,
                0,
                2,
                0.1,
                1E-12);
        FunctionsSystem functionsSystem = new FunctionsSystem();
        CsvWriter.write(
                "csv/system.csv",
                functionsSystem,
                -2,
                2,
                0.1,
                1E-6);

    }
}
