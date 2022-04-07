package ua.hillel.task10.checking;

import ua.hillel.task10.field.Field;

public class DrawChecker implements Checker {
    private final Field field;

    public DrawChecker(Field field) {
        this.field = field;
    }

    public boolean check() {
        char[][] data = field.getData();
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] == Field.EMPTY_SYMBOL) {
                    count++;
                }
            }
        }
        return count <= 0;
    }
}
