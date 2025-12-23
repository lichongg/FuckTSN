package com.bytedance.sdk.openadsdk.core.jy;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.rr;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.feature.dynamic.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl implements com.bytedance.sdk.openadsdk.m.j {
    private JSONArray ae;
    private Boolean cw;

    /* renamed from: g, reason: collision with root package name */
    private boolean f29277g;

    /* renamed from: j, reason: collision with root package name */
    private String f29278j;
    private volatile int jy;

    /* renamed from: m, reason: collision with root package name */
    private JSONObject f29279m;
    private int oq;
    private AtomicLong qv;

    /* renamed from: r, reason: collision with root package name */
    private Boolean f29280r;
    private JSONArray tl;
    private Boolean up;
    private JSONObject vl;
    private volatile boolean ws;
    private n xt;

    public tl(String str, n nVar, JSONObject jSONObject) {
        this.f29278j = "embeded_ad";
        Boolean bool = Boolean.FALSE;
        this.cw = bool;
        this.f29280r = bool;
        this.up = bool;
        this.f29277g = false;
        this.qv = new AtomicLong();
        this.jy = 0;
        this.ws = false;
        this.f29278j = str;
        this.xt = nVar;
        this.f29279m = jSONObject;
        this.ae = new JSONArray();
        this.tl = new JSONArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        if (this.up.booleanValue()) {
            return true;
        }
        return this.f29280r.booleanValue() && this.cw.booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.m.r.r
    public void ae() {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.10
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    tl.this.j(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.f29279m, "webview_load_success", jSONObject);
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.j
    public void az() {
        this.cw = Boolean.TRUE;
    }

    @Override // com.bytedance.sdk.openadsdk.m.r.xt
    public void cw() {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.27
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    tl.this.j(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.f29279m, "native_render_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    public void g() {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.13
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    tl.this.j(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.f29279m, "native_endcard_show", jSONObject);
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.r.r
    public void m() {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.9
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    tl.this.j(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.f29279m, "webview_load_start", (Object) jSONObject, false);
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.r.j
    public void r(final String str) {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.2
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    tl.this.j(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.f29279m, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.r.r
    public void tl() {
        xt((JSONObject) null);
    }

    @Override // com.bytedance.sdk.openadsdk.m.r.j
    public void up(final String str) {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.3
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    tl.this.j(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.f29279m, str, jSONObject);
                    if (!tl.this.f29278j.equals("splash_ad") && !tl.this.f29278j.equals("cache_splash_ad")) {
                        com.bytedance.sdk.openadsdk.core.ch.j.j().j("ugen_render", "native_render_success", String.valueOf(currentTimeMillis) + "0");
                    }
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.r.cw
    public void xt() {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.12
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    tl.this.j(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.f29279m, "render_success", jSONObject);
                    if (!tl.this.f29278j.equals("splash_ad") && !tl.this.f29278j.equals("cache_splash_ad")) {
                        if (tl.this.f29279m.optInt("webview_source", -1) == 2) {
                            vl.j(tl.this.f29278j, "no count ENDCARD_SOURCE");
                            return;
                        }
                        com.bytedance.sdk.openadsdk.core.ch.j.j().j("ugen_render", "h5_render_success", String.valueOf(currentTimeMillis) + "0");
                    }
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.j
    public void av() {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.25
                @Override // java.lang.Runnable
                public void run() {
                    if (tl.this.i() && !tl.this.f29277g) {
                        if (tl.this.ae != null && tl.this.ae.length() != 0) {
                            try {
                                tl.this.f29279m.put("native_switchBackgroundAndForeground", tl.this.ae);
                            } catch (Exception unused) {
                            }
                        }
                        if (tl.this.tl != null && tl.this.tl.length() != 0) {
                            try {
                                tl.this.f29279m.put("intercept_source", tl.this.tl);
                            } catch (Exception unused2) {
                            }
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("webview_time_track", tl.this.f29279m);
                        oq.i().z();
                        cw.ae(tl.this.xt, tl.this.f29278j, "webview_time_track", hashMap);
                        tl.this.f29277g = true;
                    }
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.r.xt
    public void jy() {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.21
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    tl.this.j(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.f29279m, "no_native_render", jSONObject);
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    public void oq() {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.14
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    tl.this.j(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.f29279m, "native_endcard_close", jSONObject);
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    public void qv() {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.15
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    tl.this.j(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    tl.this.j(jSONObject, "type", "native_enterBackground");
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.ae, jSONObject);
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    public void vl() {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.16
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    tl.this.j(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    tl.this.j(jSONObject, "type", "native_enterForeground");
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.ae, jSONObject);
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.r.cw
    public void ws() {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.22
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    tl.this.j(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.f29279m, "render_failed", jSONObject);
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.r.r
    public void ae(final String str) {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.20
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    tl.this.j(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    tl.this.j(jSONObject, "jsb", str);
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.f29279m, "webview_jsb_end", jSONObject);
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.r.j
    public void cw(final String str) {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.30
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    tl.this.j(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.f29279m, str, jSONObject);
                    if (!tl.this.f29278j.equals("splash_ad") && !tl.this.f29278j.equals("cache_splash_ad")) {
                        com.bytedance.sdk.openadsdk.core.ch.j.j().j("ugen_render", "native_render_success", String.valueOf(currentTimeMillis) + "0");
                    }
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.r.r
    public void m(final String str) {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.19
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    tl.this.j(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    tl.this.j(jSONObject, "jsb", str);
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.f29279m, "webview_jsb_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    public void r() {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.7
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    tl.this.j(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.f29279m, "native_render_end", jSONObject);
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.r.xt
    public void up() {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.8
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    tl.this.j(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.f29279m, "native_render_end", jSONObject);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    JSONObject jSONObject2 = new JSONObject();
                    tl.this.j(jSONObject2, "ts", Long.valueOf(currentTimeMillis2));
                    tl tlVar2 = tl.this;
                    tlVar2.j(tlVar2.f29279m, "render_success", jSONObject2);
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.r.j
    public void xt(final String str) {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.29
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    tl.this.j(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.f29279m, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.r.j
    public void cw(final int i6, final String str) {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.4
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    tl.this.j(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    tl.this.j(jSONObject, "code", Integer.valueOf(i6));
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.f29279m, str, jSONObject);
                    if (!tl.this.f29278j.equals("splash_ad") && !tl.this.f29278j.equals("cache_splash_ad")) {
                        com.bytedance.sdk.openadsdk.core.ch.j.j().j("ugen_render", "native_render_fail", String.valueOf(currentTimeMillis) + "1");
                    }
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.r.cw
    public void j() {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.1
                @Override // java.lang.Runnable
                public void run() {
                    tl.this.qv.set(System.currentTimeMillis());
                    JSONObject jSONObject = new JSONObject();
                    tl tlVar = tl.this;
                    tlVar.j(jSONObject, "ts", Long.valueOf(tlVar.qv.get()));
                    tl tlVar2 = tl.this;
                    tlVar2.j(jSONObject, "render_sequence", Integer.valueOf(hh.xt(tlVar2.xt)));
                    tl tlVar3 = tl.this;
                    tlVar3.j(jSONObject, "render_timeout", Integer.valueOf(tlVar3.oq));
                    tl.this.j(jSONObject, "webview_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.up.up.j().up()));
                    tl.this.j(jSONObject, "available_cache_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.up.up.j().cw()));
                    rr ae = hh.ae(tl.this.xt);
                    if (ae != null) {
                        tl.this.j(jSONObject, "rule_id", ae.tl());
                    } else {
                        tl.this.j(jSONObject, "rule_id", "0");
                    }
                    tl tlVar4 = tl.this;
                    tlVar4.j(tlVar4.f29279m, "render_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.j
    public void r(final JSONObject jSONObject) {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.24
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2;
                    if (tl.this.f29279m == null || (jSONObject2 = jSONObject) == null) {
                        return;
                    }
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        tl tlVar = tl.this;
                        tlVar.j(tlVar.f29279m, next, jSONObject.opt(next));
                    }
                    tl.this.f29280r = Boolean.TRUE;
                    tl.this.av();
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.r.j
    public void xt(final int i6, final String str) {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.31
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    tl.this.j(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    tl.this.j(jSONObject, "code", Integer.valueOf(i6));
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.f29279m, str, jSONObject);
                    if (!tl.this.f29278j.equals("splash_ad") && !tl.this.f29278j.equals("cache_splash_ad")) {
                        com.bytedance.sdk.openadsdk.core.ch.j.j().j("ugen_render", "native_render_fail", String.valueOf(currentTimeMillis) + "1");
                    }
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.r.cw
    public void cw(final JSONObject jSONObject) {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.23
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    tl.this.j(jSONObject2, "ts", Long.valueOf(currentTimeMillis));
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.f29279m, "render_did_finish", jSONObject2);
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.r.cw
    public void j(final int i6, final String str) {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.26
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    tl.this.j(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    tl.this.j(jSONObject, "code", Integer.valueOf(i6));
                    String str2 = str;
                    if (str2 != null) {
                        tl.this.j(jSONObject, MediationConstant.KEY_REASON, str2);
                    }
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.f29279m, "render_error", jSONObject);
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    public void xt(final JSONObject jSONObject) {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.11
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    tl.this.j(jSONObject2, "ts", Long.valueOf(System.currentTimeMillis()));
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.f29279m, "webview_load_error", jSONObject2);
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.r.j
    public void j(final String str) {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.28
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    tl.this.j(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.f29279m, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.r.r
    public void xt(final String str, final long j6, final long j7, final int i6) {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.18
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str) || j7 < j6) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    tl.this.j(jSONObject, "start_ts", Long.valueOf(j6));
                    tl.this.j(jSONObject, "end_ts", Long.valueOf(j7));
                    tl.this.j(jSONObject, "intercept_type", Integer.valueOf(i6));
                    tl.this.j(jSONObject, "type", "intercept_js");
                    tl.this.j(jSONObject, "url", str);
                    tl.this.j(jSONObject, "duration", Long.valueOf(j7 - j6));
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.tl, jSONObject);
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.r.j
    public void j(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.5
                @Override // java.lang.Runnable
                public void run() {
                    tl.this.j(jSONObject, "ts", Long.valueOf(System.currentTimeMillis()));
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.f29279m, "render_exception", jSONObject);
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.j
    public void xt(boolean z5) {
        try {
            if (!this.ws && this.xt != null) {
                this.ws = true;
                if (hh.xt(this.xt) == 0 && this.jy != 0) {
                    if (this.vl == null) {
                        this.vl = new JSONObject();
                    }
                    this.vl.put("render_sequence", hh.xt(this.xt));
                    this.vl.put("render_control", hh.j(this.xt));
                    this.vl.put("fetch_tpl_time_out", v.xt().j(this.f29278j, hh.xt(this.xt)));
                    this.vl.put("req_id", this.xt.ej());
                    this.vl.put(MediationConstant.EXTRA_ADID, this.xt.fs());
                    this.vl.put("ad_slot_type", uf.tl(this.xt));
                    if (z5) {
                        this.vl.put("webview_time_cost", System.currentTimeMillis() - this.qv.get());
                        this.vl.put("webview_result", 2);
                    }
                    ws.j().j(this.vl);
                }
            }
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.r.r
    public void j(final int i6) {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.6
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    tl.this.j(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    tl.this.j(jSONObject, "isWebViewCache", Integer.valueOf(i6));
                    if (tl.this.xt != null) {
                        if (hh.tl(tl.this.xt)) {
                            tl.this.j(jSONObject, "engine_version", b.f33222u);
                        } else {
                            tl.this.j(jSONObject, "engine_version", "v1");
                        }
                    }
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.f29279m, "before_webview_request", jSONObject);
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    protected tl() {
        this.f29278j = "embeded_ad";
        Boolean bool = Boolean.FALSE;
        this.cw = bool;
        this.f29280r = bool;
        this.up = bool;
        this.f29277g = false;
        this.qv = new AtomicLong();
        this.jy = 0;
        this.ws = false;
    }

    @Override // com.bytedance.sdk.openadsdk.m.r.r
    public void j(final String str, final long j6, final long j7, final int i6) {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jy.tl.17
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str) || j7 < j6) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    tl.this.j(jSONObject, "start_ts", Long.valueOf(j6));
                    tl.this.j(jSONObject, "end_ts", Long.valueOf(j7));
                    tl.this.j(jSONObject, "intercept_type", Integer.valueOf(i6));
                    tl.this.j(jSONObject, "type", "intercept_html");
                    tl.this.j(jSONObject, "url", str);
                    tl.this.j(jSONObject, "duration", Long.valueOf(j7 - j6));
                    tl tlVar = tl.this;
                    tlVar.j(tlVar.tl, jSONObject);
                }
            });
        } catch (Throwable th) {
            vl.xt("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.j
    public void j(boolean z5) {
        this.up = Boolean.valueOf(z5);
    }

    @Override // com.bytedance.sdk.openadsdk.m.j
    public void j(boolean z5, int i6) {
        try {
            if (this.vl == null) {
                this.vl = new JSONObject();
            }
            this.vl.put("error_code", i6);
            this.vl.put("webview_time_cost", System.currentTimeMillis() - this.qv.get());
            this.vl.put("webview_result", !z5 ? 1 : 0);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.j
    public void j(int i6, int i7, String str) {
        try {
            this.jy = i6;
            if (this.vl == null) {
                this.vl = new JSONObject();
            }
            this.vl.put("render_type", i6);
            this.vl.put("error_code", i7);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public void xt(int i6) {
        this.oq = i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(JSONObject jSONObject, String str, Object obj, boolean z5) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!z5) {
            try {
                if (jSONObject.has(str)) {
                    return;
                }
            } catch (Exception e6) {
                vl.xt("WebviewTimeTrack", e6.getMessage());
                return;
            }
        }
        jSONObject.put(str, obj);
    }

    public void j(JSONObject jSONObject, String str, Object obj) {
        j(jSONObject, str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(JSONArray jSONArray, Object obj) {
        if (jSONArray == null || jSONArray.length() >= 10) {
            return;
        }
        try {
            jSONArray.put(obj);
        } catch (Exception e6) {
            vl.xt("WebviewTimeTrack", e6.getMessage());
        }
    }
}
