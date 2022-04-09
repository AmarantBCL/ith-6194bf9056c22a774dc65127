package ua.hillel.task10;

public class Gameplay {
    private final Field field;
    private final FieldDrawer fieldDrawer;
    private boolean inProgress;
    private char symbol;

    public Gameplay(Field field) {
        inProgress = true;
        this.field = field;
        this.fieldDrawer = new FieldDrawer();
        fieldDrawer.draw(field);
    }

    public void turn(CoordinateScanner scanner) {
        CoordinateChecker coordinateChecker = new CoordinateChecker();
        Coordinate coordinate;
        setTurnSymbol();
        do {
            coordinate = scanner.scan();
        } while (!coordinateChecker.check(coordinate, field));
        field.setValue(coordinate.getH(), coordinate.getV(), symbol);
        fieldDrawer.draw(field);
    }

    public boolean checkWinDraw(Checker checker) {
        if (checker.check()) {
            inProgress = false;
            showWinner(checker.getWinner());
            return true;
        }
        return false;
    }

    public boolean notFinished() {
        return inProgress;
    }

    public boolean playAgain() {
        return new RematchScanner().ask();
    }

    private void setTurnSymbol() {
        symbol = symbol == 'O' || symbol == '\u0000' ? 'X' : 'O';
    }

    private void showWinner(String winner) {
        if (winner != null) {
            System.out.println("The winner is '" + winner + "'!");
        } else {
            System.out.println("DRAW!");
        }
    }
}
