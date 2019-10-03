package com.aitekteam.developer.labourer;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.aitekteam.developer.labourer.Fragments.AchievementFragment;
import com.aitekteam.developer.labourer.Fragments.CreateJobFragment;
import com.aitekteam.developer.labourer.Fragments.EditProfileFragment;
import com.aitekteam.developer.labourer.Fragments.JobDetailFragment;
import com.aitekteam.developer.labourer.Fragments.LevelFragment;
import com.aitekteam.developer.labourer.Fragments.NotFound404Fragment;
import com.aitekteam.developer.labourer.Fragments.ReviewFragment;
import com.aitekteam.developer.labourer.Fragments.SkillsFragment;

public class DetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ActionBar ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        this.toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(this.toolbar);

        this.ab = getSupportActionBar();
        if (this.ab != null) {
            this.ab.setDisplayHomeAsUpEnabled(true);
        }
        this.setUpDetail();
    }

    private void setUpDetail() {
        if (this.getIntent().getExtras() != null) {
            String title = this.getIntent().getStringExtra("title");
            int fragment = this.getIntent().getIntExtra("fragment",0);

            this.ab.setTitle(title);
            Fragment detail_fragment;
            switch (fragment) {
                case R.string.job_detail_fragment:
                    detail_fragment = JobDetailFragment.getInstance();
                    break;
                case R.string.edit_profile_fragment:
                    detail_fragment = EditProfileFragment.getInstance();
                    break;
                case R.string.create_job_fragment:
                    detail_fragment = CreateJobFragment.getInstance();
                    break;
                case R.string.level_fragment:
                    detail_fragment = LevelFragment.getInstance();
                    break;
                case R.string.achievement_fragment:
                    detail_fragment = AchievementFragment.getInstance();
                    break;
                case R.string.skills_fragment:
                    detail_fragment = SkillsFragment.getInstance();
                    break;
                case R.string.review_fragment:
                    detail_fragment = ReviewFragment.getInstance();
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
