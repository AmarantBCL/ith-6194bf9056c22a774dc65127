package ua.hillel.task24;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLoggerWriter implements LoggerWriter {
    private static final DateTimeFormatter MESSAGE_TIME_FORMAT = DateTimeFormatter.ofPattern(
            "dd.MM.yyyy HH:mm:ss");

    private final LoggerConfiguration config;

    public FileLoggerWriter(LoggerConfiguration config) {
        this.config = config;
        config.createNewFile();
    }

    public void write(String message) {
        checkNewFile();
        try {
            File file = config.getFile();
            String timeFormat = MESSAGE_TIME_FORMAT.format((LocalDateTime.now()));
            String messageStr = String.format(config.getFormat(), timeFormat, config.getLogLevel(), message);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(messageStr);
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException("Something wrong with writing into a file.", e);
        }
    }

    private void checkNewFile() {
        if (config.getFile().length() >= config.getMaxSize()) {
            config.createNewFile();
        }
    }
}
