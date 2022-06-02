package ua.hillel.task23;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CurrencyScanner scanner = new CurrencyScanner(new CurrencyConverter());
        do {
            scanner.scan();
        } while (scanner.notDone());
    }
}
