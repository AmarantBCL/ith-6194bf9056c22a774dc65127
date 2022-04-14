package ua.hillel.task14;

public class FileData {
    private String name;
    private long size;
    private String path;

    public long getSize() {
        return size;
    }

    public FileData(String name, long size, String path) {
        this.name = name;
        this.size = size;
        this.path = path;
    }

    public void changePath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "FileData{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", path='" + path + '\'' +
                '}';
    }
}
