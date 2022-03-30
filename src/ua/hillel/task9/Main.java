package ua.hillel.task9;

public class Main {
    public static void main(String[] args) {
        String symbolStr = "phenomenon";
        System.out.println(StringUtil.findSymbolOccurance(symbolStr, 'n'));

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
    }
}
