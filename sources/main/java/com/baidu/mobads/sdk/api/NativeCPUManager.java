package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.ae;
import com.baidu.mobads.sdk.internal.bq;
import com.baidu.mobads.sdk.internal.bu;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class NativeCPUManager {
    private static final String TAG = "NativeCPUManager";
    private CPUAdListener mCPUAdListener;
    private ae mCPUAdProd;
    private Context mContext;
    private int mPageSize = 10;
    private HashMap<String, Object> mParams = new HashMap<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface CPUAdListener {
        void onAdError(String str, int i6);

        void onAdLoaded(List<IBasicCPUData> list);

        void onDisLikeAdClick(int i6, String str);

        void onExitLp();

        void onLpCustomEventCallBack(HashMap<String, Object> hashMap, DataPostBackListener dataPostBackListener);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface DataPostBackListener {
        void postback(JSONObject jSONObject);
    }

    public void loadAd(int i6, int i7, boolean z5) {
        loadAd(i6, new int[]{i7}, z5);
    }

    private void loadAd(int i6, int[] iArr, boolean z5) {
        if (i6 <= 0 || iArr == null) {
            bu.a().c(TAG, "LoadAd with terrible params!");
            return;
        }
        ae aeVar = this.mCPUAdProd;
        if (aeVar != null) {
            aeVar.a(i6, this.mPageSize, iArr, z5, this.mParams);
            this.mCPUAdProd.e();
            this.mCPUAdProd.a();
        }
    }

    public void openAppActivity(String str) {
        ae aeVar = this.mCPUAdProd;
        if (aeVar != null) {
            aeVar.a(str);
            this.mCPUAdProd.a();
        }
    }

    public void setPageSize(int i6) {
        if (i6 <= 0 || i6 > 20) {
            bu.a().c(TAG, "Input page size is wrong which should be in (0,20]!");
        } else {
            this.mPageSize = i6;
        }
    }

    public void setRequestParameter(CPUAdRequest cPUAdRequest) {
        if (cPUAdRequest == null || cPUAdRequest.getExtras() == null) {
            return;
        }
        this.mParams = cPUAdRequest.getExtras();
    }

    public void setRequestTimeoutMillis(int i6) {
        ae aeVar = this.mCPUAdProd;
        if (aeVar != null) {
            aeVar.a(i6);
        }
    }

    public NativeCPUManager(Context context, String str, CPUAdListener cPUAdListener) {
        this.mCPUAdProd = null;
        if (context != null && !TextUtils.isEmpty(str)) {
            this.mCPUAdListener = cPUAdListener;
            this.mContext = context;
            ae aeVar = new ae(context, str, this);
            this.mCPUAdProd = aeVar;
            aeVar.a(cPUAdListener);
            return;
        }
        bu.a().c(TAG, "Init params error!");
        if (cPUAdListener != null) {
            cPUAdListener.onAdError("Input params error.", bq.INTERFACE_USE_PROBLEM.b());
        }
    }
}
