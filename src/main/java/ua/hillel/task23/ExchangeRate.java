package ua.hillel.task23;

import java.util.ArrayList;
import java.util.List;

public class ExchangeRate {
    private final List<Currency> rates = new ArrayList<>();

    public void add(Currency currency) {
        rates.add(currency);
    }

    public Currency filter(String letterCode) {
        return rates.stream()
                .filter(c -> c.getLetterCode().equalsIgnoreCase(letterCode))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "rates=" + rates +
                '}';
    }
}
