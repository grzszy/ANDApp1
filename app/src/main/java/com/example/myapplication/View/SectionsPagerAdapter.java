package com.example.myapplication.View;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {


    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new QuizFragment();
                break;
            case 1:
                fragment = new ScoresFragment();
                break;
            case 2:
                fragment = new Settings();
                break;

        }
        return fragment;
    }



    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }
}