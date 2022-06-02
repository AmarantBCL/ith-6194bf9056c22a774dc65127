package ua.hillel.task23;

public class CurrencyConverter {
    public Currency getCurrency(String letterCode) {
        CurrencyFileReader reader = new CurrencyFileReader();
        ExchangeRate rate = reader.read();
        return rate.filter(letterCode);
    }
}
