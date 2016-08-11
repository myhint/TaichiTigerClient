package com.taichitiger.client.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.taichitiger.client.R;
import com.taichitiger.client.extend.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BindNewBankCardActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.tlName)
    TextInputLayout tlName;
    @Bind(R.id.tlIdentity)
    TextInputLayout tlIdentity;
    @Bind(R.id.tlCard)
    TextInputLayout tlCard;
    @Bind(R.id.tlPhone)
    TextInputLayout tlPhone;
    @Bind(R.id.btnCode)
    Button btnCode;
    @Bind(R.id.tlCode)
    TextInputLayout tlCode;
    @Bind(R.id.btnCommit)
    Button btnCommit;
    @Bind(R.id.tvAgreement)
    TextView tvAgreement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_new_bank_card);
        ButterKnife.bind(this);

        toolbar.setTitle(R.string.title_bind_bank_card);
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

    @OnClick({R.id.btnCode, R.id.btnCommit, R.id.tvAgreement})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCode:
                /*todo code*/
                break;
            case R.id.btnCommit:
                break;
            case R.id.tvAgreement:
                break;
        }
    }
}
