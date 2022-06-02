package ua.hillel.task23;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatUtils {
    public static LocalDate parseToDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        return LocalDate.parse(dateStr, formatter);
    }

    public static LocalTime parseToTime(String timeStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.mm");
        return LocalTime.parse(timeStr, formatter);
    }

    public static double parseToDouble(String doubleStr) {
        NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
        Number number = null;
        try {
            number = format.parse(doubleStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return number.doubleValue();
    }
}
