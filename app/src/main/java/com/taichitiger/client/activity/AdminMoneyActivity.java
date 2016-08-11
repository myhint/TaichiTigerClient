package com.taichitiger.client.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.taichitiger.client.R;
import com.taichitiger.client.extend.BaseActivity;
import com.taichitiger.client.view.ListItem;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AdminMoneyActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.itemBalance)
    ListItem itemBalance;
    @Bind(R.id.itemBankCard)
    ListItem itemBankCard;
    @Bind(R.id.itemFlow)
    ListItem itemFlow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_money);
        ButterKnife.bind(this);

        toolbar.setTitle(R.string.title_admin_money);
        getThis().setSupportActionBar(toolbar);
        getThis().getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick({R.id.itemBalance, R.id.itemBankCard, R.id.itemFlow})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.itemBalance:
                start(BalanceActivity.class);
                break;
            case R.id.itemBankCard:
                start(BindBankCardActivity.class);
                break;
            case R.id.itemFlow:
                start(FlowRecordActivity.class);
                break;
        }
    }
}
