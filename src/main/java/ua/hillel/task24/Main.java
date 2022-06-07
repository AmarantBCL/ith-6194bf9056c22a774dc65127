package ua.hillel.task24;

public class Main {
    private static final String CONFIG_PATH = "src/ua/hillel/task24/config.ini";

    public static void main(String[] args) {
        FileLoggerConfigurationLoader configLoader = new FileLoggerConfigurationLoader();
        FileLoggerConfiguration config = configLoader.load(CONFIG_PATH);
        FileLogger log = new FileLogger(config);
        for (int i = 0; i < 5; i++) {
            log.debug("Debug test string");
            log.info("Info test string");
        }
    }
}
