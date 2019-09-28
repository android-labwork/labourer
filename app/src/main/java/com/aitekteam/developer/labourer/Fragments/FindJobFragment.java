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

import com.aitekteam.developer.labourer.Adapters.FindJobAdapter;
import com.aitekteam.developer.labourer.Models.JobModel;
import com.aitekteam.developer.labourer.R;

import java.util.ArrayList;

public class FindJobFragment extends Fragment {

    private RecyclerView main_list;
    private FindJobAdapter adapter;
    private View view;
    private ArrayList<JobModel> data_set;

    public static FindJobFragment getInstance() {
        return new FindJobFragment();
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
        this.adapter = new FindJobAdapter(this.data_set, new FindJobAdapter.JobSelectedHandler() {
            @Override
            public void onSelectedItem(JobModel item, int position) {

            }
        });
        this.main_list.setAdapter(this.adapter);

        return view;
    }

    private void insertDataSet() {
        this.data_set.add(new JobModel(new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
                "Cat Dinding Rumah", "Saya punya dinding rumah perlu di cat, please.", "Sukapura",
                5, 1, 200, 1, 1, 0, 0));
        this.data_set.add(new JobModel(new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
                "Renovasi Atap Rumah", "Saya punya atap rumah perlu di renovasi, please.", "Sukapura",
                5, 1, 200, 2, 2,0, 0));
        this.data_set.add(new JobModel(new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
                "Cat Pagar Rumah", "Saya punya pagar rumah perlu di cat, please.", "Sukapura",
                5, 1, 200, 3, 1,0, 0));
        this.data_set.add(new JobModel(new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
                "Cat Atap Rumah", "Saya punya atap rumah perlu di cat, please.", "Sukapura",
                5, 1, 200, 4, 1,0, 0));
        this.data_set.add(new JobModel(new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
                "Cat Atap Masjid", "Saya punya atap rumah perlu di cat, please.", "Sukapura",
                5, 1, 200, 5, 1,0, 0));
    }
}
