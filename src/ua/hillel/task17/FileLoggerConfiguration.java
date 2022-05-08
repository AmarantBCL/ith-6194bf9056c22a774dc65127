package ua.hillel.task17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLoggerConfiguration {
    private final static DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern(
            "dd.MM.yyyy-HH_mm_ss_SSS");
    private final LoggingLevel logLevel;
    private final long maxSize;
    private final String format;
    private final String pathName;
    private Path path;

    public Path getPath() {
        return path;
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

    public FileLoggerConfiguration(String pathName, LoggingLevel logLevel, long maxSize, String format) {
        this.pathName = pathName;
        this.logLevel = logLevel;
        this.maxSize = maxSize;
        this.format = format;
        createNewFile();
    }

    public void createNewFile() {
        String fileName = "Log_" + TIME_FORMAT.format(LocalDateTime.now()) + ".txt";
        try {
            path = Files.createFile(Path.of(pathName, fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
