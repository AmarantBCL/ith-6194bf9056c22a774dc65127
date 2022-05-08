package ua.hillel.task17;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class FileLogger implements Logger {
    private final LoggerConfiguration config;

    public FileLogger(LoggerConfiguration config) {
        this.config = config;
    }

    @Override
    public void debug(String message) {
        if (config.getLogLevel().ordinal() < LoggingLevel.DEBUG.ordinal()) return;
        writeMessage(message, "DEBUG");
    }

    @Override
    public void info(String message) {
        if (config.getLogLevel().ordinal() < LoggingLevel.INFO.ordinal()) return;
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
        String timeStr = LoggerConfiguration.MESSAGE_TIME_FORMAT.format((LocalDateTime.now()));
        String messageStr = String.format(config.getFormat(), timeStr, type, message);
        try (BufferedWriter bw = Files.newBufferedWriter(config.getPath(), StandardOpenOption.APPEND)) {
            bw.write(messageStr);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
