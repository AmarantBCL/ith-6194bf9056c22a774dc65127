package ua.hillel.task23;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class FormatUtils {
    private final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("d.MM.yyyy");
    private final static DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH.mm");

    public static boolean isValidDate(String dateStr) {
        try {
            LocalDate.parse(dateStr, DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    public static LocalDate parseToDate(String dateStr) {
        return LocalDate.parse(dateStr, DATE_FORMATTER);
    }

    public static LocalTime parseToTime(String timeStr) {
        return LocalTime.parse(timeStr, TIME_FORMATTER);
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
