package ua.hillel.task24;

public enum LoggingLevel {
    INFO(0), DEBUG(1);

    private final int level;

    public int getLevel() {
        return level;
    }

    LoggingLevel(int level) {
        this.level = level;
    }
}
