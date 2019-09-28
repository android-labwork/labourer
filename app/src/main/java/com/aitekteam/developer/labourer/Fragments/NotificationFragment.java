package com.aitekteam.developer.labourer.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aitekteam.developer.labourer.Adapters.NotificationAdapter;
import com.aitekteam.developer.labourer.Models.NotificationModel;
import com.aitekteam.developer.labourer.R;

import java.util.ArrayList;

public class NotificationFragment extends Fragment {

    private RecyclerView main_list;
    private NotificationAdapter adapter;
    private View view;
    private ArrayList<NotificationModel> data_set;

    public static NotificationFragment getInstance() {
        return new NotificationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.component_list, container, false);

        this.main_list = this.view.findViewById(R.id.main_list);
        this.main_list.setHasFixedSize(true);
        this.main_list.setLayoutManager(new LinearLayoutManager(this.getContext()));
        this.data_set = new ArrayList<>();
        this.insertDataSet();
        this.adapter = new NotificationAdapter(this.data_set, new NotificationAdapter.NotificationSelectedHandler() {
            @Override
            public void onSelectedItem(NotificationModel item, int position) {

            }
        });
        this.main_list.setAdapter(this.adapter);
        return this.view;
    }

    private void insertDataSet() {
        this.data_set.add(new NotificationModel("", "",
                "Menerima Lamaran Anda", "John Wi", "", 0,
                0));
        this.data_set.add(new NotificationModel("", "",
                "Tidak Menerima Lamaran Anda", "John Wi", "", 1,
                0));
    }
}
