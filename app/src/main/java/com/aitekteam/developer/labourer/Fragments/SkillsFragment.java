package com.aitekteam.developer.labourer.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aitekteam.developer.labourer.Adapters.SkillsAdapter;
import com.aitekteam.developer.labourer.Handlers.PagesHandler;
import com.aitekteam.developer.labourer.Models.SkillsModel;
import com.aitekteam.developer.labourer.R;

import java.util.ArrayList;

public class SkillsFragment extends Fragment {
    private RecyclerView main_list;
    private SkillsAdapter adapter;
    private View view;
    private ArrayList<SkillsModel> data_set;

    public static SkillsFragment getInstance() {
        return new SkillsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.component_page, container, false);
        PagesHandler pagesHandler = new PagesHandler(this.view);
        pagesHandler.showPage(R.id.page_skill);

        this.main_list = this.view.findViewById(R.id.page_skill_list);
        this.main_list.setHasFixedSize(true);
        this.main_list.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        this.data_set = new ArrayList<>();
        this.insertDataSet();
        this.adapter = new SkillsAdapter(this.data_set);
        this.main_list.setAdapter(this.adapter);

        return this.view;
    }

    private void insertDataSet() {
        this.data_set.add(new SkillsModel("Mengecat", 2, 450, 0, 0));
        this.data_set.add(new SkillsModel("Renovasi", 0, 0, 0, 0));
    }
}
