package com.taichitiger.client.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.taichitiger.client.R;
import com.taichitiger.client.extend.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventAddTeamCommitActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.btnCommit)
    Button btnCommit;
    @Bind(R.id.etName)
    EditText etName;
    @Bind(R.id.etSignature)
    EditText etSignature;
    @Bind(R.id.ivWarning)
    ImageView ivWarning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_add_team_commit);
        ButterKnife.bind(this);

        toolbar.setTitle(R.string.title_add_my_team);
        getThis().setSupportActionBar(toolbar);
        getThis().getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setWatchListener();
        checkTextName(etName.getText().toString());
    }

    private void setWatchListener() {
        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String name = editable.toString().trim();
                checkTextName(name);
            }
        });
    }

    private void checkTextName(String name) {
        if (name.isEmpty() || name.length() < 6) {
            btnCommit.setEnabled(false);
            ivWarning.setVisibility(View.VISIBLE);
        } else {
            btnCommit.setEnabled(true);
            ivWarning.setVisibility(View.INVISIBLE);

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
