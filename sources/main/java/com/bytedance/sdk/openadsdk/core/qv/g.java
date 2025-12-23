package com.bytedance.sdk.openadsdk.core.qv;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.j;
import com.bytedance.sdk.openadsdk.core.rn.m;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.i;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.tj;
import com.bytedance.sdk.openadsdk.core.v;
import com.kuaishou.weapon.p0.bq;
import java.io.File;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g {
    public static boolean cw() {
        if (Build.VERSION.SDK_INT >= 23) {
            return com.bytedance.sdk.openadsdk.core.x.up.j().j(v.getContext(), com.kuaishou.weapon.p0.g.f36050j);
        }
        return true;
    }

    private static void xt(final n nVar, final String str) {
        final com.bytedance.sdk.openadsdk.core.rn.j r5;
        if (j(nVar) || (r5 = oq.i().r()) == null) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        r5.j(new j.InterfaceC0472j() { // from class: com.bytedance.sdk.openadsdk.core.qv.g.1
            @Override // com.bytedance.sdk.openadsdk.core.rn.j.InterfaceC0472j
            public void j() {
                if (!ed.j()) {
                    com.bytedance.sdk.openadsdk.core.rn.j jVar = com.bytedance.sdk.openadsdk.core.rn.j.this;
                    if (jVar != null) {
                        jVar.cw();
                        return;
                    }
                    return;
                }
                if (!com.bytedance.sdk.openadsdk.av.xt.j(str)) {
                    g.xt(nVar, currentTimeMillis, com.bytedance.sdk.openadsdk.core.rn.j.this, str);
                }
                com.bytedance.sdk.openadsdk.core.rn.j jVar2 = com.bytedance.sdk.openadsdk.core.rn.j.this;
                if (jVar2 != null) {
                    jVar2.cw();
                }
            }
        });
    }

    public static String r() {
        try {
            Function<SparseArray<Object>, Object> gx = oq.i().gx();
            if (gx != null) {
                gx.apply(com.bytedance.sdk.openadsdk.i.r.j().j(1).j(String.class).xt());
            }
        } catch (Exception unused) {
        }
        return bq.f35804e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cw(n nVar, String str) {
        if (nVar == null) {
            return;
        }
        uf.j(v.getContext(), str);
    }

    private static String m() {
        File j6 = com.bytedance.sdk.openadsdk.api.plugin.xt.j(v.getContext(), Environment.DIRECTORY_DOWNLOADS);
        if (j6 != null) {
            if (!j6.exists()) {
                j6.mkdirs();
            }
            if (j6.exists()) {
                return j6.getAbsolutePath();
            }
            return null;
        }
        return null;
    }

    public static void up() {
        if (oq.i().gx() != null) {
            oq.i().gx().apply(com.bytedance.sdk.openadsdk.i.r.j().j(20).j(Void.class).xt());
        } else {
            vl.r("TTDownload-Util", "下载SDK 初始化失败 ， bridge = null ！！！");
        }
    }

    public static void j(String str, n nVar) {
        boolean ae;
        try {
            if (v.getContext() != null && !TextUtils.isEmpty(str) && (ae = tj.ae(nVar))) {
                i m111if = nVar.m111if();
                if (m111if != null && !TextUtils.isEmpty(m111if.xt())) {
                    vl.r("TTDownload-Util", "含有deepLink");
                    if (tj.r(nVar) != 0) {
                        vl.r("TTDownload-Util", "deepLink过滤 DownConfig.getDownConfigAutoOpen(materialMeta) " + tj.r(nVar));
                        return;
                    }
                }
                if (ae) {
                    if (com.bytedance.sdk.openadsdk.av.xt.j(str)) {
                        vl.r("TTDownload-Util", "该app已被激活 pkgName ".concat(String.valueOf(str)));
                    } else if (!tj.tl(nVar)) {
                        xt(nVar, str);
                    } else {
                        j(v.getContext(), nVar, str);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static JSONObject xt() {
        com.bytedance.sdk.openadsdk.core.p.oq xt = v.xt();
        if (xt != null && xt.sm() != null) {
            return xt.sm();
        }
        return new JSONObject();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(final com.bytedance.sdk.openadsdk.core.rn.j jVar, final n nVar, String str, String str2, final String str3) {
        if (jVar != null && uf.cw(v.getContext(), str3)) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            String fs = nVar.fs();
            com.bytedance.sdk.openadsdk.core.rn.m.j(v.getContext(), fs, str, str2, "立即打开", "退出", new m.j() { // from class: com.bytedance.sdk.openadsdk.core.qv.g.3
                @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
                public void onDialogBtnNo() {
                    com.bytedance.sdk.openadsdk.core.rn.j jVar2 = jVar;
                    if (jVar2 != null) {
                        jVar2.cw();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
                public void onDialogBtnYes() {
                    g.cw(n.this, str3);
                    com.bytedance.sdk.openadsdk.core.rn.j jVar2 = jVar;
                    if (jVar2 != null) {
                        jVar2.cw();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
                public void onDialogCancel() {
                    com.bytedance.sdk.openadsdk.core.rn.j jVar2 = jVar;
                    if (jVar2 != null) {
                        jVar2.cw();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(n nVar, long j6, com.bytedance.sdk.openadsdk.core.rn.j jVar, String str) {
        String str2;
        String str3;
        if (nVar == null) {
            return;
        }
        if (System.currentTimeMillis() - j6 >= tj.g(nVar) * 1000) {
            if (nVar.by() != null) {
                str2 = nVar.by().cw();
            } else {
                str2 = "";
            }
            if (TextUtils.isEmpty(str2)) {
                str3 = "应用安装完成，是否立即打开 ？";
            } else {
                str3 = "安装完成，是否立即打开 ？";
            }
            xt(jVar, nVar, str2, str3, str);
            return;
        }
        cw(nVar, str);
    }

    public static String j() {
        String r5 = com.bytedance.sdk.openadsdk.av.xt.r();
        com.bytedance.sdk.openadsdk.i.cw.cw.r w5 = oq.i().w();
        if (w5 == null || w5.up()) {
            return r5;
        }
        try {
            return m();
        } catch (Throwable unused) {
            return r5;
        }
    }

    private static void j(Context context, final n nVar, final String str) {
        String str2;
        String str3;
        if (context == null || nVar == null || j(nVar)) {
            return;
        }
        if (nVar.by() != null) {
            str2 = nVar.by().cw();
        } else {
            str2 = "";
        }
        final String str4 = str2;
        if (TextUtils.isEmpty(str4)) {
            str3 = "应用安装完成，是否立即打开 ？";
        } else {
            str3 = "安装完成，是否立即打开 ？";
        }
        final String str5 = str3;
        final com.bytedance.sdk.openadsdk.core.rn.j r5 = oq.i().r();
        if (r5 == null) {
            return;
        }
        r5.j(new j.InterfaceC0472j() { // from class: com.bytedance.sdk.openadsdk.core.qv.g.2
            @Override // com.bytedance.sdk.openadsdk.core.rn.j.InterfaceC0472j
            public void j() {
                try {
                    if (!ed.j()) {
                        com.bytedance.sdk.openadsdk.core.rn.j jVar = com.bytedance.sdk.openadsdk.core.rn.j.this;
                        if (jVar != null) {
                            jVar.cw();
                            return;
                        }
                        return;
                    }
                    if (!com.bytedance.sdk.openadsdk.av.xt.j(str)) {
                        g.xt(com.bytedance.sdk.openadsdk.core.rn.j.this, nVar, str4, str5, str);
                    }
                    com.bytedance.sdk.openadsdk.core.rn.j jVar2 = com.bytedance.sdk.openadsdk.core.rn.j.this;
                    if (jVar2 != null) {
                        jVar2.cw();
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    private static boolean j(n nVar) {
        if (nVar == null || !j(xt())) {
            return false;
        }
        int jl = nVar.jl();
        String vm = nVar.vm();
        com.bytedance.sdk.component.r.j.xt j6 = com.bytedance.sdk.openadsdk.core.xt.j();
        if ((TextUtils.isEmpty(vm) || jl != 4) && !j6.xt("is_landing_page_open_market", false)) {
            return false;
        }
        j6.j("is_landing_page_open_market", false);
        return true;
    }

    private static boolean j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return jSONObject.optInt("enable_open_app_dialog") == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0065 A[Catch: all -> 0x0069, TRY_LEAVE, TryCatch #0 {all -> 0x0069, blocks: (B:23:0x0003, B:25:0x0009, B:4:0x0021, B:6:0x0027, B:8:0x0033, B:10:0x003f, B:11:0x0043, B:13:0x0049, B:14:0x005f, B:16:0x0065), top: B:22:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0027 A[Catch: all -> 0x0069, TryCatch #0 {all -> 0x0069, blocks: (B:23:0x0003, B:25:0x0009, B:4:0x0021, B:6:0x0027, B:8:0x0033, B:10:0x003f, B:11:0x0043, B:13:0x0049, B:14:0x005f, B:16:0x0065), top: B:22:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String j(boolean r3) {
        /*
            r0 = 0
            if (r3 == 0) goto L20
            boolean r3 = cw()     // Catch: java.lang.Throwable -> L69
            if (r3 != 0) goto L20
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L69
            android.content.Context r1 = com.bytedance.sdk.openadsdk.core.v.getContext()     // Catch: java.lang.Throwable -> L69
            java.io.File r1 = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(r1)     // Catch: java.lang.Throwable -> L69
            java.lang.String r2 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch: java.lang.Throwable -> L69
            r3.<init>(r1, r2)     // Catch: java.lang.Throwable -> L69
            r3.mkdirs()     // Catch: java.lang.Throwable -> L69
            java.lang.String r3 = r3.getPath()     // Catch: java.lang.Throwable -> L69
            goto L21
        L20:
            r3 = r0
        L21:
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L5f
            java.lang.String r1 = com.bytedance.sdk.openadsdk.l.cw.j()     // Catch: java.lang.Throwable -> L69
            java.lang.String r2 = "mounted"
            boolean r1 = r2.equals(r1)     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L43
            android.content.Context r1 = com.bytedance.sdk.openadsdk.core.v.getContext()     // Catch: java.lang.Throwable -> L69
            java.lang.String r2 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch: java.lang.Throwable -> L69
            java.io.File r1 = com.bytedance.sdk.openadsdk.api.plugin.xt.j(r1, r2)     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L43
            java.lang.String r3 = r1.getPath()     // Catch: java.lang.Throwable -> L69
        L43:
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L5f
            android.content.Context r3 = com.bytedance.sdk.openadsdk.core.v.getContext()     // Catch: java.lang.Throwable -> L69
            java.io.File r3 = com.bytedance.sdk.openadsdk.api.plugin.xt.j(r3)     // Catch: java.lang.Throwable -> L69
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L69
            java.lang.String r2 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch: java.lang.Throwable -> L69
            r1.<init>(r3, r2)     // Catch: java.lang.Throwable -> L69
            r1.mkdirs()     // Catch: java.lang.Throwable -> L69
            java.lang.String r3 = r1.getPath()     // Catch: java.lang.Throwable -> L69
        L5f:
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L69
            if (r1 != 0) goto L69
            com.bytedance.sdk.openadsdk.core.rn.qv.j()     // Catch: java.lang.Throwable -> L69
            return r3
        L69:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.qv.g.j(boolean):java.lang.String");
    }

    public static void j(Runnable runnable, n nVar) {
        if (nVar == null || runnable == null) {
            return;
        }
        if (tj.i(nVar)) {
            com.bytedance.sdk.openadsdk.l.ae.j((Runnable) new com.bytedance.sdk.component.oq.g("tt_download_toast") { // from class: com.bytedance.sdk.openadsdk.core.qv.g.4
                @Override // java.lang.Runnable
                public void run() {
                    a.j(v.getContext(), "即将跳转到应用商店...", 1);
                }
            });
            com.bytedance.sdk.openadsdk.core.tj.m().postDelayed(runnable, 500L);
        } else {
            com.bytedance.sdk.openadsdk.l.ae.j(runnable);
        }
    }
}
