package com.taichitiger.client.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.taichitiger.client.R;
import com.taichitiger.client.extend.BaseActivity;
import com.xycode.xylibrary.adapter.XAdapter;
import com.xycode.xylibrary.unit.ViewTypeUnit;
import com.xycode.xylibrary.xRefresher.XRefresher;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FlowRecordActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.refresher)
    XRefresher refresher;
    @Bind(R.id.ivStart)
    ImageView ivStart;
    @Bind(R.id.etStart)
    EditText etStart;
    @Bind(R.id.ivEnd)
    ImageView ivEnd;
    @Bind(R.id.etEnd)
    EditText etEnd;
    @Bind(R.id.btnCode)
    Button btnCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_record);
        ButterKnife.bind(this);

        toolbar.setTitle(R.string.title_flow_record);
        getThis().setSupportActionBar(toolbar);
        getThis().getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        XAdapter adapter = new XAdapter(getThis(), null) {

            @Override
            protected ViewTypeUnit getViewTypeUnitForLayout(Object item) {
                return new ViewTypeUnit(0, R.layout.item_flow_record);
            }

            @Override
            public void creatingHolder(CustomHolder holder, List dataList, ViewTypeUnit viewTypeUnit) {

            }

            @Override
            public void bindingHolder(CustomHolder holder, List dataList, int pos) {

            }
        };

        refresher.setup(getThis(), adapter, false, null);
    }

    @OnClick({R.id.ivStart, R.id.etStart, R.id.ivEnd, R.id.etEnd, R.id.btnCode})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivStart:
                break;
            case R.id.etStart:
                break;
            case R.id.ivEnd:
                break;
            case R.id.etEnd:
                break;
            case R.id.btnCode:
                break;
        }
    }
}
