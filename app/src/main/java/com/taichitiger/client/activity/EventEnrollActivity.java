package com.taichitiger.client.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import com.taichitiger.client.R;
import com.taichitiger.client.extend.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventEnrollActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.btnCommit)
    Button btnCommit;
    @Bind(R.id.tlName)
    TextInputLayout tlName;
    @Bind(R.id.tlPhone)
    TextInputLayout tlPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_enroll);
        ButterKnife.bind(this);

        toolbar.setTitle(R.string.title_event_enroll);
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

    @OnClick(R.id.btnCommit)
    public void commit() {

    }

    @Override
    protected void onStop() {
        super.onStop();
        hideSoftInput();
    }

}
