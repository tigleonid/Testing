package org.youngpopeugene;

import org.youngpopeugene.task1.Asin;
import org.youngpopeugene.task2.OpenAddressingHashTable;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        OpenAddressingHashTable table = new OpenAddressingHashTable(5);
        table.put(2);
        table.put(4);
        table.put(6);
        table.put(8);
        table.put(9);
        table.put(10);
        table.put(12);
        System.out.println(table);
    }
}
