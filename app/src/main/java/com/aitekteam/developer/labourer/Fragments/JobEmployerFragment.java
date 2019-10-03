package com.aitekteam.developer.labourer.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aitekteam.developer.labourer.Adapters.JobEmployerAdapter;
import com.aitekteam.developer.labourer.DetailActivity;
import com.aitekteam.developer.labourer.Handlers.CacheHandler;
import com.aitekteam.developer.labourer.Handlers.FirebaseHandler;
import com.aitekteam.developer.labourer.Handlers.PagesHandler;
import com.aitekteam.developer.labourer.Models.EmptySerialize;
import com.aitekteam.developer.labourer.Models.JobModel;
import com.aitekteam.developer.labourer.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class JobEmployerFragment extends Fragment implements FirebaseHandler.FirebaseHandlerDB {
    private View view;
    private RecyclerView main_list;
    private JobEmployerAdapter adapter;
    private FloatingActionButton page_job_employer_create;
    private ArrayList<JobModel> data_set;
    private FirebaseHandler db;
    private CacheHandler cache;
    private final int GET_USER = 0;

    public static JobEmployerFragment getInstance() {
        return new JobEmployerFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.component_page, container, false);
        PagesHandler pagesHandler = new PagesHandler(this.view);
        pagesHandler.showPage(R.id.page_job_employer);

        this.db = new FirebaseHandler(this);
        this.cache = new CacheHandler(getContext());

        this.main_list = this.view.findViewById(R.id.main_list);
        this.page_job_employer_create = this.view.findViewById(R.id.page_job_employer_create);
        this.main_list.setHasFixedSize(true);
        this.main_list.setLayoutManager(new LinearLayoutManager(this.getContext()));
        this.data_set = new ArrayList<>();
        this.insertDataSet();

        return this.view;
    }

    private void insertDataSet() {
        this.db.valueEvent(GET_USER);
    }

    @Override
    public void create(DatabaseReference db, int validation) {

    }

    @Override
    public ValueEventListener getWithValueEvent(DatabaseReference database, int validation) {
        if (validation == GET_USER) {
            String uid = this.cache.read();
            ValueEventListener getDataUser = new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.hasChild("userJob")) {
                        for (DataSnapshot ds: dataSnapshot.child("userJob").getChildren()) {
                            data_set.add(ds.getValue(JobModel.class));
                        }
                        Collections.reverse(data_set);
                        adapter = new JobEmployerAdapter(data_set, new JobEmployerAdapter.JobSelectedHandler() {
                            @Override
                            public void onSelectedItem(JobModel item, int position) {
                                Intent intent = new Intent(getContext(), DetailActivity.class);
                                intent.putExtra("data_object", item);
                                intent.putExtra("title", getResources().getString(R.string.job_detail_app));
                                intent.putExtra("fragment", R.string.job_employer_detail_fragment);
                                startActivity(intent);
                            }
                        });
                        main_list.setAdapter(adapter);
                        page_job_employer_create.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(getContext(), DetailActivity.class);
                                intent.putExtra("data_object", new EmptySerialize());
                                intent.putExtra("title", getResources().getString(R.string.create_job_app));
                                intent.putExtra("fragment", R.string.create_job_fragment);
                                startActivity(intent);
                            }
                        });
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            };
            database.child("users").child(uid).addValueEventListener(getDataUser);
        }
        return null;
    }

    @Override
    public ChildEventListener getWithChildEvent(DatabaseReference db, int validation) {
        return null;
    }
}