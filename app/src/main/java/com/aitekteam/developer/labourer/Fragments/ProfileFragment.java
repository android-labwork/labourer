package com.aitekteam.developer.labourer.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aitekteam.developer.labourer.Adapters.ProfilePageContentAdapter;
import com.aitekteam.developer.labourer.DetailActivity;
import com.aitekteam.developer.labourer.Handlers.PagesHandler;
import com.aitekteam.developer.labourer.Models.PageContentModel;
import com.aitekteam.developer.labourer.R;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {
    private RecyclerView page_profile_content;
    private View view;
    private ArrayList<PageContentModel> data_set;
    private ProfilePageContentAdapter adapter;
    private ImageView page_setting_button;

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
        this.page_setting_button = this.view.findViewById(R.id.page_setting_button);
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

        this.page_setting_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra("data_object", data_set.get(0));
                intent.putExtra("title", getResources().getString(R.string.edit_profile_app));
                intent.putExtra("fragment", R.string.edit_profile_fragment);
                startActivity(intent);
            }
        });

        return this.view;
    }

    private void insertDataSet() {
        this.data_set.add(new PageContentModel(R.drawable.ic_level_40, 0, "Level 1", "exp"));
        this.data_set.add(new PageContentModel(R.drawable.ic_achievement_40, 0, "Pencapaian", "pencapaian"));
        this.data_set.add(new PageContentModel(R.drawable.ic_skill_40, 0, "Keahlian", "keahlian"));
        this.data_set.add(new PageContentModel(R.drawable.ic_review_40, 0, "Ulasan", "ulasan"));
    }
}
