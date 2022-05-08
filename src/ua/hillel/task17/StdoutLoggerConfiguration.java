package ua.hillel.task17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

public class StdoutLoggerConfiguration extends LoggerConfiguration {
    public StdoutLoggerConfiguration(String pathName, LoggingLevel logLevel, long maxSize, String format) {
        super(pathName, logLevel, maxSize, format);
    }

    @Override
    public void createNewFile() {
        String fileName = "ScannerLog_" + FILE_NAME_TIME_FORMAT.format(LocalDateTime.now()) + ".txt";
        try {
            setPath(Files.createFile(Path.of(getPathName(), fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
