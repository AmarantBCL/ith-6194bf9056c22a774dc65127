package ua.hillel.task24;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLoggerConfiguration extends LoggerConfiguration {
    private static final String FILE_PREFIX = "Log_";
    private static final String FILE_FORMAT = ".txt";
    private static final DateTimeFormatter FILE_NAME_TIME_FORMAT = DateTimeFormatter.ofPattern(
            "dd.MM.yyyy-HH_mm_ss_SSS");

    public FileLoggerConfiguration(String filePath, LoggingLevel logLevel, long maxSize, String format) {
        super(filePath, logLevel, maxSize, format);
    }

    public void createNewFile() {
        String fileName = FILE_PREFIX + FILE_NAME_TIME_FORMAT.format(LocalDateTime.now()) + FILE_FORMAT;
        setFile(new File(getFilePath() + fileName));
    }
}
