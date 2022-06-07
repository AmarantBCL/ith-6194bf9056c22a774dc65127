package ua.hillel.task17;

public class FileMaxSizeReachedException extends RuntimeException {
    public FileMaxSizeReachedException(String message) {
        super(message);
    }

    public FileMaxSizeReachedException() {
        super();
    }
}
