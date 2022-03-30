package ua.hillel.task9;

import java.util.Arrays;
import java.util.Random;

public class WordGame {
    private static final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
            "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
            "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin",
            "potato"};
    private static final int MAX_HINT_LENGTH = 15;
    private final String word;
    private boolean isFinished;
    private String answer;
    private char[] maskedAnswer;

    public WordGame() {
        Random random = new Random();
        this.word = words[random.nextInt(words.length)];
        generateMaskedAnswer();
    }

    public String getAnswer() {
        return answer;
    }

    public void acceptAnswer(String answer) {
        this.answer = answer;
        if (word.equals(answer)) {
            isFinished = true;
        }
    }

    public boolean isNotFinished() {
        return !isFinished;
    }

    public String takeHint() {
        char[] wordChars = word.toCharArray();
        for (int i = 0; i < wordChars.length; i++) {
            if (answer.length() > i && maskedAnswer[i] == '#' && answer.charAt(i) == word.charAt(i)) {
                maskedAnswer[i] = word.charAt(i);
            }
        }
        return new String(maskedAnswer);
    }

    private void generateMaskedAnswer() {
        maskedAnswer = new char[MAX_HINT_LENGTH];
        Arrays.fill(maskedAnswer, '#');
    }
}
