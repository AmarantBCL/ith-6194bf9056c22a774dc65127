package ua.hillel.task14;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileNavigator navigator = new FileNavigator();
        HashMap<String, List<FileData>> map = navigator.getFiles();
        FileData file = new FileData("video.mp3", 56L, "D:/Videos");
        System.out.println(file);
        System.out.println(map);
        navigator.add(file, "D:/Storage");
        System.out.println(file);
        System.out.println(map);
        FileData file2 = new FileData("firstApp.java", 1L, "D:/Apps");
        System.out.println(file2);
        navigator.add(file2, "D:/Storage");
        System.out.println(map);
        FileData file3 = new FileData("love.jpg", 5L, "D:/Images/Photos");
        System.out.println(navigator.find("D:/Storage"));

        System.out.println(file3);
        navigator.add(file3, "D:/Storage/Images");
        System.out.println(map);
        System.out.println(navigator.find("D:/Storage/Images"));

        System.out.println(navigator.filterBySize("D:/Storage", 1L));

        navigator.remove("D:/Storage");
        System.out.println(map);
    }
}
