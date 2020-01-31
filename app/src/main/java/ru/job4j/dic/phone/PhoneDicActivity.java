package ru.job4j.dic.phone;

import androidx.fragment.app.Fragment;

public class PhoneDicActivity extends BaseActivity {

    @Override
    public Fragment loadFrg() {
        return new PhoneDicFragment();
    }
}
