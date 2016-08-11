package com.taichitiger.client.view;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.view.View;

import com.taichitiger.client.R;
import com.xycode.xylibrary.base.BaseTabItems;

/**
 * Created by XY on 2016-08-10.
 */
public class TabItems extends BaseTabItems {

    public TabItems(Context context, TabLayout tabMain, int layoutId, String[] titles, int tabIconsNormalArrayId, int tabIconsSelectedArrayId, int selectedTextColor, int normalTextColor) {
        super(context, tabMain, layoutId, R.id.tvTab, R.id.ivTab, titles, tabIconsNormalArrayId, tabIconsSelectedArrayId, selectedTextColor, normalTextColor);
    }

    @Override
    protected void initTabItemView(int layoutId, View view, int pos) {

    }


}
