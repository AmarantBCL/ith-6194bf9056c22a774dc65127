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
            /* Здесь можно вызвать Exception вместо создания нового файла (было также одним из подзаданий)
             throw new FileMaxSizeReachedException(String.format("File '%s' size: %d, max size: %d",
                     config.getFile().getPath(), config.getFile().length(), config.getMaxSize()));
             */
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
            e.printStackTrace();
        }
    }
}
