package com.bytedance.sdk.openadsdk.core.jy;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.qv;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.az.j;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.rn.n;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private long f29259a;

    /* renamed from: f, reason: collision with root package name */
    private JSONObject f29260f;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<xt> f29262h;
    private com.bytedance.sdk.component.jy.cw kt;

    /* renamed from: l, reason: collision with root package name */
    private Runnable f29265l;

    /* renamed from: m, reason: collision with root package name */
    private final n f29266m;

    /* renamed from: r, reason: collision with root package name */
    private String f29268r;
    private String up;

    /* renamed from: v, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.m.j f29270v;

    /* renamed from: j, reason: collision with root package name */
    private int f29264j = 0;
    private volatile boolean xt = false;
    private int cw = -1;
    private String ae = "landingpage";
    private long tl = 0;

    /* renamed from: g, reason: collision with root package name */
    private long f29261g = 0;
    private long oq = 0;
    private long qv = 0;
    private long vl = 0;
    private boolean jy = false;
    private long ws = 0;
    private long az = 0;
    private long av = 0;

    /* renamed from: i, reason: collision with root package name */
    private long f29263i = -1;

    /* renamed from: w, reason: collision with root package name */
    private boolean f29271w = false;
    private AtomicInteger mi = new AtomicInteger(0);
    private boolean tj = false;

    /* renamed from: x, reason: collision with root package name */
    private AtomicBoolean f29272x = new AtomicBoolean(false);
    private boolean ch = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f29269s = true;

    /* renamed from: p, reason: collision with root package name */
    private final Map<String, n.j> f29267p = new ConcurrentHashMap();

    private static class j {

        /* renamed from: j, reason: collision with root package name */
        private final AtomicInteger f29276j;
        private final WeakReference<xt> xt;

        @JavascriptInterface
        public void readPercent(String str) {
            int i6 = 0;
            try {
                int intValue = Float.valueOf(str).intValue();
                if (intValue > 100) {
                    i6 = 100;
                } else if (intValue >= 0) {
                    i6 = intValue;
                }
            } catch (Throwable unused) {
            }
            AtomicInteger atomicInteger = this.f29276j;
            if (atomicInteger != null) {
                atomicInteger.set(i6);
            }
            WeakReference<xt> weakReference = this.xt;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.xt.get().j(str);
        }

        @JavascriptInterface
        public String getUrl() {
            return "";
        }

        j(AtomicInteger atomicInteger, WeakReference<xt> weakReference) {
            this.f29276j = atomicInteger;
            this.xt = weakReference;
        }

        @JavascriptInterface
        public void readHtml(String str, String str2) {
        }
    }

    public interface xt {
        void j(String str);
    }

    public r r(long j6) {
        this.f29263i = j6;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.az.j.f27963j) && this.f29266m != null) {
                StringBuilder sb = new StringBuilder(com.bytedance.sdk.openadsdk.core.az.j.f27963j);
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("cid", this.f29266m.fs());
                jSONObject.putOpt(MediationConstant.EXTRA_ADID, this.f29266m.so());
                jSONObject.put(MediationConstant.EXTRA_LOG_EXTRA, this.f29266m.os());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("web_init_time", this.av);
                jSONObject2.put("click_time", this.az);
                jSONObject2.put("web_url", this.f29266m.yb());
                jSONObject.put("client_info", jSONObject2);
                com.bytedance.sdk.openadsdk.core.az.j.j(sb, "\"/** adInfo **/\"", jSONObject.toString());
                String sb2 = sb.toString();
                if (TextUtils.isEmpty(sb2)) {
                    return;
                }
                String concat = "javascript:".concat(String.valueOf(sb2));
                com.bytedance.sdk.component.jy.cw cwVar = this.kt;
                if (cwVar != null) {
                    qv.j(cwVar, concat);
                }
            }
        } catch (Throwable th) {
            vl.cw(th.getMessage());
        }
    }

    public void ae() {
        com.bytedance.sdk.openadsdk.core.az.j.j ya;
        com.bytedance.sdk.component.jy.cw cwVar;
        if (this.f29264j != 2 || !this.jy || (ya = v.xt().ya()) == null || (cwVar = this.kt) == null) {
            return;
        }
        ya.j(cwVar.getWebView(), this.f29266m);
    }

    public com.bytedance.sdk.openadsdk.m.j cw() {
        return this.f29270v;
    }

    public void j(xt xtVar) {
        this.f29262h = new WeakReference<>(xtVar);
    }

    public void m() {
        com.bytedance.sdk.component.jy.cw cwVar = this.kt;
        if (cwVar != null) {
            cwVar.removeJavascriptInterface("JS_LANDING_PAGE_LOG_OBJ");
        }
        this.kt = null;
        if (!this.f29272x.get() && this.xt) {
            cw.cw(this.f29266m, this.ae, System.currentTimeMillis() - this.ws);
        }
        this.f29265l = null;
        if (this.f29267p.isEmpty()) {
            return;
        }
        ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.r.2
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() {
                com.bytedance.sdk.openadsdk.core.kt.j.xt j6 = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("web_cache_hit_report");
                if (r.this.f29266m != null) {
                    j6.m(r.this.f29266m.ej());
                }
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (n.j jVar : r.this.f29267p.values()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("url", jVar.cw());
                        jSONObject2.put("hit", jVar.r());
                        jSONObject2.put("miss", jVar.up());
                        jSONArray.put(jSONObject2);
                    } catch (JSONException unused) {
                    }
                }
                try {
                    jSONObject.put("hit_records", jSONArray);
                } catch (JSONException unused2) {
                }
                j6.xt(jSONObject.toString());
                return j6;
            }
        }, "web_cache_hit_report");
    }

    public void r() {
        this.tl = System.currentTimeMillis();
        if (this.ws == 0) {
            this.ws = System.currentTimeMillis();
        }
    }

    public Map<String, n.j> tl() {
        return this.f29267p;
    }

    public void up() {
        if (this.f29269s) {
            this.f29269s = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", this.f29259a);
                jSONObject.put("end", System.currentTimeMillis());
                com.bytedance.sdk.openadsdk.up.j.j(jSONObject, this.f29266m);
            } catch (JSONException e6) {
                vl.j(e6);
            }
            cw.j(this.f29266m, "landingpage", "agg_stay_page", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.r.1
                @Override // com.bytedance.sdk.openadsdk.m.j.j
                public void j(JSONObject jSONObject2) throws JSONException {
                    jSONObject2.put("ad_extra_data", jSONObject);
                }
            });
        }
        if (this.f29264j == 2) {
            if (this.oq > 0 || !xt()) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f29261g = currentTimeMillis;
                long max = currentTimeMillis - Math.max(this.tl, this.oq);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("load_status", this.f29264j);
                    jSONObject2.put("max_scroll_percent", this.mi.get());
                    jSONObject2.putOpt("render_type", "h5");
                    jSONObject2.putOpt("render_type_2", 0);
                } catch (JSONException unused) {
                }
                j("stay_page", jSONObject2, Math.min(max, TTAdConstant.AD_MAX_EVENT_TIME));
            }
        }
    }

    public boolean xt() {
        return this.ch;
    }

    public r(com.bytedance.sdk.openadsdk.core.tj.n nVar, com.bytedance.sdk.component.jy.cw cwVar) {
        this.f29266m = nVar;
        this.kt = cwVar;
        if (cwVar != null) {
            cwVar.addJavascriptInterface(new j(this.mi, this.f29262h), "JS_LANDING_PAGE_LOG_OBJ");
        }
        this.f29259a = System.currentTimeMillis();
    }

    public r cw(long j6) {
        this.av = j6;
        return this;
    }

    public void j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.ae = str;
    }

    public r xt(boolean z5) {
        this.tj = z5;
        return this;
    }

    public r xt(long j6) {
        this.az = j6;
        return this;
    }

    public String j() {
        return this.ae;
    }

    public void xt(String str) {
        if (this.tj) {
            if ("load_finish".equals(str) && "landingpage".equals(this.ae)) {
                Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.r.3
                    @Override // java.lang.Runnable
                    public void run() {
                        r.this.g();
                    }
                };
                this.f29265l = runnable;
                com.bytedance.sdk.openadsdk.core.az.j.j(new j.RunnableC0434j(runnable));
            }
            long j6 = this.vl - this.qv;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_code", this.cw);
                jSONObject.put("error_msg", this.f29268r);
                jSONObject.put("error_url", this.up);
                jSONObject.putOpt("render_type", "h5");
                jSONObject.putOpt("render_type_2", 0);
                long j7 = this.az;
                if (j7 > 0) {
                    jSONObject.put("exp_duration", this.vl - j7);
                }
                long j8 = this.av;
                if (j8 > 0) {
                    jSONObject.put("web_duration", this.vl - j8);
                }
                long j9 = this.f29263i;
                if (j9 >= 0) {
                    jSONObject.put("webview_duration", j9);
                }
            } catch (Exception unused) {
            }
            j(str, jSONObject, Math.min(j6, TTAdConstant.AD_MAX_EVENT_TIME));
        }
    }

    public void j(long j6) {
        this.oq = j6;
    }

    public void j(boolean z5) {
        this.ch = z5;
    }

    public void j(com.bytedance.sdk.openadsdk.m.j jVar) {
        this.f29270v = jVar;
    }

    public void j(JSONObject jSONObject) {
        this.f29260f = jSONObject;
    }

    public void j(WebView webView, int i6) {
        if (this.qv == 0 && i6 > 0) {
            this.f29264j = 1;
            this.qv = System.currentTimeMillis();
        } else {
            if (i6 != 100 || this.jy) {
                return;
            }
            this.jy = true;
            this.vl = System.currentTimeMillis();
            if (!"landingpage".equals(this.ae) || this.f29264j == 3) {
                return;
            }
            xt("landingpage_load_hundred");
        }
    }

    public void j(WebView webView, String str, Bitmap bitmap) {
        com.bytedance.sdk.openadsdk.m.j jVar = this.f29270v;
        if (jVar != null) {
            jVar.m();
        }
        if (this.xt) {
            return;
        }
        this.ws = System.currentTimeMillis();
        this.xt = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "h5");
            jSONObject.putOpt("render_type_2", 0);
        } catch (Exception unused) {
        }
        j("load_start", jSONObject);
    }

    public void j(WebView webView) {
        com.bytedance.sdk.openadsdk.m.j jVar = this.f29270v;
        if (jVar != null) {
            jVar.ae();
        }
        if (this.vl <= 0) {
            this.vl = System.currentTimeMillis();
        }
        if (webView != null && !this.f29271w && this.tj) {
            this.f29271w = true;
            qv.j(webView, "javascript:\n    function sendScroll() {\n        try {\n            var totalH = document.body.scrollHeight || document.documentElement.scrollHeight;\n            var clientH = window.innerHeight || document.documentElement.clientHeight;\n            var scrollH = document.body.scrollTop || document.documentElement.scrollTop;\n            var validH = scrollH + clientH;\n            var result = (validH / totalH * 100).toFixed(2);\n            console.log('LandingPageLogscroll status: (' + scrollH + '+' + clientH + ')/' + totalH + '=' + result);\n            window.JS_LANDING_PAGE_LOG_OBJ.readPercent(result);\n        } catch (e) {\n            console.log('sendScroll error' + e)\n        }\n    }\nsendScroll();\nwindow.addEventListener('scroll', function (e) {\n    sendScroll();\n});");
        }
        if (this.f29272x.get()) {
            return;
        }
        if (this.f29264j != 3) {
            this.f29264j = 2;
        }
        this.f29272x.set(true);
        this.tl = System.currentTimeMillis();
        if (this.f29264j == 2) {
            xt("load_finish");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error_code", this.cw);
            jSONObject.put("error_msg", this.f29268r);
            jSONObject.put("error_url", this.up);
            jSONObject.putOpt("render_type", "h5");
            jSONObject.putOpt("render_type_2", 0);
        } catch (Exception unused) {
        }
        j("load_fail", jSONObject);
    }

    public void j(int i6, String str, String str2, String str3) {
        com.bytedance.sdk.openadsdk.m.j jVar = this.f29270v;
        if (jVar != null) {
            jVar.tl();
        }
        if ((str3 == null || !str3.startsWith(SocializeProtocolConstants.IMAGE)) && this.f29264j != 2) {
            this.f29264j = 3;
        }
        this.cw = i6;
        this.f29268r = str;
        this.up = str2;
    }

    private void j(String str, JSONObject jSONObject) {
        j(str, jSONObject, -1L);
    }

    private void j(String str, JSONObject jSONObject, long j6) {
        if (!this.tj || this.f29266m == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("ad_extra_data", jSONObject.toString());
                    if (j6 > 0) {
                        jSONObject3.put("duration", j6);
                    }
                } catch (JSONException unused) {
                }
                jSONObject2 = jSONObject3;
            } catch (JSONException unused2) {
            }
        }
        cw.cw(this.f29266m, this.ae, str, jSONObject2);
    }
}
