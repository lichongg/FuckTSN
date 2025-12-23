package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.baidu.mobads.sdk.api.ScreenVideoAdListener;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class di extends bj {
    private String A;
    private a B;
    private RequestParameters C;

    /* renamed from: a, reason: collision with root package name */
    private boolean f11015a;

    /* renamed from: t, reason: collision with root package name */
    private int f11016t;

    /* renamed from: u, reason: collision with root package name */
    private String f11017u;

    /* renamed from: v, reason: collision with root package name */
    private ScreenVideoAdListener f11018v;

    /* renamed from: w, reason: collision with root package name */
    private final String f11019w;

    /* renamed from: x, reason: collision with root package name */
    private int f11020x;

    /* renamed from: y, reason: collision with root package name */
    private int f11021y;

    /* renamed from: z, reason: collision with root package name */
    private String f11022z;

    public di(Context context, String str, boolean z5) {
        this(context, str, z5, IAdInterListener.AdProdType.PRODUCT_REWARDVIDEO);
    }

    public void a(Context context) {
        if (this.f10733m != null) {
            JSONObject jSONObject = new JSONObject();
            HashMap hashMap = new HashMap();
            try {
                jSONObject.put("msg", "setContext");
                hashMap.put(com.umeng.analytics.pro.d.X, context);
            } catch (JSONException e6) {
                bu.a().a(e6);
            }
            a(jSONObject, hashMap);
            this.f10733m.showAd();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void b() {
        ScreenVideoAdListener screenVideoAdListener = this.f11018v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void g(IOAdEvent iOAdEvent) {
        super.g(iOAdEvent);
        float floatValue = (iOAdEvent == null || iOAdEvent.getData() == null) ? 0.0f : ((Float) iOAdEvent.getData().get("play_scale")).floatValue();
        ScreenVideoAdListener screenVideoAdListener = this.f11018v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdClose(floatValue);
        }
    }

    public void j(String str) {
        this.A = str;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeout", AVMDLDataLoader.KeyIsLiveSetLoaderType);
            jSONObject.put("useSurfaceView", this.f11015a);
            jSONObject.put("downloadConfirmPolicy", this.f11016t);
            jSONObject.put("userid", this.f11022z);
            jSONObject.put(JThirdPlatFormInterface.KEY_EXTRA, this.A);
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            return jSONObject;
        }
    }

    public di(Context context, String str, boolean z5, String str2) {
        super(context);
        this.f11016t = 3;
        this.f11017u = str;
        this.f11015a = z5;
        this.f11019w = str2;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void c() {
        ScreenVideoAdListener screenVideoAdListener = this.f11018v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onVideoDownloadFailed();
        }
    }

    public void e() {
        IAdInterListener iAdInterListener = this.f10733m;
        if (iAdInterListener != null) {
            iAdInterListener.showAd();
        }
    }

    public boolean f() {
        IAdInterListener iAdInterListener = this.f10733m;
        if (iAdInterListener != null) {
            return iAdInterListener.isAdReady();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void h(IOAdEvent iOAdEvent) {
        ScreenVideoAdListener screenVideoAdListener = this.f11018v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject j() {
        this.f10739s = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, this.f11019w);
            this.f10733m.createProdHandler(jSONObject2);
            m();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.f11019w);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f11017u);
            jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON");
            jSONObject.put("n", "1");
            jSONObject.put("at", "10");
            if (!TextUtils.isEmpty(this.f10737q)) {
                jSONObject.put("appid", this.f10737q);
            }
            Rect a6 = bb.a(this.f10729i);
            this.f11020x = a6.width();
            this.f11021y = a6.height();
            if (this.f10729i.getResources().getConfiguration().orientation == 2) {
                this.f11020x = a6.height();
                this.f11021y = a6.width();
            }
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.f11020x);
            jSONObject.put("h", "" + this.f11021y);
            jSONObject.put("opt", 1);
            if (IAdInterListener.AdProdType.PRODUCT_REWARDVIDEO.equals(this.f11019w)) {
                jSONObject.put("msa", 5293);
            }
            jSONObject = m.a(jSONObject, b(this.f10735o));
            b(jSONObject);
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void q() {
        ScreenVideoAdListener screenVideoAdListener = this.f11018v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdShow();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void s() {
        ScreenVideoAdListener screenVideoAdListener = this.f11018v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.playCompletion();
        }
    }

    public String x() {
        a aVar = this.B;
        return aVar != null ? aVar.A() : "";
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void b(boolean z5) {
        ScreenVideoAdListener screenVideoAdListener = this.f11018v;
        if (screenVideoAdListener == null || !(screenVideoAdListener instanceof RewardVideoAd.RewardVideoAdListener)) {
            return;
        }
        ((RewardVideoAd.RewardVideoAdListener) screenVideoAdListener).onRewardVerify(z5);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void g(String str) {
        ScreenVideoAdListener screenVideoAdListener = this.f11018v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdSkip(Float.parseFloat(str));
        }
    }

    public String g() {
        a aVar = this.B;
        if (aVar != null) {
            return aVar.z();
        }
        return "";
    }

    public Object k(String str) {
        if (this.B == null) {
            return null;
        }
        if ("request_id".equals(str)) {
            return this.B.V();
        }
        return this.B.a(str);
    }

    public void a(int i6) {
        this.f11016t = i6;
    }

    public void a(String str) {
        this.f11022z = str;
    }

    public void a(ScreenVideoAdListener screenVideoAdListener) {
        this.f11018v = screenVideoAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        IAdInterListener iAdInterListener = this.f10733m;
        if (iAdInterListener == null) {
            this.f10734n = false;
        } else {
            this.f10734n = true;
            iAdInterListener.loadAd(j(), k());
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(IOAdEvent iOAdEvent) {
        List<a> a6;
        if (iOAdEvent != null && (a6 = b.a(iOAdEvent.getMessage()).a()) != null && a6.size() > 0) {
            this.B = a6.get(0);
        }
        ScreenVideoAdListener screenVideoAdListener = this.f11018v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdLoaded();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(String str, int i6, String str2) {
        super.a(str, i6, str2);
        ScreenVideoAdListener screenVideoAdListener = this.f11018v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdFailed(str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(int i6, String str, String str2) {
        super.a(i6, str, str2);
        ScreenVideoAdListener screenVideoAdListener = this.f11018v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdFailed(str);
        }
    }

    public void a(boolean z5, LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        a aVar = this.B;
        if (aVar != null) {
            a(aVar.I(), z5, linkedHashMap, biddingListener);
        } else {
            a(this.f10730j, z5, linkedHashMap, biddingListener);
        }
    }

    public void a(RequestParameters requestParameters) {
        this.C = requestParameters;
        a(requestParameters.getExt());
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(Map<String, String> map) {
        try {
            this.f10735o = m.a(map);
        } catch (Throwable unused) {
            this.f10735o = new HashMap<>();
        }
    }
}
