package com.aitekteam.developer.labourer.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aitekteam.developer.labourer.Handlers.CacheHandler;
import com.aitekteam.developer.labourer.Handlers.FirebaseHandler;
import com.aitekteam.developer.labourer.Handlers.PagesHandler;
import com.aitekteam.developer.labourer.MainActivity;
import com.aitekteam.developer.labourer.Models.User;
import com.aitekteam.developer.labourer.PortalActivity;
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

public class LoginFragment extends Fragment implements View.OnClickListener, FirebaseHandler.FirebaseHandlerDB {
    private View view;
    private TextView page_login_registration;
    private Button page_login_save;
    private EditText page_login_email, page_login_password;
    private FirebaseHandler db;
    private final int ALREADY_LOGIN = 0, NOT_ALREADY_LOGIN = 1;
    private final String TYPE_WORKER = "worker", TYPE_EMPLOYER = "employer";
    private CacheHandler cache;
    private FirebaseAuth mAuth;

    public static LoginFragment getInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.component_page, container, false);
        PagesHandler pagesHandler = new PagesHandler(this.view);
        pagesHandler.showPage(R.id.page_login);

        this.db = new FirebaseHandler(this);
        mAuth = FirebaseAuth.getInstance();

        this.cache = new CacheHandler(getContext());

        this.page_login_registration = this.view.findViewById(R.id.page_login_registration);
        this.page_login_save = this.view.findViewById(R.id.page_login_save);
        this.page_login_email = this.view.findViewById(R.id.page_login_email);
        this.page_login_password = this.view.findViewById(R.id.page_login_password);
        this.page_login_registration.setOnClickListener(this);
        this.page_login_save.setOnClickListener(this);

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
            signIn(
                    page_login_email.getText().toString(),
                    page_login_password.getText().toString()
            );
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            this.cache = new CacheHandler(getContext());
            this.db = new FirebaseHandler(this);
            this.db.valueEvent(ALREADY_LOGIN);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public void create(DatabaseReference db, int validation) {

    }

    private void signIn(String email, String password) {
        if (getActivity() != null)
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user != null) {
                                db.valueEvent(NOT_ALREADY_LOGIN);
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

    private void successLogin(String type) {
        Intent intent;
        if (type.equalsIgnoreCase(TYPE_WORKER)) {
            intent = new Intent(getContext(), MainActivity.class);
            intent.putExtra("account_type", R.string.label_account_type_worker);
        }
        else {
            intent = new Intent(getContext(), MainActivity.class);
            intent.putExtra("account_type", R.string.label_account_type_employer);
        }
        startActivity(intent);
    }

    @Override
    public ValueEventListener getWithValueEvent(DatabaseReference db, int validation) {
        if (validation == ALREADY_LOGIN) {
            String uid = this.cache.read();
            Log.d("USERID", uid);
            ValueEventListener getDataUser = new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    User currentUser = dataSnapshot.getValue(User.class);
                    if (currentUser != null)
                        successLogin(currentUser.getUserRole());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            };
            db.child("users").child(uid).addValueEventListener(getDataUser);
        }
        else {
            final ValueEventListener getDataUser = new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getChildrenCount() > 0) {
                        dataSnapshot = dataSnapshot.getChildren().iterator().next();
                        User currentUser = dataSnapshot.getValue(User.class);
                        if (currentUser != null) {
                            try {
                                cache.write(currentUser.getUserId());
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                successLogin(currentUser.getUserRole());
                            }
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            };
            db.child("users").orderByChild("userEmail").equalTo(page_login_email.getText().toString())
                .addValueEventListener(getDataUser);
        }
        return null;
    }

    @Override
    public ChildEventListener getWithChildEvent(DatabaseReference db, int validation) {
        return null;
    }
}
