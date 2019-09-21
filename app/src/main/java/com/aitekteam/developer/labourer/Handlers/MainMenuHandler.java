package com.aitekteam.developer.labourer.Handlers;

import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainMenuHandler implements BottomNavigationView.OnNavigationItemSelectedListener {

    private NavigationItemHandler handler;

    public static MainMenuHandler getInstance(NavigationItemHandler handler) {
        return new MainMenuHandler(handler);
    }

    public MainMenuHandler(NavigationItemHandler handler) {
        this.handler = handler;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        this.handler.itemSelected(item, item.getItemId());
        return true;
    }

    public interface NavigationItemHandler {
        void itemSelected(MenuItem item, int id);
    }
}
