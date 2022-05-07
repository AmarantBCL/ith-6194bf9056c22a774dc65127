package ua.hillel.task17;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        FileLoggerConfigurationLoader configLoader = new FileLoggerConfigurationLoader();
        FileLoggerConfiguration config = configLoader.load(Path.of("config.ini"));
        FileLogger log = new FileLogger(config);
        for (int i = 0; i < 25; i++) {
            log.debug("Debug test string");
            log.info("Info test string");
        }
    }
}
