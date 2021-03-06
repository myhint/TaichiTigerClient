package com.taichitiger.client.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;

import com.taichitiger.client.R;
import com.taichitiger.client.extend.BaseActivity;
import com.xycode.xylibrary.adapter.XAdapter;
import com.xycode.xylibrary.unit.ViewTypeUnit;
import com.xycode.xylibrary.xRefresher.XRefresher;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailGymActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.refresher)
    XRefresher refresher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_gym);
        ButterKnife.bind(this);

        toolbar.setTitle(R.string.title_detail_gym);
        getThis().setSupportActionBar(toolbar);
        getThis().getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        XAdapter adapter = new XAdapter(getThis(), null) {
            @Override
            public void bindingHolder(CustomHolder holder, List dataList, int pos) {

            }

            @Override
            protected ViewTypeUnit getViewTypeUnitForLayout(Object item) {
                return null;
            }
        };

        adapter.addHeader(1, R.layout.header_detail_gym);
        refresher.setup(getThis(), adapter, false, new XRefresher.OnSwipeListener() {
            @Override
            public void onRefresh() {
                refresher.setRefreshing(false);
            }
        }, null);
    }

}
