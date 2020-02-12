package ru.job4j.dic.phone;

import android.app.Activity;
import android.database.Cursor;
import android.provider.ContactsContract;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class PhoneStore {
    private static final PhoneStore INST = new PhoneStore();
    private static Cursor cursor;

    static void loadDic(Activity activity, List<String> phones,
                 RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        String by = "va";
        cursor = activity.getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                        ContactsContract.CommonDataKinds.Phone.NUMBER},
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " like '%" + by + "%'",
                null, null);
        try {
            while (cursor.moveToNext()) {
                phones.add(PhoneStore.getPhoneStore().getNameAndNumber());
            }
            adapter.notifyDataSetChanged();
        } finally {
            cursor.close();
        }
    }

    private String getNameAndNumber() {
        String text;
        String name = cursor.getString(cursor.getColumnIndex(
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
        String phone = cursor.getString(cursor.getColumnIndex(
                ContactsContract.CommonDataKinds.Phone.NUMBER));
        text = name + " " + phone;
        return text;
    }

    private PhoneStore() {
    }

    private static PhoneStore getPhoneStore() {
        return INST;
    }
}
