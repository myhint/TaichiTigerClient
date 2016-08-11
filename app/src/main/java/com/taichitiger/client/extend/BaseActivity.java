package com.taichitiger.client.extend;

import butterknife.ButterKnife;

/**
 * Created by XY on 2016-08-04.
 */
public class BaseActivity extends com.xycode.xylibrary.base.BaseActivity {

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
