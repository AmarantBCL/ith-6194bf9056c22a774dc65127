package ua.hillel.task10;

public class Field {
    public static final char EMPTY_SYMBOL = '-';

    private final char[][] data = {
            {EMPTY_SYMBOL, EMPTY_SYMBOL, EMPTY_SYMBOL},
            {EMPTY_SYMBOL, EMPTY_SYMBOL, EMPTY_SYMBOL},
            {EMPTY_SYMBOL, EMPTY_SYMBOL, EMPTY_SYMBOL}
    };

    public char[][] getData() {
        return data;
    }

    public char getValue(int h, int v) {
        return data[h][v];
    }

    public void setValue(int h, int v, char ch) {
        data[h][v] = ch;
    }
}
