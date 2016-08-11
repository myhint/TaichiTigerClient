package com.taichitiger.client.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taichitiger.client.R;
import com.taichitiger.client.extend.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by XY on 2016-07-28.
 */
public class FragmentCategory extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
  /*  @Override
    protected void onLazyLoad() {
        super.onLazyLoad();

        getViewStub().setLayoutResource(R.layout.fragment_category);
        View view = getViewStub().inflate();
        ButterKnife.bind(this, view);
    }*/
}
