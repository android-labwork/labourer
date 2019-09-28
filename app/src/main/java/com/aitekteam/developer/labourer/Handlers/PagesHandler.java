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
        this.items.add(R.id.page_profile);
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
