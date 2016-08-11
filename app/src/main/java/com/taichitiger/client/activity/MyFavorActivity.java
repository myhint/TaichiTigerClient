package com.taichitiger.client.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.taichitiger.client.R;
import com.taichitiger.client.extend.BaseActivity;
import com.taichitiger.client.view.TabItems;
import com.xycode.xylibrary.adapter.XAdapter;
import com.xycode.xylibrary.unit.ViewTypeUnit;
import com.xycode.xylibrary.xRefresher.XRefresher;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MyFavorActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.refresher)
    XRefresher refresher;
    @Bind(R.id.tabMain)
    TabLayout tabMain;
    private TabItems tabItems;
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_favor);
        ButterKnife.bind(this);

        toolbar.setTitle(R.string.title_my_favor);
        getThis().setSupportActionBar(toolbar);
        getThis().getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTabs();


        XAdapter adapter = new XAdapter(getThis(), null) {

            @Override
            public void creatingHolder(CustomHolder holder, List dataList, ViewTypeUnit viewTypeUnit) {
                View.OnClickListener clickListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switch (view.getId()) {
                            case R.id.sivPic:

                                break;
                            case R.id.ivRecycle:

                                break;
                            case R.id.btnCommit:

                                break;
                            default:
                                break;
                        }
                    }
                };
                holder.setClick(R.id.sivPic, clickListener);
                holder.setClick(R.id.ivRecycle, clickListener);
                holder.setClick(R.id.btnCommit, clickListener);
            }

            @Override
            public void bindingHolder(CustomHolder holder, List dataList, int pos) {

            }

            @Override
            protected ViewTypeUnit getViewTypeUnitForLayout(Object item) {
                return new ViewTypeUnit(0, R.layout.item_favor_list);
            }
        };

        refresher.setup(getThis(), adapter, false, null);
    }

    private void setTabs() {

        String[] titles = getResources().getStringArray(R.array.favor_tabs);
        tabItems = new TabItems(getThis(), tabMain, R.layout.tab_item_favor, titles, R.array.favor_tabs_icon_disable, R.array.favor_tabs_icon, R.color.btnOption, R.color.textLite);

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
