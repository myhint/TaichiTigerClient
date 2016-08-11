package com.taichitiger.client.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;

import com.taichitiger.client.extend.BaseFragment;
import com.taichitiger.client.fragment.FragmentMassage;

/**
 * Created by XY on 2016-07-28.
 */
public class MassageFragmentAdapter extends FragmentPagerAdapter {

    private SparseArray<BaseFragment> fragments;

    public MassageFragmentAdapter(FragmentManager fm) {
        super(fm);
        this.fragments = new SparseArray<>();
    }

    @Override
    public Fragment getItem(int position) {
        BaseFragment fragment = fragments.get(position);
        if (fragment == null) {
            fragment = new FragmentMassage(position);
            fragments.put(position, fragment);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
