package ua.hillel.task26;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class ResultOperation {
    private static final Map<String, ArithmeticOperation> ARITHMETIC_OPERATIONS;
    private static final String OPERANDS_REGEX = "\\s+[+\\-*/]\\s*";
    private static final String ARITHMETIC_OPERATIONS_REGEX = "-*\\d+,*\\d*";

    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.##########");

    static {
        ARITHMETIC_OPERATIONS = new HashMap<>();
        ARITHMETIC_OPERATIONS.put("+", new AddOperation());
        ARITHMETIC_OPERATIONS.put("-", new SubtractOperation());
        ARITHMETIC_OPERATIONS.put("*", new MultiplyOperation());
        ARITHMETIC_OPERATIONS.put("/", new DivideOperation());
    }

    public static String calculate(String expressionStr) {
        String[] operands = expressionStr.split(OPERANDS_REGEX);
        String[] operations = expressionStr.split(ARITHMETIC_OPERATIONS_REGEX);
        double result = 0;
        boolean isFirstOperation = true;
        if (operations.length < 2 || operands.length < 2) return operands.length > 0 ? operands[0] : "";
        for (int i = 1; i < operations.length; i++) {
            if (isFirstOperation) {
                result = ARITHMETIC_OPERATIONS.get(operations[i].trim()).calculate(
                        Double.parseDouble(operands[i - 1].replace(",", ".")),
                        Double.parseDouble(operands[i].replace(",", ".")));
                isFirstOperation = false;
            } else {
                if (i >= operands.length) break;
                result = ARITHMETIC_OPERATIONS.get(operations[i].trim()).calculate(result,
                        Double.parseDouble(operands[i].replace(",", ".")));
            }
        }
        return String.valueOf(DECIMAL_FORMAT.format(result));
    }
}
