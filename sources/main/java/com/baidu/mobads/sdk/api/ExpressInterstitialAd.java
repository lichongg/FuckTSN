package com.baidu.mobads.sdk.api;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.az;
import com.baidu.mobads.sdk.internal.cs;
import com.baidu.mobads.sdk.internal.de;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ExpressInterstitialAd {
    private InterstitialAdDislikeListener mAdDislikeListener;
    private String mAdPlaceId;
    private String mAppsid;
    private int mBidFloor;
    private Context mContext;
    private ExpressInterstitialListener mExpressInterstitialListener;
    private int mHeight;
    private InterAdDownloadWindowListener mInterAdDownloadWindowListener;
    private long mLoadTime;
    private de mNativeInterstitialAdProd;
    private RequestParameters mRequestParameters;
    private boolean mUseDialogContainer;
    private boolean mUseDialogFrame;
    private int mWidth;
    private boolean onlyFetchAd;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface InterAdDownloadWindowListener {
        void adDownloadWindowClose();

        void adDownloadWindowShow();

        void onADPermissionClose();

        void onADPermissionShow();

        void onADPrivacyClick();

        void onADPrivacyClose();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface InterstitialAdDislikeListener {
        void interstitialAdDislikeClick();
    }

    public ExpressInterstitialAd(Context context, String str) {
        this(context, str, 500, 600);
    }

    public String getBiddingToken() {
        this.onlyFetchAd = true;
        initNativeInterstitialAdProd();
        return this.mNativeInterstitialAdProd.l();
    }

    public void show() {
        de deVar = this.mNativeInterstitialAdProd;
        if (deVar == null) {
            return;
        }
        if (deVar.f()) {
            this.mNativeInterstitialAdProd.g();
        } else {
            this.mNativeInterstitialAdProd.f((IOAdEvent) null);
        }
    }

    public ExpressInterstitialAd(Context context, String str, int i6, int i7) {
        this.mUseDialogFrame = false;
        this.mBidFloor = -1;
        this.mUseDialogContainer = false;
        this.mContext = context;
        this.mAdPlaceId = str;
        this.mWidth = i6;
        this.mHeight = i7;
    }

    public void biddingFail(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        de deVar = this.mNativeInterstitialAdProd;
        if (deVar != null) {
            deVar.a(false, linkedHashMap, biddingListener);
        }
    }

    public void biddingSuccess(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        de deVar = this.mNativeInterstitialAdProd;
        if (deVar != null) {
            deVar.a(true, linkedHashMap, biddingListener);
        }
    }

    public void destroy() {
        de deVar = this.mNativeInterstitialAdProd;
        if (deVar == null) {
            return;
        }
        deVar.p();
    }

    public Object getAdDataForKey(String str) {
        de deVar = this.mNativeInterstitialAdProd;
        if (deVar != null) {
            return deVar.a(str);
        }
        return null;
    }

    public String getECPMLevel() {
        a x5;
        de deVar = this.mNativeInterstitialAdProd;
        return (deVar == null || (x5 = deVar.x()) == null) ? "" : x5.z();
    }

    public String getPECPM() {
        a x5;
        de deVar = this.mNativeInterstitialAdProd;
        return (deVar == null || (x5 = deVar.x()) == null) ? "" : x5.A();
    }

    public boolean isReady() {
        IAdInterListener iAdInterListener;
        de deVar = this.mNativeInterstitialAdProd;
        if (deVar == null || (iAdInterListener = deVar.f10733m) == null) {
            return false;
        }
        return iAdInterListener.isAdReady();
    }

    public void loadBiddingAd(String str) {
        de deVar = this.mNativeInterstitialAdProd;
        if (deVar != null) {
            deVar.c(str);
        }
    }

    public void setAdDislikeListener(InterstitialAdDislikeListener interstitialAdDislikeListener) {
        this.mAdDislikeListener = interstitialAdDislikeListener;
    }

    public void setAppSid(String str) {
        this.mAppsid = str;
    }

    public void setBidFloor(int i6) {
        this.mBidFloor = i6;
    }

    @Deprecated
    public void setBiddingData(String str) {
        de deVar = this.mNativeInterstitialAdProd;
        if (deVar != null) {
            deVar.b(str);
        }
    }

    public void setDialogFrame(boolean z5) {
        this.mUseDialogFrame = z5;
    }

    public void setDownloadListener(InterAdDownloadWindowListener interAdDownloadWindowListener) {
        this.mInterAdDownloadWindowListener = interAdDownloadWindowListener;
    }

    public void setLoadListener(ExpressInterstitialListener expressInterstitialListener) {
        this.mExpressInterstitialListener = expressInterstitialListener;
        de deVar = this.mNativeInterstitialAdProd;
        if (deVar != null) {
            deVar.a(expressInterstitialListener);
        }
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        this.mRequestParameters = requestParameters;
    }

    public void useUseDialogContainer(boolean z5) {
        this.mUseDialogContainer = z5;
    }

    private void initNativeInterstitialAdProd() {
        System.currentTimeMillis();
        cs csVar = new cs(this.mContext);
        csVar.a(new cs.a() { // from class: com.baidu.mobads.sdk.api.ExpressInterstitialAd.1
            @Override // com.baidu.mobads.sdk.internal.cs.a
            public boolean onKeyDown(int i6, KeyEvent keyEvent) {
                return i6 == 4;
            }

            @Override // com.baidu.mobads.sdk.internal.cs.a
            public void dispatchTouchEvent(MotionEvent motionEvent) {
                ExpressInterstitialAd.this.mNativeInterstitialAdProd.a(motionEvent);
            }

            @Override // com.baidu.mobads.sdk.internal.cs.a
            @SuppressLint({"MissingSuperCall"})
            public void onDetachedFromWindow() {
                if (ExpressInterstitialAd.this.mNativeInterstitialAdProd != null) {
                    ExpressInterstitialAd.this.mNativeInterstitialAdProd.o();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.cs.a
            public void onAttachedToWindow() {
            }

            @Override // com.baidu.mobads.sdk.internal.cs.a
            public void onWindowFocusChanged(boolean z5) {
            }

            @Override // com.baidu.mobads.sdk.internal.cs.a
            public void onWindowVisibilityChanged(int i6) {
            }

            @Override // com.baidu.mobads.sdk.internal.cs.a
            public void onLayoutComplete(int i6, int i7) {
            }
        });
        this.mNativeInterstitialAdProd = new de(this.mContext, csVar, this.mAdPlaceId);
        if (!TextUtils.isEmpty(this.mAppsid)) {
            this.mNativeInterstitialAdProd.f10737q = this.mAppsid;
        }
        de deVar = this.mNativeInterstitialAdProd;
        deVar.f10738r = this.mBidFloor;
        deVar.f10996t = this.onlyFetchAd;
        deVar.a(this.mExpressInterstitialListener);
        this.mNativeInterstitialAdProd.a(this.mInterAdDownloadWindowListener);
        this.mNativeInterstitialAdProd.a(this.mAdDislikeListener);
        this.mNativeInterstitialAdProd.c(this.mUseDialogFrame);
        this.mNativeInterstitialAdProd.d(this.mUseDialogContainer);
        RequestParameters requestParameters = this.mRequestParameters;
        if (requestParameters != null) {
            this.mNativeInterstitialAdProd.a(requestParameters);
        }
    }

    private void reallyLoad() {
        initNativeInterstitialAdProd();
        this.mNativeInterstitialAdProd.a();
    }

    public void load() {
        this.mLoadTime = System.currentTimeMillis();
        if (this.mContext == null) {
            az.c().e("ExpressInterstitialAd", "请传一个非空的context再进行load");
        } else {
            this.onlyFetchAd = true;
            reallyLoad();
        }
    }

    public void show(Activity activity) {
        de deVar = this.mNativeInterstitialAdProd;
        if (deVar == null) {
            return;
        }
        deVar.a(activity);
        show();
    }
}
