package ua.hillel.task10;

public class Main {
    private static final CoordinateScanner[] SCANNERS = {
            new StdoutCoordinateScanner(), new RandomCoordinateScanner()
    };

    public static void main(String[] args) {
        boolean playing = true;
        while (playing) {
            Field field = new Field();
            Gameplay gameplay = new Gameplay(field);
            WinChecker winChecker = new WinChecker(field);
            DrawChecker drawChecker = new DrawChecker(field);
            do {
                for (CoordinateScanner scanner : SCANNERS) {
                    gameplay.turn(scanner);
                    if (gameplay.checkWinDraw(winChecker) || gameplay.checkWinDraw(drawChecker)) {
                        playing = gameplay.playAgain();
                        break;
                    }
                }
            } while (gameplay.notFinished());
        }
    }
}
