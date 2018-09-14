package com.hossam.android.arabicchallenge5app.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hossam.android.arabicchallenge5app.fragments.HolderFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 5;

    public ViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return HolderFragment.newInstance(0);
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return HolderFragment.newInstance(1);
            case 2: // Fragment # 1 - This will show SecondFragment
                return HolderFragment.newInstance(2);
            case 3: // Fragment # 1 - This will show SecondFragment
                return HolderFragment.newInstance(3);
            case 4: // Fragment # 1 - This will show SecondFragment
                return HolderFragment.newInstance(4);
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return "حروف وكلمات";
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return "الوان";
            case 2: // Fragment # 1 - This will show SecondFragment
                return "جمل عربية";
            case 3: // Fragment # 1 - This will show SecondFragment
                return "فلنلعب";
            case 4: // Fragment # 1 - This will show SecondFragment
                return "الاعدادات" ;
            default:
                return "الاعدادات";
        }

    }
}