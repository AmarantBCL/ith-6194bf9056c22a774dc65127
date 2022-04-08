package ua.hillel.task10;

public class WinChecker implements Checker {
    private static final char[] SYMBOLS = new char[]{'O', 'X'};
    private final Field field;
    private String winner;

    public String getWinner() {
        return winner;
    }

    public WinChecker(Field field) {
        this.field = field;
    }

    public boolean check() {
        char[][] data = field.getData();
        for (char symbol : SYMBOLS) {
            for (int i = 0; i < data.length; i++) {
                int horizontalMatches = 0;
                int verticalMatches = 0;
                for (int j = 0; j < data[i].length; j++) {
                    horizontalMatches += countLineMatches(i, j, symbol);
                    verticalMatches += countLineMatches(j, i, symbol);
                }
                if (isLineMatch(horizontalMatches, verticalMatches)) {
                    winner = String.valueOf(symbol);
                    return true;
                }
            }
            if (isDiagonalMatch(symbol)) {
                winner = String.valueOf(symbol);
                return true;
            }
        }
        return false;
    }

    private int countLineMatches(int h, int v, char symbol) {
        return field.getValue(h, v) == symbol ? 1 : 0;
    }

    private boolean isLineMatch(int horizontalMatches, int verticalMatches) {
        return (horizontalMatches >= 3 || verticalMatches >= 3);
    }

    private boolean isDiagonalMatch(char symbol) {
        return  ((field.getValue(0, 0) == symbol && field.getValue(1, 1) == symbol &&
                field.getValue(2, 2) == symbol) || (field.getValue(0, 2) == symbol &&
                field.getValue(1, 1) == symbol && field.getValue(2, 0) == symbol));
    }
}
