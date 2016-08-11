package com.taichitiger.client;

import android.app.Application;

import com.alibaba.fastjson.JSONObject;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.xycode.xylibrary.okHttp.Header;
import com.xycode.xylibrary.okHttp.OkHttp;
import com.xycode.xylibrary.okHttp.Param;
import com.xycode.xylibrary.utils.TS;
import com.xycode.xylibrary.utils.Tools;
import com.xycode.xylibrary.xRefresher.XRefresher;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by XY on 2016-07-27.
 * add gitLab
 */
public class App extends Application {

    private static App instance = null;

    public static App getInstance() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (instance!=null) {
            if (Tools.isProcessRunning(this)) {
                return;
            }
            return;
        }
        instance = this;
        TS.init(this);
        Fresco.initialize(this);

        OkHttp.init(new OkHttp.IOkInit() {
            @Override
            public int judgeResultWhenFirstReceivedResponse(Call call, Response response, JSONObject json) {
                switch (json.getInteger("resultCode")) {
                    case 1:
                        return OkHttp.RESULT_SUCCESS;
                    case 0:
                        return OkHttp.RESULT_ERROR;
                    case -1:
                        return OkHttp.RESULT_VERIFY_ERROR;
                    default:
                        return OkHttp.RESULT_OTHER;
                }
            }

            @Override
            public void networkError(Call call, boolean isCanceled) {
                TS.show(getString(R.string.ts_response_failure));
            }

            @Override
            public void receivedNetworkErrorCode(Call call, Response response) {

            }

            @Override
            public boolean resultSuccessByJudge(Call call, Response response, JSONObject json, int resultCode) {
                if (resultCode == OkHttp.RESULT_VERIFY_ERROR) {
                    return true;
                }
                return false;
            }

            @Override
            public void judgeResultParseResponseFailed(Call call, Response response) {

            }

            @Override
            public Param setDefaultParams(Param defaultParams) {
                return defaultParams;
            }

            @Override
            public Header setDefaultHeader(Header defaultHeader) {
                return defaultHeader;
            }
        });

        XRefresher.setLoadingArrowColor(R.color.colorAccent);
    }
}
