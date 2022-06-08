package ua.hillel.task24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileLoggerConfigurationLoader implements LoggerConfigurationLoader {
    private static final Pattern CONFIG_PATTERN = Pattern.compile("^.+?:\s(.+)$");

    public FileLoggerConfiguration load(String path) {
        List<String> params = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = CONFIG_PATTERN.matcher(line);
                while (matcher.find()) {
                    params.add(matcher.group(1));
                }
            }
        } catch (IOException e) {
            throw new ConfigurationNotFoundException("Cannot load configuration file.", e);
        }
        return checkParams(params);
    }

    private FileLoggerConfiguration checkParams(List<String> params) {
        try {
            return new FileLoggerConfiguration(params.get(0),
                    LoggingLevel.valueOf(params.get(1)),
                    Long.parseLong(params.get(2)),
                    params.get(3));
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Wrong configuration parameters.");
        }
    }
}
