package ru.job4j.dic.phone;

import java.util.ArrayList;
import java.util.List;

public class PhoneStore {
    public static final PhoneStore INST = new PhoneStore();
    private final List<String> phones = new ArrayList<>();

    private PhoneStore() {
    }

    static PhoneStore getPhoneStore() {
        return INST;
    }

    void add(String text) {
        this.phones.add(text);
    }

    void set(int index, String text) {
        this.phones.set(index, text);
    }

    List<String> getAll() {
        return this.phones;
    }

    int size() {
        return phones.size();
    }

    String get(int index) {
        return phones.get(index);
    }
}
