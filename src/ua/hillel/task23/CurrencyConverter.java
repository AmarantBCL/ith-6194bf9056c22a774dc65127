package ua.hillel.task23;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CurrencyConverter {
    public List<Currency> getCurrencies(String letterCode, LocalDate dateStart, LocalDate dateEnd) {
        CurrencyFileReader reader = new CurrencyFileReader();
        List<Currency> currencies = new ArrayList<>();
        for (LocalDate date = dateStart; !date.isAfter(dateEnd); date = date.plusDays(1)) {
            ExchangeRate rate = reader.read(date);
            currencies.add(rate.filter(letterCode));
        }
        return currencies;
    }

    public double calculateAverage(List<Currency> currencies) {
        return currencies.stream().mapToDouble(c -> c.getUAH()).sum() / currencies.size();
    }
}
