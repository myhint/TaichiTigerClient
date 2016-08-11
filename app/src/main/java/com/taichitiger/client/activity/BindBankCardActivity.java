package com.taichitiger.client.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.taichitiger.client.R;
import com.taichitiger.client.extend.BaseActivity;
import com.xycode.xylibrary.adapter.XAdapter;
import com.xycode.xylibrary.unit.ViewTypeUnit;
import com.xycode.xylibrary.xRefresher.XRefresher;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BindBankCardActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.refresher)
    XRefresher refresher;
    @Bind(R.id.llBindNew)
    LinearLayout llBindNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_bank_card);
        ButterKnife.bind(this);

        toolbar.setTitle(R.string.title_bind_bank_card);
        getThis().setSupportActionBar(toolbar);
        getThis().getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        XAdapter adapter = new XAdapter(getThis(), null) {

            @Override
            protected ViewTypeUnit getViewTypeUnitForLayout(Object item) {
                return new ViewTypeUnit(0, R.layout.item_bind_bank_card);
            }

            @Override
            public void creatingHolder(CustomHolder holder, List dataList, ViewTypeUnit viewTypeUnit) {
                View.OnClickListener clickListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switch (view.getId()) {
                            case R.id.tvDelete:

                                break;
                        }
                    }
                };
                holder.setClick(R.id.tvDelete, clickListener);
            }

            @Override
            public void bindingHolder(CustomHolder holder, List dataList, int pos) {

            }
        };

        refresher.setup(getThis(), adapter, false, null);
    }

    @OnClick(R.id.llBindNew)
    public void onClick() {
        start(BindNewBankCardActivity.class);
    }
}
