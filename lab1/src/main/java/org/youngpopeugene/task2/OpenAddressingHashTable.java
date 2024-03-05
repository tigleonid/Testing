package org.youngpopeugene.task2;

import java.util.Arrays;
import java.util.Objects;

public class OpenAddressingHashTable {
    private int length;
    private Element[] table;

    private static class Element {
        private Integer value;
        public Element(Integer value) {
            this.value = value;
        }
    }

    public OpenAddressingHashTable(int length) {
        this.length = length;
        this.table = new Element[length];
    }

    public void put(Integer value) {
        int index = hash(value);
        for (int i = 0; i < length; i++) {
            if (table[index] == null || table[index].value == null) {
                table[index] = new Element(value);
                return;
            }
            index = (index + 1) % length;
        }
        resize();
        put(value);
    }

    public Integer get(int value) {
        int index = hash(value);
        for (int i = 0; i < length; i++) {
            if (table[index] == null) {
                return null;
            }
            if (Objects.equals(table[index].value, value)) {
                return table[index].value;
            }
            index = (index + 1) % length;
        }
        return null;
    }

    public void delete(int value) {
        int index = hash(value);
        for (int i = 0; i < length; i++) {
            if (table[index] == null) {
                return;
            }
            if (Objects.equals(table[index].value, value)){
                table[index].value = null;
                return;
            }
            index = (index + 1) % length;
        }
    }

    private int hash(Integer value) {
        return value % length;
    }

    private void resize() {
        Element[] oldTable = table;
        length = oldTable.length * 2;
        table = new Element[length];
        for (Element element : oldTable) {
            if (element.value != null) {
                put(element.value);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        boolean first = true;

        for (Element element : table) {
            if (!first) {
                result.append(", ");
            }

            if (element == null) {
                result.append("null");
            } else {
                result.append(element.value == null ? "<deleted>" : element.value);
            }

            first = false;
        }

        result.append("]");
        return result.toString();
    }
}
