package ru.job4j.dic.phone;

import android.database.Cursor;
import android.provider.ContactsContract;

public class PhoneStore {
    public static final PhoneStore INST = new PhoneStore();

    public String getNameAndNumber() {
        String text;
        Cursor cursor = PhoneDicFragment.getCursor();
        String name = cursor.getString(cursor.getColumnIndex(
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
        String phone = cursor.getString(cursor.getColumnIndex(
                ContactsContract.CommonDataKinds.Phone.NUMBER));
        text = name + " " + phone;
        return text;
    }

    private PhoneStore() {
    }

    static PhoneStore getPhoneStore() {
        return INST;
    }
}
