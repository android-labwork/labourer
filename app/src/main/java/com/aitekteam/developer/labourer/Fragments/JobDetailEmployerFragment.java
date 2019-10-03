package com.aitekteam.developer.labourer.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.aitekteam.developer.labourer.Adapters.SliderPagerAdapter;
import com.aitekteam.developer.labourer.Handlers.CacheHandler;
import com.aitekteam.developer.labourer.Handlers.FirebaseHandler;
import com.aitekteam.developer.labourer.Handlers.PagesHandler;
import com.aitekteam.developer.labourer.Models.JobModel;
import com.aitekteam.developer.labourer.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class JobDetailEmployerFragment extends Fragment implements ViewPager.OnPageChangeListener, FirebaseHandler.FirebaseHandlerDB{
    private View view;
    private JobModel data;
    private ViewPager slider;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;
    private FirebaseHandler db;
    private CacheHandler cache;
    private final int GET_JOB = 0;

    private TextView page_job_detail_title,
            page_job_detail_location,
            page_job_detail_prices,
            page_job_detail_duration_of_work,
            page_job_detail_description,
            page_job_detail_count_of_worker;

    private ListView page_job_detail_list_of_benefit;

    public static JobDetailEmployerFragment getInstance() {
        return new JobDetailEmployerFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.component_page, container, false);
        if (getArguments() != null)
            this.data = (JobModel) getArguments().getSerializable("data_object");
        PagesHandler pagesHandler = new PagesHandler(this.view);
        pagesHandler.showPage(R.id.page_job_detail);

        this.db = new FirebaseHandler(this);
        this.cache = new CacheHandler(getContext());

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.slider);
        images.add(R.drawable.slider);

        this.page_job_detail_title = this.view.findViewById(R.id.page_job_detail_title);
        this.page_job_detail_location = this.view.findViewById(R.id.page_job_detail_location);
        this.page_job_detail_prices = this.view.findViewById(R.id.page_job_detail_prices);
        this.page_job_detail_duration_of_work = this.view.findViewById(R.id.page_job_detail_duration_of_work);
        this.page_job_detail_count_of_worker = this.view.findViewById(R.id.page_job_detail_count_of_worker);
        this.page_job_detail_description = this.view.findViewById(R.id.page_job_detail_description);
        this.page_job_detail_list_of_benefit = this.view.findViewById(R.id.page_job_detail_list_of_benefit);

        this.page_job_detail_title.setText(data.getTitle());
        this.page_job_detail_location.setText(data.getLocation());
        this.page_job_detail_prices.setText(String.valueOf(data.getPrice()));
        this.page_job_detail_duration_of_work.setText(String.valueOf(data.getDuration_of_work()) + " Hari");
        this.page_job_detail_count_of_worker.setText(String.valueOf(data.getCount_of_worker()) + " Orang");
        this.page_job_detail_description.setText(data.getDescription());
        ArrayAdapter<String> adapterList = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1, data.getBenefits());
        this.page_job_detail_list_of_benefit.setAdapter(adapterList);

        this.slider = this.view.findViewById(R.id.page_job_detail_slider);
        SliderPagerAdapter adapter = new SliderPagerAdapter(getContext(), images);
        this.slider.setAdapter(adapter);

        this.sliderDotspanel = this.view.findViewById(R.id.page_job_detail_slider_dots);
        this.dotscount = adapter.getCount();
        this.dots = new ImageView[this.dotscount];
        for (int i = 0; i < this.dotscount; i++) {
            this.dots[i] = new ImageView(getContext());
            if (getActivity() != null)
                this.dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.non_active_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 0, 16, 0);
            sliderDotspanel.addView(this.dots[i], params);
        }

        if (getActivity() != null)
            dots[0].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.active_dot));

        this.slider.addOnPageChangeListener(this);
        return this.view;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (getActivity() != null) {
            for (int i = 0; i < dotscount; i++) {
                dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.non_active_dot));
            }
            dots[position].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.active_dot));
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void create(DatabaseReference db, int validation) {

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
