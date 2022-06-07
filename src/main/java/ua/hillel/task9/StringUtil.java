package ua.hillel.task9;

public class StringUtil {
    public static int findSymbolOccurrence(String str, char symbol) {
        char[] chars = str.toCharArray();
        int times = 0;
        for (char c : chars) {
            if (c == symbol) {
                times++;
            }
        }
        return times;
    }

    public static int findWordPosition(String source, String target) {
        return source.indexOf(target);
    }

    public static String stringReverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    public static boolean isPalindrome(String str) {
        StringBuilder sb = new StringBuilder(str);
        return str.equals(sb.reverse().toString());
    }
}
