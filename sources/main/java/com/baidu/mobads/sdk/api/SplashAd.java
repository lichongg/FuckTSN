package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.bb;
import com.baidu.mobads.sdk.internal.bq;
import com.baidu.mobads.sdk.internal.bu;
import com.baidu.mobads.sdk.internal.cs;
import com.baidu.mobads.sdk.internal.dd;
import com.baidu.mobads.sdk.internal.dj;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SplashAd {
    private static final int BOTTOM_VIEW_ID = 4097;
    public static final String KEY_BIDFAIL_ADN = "adn";
    public static final String KEY_BIDFAIL_ECPM = "ecpm";
    public static final String KEY_DISPLAY_DOWNLOADINFO = "displayDownloadInfo";
    public static final String KEY_FETCHAD = "fetchAd";
    public static final String KEY_LOAD_AFTER_CACHE_END = "loadAfterCacheEnd";
    public static final String KEY_POPDIALOG_DOWNLOAD = "use_dialog_frame";
    public static final String KEY_PREFER_FULLSCREEN = "prefer_fullscreen";
    public static final String KEY_SHAKE_LOGO_SIZE = "shake_logo_size";
    public static final String KEY_TIMEOUT = "timeout";
    public static final String KEY_TWIST_BG_COLOR = "twist_bg_color";
    public static final String KEY_TWIST_LOGO_HEIGHT_DP = "twist_logo_height_dp";
    public static final String KEY_USE_ADAPTIVE_AD = "adaptive_ad";
    private static final int RT_SPLASH_LOAD_AD_TIMEOUT = 4200;
    private String mAdPlaceId;
    private dj mAdProd;
    private String mAppSid;
    private int mBidFloor;
    private Context mContext;
    private Boolean mDisplayClickRegion;
    private boolean mDisplayDownInfo;
    private SplashAdDownloadDialogListener mDownloadDialogListener;
    private boolean mFetchAd;
    private boolean mFetchNotShow;
    private boolean mIsAdaptiveSplashAd;
    private Boolean mLimitRegionClick;
    private SplashAdListener mListener;
    private RequestParameters mParameter;
    private Boolean mPopDialogIfDL;
    private int mShakeLogoSize;
    private int mTimeout;
    private int mTipStyle;
    protected int mTwistBgColor;
    protected int mTwistLogoHeightDp;
    private ViewGroup mViewParent;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnFinishListener {
        void onFinishActivity();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface SplashAdDownloadDialogListener {
        void adDownloadWindowClose();

        void adDownloadWindowShow();

        void onADFunctionLpClose();

        void onADFunctionLpShow();

        void onADPermissionClose();

        void onADPermissionShow();

        void onADPrivacyLpClose();

        void onADPrivacyLpShow();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface SplashCardAdListener {
        void onCardClick();

        void onCardClose();

        void onCardShow();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface SplashFocusAdListener {
        void onAdClick();

        void onAdClose();

        void onAdIconShow();

        void onLpClosed();
    }

    public SplashAd(Context context, String str, SplashAdListener splashAdListener) {
        this(context, str, null, splashAdListener);
    }

    public static void registerEnterTransition(Activity activity, SplashFocusAdListener splashFocusAdListener) {
        dj.a(activity, (JSONObject) null, splashFocusAdListener);
    }

    public void finishAndJump(Intent intent) {
        finishAndJump(intent, null);
    }

    public final void show(ViewGroup viewGroup) {
        showWithBottomView(viewGroup, null);
    }

    public SplashAd(Context context, String str, RequestParameters requestParameters, SplashAdListener splashAdListener) {
        this.mTipStyle = 4;
        this.mFetchAd = true;
        this.mFetchNotShow = false;
        this.mDisplayDownInfo = true;
        this.mPopDialogIfDL = Boolean.FALSE;
        Boolean bool = Boolean.TRUE;
        this.mLimitRegionClick = bool;
        this.mDisplayClickRegion = bool;
        this.mTimeout = 4200;
        this.mShakeLogoSize = 60;
        this.mTwistLogoHeightDp = 67;
        this.mTwistBgColor = ViewCompat.MEASURED_STATE_MASK;
        this.mIsAdaptiveSplashAd = false;
        this.mBidFloor = -1;
        this.mListener = new SplashInteractionListener() { // from class: com.baidu.mobads.sdk.api.SplashAd.1
            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onADLoaded() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdCacheFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdCacheSuccess() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdClick() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdDismissed() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdExposed() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onAdFailed(String str2) {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdPresent() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdSkip() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onLpClosed() {
            }
        };
        this.mContext = context;
        this.mAdPlaceId = str;
        if (splashAdListener != null) {
            this.mListener = splashAdListener;
        }
        if (TextUtils.isEmpty(str)) {
            sendSplashFailedLog("请您输入正确的广告位ID");
            this.mListener.onAdFailed("请您输入正确的广告位ID");
            return;
        }
        this.mParameter = requestParameters;
        if (requestParameters == null || requestParameters.getExtras() == null) {
            return;
        }
        String str2 = this.mParameter.getExtras().get(KEY_FETCHAD);
        if (!TextUtils.isEmpty(str2)) {
            this.mFetchAd = Boolean.parseBoolean(str2);
        }
        String str3 = this.mParameter.getExtras().get(KEY_DISPLAY_DOWNLOADINFO);
        if (!TextUtils.isEmpty(str3)) {
            this.mDisplayDownInfo = Boolean.parseBoolean(str3);
        }
        String str4 = this.mParameter.getExtras().get(KEY_POPDIALOG_DOWNLOAD);
        if (!TextUtils.isEmpty(str4)) {
            this.mPopDialogIfDL = Boolean.valueOf(str4);
        }
        String str5 = this.mParameter.getExtras().get(KEY_SHAKE_LOGO_SIZE);
        if (!TextUtils.isEmpty(str5)) {
            this.mShakeLogoSize = Integer.parseInt(str5);
        }
        String str6 = this.mParameter.getExtras().get(KEY_TWIST_LOGO_HEIGHT_DP);
        if (!TextUtils.isEmpty(str6)) {
            this.mTwistLogoHeightDp = Integer.parseInt(str6);
        }
        String str7 = this.mParameter.getExtras().get(KEY_TWIST_BG_COLOR);
        if (!TextUtils.isEmpty(str7)) {
            this.mTwistBgColor = Integer.parseInt(str7);
        }
        String str8 = this.mParameter.getExtras().get("timeout");
        if (!TextUtils.isEmpty(str8)) {
            this.mTimeout = Integer.parseInt(str8);
        }
        String str9 = this.mParameter.getExtras().get(KEY_USE_ADAPTIVE_AD);
        if (TextUtils.isEmpty(str9)) {
            return;
        }
        this.mIsAdaptiveSplashAd = Boolean.parseBoolean(str9);
    }

    private void addZeroPxSurfaceViewAvoidBlink(ViewGroup viewGroup, Context context) {
        try {
            viewGroup.addView(new SurfaceView(context), new RelativeLayout.LayoutParams(0, 0));
        } catch (Exception e6) {
            bu.a().a(e6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callAdFailed(String str) {
        if (this.mListener != null) {
            sendSplashFailedLog(str);
            this.mListener.onAdFailed(str);
        }
    }

    public static void registerEnterTransition(Activity activity, SplashFocusParams splashFocusParams, SplashFocusAdListener splashFocusAdListener) {
        dj.a(activity, splashFocusParams != null ? splashFocusParams.getFocusParams() : null, splashFocusAdListener);
    }

    private void sendSplashFailedLog(String str) {
        try {
            dj djVar = this.mAdProd;
            if (djVar != null) {
                djVar.a(str);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void sendSplashLog(ViewGroup viewGroup, View view) {
        try {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            boolean z5 = false;
            sb.append(viewGroup == null);
            sb.append("");
            hashMap.put("adContainer", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            if (this.mIsAdaptiveSplashAd && view == null) {
                z5 = true;
            }
            sb2.append(z5);
            sb2.append("");
            hashMap.put("isAdaptive", sb2.toString());
            hashMap.put("mFetchNotShow", this.mFetchNotShow + "");
            if (this.mAdProd != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("msg", "sendSplashLog");
                } catch (JSONException e6) {
                    bu.a().a(e6);
                }
                this.mAdProd.a(jSONObject, hashMap);
            }
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }

    private void setAppLogo(Object obj) {
        if (this.mAdProd != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event_type", "splash_logo");
                HashMap hashMap = new HashMap();
                hashMap.put("appLogo", obj);
                this.mAdProd.a(jSONObject, hashMap);
            } catch (Throwable th) {
                bu.a().d(th);
            }
        }
    }

    public void biddingFail(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        dj djVar = this.mAdProd;
        if (djVar != null) {
            djVar.a(false, linkedHashMap, biddingListener);
        }
    }

    public void biddingSuccess(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        dj djVar = this.mAdProd;
        if (djVar != null) {
            djVar.a(true, linkedHashMap, biddingListener);
        }
    }

    public void destroy() {
        dj djVar = this.mAdProd;
        if (djVar != null) {
            djVar.p();
        }
        this.mListener = null;
    }

    public void finishAndJump(Intent intent, OnFinishListener onFinishListener) {
        dj djVar = this.mAdProd;
        if (djVar != null) {
            djVar.a(intent, onFinishListener);
        }
    }

    public Object getAdDataForKey(String str) {
        dj djVar = this.mAdProd;
        if (djVar != null) {
            return djVar.j(str);
        }
        return null;
    }

    public String getBiddingToken() {
        dj djVar = this.mAdProd;
        if (djVar != null) {
            djVar.r();
            this.mAdProd = null;
        }
        float e6 = bb.e(this.mContext);
        Rect a6 = bb.a(this.mContext);
        int width = a6.width();
        int height = a6.height();
        RequestParameters requestParameters = this.mParameter;
        if (requestParameters != null && requestParameters.isCustomSize()) {
            if (this.mParameter.getWidth() > 0) {
                width = (int) (this.mParameter.getWidth() * e6);
            }
            if (this.mParameter.getHeight() > 0) {
                height = (int) (this.mParameter.getHeight() * e6);
            }
        }
        int i6 = height;
        int i7 = width;
        if (i7 < 200.0f * e6 || i6 < e6 * 150.0f) {
            bu.a().c(dd.a().a(bq.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
            SplashAdListener splashAdListener = this.mListener;
            if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
                ((SplashInteractionListener) splashAdListener).onAdDismissed();
            }
            return null;
        }
        dj djVar2 = new dj(this.mContext, this.mAdPlaceId, i7, i6, this.mTipStyle, this.mTimeout, this.mDisplayDownInfo, this.mPopDialogIfDL.booleanValue(), this.mDisplayClickRegion.booleanValue(), this.mLimitRegionClick.booleanValue());
        this.mAdProd = djVar2;
        djVar2.d(this.mShakeLogoSize);
        this.mAdProd.a(this.mTwistLogoHeightDp);
        this.mAdProd.c(this.mTwistBgColor);
        this.mAdProd.h(this.mAppSid);
        dj djVar3 = this.mAdProd;
        djVar3.f10738r = this.mBidFloor;
        djVar3.f11025u = true;
        RequestParameters requestParameters2 = this.mParameter;
        if (requestParameters2 != null) {
            djVar3.a(requestParameters2);
        }
        this.mAdProd.a(this.mListener);
        this.mFetchNotShow = true;
        this.mAdProd.a(this.mDownloadDialogListener);
        return this.mAdProd.l();
    }

    public String getECPMLevel() {
        a g6;
        dj djVar = this.mAdProd;
        return (djVar == null || (g6 = djVar.g()) == null) ? "" : g6.z();
    }

    public String getPECPM() {
        a g6;
        dj djVar = this.mAdProd;
        return (djVar == null || (g6 = djVar.g()) == null) ? "" : g6.A();
    }

    public final boolean hasSplashCardView() {
        dj djVar = this.mAdProd;
        if (djVar != null) {
            return djVar.f();
        }
        return false;
    }

    public boolean isReady() {
        IAdInterListener iAdInterListener;
        dj djVar = this.mAdProd;
        if (djVar == null || (iAdInterListener = djVar.f10733m) == null) {
            return false;
        }
        return iAdInterListener.isAdReady();
    }

    public final void load() {
        dj djVar = this.mAdProd;
        if (djVar != null) {
            djVar.r();
            this.mAdProd = null;
        }
        float e6 = bb.e(this.mContext);
        Rect a6 = bb.a(this.mContext);
        int width = a6.width();
        int height = a6.height();
        RequestParameters requestParameters = this.mParameter;
        if (requestParameters != null && requestParameters.isCustomSize()) {
            if (this.mParameter.getWidth() > 0) {
                width = (int) (this.mParameter.getWidth() * e6);
            }
            if (this.mParameter.getHeight() > 0) {
                height = (int) (this.mParameter.getHeight() * e6);
            }
        }
        int i6 = height;
        int i7 = width;
        if (i7 < 200.0f * e6 || i6 < e6 * 150.0f) {
            bu.a().c(dd.a().a(bq.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
            SplashAdListener splashAdListener = this.mListener;
            if (splashAdListener == null || !(splashAdListener instanceof SplashInteractionListener)) {
                return;
            }
            ((SplashInteractionListener) splashAdListener).onAdDismissed();
            return;
        }
        dj djVar2 = new dj(this.mContext, this.mAdPlaceId, i7, i6, this.mTipStyle, this.mTimeout, this.mDisplayDownInfo, this.mPopDialogIfDL.booleanValue(), this.mDisplayClickRegion.booleanValue(), this.mLimitRegionClick.booleanValue());
        this.mAdProd = djVar2;
        djVar2.d(this.mShakeLogoSize);
        this.mAdProd.a(this.mTwistLogoHeightDp);
        this.mAdProd.c(this.mTwistBgColor);
        this.mAdProd.h(this.mAppSid);
        dj djVar3 = this.mAdProd;
        djVar3.f10738r = this.mBidFloor;
        djVar3.f11025u = true;
        RequestParameters requestParameters2 = this.mParameter;
        if (requestParameters2 != null) {
            djVar3.a(requestParameters2);
        }
        this.mAdProd.a(this.mListener);
        this.mFetchNotShow = true;
        this.mAdProd.a(this.mDownloadDialogListener);
        this.mAdProd.a();
    }

    public void loadAndShow(ViewGroup viewGroup) {
        if (viewGroup == null) {
            if (this.mListener != null) {
                sendSplashFailedLog("传入容器不可以为空");
                this.mListener.onAdFailed("传入容器不可以为空");
                return;
            }
            return;
        }
        if (this.mIsAdaptiveSplashAd) {
            if (this.mListener != null) {
                sendSplashFailedLog("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                this.mListener.onAdFailed("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                return;
            }
            return;
        }
        addZeroPxSurfaceViewAvoidBlink(viewGroup, this.mContext);
        final cs csVar = new cs(this.mContext);
        csVar.a(new cs.a() { // from class: com.baidu.mobads.sdk.api.SplashAd.3
            @Override // com.baidu.mobads.sdk.internal.cs.a
            public boolean onKeyDown(int i6, KeyEvent keyEvent) {
                return false;
            }

            @Override // com.baidu.mobads.sdk.internal.cs.a
            public void dispatchTouchEvent(MotionEvent motionEvent) {
                if (SplashAd.this.mAdProd != null) {
                    SplashAd.this.mAdProd.a(motionEvent);
                }
            }

            @Override // com.baidu.mobads.sdk.internal.cs.a
            public void onAttachedToWindow() {
                if (SplashAd.this.mAdProd != null) {
                    SplashAd.this.mAdProd.n();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.cs.a
            public void onDetachedFromWindow() {
                if (SplashAd.this.mAdProd != null) {
                    SplashAd.this.mAdProd.o();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.cs.a
            public void onLayoutComplete(int i6, int i7) {
                if (SplashAd.this.mAdProd != null) {
                    return;
                }
                float e6 = bb.e(SplashAd.this.mContext);
                if (SplashAd.this.mParameter != null && SplashAd.this.mParameter.isCustomSize()) {
                    if (SplashAd.this.mParameter.getWidth() > 0) {
                        i6 = (int) (SplashAd.this.mParameter.getWidth() * e6);
                    }
                    if (SplashAd.this.mParameter.getHeight() > 0) {
                        i7 = (int) (SplashAd.this.mParameter.getHeight() * e6);
                    }
                }
                int i8 = i6;
                int i9 = i7;
                if (i8 < 200.0f * e6 || i9 < e6 * 150.0f) {
                    bu.a().c(dd.a().a(bq.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
                    if (SplashAd.this.mListener == null || !(SplashAd.this.mListener instanceof SplashInteractionListener)) {
                        return;
                    }
                    ((SplashInteractionListener) SplashAd.this.mListener).onAdDismissed();
                    return;
                }
                SplashAd.this.mAdProd = new dj(SplashAd.this.mContext, SplashAd.this.mAdPlaceId, i8, i9, SplashAd.this.mTipStyle, SplashAd.this.mTimeout, SplashAd.this.mDisplayDownInfo, SplashAd.this.mPopDialogIfDL.booleanValue(), SplashAd.this.mDisplayClickRegion.booleanValue(), SplashAd.this.mLimitRegionClick.booleanValue());
                SplashAd.this.mAdProd.a(csVar);
                SplashAd.this.mAdProd.d(SplashAd.this.mShakeLogoSize);
                SplashAd.this.mAdProd.a(SplashAd.this.mTwistLogoHeightDp);
                SplashAd.this.mAdProd.c(SplashAd.this.mTwistBgColor);
                SplashAd.this.mAdProd.h(SplashAd.this.mAppSid);
                SplashAd.this.mAdProd.f10738r = SplashAd.this.mBidFloor;
                SplashAd.this.mAdProd.a(SplashAd.this.mListener);
                if (SplashAd.this.mParameter != null) {
                    SplashAd.this.mAdProd.a(SplashAd.this.mParameter);
                }
                SplashAd.this.mAdProd.f11025u = false;
                SplashAd.this.mAdProd.a(SplashAd.this.mDownloadDialogListener);
                SplashAd.this.mAdProd.a();
            }

            @Override // com.baidu.mobads.sdk.internal.cs.a
            public void onWindowFocusChanged(boolean z5) {
                if (SplashAd.this.mAdProd != null) {
                    SplashAd.this.mAdProd.a(z5);
                }
            }

            @Override // com.baidu.mobads.sdk.internal.cs.a
            public void onWindowVisibilityChanged(int i6) {
                if (SplashAd.this.mAdProd != null) {
                    SplashAd.this.mAdProd.b(i6);
                }
            }
        });
        csVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        viewGroup.addView(csVar);
    }

    public void loadBiddingAd(String str) {
        dj djVar = this.mAdProd;
        if (djVar != null) {
            djVar.c(str);
        }
    }

    public void setAppSid(String str) {
        this.mAppSid = str;
    }

    public void setBidFloor(int i6) {
        this.mBidFloor = i6;
    }

    @Deprecated
    public void setBiddingData(String str) {
        dj djVar = this.mAdProd;
        if (djVar != null) {
            djVar.b(str);
        }
    }

    public void setDownloadDialogListener(SplashAdDownloadDialogListener splashAdDownloadDialogListener) {
        this.mDownloadDialogListener = splashAdDownloadDialogListener;
        dj djVar = this.mAdProd;
        if (djVar != null) {
            djVar.a(splashAdDownloadDialogListener);
        }
    }

    public void setListener(SplashAdListener splashAdListener) {
        this.mListener = splashAdListener;
        dj djVar = this.mAdProd;
        if (djVar != null) {
            djVar.a(splashAdListener);
        }
    }

    public final boolean showSplashCardView(Activity activity, SplashCardAdListener splashCardAdListener) {
        dj djVar = this.mAdProd;
        if (djVar == null) {
            return false;
        }
        djVar.a(splashCardAdListener);
        return this.mAdProd.b(activity);
    }

    private final void setAppLogoData(byte[] bArr) {
        setAppLogo(bArr);
    }

    private final void setAppLogoId(int i6) {
        setAppLogo(Integer.valueOf(i6));
    }

    private final void showWithBottomView(ViewGroup viewGroup, View view) {
        sendSplashLog(viewGroup, view);
        this.mViewParent = viewGroup;
        if (viewGroup == null) {
            if (this.mListener != null) {
                sendSplashFailedLog("传入容器不可以为空");
                this.mListener.onAdFailed("传入容器不可以为空");
                return;
            }
            return;
        }
        if (this.mIsAdaptiveSplashAd && view == null) {
            if (this.mListener != null) {
                sendSplashFailedLog("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                this.mListener.onAdFailed("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                return;
            }
            return;
        }
        if (!this.mFetchNotShow) {
            dj djVar = this.mAdProd;
            if (djVar != null) {
                djVar.r();
            }
            callAdFailed("展现失败，请重新load");
            return;
        }
        this.mFetchNotShow = false;
        dj djVar2 = this.mAdProd;
        if (djVar2 != null) {
            final cs csVar = new cs(this.mContext);
            csVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            if (view != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                view.setId(4097);
                csVar.addView(view, layoutParams);
            }
            csVar.a(new cs.a() { // from class: com.baidu.mobads.sdk.api.SplashAd.2
                private boolean mIsFirstOnLayout = true;

                @Override // com.baidu.mobads.sdk.internal.cs.a
                public boolean onKeyDown(int i6, KeyEvent keyEvent) {
                    return false;
                }

                @Override // com.baidu.mobads.sdk.internal.cs.a
                public void dispatchTouchEvent(MotionEvent motionEvent) {
                    SplashAd.this.mAdProd.a(motionEvent);
                }

                @Override // com.baidu.mobads.sdk.internal.cs.a
                public void onAttachedToWindow() {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.n();
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.cs.a
                public void onDetachedFromWindow() {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.o();
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.cs.a
                public void onLayoutComplete(int i6, int i7) {
                    if (this.mIsFirstOnLayout) {
                        if (SplashAd.this.mAdProd == null) {
                            SplashAd.this.callAdFailed("展现失败，请检查splashAd参数是否正确");
                            return;
                        }
                        SplashAd.this.mAdProd.f11025u = false;
                        SplashAd.this.mFetchNotShow = false;
                        this.mIsFirstOnLayout = false;
                        SplashAd.this.mAdProd.a(csVar);
                        SplashAd.this.mAdProd.e();
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.cs.a
                public void onWindowFocusChanged(boolean z5) {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.a(z5);
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.cs.a
                public void onWindowVisibilityChanged(int i6) {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.b(i6);
                    }
                }
            });
            this.mViewParent.addView(csVar);
            return;
        }
        if (djVar2 != null) {
            djVar2.r();
        }
        callAdFailed("展现失败，请检查splashAd参数是否正确");
    }

    public static void registerEnterTransition(Activity activity, int i6, int i7, SplashFocusAdListener splashFocusAdListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("right_margin", i6);
            jSONObject.put("bottom_margin", i7);
        } catch (JSONException e6) {
            bu.a().a(e6);
        }
        dj.a(activity, jSONObject, splashFocusAdListener);
    }

    @Deprecated
    public static void registerEnterTransition(Activity activity, int i6, int i7, int i8, SplashFocusAdListener splashFocusAdListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("right_margin", i6);
            jSONObject.put("bottom_margin", i7);
            jSONObject.put("anim_offset_y", i8);
        } catch (JSONException e6) {
            bu.a().a(e6);
        }
        dj.a(activity, jSONObject, splashFocusAdListener);
    }
}
