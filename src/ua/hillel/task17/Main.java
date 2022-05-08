package ua.hillel.task17;

public class Main {
    public static void main(String[] args) {
        // File logger
        LoggerConfigurationLoader fileConfigLoader = new FileLoggerConfigurationLoader();
        LoggerConfiguration fileConfig = fileConfigLoader.load("file.ini");
        Logger log = new FileLogger(fileConfig);
        for (int i = 0; i < 10; i++) {
            log.debug("Debug test string");
            log.info("Info test string");
        }

        // Console logger
        LoggerConfigurationLoader stdoutConfigLoader = new StdoutLoggerConfigurationLoader();
        LoggerConfiguration stdoutConfig = stdoutConfigLoader.load("scanner.ini");
        Logger stdoutLog = new StdoutLogger(stdoutConfig);
        for (int i = 0; i < 10; i++) {
            stdoutLog.debug("Debug scanner test message");
            stdoutLog.info("Info scanner test message");
        }

    }
}
