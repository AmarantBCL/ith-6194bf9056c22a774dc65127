package ua.hillel.task17;

public class Main {
    public static void main(String[] args) {
        FileLoggerConfigurationLoader configLoader = new FileLoggerConfigurationLoader();
        FileLoggerConfiguration config = configLoader.load("config.ini");
        FileLogger log = new FileLogger(config);
        for (int i = 0; i < 50; i++) {
            log.debug("Debug test string");
            log.info("Info test string");
        }
    }
}
