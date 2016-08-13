package com.taichitiger.client.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;

import com.taichitiger.client.R;
import com.taichitiger.client.extend.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OrderCommitActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_commit);
        ButterKnife.bind(this);

        toolbar.setTitle(R.string.title_order_commit);
        getThis().setSupportActionBar(toolbar);
        getThis().getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void onStop() {
        super.onStop();
        hideSoftInput();
    }


}
