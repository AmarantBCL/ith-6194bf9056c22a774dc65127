package ua.hillel.task23;

import java.time.LocalDate;
import java.time.LocalTime;

public class Currency {
    private final LocalDate date;
    private final LocalTime time;
    private final String digitalCode;
    private final String letterCode;
    private final int unit;
    private final String name;
    private final double UAH;

    public String getLetterCode() {
        return letterCode;
    }

    public String getName() {
        return name;
    }

    public double getUAH() {
        return UAH;
    }

    public Currency(LocalDate date, LocalTime time, String digitalCode, String letterCode, int unit,
                    String name, double UAH) {
        this.date = date;
        this.time = time;
        this.digitalCode = digitalCode;
        this.letterCode = letterCode;
        this.unit = unit;
        this.name = name;
        this.UAH = UAH;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "date=" + date +
                ", time=" + time +
                ", digitalCode='" + digitalCode + '\'' +
                ", letterCode='" + letterCode + '\'' +
                ", unit=" + unit +
                ", name='" + name + '\'' +
                ", UAH=" + UAH +
                '}';
    }
}
