package ua.hillel.task17;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLoggerConfiguration {
    private final static DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern(
            "dd.MM.yyyy-HH_mm_ss_SSS");
    private final LoggingLevel logLevel;
    private final long maxSize;
    private final String format;
    private final String filePath;
    private File file;

    public File getFile() {
        return file;
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
        createNewFile();
    }

    public void createNewFile() {
        String fileName = "Log_" + TIME_FORMAT.format(LocalDateTime.now()) + ".txt";
        file = new File(filePath + fileName);
    }
}