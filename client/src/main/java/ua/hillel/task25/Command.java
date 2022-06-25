package ua.hillel.task25;

import java.io.IOException;

public interface Command {
    boolean execute(String... args) throws IOException;
}
