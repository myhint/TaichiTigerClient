package com.taichitiger.client.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.taichitiger.client.R;
import com.taichitiger.client.extend.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResetPasswordActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.tlPhone)
    TextInputLayout tlPhone;
    @Bind(R.id.btnCode)
    Button btnCode;
    @Bind(R.id.tlCode)
    TextInputLayout tlCode;
    @Bind(R.id.tlPassword)
    TextInputLayout tlPassword;
    @Bind(R.id.ivShowPassword)
    ImageView ivShowPassword;
    @Bind(R.id.btnCommit)
    Button btnCommit;
    @Bind(R.id.tvService)
    TextView tvService;

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

    private void checkTextName(String name) {
        if (name.isEmpty() || name.length() < 6) {
            btnCommit.setEnabled(false);
        } else {
            btnCommit.setEnabled(true);

        }
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
