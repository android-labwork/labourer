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

import com.aitekteam.developer.labourer.Adapters.ProfilePageContentAdapter;
import com.aitekteam.developer.labourer.Handlers.PagesHandler;
import com.aitekteam.developer.labourer.Models.PageContentModel;
import com.aitekteam.developer.labourer.R;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {
    private RecyclerView page_profile_content;
    private View view;
    private ArrayList<PageContentModel> data_set;
    private ProfilePageContentAdapter adapter;

    public static ProfileFragment getInstance() {
        return new ProfileFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.component_page, container, false);
        PagesHandler pagesHandler = new PagesHandler(this.view);
        pagesHandler.showPage(R.id.page_profile_worker);
        this.page_profile_content = this.view.findViewById(R.id.page_profile_content);
        this.page_profile_content.setHasFixedSize(true);
        this.page_profile_content.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        this.data_set = new ArrayList<>();
        this.insertDataSet();
        this.adapter = new ProfilePageContentAdapter(this.data_set, new ProfilePageContentAdapter.PageContentSelectedHandler() {
            @Override
            public void onSelectedItem(PageContentModel item, int position) {

            }
        });
        this.page_profile_content.setAdapter(this.adapter);

        return this.view;
    }

    private void insertDataSet() {
        this.data_set.add(new PageContentModel(R.drawable.ic_level_40, 0, "Level 1", "exp"));
        this.data_set.add(new PageContentModel(R.drawable.ic_achievement_40, 0, "Pencapaian", "pencapaian"));
        this.data_set.add(new PageContentModel(R.drawable.ic_skill_40, 0, "Keahlian", "keahlian"));
        this.data_set.add(new PageContentModel(R.drawable.ic_review_40, 0, "Ulasan", "ulasan"));
    }
}
