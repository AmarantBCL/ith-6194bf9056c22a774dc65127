package ua.hillel.task23;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class CurrencyFileReader {
    public ExchangeRate read(LocalDate localDate) {
        ExchangeRate rate = new ExchangeRate();
        String path = "Exchange_rates_" + localDate + ".txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("| Date")) continue;
                String[] data = line.split("\\|");
                LocalDate date = FormatUtils.parseToDate(data[1].trim());
                LocalTime time = FormatUtils.parseToTime(data[2].trim());
                double UAH = FormatUtils.parseToDouble(data[7].trim());
                Currency currency = new Currency(date, time, data[3].trim(), data[4].trim(),
                        Integer.parseInt(data[5].trim()), data[6].trim(), UAH);
                rate.add(currency);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rate;
    }
}
