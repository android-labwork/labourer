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

import com.aitekteam.developer.labourer.Adapters.LevelAdapter;
import com.aitekteam.developer.labourer.Handlers.PagesHandler;
import com.aitekteam.developer.labourer.Models.LevelModel;
import com.aitekteam.developer.labourer.R;

import java.util.ArrayList;

public class LevelFragment extends Fragment {
    private RecyclerView main_list;
    private LevelAdapter adapter;
    private View view;
    private ArrayList<LevelModel> data_set;

    public static LevelFragment getInstance() {
        return new LevelFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.component_page, container, false);
        PagesHandler pagesHandler = new PagesHandler(this.view);
        pagesHandler.showPage(R.id.page_level);

        this.main_list = this.view.findViewById(R.id.page_level_list);
        this.main_list.setHasFixedSize(true);
        this.main_list.setLayoutManager(new LinearLayoutManager(this.getContext()));
        this.data_set = new ArrayList<>();
        this.insertDataSet();
        this.adapter = new LevelAdapter(this.data_set);
        this.main_list.setAdapter(this.adapter);

        return this.view;
    }

    private void insertDataSet() {
        this.data_set.add(new LevelModel("Cat Atap Rumah", "Sukabirus", 100, 0, 0, 0));
        this.data_set.add(new LevelModel("Cat Dinding Rumah", "Sukapura", 125, 0, 0, 0));
        this.data_set.add(new LevelModel("Cat Atap Rumah", "Babakan Ciamis", 50, 0, 0, 0));
    }
}
