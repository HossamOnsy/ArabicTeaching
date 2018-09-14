package com.hossam.android.arabicchallenge5app;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jkb.fragment.rigger.annotation.Puppet;

import cn.hugeterry.coordinatortablayout.CoordinatorTabLayout;


/**
 * A simple {@link Fragment} subclass.
 */

@Puppet(containerViewId = R.id.container, stickyStack = true)
public class MainFragment extends Fragment {

    ViewPagerAdapter adapterViewPager;
    CoordinatorTabLayout mCoordinatorTabLayout;

    int[] mImageArray = new int[]{
            R.drawable.hammer_h,
            R.drawable.hourglass_h,
            R.drawable.heart,
            R.drawable.cloud_h,
            R.drawable.hammer_h};
    int[] mColorArray = new int[]{
            android.R.color.holo_orange_light,
            android.R.color.holo_green_light,
            android.R.color.holo_red_light,
            android.R.color.darker_gray,
            android.R.color.holo_orange_light};
    ViewPager vpPager;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        vpPager = view.findViewById(R.id.vp);
        if (getActivity() != null)
            adapterViewPager = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        vpPager.setOffscreenPageLimit(5);
        vpPager.setAdapter(adapterViewPager);

        mCoordinatorTabLayout = view.findViewById(R.id.coordinatortablayout);
        mCoordinatorTabLayout.setTitle("Learning Arabic")
                .setImageArray(mImageArray, mColorArray)
                .setupWithViewPager(vpPager);
    }
}
