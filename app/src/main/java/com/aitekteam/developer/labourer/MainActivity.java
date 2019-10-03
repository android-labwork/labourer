package com.aitekteam.developer.labourer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.aitekteam.developer.labourer.Fragments.FindJobFragment;
import com.aitekteam.developer.labourer.Fragments.FindWorkersFragment;
import com.aitekteam.developer.labourer.Fragments.JobEmployerFragment;
import com.aitekteam.developer.labourer.Fragments.JobFragment;
import com.aitekteam.developer.labourer.Fragments.NotificationFragment;
import com.aitekteam.developer.labourer.Fragments.ProfileEmployerFragment;
import com.aitekteam.developer.labourer.Fragments.ProfileFragment;
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

        if (getIntent().getExtras() != null) {
            int target = getIntent().getIntExtra("account_type", 0);
            if (target == R.string.label_account_type_worker) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_frame, JobFragment.getInstance()).commit();
            }
            else {
                this.navigation.getMenu().clear();
                this.navigation.inflateMenu(R.menu.main_menu_employer);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_frame, JobEmployerFragment.getInstance()).commit();
            }
        }

        this.navigation.setOnNavigationItemSelectedListener(this.menuHandler);
    }

    @Override
    public void itemSelected(MenuItem item, int id) {
        if (getIntent().getExtras() != null) {
            Fragment fragment;
            int target = getIntent().getIntExtra("account_type", 0);
            if (target == R.string.label_account_type_worker) {
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
            }
            else {
                switch (id) {
                    case R.id.action_job_employer:
                        fragment = JobEmployerFragment.getInstance();
                        break;
                    case R.id.action_find_job_employer:
                        fragment = FindWorkersFragment.getInstance();
                        break;
                    case R.id.action_notification_employer:
                        fragment = NotificationFragment.getInstance();
                        break;
                    default:
                        fragment = ProfileEmployerFragment.getInstance();
                        break;
                }
            }
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_frame, fragment).commit();
        }
    }
}
