package com.aitekteam.developer.labourer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.aitekteam.developer.labourer.Fragments.SplashScreenFragment;
import com.aitekteam.developer.labourer.Models.Achivement;
import com.aitekteam.developer.labourer.Models.Job;
import com.aitekteam.developer.labourer.Models.ReviewUser;
import com.aitekteam.developer.labourer.Models.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PortalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal);
        setTheme(R.style.AppTheme);
        createDbStructure();
        setUpPortal(SplashScreenFragment.getInstance());
    }

    public void setUpPortal(Fragment fragmentClass) {
        Fragment fragment = null;
        try {
            fragment = fragmentClass;
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_frame, fragment)
                .commit();
    }

    private void createDbStructure(){
        DatabaseReference mUser = FirebaseDatabase.getInstance().getReference("users");
        String keyUser = mUser.push().getKey();
        User user = new User(keyUser,
                "John Doe",
                "213213213",
                "https://cdn1.iconfinder.com/data/icons/flat-character-color-1/60/flat-design-character_3-512.png",
                "johndoe@example.com",
                "johndoe",
                "common",
                "",
                "",
                "",
                0
        );
        mUser.child(keyUser).setValue(user);

        DatabaseReference mAch = FirebaseDatabase.getInstance().getReference("users").child(keyUser).child("userAchivement");
        DatabaseReference mRev = FirebaseDatabase.getInstance().getReference("users").child(keyUser).child("userReviews");
        DatabaseReference mJob = FirebaseDatabase.getInstance().getReference("users").child(keyUser).child("userJob");
        String keyAch = mAch.push().getKey();
        String keyRev = mRev.push().getKey();
        String keyJob = mJob.push().getKey();
        Achivement ach = new Achivement (keyAch,"Title", "Description", "Piture", 0);
        ReviewUser ru = new ReviewUser(keyRev,"qweweq",0,"rewr","John Doe");
        Job jm = new Job(
                null,
                null,
                null,
                keyJob,
                "Fixing Roof",
                "Got A Simlpe Fixing Roof",
                "My Home",
                keyUser,
                "John Doe",
                100,
                2,
                100,
                0,
                1,
                100,
                0,
                0);
        mAch.child(keyAch).setValue(ach);
        mRev.child(keyRev).setValue(ru);
        mJob.child(keyJob).setValue(jm);
    }
}
