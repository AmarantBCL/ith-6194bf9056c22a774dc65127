package ua.hillel.task17;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
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
            /* Здесь можно вызвать Exception вместо создания нового файла (было также одним из подзаданий) */
            // throw new FileMaxSizeReachedException(String.format("File '%s' size: %d, max size: %d",
            // file.getPath(), file.length(), config.getMaxSize()));
        }
        File file = config.getFile();
        String timeStr = TIME_FORMAT.format((LocalDateTime.now()));
        String messageStr = String.format(config.getFormat() + "\n", timeStr, type, message);
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(file, true))) {
            bf.write(messageStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
