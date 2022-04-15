package ua.hillel.task12.phonebook;

public class Record {
    private final String name;
    private final String phoneNumber;

    public String getName() {
        return name;
    }

    public Record(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return name + ": " + phoneNumber;
    }
}
