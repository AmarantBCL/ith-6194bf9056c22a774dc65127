package ua.hillel.task25;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class FileReceiver {
    public void receive(String path, String name) throws IOException {
        Path fileName = Path.of(path).getFileName();
        try (FileInputStream fin = new FileInputStream(path);
             FileOutputStream fos = new FileOutputStream(fileName.toString())) {
            byte[] buffer = new byte[fin.available()];
            fin.read(buffer, 0, buffer.length);
            fos.write(buffer, 0, buffer.length);
            Server.log.info("[FILE] " + name + ": '" + fileName + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
