package com.aitekteam.developer.labourer.Handlers;

import android.view.View;
import android.widget.RelativeLayout;

import com.aitekteam.developer.labourer.R;

import java.util.ArrayList;

public class PagesHandler {
    private View view;
    private ArrayList<Integer> items;
    private ArrayList<RelativeLayout> pages;

    public PagesHandler(View view) {
        this.view = view;
        this.items = new ArrayList<>();
        this.pages = new ArrayList<>();
        this.listPage();
        this.setPages();
        this.hidePages();
    }

    private void listPage() {
        this.items.add(R.id.page_splash_screen);
        this.items.add(R.id.page_login);
        this.items.add(R.id.page_registration);
        this.items.add(R.id.page_registration_account_type);

        this.items.add(R.id.page_profile_worker);
        this.items.add(R.id.page_edit_profile);
        this.items.add(R.id.page_job_detail);
        this.items.add(R.id.page_level);
        this.items.add(R.id.page_achievement);
        this.items.add(R.id.page_skill);
        this.items.add(R.id.page_review);

        this.items.add(R.id.page_job_employer);
        this.items.add(R.id.page_create_job);
        this.items.add(R.id.page_profile_employer);
    }

    private void setPages() {
        for(int item: this.items) {
            this.pages.add((RelativeLayout) this.view.findViewById(item));
        }
    }

    private void hidePages() {
        for(RelativeLayout item: this.pages) {
            item.setVisibility(View.GONE);
        }
    }

    public void showPage(int id) {
        int position = this.items.indexOf(id);
        this.pages.get(position).setVisibility(View.VISIBLE);
    }
}
