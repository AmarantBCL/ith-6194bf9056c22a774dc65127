package ua.hillel.task23;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CurrencyFileReader {
    private static final String FILE_PREFIX = "Exchange_rates_";
    private static final String FILE_FORMAT = ".txt";
    private static final String HEADER = "| Date";

    public List<File> getFiles(LocalDate dateStart, LocalDate dateEnd) {
        List<File> files = new ArrayList<>();
        for (LocalDate date = dateStart; !date.isAfter(dateEnd); date = date.plusDays(1)) {
            if (exists(date)) {
                files.add(new File(FILE_PREFIX + date + FILE_FORMAT));
            }
        }
        return files;
    }

    public ExchangeRate read(File file) {
        ExchangeRate rate = new ExchangeRate();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(HEADER)) continue;
                String[] data = line.split("\\|");
                LocalDate date = FormatUtils.parseToDate(data[1].trim());
                LocalTime time = FormatUtils.parseToTime(data[2].trim());
                double UAH = FormatUtils.parseToDouble(data[7].trim());
                Currency currency = new Currency(date, time, data[3].trim(), data[4].trim(),
                        Integer.parseInt(data[5].trim()), data[6].trim(), UAH);
                rate.add(currency);
            }
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong with file reading.", e);
        }
        return rate;
    }

    private boolean exists(LocalDate localDate) {
        return new File(FILE_PREFIX + localDate + FILE_FORMAT).exists();
    }
}
