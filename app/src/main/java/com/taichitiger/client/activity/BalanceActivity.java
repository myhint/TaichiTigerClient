package com.taichitiger.client.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.taichitiger.client.R;
import com.taichitiger.client.extend.BaseActivity;
import com.taichitiger.client.view.ListItem;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BalanceActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.liBalance)
    ListItem liBalance;
    @Bind(R.id.liDeposit)
    ListItem liDeposit;
    @Bind(R.id.liCanDeposit)
    ListItem liCanDeposit;
    @Bind(R.id.tlDeposit)
    TextInputLayout tlDeposit;
    @Bind(R.id.btnCode)
    Button btnCode;
    @Bind(R.id.tlCode)
    TextInputLayout tlCode;
    @Bind(R.id.btnCommit)
    Button btnCommit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);
        ButterKnife.bind(this);

        /* todo page title */
        getThis().setSupportActionBar(toolbar);
        getThis().getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setWatchListener();
    }

    private void setWatchListener() {

    }

    private void checkTextName() {
        String name = tlCode.getEditText().getText().toString();
        String money = tlDeposit.getEditText().getText().toString();
        float m = Float.parseFloat(money);
        if (name.isEmpty() || name.length() < 4 || m<0) {
            btnCommit.setEnabled(false);
        } else {
            btnCommit.setEnabled(true);

        }
    }

    @OnClick(R.id.btnCommit)
    public void commit() {

    }

    @Override
    protected void onStop() {
        super.onStop();
        hideSoftInput();
    }

    @OnClick({R.id.btnCode, R.id.btnCommit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCode:
        /* todo code */
                break;
            case R.id.btnCommit:
                break;
        }
    }
}
