package com.aitekteam.developer.labourer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.aitekteam.developer.labourer.Fragments.FindJobFragment;
import com.aitekteam.developer.labourer.Fragments.JobFragment;
import com.aitekteam.developer.labourer.Fragments.NotificationFragment;
import com.aitekteam.developer.labourer.Fragments.ProfileFragment;
import com.aitekteam.developer.labourer.Handlers.MainMenuHandler;
import com.aitekteam.developer.labourer.Models.Achivement;
import com.aitekteam.developer.labourer.Models.ReviewUser;
import com.aitekteam.developer.labourer.Models.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements MainMenuHandler.NavigationItemHandler{

    private BottomNavigationView navigation;
    private MainMenuHandler menuHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.menuHandler = MainMenuHandler.getInstance(this);

        this.navigation = this.findViewById(R.id.navigation);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame, JobFragment.getInstance()).commit();
        this.navigation.setOnNavigationItemSelectedListener(this.menuHandler);
    }

    @Override
    public void itemSelected(MenuItem item, int id) {
        Fragment fragment;
        switch (id) {
            case R.id.action_job:
                fragment = JobFragment.getInstance();
                break;
            case R.id.action_find_job:
                fragment = FindJobFragment.getInstance();
                break;
            case R.id.action_notification:
                fragment = NotificationFragment.getInstance();
                break;
            default:
                fragment = ProfileFragment.getInstance();
                break;
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame, fragment).commit();
    }
}
