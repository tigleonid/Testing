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
        String ultimate_path =
                "C:/Users/79777/IdeaProjects/SoftwareTesting/lab2/csv/";
//                "csv/";

        Cos cos = new Cos();
        CsvWriter.write(
                ultimate_path+"cos.csv",
                cos,
                -2,
                1,
                0.1,
                1E-12);

        Sin sin = new Sin();
        CsvWriter.write(
                ultimate_path+"sin.csv",
                sin,
                -2,
                1,
                0.1,
                1E-12);

        Cot cot = new Cot();
        CsvWriter.write(
                ultimate_path+"cot.csv",
                cot,
                -2,
                1,
                0.1,
                1E-12);

        Ln ln = new Ln();
        CsvWriter.write(
                ultimate_path+"ln.csv",
                ln,
                0.1,
                20,
                0.1,
                1E-12);

        Log log2 = new Log(2);
        CsvWriter.write(
                ultimate_path+"log2.csv",
                log2,
                0.1,
                2.5,
                0.1,
                1E-12);

        Log log3 = new Log(3);
        CsvWriter.write(
                ultimate_path+"log3.csv",
                log3,
                0.1,
                2.5,
                0.1,
                1E-12);



        FirstFunction firstFunction = new FirstFunction();
        CsvWriter.write(
                ultimate_path+"function1.csv",
                firstFunction,
                -2,
                0.5,
                0.1,
                1E-12);

        SecondFunction secondFunction = new SecondFunction();
        CsvWriter.write(
                ultimate_path+"function2.csv",
                secondFunction,
                0.1,
                2,
                0.1,
                1E-12);
        FunctionsSystem functionsSystem = new FunctionsSystem();
        CsvWriter.write(
                ultimate_path+"system.csv",
                functionsSystem,
                -2,
                2,
                0.1,
                1E-12);

    }
}
