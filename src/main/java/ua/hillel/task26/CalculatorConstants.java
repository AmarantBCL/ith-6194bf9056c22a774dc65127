package ua.hillel.task26;

import java.util.HashSet;
import java.util.Set;

public final class CalculatorConstants {
    public static final String ERROR_MESSAGE = "ERR";
    public static final Set<String> CORRECT_OPERATIONS;

    static {
        CORRECT_OPERATIONS = new HashSet<>();
        CORRECT_OPERATIONS.add("+");
        CORRECT_OPERATIONS.add("-");
        CORRECT_OPERATIONS.add("*");
        CORRECT_OPERATIONS.add("/");
    }

    private CalculatorConstants() {
    }
}
