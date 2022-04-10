package ua.hillel.task12.phonebook;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    private final List<Record> recordList = new ArrayList<>();

    public void add(Record record) {
        recordList.add(record);
    }

    public Record find(String search) {
        for (Record record : recordList) {
            if (record.getName().equals(search)) return record;
        }
        return null;
    }

    public List<Record> findAll(String search) {
        List<Record> list = new ArrayList<>();
        for (Record record : recordList) {
            if (record.getName().equals(search)) {
                list.add(record);
            }
        }
        return list;
    }
}
