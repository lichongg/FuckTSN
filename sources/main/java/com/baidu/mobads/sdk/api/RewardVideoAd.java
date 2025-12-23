package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.az;
import com.baidu.mobads.sdk.internal.bu;
import com.baidu.mobads.sdk.internal.di;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RewardVideoAd {
    public static final int DOWNLOAD_APP_CONFIRM_NEVER = 3;
    public static final int DOWNLOAD_APP_CONFIRM_ONLY_MOBILE = 1;
    private static final String TAG = "RewardVideoAd";
    private di mAdProd;
    private final Context mContext;
    private RequestParameters mRequestParameters;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface RewardVideoAdListener extends ScreenVideoAdListener {
        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClick();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClose(float f6);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdFailed(String str);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdLoaded();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdShow();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdSkip(float f6);

        void onRewardVerify(boolean z5);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadFailed();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadSuccess();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void playCompletion();
    }

    public RewardVideoAd(Context context, String str, RewardVideoAdListener rewardVideoAdListener) {
        this(context, str, rewardVideoAdListener, false);
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

    public RewardVideoAd(Context context, String str, RewardVideoAdListener rewardVideoAdListener, boolean z5) {
        this.mContext = context;
        di diVar = new di(context, str, z5);
        this.mAdProd = diVar;
        diVar.a(rewardVideoAdListener);
        if (TextUtils.isEmpty(str)) {
            az.c().e("RewardVideoAd初始化异常：广告位为空");
        }
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

    public Object getAdDataForKey(String str) {
        di diVar = this.mAdProd;
        if (diVar != null) {
            return diVar.k(str);
        }
        return null;
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

    @Deprecated
    public void setDownloadAppConfirmPolicy(int i6) {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.a(i6);
        }
    }

    public void setExtraInfo(String str) {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.j(str);
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

    public void setShowDialogOnSkip(boolean z5) {
        if (this.mAdProd != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("showDialogOnSkip", z5);
                this.mAdProd.a(jSONObject);
            } catch (Throwable th) {
                bu.a().c(th);
            }
        }
    }

    public void setUserId(String str) {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.a(str);
        }
    }

    public synchronized void show(Context context) {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.a(context);
        }
    }
}
