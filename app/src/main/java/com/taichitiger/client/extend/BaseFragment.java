package com.taichitiger.client.extend;

import android.support.v4.app.Fragment;

import com.xycode.xylibrary.base.BaseActivity;

import butterknife.ButterKnife;

/**
 * Created by XY on 2016-08-03.
 */
public class BaseFragment extends Fragment {

    public BaseActivity getThis() {
        return ((BaseActivity) getActivity());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
