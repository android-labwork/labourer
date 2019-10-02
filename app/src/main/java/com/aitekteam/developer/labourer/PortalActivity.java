package com.aitekteam.developer.labourer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.aitekteam.developer.labourer.Fragments.SplashScreenFragment;

public class PortalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal);
        setTheme(R.style.AppTheme);

        setUpPortal(SplashScreenFragment.getInstance());
    }

    public void setUpPortal(Fragment fragmentClass) {
        Fragment fragment = null;
        try {
            fragment = fragmentClass;
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_frame, fragment)
                .commit();
    }
}
