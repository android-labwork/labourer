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

import com.aitekteam.developer.labourer.Adapters.ReviewAdapter;
import com.aitekteam.developer.labourer.Handlers.PagesHandler;
import com.aitekteam.developer.labourer.Models.ReviewModel;
import com.aitekteam.developer.labourer.R;

import java.util.ArrayList;

public class ReviewFragment extends Fragment {
    private RecyclerView main_list;
    private ReviewAdapter adapter;
    private View view;
    private ArrayList<ReviewModel> data_set;

    public static ReviewFragment getInstance() {
        return new ReviewFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.component_page, container, false);
        PagesHandler pagesHandler = new PagesHandler(this.view);
        pagesHandler.showPage(R.id.page_review);

        this.main_list = this.view.findViewById(R.id.page_review_list);
        this.main_list.setHasFixedSize(true);
        this.main_list.setLayoutManager(new LinearLayoutManager(this.getContext()));
        this.data_set = new ArrayList<>();
        this.insertDataSet();
        this.adapter = new ReviewAdapter(this.data_set);
        this.main_list.setAdapter(this.adapter);

        return this.view;
    }

    private void insertDataSet() {
        this.data_set.add(new ReviewModel("Joko Wi", "Cara mengecatnya rapi", 5, 0));
        this.data_set.add(new ReviewModel("Jane Wi", "Cara mengecatnya bagus", 4, 0));
        this.data_set.add(new ReviewModel("Tina Tut", "Peralatan lengkap", 3, 0));
    }
}
