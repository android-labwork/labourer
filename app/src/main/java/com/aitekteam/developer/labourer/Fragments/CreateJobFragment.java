package com.aitekteam.developer.labourer.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aitekteam.developer.labourer.Handlers.FirebaseHandler;
import com.aitekteam.developer.labourer.Handlers.PagesHandler;
import com.aitekteam.developer.labourer.Models.JobModel;
import com.aitekteam.developer.labourer.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

public class CreateJobFragment extends Fragment implements View.OnClickListener, FirebaseHandler.FirebaseHandlerDB {
    private View view;
    private FirebaseHandler db;
    private SharedPreferences sharedPref;
    private EditText page_create_job_title,
            page_create_job_description,
            page_create_job_min_price,
            page_create_job_max_price,
            page_create_job_benefit,
            page_create_job_duration_of_work,
            page_create_job_count_of_work;
    private TextView
            page_create_job_location,
            page_create_job_change_images;
    private ImageView
            page_create_job_images;
    private Button
            page_create_job_find_location,
            page_create_job_save;
    private final int CREATE_JOB = 0;
    private
    LocationManager locationManager;
    private
    LocationListener locationListener;
    private
        String uid;

    public static CreateJobFragment getInstance() {
        return new CreateJobFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.component_page, container, false);
        PagesHandler pagesHandler = new PagesHandler(this.view);
        pagesHandler.showPage(R.id.page_create_job);

        this.db = new FirebaseHandler(this);

        if (getActivity() != null) {
            this.sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
            uid = this.sharedPref.getString(getString(R.string.uid), "");
        }

        this.page_create_job_title = this.view.findViewById(R.id.page_create_job_title);
        this.page_create_job_description = this.view.findViewById(R.id.page_create_job_description);
        this.page_create_job_min_price = this.view.findViewById(R.id.page_create_job_min_price);
        this.page_create_job_max_price = this.view.findViewById(R.id.page_create_job_max_price);
        this.page_create_job_benefit = this.view.findViewById(R.id.page_create_job_benefit);
        this.page_create_job_duration_of_work = this.view.findViewById(R.id.page_create_job_duration_of_work);
        this.page_create_job_count_of_work = this.view.findViewById(R.id.page_create_job_count_of_work);
        this.page_create_job_location = this.view.findViewById(R.id.page_create_job_location);
        this.page_create_job_change_images = this.view.findViewById(R.id.page_create_job_change_images);
        this.page_create_job_images = this.view.findViewById(R.id.page_create_job_images);
        this.page_create_job_find_location = this.view.findViewById(R.id.page_create_job_find_location);
        this.page_create_job_save = this.view.findViewById(R.id.page_create_job_save);

        this.page_create_job_save.setOnClickListener(this);

        return this.view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.page_create_job_save) {
            this.db.create(CREATE_JOB);
        }
    }

    @Override
    public void create(DatabaseReference db, int validation) {
        if (validation == CREATE_JOB) {
            ArrayList<String> photos = new ArrayList<>();
            ArrayList<String> benefit = new ArrayList<>();
            benefit.addAll(Arrays.asList(page_create_job_benefit.getText().toString().split(",")));
            photos.add("https://firebasestorage.googleapis.com/v0/b/labourer-51d5e.appspot.com/o/slider.png?alt=media&token=b4deaa5f-0620-4de1-8735-25b5699e0974");
            JobModel newJob = new JobModel(
                    photos,
                    benefit,
                    null,
                    page_create_job_title.getText().toString(),
                    page_create_job_description.getText().toString(),
                    page_create_job_find_location.getText().toString(),
                    Integer.parseInt(page_create_job_duration_of_work.getText().toString()),
                    Integer.parseInt(page_create_job_count_of_work.getText().toString()),
                    Integer.parseInt(page_create_job_max_price.getText().toString()),
                    1,
                    0,
                    0,
                    0
            );

            if (!TextUtils.isEmpty(uid)) {
                String key = db.child("users").child(uid).child("userJob").push().getKey();
                db.child("users").child(uid).child("userJob").child(key).setValue(newJob).addOnSuccessListener(getActivity(), new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getContext(), "Berhasil membuat pekerjaan", Toast.LENGTH_SHORT).show();
                        getActivity().finish();
                    }
                });
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
