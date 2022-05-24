package ua.hillel.task17;

public enum LoggingLevel {
    INFO(0), DEBUG(1);

    private int level;

    public int getLevel() {
        return level;
    }

    LoggingLevel(int level) {
        this.level = level;
    }
}
