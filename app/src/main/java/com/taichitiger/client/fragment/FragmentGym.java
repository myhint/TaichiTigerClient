package com.taichitiger.client.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.taichitiger.client.R;
import com.taichitiger.client.extend.BaseFragment;
import com.xycode.xylibrary.adapter.XAdapter;
import com.xycode.xylibrary.unit.ViewTypeUnit;
import com.xycode.xylibrary.xRefresher.XRefresher;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by XY on 2016-07-28.
 */
@SuppressLint("ValidFragment")
public class FragmentGym extends BaseFragment {

    public static final int FRAGMENT_ROOM = 0;
    public static final int FRAGMENT_COACH = 1;

    @Bind(R.id.refresher)
    XRefresher refresher;
    @Bind(R.id.spinner1)
    Spinner spinner1;
    @Bind(R.id.spinner2)
    Spinner spinner2;
    @Bind(R.id.spinner3)
    Spinner spinner3;

    private int type;

    public FragmentGym(int type) {
        this.type = type;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gym, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        XAdapter adapter = new XAdapter(getThis(), null) {
            @Override
            public void bindingHolder(CustomHolder holder, List dataList, int pos) {
                View view1 = holder.getView(R.id.itemDetail1);
                View view2 = holder.getView(R.id.itemDetail2);
                view1.findViewById(R.id.llItem).setVisibility(View.VISIBLE);
                view2.findViewById(R.id.llItem).setVisibility(View.VISIBLE);
            }

            @Override
            protected ViewTypeUnit getViewTypeUnitForLayout(Object item) {
                return new ViewTypeUnit(0, R.layout.item_gym);
            }
        };
        refresher.setup(getThis(), adapter, false, null);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
