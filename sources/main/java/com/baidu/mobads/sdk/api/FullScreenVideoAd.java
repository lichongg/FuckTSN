package com.baidu.mobads.sdk.api;

import android.content.Context;
import com.baidu.mobads.sdk.internal.dg;
import com.baidu.mobads.sdk.internal.di;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FullScreenVideoAd {
    private static final String TAG = "FullScreenVideoAd";
    private di mAdProd;
    private final Context mContext;
    private RequestParameters mRequestParameters;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface FullScreenVideoAdListener extends ScreenVideoAdListener {
        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClick();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClose(float f6);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdFailed(String str);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdShow();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdSkip(float f6);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadFailed();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadSuccess();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void playCompletion();
    }

    public FullScreenVideoAd(Context context, String str, FullScreenVideoAdListener fullScreenVideoAdListener) {
        this(context, str, fullScreenVideoAdListener, false);
    }

    public synchronized void load() {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.a();
        }
    }

    public synchronized void show() {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.e();
        }
    }

    public FullScreenVideoAd(Context context, String str, FullScreenVideoAdListener fullScreenVideoAdListener, boolean z5) {
        this.mContext = context;
        dg dgVar = new dg(context, str, z5);
        this.mAdProd = dgVar;
        dgVar.a(fullScreenVideoAdListener);
    }

    public void biddingFail(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.a(false, linkedHashMap, biddingListener);
        }
    }

    public void biddingSuccess(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.a(true, linkedHashMap, biddingListener);
        }
    }

    public String getBiddingToken() {
        di diVar = this.mAdProd;
        if (diVar != null) {
            return diVar.l();
        }
        return null;
    }

    public String getECPMLevel() {
        di diVar = this.mAdProd;
        return diVar != null ? diVar.g() : "";
    }

    public String getPECPM() {
        di diVar = this.mAdProd;
        return diVar != null ? diVar.x() : "";
    }

    public boolean isReady() {
        di diVar = this.mAdProd;
        if (diVar != null) {
            return diVar.f();
        }
        return false;
    }

    public void loadBiddingAd(String str) {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.c(str);
        }
    }

    public void setAppSid(String str) {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.h(str);
        }
    }

    public void setBidFloor(int i6) {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.f10738r = i6;
        }
    }

    @Deprecated
    public void setBiddingData(String str) {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.b(str);
        }
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        di diVar;
        this.mRequestParameters = requestParameters;
        if (requestParameters == null || (diVar = this.mAdProd) == null) {
            return;
        }
        diVar.a(requestParameters);
    }

    public synchronized void show(Context context) {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.a(context);
        }
    }
}
