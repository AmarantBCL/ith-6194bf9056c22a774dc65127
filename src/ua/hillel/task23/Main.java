package ua.hillel.task23;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        CurrencyConverter converter = new CurrencyConverter();
        Scanner scanner = new Scanner(System.in);
        boolean isDone = false;
        do {
            System.out.print("Укажите валюту: ");
            Currency currency = converter.getCurrency(scanner.nextLine());
            if (currency != null) {
                DecimalFormat decimalFormat = new DecimalFormat("#.####");
                System.out.printf("Средняя стоимость UAH [Ukrainian Hryvnia] к %s [%s] -> %s",
                        currency.getLetterCode(),
                        currency.getName(),
                        decimalFormat.format(currency.getUAH())
                );
                isDone = true;
            } else {
                System.out.println("Такой валюты не существует. Попробуйте ещё раз.");
            }
        } while (!isDone);
    }
}
