package com.aitekteam.developer.labourer.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aitekteam.developer.labourer.Handlers.PagesHandler;
import com.aitekteam.developer.labourer.PortalActivity;
import com.aitekteam.developer.labourer.R;

public class SplashScreenFragment extends Fragment {
    private View view;
    private boolean _active = true;
    private int _splashTime = 3000;

    public static SplashScreenFragment getInstance() {
        return new SplashScreenFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.component_page, container, false);
        PagesHandler pagesHandler = new PagesHandler(this.view);
        pagesHandler.showPage(R.id.page_splash_screen);

        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (_active && (waited < _splashTime)) {
                        sleep(100);
                        if (_active) {
                            waited += 100;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (((PortalActivity) getActivity()) != null)
                        ((PortalActivity) getActivity()).setUpPortal(LoginFragment.getInstance());
                }
            };
        };
        splashTread.start();

        return this.view;
    }
}
