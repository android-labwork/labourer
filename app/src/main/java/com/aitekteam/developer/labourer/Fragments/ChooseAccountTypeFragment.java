package com.aitekteam.developer.labourer.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aitekteam.developer.labourer.Handlers.FirebaseHandler;
import com.aitekteam.developer.labourer.Handlers.PagesHandler;
import com.aitekteam.developer.labourer.MainActivity;
import com.aitekteam.developer.labourer.Models.User;
import com.aitekteam.developer.labourer.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class ChooseAccountTypeFragment extends Fragment implements View.OnClickListener, FirebaseHandler.FirebaseHandlerDB {
    private View view;
    private LinearLayout page_registration_account_type_worker,
            page_registration_account_type_employer;
    private FirebaseHandler db;
    private final int UPDATE_USER_AS_WORKER = 0, UPDATE_USER_AS_EMPLOYER = 1;
    private final String TYPE_WORKER = "worker", TYPE_EMPLOYER = "employer";
    private SharedPreferences sharedPref;

    private FirebaseAuth mAuth;

    public static ChooseAccountTypeFragment getInstance() {
        return new ChooseAccountTypeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.component_page, container, false);
        PagesHandler pagesHandler = new PagesHandler(this.view);
        pagesHandler.showPage(R.id.page_registration_account_type);

        this.db = new FirebaseHandler(this);
        this.mAuth = FirebaseAuth.getInstance();

        if (getActivity() != null)
        this.sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);

        this.page_registration_account_type_worker = this.view.findViewById(R.id.page_registration_account_type_worker);
        this.page_registration_account_type_employer = this.view.findViewById(R.id.page_registration_account_type_employer);

        this.page_registration_account_type_worker.setOnClickListener(this);
        this.page_registration_account_type_employer.setOnClickListener(this);

        return this.view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.page_registration_account_type_worker) {
            // Go to Employer
            this.db.create(UPDATE_USER_AS_WORKER);
        }
        else {
            // Go to Worker
            this.db.create(UPDATE_USER_AS_EMPLOYER);
        }
    }

    private void signIn(String email, String password, final int type) {
        if (getActivity() != null)
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                if (user != null) {
                                    Intent intent;
                                    if (type == UPDATE_USER_AS_WORKER) {
                                        intent = new Intent(getContext(), MainActivity.class);
                                        intent.putExtra("account_type", R.string.label_account_type_worker);
                                    }
                                    else {
                                        intent = new Intent(getContext(), MainActivity.class);
                                        intent.putExtra("account_type", R.string.label_account_type_employer);
                                    }
                                    startActivity(intent);
                                }
                                else {
                                    Toast.makeText(getContext(), "Authentication failed. On Your Username And Password",
                                            Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(getContext(), "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
    }

    @Override
    public void create(DatabaseReference db, int validation) {
        String uid = this.sharedPref.getString(getString(R.string.uid), "");
        if (!TextUtils.isEmpty(uid)) {
            if (validation == UPDATE_USER_AS_WORKER) {
                db.child("users").child(uid).child("userRole").setValue(TYPE_WORKER);
            } else {
                db.child("users").child(uid).child("userRole").setValue(TYPE_EMPLOYER);
            }
            this.db.valueEvent(validation);
        }
    }

    @Override
    public ValueEventListener getWithValueEvent(DatabaseReference db, final int validation) {
        String uid = this.sharedPref.getString(getString(R.string.uid), "");
        ValueEventListener getDataUser = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User currentUser = dataSnapshot.getValue(User.class);
                if (currentUser != null)
                signIn(currentUser.getUserEmail(), currentUser.getUserPassword(), validation);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        db.child("users").child(uid).addValueEventListener(getDataUser);

        return getDataUser;
    }

    @Override
    public ChildEventListener getWithChildEvent(DatabaseReference db, int validation) {
        return null;
    }
}
