package com.aitekteam.developer.labourer.Fragments;

import android.content.Intent;
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
import com.aitekteam.developer.labourer.DetailActivity;
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
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra("data_object", item);
                intent.putExtra("title", getResources().getString(R.string.job_detail_app));
                intent.putExtra("fragment", R.string.job_detail_fragment);
                startActivity(intent);
            }
        });
        this.main_list.setAdapter(this.adapter);

        return view;
    }

    private void insertDataSet() {

    }
}
