package ua.hillel.task24;

public class Main {
    private static final String CONFIG_PATH = "src/main/resources/config.ini";

    public static void main(String[] args) {
        LoggerConfigurationLoader configLoader = new FileLoggerConfigurationLoader();
        LoggerConfiguration config = configLoader.load(CONFIG_PATH);
        Logger log = new FileLogger(config);
        for (int i = 0; i < 5; i++) {
            log.debug("Debug test string");
            log.info("Info test string");
        }
    }
}
