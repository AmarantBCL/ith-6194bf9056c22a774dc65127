package ua.hillel.task14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileNavigator {
    private final HashMap<String, List<FileData>> files = new HashMap<>();

    public HashMap<String, List<FileData>> getFiles() {
        return files;
    }

    public void add(FileData file, String path) {
        List<FileData> list = files.containsKey(path) ? files.get(path) : new ArrayList<>();
        file.changePath(path);
        list.add(file);
        files.put(path, list);
    }

    public List<FileData> find(String path) {
        return files.get(path);
    }

    public List<FileData> filterBySize(String path, long size) {
        List<FileData> list = new ArrayList<>(find(path));
        for (FileData file : list) {
            if (file.getSize() > size) {
                list.remove(file);
            }
        }
        return list;
    }

    public void remove(String path) {
        List<FileData> list = find(path);
        files.remove(path);
    }
}
