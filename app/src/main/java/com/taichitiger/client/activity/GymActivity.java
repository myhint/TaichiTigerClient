package com.taichitiger.client.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;

import com.taichitiger.client.R;
import com.taichitiger.client.adapter.GymFragmentAdapter;
import com.taichitiger.client.extend.BaseActivity;
import com.xycode.xylibrary.uiKit.views.NoScrollViewPager;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GymActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.vpMain)
    NoScrollViewPager vpMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym);
        ButterKnife.bind(this);

        getThis().setSupportActionBar(toolbar);

        /* todo page title */
        vpMain.setAdapter(new GymFragmentAdapter(getSupportFragmentManager()));
    }

}
