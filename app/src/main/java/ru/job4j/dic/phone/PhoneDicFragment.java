package ru.job4j.dic.phone;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PhoneDicFragment extends Fragment {
    private RecyclerView recycler;
    private RecyclerView.Adapter<RecyclerView.ViewHolder> adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.phones, container, false);
        recycler = view.findViewById(R.id.phones);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<String> phones = new ArrayList<>();
        adapter = new PhoneAdapter(phones);
        recycler.setAdapter(adapter);
        PhoneStore.loadDic(getActivity(), phones, adapter);
        return view;
    }

    public static final class PhoneAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private final List<String> phones;

        PhoneAdapter(List<String> phones) {
            this.phones = phones;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new RecyclerView.ViewHolder(LayoutInflater.from(
                    parent.getContext()).inflate(R.layout.phone, parent, false)) {
            };
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            TextView text = holder.itemView.findViewById(R.id.name);
            text.setText(phones.get(position));
        }

        @Override
        public int getItemCount() {
            return phones.size();
        }
    }
}
