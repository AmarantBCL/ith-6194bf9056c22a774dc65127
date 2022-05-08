package ua.hillel.task17;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StdoutLoggerConfigurationLoader implements LoggerConfigurationLoader {
    private static final Pattern CONFIG_PATTERN = Pattern.compile("^.+?:\s(.+)$");

    @Override
    public LoggerConfiguration load(String pathName) {
        List<String> params = new ArrayList<>();
        String line;
        try (BufferedReader br = Files.newBufferedReader(Path.of(pathName))) {
            while ((line = br.readLine()) != null) {
                Matcher matcher = CONFIG_PATTERN.matcher(line);
                while (matcher.find()) {
                    params.add(matcher.group(1));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new StdoutLoggerConfiguration(params.get(0),
                    LoggingLevel.valueOf(params.get(1)),
                    Long.parseLong(params.get(2)),
                    params.get(3));
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Wrong configuration arguments");
        }
    }
}
