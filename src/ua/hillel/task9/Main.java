package ua.hillel.task9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String symbolStr = "phenomenon";
        System.out.println(StringUtil.findSymbolOccurrence(symbolStr, 'n'));

        String subStr1 = "Apollo";
        String subStr2 = "Apple";
        System.out.println(StringUtil.findWordPosition(subStr1, "pollo"));
        System.out.println(StringUtil.findWordPosition(subStr2, "Plant"));

        String reversedStr = "Hello";
        System.out.println(StringUtil.stringReverse(reversedStr));

        String palindromeStr1 = "ERE";
        String palindromeStr2 = "Allo";
        System.out.println(StringUtil.isPalindrome(palindromeStr1));
        System.out.println(StringUtil.isPalindrome(palindromeStr2));

        startGame();
    }

    private static void startGame() {
        WordGame game = new WordGame();
        Scanner scanner = new Scanner(System.in);
        while (game.isNotFinished()) {
            System.out.print("Enter your word: ");
            game.acceptAnswer(scanner.nextLine());
            System.out.println(game.takeHint());
        }
        System.out.printf("VICTORY! The word was '%s'!", game.getAnswer());
    }
}
