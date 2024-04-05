package org.itmo.util;

import org.itmo.exceptions.MathException;
import org.itmo.functions.AbstractFunction;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CsvWriter {

    public static void write(
            final String filename,
            final AbstractFunction function,
            final double from,
            final double to,
            final double step,
            final double eps)
            throws IOException {
        final Path path = Paths.get(filename);
        final File file = new File(path.toUri());
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        final PrintWriter printWriter = new PrintWriter(file);
        for (double x = from; x <= to; x+=step) {
            try {
                printWriter.println(Math.round(x * 100.0) / 100.0 + "," + function.calculate(x, eps));
            } catch (MathException e) {
                printWriter.println(Math.round(x * 100.0) / 100.0 + "," + "undefined");
            }
        }
        printWriter.close();
    }

}
