package ua.hillel.task17;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileLoggerConfigurationLoader {
    private static final Pattern CONFIG_PATTERN = Pattern.compile("^.+?:\s(.+)$");

    public FileLoggerConfiguration load(Path path) {
        List<String> params = new ArrayList<>();
        String line;
        try (BufferedReader br = Files.newBufferedReader(path)) {
            while ((line = br.readLine()) != null) {
                Matcher matcher = CONFIG_PATTERN.matcher(line);
                while (matcher.find()) {
                    params.add(matcher.group(1));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new FileLoggerConfiguration(params.get(0),
                LoggingLevel.valueOf(params.get(1)),
                Long.parseLong(params.get(2)),
                params.get(3));
    }
}
