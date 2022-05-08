package ua.hillel.task17;

import java.nio.file.Path;
import java.time.format.DateTimeFormatter;

public abstract class LoggerConfiguration {
    public final static DateTimeFormatter FILE_NAME_TIME_FORMAT = DateTimeFormatter.ofPattern(
            "dd.MM.yyyy-HH_mm_ss_SSS");
    public final static DateTimeFormatter MESSAGE_TIME_FORMAT = DateTimeFormatter.ofPattern(
            "dd.MM.yyyy-HH:mm:ss");

    private final LoggingLevel logLevel;
    private final long maxSize;
    private final String format;
    private final String pathName;
    private Path path;

    public LoggingLevel getLogLevel() {
        return logLevel;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public String getFormat() {
        return format;
    }

    public String getPathName() {
        return pathName;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public LoggerConfiguration(String pathName, LoggingLevel logLevel, long maxSize, String format) {
        this.pathName = pathName;
        this.logLevel = logLevel;
        this.maxSize = maxSize;
        this.format = format;
        createNewFile();
    }

    public abstract void createNewFile();
}
