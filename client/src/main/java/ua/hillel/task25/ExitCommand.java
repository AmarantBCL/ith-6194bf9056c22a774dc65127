package ua.hillel.task25;

public class ExitCommand implements Command {
    @Override
    public boolean execute(String... args) {
        System.out.println("Exiting the server...");
        return true;
    }
}
