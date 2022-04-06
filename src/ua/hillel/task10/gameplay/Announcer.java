package ua.hillel.task10.gameplay;

public class Announcer {
    public void show(String winner) {
        if (winner != null) {
            System.out.println("The winner is '" + winner + "'!");
        } else {
            System.err.println("DRAW!");
        }
    }
}
