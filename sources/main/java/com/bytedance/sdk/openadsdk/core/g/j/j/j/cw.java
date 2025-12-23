package com.bytedance.sdk.openadsdk.core.g.j.j.j;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.xt;
import com.bytedance.sdk.openadsdk.core.ed;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.c;
import com.bytedance.sdk.openadsdk.core.rn.j;
import com.bytedance.sdk.openadsdk.core.rn.la;
import com.bytedance.sdk.openadsdk.core.rn.m;
import com.bytedance.sdk.openadsdk.core.tj.hl;
import com.bytedance.sdk.openadsdk.core.tj.i;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.uf;
import com.bytedance.sdk.openadsdk.core.tj.v;
import com.tencent.open.SocialConstants;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements com.bytedance.sdk.openadsdk.core.g.j.j.j {
    private String cw;

    /* renamed from: g, reason: collision with root package name */
    private boolean f28965g;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.g.j.j.j f28966j;
    private com.bytedance.sdk.openadsdk.core.video.xt.xt jy;
    private boolean oq;
    private com.bytedance.sdk.openadsdk.core.qv.xt.cw qv;

    /* renamed from: r, reason: collision with root package name */
    private Context f28968r;
    private i up;
    private String vl;
    private n xt;

    /* renamed from: m, reason: collision with root package name */
    private boolean f28967m = false;
    private boolean ae = false;
    private Function<SparseArray<Object>, Object> tl = oq.i().gx();

    public void cw(boolean z5) {
        this.f28965g = z5;
    }

    public void xt(boolean z5) {
        this.ae = z5;
    }

    public cw(com.bytedance.sdk.openadsdk.core.g.j.j.j jVar, n nVar, String str, i iVar, Context context) {
        this.f28966j = jVar;
        this.xt = nVar;
        this.cw = str;
        this.f28968r = context;
        this.up = iVar;
    }

    private String cw(String str) {
        n nVar;
        uf yv;
        if (!TextUtils.isEmpty(str) && (nVar = this.xt) != null && hl.j(nVar) && (yv = this.xt.yv()) != null) {
            try {
                String cw = yv.cw();
                String r5 = yv.r();
                Map<String, String> j6 = c.j(str);
                j6.put("live_short_touch_params", cw);
                j6.put("extra_pangle_scheme_params", r5);
                String j7 = c.j(str, j6);
                com.bytedance.sdk.openadsdk.core.xt.j().j("is_reward_deep_link_to_live", true);
                return j7;
            } catch (Exception unused) {
            }
        }
        return str;
    }

    private boolean xt() {
        String cw = v.cw(this.xt, this.vl);
        n nVar = this.xt;
        Context context = this.f28968r;
        String str = this.cw;
        com.bytedance.sdk.openadsdk.core.g.j.j.xt.j jVar = new com.bytedance.sdk.openadsdk.core.g.j.j.xt.j(nVar, context, str, com.bytedance.sdk.openadsdk.core.rn.uf.xt(str));
        jVar.cw(true);
        jVar.j(cw);
        jVar.j(this.jy);
        return jVar.j((Map<String, Object>) new HashMap());
    }

    public void j(com.bytedance.sdk.openadsdk.core.video.xt.xt xtVar) {
        this.jy = xtVar;
    }

    public void j(boolean z5) {
        this.f28967m = z5;
    }

    public void j(com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar) {
        this.qv = cwVar;
    }

    public void j(String str) {
        this.vl = str;
    }

    private i j() {
        i iVar = this.up;
        return iVar == null ? new i() : iVar;
    }

    protected String xt(String str) {
        Uri parse;
        return (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || TextUtils.isEmpty(parse.getScheme())) ? "" : parse.getScheme().toLowerCase(Locale.US);
    }

    public Boolean j(Map<String, Object> map, String str, JSONObject jSONObject) {
        String cw = cw(str);
        if (TextUtils.isEmpty(cw)) {
            return null;
        }
        i.j((String) null);
        Uri parse = Uri.parse(cw);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        if (this.f28967m) {
            com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.xt, this.cw, "lp_open_dpl", xt(cw));
        }
        boolean xt = com.bytedance.sdk.openadsdk.core.rn.uf.xt(this.f28968r);
        try {
            jSONObject.putOpt("is_lp", Boolean.valueOf(this.f28967m));
            jSONObject.putOpt("can_qry_pkg", Boolean.valueOf(xt));
        } catch (Exception unused) {
        }
        if (xt) {
            boolean j6 = com.bytedance.sdk.openadsdk.core.rn.uf.j(this.f28968r, intent);
            try {
                jSONObject.putOpt("installed", Boolean.valueOf(j6));
            } catch (Exception unused2) {
            }
            if (j6) {
                return j(map, intent, true, jSONObject);
            }
            j(map, true, (Throwable) null);
            j(1);
            return null;
        }
        try {
            jSONObject.putOpt("installed_douyin", Boolean.valueOf(com.bytedance.sdk.openadsdk.core.live.up.j.j(cw)));
            String x5 = com.bytedance.sdk.openadsdk.core.rn.uf.x(this.xt);
            if (x5 != null && x5.length() > 0) {
                jSONObject.putOpt("installed_other", Boolean.valueOf(com.bytedance.sdk.openadsdk.core.rn.uf.j(x5)));
            }
            jSONObject.putOpt("pkg", x5);
        } catch (Throwable unused3) {
        }
        return j(map, intent, false, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(final Intent intent) {
        String str;
        String concat;
        n nVar = this.xt;
        if (nVar == null || this.f28968r == null || intent == null) {
            return;
        }
        if (nVar.by() != null) {
            str = this.xt.by().cw();
        } else {
            str = "";
        }
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            concat = "是否立即打开应用";
        } else {
            concat = "是否立即打开".concat(String.valueOf(str2));
        }
        String str3 = concat;
        com.bytedance.sdk.openadsdk.core.rn.m.j(this.f28968r, this.xt.fs(), str2, str3, "立即打开", "退出", new m.j() { // from class: com.bytedance.sdk.openadsdk.core.g.j.j.j.cw.3
            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnYes() {
                HashMap hashMap = new HashMap();
                hashMap.put(SocialConstants.PARAM_SOURCE, "DeepLinkConverter");
                com.bytedance.sdk.openadsdk.core.jy.cw.tl(cw.this.xt, cw.this.cw, "open_url_app", hashMap);
                com.bytedance.sdk.component.utils.xt.j(cw.this.f28968r, intent, new xt.j() { // from class: com.bytedance.sdk.openadsdk.core.g.j.j.j.cw.3.1
                    @Override // com.bytedance.sdk.component.utils.xt.j
                    public void j() {
                        com.bytedance.sdk.openadsdk.core.jy.m.j().j(cw.this.xt, cw.this.cw, false);
                        com.bytedance.sdk.openadsdk.core.jy.cw.j(cw.this.xt, cw.this.cw, "deeplink_success_realtime", (Throwable) null);
                    }

                    @Override // com.bytedance.sdk.component.utils.xt.j
                    public void j(Throwable th) {
                        com.bytedance.sdk.openadsdk.core.jy.cw.j(cw.this.xt, cw.this.cw, "deeplink_fail_realtime", th);
                    }
                }, TextUtils.equals("main", UMModuleRegister.INNER));
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogCancel() {
            }
        });
    }

    private Boolean j(JSONObject jSONObject) {
        Boolean valueOf;
        try {
            jSONObject.putOpt(CommonNetImpl.TAG, this.vl);
        } catch (JSONException unused) {
        }
        if (TextUtils.isEmpty(this.vl) || !v.j(this.xt, this.vl)) {
            return null;
        }
        int xt = v.xt(this.xt, this.vl);
        if (xt != 1) {
            valueOf = j(new HashMap(), v.cw(this.xt, this.vl), jSONObject);
        } else {
            valueOf = Boolean.valueOf(xt());
        }
        try {
            jSONObject.putOpt("convert_type", Integer.valueOf(xt));
            jSONObject.putOpt("dpl_result", valueOf);
        } catch (JSONException unused2) {
        }
        return valueOf;
    }

    private Boolean j(final Map<String, Object> map, Intent intent, final boolean z5, JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.rn.uf.xt(intent);
        j(intent);
        HashMap hashMap = new HashMap();
        hashMap.put(SocialConstants.PARAM_SOURCE, "DeepLinkConverter");
        if (this.ae) {
            boolean j6 = j(this.cw, "open_fallback_url", this.xt, map);
            if (!j6) {
                com.bytedance.sdk.openadsdk.core.jy.cw.tl(this.xt, this.cw, "open_url_app", hashMap);
            }
            try {
                jSONObject.putOpt("intercept", Boolean.valueOf(j6));
            } catch (JSONException unused) {
            }
        } else {
            com.bytedance.sdk.openadsdk.core.jy.cw.tl(this.xt, this.cw, "open_url_app", hashMap);
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.bytedance.sdk.component.utils.xt.j(this.f28968r, intent, new xt.j() { // from class: com.bytedance.sdk.openadsdk.core.g.j.j.j.cw.1
            @Override // com.bytedance.sdk.component.utils.xt.j
            public void j() {
                atomicBoolean.set(true);
                if (cw.this.f28967m) {
                    com.bytedance.sdk.openadsdk.core.jy.cw.j(cw.this.xt, cw.this.cw, "lp_openurl", (Throwable) null);
                    com.bytedance.sdk.openadsdk.core.jy.cw.j(cw.this.xt, cw.this.cw, "lp_deeplink_success_realtime", (Throwable) null);
                } else {
                    com.bytedance.sdk.openadsdk.core.jy.cw.j(cw.this.xt, cw.this.cw, "deeplink_success_realtime", (Throwable) null);
                }
                com.bytedance.sdk.openadsdk.core.jy.m.j().j(cw.this.xt, cw.this.cw, cw.this.f28967m);
                cw.this.j(0);
            }

            @Override // com.bytedance.sdk.component.utils.xt.j
            public void j(Throwable th) {
                atomicBoolean.set(false);
                cw.this.j((Map<String, Object>) map, z5, th);
                cw.this.j(3);
            }
        }, TextUtils.equals("main", UMModuleRegister.INNER));
        return Boolean.valueOf(atomicBoolean.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i6) {
        n nVar = this.xt;
        if (nVar == null || nVar.li() != 1) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jy.cw.j(this.xt, this.cw, 1, 1, i6, h.m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j(java.util.Map<java.lang.String, java.lang.Object> r4, boolean r5, java.lang.Throwable r6) {
        /*
            r3 = this;
            boolean r0 = r3.ae
            if (r0 == 0) goto Lf
            if (r5 != 0) goto Lf
            com.bytedance.sdk.openadsdk.core.tj.n r5 = r3.xt
            java.lang.String r0 = r3.cw
            java.lang.String r1 = "open_fallback_download"
            com.bytedance.sdk.openadsdk.core.jy.cw.cw(r5, r0, r1)
        Lf:
            boolean r5 = r3.ae
            java.lang.String r0 = "open_fallback_url"
            if (r5 == 0) goto L2f
            com.bytedance.sdk.openadsdk.core.tj.n r5 = r3.xt
            java.lang.String r1 = r3.cw
            java.lang.String r2 = "lp_openurl_failed"
            com.bytedance.sdk.openadsdk.core.jy.cw.cw(r5, r1, r2)
            boolean r5 = r3.oq
            if (r5 != 0) goto L37
            java.lang.String r5 = r3.cw
            com.bytedance.sdk.openadsdk.core.tj.n r1 = r3.xt
            boolean r4 = r3.j(r5, r0, r1, r4)
            if (r4 != 0) goto L37
            r4 = 1
            r3.oq = r4
        L2f:
            com.bytedance.sdk.openadsdk.core.tj.n r4 = r3.xt
            java.lang.String r5 = r3.cw
            r1 = 0
            com.bytedance.sdk.openadsdk.core.jy.cw.tl(r4, r5, r0, r1)
        L37:
            boolean r4 = r3.f28965g
            if (r4 == 0) goto L3c
            return
        L3c:
            boolean r4 = r3.ae
            if (r4 == 0) goto L47
            boolean r4 = r3.f28967m
            if (r4 == 0) goto L47
            java.lang.String r4 = "lp_deeplink_fail_realtime"
            goto L49
        L47:
            java.lang.String r4 = "deeplink_fail_realtime"
        L49:
            com.bytedance.sdk.openadsdk.core.tj.n r5 = r3.xt
            java.lang.String r0 = r3.cw
            com.bytedance.sdk.openadsdk.core.jy.cw.j(r5, r0, r4, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.g.j.j.j.cw.j(java.util.Map, boolean, java.lang.Throwable):void");
    }

    private boolean j(String str, String str2, n nVar, Map<String, Object> map) {
        Object apply;
        if (this.tl == null) {
            return false;
        }
        apply = this.tl.apply(com.bytedance.sdk.openadsdk.i.r.j().j(2).j(Boolean.class).j(0, new la().j("tagIntercept", str).j("label", str2).j("hashCode", Integer.valueOf(j.cw(map))).j("meta", nVar.tv().toString())).xt());
        return apply != null && ((Boolean) apply).booleanValue();
    }

    public void j(final Intent intent) {
        final com.bytedance.sdk.openadsdk.core.rn.j r5;
        final long currentTimeMillis = System.currentTimeMillis();
        n nVar = this.xt;
        if (nVar == null || intent == null || this.f28968r == null) {
            return;
        }
        i m111if = nVar.m111if();
        if (m111if != null && m111if.cw() == 2 && !m111if.j() && com.bytedance.sdk.openadsdk.core.xt.j().xt("dpl_reject_by_dialog", false)) {
            ed.j(this.xt, this.cw);
        } else if (this.xt.sh() && (r5 = oq.i().r()) != null) {
            r5.j(new j.InterfaceC0472j() { // from class: com.bytedance.sdk.openadsdk.core.g.j.j.j.cw.2
                @Override // com.bytedance.sdk.openadsdk.core.rn.j.InterfaceC0472j
                public void j() {
                    if (System.currentTimeMillis() - currentTimeMillis <= 3000) {
                        cw.this.xt(intent);
                    }
                    com.bytedance.sdk.openadsdk.core.rn.j jVar = r5;
                    if (jVar != null) {
                        jVar.cw();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.j.j.j
    public boolean j(Map<String, Object> map) {
        Object valueOf;
        JSONObject jSONObject = new JSONObject();
        try {
            Boolean j6 = j(jSONObject);
            try {
                if (j6 != null && j6.booleanValue()) {
                    try {
                        jSONObject.putOpt("dpa_sub", Boolean.TRUE);
                    } catch (Exception unused) {
                    }
                    jSONObject.putOpt("uchain", Boolean.TRUE);
                    jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.xt.ww()));
                    jSONObject.putOpt("req_id", this.xt.ej());
                    valueOf = Boolean.valueOf(this.xt.j());
                } else {
                    i j7 = j();
                    if (j7 == null) {
                        j7 = this.xt.m111if();
                    }
                    if (j7 != null && !TextUtils.isEmpty(j7.xt())) {
                        String xt = j7.xt();
                        Boolean j8 = j(map, xt, jSONObject);
                        try {
                            jSONObject.putOpt("dpl_result", j8);
                            jSONObject.putOpt("url", xt);
                        } catch (Exception unused2) {
                        }
                        if (j7.up() == 2 && this.qv != null && !this.ae && (j8 == null || !j8.booleanValue())) {
                            this.qv.r(false);
                            this.qv.j(this.xt, com.bytedance.sdk.openadsdk.core.g.j.r.j.j(map));
                            jSONObject.putOpt("uchain", Boolean.TRUE);
                            jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.xt.ww()));
                            jSONObject.putOpt("req_id", this.xt.ej());
                            valueOf = Boolean.valueOf(this.xt.j());
                        } else {
                            if (j8 != null && !this.ae) {
                                return j8.booleanValue();
                            }
                            if (this.ae && (j8 == null || !j8.booleanValue())) {
                                try {
                                    jSONObject.putOpt("uchain", Boolean.TRUE);
                                    jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.xt.ww()));
                                    jSONObject.putOpt("req_id", this.xt.ej());
                                    jSONObject.putOpt("web_meta", Boolean.valueOf(this.xt.j()));
                                } catch (Exception unused3) {
                                }
                                ws.j().j("open_detail_page", AMPSConstants.AdType.AD_TYPE_NATIVE, 0, jSONObject);
                                com.bytedance.sdk.openadsdk.core.g.j.j.j jVar = this.f28966j;
                                return jVar != null && jVar.j(map);
                            }
                            try {
                                jSONObject.putOpt("uchain", Boolean.TRUE);
                                jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.xt.ww()));
                                jSONObject.putOpt("req_id", this.xt.ej());
                                jSONObject.putOpt("web_meta", Boolean.valueOf(this.xt.j()));
                            } catch (Exception unused4) {
                            }
                            ws.j().j("open_detail_page", AMPSConstants.AdType.AD_TYPE_NATIVE, 0, jSONObject);
                            return false;
                        }
                    }
                    try {
                        jSONObject.putOpt("dpl_null", Boolean.TRUE);
                    } catch (Exception unused5) {
                    }
                    com.bytedance.sdk.openadsdk.core.g.j.j.j jVar2 = this.f28966j;
                    r9 = jVar2 != null && jVar2.j(map);
                    jSONObject.putOpt("uchain", Boolean.TRUE);
                    jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.xt.ww()));
                    jSONObject.putOpt("req_id", this.xt.ej());
                    valueOf = Boolean.valueOf(this.xt.j());
                }
                jSONObject.putOpt("web_meta", valueOf);
            } catch (Exception unused6) {
            }
            ws.j().j("open_detail_page", AMPSConstants.AdType.AD_TYPE_NATIVE, 0, jSONObject);
            return r9;
        } finally {
            try {
                jSONObject.putOpt("uchain", Boolean.TRUE);
                jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.xt.ww()));
                jSONObject.putOpt("req_id", this.xt.ej());
                jSONObject.putOpt("web_meta", Boolean.valueOf(this.xt.j()));
            } catch (Exception unused7) {
            }
            ws.j().j("open_detail_page", AMPSConstants.AdType.AD_TYPE_NATIVE, 0, jSONObject);
        }
    }
}
