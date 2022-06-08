package ua.hillel.task24;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FileLoggerConfigurationLoaderTest {
    @Test
    void shouldReturnConfigurationNotFoundException_whenWrongConfigPathSpecified() {
        FileLoggerConfigurationLoader wrongConfigLoader = new FileLoggerConfigurationLoader();
        Assertions.assertThrowsExactly(ConfigurationNotFoundException.class, () -> wrongConfigLoader.load("src/resources/config.ini"));
    }

    @Test
    void shouldReturnFileLoggerConfigurationObject_whenCorrectConfigPathSpecified() {
        FileLoggerConfigurationLoader correctConfigLoader = new FileLoggerConfigurationLoader();
        Assertions.assertInstanceOf(FileLoggerConfiguration.class, correctConfigLoader.load("src/main/resources/config.ini"));
    }

    @Test
    void shouldReturnNullPointerException_whenNoConfigPathSpecified() {
        FileLoggerConfigurationLoader wrongConfigLoader = new FileLoggerConfigurationLoader();
        Assertions.assertThrowsExactly(NullPointerException.class, () -> wrongConfigLoader.load(null));
    }
}