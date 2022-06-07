package ua.hillel.task14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Task #1 tests
        FileNavigator navigator = new FileNavigator();
        Map<String, List<FileData>> allFiles = navigator.getAllFiles();
        FileData file1 = new FileData("movie.avi", 50, "/Storage");
        FileData file2 = new FileData("app.java", 1, "/Programs");
        FileData file3 = new FileData("song.mp3", 10, "/Storage");
        FileData file4 = new FileData("family.jpg", 5, "/Storage");
        FileData file5 = new FileData("corrupted.bad", 2, "/Garbage");

        System.out.println("***** add *****");
        navigator.add(file1, "/Storage");
        navigator.add(file2, "/Programs");
        navigator.add(file3, "/Storage");
        navigator.add(file4, "/Storage");
        navigator.add(file5, "/Storage");
        System.out.println(allFiles);

        System.out.println("***** find *****");
        System.out.println(navigator.find("/Programs"));

        System.out.println("***** filterBySize *****");
        System.out.println(navigator.filterBySize(5));

        System.out.println("***** remove *****");
        System.out.println(navigator.remove("/Programs"));

        System.out.println("***** sortBySize *****");
        List<FileData> sortedFiles = navigator.sortBySize();
        System.out.println(sortedFiles);

        // Task #2 tests
        List<String> testStrings = new ArrayList<>(Arrays.asList(
                "Привет", "Мир", "Привет", "!"));
        System.out.println(SetUtils.convertToUnique(testStrings));

        List<Integer> testNumbers = new ArrayList<>(Arrays.asList(
                1, 2, 6, 8, 2, 9, 3, 3, 8, 5, 1, 4, 7
        ));
        System.out.println(SetUtils.getSortedUniqueIntegersASC(testNumbers));
        System.out.println(SetUtils.getSortedUniqueIntegersDESC(testNumbers));

        List<String> moreStrings = new ArrayList<>(Arrays.asList(
                "Привет", "Мир", "Привет", "!", "!"));
        System.out.println(SetUtils.buildSentenceDirection(moreStrings));
    }
}
