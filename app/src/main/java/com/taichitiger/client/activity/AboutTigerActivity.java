package com.taichitiger.client.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.taichitiger.client.R;
import com.taichitiger.client.extend.BaseActivity;
import com.taichitiger.client.view.ListItem;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutTigerActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.tvVersion)
    TextView tvVersion;
    @Bind(R.id.tvVersionCheck)
    TextView tvVersionCheck;
    @Bind(R.id.liAboutUs)
    ListItem liAboutUs;
    @Bind(R.id.liServicePhone)
    ListItem liServicePhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_tiger);
        ButterKnife.bind(this);

        toolbar.setTitle(R.string.title_about_tiger);
        getThis().setSupportActionBar(toolbar);
        getThis().getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick({R.id.tvVersionCheck, R.id.liAboutUs, R.id.liServicePhone})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvVersionCheck:
                break;
            case R.id.liAboutUs:
                start(AboutUsActivity.class);
                break;
            case R.id.liServicePhone:
                break;
        }
    }
}
