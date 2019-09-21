package com.aitekteam.developer.labourer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.aitekteam.developer.labourer.Fragment.FindJobFragment;
import com.aitekteam.developer.labourer.Fragment.JobFragment;
import com.aitekteam.developer.labourer.Fragment.NotificationFragment;
import com.aitekteam.developer.labourer.Fragment.ProfileFragment;
import com.aitekteam.developer.labourer.Handlers.MainMenuHandler;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements MainMenuHandler.NavigationItemHandler{

    private BottomNavigationView navigation;
    private MainMenuHandler menuHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.menuHandler = MainMenuHandler.getInstance(this);

        this.navigation = this.findViewById(R.id.navigation);
        this.navigation.setOnNavigationItemSelectedListener(this.menuHandler);
    }

    @Override
    public void itemSelected(MenuItem item, int id) {
        Fragment fragment;
        switch (id) {
            case R.id.action_job:
                fragment = new JobFragment();
                break;
            case R.id.action_find_job:
                fragment = new FindJobFragment();
                break;
            case R.id.action_notification:
                fragment = new NotificationFragment();
                break;
            default:
                fragment = new ProfileFragment();
                break;
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame, fragment).commit();
    }
}
