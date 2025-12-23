package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashAdListener;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class dj extends bj {
    private static int J;
    private static dj P;
    private int A;
    private int B;
    private int C;
    private int D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private int I;
    private SplashAdListener K;
    private SplashAd.OnFinishListener L;
    private SplashAd.SplashFocusAdListener M;
    private SplashAd.SplashCardAdListener N;
    private RequestParameters O;
    private a Q;
    private SplashAd.SplashAdDownloadDialogListener R;
    private HashMap<String, String> S;

    /* renamed from: a, reason: collision with root package name */
    protected int f11023a;

    /* renamed from: t, reason: collision with root package name */
    protected int f11024t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f11025u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f11026v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f11027w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f11028x;

    /* renamed from: y, reason: collision with root package name */
    private RelativeLayout f11029y;

    /* renamed from: z, reason: collision with root package name */
    private String f11030z;

    private void b(Intent intent, SplashAd.OnFinishListener onFinishListener) {
        Context context = this.f10729i;
        if (context == null || intent == null) {
            return;
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        this.f10729i.startActivity(intent);
        if (onFinishListener != null) {
            onFinishListener.onFinishActivity();
            return;
        }
        Context context2 = this.f10729i;
        if (context2 instanceof Activity) {
            ((Activity) context2).finish();
        }
    }

    public static void e(int i6) {
        J = i6;
    }

    private String k(String str) {
        if (this.O == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Map<String, String> extras = this.O.getExtras();
            if (extras != null) {
                return extras.get(str);
            }
            return null;
        } catch (Throwable th) {
            this.f10731k.d(bj.f10722b, th);
            return null;
        }
    }

    public void c(int i6) {
        this.f11024t = i6;
    }

    public void d(int i6) {
        this.I = i6;
    }

    public boolean f() {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("event_type", "splash_focus_card_enable");
            a(jSONObject, hashMap);
            Object obj = hashMap.get("splash_focus_card_enable");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        } catch (JSONException e6) {
            bu.a().c(e6);
            return false;
        } catch (Throwable th) {
            bu.a().c(th);
            return false;
        }
    }

    public a g() {
        return this.Q;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void h(IOAdEvent iOAdEvent) {
        this.f11026v = true;
        SplashAdListener splashAdListener = this.K;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdClick();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.M;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onAdClick();
        }
        SplashAd.SplashCardAdListener splashCardAdListener = this.N;
        if (splashCardAdListener != null) {
            splashCardAdListener.onCardClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject j() {
        String str = "1";
        this.f10739s = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_SPLASH);
            this.f10733m.createProdHandler(jSONObject2);
            m();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_SPLASH);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f11030z);
            jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,HTML,MSSP,VIDEO,RSPLASHHTML");
            jSONObject.put("n", "1");
            jSONObject.put("at", "26");
            jSONObject.put(IAdInterListener.AdReqParam.MIME_TYPE, "video/mp4,image/jpg,image/gif,image/png");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.A);
            jSONObject.put("h", "" + this.B);
            jSONObject.put("msa", 399);
            if (!TextUtils.isEmpty(this.f10737q)) {
                jSONObject.put("appid", this.f10737q);
            }
            String k6 = k(SplashAd.KEY_USE_ADAPTIVE_AD);
            if (!TextUtils.isEmpty(k6)) {
                if (!Boolean.parseBoolean(k6)) {
                    str = "0";
                }
                jSONObject.put("adtv", str);
            }
            jSONObject = m.a(jSONObject, b(this.S));
            b(jSONObject);
            return jSONObject;
        } catch (Exception e6) {
            e6.printStackTrace();
            return jSONObject;
        }
    }

    public void a(RelativeLayout relativeLayout) {
        this.f11029y = relativeLayout;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void c() {
        SplashAdListener splashAdListener = this.K;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdCacheFailed();
        }
        super.c();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void d() {
        SplashAdListener splashAdListener = this.K;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onLpClosed();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.M;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onLpClosed();
        }
        super.d();
    }

    public void e() {
        IAdInterListener iAdInterListener;
        if (this.f11025u || (iAdInterListener = this.f10733m) == null) {
            return;
        }
        iAdInterListener.setAdContainer(this.f11029y);
        this.f10733m.showAd();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void g(IOAdEvent iOAdEvent) {
        if (this.f11027w) {
            return;
        }
        this.f11027w = true;
        Map<String, Object> data = iOAdEvent.getData();
        if (this.M != null && data != null && data.containsKey("splash_close_reason")) {
            this.M.onAdClose();
            return;
        }
        SplashAd.SplashCardAdListener splashCardAdListener = this.N;
        if (splashCardAdListener != null) {
            splashCardAdListener.onCardClose();
            return;
        }
        super.g(iOAdEvent);
        SplashAdListener splashAdListener = this.K;
        if (splashAdListener == null || !(splashAdListener instanceof SplashInteractionListener)) {
            return;
        }
        ((SplashInteractionListener) splashAdListener).onAdDismissed();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void q() {
        SplashAdListener splashAdListener = this.K;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdPresent();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.M;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onAdIconShow();
        }
        SplashAd.SplashCardAdListener splashCardAdListener = this.N;
        if (splashCardAdListener != null) {
            splashCardAdListener.onCardShow();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void t() {
        SplashAd.OnFinishListener onFinishListener = this.L;
        if (onFinishListener != null) {
            onFinishListener.onFinishActivity();
            this.L = null;
        } else {
            Context context = this.f10729i;
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
        }
        this.f10729i = null;
        this.f11029y = null;
        super.t();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void u() {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.R;
        if (splashAdDownloadDialogListener == null || !androidx.activity.k.a(splashAdDownloadDialogListener)) {
            return;
        }
        this.R.onADPrivacyLpClose();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void v() {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.R;
        if (splashAdDownloadDialogListener == null || !androidx.activity.k.a(splashAdDownloadDialogListener)) {
            return;
        }
        this.R.onADFunctionLpClose();
    }

    public dj(Context context, String str, int i6, int i7, int i8, int i9, boolean z5, boolean z6, boolean z7, boolean z8) {
        super(context);
        this.I = 60;
        this.f11023a = 67;
        this.f11024t = ViewCompat.MEASURED_STATE_MASK;
        this.f11026v = false;
        this.f11027w = false;
        this.f11028x = false;
        this.f11030z = str;
        this.A = i6;
        this.B = i7;
        this.C = i8;
        this.D = i9;
        this.E = z5;
        this.F = z6;
        this.G = z8;
        this.H = z7;
    }

    public void a(int i6) {
        this.f11023a = i6;
    }

    public void a(SplashAdListener splashAdListener) {
        this.K = splashAdListener;
    }

    public void a(SplashAd.SplashFocusAdListener splashFocusAdListener) {
        this.M = splashFocusAdListener;
        this.f11027w = false;
    }

    public void c(Map<String, String> map) {
        try {
            this.S = m.a(map);
        } catch (Throwable unused) {
            this.S = new HashMap<>();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void e(IOAdEvent iOAdEvent) {
        SplashAdListener splashAdListener = this.K;
        if (splashAdListener == null || !(splashAdListener instanceof SplashInteractionListener)) {
            return;
        }
        ((SplashInteractionListener) splashAdListener).onAdExposed();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeout", this.D);
            jSONObject.put("splashTipStyle", this.C);
            jSONObject.put("bitmapDisplayMode", J);
            jSONObject.put("countDownNew", "true");
            jSONObject.put("Display_Down_Info", "" + this.E);
            jSONObject.put("popDialogIfDl", "" + this.F);
            jSONObject.put("limitRegionClick", "" + this.G);
            jSONObject.put("displayClickButton", "" + this.H);
            jSONObject.put("needCache", true);
            jSONObject.put("onlyLoadAd", this.f11025u);
            jSONObject.put("cacheVideoOnlyWifi", true);
            jSONObject.put("shakeLogoSize", this.I);
            jSONObject.put("twistLogoHeightDp", this.f11023a);
            jSONObject.put("twistBgColor", this.f11024t);
            RequestParameters requestParameters = this.O;
            if (requestParameters != null) {
                a(requestParameters.getExtras());
            }
            return m.a(jSONObject, b(this.f10735o));
        } catch (Exception e6) {
            e6.printStackTrace();
            return jSONObject;
        }
    }

    public void a(SplashAd.SplashCardAdListener splashCardAdListener) {
        this.N = splashCardAdListener;
        this.f11027w = false;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void e(String str) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.R;
        if (splashAdDownloadDialogListener == null || !androidx.activity.k.a(splashAdDownloadDialogListener)) {
            return;
        }
        this.R.onADPrivacyLpShow();
    }

    public boolean b(Activity activity) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            this.f10733m.removeAllListeners();
            this.f10733m.addEventListener(z.L, this.f10732l);
            this.f10733m.addEventListener(z.G, this.f10732l);
            this.f10733m.addEventListener(z.V, this.f10732l);
            this.K = null;
            jSONObject.putOpt("event_type", "splash_focus_card");
            hashMap.put("splash_focus_activity", activity);
            a(jSONObject, hashMap);
            Object obj = hashMap.get("splash_focus_card_show");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        } catch (JSONException e6) {
            bu.a().c(e6);
            return false;
        } catch (Throwable th) {
            bu.a().c(th);
            return false;
        }
    }

    public void a(RequestParameters requestParameters) {
        this.O = requestParameters;
        c(requestParameters.getExt());
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void f(String str) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.R;
        if (splashAdDownloadDialogListener == null || !androidx.activity.k.a(splashAdDownloadDialogListener)) {
            return;
        }
        this.R.onADFunctionLpShow();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        IAdInterListener iAdInterListener = this.f10733m;
        if (iAdInterListener == null) {
            this.f10734n = false;
            return;
        }
        this.f10734n = true;
        if (!this.f11025u) {
            iAdInterListener.setAdContainer(this.f11029y);
        }
        this.f10733m.loadAd(j(), k());
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void g(String str) {
        SplashAdListener splashAdListener = this.K;
        if (splashAdListener == null || !(splashAdListener instanceof SplashInteractionListener)) {
            return;
        }
        ((SplashInteractionListener) splashAdListener).onAdSkip();
    }

    public void a(@NonNull Intent intent, @Nullable SplashAd.OnFinishListener onFinishListener) {
        try {
            if (!this.f11026v && intent != null && this.f10733m != null && !this.f11028x && (this.f10729i instanceof Activity)) {
                this.L = onFinishListener;
                JSONObject jSONObject = new JSONObject();
                HashMap hashMap = new HashMap();
                try {
                    jSONObject.putOpt("event_type", "splash_focus_start_activity");
                    hashMap.put("splash_focus_user_intent", intent);
                } catch (JSONException e6) {
                    bu.a().a(e6);
                }
                this.f10733m.removeAllListeners();
                this.f10733m.addEventListener(z.Y, this.f10732l);
                this.f10733m.addEventListener(z.L, this.f10732l);
                this.f10733m.addEventListener(z.G, this.f10732l);
                this.f10733m.addEventListener(z.V, this.f10732l);
                this.f10733m.addEventListener(z.W, this.f10732l);
                a(jSONObject, hashMap);
                this.K = null;
                P = this;
                be.a().a(new dk(this), 3L, TimeUnit.SECONDS);
                return;
            }
            b(intent, onFinishListener);
        } catch (Throwable th) {
            th.printStackTrace();
            b(intent, onFinishListener);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void b() {
        SplashAdListener splashAdListener = this.K;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdCacheSuccess();
        }
        super.b();
    }

    public Object j(String str) {
        if (this.Q == null) {
            return null;
        }
        if ("request_id".equals(str)) {
            return this.Q.V();
        }
        return this.Q.a(str);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void b(String str, boolean z5) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.R;
        if (splashAdDownloadDialogListener == null || !androidx.activity.k.a(splashAdDownloadDialogListener)) {
            return;
        }
        if (z5) {
            this.R.adDownloadWindowShow();
        } else {
            this.R.adDownloadWindowClose();
        }
    }

    public static void a(Activity activity, JSONObject jSONObject, SplashAd.SplashFocusAdListener splashFocusAdListener) {
        dj djVar = P;
        if (djVar != null) {
            djVar.a(splashFocusAdListener);
            HashMap hashMap = new HashMap();
            JSONObject jSONObject2 = new JSONObject();
            try {
                try {
                    try {
                        jSONObject2.putOpt("event_type", "splash_focus_register_transition");
                        jSONObject2.putOpt("splash_focus_params", jSONObject);
                        hashMap.put("splash_focus_activity", activity);
                        P.a(jSONObject2, hashMap);
                        P = null;
                    } catch (JSONException e6) {
                        bu.a().c(e6);
                        P = null;
                    }
                } catch (Throwable th) {
                    bu.a().c(th);
                    P = null;
                }
            } catch (Throwable th2) {
                P = null;
                throw th2;
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(IOAdEvent iOAdEvent) {
        List<a> a6;
        if (iOAdEvent != null && (a6 = b.a(iOAdEvent.getMessage()).a()) != null && a6.size() > 0) {
            this.Q = a6.get(0);
        }
        SplashAdListener splashAdListener = this.K;
        if (splashAdListener != null) {
            splashAdListener.onADLoaded();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(int i6, String str, String str2) {
        this.f11028x = true;
        SplashAdListener splashAdListener = this.K;
        if (splashAdListener != null) {
            splashAdListener.onAdFailed("广告无填充");
        }
        super.a(i6, str, str2);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(String str, int i6, String str2) {
        this.f11028x = true;
        if (this.K != null) {
            a(i6 + "==" + str);
            this.K.onAdFailed(str);
        }
        super.a(str, i6, str2);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(String str, boolean z5) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.R;
        if (splashAdDownloadDialogListener == null || !androidx.activity.k.a(splashAdDownloadDialogListener)) {
            return;
        }
        if (z5) {
            this.R.onADPermissionShow();
        } else {
            this.R.onADPermissionClose();
        }
    }

    public void a(SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener) {
        this.R = splashAdDownloadDialogListener;
    }

    public void a(MotionEvent motionEvent) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("e_d_t", motionEvent.getDownTime());
            jSONObject.put("e_e_t", motionEvent.getEventTime());
            jSONObject.put("e_a", motionEvent.getAction());
            jSONObject.put("e_x", motionEvent.getX());
            jSONObject.put("e_y", motionEvent.getY());
            jSONObject.put("e_m_s", motionEvent.getMetaState());
            jSONObject.put("event_type", "x_event");
            a(jSONObject);
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z5, LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        a aVar = this.Q;
        if (aVar != null) {
            a(aVar.I(), z5, linkedHashMap, biddingListener);
        } else {
            a(this.f10730j, z5, linkedHashMap, biddingListener);
        }
    }

    public void a(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("msg", str);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("msg", "sendSplashFailedLog");
            } catch (JSONException e6) {
                bu.a().a(e6);
            }
            a(jSONObject, hashMap);
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }
}
