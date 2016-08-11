package com.taichitiger.client.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taichitiger.client.R;
import com.taichitiger.client.activity.GymActivity;
import com.taichitiger.client.activity.MassageActivity;
import com.taichitiger.client.extend.BaseFragment;
import com.xycode.xylibrary.adapter.XAdapter;
import com.xycode.xylibrary.uiKit.views.MultiImageView;
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
public class FragmentHome extends BaseFragment {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.refresher)
    XRefresher refresher;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 100) {

            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
//        refresher = (XRefresher) view.findViewById(R.id.refresher);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getThis().setSupportActionBar(toolbar);
        XAdapter adapter = new XAdapter(getThis(), null) {
            @Override
            public void bindingHolder(CustomHolder holder, List dataList, int pos) {

            }

            @Override
            protected ViewTypeUnit getViewTypeUnitForLayout(Object item) {
                return null;
            }

            @Override
            protected void creatingHeader(CustomHolder holder, int headerKey) {
                super.creatingHeader(holder, headerKey);
                holder.getView(R.id.liEducation).setOnClickListener(clickListener);
                holder.getView(R.id.liGym).setOnClickListener(clickListener);
                holder.getView(R.id.liMassage).setOnClickListener(clickListener);
                holder.getView(R.id.rlMall).setOnClickListener(clickListener);
                holder.getView(R.id.rlHouseKeep).setOnClickListener(clickListener);
                holder.getView(R.id.ivMore).setOnClickListener(clickListener);

                AdLoopView loopView = holder.getView(R.id.loopView);
                List<String> urls = new ArrayList<>();
                urls.add("res:///" + R.mipmap.syhbbb);
                urls.add("res:///" + R.mipmap.syhbbb);
                urls.add("res:///" + R.mipmap.syhbbb);
                loopView.initData(urls);
                MultiImageView multiImageView = holder.getView(R.id.multiView);
                List<String> images = new ArrayList<>();
                images.add("res:///" + R.mipmap.jrjxuanpic2);
                images.add("res:///" + R.mipmap.jrjxuanpic1);
                images.add("res:///" + R.mipmap.jrjxuanpic2);
                images.add("res:///" + R.mipmap.jrjxuanpic3);
                multiImageView.setList(images);
                multiImageView.setLoadImageListener(new MultiImageView.OnImageLoadListener() {
                    @Override
                    public Uri setPreviewUri(int position) {
                        return null;
                    }
                });
            }

            @Override
            protected void bindingHeader(CustomHolder holder, int pos) {
                super.bindingHeader(holder, pos);
            }
        };
        adapter.addHeader(1, R.layout.header_home);
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
                case R.id.liGym:
                    getThis().start(GymActivity.class);
                    break;
                case R.id.liMassage:
                    getThis().start(MassageActivity.class);
                    break;
                case R.id.liEducation:

                    break;
                case R.id.rlMall:

                    break;
                case R.id.rlHouseKeep:

                    break;
                case R.id.ivMore:

                    break;
                default:
                    break;
            }
        }
    };

    /* @Override
    protected void onLazyLoad() {
        super.onLazyLoad();

        getViewStub().setLayoutResource(R.layout.fragment_home);
        View view = getViewStub().inflate();
        ButterKnife.bind(this, view);
    }*/

}
