package ua.hillel.task25;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

public class FileSender {
    public void send(String path, DataOutputStream out) throws IOException {
        if (!new File(path).exists()) {
            System.out.println("The file '" + path + "' doesn't exist!");
            return;
        }
        out.writeUTF("-file " + path);
        System.out.println("The file has been sent.");
    }
}
