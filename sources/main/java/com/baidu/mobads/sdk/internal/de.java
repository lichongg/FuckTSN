package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class de extends bj {
    private ExpressInterstitialListener A;
    private ExpressInterstitialAd.InterAdDownloadWindowListener B;
    private ExpressInterstitialAd.InterstitialAdDislikeListener C;
    private a D;
    private boolean E;
    private boolean F;

    /* renamed from: a, reason: collision with root package name */
    RelativeLayout f10995a;

    /* renamed from: t, reason: collision with root package name */
    public boolean f10996t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f10997u;

    /* renamed from: v, reason: collision with root package name */
    private int f10998v;

    /* renamed from: w, reason: collision with root package name */
    private String f10999w;

    /* renamed from: x, reason: collision with root package name */
    private String f11000x;

    /* renamed from: y, reason: collision with root package name */
    private int f11001y;

    /* renamed from: z, reason: collision with root package name */
    private int f11002z;

    public void a(ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener) {
        this.B = interAdDownloadWindowListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void b() {
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdCacheSuccess();
        }
    }

    public void c(boolean z5) {
        this.E = z5;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void d(String str) {
    }

    public String e() {
        return this.f10999w;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void f(String str) {
    }

    public void g() {
        IAdInterListener iAdInterListener = this.f10733m;
        if (iAdInterListener != null) {
            iAdInterListener.showAd();
        }
    }

    public void a(ExpressInterstitialAd.InterstitialAdDislikeListener interstitialAdDislikeListener) {
        this.C = interstitialAdDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void c() {
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdCacheFailed();
        }
    }

    public void d(boolean z5) {
        this.F = z5;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void e(IOAdEvent iOAdEvent) {
        this.f10997u = false;
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADExposed();
        }
    }

    public boolean f() {
        return this.f10997u;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void h(IOAdEvent iOAdEvent) {
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject j() {
        this.f10739s = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, this.f10999w);
            this.f10733m.createProdHandler(jSONObject2);
            this.f10733m.setAdContainer(this.f10995a);
            m();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.f10999w);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f11000x);
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.f10737q)) {
                jSONObject.put("appid", this.f10737q);
            }
            if (cr.a().b()) {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
            } else {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
            }
            jSONObject.put("at", "10");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + bb.b(this.f10729i));
            jSONObject.put("h", "" + bb.c(this.f10729i));
            jSONObject.put("msa", 159);
            jSONObject.put("opt", 1);
            jSONObject = m.a(jSONObject, b(this.f10735o));
            b(jSONObject);
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("onlyLoadAd", this.f10996t);
            jSONObject.put(SplashAd.KEY_POPDIALOG_DOWNLOAD, this.E);
            jSONObject.put("use_dialog_container", this.F);
            jSONObject.put("timeout", this.f10998v);
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void u() {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.B;
        if (interAdDownloadWindowListener != null) {
            interAdDownloadWindowListener.onADPrivacyClose();
        }
    }

    public a x() {
        return this.D;
    }

    public de(Context context, RelativeLayout relativeLayout, String str) {
        super(context);
        this.f10998v = AVMDLDataLoader.KeyIsLiveSetLoaderType;
        this.f10999w = IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL;
        this.f11001y = 600;
        this.f11002z = 500;
        this.E = false;
        this.f10995a = relativeLayout;
        this.f11000x = str;
    }

    public void a(int i6) {
        this.f10998v = i6;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void b(String str, boolean z5) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.B;
        if (interAdDownloadWindowListener != null) {
            if (z5) {
                interAdDownloadWindowListener.adDownloadWindowShow();
            } else {
                interAdDownloadWindowListener.adDownloadWindowClose();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void d() {
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onLpClosed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void f(IOAdEvent iOAdEvent) {
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADExposureFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void g(IOAdEvent iOAdEvent) {
        super.g(iOAdEvent);
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdClose();
        }
    }

    public void a(ExpressInterstitialListener expressInterstitialListener) {
        this.A = expressInterstitialListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void c(IOAdEvent iOAdEvent) {
        ExpressInterstitialAd.InterstitialAdDislikeListener interstitialAdDislikeListener = this.C;
        if (interstitialAdDislikeListener == null || iOAdEvent == null) {
            return;
        }
        interstitialAdDislikeListener.interstitialAdDislikeClick();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        IAdInterListener iAdInterListener = this.f10733m;
        if (iAdInterListener == null) {
            this.f10734n = false;
            return;
        }
        this.f10997u = false;
        this.f10734n = true;
        iAdInterListener.loadAd(j(), k());
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void e(String str) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.B;
        if (interAdDownloadWindowListener != null) {
            interAdDownloadWindowListener.onADPrivacyClick();
        }
    }

    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.f11001y = width;
            this.f11002z = height;
        }
        a(requestParameters.getExt());
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(String str, int i6, String str2) {
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdFailed(i6, str);
        }
        super.a(str, i6, str2);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(int i6, String str, String str2) {
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onNoAd(i6, str);
        }
        super.a(i6, str, str2);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void v() {
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(String str, boolean z5) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.B;
        if (interAdDownloadWindowListener != null) {
            if (z5) {
                interAdDownloadWindowListener.onADPermissionShow();
            } else {
                interAdDownloadWindowListener.onADPermissionClose();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(IOAdEvent iOAdEvent) {
        List<a> a6;
        if (iOAdEvent != null && (a6 = b.a(iOAdEvent.getMessage()).a()) != null && a6.size() > 0) {
            this.D = a6.get(0);
        }
        this.f10997u = true;
        ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADLoaded();
        }
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
        a aVar = this.D;
        if (aVar != null) {
            a(aVar.I(), z5, linkedHashMap, biddingListener);
        } else {
            a(this.f10730j, z5, linkedHashMap, biddingListener);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(Map<String, String> map) {
        try {
            this.f10735o = m.a(map);
        } catch (Throwable unused) {
            this.f10735o = new HashMap<>();
        }
    }

    public Object a(String str) {
        if (this.D == null) {
            return null;
        }
        if ("request_id".equals(str)) {
            return this.D.V();
        }
        return this.D.a(str);
    }
}
