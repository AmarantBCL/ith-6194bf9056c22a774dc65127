package ua.hillel.task24;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLoggerWriter {
    private static final DateTimeFormatter MESSAGE_TIME_FORMAT = DateTimeFormatter.ofPattern(
            "dd.MM.yyyy HH:mm:ss");

    private final FileLoggerConfiguration config;

    public FileLoggerWriter(FileLoggerConfiguration config) {
        this.config = config;
        config.createNewFile();
    }

    public void write(String message) {
        if (config.getFile().length() >= config.getMaxSize()) {
            config.createNewFile();
        }
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
}
