package com.taichitiger.client.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
public class FragmentMassage extends BaseFragment {

    public static final int FRAGMENT_MASSAGE = 0;
    public static final int FRAGMENT_MASSEUSE = 1;

    @Bind(R.id.refresher)
    XRefresher refresher;

    private int type;

    public FragmentMassage(int type) {
        this.type = type;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_massage, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setPage(type);
     /*   XAdapter adapter = new XAdapter(getThis(), null) {
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
        };*/

    }

    private void setPage(int type) {
        XAdapter adapter;
        switch (type) {
            case FRAGMENT_MASSAGE:
                adapter = new MassageAdapter(getThis(), null);
                refresher.setup(getThis(), adapter, false, null);
                break;
            case FRAGMENT_MASSEUSE:
                adapter = new MasseuseAdapter(getThis(), null);
                refresher.setup(getThis(), adapter, false, null);
                break;
        }
    }

    private class MassageAdapter extends XAdapter {
        /**
         * use single Layout
         *
         * @param context
         * @param dataList
         */
        public MassageAdapter(Context context, List dataList) {
            super(context, dataList);
        }

        @Override
        public void bindingHolder(CustomHolder holder, List dataList, int pos) {
        }

        @Override
        protected ViewTypeUnit getViewTypeUnitForLayout(Object item) {
            return new ViewTypeUnit(0, R.layout.item_massage);
        }
    }

    private class MasseuseAdapter extends XAdapter {
        /**
         * use single Layout
         *
         * @param context
         * @param dataList
         */
        public MasseuseAdapter(Context context, List dataList) {
            super(context, dataList);
        }

        @Override
        public void bindingHolder(CustomHolder holder, List dataList, int pos) {
        }

        @Override
        protected ViewTypeUnit getViewTypeUnitForLayout(Object item) {
            return new ViewTypeUnit(0, R.layout.item_masseuse);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
