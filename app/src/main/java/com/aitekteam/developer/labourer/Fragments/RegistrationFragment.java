package com.aitekteam.developer.labourer.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aitekteam.developer.labourer.Handlers.PagesHandler;
import com.aitekteam.developer.labourer.PortalActivity;
import com.aitekteam.developer.labourer.R;

public class RegistrationFragment extends Fragment implements View.OnClickListener {
    private View view;
    private Button page_registration_save;

    public static RegistrationFragment getInstance() {
        return new RegistrationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.component_page, container, false);
        PagesHandler pagesHandler = new PagesHandler(this.view);
        pagesHandler.showPage(R.id.page_registration);

        this.page_registration_save = this.view.findViewById(R.id.page_registration_save);
        this.page_registration_save.setOnClickListener(this);

        return this.view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.page_registration_save) {
            // Do Save Data
            try {
                // TO DO Magic
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (((PortalActivity) getActivity()) != null)
                    ((PortalActivity) getActivity()).setUpPortal(ChooseAccountTypeFragment.getInstance());
            }
        }
    }
}
