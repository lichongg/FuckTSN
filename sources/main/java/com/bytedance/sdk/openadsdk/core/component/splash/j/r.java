package com.bytedance.sdk.openadsdk.core.component.splash.j;

import android.text.TextUtils;
import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.openadsdk.core.a;
import com.bytedance.sdk.openadsdk.core.component.splash.m;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.rn.h;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.sm;
import com.bytedance.sdk.openadsdk.core.v;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends com.bytedance.sdk.openadsdk.core.component.splash.j.j {

    /* renamed from: m, reason: collision with root package name */
    private xt f28699m;
    private volatile com.bytedance.sdk.component.r.j.xt ae = null;
    private com.bytedance.sdk.component.r.j.xt tl = h.j("tt_materialMeta");

    private class xt extends g {
        private sm xt;

        public void j(sm smVar) {
            this.xt = smVar;
        }

        public xt(sm smVar) {
            super("WriteCacheTask");
            this.xt = smVar;
        }

        private void j() {
            try {
                int j6 = m.j(this.xt);
                if (j6 <= 0) {
                    return;
                }
                String xt = r.this.tl.xt("net_ad_already_shown", "");
                if (!TextUtils.isEmpty(xt) && xt.equals(this.xt.j().ej())) {
                    com.bytedance.sdk.openadsdk.core.ae.j.j("lqmt", "该缓存已show-则不再save： rit: " + j6 + "   reqId: " + this.xt.j().ej());
                    return;
                }
                JSONObject cw = this.xt.xt().cw();
                if (cw != null) {
                    r.this.tl.j("materialMeta".concat(String.valueOf(j6)), cw.toString());
                }
                r.this.tl.j("net_ad_save_success".concat(String.valueOf(j6)), this.xt.j().ej());
                com.bytedance.sdk.openadsdk.core.ae.j.j("lqmt", "缓存成功： rit: " + j6 + "   reqId: " + this.xt.j().ej());
            } catch (Throwable unused) {
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            j();
        }
    }

    private boolean cw(final String str) {
        final j xt2 = xt(str);
        if (xt2.f28701j) {
            ws.j().ae(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.j.r.1
                @Override // com.bytedance.sdk.openadsdk.vl.j.j
                public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                    j jVar = xt2;
                    long j6 = jVar.f28702r - jVar.xt;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("available_type", 0);
                    jSONObject.putOpt("creative_timeout_duration", Long.valueOf(j6 / 3600));
                    return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j(4).cw(str).xt(jSONObject.toString());
                }
            });
        }
        return xt2.f28701j;
    }

    private void r(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.r.j.xt up = up();
        this.tl.j("materialMeta" + str);
        if (up != null) {
            up.j("has_ad_cache" + str);
            up.j("expiration" + str);
        }
        com.bytedance.sdk.openadsdk.core.ae.j.j("lqmt", "清除成功： rit: " + str);
    }

    private com.bytedance.sdk.component.r.j.xt up() {
        if (this.ae == null) {
            this.ae = h.j("tt_splash");
        }
        return this.ae;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.j.j
    public void j(String str, String str2, boolean z5, boolean z6, Object obj) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.j.j
    public void xt() {
    }

    static class j {

        /* renamed from: j, reason: collision with root package name */
        boolean f28701j = true;
        long xt = 0;
        long cw = 0;

        /* renamed from: r, reason: collision with root package name */
        long f28702r = 0;

        j() {
        }
    }

    private j xt(String str) {
        j jVar = new j();
        if (TextUtils.isEmpty(str)) {
            return jVar;
        }
        com.bytedance.sdk.component.r.j.xt up = up();
        long xt2 = up.xt("expiration" + str, 0L);
        long xt3 = up.xt("update" + str, 0L);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        jVar.f28701j = currentTimeMillis < xt3 || currentTimeMillis >= xt2;
        jVar.xt = xt3;
        jVar.cw = xt2;
        jVar.f28702r = currentTimeMillis;
        return jVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.j.j
    public void j(sm smVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, boolean z5) {
        int j6;
        if (smVar != null && (j6 = m.j(smVar)) > 0) {
            j(j6, smVar.j().xj());
            j(smVar);
        }
    }

    private com.bytedance.sdk.openadsdk.core.tj.j up(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String xt2 = this.tl.xt("materialMeta" + str, (String) null);
        if (!TextUtils.isEmpty(xt2)) {
            try {
                a.j j6 = a.j.j(new JSONObject(xt2));
                if (j6 != null) {
                    com.bytedance.sdk.openadsdk.core.tj.j jVar = j6.tl;
                    if (jVar != null) {
                        return jVar;
                    }
                }
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.j.j
    public void cw() {
        try {
            h.j("tt_materialMeta").j();
            h.j("tt_splash").j();
        } catch (Throwable unused) {
        }
    }

    private void j(sm smVar) {
        xt xtVar = this.f28699m;
        if (xtVar == null) {
            this.f28699m = new xt(smVar);
        } else {
            xtVar.j(smVar);
        }
        ae.j(this.f28699m, 10);
    }

    public static void r() {
        v.xt().dj();
    }

    private void j(int i6, long j6) {
        com.bytedance.sdk.component.r.j.xt up = up();
        up.j("expiration" + i6, j6);
        up.j("update" + i6, System.currentTimeMillis() / 1000);
        up.j("has_ad_cache" + i6, true);
    }

    private boolean j(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae aeVar, String str) {
        if (j(str)) {
            return true;
        }
        if (aeVar != null) {
            aeVar.r(0);
            aeVar.xt(1);
            aeVar.j("no cache");
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003f A[Catch: all -> 0x004d, TryCatch #1 {all -> 0x004d, blocks: (B:28:0x0020, B:30:0x0026, B:32:0x0030, B:15:0x003f, B:16:0x0042, B:24:0x004f), top: B:27:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004f A[Catch: all -> 0x004d, TRY_LEAVE, TryCatch #1 {all -> 0x004d, blocks: (B:28:0x0020, B:30:0x0026, B:32:0x0030, B:15:0x003f, B:16:0x0042, B:24:0x004f), top: B:27:0x0020 }] */
    @Override // com.bytedance.sdk.openadsdk.core.component.splash.j.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae r4, java.lang.String r5, com.bytedance.sdk.openadsdk.core.component.splash.j.j.InterfaceC0450j r6) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L62
            if (r6 != 0) goto L9
            goto L62
        L9:
            boolean r4 = r3.j(r4, r5)
            if (r4 != 0) goto L13
            r6.j()
            return
        L13:
            r4 = 0
            com.bytedance.sdk.openadsdk.core.tj.j r0 = r3.up(r5)     // Catch: java.lang.Throwable -> L52
            com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m r1 = new com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m     // Catch: java.lang.Throwable -> L52
            r2 = 1
            r1.<init>(r0, r2)     // Catch: java.lang.Throwable -> L52
            if (r0 == 0) goto L3c
            java.util.List r2 = r0.xt()     // Catch: java.lang.Throwable -> L4d
            if (r2 == 0) goto L3c
            java.util.List r2 = r0.xt()     // Catch: java.lang.Throwable -> L4d
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L4d
            if (r2 != 0) goto L3c
            java.util.List r0 = r0.xt()     // Catch: java.lang.Throwable -> L4d
            r2 = 0
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> L4d
            com.bytedance.sdk.openadsdk.core.tj.n r0 = (com.bytedance.sdk.openadsdk.core.tj.n) r0     // Catch: java.lang.Throwable -> L4d
            goto L3d
        L3c:
            r0 = r4
        L3d:
            if (r0 == 0) goto L42
            r1.j(r0)     // Catch: java.lang.Throwable -> L4d
        L42:
            com.bytedance.sdk.openadsdk.core.live.xt r2 = com.bytedance.sdk.openadsdk.core.live.xt.j()     // Catch: java.lang.Throwable -> L4d
            int r0 = r2.cw(r0)     // Catch: java.lang.Throwable -> L4d
            r2 = 3
            if (r0 == r2) goto L4f
        L4d:
            r4 = r1
            goto L52
        L4f:
            r1.j(r4)     // Catch: java.lang.Throwable -> L4d
        L52:
            r6.j(r4)
            com.bytedance.sdk.openadsdk.core.cw.up r4 = com.bytedance.sdk.openadsdk.core.cw.up.j()
            boolean r4 = r4.oq()
            if (r4 != 0) goto L62
            r3.r(r5)
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.splash.j.r.j(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae, java.lang.String, com.bytedance.sdk.openadsdk.core.component.splash.j.j$j):void");
    }

    public boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.bytedance.sdk.component.r.j.xt up = up();
        StringBuilder sb = new StringBuilder("has_ad_cache");
        sb.append(str);
        return up.xt(sb.toString(), false) && !cw(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.j.j
    public void j(com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.r<com.bytedance.sdk.openadsdk.core.component.splash.cw.j.g, com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae> rVar, n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, boolean z5) {
        if (nVar == null) {
            return;
        }
        if (z5) {
            this.tl.j("net_ad_already_shown", nVar.ej());
        }
        if (this.up.get()) {
            return;
        }
        String xt2 = this.tl.xt("net_ad_save_success" + uf.g(nVar), "");
        if (TextUtils.isEmpty(xt2) || !xt2.equals(nVar.ej())) {
            return;
        }
        this.up.set(true);
        com.bytedance.sdk.openadsdk.core.ae.j.j("lqmt", "计划清除缓存 reqId:  " + xt2);
        r(xtVar != null ? xtVar.r() : null);
        if (rVar != null) {
            rVar.j();
        }
    }
}
