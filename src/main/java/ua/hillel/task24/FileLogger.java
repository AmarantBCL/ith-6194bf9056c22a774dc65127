package ua.hillel.task24;

public class FileLogger implements Logger {
    private final LoggerConfiguration config;
    private final LoggerWriter writer;

    public FileLogger(LoggerConfiguration config) {
        this.config = config;
        this.writer = new FileLoggerWriter(config);
    }

    public void debug(String message) {
        if (config.getLogLevel().getLevel() < LoggingLevel.DEBUG.getLevel()) return;
        writer.write(message);
    }

    public void info(String message) {
        if (config.getLogLevel().getLevel() < LoggingLevel.INFO.getLevel()) return;
        writer.write(message);
    }
}
