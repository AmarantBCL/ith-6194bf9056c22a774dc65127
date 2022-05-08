package ua.hillel.task17;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
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
        try {
            if (Files.size(config.getPath()) >= config.getMaxSize()) {
                config.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String timeStr = TIME_FORMAT.format((LocalDateTime.now()));
        String messageStr = String.format(config.getFormat(), timeStr, type, message);
        try (BufferedWriter bf = Files.newBufferedWriter(config.getPath(), StandardOpenOption.APPEND)) {
            bf.write(messageStr);
            bf.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
