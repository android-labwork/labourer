package com.aitekteam.developer.labourer.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.aitekteam.developer.labourer.Adapters.SliderPagerAdapter;
import com.aitekteam.developer.labourer.Handlers.PagesHandler;
import com.aitekteam.developer.labourer.Models.JobModel;
import com.aitekteam.developer.labourer.R;

import java.util.ArrayList;

public class JobDetailFragment extends Fragment implements ViewPager.OnPageChangeListener{

    private View view;
    private JobModel data;
    private ViewPager slider;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;

    public static JobDetailFragment getInstance() {
        return new JobDetailFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.component_page, container, false);
        if (getArguments() != null)
            this.data = (JobModel) getArguments().getSerializable("data_object");
        PagesHandler pagesHandler = new PagesHandler(this.view);
        pagesHandler.showPage(R.id.page_job_detail);

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.slider);
        images.add(R.drawable.slider);

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
}
