package com.taichitiger.client.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import com.taichitiger.client.R;
import com.taichitiger.client.extend.BaseActivity;
import com.xycode.xylibrary.uiKit.views.TouchImageView;
import com.xycode.xylibrary.utils.ImageUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhotoActivity extends BaseActivity {

    @Bind(R.id.ivPhoto)
    TouchImageView ivPhoto;

    private String url;

    public static void startThis(Activity activity, String url) {
        activity.startActivity(new Intent(activity, PhotoActivity.class).putExtra("url", url));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        ButterKnife.bind(this);
        url = getIntent().getStringExtra("url");
        if (url != null && !"".equals(url)) {
            ImageUtils.loadBitmapFromFresco(this, Uri.parse(url), new ImageUtils.IGetFrescoBitmap() {
                @Override
                public void afterGotBitmap(final Bitmap bitmap) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ivPhoto.setImageBitmap(bitmap);
                        }
                    });
                }
            });
        }
    }

    @OnClick(R.id.ivPhoto)
    public void onClick() {
        PhotoActivity.this.finish();
    }
}
