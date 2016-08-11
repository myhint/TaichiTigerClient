package com.taichitiger.client.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;

import com.taichitiger.client.extend.BaseFragment;
import com.taichitiger.client.fragment.FragmentCategory;
import com.taichitiger.client.fragment.FragmentEvent;
import com.taichitiger.client.fragment.FragmentHome;
import com.taichitiger.client.fragment.FragmentMe;

/**
 * Created by XY on 2016-07-28.
 */
public class MainFragmentAdapter extends FragmentPagerAdapter {

    public static final int FRAGMENT_HOME = 0;
    public static final int FRAGMENT_CATEGORY = 1;
    public static final int FRAGMENT_EVENT = 2;
    public static final int FRAGMENT_ME = 3;

    private SparseArray<BaseFragment> fragments;

    public MainFragmentAdapter(FragmentManager fm) {
        super(fm);
        this.fragments = new SparseArray<>();
    }

    @Override
    public Fragment getItem(int position) {
        BaseFragment fragment = fragments.get(position);
        if (fragment == null) {
            switch (position) {
                case FRAGMENT_HOME:
                    fragment = new FragmentHome();
                    break;
                case FRAGMENT_CATEGORY:
                    fragment = new FragmentCategory();
                    break;
                case FRAGMENT_EVENT:
                    fragment = new FragmentEvent();
                    break;
                case  FRAGMENT_ME:
                    fragment = new FragmentMe();
                    break;
            }
            fragments.put(position, fragment);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
