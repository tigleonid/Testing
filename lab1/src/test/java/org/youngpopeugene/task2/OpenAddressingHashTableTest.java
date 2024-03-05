package org.youngpopeugene.task2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class OpenAddressingHashTableTest {
    private OpenAddressingHashTable table;

    @BeforeEach
    public void setUp() {
        table = new OpenAddressingHashTable(5);
    }

    @Test
    public void testPut(){
        table.put(1);
        table.put(6);
        table.put(2);
        table.put(200);
        assertEquals("[200, 1, 6, 2, null]", table.toString());
    }

    @Test
    public void testGet(){
        var value = 1;
        table.put(value);
        var newValue = table.get(value);
        assertEquals(value, newValue);
    }

    @Test
    public void testDelete(){
        var value = 1;
        table.put(value);
        table.delete(value);
        var newValue = table.get(value);
        assertNull(newValue);
    }

    @Test
    public void testPutAfterDelete(){
        table.put(1);
        table.put(1);
        table.put(1);
        table.put(1);
        table.put(1);
        table.delete(1);
        table.put(5);
        assertEquals("[1, 5, 1, 1, 1]", table.toString());
    }

    @Test
    public void testGetAfterDelete(){
        var value = 1;
        table.put(value);
        table.put(value);
        table.put(value);
        table.put(value);
        table.put(value);
        table.delete(value);
        table.delete(value);
        table.delete(value);
        table.delete(value);
        var newValue = table.get(value);
        assertEquals(value, newValue);
    }

    @Test
    public void testResize(){
        table.put(2);
        table.put(4);
        table.put(6);
        table.put(8);
        table.put(9);
        table.put(10);
        table.put(12);
        assertEquals("[10, null, 2, 12, 4, null, 6, null, 8, 9]", table.toString());
    }

}
