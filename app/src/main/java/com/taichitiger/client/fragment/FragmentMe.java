package com.taichitiger.client.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.taichitiger.client.R;
import com.taichitiger.client.activity.AboutTigerActivity;
import com.taichitiger.client.activity.AdminMoneyActivity;
import com.taichitiger.client.activity.MyFavorActivity;
import com.taichitiger.client.activity.MyInfoActivity;
import com.taichitiger.client.activity.SecurityCenterActivity;
import com.taichitiger.client.extend.BaseFragment;
import com.taichitiger.client.view.ListItem;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by XY on 2016-07-28.
 */
public class FragmentMe extends BaseFragment implements View.OnClickListener {

    @Bind(R.id.sivHead)
    SimpleDraweeView sivHead;
    @Bind(R.id.phone)
    TextView tvPhone;
    @Bind(R.id.itemOrder)
    ListItem itemOrder;
    @Bind(R.id.itemFavor)
    ListItem itemFavor;
    @Bind(R.id.itemMoney)
    ListItem itemMoney;
    @Bind(R.id.itemSecurity)
    ListItem itemSecurity;
    @Bind(R.id.itemAboutUs)
    ListItem itemAboutUs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sivHead.setImageURI(Uri.parse("res:///" + R.mipmap.hytx));
        tvPhone.setText("13800180833");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.sivHead, R.id.itemOrder, R.id.itemFavor, R.id.itemMoney, R.id.itemSecurity, R.id.itemAboutUs})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sivHead:
                getThis().start(MyInfoActivity.class);
                break;
            case R.id.itemOrder:
                break;
            case R.id.itemFavor:
                getThis().start(MyFavorActivity.class);
                break;
            case R.id.itemMoney:
                getThis().start(AdminMoneyActivity.class);
                break;
            case R.id.itemSecurity:
                getThis().start(SecurityCenterActivity.class);
                break;
            case R.id.itemAboutUs:
                getThis().start(AboutTigerActivity.class);
                break;
        }
    }

    /* @Override
    protected void onLazyLoad() {
        super.onLazyLoad();
        getViewStub().setLayoutResource(R.layout.fragment_me);
        View view = getViewStub().inflate();
        ButterKnife.bind(this, view);
    }*/
}
