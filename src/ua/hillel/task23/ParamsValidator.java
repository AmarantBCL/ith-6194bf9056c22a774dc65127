package ua.hillel.task23;

public class ParamsValidator {
    private final String[] params;

    public ParamsValidator(String[] params) {
        this.params = params;
    }

    public boolean check() {
        if (moreThanThreeParams()) {
            System.out.println("Параметров не может быть больше 3");
            return false;
        }
        for (int i = 1; i < params.length; i++) {
            if (notValidDate(params[i])) {
                System.out.println("Введён неверный формат параметров. Правильные варианты: " +
                        "\nUSD" +
                        "\nusd" +
                        "\nUSD 01.06.2022" +
                        "\nUSD 31.05.2022 02.06.2022");
                return false;
            }
        }
        return true;
    }

    private boolean moreThanThreeParams() {
        return params.length > 3;
    }

    private boolean notValidDate(String dateStr) {
        return !FormatUtils.isValidDate(dateStr);
    }
}
