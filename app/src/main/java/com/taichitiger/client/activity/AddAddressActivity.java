package com.taichitiger.client.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.taichitiger.client.R;
import com.taichitiger.client.extend.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddAddressActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        ButterKnife.bind(this);

        toolbar.setTitle(R.string.title_reset_password);
        getThis().setSupportActionBar(toolbar);
        getThis().getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setWatchListener();
    }

    private void setWatchListener() {

    }

    @Override
    protected void onStop() {
        super.onStop();
        hideSoftInput();
    }


    @OnClick({R.id.btnCode, R.id.ivShowPassword, R.id.btnCommit, R.id.tvService})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCode:
                break;
            case R.id.ivShowPassword:
                break;
            case R.id.btnCommit:
                break;
            case R.id.tvService:
                break;
        }
    }
}
