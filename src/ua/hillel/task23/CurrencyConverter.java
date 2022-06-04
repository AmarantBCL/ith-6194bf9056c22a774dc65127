package ua.hillel.task23;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CurrencyConverter {
    private static final int MAX_FILES_PER_THREAD = 30;

    public List<Currency> getCurrencies(String letterCode, LocalDate dateStart, LocalDate dateEnd) {
        CurrencyFileReader reader = new CurrencyFileReader();
        List<Currency> currencies = new ArrayList<>();
        List<File> files = reader.getFiles(dateStart, dateEnd);
        if (files.size() == 0) return currencies;
        int threadCount = (int) Math.ceil((double) files.size() / MAX_FILES_PER_THREAD);
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        for (File file : files) {
            executorService.submit(() -> {
                ExchangeRate rate = reader.read(file);
                Currency currency = rate.filter(letterCode);
                currencies.add(currency);
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(2, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return currencies;
    }

    public double calculateAverage(List<Currency> currencies) {
        return currencies.stream().filter(Objects::nonNull).mapToDouble(Currency::getUAH).sum()
                / currencies.stream().filter(Objects::nonNull).count();
    }
}
