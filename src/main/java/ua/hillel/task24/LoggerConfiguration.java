package ua.hillel.task24;

import java.io.File;

public abstract class LoggerConfiguration {
    private final LoggingLevel logLevel;
    private final long maxSize;
    private final String format;
    private final String filePath;
    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
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

    public String getFilePath() {
        return filePath;
    }

    public LoggerConfiguration(String filePath, LoggingLevel logLevel, long maxSize, String format) {
        this.filePath = filePath;
        this.logLevel = logLevel;
        this.maxSize = maxSize;
        this.format = format;
    }

    public abstract void createNewFile();
}
