package ua.hillel.task17;

public class FileLogger {
    private final FileLoggerConfiguration config;
    private final FileLoggerWriter writer;

    public FileLogger(FileLoggerConfiguration config) {
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
