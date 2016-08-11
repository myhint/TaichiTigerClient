package com.taichitiger.client.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;

import com.taichitiger.client.R;
import com.taichitiger.client.adapter.MassageFragmentAdapter;
import com.taichitiger.client.extend.BaseActivity;
import com.taichitiger.client.view.TabItems;
import com.xycode.xylibrary.uiKit.views.NoScrollViewPager;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MassageActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.vpMain)
    NoScrollViewPager vpMain;
    @Bind(R.id.tabMain)
    TabLayout tabMain;
    private TabItems tabItems;
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_massage);
        ButterKnife.bind(this);

        toolbar.setTitle(R.string.title_massage);
        getThis().setSupportActionBar(toolbar);
        getThis().getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vpMain.setAdapter(new MassageFragmentAdapter(getSupportFragmentManager()));
        tabMain.setupWithViewPager(vpMain);
        setTabs();
    }

    private void setTabs() {

        String[] titles = getResources().getStringArray(R.array.massage_tabs);
        tabItems = new TabItems(getThis(), tabMain, R.layout.tab_item_massage, titles, R.array.massage_tabs_icon_disable, R.array.massage_tabs_icon, R.color.colorAccent, R.color.textNormal);

        tabMain.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                currentIndex = tabItems.setTabSelected(tab);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tabItems.setTabUnselected(tab);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


}
