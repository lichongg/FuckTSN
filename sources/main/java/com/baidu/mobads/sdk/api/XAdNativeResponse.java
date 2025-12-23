package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.al;
import com.baidu.mobads.sdk.internal.at;
import com.baidu.mobads.sdk.internal.bu;
import com.baidu.mobads.sdk.internal.cr;
import com.baidu.mobads.sdk.internal.df;
import com.baidu.mobads.sdk.internal.r;
import com.stub.StubApp;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class XAdNativeResponse implements NativeResponse {
    private static final String TAG = "NativeResponse";
    private boolean isDownloadApp;
    private int mAdActionType = 1;
    private NativeResponse.AdCloseListener mAdCloseListener;
    private NativeResponse.AdDislikeListener mAdDislikeListener;
    private a mAdInstanceInfo;
    private NativeResponse.AdInteractionListener mAdInteractionListener;
    private NativeResponse.AdPrivacyListener mAdPrivacyListener;
    private NativeResponse.AdShakeViewListener mAdShakeViewListener;
    private NativeResponse.AdShakeViewListener mCouponFloatViewListener;
    private NativeResponse.CustomizeMediaPlayer mCustomizeMediaPlayer;
    private Context mCxt;
    private df mFeedsProd;
    private String mNoAdUniqueId;
    private cr mUriUtils;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.baidu.mobads.sdk.api.XAdNativeResponse$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class DislikeInfo implements DislikeEvent {
        private String dislikeName;
        private int dislikeType;

        private DislikeInfo() {
        }

        /* synthetic */ DislikeInfo(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.baidu.mobads.sdk.api.DislikeEvent
        public String getDislikeName() {
            return this.dislikeName;
        }

        @Override // com.baidu.mobads.sdk.api.DislikeEvent
        public int getDislikeType() {
            return this.dislikeType;
        }
    }

    void handleClick(View view) {
        handleClick(view, -1);
    }

    private int getActionType() {
        return this.mAdInstanceInfo.p();
    }

    private IAdInterListener getAdInterListener() {
        df dfVar = this.mFeedsProd;
        if (dfVar != null) {
            return dfVar.f10733m;
        }
        return null;
    }

    private String getProd() {
        df dfVar = this.mFeedsProd;
        return dfVar != null ? dfVar.e() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void biddingFail(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        if (this.mFeedsProd != null) {
            String str = this.mNoAdUniqueId;
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                str = aVar.I();
            }
            this.mFeedsProd.a(str, false, linkedHashMap, biddingListener);
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void biddingSuccess(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        df dfVar;
        a aVar = this.mAdInstanceInfo;
        if (aVar == null || (dfVar = this.mFeedsProd) == null) {
            return;
        }
        dfVar.a(aVar.I(), true, linkedHashMap, biddingListener);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void cancelAppDownload() {
        if (this.mCxt == null || !this.isDownloadApp || this.mFeedsProd == null) {
            return;
        }
        JSONObject U = this.mAdInstanceInfo.U();
        try {
            U.put(d.S, getAppPackage());
            U.put("msg", "cancelDownload");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.a(U);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void clearImpressionTaskWhenBack() {
        df dfVar = this.mFeedsProd;
        if (dfVar != null) {
            dfVar.o();
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void dislikeClick(DislikeEvent dislikeEvent) {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null || this.mFeedsProd == null || !(dislikeEvent instanceof DislikeInfo)) {
            return;
        }
        JSONObject U = aVar.U();
        try {
            U.put("dislike_type", dislikeEvent.getDislikeType());
            U.put("msg", "dislike_click");
        } catch (Exception unused) {
        }
        this.mFeedsProd.a(U);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void functionClick() {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null || this.mFeedsProd == null) {
            return;
        }
        String E = aVar.E();
        JSONObject U = this.mAdInstanceInfo.U();
        try {
            U.put("function_link", E);
            U.put("msg", "functionClick");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.a(U);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getActButtonString() {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null) {
            return "";
        }
        JSONObject U = aVar.U();
        try {
            U.put("msg", "creative_call");
            U.put("creative_type", "cta_get");
        } catch (Exception unused) {
        }
        this.mFeedsProd.a(U);
        return this.mAdInstanceInfo.N();
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getAdActionType() {
        return this.mAdActionType;
    }

    public NativeResponse.AdCloseListener getAdCloseListener() {
        return this.mAdCloseListener;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public Object getAdDataForKey(String str) {
        if (this.mAdInstanceInfo != null) {
            return "request_id".equals(str) ? this.mAdInstanceInfo.V() : "dp_id".equals(str) ? this.mAdInstanceInfo.W() : this.mAdInstanceInfo.a(str);
        }
        return null;
    }

    public NativeResponse.AdDislikeListener getAdDislikeListener() {
        return this.mAdDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAdLogoUrl() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.h() : "https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAdMaterialType() {
        a aVar = this.mAdInstanceInfo;
        return aVar == null ? NativeResponse.MaterialType.NORMAL.getValue() : "video".equals(aVar.x()) ? NativeResponse.MaterialType.VIDEO.getValue() : a.f10505f.equals(this.mAdInstanceInfo.x()) ? NativeResponse.MaterialType.HTML.getValue() : NativeResponse.MaterialType.NORMAL.getValue();
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppFunctionLink() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.E() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppPackage() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.m() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppPermissionLink() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.F() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppPrivacyLink() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.D() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public long getAppSize() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.j();
        }
        return 0L;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppVersion() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.B() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getBaiduLogoUrl() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.i() : "https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getBrandName() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.g() : "";
    }

    public List<String> getBtnStyleColors() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.P();
        }
        return null;
    }

    public int getBtnStyleType() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.O();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getContainerHeight() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.s();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getContainerSizeType() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.t();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getContainerWidth() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.r();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public NativeResponse.CustomizeMediaPlayer getCustomizeMediaPlayer() {
        a aVar;
        if (this.mCustomizeMediaPlayer == null && (aVar = this.mAdInstanceInfo) != null && aVar.T() == 1) {
            this.mCustomizeMediaPlayer = new r(this.mFeedsProd, this.mAdInstanceInfo);
        }
        return this.mCustomizeMediaPlayer;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getDesc() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.b() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public List<DislikeEvent> getDislikeList() {
        ArrayList arrayList = new ArrayList();
        if (this.mAdInstanceInfo != null && this.mFeedsProd != null) {
            try {
                HashMap hashMap = new HashMap();
                JSONObject U = this.mAdInstanceInfo.U();
                U.put("msg", "dislike_mapping");
                this.mFeedsProd.a(U, hashMap);
                Object obj = hashMap.get("dislike_data");
                if (obj instanceof Map) {
                    Map map = (Map) obj;
                    for (String str : map.keySet()) {
                        DislikeInfo dislikeInfo = new DislikeInfo(null);
                        dislikeInfo.dislikeName = str;
                        dislikeInfo.dislikeType = ((Integer) map.get(str)).intValue();
                        arrayList.add(dislikeInfo);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getDownloadStatus() {
        Context context;
        if (!this.isDownloadApp || (context = this.mCxt) == null) {
            return -1;
        }
        return at.a(StubApp.getOrigApplicationContext(context.getApplicationContext())).a(StubApp.getOrigApplicationContext(this.mCxt.getApplicationContext()), getAppPackage());
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getDuration() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.w();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getECPMLevel() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.z() : "";
    }

    public JSONObject getExtraParams() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.J();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public Map<String, String> getExtras() {
        HashMap hashMap = new HashMap();
        df dfVar = this.mFeedsProd;
        if (dfVar != null) {
            hashMap.put("appsid", dfVar.f10737q);
        }
        return hashMap;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getHtmlSnippet() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.o() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getIconUrl() {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null) {
            return "";
        }
        String c6 = aVar.c();
        return TextUtils.isEmpty(c6) ? this.mAdInstanceInfo.d() : c6;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getImageUrl() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.d() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getMainPicHeight() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.f();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getMainPicWidth() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.e();
        }
        return 0;
    }

    public String getMarketingDesc() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.L() : "";
    }

    public String getMarketingICONUrl() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.K() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getMarketingPendant() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.M() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public NativeResponse.MaterialType getMaterialType() {
        a aVar = this.mAdInstanceInfo;
        return aVar == null ? NativeResponse.MaterialType.NORMAL : "video".equals(aVar.x()) ? NativeResponse.MaterialType.VIDEO : a.f10505f.equals(this.mAdInstanceInfo.x()) ? NativeResponse.MaterialType.HTML : NativeResponse.MaterialType.NORMAL;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public List<String> getMultiPicUrls() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.H();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getPECPM() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.A() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getPublisher() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.C() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getStyleType() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.u();
        }
        return 0;
    }

    public List<String> getThirdTrackers(String str) {
        if (this.mAdInstanceInfo == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject Q = this.mAdInstanceInfo.Q();
            if (Q != null) {
                Iterator<String> keys = Q.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next.equals(str)) {
                        JSONArray optJSONArray = Q.optJSONArray(next);
                        for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                            arrayList.add(optJSONArray.optString(i6));
                        }
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getTitle() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.a() : "";
    }

    public String getUniqueId() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.I() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getVideoUrl() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.n() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public WebView getWebView() {
        df dfVar = this.mFeedsProd;
        if (dfVar != null) {
            return (WebView) dfVar.w();
        }
        return null;
    }

    void handleClick(View view, int i6) {
        handleClick(view, i6, false);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isAdAvailable(Context context) {
        return this.mAdInstanceInfo != null && System.currentTimeMillis() - this.mAdInstanceInfo.y() <= this.mAdInstanceInfo.G();
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isAutoPlay() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null && aVar.k() == 1;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isNeedDownloadApp() {
        return this.isDownloadApp;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isNonWifiAutoPlay() {
        a aVar = this.mAdInstanceInfo;
        return aVar == null || aVar.l() == 1;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isReady(Context context) {
        return this.mAdInstanceInfo != null && System.currentTimeMillis() - this.mAdInstanceInfo.y() <= this.mAdInstanceInfo.G();
    }

    public int isRegionClick() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.R();
        }
        return 2;
    }

    public int isShowDialog() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.S();
        }
        return 2;
    }

    public void onADExposed() {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onADExposed();
        }
    }

    public void onADExposureFailed(int i6) {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onADExposureFailed(i6);
        }
    }

    public void onADFunctionClick() {
        NativeResponse.AdPrivacyListener adPrivacyListener = this.mAdPrivacyListener;
        if (adPrivacyListener != null) {
            adPrivacyListener.onADFunctionClick();
        }
    }

    public void onADPermissionShow(boolean z5) {
        NativeResponse.AdPrivacyListener adPrivacyListener = this.mAdPrivacyListener;
        if (adPrivacyListener != null) {
            if (z5) {
                adPrivacyListener.onADPermissionShow();
            } else {
                adPrivacyListener.onADPermissionClose();
            }
        }
    }

    public void onADPrivacyClick() {
        NativeResponse.AdPrivacyListener adPrivacyListener = this.mAdPrivacyListener;
        if (adPrivacyListener != null) {
            adPrivacyListener.onADPrivacyClick();
        }
    }

    public void onADStatusChanged() {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onADStatusChanged();
        }
    }

    public void onAdClick() {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClick();
        }
    }

    public void onAdClose(NativeResponse nativeResponse) {
        NativeResponse.AdCloseListener adCloseListener = this.mAdCloseListener;
        if (adCloseListener != null) {
            adCloseListener.onAdClose(nativeResponse);
        }
    }

    public void onAdDownloadWindow(boolean z5) {
        NativeResponse.AdPrivacyListener adPrivacyListener = this.mAdPrivacyListener;
        if (adPrivacyListener == null || !(adPrivacyListener instanceof NativeResponse.AdDownloadWindowListener)) {
            return;
        }
        if (z5) {
            ((NativeResponse.AdDownloadWindowListener) adPrivacyListener).adDownloadWindowShow();
        } else {
            ((NativeResponse.AdDownloadWindowListener) adPrivacyListener).adDownloadWindowClose();
        }
    }

    public void onAdUnionClick() {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onAdUnionClick();
        }
    }

    public void onCouponFloatDismiss() {
        NativeResponse.AdShakeViewListener adShakeViewListener = this.mCouponFloatViewListener;
        if (adShakeViewListener != null) {
            adShakeViewListener.onDismiss();
        }
    }

    public void onDislikeClick(String str) {
        NativeResponse.AdDislikeListener adDislikeListener = this.mAdDislikeListener;
        if (adDislikeListener != null) {
            adDislikeListener.onDislikeItemClick(str);
        }
    }

    public void onDislikeClose() {
        NativeResponse.AdDislikeListener adDislikeListener = this.mAdDislikeListener;
        if (adDislikeListener != null) {
            adDislikeListener.onDislikeWindowClose();
        }
    }

    public void onDislikeShow() {
        NativeResponse.AdDislikeListener adDislikeListener = this.mAdDislikeListener;
        if (adDislikeListener != null) {
            adDislikeListener.onDislikeWindowShow();
        }
    }

    public void onShakeViewDismiss() {
        NativeResponse.AdShakeViewListener adShakeViewListener = this.mAdShakeViewListener;
        if (adShakeViewListener != null) {
            adShakeViewListener.onDismiss();
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void pauseAppDownload() {
        if (this.mCxt == null || !this.isDownloadApp || this.mFeedsProd == null) {
            return;
        }
        JSONObject U = this.mAdInstanceInfo.U();
        try {
            U.put(d.S, getAppPackage());
            U.put("msg", "pauseDownload");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.a(U);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void permissionClick() {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null || this.mFeedsProd == null) {
            return;
        }
        String F = aVar.F();
        JSONObject U = this.mAdInstanceInfo.U();
        try {
            U.put("permissionUrl", F);
            U.put("msg", "permissionClick");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.a(U);
    }

    public void preloadVideoMaterial() {
        a aVar;
        if (this.mFeedsProd == null || (aVar = this.mAdInstanceInfo) == null) {
            return;
        }
        JSONObject U = aVar.U();
        try {
            U.put("msg", "preloadVideoMaterial");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.a(U);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void privacyClick() {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null || this.mFeedsProd == null) {
            return;
        }
        String D = aVar.D();
        JSONObject U = this.mAdInstanceInfo.U();
        try {
            U.put("privacy_link", D);
            U.put("msg", "privacyClick");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.a(U);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void recordImpression(View view) {
        a aVar;
        df dfVar = this.mFeedsProd;
        if (dfVar == null || (aVar = this.mAdInstanceInfo) == null) {
            return;
        }
        dfVar.a(view, aVar.U());
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void registerViewForInteraction(View view, List<View> list, List<View> list2, NativeResponse.AdInteractionListener adInteractionListener) {
        this.mAdInteractionListener = adInteractionListener;
        if (this.mFeedsProd != null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("adView", view);
                hashMap.put("clickViews", list);
                hashMap.put("creativeViews", list2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("msg", "registerViewForInteraction");
                jSONObject.put("uniqueId", getUniqueId());
                jSONObject.put("isDownloadApp", this.isDownloadApp);
                this.mFeedsProd.a(jSONObject, hashMap);
            } catch (Throwable th) {
                bu.a().c(TAG, "registerViewForInteraction failed: " + th.getMessage());
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public View renderBulletView(int i6, int i7) {
        if (this.mFeedsProd == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, i6);
            jSONObject.put("h", i7);
            return renderNativeView("native_bullet_view", jSONObject);
        } catch (Throwable th) {
            bu.a().c(TAG, "renderBulletView failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public View renderCouponFloatView(NativeResponse.AdShakeViewListener adShakeViewListener) {
        if (this.mFeedsProd == null) {
            return null;
        }
        try {
            this.mCouponFloatViewListener = adShakeViewListener;
            return renderNativeView("native_coupon_float_icon", new JSONObject());
        } catch (Throwable th) {
            bu.a().c(TAG, "renderCouponFloatView failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public View renderFlipPageView() {
        if (this.mFeedsProd == null) {
            return null;
        }
        try {
            return renderNativeView("native_coupon_flip_page", new JSONObject());
        } catch (Throwable th) {
            bu.a().c(TAG, "renderFlipPageView failed: " + th.getMessage());
            return null;
        }
    }

    View renderNativeView(String str, JSONObject jSONObject) {
        try {
            jSONObject.put("viewId", str);
            jSONObject.put("msg", "renderNativeView");
            jSONObject.put("uniqueId", getUniqueId());
            jSONObject.put("isDownloadApp", this.isDownloadApp);
            HashMap hashMap = new HashMap();
            this.mFeedsProd.a(jSONObject, hashMap);
            Object obj = hashMap.get(str);
            if (obj instanceof View) {
                return (View) obj;
            }
            return null;
        } catch (Throwable th) {
            bu.a().c(TAG, "renderNativeView failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public View renderShakeView(int i6, int i7, NativeResponse.AdShakeViewListener adShakeViewListener) {
        if (this.mFeedsProd == null) {
            return null;
        }
        try {
            this.mAdShakeViewListener = adShakeViewListener;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("msg", "renderShakeView");
            jSONObject.put("uniqueId", getUniqueId());
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, i6);
            jSONObject.put("h", i7);
            jSONObject.put("isDownloadApp", this.isDownloadApp);
            HashMap hashMap = new HashMap();
            this.mFeedsProd.a(jSONObject, hashMap);
            Object obj = hashMap.get("shake_view");
            if (obj instanceof View) {
                return (View) obj;
            }
            return null;
        } catch (Throwable th) {
            bu.a().c(TAG, "renderShakeView failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public ShakeViewContainer renderShakeViewContainer() {
        if (this.mFeedsProd == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("msg", "renderShakeView");
            jSONObject.put("uniqueId", getUniqueId());
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, 80);
            jSONObject.put("h", 80);
            jSONObject.put("isDownloadApp", this.isDownloadApp);
            jSONObject.put("isContainer", "1");
            HashMap hashMap = new HashMap();
            this.mFeedsProd.a(jSONObject, hashMap);
            Object obj = hashMap.get("shake_view");
            Object obj2 = hashMap.get("shake_controller");
            if ((obj instanceof RelativeLayout) && (obj2 instanceof IOAdEventListener)) {
                return new al((RelativeLayout) obj, (IOAdEventListener) obj2);
            }
            return null;
        } catch (Throwable th) {
            bu.a().c(TAG, "renderShakeView failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public View renderSlideView(int i6, int i7, int i8, NativeResponse.AdShakeViewListener adShakeViewListener) {
        if (this.mFeedsProd == null) {
            return null;
        }
        try {
            this.mAdShakeViewListener = adShakeViewListener;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, i6);
            jSONObject.put("h", i7);
            jSONObject.put("repeat", i8);
            return renderNativeView("native_slide_view", jSONObject);
        } catch (Throwable th) {
            bu.a().c(TAG, "renderSlideView failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void resumeAppDownload() {
        a aVar;
        if (!this.isDownloadApp || this.mFeedsProd == null || (aVar = this.mAdInstanceInfo) == null) {
            return;
        }
        JSONObject U = aVar.U();
        try {
            U.put("msg", "resumeDownload");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.a(U);
    }

    public void setAdActionType(int i6) {
        this.mAdActionType = i6;
    }

    public void setAdCloseListener(NativeResponse.AdCloseListener adCloseListener) {
        this.mAdCloseListener = adCloseListener;
    }

    public void setAdDislikeListener(NativeResponse.AdDislikeListener adDislikeListener) {
        this.mAdDislikeListener = adDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void setAdPrivacyListener(NativeResponse.AdPrivacyListener adPrivacyListener) {
        this.mAdPrivacyListener = adPrivacyListener;
    }

    public void setIsDownloadApp(boolean z5) {
        this.isDownloadApp = z5;
    }

    public void setNoAdUniqueId(String str) {
        this.mNoAdUniqueId = str;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void stopNativeView(View view) {
        if (this.mFeedsProd != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("msg", "stopNativeView");
                jSONObject.put("uniqueId", getUniqueId());
                HashMap hashMap = new HashMap();
                hashMap.put("native_view", view);
                this.mFeedsProd.a(jSONObject, hashMap);
            } catch (Throwable th) {
                bu.a().c(TAG, "stopNativeView failed: " + th.getMessage());
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void unionLogoClick() {
        if (this.mFeedsProd == null || this.mUriUtils == null) {
            return;
        }
        JSONObject U = this.mAdInstanceInfo.U();
        try {
            U.put("unionUrl", "https://union.baidu.com/");
            U.put("msg", "unionLogoClick");
        } catch (Throwable unused) {
        }
        this.mFeedsProd.a(U);
    }

    public XAdNativeResponse(Context context, df dfVar, a aVar) {
        this.isDownloadApp = false;
        this.mCxt = context;
        this.mAdInstanceInfo = aVar;
        this.mFeedsProd = dfVar;
        if (aVar != null && aVar.p() == 2) {
            this.isDownloadApp = true;
        }
        this.mUriUtils = cr.a();
    }

    void handleClick(View view, boolean z5) {
        handleClick(view, -1, z5);
    }

    void handleClick(View view, int i6, boolean z5) {
        a aVar;
        if (this.mFeedsProd == null || (aVar = this.mAdInstanceInfo) == null) {
            return;
        }
        JSONObject U = aVar.U();
        try {
            U.put(NotificationCompat.CATEGORY_PROGRESS, i6);
            U.put(SplashAd.KEY_POPDIALOG_DOWNLOAD, z5);
            U.put("isDownloadApp", this.isDownloadApp);
        } catch (Throwable unused) {
        }
        this.mFeedsProd.b(view, U);
    }
}
