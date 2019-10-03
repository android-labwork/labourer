package com.aitekteam.developer.labourer.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aitekteam.developer.labourer.Handlers.CacheHandler;
import com.aitekteam.developer.labourer.Handlers.FirebaseHandler;
import com.aitekteam.developer.labourer.Handlers.PagesHandler;
import com.aitekteam.developer.labourer.Models.User;
import com.aitekteam.developer.labourer.PortalActivity;
import com.aitekteam.developer.labourer.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class RegistrationFragment extends Fragment implements View.OnClickListener, FirebaseHandler.FirebaseHandlerDB {
    private View view;
    private Button page_registration_save;
    private EditText page_registration_full_name, page_registration_nik, page_registration_email, page_registration_password;
    private FirebaseHandler db;
    private final int CREATE_USER = 0;
    private CacheHandler cache;

    public static RegistrationFragment getInstance() {
        return new RegistrationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.component_page, container, false);
        PagesHandler pagesHandler = new PagesHandler(this.view);
        pagesHandler.showPage(R.id.page_registration);
        this.db = new FirebaseHandler(this);

        this.cache = new CacheHandler(getContext());

        this.page_registration_save = this.view.findViewById(R.id.page_registration_save);
        this.page_registration_full_name = this.view.findViewById(R.id.page_registration_full_name);
        this.page_registration_nik = this.view.findViewById(R.id.page_registration_nik);
        this.page_registration_email = this.view.findViewById(R.id.page_registration_email);
        this.page_registration_password = this.view.findViewById(R.id.page_registration_password);
        this.page_registration_save.setOnClickListener(this);

        return this.view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.page_registration_save) {
            // Do Save Data
            this.db.create(CREATE_USER);
        }
    }

    @Override
    public void create(DatabaseReference db, int validation) {
        if (validation == CREATE_USER) {
            String uid = db.child("users").push().getKey();
            User newUser = new User(
                    uid,
                    page_registration_full_name.getText().toString(),
                    page_registration_nik.getText().toString(),
                    "https://cdn1.iconfinder.com/data/icons/flat-character-color-1/60/flat-design-character_3-512.png",
                    page_registration_email.getText().toString(),
                    page_registration_password.getText().toString(),
                    "",
                    "",
                    "",
                    "",
                    0
            );
            if (uid != null)
                db.child("users").child(uid).setValue(newUser);

            try {
                cache.write(uid);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (((PortalActivity) getActivity()) != null)
                    ((PortalActivity) getActivity()).setUpPortal(ChooseAccountTypeFragment.getInstance());
            }
        }
    }

    @Override
    public ValueEventListener getWithValueEvent(DatabaseReference db, int validation) {
        return null;
    }

    @Override
    public ChildEventListener getWithChildEvent(DatabaseReference db, int validation) {
        return null;
    }
}
