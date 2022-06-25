package ua.hillel.task25;

import java.io.DataOutputStream;
import java.io.IOException;

public class SendFileCommand implements Command {
    private DataOutputStream out;

    public SendFileCommand(DataOutputStream out) {
        this.out = out;
    }

    @Override
    public boolean execute(String... args) throws IOException {
        if (args.length < 2) {
            System.out.println("Select a path to file!");
        } else {
            new FileSender().send(args[1], out);
        }
        return false;
    }
}
