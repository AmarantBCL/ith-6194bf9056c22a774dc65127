package ua.hillel.task17;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {
    private static final DateTimeFormatter MESSAGE_TIME_FORMAT = DateTimeFormatter.ofPattern(
            "dd.MM.yyyy HH:mm:ss");
    private final FileLoggerConfiguration config;

    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
    }

    public void debug(String message) {
        if (config.getLogLevel() == LoggingLevel.INFO) return;
        writeMessage(message, "DEBUG");
    }

    public void info(String message) {
        writeMessage(message, "INFO");
    }

    private void writeMessage(String message, String type) {
        if (config.getFile().length() >= config.getMaxSize()) {
            config.createNewFile();
            /* Здесь можно вызвать Exception вместо создания нового файла (было также одним из подзаданий)
             throw new FileMaxSizeReachedException(String.format("File '%s' size: %d, max size: %d",
                     config.getFile().getPath(), config.getFile().length(), config.getMaxSize()));
             */
        }
        File file = config.getFile();
        String timeStr = MESSAGE_TIME_FORMAT.format((LocalDateTime.now()));
        String messageStr = String.format(config.getFormat(), timeStr, type, message);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(messageStr);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
