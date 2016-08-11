package com.taichitiger.client.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.taichitiger.client.R;
import com.taichitiger.client.extend.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @Bind(R.id.tvFastLogin)
    TextView tvFastLogin;
    @Bind(R.id.tlAccount)
    TextInputLayout tlAccount;
    @Bind(R.id.tlPassword)
    TextInputLayout tlPassword;
    @Bind(R.id.ivShowPassword)
    ImageView ivShowPassword;
    @Bind(R.id.btnCommit)
    Button btnCommit;
    @Bind(R.id.tvAgreement)
    TextView tvAgreement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        setWatchListener();
        checkTextName();
    }

    private void setWatchListener() {
        tlAccount.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                checkTextName();
            }
        });
    }

    private void checkTextName() {
        String account = tlAccount.getEditText().getText().toString().trim();
        String pw = tlPassword.getEditText().getText().toString();
        if (account.isEmpty() || pw.isEmpty()) {
            btnCommit.setEnabled(false);
        } else {
            btnCommit.setEnabled(true);

        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @OnClick({R.id.tvFastLogin, R.id.ivShowPassword, R.id.btnCommit, R.id.tvAgreement})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvFastLogin:
                start(RegisterActivity.class);
                break;
            case R.id.ivShowPassword:
                break;
            case R.id.btnCommit:
                break;
            case R.id.tvAgreement:
                break;
        }
    }
}
