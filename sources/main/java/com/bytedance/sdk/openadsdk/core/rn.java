package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import android.view.View;
import android.webkit.JavascriptInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.av.j;
import com.bytedance.sdk.openadsdk.core.tj.x;
import com.bytedance.sdk.openadsdk.core.tj.xp;
import com.bytedance.sdk.openadsdk.core.widget.ae;
import com.bytedance.sdk.openadsdk.core.xt.r;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes4.dex */
public class rn implements com.bytedance.sdk.component.adexpress.up.xt, l.j, com.bytedance.sdk.openadsdk.core.av.xt {
    private static final Map<String, Boolean> cw;

    /* renamed from: e, reason: collision with root package name */
    private static volatile boolean f30020e;

    /* renamed from: a, reason: collision with root package name */
    private List<com.bytedance.sdk.openadsdk.core.tj.n> f30021a;
    private com.bytedance.sdk.openadsdk.core.av.cw ae;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g> f30022b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f30023c;
    private WeakReference<com.bytedance.sdk.openadsdk.core.w.xt> ch;
    private boolean ed;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.w.r> f30024f;

    /* renamed from: g, reason: collision with root package name */
    private WeakReference<View> f30025g;
    private com.bytedance.sdk.component.j.i gq;
    private JSONObject hh;
    private WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.ae.xt> hl;

    /* renamed from: i, reason: collision with root package name */
    private SoftReference<com.bytedance.sdk.component.adexpress.xt.qv> f30027i;

    /* renamed from: j, reason: collision with root package name */
    protected Map<String, Object> f30028j;
    private com.bytedance.sdk.openadsdk.core.tj.n jy;
    private WeakReference<com.bytedance.sdk.openadsdk.core.av.r> kt;

    /* renamed from: l, reason: collision with root package name */
    private HashMap<String, qv> f30029l;
    private com.bytedance.sdk.openadsdk.m.j la;

    /* renamed from: m, reason: collision with root package name */
    private final WeakReference<Context> f30030m;
    private JSONObject mi;
    private com.bytedance.sdk.openadsdk.core.ugeno.xt ol;
    private String oq;

    /* renamed from: q, reason: collision with root package name */
    private AtomicBoolean f30033q;
    private WeakReference<com.bytedance.sdk.openadsdk.core.w.up> qb;
    private int qv;

    /* renamed from: r, reason: collision with root package name */
    private WeakReference<SSWebView> f30034r;
    private ae.j rh;
    private String rn;

    /* renamed from: s, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.w.m> f30035s;
    private WeakReference<com.bytedance.sdk.openadsdk.core.w.j> tj;
    private String tl;

    /* renamed from: v, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.qv.j> f30036v;
    private String vl;
    private com.bytedance.sdk.openadsdk.core.widget.j.j wq;

    /* renamed from: x, reason: collision with root package name */
    private JSONObject f30038x;

    /* renamed from: z, reason: collision with root package name */
    private List<JSONObject> f30039z;
    boolean xt = false;
    private boolean ws = false;
    private boolean az = true;
    private boolean av = true;

    /* renamed from: w, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.nativeexpress.vl f30037w = new com.bytedance.sdk.openadsdk.core.nativeexpress.vl();

    /* renamed from: p, reason: collision with root package name */
    private boolean f30032p = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f30026h = false;
    private boolean uf = false;
    private boolean gx = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f30031n = false;
    private boolean nd = false;
    private com.bytedance.sdk.component.utils.l up = new com.bytedance.sdk.component.utils.l(Looper.getMainLooper(), this);

    public static class j {
        public String cw;

        /* renamed from: j, reason: collision with root package name */
        public String f30080j;

        /* renamed from: r, reason: collision with root package name */
        public JSONObject f30081r;
        public int up;
        public String xt;
    }

    private void av(JSONObject jSONObject) {
        WeakReference<com.bytedance.sdk.openadsdk.core.w.xt> weakReference = this.ch;
        if (weakReference == null || jSONObject == null || weakReference.get() == null) {
            return;
        }
        this.ch.get().j(jSONObject.optBoolean("isRenderSuc", false), jSONObject.optInt("code", -1), jSONObject.optString("msg", ""));
    }

    private JSONObject c() {
        View view;
        SSWebView sSWebView;
        try {
            view = this.f30025g.get();
            sSWebView = this.f30034r.get();
        } catch (Throwable unused) {
        }
        if (view == null || sSWebView == null) {
            com.bytedance.sdk.component.utils.vl.r("TTAndroidObject", "setCloseButtonInfo error closeButton is null");
            return null;
        }
        int[] xt = com.bytedance.sdk.openadsdk.core.rn.ed.xt(view);
        int[] xt2 = com.bytedance.sdk.openadsdk.core.rn.ed.xt(sSWebView);
        if (xt != null && xt2 != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("x", com.bytedance.sdk.openadsdk.core.rn.ed.r(v.getContext(), xt[0] - xt2[0]));
            jSONObject.put("y", com.bytedance.sdk.openadsdk.core.rn.ed.r(v.getContext(), xt[1] - xt2[1]));
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, com.bytedance.sdk.openadsdk.core.rn.ed.r(v.getContext(), view.getWidth()));
            jSONObject.put("h", com.bytedance.sdk.openadsdk.core.rn.ed.r(v.getContext(), view.getHeight()));
            jSONObject.put("isExist", true);
            return jSONObject;
        }
        com.bytedance.sdk.component.utils.vl.r("TTAndroidObject", "setCloseButtonInfo error position or webViewPosition is null");
        return null;
    }

    private JSONObject f(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.i.cw.cw.xt rr;
        if (this.f30028j != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                String optString = jSONObject.optString("ad_extra_data", null);
                if (optString != null) {
                    jSONObject2 = new JSONObject(optString);
                }
                if (h.m()) {
                    try {
                        com.bytedance.sdk.openadsdk.core.tj.n nVar = this.jy;
                        if (nVar != null && (rr = nVar.rr()) != null) {
                            String jy = rr.jy();
                            if (!TextUtils.isEmpty(jy)) {
                                jSONObject2.putOpt("media_extra", jy);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                for (Map.Entry<String, Object> entry : this.f30028j.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception e6) {
                com.bytedance.sdk.component.utils.vl.cw(e6.toString());
            }
        }
        return jSONObject;
    }

    private void mi(JSONObject jSONObject) {
        WeakReference<com.bytedance.sdk.openadsdk.core.av.r> weakReference;
        com.bytedance.sdk.openadsdk.core.av.r rVar;
        if (jSONObject == null || (weakReference = this.kt) == null || (rVar = weakReference.get()) == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("temaiProductIds");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                rVar.j(false, null);
            } else {
                rVar.j(true, optJSONArray);
            }
        } catch (Exception unused) {
            rVar.j(false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj(JSONObject jSONObject) {
        com.bytedance.sdk.component.jy.cw ed = ed();
        if (ed != null) {
            com.bytedance.sdk.component.utils.qv.j(ed, "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + jSONObject.toString() + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w(JSONObject jSONObject) {
        return jSONObject.has("borderRadiusTopLeft") && jSONObject.has("borderRadiusBottomLeft") && jSONObject.has("borderRadiusTopRight") && jSONObject.has("borderRadiusBottomRight");
    }

    public boolean ae() {
        return this.f30031n;
    }

    public void az() {
        this.f30037w.r();
    }

    public boolean g() {
        com.bytedance.sdk.openadsdk.core.tj.n nVar = this.jy;
        return nVar != null && nVar.b();
    }

    @Override // com.bytedance.sdk.component.adexpress.up.xt
    @JavascriptInterface
    public String getTemplateInfo() {
        xt("getTemplateInfo", true);
        try {
            vl();
            xt("getTemplateInfo", false);
            return this.mi.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public void i() {
        WeakReference<com.bytedance.sdk.openadsdk.qv.j> weakReference = this.f30036v;
        if (weakReference == null || weakReference.get() == null) {
            this.f30037w.qv();
        } else {
            this.f30036v.get().j();
        }
    }

    public void jy() {
        com.bytedance.sdk.openadsdk.core.kt.ws.j().cw(this.jy, "stats_reward_full_deal_skip_video");
        this.f30037w.ae();
    }

    public boolean kt() {
        return this.uf;
    }

    public com.bytedance.sdk.component.j.i m() {
        return this.gq;
    }

    public boolean oq() {
        return this.xt;
    }

    public JSONObject qv() {
        return this.hh;
    }

    public void tl(boolean z5) {
        this.nd = z5;
    }

    public int up(boolean z5) {
        if (com.bytedance.sdk.openadsdk.core.tj.gq.j(this.jy) != 0 && z5) {
            return 2;
        }
        if (this.ed) {
            return 1;
        }
        return this.f30023c ? com.bytedance.sdk.openadsdk.core.tj.gq.j(this.jy) == 2 ? 2 : 1 : com.bytedance.sdk.openadsdk.core.tj.gq.j(this.jy) == 0 ? 1 : 2;
    }

    public JSONObject vl() {
        JSONObject jSONObject = this.mi;
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception unused) {
            }
        }
        if (this.jy != null) {
            jSONObject.put("setting", rh());
            jSONObject.put("extension", this.jy.hu());
        }
        this.mi = jSONObject;
        return jSONObject;
    }

    public void ws() {
        this.f30037w.tl();
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        cw = concurrentHashMap;
        Boolean bool = Boolean.TRUE;
        concurrentHashMap.put("log_event", bool);
        concurrentHashMap.put("private", bool);
        concurrentHashMap.put("dispatch_message", bool);
        concurrentHashMap.put("custom_event", bool);
        concurrentHashMap.put("log_event_v3", bool);
        f30020e = false;
    }

    private boolean b() {
        return this.f30022b != null;
    }

    private com.bytedance.sdk.component.jy.cw ed() {
        WeakReference<SSWebView> weakReference = this.f30034r;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private static List<String> gx() {
        return Arrays.asList("appInfo", "adInfo", "getTemplateInfo", "getTeMaiAds");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hh() {
        Context context;
        List<com.bytedance.sdk.openadsdk.core.tj.n> list = this.f30021a;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f30029l = new HashMap<>();
        WeakReference<SSWebView> weakReference = this.f30034r;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        WeakReference<Context> weakReference2 = this.f30030m;
        if (weakReference2 == null || (context = weakReference2.get()) == null) {
            return;
        }
        for (com.bytedance.sdk.openadsdk.core.tj.n nVar : this.f30021a) {
            this.f30029l.put(nVar.fs(), new qv(context, nVar, sSWebView, this.rn));
        }
    }

    private void hl() {
        if (this.ae == null) {
            this.ae = com.bytedance.sdk.openadsdk.core.av.j.j(this, this.jy, this.gx);
        }
    }

    private void kt(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            tj(jSONObject);
        } else {
            tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.2
                @Override // java.lang.Runnable
                public void run() {
                    rn.this.tj(jSONObject);
                }
            });
        }
    }

    private void n() {
        WeakReference<com.bytedance.sdk.openadsdk.core.w.m> weakReference = this.f30035s;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f30035s.get().j();
    }

    private void nd() {
        WeakReference<com.bytedance.sdk.openadsdk.core.w.m> weakReference = this.f30035s;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f30035s.get().xt();
    }

    private void ol() {
        xp al;
        Context context;
        com.bytedance.sdk.openadsdk.core.tj.n nVar = this.jy;
        if (nVar != null && (al = nVar.al()) != null && al.xt() == 1 && al.m() == 1) {
            hl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", new JSONObject());
            } catch (Throwable unused) {
            }
            WeakReference<Context> weakReference = this.f30030m;
            if (weakReference == null || (context = weakReference.get()) == null) {
                return;
            }
            this.ae.j(context, jSONObject, this.oq, this.qv, this.ws, true);
            j(jSONObject, false);
        }
    }

    private JSONObject rh() {
        return j(this.jy, this.f30033q);
    }

    private void uf() {
        com.bytedance.sdk.openadsdk.core.tj.n nVar;
        WeakReference<SSWebView> weakReference = this.f30034r;
        if (weakReference == null || weakReference.get() == null || (nVar = this.jy) == null) {
            return;
        }
        int si = nVar.si();
        int ho = this.jy.ho();
        int km = this.jy.km();
        int wo = this.jy.wo();
        int qo = this.jy.qo();
        JSONObject mt = this.jy.mt();
        JSONObject xn = this.jy.xn();
        JSONObject lr = this.jy.lr();
        this.f30034r.get().setShakeValue(si);
        this.f30034r.get().setDeepShakeValue(ho);
        this.f30034r.get().setWriggleValue(km);
        this.f30034r.get().setTwistConfig(mt);
        this.f30034r.get().setShakeInteractConf(xn);
        this.f30034r.get().setTwistInteractConf(lr);
        this.f30034r.get().setCalculationMethod(wo);
        this.f30034r.get().setCalculationTwistMethod(qo);
    }

    private boolean z() {
        com.bytedance.sdk.openadsdk.core.tj.n nVar = this.jy;
        if (nVar == null || nVar.ag() == null || com.bytedance.sdk.openadsdk.core.rn.tj.xt(this.jy) || this.f30032p || this.jy.ag().optInt("parent_type") != 2) {
            return false;
        }
        int tl = com.bytedance.sdk.openadsdk.core.rn.uf.tl(this.jy);
        if (tl != 8 && tl != 7) {
            return false;
        }
        this.f30032p = true;
        return true;
    }

    public void a() {
        com.bytedance.sdk.openadsdk.core.av.cw cwVar = this.ae;
        if (cwVar != null) {
            cwVar.xt();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.up.xt
    @JavascriptInterface
    public String adInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            r(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    public void ae(boolean z5) {
        this.f30031n = z5;
    }

    @Override // com.bytedance.sdk.component.adexpress.up.xt
    @JavascriptInterface
    public String appInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            cw(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    public void az(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.tl = jSONObject.optString("cid");
        this.oq = jSONObject.optString(MediationConstant.EXTRA_LOG_EXTRA);
    }

    public String ch() {
        return com.bytedance.sdk.openadsdk.core.rn.uf.j(this.qv);
    }

    @Override // com.bytedance.sdk.component.adexpress.up.xt
    @JavascriptInterface
    public void changeVideoState(final String str) {
        com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    rn.this.tl(new JSONObject(str));
                } catch (Exception e6) {
                    com.bytedance.sdk.component.utils.vl.j(e6);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.up.xt
    @JavascriptInterface
    public void clickEvent(final String str) {
        com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    rn.this.qv(new JSONObject(str));
                } catch (Exception e6) {
                    com.bytedance.sdk.component.utils.vl.j(e6);
                }
            }
        });
    }

    public com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g cw() {
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g> weakReference = this.f30022b;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.adexpress.up.xt
    @JavascriptInterface
    public void dynamicTrack(String str) {
        try {
            jy(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    public void g(boolean z5) {
        this.xt = z5;
    }

    public Context getContext() {
        return this.f30030m.get();
    }

    @Override // com.bytedance.sdk.component.adexpress.up.xt
    @JavascriptInterface
    public String getCurrentVideoState() {
        JSONObject jSONObject = new JSONObject();
        i(jSONObject);
        return jSONObject.toString();
    }

    public void gq() {
        if (this.f30037w.vl() != null) {
            this.f30037w.vl().g();
        }
    }

    public int h() {
        if (this.f30037w.vl() == null) {
            return 0;
        }
        return this.f30037w.vl().cw();
    }

    @Override // com.bytedance.sdk.component.adexpress.up.xt
    @JavascriptInterface
    public void initRenderFinish() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.9
            @Override // java.lang.Runnable
            public void run() {
                if (rn.this.wq != null) {
                    com.bytedance.sdk.openadsdk.core.widget.j.j unused = rn.this.wq;
                }
            }
        });
    }

    public void la() {
        WeakReference<com.bytedance.sdk.openadsdk.core.w.up> weakReference = this.qb;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.qb.get().j();
    }

    public rn m(boolean z5) {
        this.f30026h = z5;
        return this;
    }

    @Override // com.bytedance.sdk.component.adexpress.up.xt
    @JavascriptInterface
    public void muteVideo(final String str) {
        com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    rn.this.ae(new JSONObject(str));
                } catch (Exception e6) {
                    com.bytedance.sdk.component.utils.vl.j(e6);
                }
            }
        });
    }

    public void oq(JSONObject jSONObject) {
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        double d11;
        double d12;
        String str;
        String str2;
        double d13;
        double d14;
        if (jSONObject == null) {
            return;
        }
        try {
            String optString = jSONObject.optString("adId");
            int optInt = jSONObject.optInt("areaType", 1);
            String optString2 = jSONObject.optString("subConvertLinkTag");
            int optInt2 = jSONObject.optInt("dpaPosition", -1);
            String optString3 = jSONObject.optString("clickAreaType");
            JSONObject optJSONObject = jSONObject.optJSONObject("clickInfo");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("is_compliant_download", jSONObject.optBoolean("is_compliant_download"));
            jSONObject2.put("convertActionType", jSONObject.optInt("convertActionType", Integer.MIN_VALUE));
            double d15 = -1.0d;
            if (optJSONObject != null) {
                double optDouble = optJSONObject.optDouble("down_x", -1.0d);
                double optDouble2 = optJSONObject.optDouble("down_y", -1.0d);
                double optDouble3 = optJSONObject.optDouble("up_x", -1.0d);
                double optDouble4 = optJSONObject.optDouble("up_y", -1.0d);
                double optDouble5 = optJSONObject.optDouble("down_time", -1.0d);
                double optDouble6 = optJSONObject.optDouble("up_time", -1.0d);
                double optDouble7 = optJSONObject.optDouble("button_x", -1.0d);
                double optDouble8 = optJSONObject.optDouble("button_y", -1.0d);
                double optDouble9 = optJSONObject.optDouble("button_width", -1.0d);
                d12 = optJSONObject.optDouble("button_height", -1.0d);
                str = optString;
                d15 = optDouble;
                d6 = optDouble2;
                d13 = optDouble3;
                d7 = optDouble5;
                d8 = optDouble6;
                d9 = optDouble7;
                d10 = optDouble8;
                d11 = optDouble9;
                str2 = optString2;
                d14 = optDouble4;
            } else {
                d6 = -1.0d;
                d7 = -1.0d;
                d8 = -1.0d;
                d9 = -1.0d;
                d10 = -1.0d;
                d11 = -1.0d;
                d12 = -1.0d;
                str = optString;
                str2 = optString2;
                d13 = -1.0d;
                d14 = -1.0d;
            }
            com.bytedance.sdk.openadsdk.core.tj.x j6 = new x.j().r((int) d15).cw((int) d6).xt((int) d13).j((int) d14).xt((long) d7).j((long) d8).j((int) d9).xt((int) d10).cw((int) d11).r((int) d12).j(optString3).j(true).j(jSONObject2).j((SparseArray<r.j>) null).up(str2).up(optInt2).j();
            SoftReference<com.bytedance.sdk.component.adexpress.xt.qv> softReference = this.f30027i;
            if (softReference != null && softReference.get() != null) {
                this.f30027i.get().j(null, optInt, j6, g(jSONObject));
            }
            j(str, optInt, j6);
        } catch (Exception unused) {
            SoftReference<com.bytedance.sdk.component.adexpress.xt.qv> softReference2 = this.f30027i;
            if (softReference2 == null || softReference2.get() == null) {
                return;
            }
            this.f30027i.get().j(null, -1, null, 0);
        }
    }

    public void p() {
        WeakReference<com.bytedance.sdk.openadsdk.core.w.r> weakReference = this.f30024f;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f30024f.get().xt();
    }

    public void qv(JSONObject jSONObject) {
        rn rnVar;
        SoftReference<com.bytedance.sdk.component.adexpress.xt.qv> softReference;
        double optDouble;
        double d6;
        double d7;
        double d8;
        double d9;
        String str;
        String str2;
        String str3;
        double d10;
        double d11;
        int i6;
        int i7;
        JSONObject jSONObject2;
        double d12;
        double d13;
        SoftReference<com.bytedance.sdk.component.adexpress.xt.qv> softReference2;
        if (jSONObject == null) {
            return;
        }
        try {
            String optString = jSONObject.optString("adId");
            int optInt = jSONObject.optInt("areaType", 1);
            String optString2 = jSONObject.optString("clickAreaType");
            String optString3 = jSONObject.optString("clickAreaId");
            JSONObject optJSONObject = jSONObject.optJSONObject("clickInfo");
            String optString4 = jSONObject.optString("subConvertLinkTag");
            int optInt2 = jSONObject.optInt("dpaPosition", -1);
            JSONObject jSONObject3 = new JSONObject();
            com.bytedance.sdk.openadsdk.core.tj.i.j(jSONObject.optString("clickScene"));
            jSONObject3.put("convertActionType", jSONObject.optInt("convertActionType", Integer.MIN_VALUE));
            jSONObject3.put("live_saas_param_interaction_type", jSONObject.optInt("live_saas_param_interaction_type", -1));
            jSONObject3.put("is_compliant_download", jSONObject.optBoolean("is_compliant_download"));
            double d14 = -1.0d;
            if (optJSONObject != null) {
                try {
                    double optDouble2 = optJSONObject.optDouble("down_x", -1.0d);
                    double optDouble3 = optJSONObject.optDouble("down_y", -1.0d);
                    double optDouble4 = optJSONObject.optDouble("up_x", -1.0d);
                    double optDouble5 = optJSONObject.optDouble("up_y", -1.0d);
                    double optDouble6 = optJSONObject.optDouble("down_time", -1.0d);
                    double optDouble7 = optJSONObject.optDouble("up_time", -1.0d);
                    double optDouble8 = optJSONObject.optDouble("button_x", -1.0d);
                    double optDouble9 = optJSONObject.optDouble("button_y", -1.0d);
                    double optDouble10 = optJSONObject.optDouble("button_width", -1.0d);
                    optDouble = optJSONObject.optDouble("button_height", -1.0d);
                    d14 = optDouble2;
                    d6 = optDouble3;
                    d7 = optDouble4;
                    d8 = optDouble9;
                    d9 = optDouble10;
                    str = optString;
                    str2 = optString2;
                    str3 = optString4;
                    d10 = optDouble5;
                    d11 = optDouble6;
                    i6 = optInt;
                    i7 = optInt2;
                    jSONObject2 = jSONObject3;
                    d12 = optDouble7;
                    d13 = optDouble8;
                } catch (Exception unused) {
                    rnVar = this;
                    softReference = rnVar.f30027i;
                    if (softReference != null || softReference.get() == null) {
                        rnVar.ol();
                    } else {
                        rnVar.f30027i.get().j(null, -1, null);
                        return;
                    }
                }
            } else {
                d6 = -1.0d;
                d7 = -1.0d;
                d8 = -1.0d;
                d9 = -1.0d;
                optDouble = -1.0d;
                str = optString;
                i6 = optInt;
                str2 = optString2;
                str3 = optString4;
                i7 = optInt2;
                jSONObject2 = jSONObject3;
                d12 = -1.0d;
                d11 = -1.0d;
                d10 = -1.0d;
                d13 = -1.0d;
            }
            com.bytedance.sdk.openadsdk.core.tj.x j6 = new x.j().r((float) d14).cw((float) d6).xt((float) d7).j((float) d10).xt((long) d11).j((long) d12).j((int) d13).xt((int) d8).cw((int) d9).r((int) optDouble).j(str2).xt(optString3).j(true).j((SparseArray<r.j>) null).j(jSONObject2).up(str3).up(i7).j();
            rnVar = this;
            int i8 = i6;
            try {
                if (rnVar.j(str, i8, j6) || (softReference2 = rnVar.f30027i) == null || softReference2.get() == null) {
                    rnVar.ol();
                } else {
                    rnVar.f30027i.get().j(null, i8, j6);
                }
            } catch (Exception unused2) {
                softReference = rnVar.f30027i;
                if (softReference != null) {
                }
                rnVar.ol();
            }
        } catch (Exception unused3) {
            rnVar = this;
        }
    }

    public boolean r() {
        WeakReference<SSWebView> weakReference = this.f30034r;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return this.f30034r.get().H_();
    }

    @Override // com.bytedance.sdk.component.adexpress.up.xt
    @JavascriptInterface
    public void renderDidFinish(String str) {
        try {
            vl(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    public void rn() {
        this.f30037w.m();
    }

    public void s() {
        com.bytedance.sdk.openadsdk.core.av.cw cwVar = this.ae;
        if (cwVar != null) {
            cwVar.j();
        }
        if (z()) {
            w();
        }
    }

    public com.bytedance.sdk.openadsdk.core.tj.n tl() {
        return this.jy;
    }

    public void v() {
        com.bytedance.sdk.openadsdk.core.tj.n nVar = this.jy;
        if (nVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.rn.m.cw(nVar, this.f30030m.get(), ch());
    }

    public boolean ws(JSONObject jSONObject) {
        try {
            jSONObject.put("creatives", j(this.f30021a));
        } catch (Exception unused) {
        }
        return true;
    }

    public JSONObject x() {
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.tj.n nVar = this.jy;
        if (nVar != null) {
            String ov = nVar.ov();
            if (!TextUtils.isEmpty(ov)) {
                try {
                    return new JSONObject(ov);
                } catch (Exception e6) {
                    com.bytedance.sdk.component.utils.vl.j(e6);
                }
            }
        }
        return jSONObject;
    }

    public rn(Context context) {
        this.f30030m = new WeakReference<>(context);
    }

    private boolean wq() {
        return oq.i().z();
    }

    public void ae(JSONObject jSONObject) {
        if (this.f30037w.vl() == null || jSONObject == null) {
            return;
        }
        try {
            this.f30037w.vl().j(jSONObject.optBoolean("mute", false));
        } catch (Exception unused) {
        }
    }

    public int g(JSONObject jSONObject) {
        if (jSONObject.optBoolean("interactShowDownloadDialog", false)) {
            this.jy.cw(true);
            return 2;
        }
        if (jSONObject.optInt("downloadDialogStatus") != 1) {
            return 0;
        }
        if (this.jy.fx().j() == 2) {
            this.jy.cw(true);
        }
        return 1;
    }

    @Override // com.bytedance.sdk.component.adexpress.up.xt
    @JavascriptInterface
    public String getData(String str) {
        if (TextUtils.isEmpty(str)) {
            return this.mi.toString();
        }
        try {
            JSONObject j6 = com.bytedance.sdk.openadsdk.core.nativeexpress.xt.xt.j(this.mi, new JSONObject(str));
            if (j6 == null) {
                return this.mi.toString();
            }
            return j6.toString();
        } catch (Exception unused) {
            return this.mi.toString();
        }
    }

    public void jy(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            Uri parse = Uri.parse(jSONObject.optString("trackData"));
            if ("bytedance".equals(parse.getScheme().toLowerCase())) {
                com.bytedance.sdk.openadsdk.core.rn.kt.j(parse, this);
            }
        } catch (Exception unused) {
        }
    }

    public void l() {
        up();
        com.bytedance.sdk.openadsdk.core.av.cw cwVar = this.ae;
        if (cwVar != null) {
            cwVar.cw();
        }
        WeakReference<SSWebView> weakReference = this.f30034r;
        if (weakReference != null) {
            weakReference.clear();
        }
        WeakReference<View> weakReference2 = this.f30025g;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        WeakReference<Context> weakReference3 = this.f30030m;
        if (weakReference3 != null) {
            weakReference3.clear();
        }
        this.wq = null;
        this.ol = null;
    }

    public rn m(JSONObject jSONObject) {
        this.mi = jSONObject;
        return this;
    }

    @Override // com.bytedance.sdk.component.adexpress.up.xt
    @JavascriptInterface
    public void requestPauseVideo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f30037w.j(jSONObject.optInt("time"), jSONObject.optString("flag"));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("state_type", 2);
            jSONObject2.put("jsb_name", "requestPauseVideo");
            com.bytedance.sdk.openadsdk.core.kt.ws.j().j(this.jy, jSONObject2);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.up.xt
    @JavascriptInterface
    public void skipVideo() {
        com.bytedance.sdk.openadsdk.core.kt.ws.j().cw(this.jy, "stats_reward_full_call_skip_video");
        com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.8
            @Override // java.lang.Runnable
            public void run() {
                rn.this.jy();
            }
        });
    }

    public void tl(JSONObject jSONObject) {
        if (this.f30037w.vl() == null || jSONObject == null) {
            return;
        }
        try {
            int optInt = jSONObject.optInt("stateType", -1);
            this.f30037w.vl().j(optInt);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("jsb_name", "changeVideoState");
            jSONObject2.put("state_type", optInt);
            com.bytedance.sdk.openadsdk.core.kt.ws.j().j(this.jy, jSONObject2);
        } catch (Exception unused) {
        }
    }

    public JSONObject xt() {
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g> weakReference = this.f30022b;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.f30022b.get().getCreativeVideoViewInfo();
    }

    private boolean i(JSONObject jSONObject) {
        if (this.f30037w.vl() != null && jSONObject != null) {
            double j6 = this.f30037w.vl().j();
            int xt = this.f30037w.vl().xt();
            try {
                jSONObject.put("currentTime", j6 / 1000.0d);
                jSONObject.put("state", xt);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private boolean m(String str) {
        return TextUtils.isEmpty(str) || !"click_other".equals(str) || tj();
    }

    public void cw(boolean z5) {
        this.ed = z5;
    }

    public void r(boolean z5) {
        this.f30023c = z5;
    }

    boolean tj() {
        com.bytedance.sdk.openadsdk.core.tj.n nVar = this.jy;
        return nVar != null && com.bytedance.sdk.openadsdk.core.tj.tj.qv(nVar) == 1;
    }

    public static void xt(boolean z5) {
        f30020e = z5;
    }

    public rn cw(String str) {
        this.oq = str;
        return this;
    }

    public rn r(String str) {
        this.vl = str;
        return this;
    }

    public void w() {
        j((JSONObject) null, new com.bytedance.sdk.openadsdk.core.w.cw() { // from class: com.bytedance.sdk.openadsdk.core.rn.12
            @Override // com.bytedance.sdk.openadsdk.core.w.cw
            public void j(boolean z5, List<com.bytedance.sdk.openadsdk.core.tj.n> list, boolean z6) {
                rn.this.f30021a = list;
                rn.this.hh();
                rn.this.mi();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(String str) {
        int indexOf;
        if (str != null && str.startsWith("bytedance://")) {
            try {
                if (str.equals("bytedance://dispatch_message/")) {
                    com.bytedance.sdk.component.jy.cw ed = ed();
                    if (ed != null) {
                        com.bytedance.sdk.component.utils.qv.j(ed, "javascript:ToutiaoJSBridge._fetchQueue()");
                        return;
                    }
                    return;
                }
                if (str.startsWith("bytedance://private/setresult/") && (indexOf = str.indexOf(38, 30)) > 0) {
                    String substring = str.substring(30, indexOf);
                    String substring2 = str.substring(indexOf + 1);
                    if (!substring.equals("SCENE_FETCHQUEUE") || substring2.length() <= 0) {
                        return;
                    }
                    up(substring2);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static JSONArray j(List<com.bytedance.sdk.openadsdk.core.tj.n> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                jSONArray.put(list.get(i6).tv());
            }
        }
        return jSONArray;
    }

    public rn cw(int i6) {
        this.qv = i6;
        return this;
    }

    public void r(JSONObject jSONObject) throws Exception {
        if (!TextUtils.isEmpty(this.tl)) {
            jSONObject.put("cid", this.tl);
        }
        if (!TextUtils.isEmpty(this.oq)) {
            jSONObject.put(MediationConstant.EXTRA_LOG_EXTRA, this.oq);
        }
        if (!TextUtils.isEmpty(this.vl)) {
            jSONObject.put("download_url", this.vl);
        }
        com.bytedance.sdk.openadsdk.core.tj.n nVar = this.jy;
        if (nVar != null) {
            jSONObject.put("isDirectDownload", nVar.i());
            jSONObject.put("dynamic_configs", this.jy.sz());
        }
        if (com.bytedance.sdk.openadsdk.core.tj.kt.qv(this.jy)) {
            jSONObject.put("voice_btn_position", com.bytedance.sdk.openadsdk.core.tj.kt.az(this.jy));
        }
    }

    public void up() {
        com.bytedance.sdk.component.j.i iVar = this.gq;
        if (iVar == null) {
            return;
        }
        iVar.j();
        this.gq = null;
    }

    public rn xt(SSWebView sSWebView) {
        this.f30034r = new WeakReference<>(sSWebView);
        return this;
    }

    public rn cw(List<com.bytedance.sdk.openadsdk.core.tj.n> list) {
        this.f30021a = list;
        return this;
    }

    public rn xt(String str) {
        this.tl = str;
        return this;
    }

    public static void cw(JSONObject jSONObject) throws Exception {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = gx().iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        jSONObject.put("appName", com.bytedance.sdk.openadsdk.core.tl.j.j());
        jSONObject.put("innerAppName", com.bytedance.sdk.openadsdk.core.tl.j.up());
        jSONObject.put(CommonNetImpl.AID, com.bytedance.sdk.openadsdk.core.tl.j.xt());
        jSONObject.put("sdkEdition", com.bytedance.sdk.openadsdk.core.tl.j.cw());
        jSONObject.put("appVersion", com.bytedance.sdk.openadsdk.core.tl.j.r());
        jSONObject.put("netType", com.bytedance.sdk.openadsdk.core.tl.j.m());
        jSONObject.put("supportList", jSONArray);
        jSONObject.put("deviceId", com.bytedance.sdk.openadsdk.core.tl.j.ae());
        jSONObject.put("themeStatus", oq.i().q());
    }

    public void av() {
        this.f30037w.up();
    }

    public void mi() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("material", j(this.f30021a));
            j("materialMeta", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void vl(final JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.m.j jVar = this.la;
        if (jVar != null) {
            jVar.cw(jSONObject);
        }
        com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("renderDidFinish") { // from class: com.bytedance.sdk.openadsdk.core.rn.10
            @Override // java.lang.Runnable
            public void run() {
                int i6;
                double d6;
                double d7;
                boolean z5;
                double d8;
                double d9;
                int i7;
                double d10;
                double d11;
                double d12;
                if (rn.this.f30027i == null || rn.this.f30027i.get() == null || jSONObject == null || rn.this.f30030m == null) {
                    return;
                }
                com.bytedance.sdk.component.adexpress.xt.ws wsVar = new com.bytedance.sdk.component.adexpress.xt.ws();
                wsVar.j(1);
                try {
                    boolean optBoolean = jSONObject.optBoolean("isRenderSuc");
                    JSONObject optJSONObject = jSONObject.optJSONObject("AdSize");
                    if (optJSONObject != null) {
                        d6 = optJSONObject.optDouble("width");
                        d7 = optJSONObject.optDouble("height");
                    } else {
                        d6 = 0.0d;
                        d7 = 0.0d;
                    }
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("videoInfo");
                    if (optJSONObject2 != null) {
                        float f6 = ((Context) rn.this.f30030m.get()).getResources().getDisplayMetrics().density;
                        float f7 = Resources.getSystem().getDisplayMetrics().density;
                        double optDouble = optJSONObject2.optDouble("x");
                        z5 = optBoolean;
                        i7 = 101;
                        double optDouble2 = optJSONObject2.optDouble("y");
                        d9 = d7;
                        double optDouble3 = optJSONObject2.optDouble("width");
                        double optDouble4 = optJSONObject2.optDouble("height");
                        if (rn.this.w(optJSONObject2)) {
                            d8 = d6;
                            double optDouble5 = optJSONObject2.optDouble("borderRadiusTopLeft");
                            d11 = optDouble4;
                            double optDouble6 = optJSONObject2.optDouble("borderRadiusTopRight");
                            d12 = optDouble3;
                            double optDouble7 = optJSONObject2.optDouble("borderRadiusBottomLeft");
                            d10 = optDouble2;
                            double optDouble8 = optJSONObject2.optDouble("borderRadiusBottomRight");
                            if (v.xt().gs()) {
                                wsVar.j(com.bytedance.sdk.openadsdk.core.rn.ed.xt(f6, com.bytedance.sdk.openadsdk.core.rn.ed.j(f7, (float) optDouble5)));
                                wsVar.xt(com.bytedance.sdk.openadsdk.core.rn.ed.xt(f6, com.bytedance.sdk.openadsdk.core.rn.ed.j(f7, (float) optDouble6)));
                                wsVar.cw(com.bytedance.sdk.openadsdk.core.rn.ed.xt(f6, com.bytedance.sdk.openadsdk.core.rn.ed.j(f7, (float) optDouble7)));
                                wsVar.r(com.bytedance.sdk.openadsdk.core.rn.ed.xt(f6, com.bytedance.sdk.openadsdk.core.rn.ed.j(f7, (float) optDouble8)));
                            } else {
                                wsVar.j((float) optDouble5);
                                wsVar.xt((float) optDouble6);
                                wsVar.cw((float) optDouble7);
                                wsVar.r((float) optDouble8);
                            }
                        } else {
                            d10 = optDouble2;
                            d11 = optDouble4;
                            d8 = d6;
                            d12 = optDouble3;
                        }
                        if (v.xt().gs()) {
                            wsVar.cw(com.bytedance.sdk.openadsdk.core.rn.ed.xt(f6, com.bytedance.sdk.openadsdk.core.rn.ed.j(f7, (float) optDouble)));
                            wsVar.r(com.bytedance.sdk.openadsdk.core.rn.ed.xt(f6, com.bytedance.sdk.openadsdk.core.rn.ed.j(f7, (float) d10)));
                            wsVar.up(com.bytedance.sdk.openadsdk.core.rn.ed.xt(f6, com.bytedance.sdk.openadsdk.core.rn.ed.j(f7, (float) d12)));
                            wsVar.m(com.bytedance.sdk.openadsdk.core.rn.ed.xt(f6, com.bytedance.sdk.openadsdk.core.rn.ed.j(f7, (float) d11)));
                        } else {
                            wsVar.cw(optDouble);
                            wsVar.r(d10);
                            wsVar.up(d12);
                            wsVar.m(d11);
                        }
                    } else {
                        z5 = optBoolean;
                        d8 = d6;
                        d9 = d7;
                        i7 = 101;
                    }
                    String optString = jSONObject.optString("msg", g.j(i7));
                    i6 = 101;
                    try {
                        int optInt = jSONObject.optInt("code", 101);
                        wsVar.j(z5);
                        wsVar.j(d8);
                        wsVar.xt(d9);
                        wsVar.j(optString);
                        wsVar.xt(optInt);
                        ((com.bytedance.sdk.component.adexpress.xt.qv) rn.this.f30027i.get()).j(wsVar);
                    } catch (Exception unused) {
                        wsVar.xt(i6);
                        wsVar.j(g.j(i6));
                        ((com.bytedance.sdk.component.adexpress.xt.qv) rn.this.f30027i.get()).j(wsVar);
                    }
                } catch (Exception unused2) {
                    i6 = 101;
                }
            }
        });
    }

    public rn xt(List<JSONObject> list) {
        this.f30039z = list;
        return this;
    }

    public void up(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.m.j jVar;
        if (jSONObject == null || (jVar = this.la) == null) {
            return;
        }
        jVar.r(jSONObject);
    }

    public rn xt(int i6) {
        this.ws = true;
        return this;
    }

    public rn j(String str) {
        this.rn = str;
        return this;
    }

    public void xt(JSONObject jSONObject) {
        this.hh = jSONObject;
    }

    private void up(String str) {
        try {
            JSONArray jSONArray = new JSONArray(new String(Base64.decode(str, 2)));
            int length = jSONArray.length();
            for (int i6 = 0; i6 < length; i6++) {
                j jVar = new j();
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                    if (optJSONObject != null) {
                        jVar.f30080j = optJSONObject.optString("__msg_type", null);
                        jVar.xt = optJSONObject.optString("__callback_id", null);
                        jVar.cw = optJSONObject.optString("func");
                        jVar.f30081r = optJSONObject.optJSONObject("params");
                        jVar.up = optJSONObject.optInt("JSSDK");
                    }
                } catch (Throwable unused) {
                }
                if (!TextUtils.isEmpty(jVar.f30080j) && !TextUtils.isEmpty(jVar.cw)) {
                    Message obtainMessage = this.up.obtainMessage(11);
                    obtainMessage.obj = jVar;
                    this.up.sendMessage(obtainMessage);
                }
            }
        } catch (Exception unused2) {
            if (com.bytedance.sdk.component.utils.vl.j()) {
                com.bytedance.sdk.component.utils.vl.xt("TTAndroidObject", "failed to parse jsbridge msg queue " + str);
                return;
            }
            com.bytedance.sdk.component.utils.vl.xt("TTAndroidObject", "failed to parse jsbridge msg queue");
        }
    }

    private void xt(String str, boolean z5) {
        if (this.la == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (z5) {
            this.la.m(str);
        } else {
            this.la.ae(str);
        }
    }

    public rn j(boolean z5) {
        this.gx = z5;
        return this;
    }

    public void vl(boolean z5) {
        this.f30033q = new AtomicBoolean(z5);
    }

    public rn j(SSWebView sSWebView) {
        com.bytedance.sdk.component.utils.vl.r("webviewpool", "===useJsb2 webView hashCode:" + sSWebView.hashCode());
        com.bytedance.sdk.component.j.i xt = com.bytedance.sdk.component.j.i.j(sSWebView).j(new com.bytedance.sdk.openadsdk.oq.j()).j("ToutiaoJSBridge").j(new com.bytedance.sdk.component.j.vl() { // from class: com.bytedance.sdk.openadsdk.core.rn.1
            @Override // com.bytedance.sdk.component.j.vl
            public <T> T j(String str, Type type) {
                return null;
            }

            @Override // com.bytedance.sdk.component.j.vl
            public <T> String j(T t5) {
                return null;
            }
        }).j(wq()).xt(true).j().xt();
        this.gq = xt;
        com.bytedance.sdk.openadsdk.core.i.j.kt.j(xt, this);
        com.bytedance.sdk.openadsdk.core.i.j.up.j(this.gq, this);
        com.bytedance.sdk.openadsdk.core.i.j.m.j(this.gq, this, this.jy);
        com.bytedance.sdk.openadsdk.core.i.j.ws.j(this.gq);
        com.bytedance.sdk.openadsdk.core.i.j.v.j(this.gq, sSWebView);
        com.bytedance.sdk.openadsdk.core.i.j.ae.j(this.gq, this);
        com.bytedance.sdk.openadsdk.core.i.j.qv.j(this.gq, this);
        com.bytedance.sdk.openadsdk.core.i.j.gq.j(this.gq, this);
        com.bytedance.sdk.openadsdk.oq.j.r.j(this.gq, this);
        com.bytedance.sdk.openadsdk.core.i.j.w.j(this.gq, this);
        com.bytedance.sdk.openadsdk.core.i.j.i.j(this.gq, this);
        com.bytedance.sdk.openadsdk.oq.j.cw.j(this.gq, this);
        com.bytedance.sdk.openadsdk.oq.j.j.j(this.gq, this);
        com.bytedance.sdk.openadsdk.oq.j.up.j(this.gq, this);
        com.bytedance.sdk.openadsdk.oq.j.m.j(this.gq, this);
        com.bytedance.sdk.openadsdk.oq.j.xt.j(this.gq, this);
        uf();
        com.bytedance.sdk.openadsdk.core.i.j.cw.j(this.gq, this.f30034r.get(), this.tl);
        com.bytedance.sdk.openadsdk.core.i.j.ch.j(this.gq, this.f30034r.get(), this.tl);
        com.bytedance.sdk.openadsdk.core.i.j.xt.j(this.gq, this.f30034r.get(), this.tl);
        com.bytedance.sdk.openadsdk.core.i.j.x.j(this.gq, this.f30034r.get(), this.tl);
        com.bytedance.sdk.openadsdk.core.i.j.p.j(this.gq, this);
        com.bytedance.sdk.openadsdk.core.i.j.mi.j(this.gq, this);
        com.bytedance.sdk.openadsdk.core.i.j.la.j(this.gq, this);
        com.bytedance.sdk.openadsdk.core.i.j.av.j(this.gq, this);
        com.bytedance.sdk.openadsdk.core.i.j.az.j(this.gq, this.jy);
        com.bytedance.sdk.openadsdk.core.i.j.tj.j(this.gq, this.f30030m.get(), this.jy);
        com.bytedance.sdk.openadsdk.core.i.j.oq.j(this.gq, this.jy, this.f30039z);
        com.bytedance.sdk.openadsdk.core.i.j.f.j(this.gq, this, this.hl);
        com.bytedance.sdk.openadsdk.core.i.j.l.j(this.gq, this, this.hl);
        com.bytedance.sdk.openadsdk.core.i.j.uf.j(this.gq, sSWebView, this);
        com.bytedance.sdk.openadsdk.core.i.j.g.j(this.gq, this.jy, this);
        com.bytedance.sdk.openadsdk.core.i.j.jy.j(this.gq, this.jy, this);
        com.bytedance.sdk.openadsdk.core.i.j.wq.j(this.gq, this.rh);
        com.bytedance.sdk.openadsdk.core.i.j.rn.j(this.gq, this);
        com.bytedance.sdk.openadsdk.core.i.j.s.j(this.gq, this.ol);
        com.bytedance.sdk.openadsdk.core.i.j.a.j(this.gq, this, this.jy);
        com.bytedance.sdk.openadsdk.core.i.j.vl.j(this.gq, this.mi);
        com.bytedance.sdk.openadsdk.core.i.j.tl.j(this.gq, this.jy, this);
        com.bytedance.sdk.openadsdk.core.i.j.j.j(this.gq, this.f30030m.get());
        com.bytedance.sdk.openadsdk.core.i.j.h.j(this.gq, this.jy);
        com.bytedance.sdk.openadsdk.core.i.j.r.j(this.gq, this);
        return this;
    }

    public void xt(final Uri uri) {
        long j6;
        try {
            String host = uri.getHost();
            if (!"log_event".equals(host) && !"custom_event".equals(host) && !"log_event_v3".equals(host)) {
                if (!"private".equals(host) && !"dispatch_message".equals(host)) {
                    com.bytedance.sdk.component.utils.vl.xt("TTAndroidObject", "handlrUir: not match schema host");
                    return;
                }
                com.bytedance.sdk.component.utils.tl.xt().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.3
                    @Override // java.lang.Runnable
                    public void run() {
                        rn.this.ae(uri.toString());
                    }
                });
                return;
            }
            String queryParameter = uri.getQueryParameter("category");
            String queryParameter2 = uri.getQueryParameter(CommonNetImpl.TAG);
            String queryParameter3 = uri.getQueryParameter("label");
            if (m(queryParameter3)) {
                if (com.bytedance.sdk.openadsdk.core.tj.rn.xt(this.jy) && TextUtils.equals(queryParameter3, "track")) {
                    return;
                }
                long j7 = 0;
                try {
                    j6 = Long.parseLong(uri.getQueryParameter("value"));
                } catch (Exception unused) {
                    j6 = 0;
                }
                try {
                    j7 = Long.parseLong(uri.getQueryParameter("ext_value"));
                } catch (Exception unused2) {
                }
                JSONObject jSONObject = new JSONObject();
                String queryParameter4 = uri.getQueryParameter(JThirdPlatFormInterface.KEY_EXTRA);
                if (!TextUtils.isEmpty(queryParameter4)) {
                    try {
                        jSONObject = new JSONObject(queryParameter4);
                    } catch (Exception unused3) {
                    }
                }
                up(queryParameter3, jSONObject);
                if (AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK.equals(queryParameter3)) {
                    jSONObject = f(jSONObject);
                    WeakReference<com.bytedance.sdk.openadsdk.core.w.r> weakReference = this.f30024f;
                    if (weakReference != null && weakReference.get() != null) {
                        this.f30024f.get().cw();
                    }
                }
                com.bytedance.sdk.openadsdk.core.jy.cw.j(queryParameter, j(queryParameter2, queryParameter3), queryParameter3, j6, j7, jSONObject);
            }
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.xt("TTAndroidObject", "handleUri exception: ", e6);
        }
    }

    public void r(int i6) {
        this.f30037w.xt(i6);
    }

    private void r(String str, JSONObject jSONObject) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "event");
            jSONObject2.put("__event_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            kt(jSONObject2);
        } catch (Exception unused) {
        }
    }

    public void f() {
        com.bytedance.sdk.openadsdk.core.tj.n nVar = this.jy;
        if (nVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.rn.m.xt(nVar, this.f30030m.get(), ch());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "callback");
            jSONObject2.put("__callback_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            kt(jSONObject2);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.up.xt
    @JavascriptInterface
    public void adAnalysisData(String str) {
    }

    private void up(String str, JSONObject jSONObject) {
        JSONArray jSONArray;
        String str2;
        String str3;
        String str4;
        String str5;
        JSONObject jSONObject2;
        String str6 = AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK;
        String str7 = "";
        try {
            if (AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_SHOW.equals(str)) {
                jSONArray = jSONObject.optJSONArray("show_url");
                str6 = AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_SHOW;
            } else if (AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK.equals(str)) {
                jSONArray = jSONObject.getJSONArray("click_url");
            } else {
                str6 = null;
                jSONArray = null;
            }
            if (jSONArray != null && jSONArray.length() != 0) {
                String cw2 = kt.cw();
                if (TextUtils.isEmpty(cw2)) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    arrayList.add(jSONArray.getString(i6));
                }
                String optString = jSONObject.optString(MediationConstant.EXTRA_LOG_EXTRA);
                try {
                    jSONObject2 = new JSONObject(optString);
                    str2 = jSONObject2.optString(MediationConstant.EXTRA_ADID);
                } catch (Throwable unused) {
                    str2 = "";
                    str3 = str2;
                }
                try {
                    str3 = jSONObject2.optString("creative_id");
                    try {
                        str4 = jSONObject2.optString("req_id");
                        try {
                            str5 = jSONObject2.optString("customer_id");
                            try {
                                str7 = com.bytedance.sdk.openadsdk.core.rn.uf.xt(jSONObject2.optInt("ad_slot_type"));
                            } catch (Throwable unused2) {
                            }
                        } catch (Throwable unused3) {
                            str5 = "";
                        }
                    } catch (Throwable unused4) {
                        str4 = "";
                        str5 = str4;
                        HashMap hashMap = new HashMap();
                        hashMap.put(CommonNetImpl.AID, str2);
                        hashMap.put("cid", str3);
                        hashMap.put("req_id", str4);
                        hashMap.put("customer_id", str5);
                        com.bytedance.sdk.openadsdk.core.kt.xt.j(cw2, arrayList, true, hashMap, com.bytedance.sdk.openadsdk.core.jy.cw.j(optString, str2, str4, str7, str6));
                    }
                } catch (Throwable unused5) {
                    str3 = "";
                    str4 = str3;
                    str5 = str4;
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(CommonNetImpl.AID, str2);
                    hashMap2.put("cid", str3);
                    hashMap2.put("req_id", str4);
                    hashMap2.put("customer_id", str5);
                    com.bytedance.sdk.openadsdk.core.kt.xt.j(cw2, arrayList, true, hashMap2, com.bytedance.sdk.openadsdk.core.jy.cw.j(optString, str2, str4, str7, str6));
                }
                HashMap hashMap22 = new HashMap();
                hashMap22.put(CommonNetImpl.AID, str2);
                hashMap22.put("cid", str3);
                hashMap22.put("req_id", str4);
                hashMap22.put("customer_id", str5);
                com.bytedance.sdk.openadsdk.core.kt.xt.j(cw2, arrayList, true, hashMap22, com.bytedance.sdk.openadsdk.core.jy.cw.j(optString, str2, str4, str7, str6));
            }
        } catch (Throwable unused6) {
        }
    }

    public void xt(String str, JSONObject jSONObject) {
        try {
            com.bytedance.sdk.component.j.i iVar = this.gq;
            if (iVar != null) {
                iVar.j(str, (String) jSONObject);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.cw("TTAndroidObject", "sendJsMsg2020 error", th);
        }
    }

    public void oq(boolean z5) {
        this.uf = z5;
    }

    public void qv(boolean z5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("visibleState", !z5 ? 1 : 0);
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.r("TTAndroidObject", e6.getMessage());
        }
        r("visibleStateChange", jSONObject);
    }

    public JSONObject j() {
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g> weakReference = this.f30022b;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.f30022b.get().getContainerInfo();
    }

    public void j(SSWebView.xt xtVar) {
        WeakReference<SSWebView> weakReference = this.f30034r;
        if (weakReference == null || weakReference.get() == null || xtVar == null) {
            return;
        }
        this.f30034r.get().setOnShakeListener(xtVar);
    }

    public rn j(com.bytedance.sdk.openadsdk.core.ugeno.ae.xt xtVar) {
        this.hl = new WeakReference<>(xtVar);
        return this;
    }

    public rn j(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g gVar) {
        this.f30022b = new WeakReference<>(gVar);
        return this;
    }

    public void j(int i6) {
        if (f30020e) {
            com.bytedance.sdk.component.utils.vl.xt("TTAndroidObject", "blocked Twist");
            return;
        }
        if (i6 != 1) {
            if (i6 == 2) {
                j("twist_callback", (JSONObject) null);
            }
        } else {
            if (this.jy != null && r()) {
                com.bytedance.sdk.openadsdk.core.qv.cw.cw.m.f29897r = true;
            }
            j("wobble_callback", (JSONObject) null);
        }
    }

    public rn j(com.bytedance.sdk.openadsdk.m.j jVar) {
        this.la = jVar;
        return this;
    }

    public rn j(View view) {
        this.f30025g = new WeakReference<>(view);
        return this;
    }

    public rn j(com.bytedance.sdk.openadsdk.core.w.xt xtVar) {
        this.ch = new WeakReference<>(xtVar);
        return this;
    }

    public rn j(com.bytedance.sdk.openadsdk.core.w.m mVar) {
        this.f30035s = new WeakReference<>(mVar);
        return this;
    }

    public rn j(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        this.jy = nVar;
        return this;
    }

    public rn j(com.bytedance.sdk.component.adexpress.xt.qv qvVar) {
        this.f30027i = new SoftReference<>(qvVar);
        return this;
    }

    public rn j(com.bytedance.sdk.openadsdk.core.nativeexpress.qv qvVar) {
        this.f30037w.j(qvVar);
        return this;
    }

    public rn j(com.bytedance.sdk.openadsdk.core.av.r rVar) {
        this.kt = new WeakReference<>(rVar);
        return this;
    }

    public rn j(JSONObject jSONObject) {
        this.f30038x = jSONObject;
        return this;
    }

    public rn j(Map<String, Object> map) {
        this.f30028j = map;
        return this;
    }

    public rn j(com.bytedance.sdk.openadsdk.core.w.j jVar) {
        this.tj = new WeakReference<>(jVar);
        return this;
    }

    public rn j(com.bytedance.sdk.openadsdk.core.w.r rVar) {
        this.f30024f = new WeakReference<>(rVar);
        return this;
    }

    public rn j(com.bytedance.sdk.openadsdk.qv.j jVar) {
        this.f30036v = new WeakReference<>(jVar);
        return this;
    }

    public void j(ae.j jVar) {
        this.rh = jVar;
    }

    public void j(com.bytedance.sdk.openadsdk.core.ugeno.xt xtVar) {
        this.ol = xtVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0225, code lost:
    
        if (r3 != null) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0227, code lost:
    
        r2 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x024f, code lost:
    
        if (r3 != null) goto L153;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject j(com.bytedance.sdk.openadsdk.core.rn.j r18, int r19) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 914
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.rn.j(com.bytedance.sdk.openadsdk.core.rn$j, int):org.json.JSONObject");
    }

    public void j(float f6) {
        if (this.f30037w.vl() == null) {
            return;
        }
        try {
            this.f30037w.vl().j(f6);
        } catch (Exception unused) {
        }
    }

    public void j(float f6, float f7, float f8, float f9, int i6) {
        this.f30037w.j(f6, f7, f8, f9, i6);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004c A[Catch: Exception -> 0x00a4, TryCatch #0 {Exception -> 0x00a4, blocks: (B:6:0x000d, B:9:0x0027, B:11:0x002d, B:14:0x0034, B:15:0x003e, B:17:0x004c, B:18:0x006a, B:20:0x0087, B:23:0x008f, B:25:0x0096, B:26:0x009a, B:34:0x0059, B:35:0x0062, B:37:0x001f), top: B:5:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0096 A[Catch: Exception -> 0x00a4, TryCatch #0 {Exception -> 0x00a4, blocks: (B:6:0x000d, B:9:0x0027, B:11:0x002d, B:14:0x0034, B:15:0x003e, B:17:0x004c, B:18:0x006a, B:20:0x0087, B:23:0x008f, B:25:0x0096, B:26:0x009a, B:34:0x0059, B:35:0x0062, B:37:0x001f), top: B:5:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject j(com.bytedance.sdk.openadsdk.core.tj.n r9, java.util.concurrent.atomic.AtomicBoolean r10) {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            com.bytedance.sdk.openadsdk.core.p.oq r1 = com.bytedance.sdk.openadsdk.core.v.xt()
            if (r1 != 0) goto Ld
            goto La4
        Ld:
            int r1 = com.bytedance.sdk.openadsdk.core.rn.uf.g(r9)     // Catch: java.lang.Exception -> La4
            int r2 = com.bytedance.sdk.openadsdk.core.rn.uf.tl(r9)     // Catch: java.lang.Exception -> La4
            r3 = 1
            boolean r4 = com.bytedance.sdk.openadsdk.core.tj.la.xt(r3, r9, r3)     // Catch: java.lang.Exception -> La4
            r5 = 0
            if (r4 == 0) goto L1f
            r4 = 0
            goto L27
        L1f:
            com.bytedance.sdk.openadsdk.core.p.oq r4 = com.bytedance.sdk.openadsdk.core.v.xt()     // Catch: java.lang.Exception -> La4
            int r4 = r4.up(r1)     // Catch: java.lang.Exception -> La4
        L27:
            boolean r6 = j(r2, r9)     // Catch: java.lang.Exception -> La4
            if (r6 != 0) goto L3d
            boolean r6 = com.bytedance.sdk.openadsdk.core.tj.la.xt(r5, r9, r3)     // Catch: java.lang.Exception -> La4
            if (r6 == 0) goto L34
            goto L3d
        L34:
            com.bytedance.sdk.openadsdk.core.p.oq r6 = com.bytedance.sdk.openadsdk.core.v.xt()     // Catch: java.lang.Exception -> La4
            int r6 = r6.m(r1)     // Catch: java.lang.Exception -> La4
            goto L3e
        L3d:
            r6 = 0
        L3e:
            com.bytedance.sdk.openadsdk.core.p.oq r7 = com.bytedance.sdk.openadsdk.core.v.xt()     // Catch: java.lang.Exception -> La4
            java.lang.String r8 = java.lang.String.valueOf(r1)     // Catch: java.lang.Exception -> La4
            boolean r7 = r7.up(r8)     // Catch: java.lang.Exception -> La4
            if (r10 == 0) goto L51
            boolean r10 = r10.get()     // Catch: java.lang.Exception -> La4
            goto L6a
        L51:
            r10 = 7
            if (r2 == r10) goto L62
            r10 = 8
            if (r2 != r10) goto L59
            goto L62
        L59:
            com.bytedance.sdk.openadsdk.core.p.oq r10 = com.bytedance.sdk.openadsdk.core.v.xt()     // Catch: java.lang.Exception -> La4
            boolean r10 = r10.r(r1)     // Catch: java.lang.Exception -> La4
            goto L6a
        L62:
            com.bytedance.sdk.openadsdk.core.p.oq r10 = com.bytedance.sdk.openadsdk.core.v.xt()     // Catch: java.lang.Exception -> La4
            boolean r10 = r10.j(r9, r1)     // Catch: java.lang.Exception -> La4
        L6a:
            java.lang.String r1 = "ad_slot_type"
            r0.put(r1, r2)     // Catch: java.lang.Exception -> La4
            java.lang.String r1 = "voice_control"
            r0.put(r1, r10)     // Catch: java.lang.Exception -> La4
            java.lang.String r10 = "rv_skip_time"
            r0.put(r10, r4)     // Catch: java.lang.Exception -> La4
            java.lang.String r10 = "fv_skip_show"
            r0.put(r10, r7)     // Catch: java.lang.Exception -> La4
            java.lang.String r10 = "iv_skip_time"
            r0.put(r10, r6)     // Catch: java.lang.Exception -> La4
            java.lang.String r10 = "show_dislike"
            if (r9 == 0) goto L8e
            boolean r1 = r9.xa()     // Catch: java.lang.Exception -> La4
            if (r1 == 0) goto L8e
            goto L8f
        L8e:
            r3 = 0
        L8f:
            r0.put(r10, r3)     // Catch: java.lang.Exception -> La4
            java.lang.String r10 = "video_adaptation"
            if (r9 == 0) goto L9a
            int r5 = r9.ry()     // Catch: java.lang.Exception -> La4
        L9a:
            r0.put(r10, r5)     // Catch: java.lang.Exception -> La4
            java.lang.String r9 = "h5_cache_resources_enable"
            boolean r10 = com.bytedance.sdk.openadsdk.core.tj.p.f30389j     // Catch: java.lang.Exception -> La4
            r0.put(r9, r10)     // Catch: java.lang.Exception -> La4
        La4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.rn.j(com.bytedance.sdk.openadsdk.core.tj.n, java.util.concurrent.atomic.AtomicBoolean):org.json.JSONObject");
    }

    public static boolean j(int i6, com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        com.bytedance.sdk.openadsdk.core.tj.l ng;
        if (i6 == 8 && com.bytedance.sdk.openadsdk.core.tj.l.j(nVar) && (ng = nVar.ng()) != null) {
            return ng.r();
        }
        return false;
    }

    private void j(final j jVar, final JSONObject jSONObject) {
        if (jVar == null) {
            return;
        }
        try {
            j(jVar.f30081r, new com.bytedance.sdk.openadsdk.core.w.cw() { // from class: com.bytedance.sdk.openadsdk.core.rn.11
                @Override // com.bytedance.sdk.openadsdk.core.w.cw
                public void j(boolean z5, List<com.bytedance.sdk.openadsdk.core.tj.n> list, boolean z6) {
                    if (!z5) {
                        rn.this.cw(jVar.xt, jSONObject);
                        return;
                    }
                    try {
                        jSONObject.put("creatives", rn.j(list));
                        rn.this.cw(jVar.xt, jSONObject);
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    private boolean j(String str, int i6, com.bytedance.sdk.openadsdk.core.tj.x xVar) {
        HashMap<String, qv> hashMap;
        qv qvVar;
        if (TextUtils.isEmpty(str) || (hashMap = this.f30029l) == null || (qvVar = hashMap.get(str)) == null) {
            return false;
        }
        qvVar.j(i6, xVar);
        return true;
    }

    public void j(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.w.cw cwVar) {
        com.bytedance.sdk.openadsdk.core.v.xt.j(this.jy, jSONObject, cwVar, (com.bytedance.sdk.openadsdk.i.cw.cw.xt) null);
    }

    public boolean j(Uri uri) {
        if (uri == null) {
            return false;
        }
        if ("bytedance".equals(uri.getScheme())) {
            return cw.containsKey(uri.getHost());
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void j(com.bytedance.sdk.openadsdk.core.tj.n nVar, int i6) {
        WeakReference<Context> weakReference = this.f30030m;
        if (weakReference == null || nVar == null || weakReference.get() == null) {
            return;
        }
        Context context = this.f30030m.get();
        com.bytedance.sdk.openadsdk.core.xt.j jVar = new com.bytedance.sdk.openadsdk.core.xt.j(context, nVar, this.rn, this.qv);
        ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).xt(true);
        com.bytedance.sdk.component.qv.up.j.j().j(nVar.hashCode() + nVar.ej()).put("live_saas_interaction_type", Integer.valueOf(i6));
        final String fs = nVar.fs();
        com.bytedance.sdk.openadsdk.core.qv.xt.r xt = com.bytedance.sdk.openadsdk.core.qv.tl.xt(context, nVar, this.rn, false);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j((com.bytedance.sdk.openadsdk.core.qv.xt.cw) xt);
        jVar.j(null, new com.bytedance.sdk.openadsdk.core.tj.qv());
        if (xt != null) {
            xt.j(new com.bytedance.sdk.openadsdk.core.qv.xt.j() { // from class: com.bytedance.sdk.openadsdk.core.rn.4
                @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
                public void j() {
                    j.C0431j.j(fs, 1, 0);
                }

                @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
                public void cw(long j6, long j7, String str, String str2) {
                    if (j6 > 0) {
                        j.C0431j.j(fs, 4, (int) ((j7 * 100) / j6));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
                public void j(long j6, long j7, String str, String str2) {
                    if (j6 > 0) {
                        j.C0431j.j(fs, 3, (int) ((j7 * 100) / j6));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
                public void xt(long j6, long j7, String str, String str2) {
                    if (j6 > 0) {
                        j.C0431j.j(fs, 2, (int) ((j7 * 100) / j6));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
                public void j(long j6, String str, String str2) {
                    j.C0431j.j(fs, 5, 100);
                }

                @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
                public void j(String str, String str2) {
                    j.C0431j.j(fs, 6, 100);
                }
            });
        }
        if (b()) {
            WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g> weakReference2 = this.f30022b;
            if (weakReference2 == null || weakReference2.get() == null) {
                return;
            }
            this.f30022b.get().r();
            return;
        }
        if (context instanceof com.bytedance.sdk.openadsdk.core.tl.xt) {
            ((com.bytedance.sdk.openadsdk.core.tl.xt) context).j(1);
        }
    }

    private String j(String str, String str2) {
        return ((("landing_perf_stats".equals(str2) || "landing_perf_exception".equals(str2)) && "landingpage".equals(str)) || this.f30027i != null || b()) ? str : com.bytedance.sdk.openadsdk.core.rn.uf.j(this.qv);
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        if (message != null && message.what == 11) {
            Object obj = message.obj;
            if (obj instanceof j) {
                try {
                    j((j) obj, 1);
                } catch (Exception unused) {
                }
            }
        }
    }

    public void j(String str, boolean z5) {
        com.bytedance.sdk.openadsdk.core.av.cw cwVar = this.ae;
        if (cwVar != null) {
            cwVar.j(str, z5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.av.xt
    public void j(String str, JSONObject jSONObject) {
        wq();
        r(str, jSONObject);
    }

    public void j(JSONObject jSONObject, boolean z5) {
        WeakReference<Context> weakReference;
        if (this.ae == null || (weakReference = this.f30030m) == null || weakReference.get() == null) {
            return;
        }
        this.ae.j(this.av && this.az);
        this.ae.xt(z5);
        this.ae.j(this.f30030m.get(), jSONObject, this.rn, this.oq);
    }

    public void j(com.bytedance.sdk.openadsdk.core.w.up upVar) {
        this.qb = new WeakReference<>(upVar);
    }

    public void j(int i6, int i7) {
        int cw2 = com.bytedance.sdk.openadsdk.core.rn.ed.cw(v.getContext(), i6);
        int cw3 = com.bytedance.sdk.openadsdk.core.rn.ed.cw(v.getContext(), i7);
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g> weakReference = this.f30022b;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f30022b.get().j(Integer.MIN_VALUE, Integer.MIN_VALUE, cw2, cw3);
    }

    public void j(int i6, int i7, int i8, int i9) {
        int i10;
        int i11;
        int i12;
        int i13 = Integer.MIN_VALUE;
        if (i6 == Integer.MAX_VALUE || i7 == Integer.MAX_VALUE) {
            i10 = Integer.MIN_VALUE;
            i11 = Integer.MIN_VALUE;
        } else {
            i10 = com.bytedance.sdk.openadsdk.core.rn.ed.cw(v.getContext(), i6);
            i11 = com.bytedance.sdk.openadsdk.core.rn.ed.cw(v.getContext(), i7);
        }
        if (i8 == Integer.MAX_VALUE || i9 == Integer.MAX_VALUE) {
            i12 = Integer.MIN_VALUE;
        } else {
            i13 = com.bytedance.sdk.openadsdk.core.rn.ed.cw(v.getContext(), i8);
            i12 = com.bytedance.sdk.openadsdk.core.rn.ed.cw(v.getContext(), i9);
        }
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g> weakReference = this.f30022b;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f30022b.get().j(i10, i11, i13, i12);
    }
}
