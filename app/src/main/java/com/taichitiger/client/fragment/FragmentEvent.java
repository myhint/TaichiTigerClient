package com.taichitiger.client.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taichitiger.client.R;
import com.taichitiger.client.activity.EventAddTeamActivity;
import com.taichitiger.client.extend.BaseFragment;
import com.xycode.xylibrary.adapter.XAdapter;
import com.xycode.xylibrary.uiKit.views.loopview.AdLoopView;
import com.xycode.xylibrary.unit.ViewTypeUnit;
import com.xycode.xylibrary.xRefresher.XRefresher;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by XY on 2016-07-28.
 */
public class FragmentEvent extends BaseFragment {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.refresher)
    XRefresher refresher;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        toolbar.setTitle(R.string.title_event);
        getThis().setSupportActionBar(toolbar);

        XAdapter adapter = new XAdapter(getThis(), null) {
            @Override
            public void bindingHolder(CustomHolder holder, List dataList, int pos) {

            }

            @Override
            protected ViewTypeUnit getViewTypeUnitForLayout(Object item) {
                return new ViewTypeUnit(0,R.layout.item_event_team_list);
            }

            @Override
            protected void creatingHeader(CustomHolder holder, int headerKey) {
                super.creatingHeader(holder, headerKey);
                holder.getView(R.id.llAddTeam).setOnClickListener(clickListener);
                holder.getView(R.id.llFindTeam).setOnClickListener(clickListener);
                holder.getView(R.id.llHotEvent).setOnClickListener(clickListener);

                AdLoopView loopView = holder.getView(R.id.loopView);
                List<String> urls = new ArrayList<>();
                urls.add("res:///" + R.mipmap.yueqiuhaibao);
                urls.add("res:///" + R.mipmap.yueqiuhaibao);
                urls.add("res:///" + R.mipmap.yueqiuhaibao);
                loopView.initData(urls);
            }

            @Override
            protected void bindingHeader(CustomHolder holder, int pos) {
                super.bindingHeader(holder, pos);
            }
        };
        adapter.addHeader(1, R.layout.header_event);
        refresher.setup(getThis(), adapter, false, new XRefresher.OnSwipeListener() {
            @Override
            public void onRefresh() {
                refresher.setRefreshing(false);
            }
        }, null);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.llAddTeam:
                    getThis().start(EventAddTeamActivity.class);
                    break;
                case R.id.llFindTeam:

                    break;
                case R.id.llHotEvent:

                    break;
                default:
                    break;
            }
        }
    };

  /*  @Override
    protected void onLazyLoad() {
        super.onLazyLoad();

        getViewStub().setLayoutResource(R.layout.fragment_event);
        View view = getViewStub().inflate();
        ButterKnife.bind(this, view);
    }*/
}
