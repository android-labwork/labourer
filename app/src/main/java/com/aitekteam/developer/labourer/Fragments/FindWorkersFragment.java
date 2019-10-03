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

import com.aitekteam.developer.labourer.Adapters.FindWorkersAdapter;
import com.aitekteam.developer.labourer.Models.WorkerModel;
import com.aitekteam.developer.labourer.R;

import java.util.ArrayList;

public class FindWorkersFragment extends Fragment {
    private View view;
    private ArrayList<WorkerModel> data_set;
    private RecyclerView main_list;
    private FindWorkersAdapter adapter;

    public static FindWorkersFragment getInstance() {
        return new FindWorkersFragment();
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
        this.adapter = new FindWorkersAdapter(this.data_set, new FindWorkersAdapter.WorkerSelectedHandler() {
            @Override
            public void onSelectedItem(WorkerModel item, int position) {

            }
        });
        this.main_list.setAdapter(this.adapter);

        return this.view;
    }

    private void insertDataSet() {
        ArrayList<String> skills = new ArrayList<>();
        skills.add("Renovasi");
        skills.add("Mengecat");
        this.data_set.add(new WorkerModel(null, "John Wi", skills, 5));
        this.data_set.add(new WorkerModel(null, "Jane Wi", skills, 4));
        this.data_set.add(new WorkerModel(null, "Joko Wi", skills, 3));
    }
}
