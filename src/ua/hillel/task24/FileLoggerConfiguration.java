package ua.hillel.task24;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLoggerConfiguration {
    private static final String FILE_PREFIX = "Log_";
    private static final String FILE_FORMAT = ".txt";
    private static final DateTimeFormatter FILE_NAME_TIME_FORMAT = DateTimeFormatter.ofPattern(
            "dd.MM.yyyy-HH_mm_ss_SSS");

    private final LoggingLevel logLevel;
    private final long maxSize;
    private final String format;
    private final String filePath;
    private File file;

    public File getFile() {
        return file;
    }

    public String getFilePath() {
        return filePath;
    }

    public LoggingLevel getLogLevel() {
        return logLevel;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public String getFormat() {
        return format;
    }

    public FileLoggerConfiguration(String filePath, LoggingLevel logLevel, long maxSize, String format) {
        this.filePath = filePath;
        this.logLevel = logLevel;
        this.maxSize = maxSize;
        this.format = format;
    }

    public void createNewFile() {
        String fileName = FILE_PREFIX + FILE_NAME_TIME_FORMAT.format(LocalDateTime.now()) + FILE_FORMAT;
        file = new File(filePath + fileName);
    }
}
