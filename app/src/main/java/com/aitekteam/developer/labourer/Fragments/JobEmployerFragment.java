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

import com.aitekteam.developer.labourer.Adapters.JobAdapter;
import com.aitekteam.developer.labourer.DetailActivity;
import com.aitekteam.developer.labourer.Handlers.PagesHandler;
import com.aitekteam.developer.labourer.Models.JobModel;
import com.aitekteam.developer.labourer.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class JobEmployerFragment extends Fragment {
    private View view;
    private RecyclerView main_list;
    private JobAdapter adapter;
    private FloatingActionButton page_job_employer_create;
    private ArrayList<JobModel> data_set;

    public static JobEmployerFragment getInstance() {
        return new JobEmployerFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.component_page, container, false);
        PagesHandler pagesHandler = new PagesHandler(this.view);
        pagesHandler.showPage(R.id.page_job_employer);

        this.main_list = this.view.findViewById(R.id.main_list);
        this.page_job_employer_create = this.view.findViewById(R.id.page_job_employer_create);
        this.main_list.setHasFixedSize(true);
        this.main_list.setLayoutManager(new LinearLayoutManager(this.getContext()));
        this.data_set = new ArrayList<>();
        this.insertDataSet();
        this.adapter = new JobAdapter(this.data_set, new JobAdapter.JobSelectedHandler() {
            @Override
            public void onSelectedItem(JobModel item, int position) {
            }
        });
        this.main_list.setAdapter(this.adapter);
        this.page_job_employer_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra("data_object", data_set.get(0));
                intent.putExtra("title", getResources().getString(R.string.create_job_app));
                intent.putExtra("fragment", R.string.create_job_fragment);
                startActivity(intent);
            }
        });

        return this.view;
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