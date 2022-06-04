package ua.hillel.task23;

public class Main {
    public static void main(String[] args) {
        CurrencyScanner scanner = new CurrencyScanner(new CurrencyConverter());
        do {
            scanner.scan();
        } while (scanner.notDone());
    }
}
