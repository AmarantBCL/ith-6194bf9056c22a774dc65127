package ua.hillel.task23;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CurrencyConverter {
    private static final int MAX_FILES_PER_THREAD = 2;
    
    public List<Currency> getCurrencies(String letterCode, LocalDate dateStart, LocalDate dateEnd) {
        CurrencyFileReader reader = new CurrencyFileReader();
        List<Currency> currencies = new ArrayList<>();
        List<File> files = reader.getFiles(dateStart, dateEnd);
        int count = files.size();
        System.out.println(files.size() + " file(s) have been found");

        // TODO concurrency...
        ExecutorService executorService = Executors.newCachedThreadPool();
        double d = Math.ceil((double) count / MAX_FILES_PER_THREAD);
        for (int i = 0; i < d; i++) {
            System.out.println("In loop");
            executorService.execute(() -> {
                System.out.println("Thread is executing...");
                for (int j = 0; j < count; j++) {
                    // TODO concurrency...
                }
            });
        }
        executorService.shutdown();

        for (File file : files) {
            ExchangeRate rate = reader.read(file);
            Currency currency = rate.filter(letterCode);
            currencies.add(currency);
        }

        return currencies;
    }

    public double calculateAverage(List<Currency> currencies) {
        return currencies.stream().filter(Objects::nonNull).mapToDouble(Currency::getUAH).sum()
                / currencies.stream().filter(Objects::nonNull).count();
    }
}
