package ua.hillel.task10;

import java.util.Scanner;

public class RematchScanner {
    private static Scanner scanner = new Scanner(System.in);
    private static String ANSWER_YES = "1";
    private static String ANSWER_NO = "2";

    public boolean ask() {
        String input;
        do {
            System.out.printf("Wanna play again? [%s - Yes, %s - No]%n", ANSWER_YES, ANSWER_NO);
            input = scanner.nextLine();
        } while (!input.equals(ANSWER_YES) && !input.equals(ANSWER_NO));
        return input.equals(ANSWER_YES);
    }
}
