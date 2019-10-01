package com.aitekteam.developer.labourer;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.aitekteam.developer.labourer.Fragments.EditProfileFragment;
import com.aitekteam.developer.labourer.Fragments.JobDetailFragment;
import com.aitekteam.developer.labourer.Fragments.NotFound404Fragment;

public class DetailActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        this.toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(this.toolbar);

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }
        this.setUpDetail();
    }

    private void setUpDetail() {
        if (this.getIntent().getExtras() != null) {
            String title = this.getIntent().getStringExtra("title");
            int fragment = this.getIntent().getIntExtra("fragment",0);

            this.toolbar.setTitle(title);
            Fragment detail_fragment;
            switch (fragment) {
                case R.string.job_detail_fragment:
                    detail_fragment = JobDetailFragment.getInstance();
                    break;
                case R.string.edit_profile_fragment:
                    detail_fragment = EditProfileFragment.getInstance();
                    break;
                default:
                    detail_fragment = NotFound404Fragment.getInstance();
                    break;
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("data_object", this.getIntent().getExtras().getSerializable("data_object"));
            detail_fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_frame, detail_fragment)
                    .commit();
        }
    }
}
