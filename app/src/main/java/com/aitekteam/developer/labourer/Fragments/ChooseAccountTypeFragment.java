package com.aitekteam.developer.labourer.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aitekteam.developer.labourer.Handlers.PagesHandler;
import com.aitekteam.developer.labourer.MainActivity;
import com.aitekteam.developer.labourer.R;

public class ChooseAccountTypeFragment extends Fragment implements View.OnClickListener {
    private View view;
    private LinearLayout page_registration_account_type_worker,
            page_registration_account_type_employer;

    public static ChooseAccountTypeFragment getInstance() {
        return new ChooseAccountTypeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.component_page, container, false);
        PagesHandler pagesHandler = new PagesHandler(this.view);
        pagesHandler.showPage(R.id.page_registration_account_type);

        this.page_registration_account_type_worker = this.view.findViewById(R.id.page_registration_account_type_worker);
        this.page_registration_account_type_employer = this.view.findViewById(R.id.page_registration_account_type_employer);

        this.page_registration_account_type_worker.setOnClickListener(this);
        this.page_registration_account_type_employer.setOnClickListener(this);

        return this.view;
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        if (view.getId() == R.id.page_registration_account_type_worker) {
            // Go to Employer
            intent = new Intent(getContext(), MainActivity.class);
            intent.putExtra("account_type", R.string.label_account_type_worker);
        }
        else {
            // Go to Worker
            intent = new Intent(getContext(), MainActivity.class);
            intent.putExtra("account_type", R.string.label_account_type_employer);
        }
        startActivity(intent);
    }
}
