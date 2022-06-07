package ua.hillel.task23;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CurrencyScanner {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.####");

    private final CurrencyConverter converter;
    private boolean isDone;

    public CurrencyScanner(CurrencyConverter converter) {
        this.converter = converter;
    }

    public void scan() {
        System.out.print("Укажите валюту: ");
        String[] params = SCANNER.nextLine().split("\\s+");
        ParamsValidator validator = new ParamsValidator(params);
        if (validator.check()) {
            LocalDate dateStart = params.length > 1 ? FormatUtils.parseToDate(params[1]) : LocalDate.now();
            LocalDate dateEnd = params.length > 2 ? FormatUtils.parseToDate(params[2]) : dateStart;
            List<Currency> currencies = converter.getCurrencies(params[0], dateStart, dateEnd);
            if (checkResponse(currencies)) return;
            double average = converter.calculateAverage(currencies);
            currencies.stream()
                    .findFirst()
                    .ifPresent(c -> info(c, average));
        }
    }

    public boolean notDone() {
        return !isDone;
    }

    private void info(Currency currency, double average) {
        System.out.printf("Средняя стоимость UAH [Ukrainian Hryvnia] к %s [%s] -> %s\n",
                currency.getLetterCode(),
                currency.getName(),
                DECIMAL_FORMAT.format(average)
        );
        isDone = true;
    }

    private boolean checkResponse(List<Currency> currencies) {
        if (currencies.isEmpty()) {
            System.out.println("Не найдено данных по выбранной дате");
            return true;
        }
        if (currencies.get(0) == null) {
            System.out.println("Такая валюта не найдена. Попробуйте ещё раз.");
            return true;
        }
        return false;
    }
}
