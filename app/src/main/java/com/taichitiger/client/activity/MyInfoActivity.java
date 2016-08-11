package com.taichitiger.client.activity;

import android.net.Uri;
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

public class MyInfoActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.itemHead)
    ListItem itemHead;
    @Bind(R.id.itemAccount)
    ListItem itemAccount;
    @Bind(R.id.itemNickName)
    ListItem itemNickName;
    @Bind(R.id.itemSex)
    ListItem itemSex;
    @Bind(R.id.itemBarCode)
    ListItem itemBarCode;
    @Bind(R.id.itemAddress)
    ListItem itemAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);
        ButterKnife.bind(this);

        toolbar.setTitle(R.string.title_my_info);
        getThis().setSupportActionBar(toolbar);
        getThis().getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        itemAccount.setText(R.id.tvContent, "139 6981 2054");
        itemNickName.setText(R.id.tvContent, "鱼冰龙");
        itemSex.setText(R.id.tvContent, "男");
        itemAddress.setText(R.id.tvContent, "");
        itemHead.setImageURI(R.id.sivPicRound, Uri.parse("res:///"+R.mipmap.hytx));
        itemBarCode.setImageURI(R.id.sivPic, Uri.parse("res:///" + R.mipmap.img_barcode));
        itemHead.getView(R.id.sivPicRound).setVisibility(View.VISIBLE);
        itemBarCode.getView(R.id.sivPic).setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.itemHead, R.id.itemAccount, R.id.itemNickName, R.id.itemSex, R.id.itemBarCode, R.id.itemAddress})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.itemHead:
                break;
            case R.id.itemAccount:
                break;
            case R.id.itemNickName:
                break;
            case R.id.itemSex:
                break;
            case R.id.itemBarCode:
                break;
            case R.id.itemAddress:
                start(AdminAddressActivity.class);
                break;
        }
    }
}
