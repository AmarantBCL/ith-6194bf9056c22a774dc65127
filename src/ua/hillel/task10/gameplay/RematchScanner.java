package ua.hillel.task10.gameplay;

import java.util.Scanner;

public class RematchScanner {
    private static Scanner scanner = new Scanner(System.in);

    public boolean ask() {
        String input;
        do {
            System.out.println("Wanna play again? [1 - Yes, 2 - No]");
            input = scanner.nextLine();
        } while (!input.equals("1") && !input.equals("2"));
        return input.equals("1");
    }
}
