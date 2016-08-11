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

public class SecurityCenterActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.itemPhone)
    ListItem itemPhone;
    @Bind(R.id.itemPassword)
    ListItem itemPassword;
    @Bind(R.id.itemQuestion)
    ListItem itemQuestion;
    @Bind(R.id.tvSecurityLevel)
    TextView tvSecurityLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_center);
        ButterKnife.bind(this);

        toolbar.setTitle(R.string.title_security_center);
        getThis().setSupportActionBar(toolbar);
        getThis().getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvSecurityLevel.setText("高");

        itemPhone.setText(R.id.tvContent, "139 6981 2054");
        itemPassword.setText(R.id.tvContent, "强");
        ((TextView) itemPassword.getView(R.id.tvContent)).setTextColor(getResources().getColor(R.color.colorAccent));
    }


    @OnClick({R.id.itemPhone, R.id.itemPassword, R.id.itemQuestion})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.itemPhone:
                break;
            case R.id.itemPassword:
                break;
            case R.id.itemQuestion:
                break;
        }
    }
}
