package ua.hillel.task12;

import ua.hillel.task12.phonebook.Directory;
import ua.hillel.task12.phonebook.Record;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("cat", "dog", "fox", "rabbit", "dog", "horse", "dog", "dog",
                "rabbit", "cat", "pig", "fox", "bird", "cat", "dog", "rabbit", "fox");
        System.out.println(ListUtils.countOccurrence(wordList, "rabbit"));

        System.out.println(ListUtils.toList(new int[]{1, 2, 3}));

        List<Integer> intList = Arrays.asList(1, 8, 5, 7, 9, 1, 2, 4, 5, 2, 2, 6, 3, 0, 0);
        System.out.println(ListUtils.findUnique(intList)); // = 8, 7, 9, 4, 6, 3

        ListUtils.calcOccurrence(wordList);

        List<String> list = ListUtils.findOccurrence(wordList);
        System.out.println(list);

        Directory directory = new Directory();
        directory.add(new Record("Viktor Kotenko", "0000000000"));
        directory.add(new Record("Viktor Kotenko", "1111111111"));
        directory.add(new Record("Alisa Muravyova", "2222222222"));
        directory.add(new Record("Nina Rogova", "3333333333"));
        directory.add(new Record("Vladymir Alekseev", "4444444444"));
        directory.add(new Record("Vladymir Alekseev", "5555555555"));
        directory.add(new Record("Anastasia Begova", "6666666666"));
        directory.add(new Record("Viktoria Nesterenko", "7777777777"));

        Record record = directory.find("Alisa Muravyova");
        System.out.println(record);

        List<Record> recordList = directory.findAll("Viktor Kotenko");
        for (Record rec : recordList) {
            System.out.println(rec);
        }
    }
}
