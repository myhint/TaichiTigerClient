package com.taichitiger.client.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;

import com.taichitiger.client.extend.BaseFragment;
import com.taichitiger.client.fragment.FragmentGym;

/**
 * Created by XY on 2016-07-28.
 */
public class GymFragmentAdapter extends FragmentPagerAdapter {

    private SparseArray<BaseFragment> fragments;

    public GymFragmentAdapter(FragmentManager fm) {
        super(fm);
        this.fragments = new SparseArray<>();
    }

    @Override
    public Fragment getItem(int position) {
        BaseFragment fragment = fragments.get(position);
        if (fragment == null) {
            fragment = new FragmentGym(position);
            fragments.put(position, fragment);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
