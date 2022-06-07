package ua.hillel.task14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileNavigator {
    private final Map<String, List<FileData>> allFiles = new HashMap<>();

    public Map<String, List<FileData>> getAllFiles() {
        return allFiles;
    }

    public void add(FileData file, String path) {
        if (file.getPath().equals(path)) {
            List<FileData> files = allFiles.containsKey(path) ? allFiles.get(path) : new ArrayList<>();
            files.add(file);
            allFiles.put(path, files);
        } else {
            System.out.printf("File path mismatch!%nPath: %s%nFileData: %s%n", file.getPath(), file);
        }
    }

    public List<FileData> find(String path) {
        return allFiles.get(path);
    }

    public List<FileData> filterBySize(long size) {
        List<FileData> filesBySize = new ArrayList<>();
        for (List<FileData> files : allFiles.values()) {
            for (FileData file : files) {
                if (file.getSize() <= size) {
                    filesBySize.add(file);
                }
            }
        }
        return filesBySize;
    }

    public List<FileData> remove(String path) {
        return allFiles.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> files = new ArrayList<>();
        for (List<FileData> fileList : allFiles.values()) {
            files.addAll(fileList);
        }
        files.sort(new Comparator<FileData>() {
            @Override
            public int compare(FileData o1, FileData o2) {
                return Long.compare(o1.getSize(), o2.getSize());
            }
        });
        return files;
    }
}
