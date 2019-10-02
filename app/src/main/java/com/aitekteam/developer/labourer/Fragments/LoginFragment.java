package com.aitekteam.developer.labourer.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aitekteam.developer.labourer.Handlers.PagesHandler;
import com.aitekteam.developer.labourer.PortalActivity;
import com.aitekteam.developer.labourer.R;

public class LoginFragment extends Fragment implements View.OnClickListener {
    private View view;
    private TextView page_login_registration;

    public static LoginFragment getInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.component_page, container, false);
        PagesHandler pagesHandler = new PagesHandler(this.view);
        pagesHandler.showPage(R.id.page_login);

        this.page_login_registration = this.view.findViewById(R.id.page_login_registration);
        this.page_login_registration.setOnClickListener(this);

        return this.view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.page_login_registration) {
            // Go to Registration
            try {
                // TO DO Magic
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (((PortalActivity) getActivity()) != null)
                    ((PortalActivity) getActivity()).setUpPortal(RegistrationFragment.getInstance());
            }
        }
        else {
            // Do Login
        }
    }
}
