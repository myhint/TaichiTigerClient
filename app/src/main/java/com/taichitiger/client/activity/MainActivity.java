package com.taichitiger.client.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.KeyEvent;

import com.taichitiger.client.R;
import com.taichitiger.client.adapter.MainFragmentAdapter;
import com.taichitiger.client.extend.BaseActivity;
import com.taichitiger.client.view.TabItems;
import com.xycode.xylibrary.uiKit.views.NoScrollViewPager;
import com.xycode.xylibrary.utils.L;
import com.xycode.xylibrary.utils.ShareStorage;
import com.xycode.xylibrary.utils.TS;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.vpMain)
    NoScrollViewPager vpMain;
    @Bind(R.id.tabMain)
    TabLayout tabMain;

    TabItems tabItems;

    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        String[] titles = getResources().getStringArray(R.array.main_tabs);
        vpMain.setAdapter(new MainFragmentAdapter(getSupportFragmentManager()));
        tabMain.setupWithViewPager(vpMain);

        currentIndex = new ShareStorage(this, "").getInt("a", 2);
        L.e("currentIndex " +currentIndex);

        tabItems = new TabItems(getThis(), tabMain, R.layout.tab_item_bottom, titles, R.array.main_tabs_icon_disable, R.array.main_tabs_icon, R.color.colorAccent, R.color.textNormal);
        setListeners();
//        tabMain.getTabAt(currentIndex).select();
        vpMain.setCurrentItem(currentIndex, false);
    }

    private void setListeners() {
        tabMain.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 1) {
                }
                currentIndex = tabItems.setTabSelected(tab);
                vpMain.setCurrentItem(currentIndex, false);
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

    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - exitTime) > 1200) {
                TS.show(getThis(), getString(R.string.text_tap_one_more_exit));
                exitTime = System.currentTimeMillis();
                return true;
            } else {
                TS.cancel();
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}

