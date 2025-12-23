package com.bytedance.msdk.m.xt;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    private boolean ae;
    protected com.bytedance.msdk.core.m.xt cw;
    private boolean tl;

    /* renamed from: r, reason: collision with root package name */
    private static final com.bytedance.msdk.core.m.j f25186r = new com.bytedance.msdk.core.m.j();
    private static Map<String, Pair<Boolean, String>> up = new ConcurrentHashMap();

    /* renamed from: m, reason: collision with root package name */
    private static Map<String, com.bytedance.msdk.m.j.cw> f25185m = new ConcurrentHashMap();

    /* renamed from: j, reason: collision with root package name */
    protected final AtomicBoolean f25187j = new AtomicBoolean(false);
    protected final AtomicBoolean xt = new AtomicBoolean(false);

    public static synchronized void cw() {
        synchronized (j.class) {
            com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.m.xt.j.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.msdk.j.up.cw.xt("TTMediationSDK_SDK_Init", "------------------ GroMore 支持ADN初始化信息 start ---------------------");
                    for (Map.Entry entry : j.up.entrySet()) {
                        if (entry.getValue() != null) {
                            if (!((Boolean) ((Pair) entry.getValue()).first).booleanValue()) {
                                com.bytedance.msdk.j.up.cw.r("TTMediationSDK_SDK_Init", "adnName = " + ((String) entry.getKey()) + " 初始化失败 " + ((String) ((Pair) entry.getValue()).second));
                            } else if (com.bytedance.msdk.core.xt.xt().cw((String) entry.getKey())) {
                                com.bytedance.msdk.j.up.cw.r("TTMediationSDK_SDK_Init", "adnName = " + ((String) entry.getKey()) + " 自定义ADN调用初始化方法成功，请开发者确保接入的自定义ADN初始化结果");
                            } else {
                                com.bytedance.msdk.j.up.cw.xt("TTMediationSDK_SDK_Init", "adnName = " + ((String) entry.getKey()) + " 初始化成功");
                            }
                        }
                    }
                    com.bytedance.msdk.j.up.cw.xt("TTMediationSDK_SDK_Init", "------------------ GroMore 支持ADN初始化信息 end ---------------------");
                }
            });
        }
    }

    public static void j(String str, Pair<Boolean, String> pair) {
        up.put(str, pair);
    }

    public static j xt() {
        return new j();
    }

    public static int j() {
        return up.size();
    }

    public static void jy() {
        com.bytedance.msdk.m.j.cw cw = cw(MediationConstant.ADN_UNITY);
        if (cw != null) {
            cw.m();
        }
    }

    public static com.bytedance.msdk.core.m.j r() {
        return f25186r;
    }

    private void w() {
        com.bytedance.msdk.m.j.cw cw = cw(MediationConstant.ADN_GDT);
        if (cw != null) {
            cw.m();
        }
    }

    public static void ws() {
        com.bytedance.msdk.m.j.cw cw = cw("xiaomi");
        if (cw != null) {
            cw.m();
        }
    }

    public static Map<String, Object> xt(Map<String, Object> map, String str) {
        return f25186r.xt(com.bytedance.msdk.core.xt.getContext(), map, str);
    }

    protected void ae() {
        com.bytedance.msdk.m.j.cw cw = cw("baidu");
        if (cw != null) {
            cw.m();
        }
    }

    protected void av() {
        if (!this.ae && this.tl && this.f25187j.get() && this.xt.get()) {
            com.bytedance.msdk.m.j.j();
            cw();
        }
    }

    protected void az() {
        com.bytedance.msdk.j.up.m.j(new Runnable() { // from class: com.bytedance.msdk.m.xt.j.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.core.m.xt xtVar = j.this.cw;
                if (xtVar != null) {
                    xtVar.j();
                }
            }
        });
    }

    protected void g() {
        com.bytedance.msdk.m.j.cw cw = cw(MediationConstant.ADN_ADMOB);
        if (cw != null) {
            cw.m();
        }
    }

    protected void m() {
        com.bytedance.msdk.m.j.cw cw = cw(MediationConstant.ADN_MINTEGRAL);
        if (cw != null) {
            cw.m();
        }
    }

    protected void qv() {
        com.bytedance.msdk.m.j.cw cw = cw(MediationConstant.ADN_SIGMOB);
        if (cw != null) {
            cw.m();
        }
    }

    protected void tl() {
        com.bytedance.msdk.m.j.cw cw = cw(MediationConstant.ADN_PANGLE);
        if (cw != null) {
            cw.m();
        }
    }

    protected void up() {
        com.bytedance.msdk.m.j.cw cw = cw(MediationConstant.ADN_KLEVIN);
        if (cw != null) {
            cw.m();
        }
    }

    protected void vl() {
        com.bytedance.msdk.m.j.cw cw = cw(MediationConstant.ADN_KS);
        if (cw != null) {
            cw.m();
        }
    }

    protected j() {
    }

    public static String j(Map<String, Object> map, String str) {
        return f25186r.j(com.bytedance.msdk.core.xt.getContext(), map, str);
    }

    protected void cw(Context context) {
        xt(context);
        j(context);
    }

    protected void oq() {
        w();
    }

    protected void xt(final Context context) {
        oq();
        com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.m.xt.j.3
            @Override // java.lang.Runnable
            public void run() {
                j.this.vl();
                j.this.ae();
                j.this.tl();
                j.this.az();
                j.this.g();
                j.this.qv();
                j.jy();
                j.ws();
                com.bytedance.msdk.m.xt.j(context);
                j.this.xt.set(true);
                j.this.av();
            }
        });
    }

    public static com.bytedance.msdk.api.r.j.xt.m.j j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f25186r.j(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b2, code lost:
    
        if (r4.equals(com.bytedance.sdk.openadsdk.mediation.MediationConstant.ADN_PANGLE) != false) goto L51;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static synchronized com.bytedance.msdk.m.j.cw cw(java.lang.String r4) {
        /*
            java.lang.Class<com.bytedance.msdk.m.xt.j> r0 = com.bytedance.msdk.m.xt.j.class
            monitor-enter(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L37
            r2 = 0
            if (r1 == 0) goto Lc
            monitor-exit(r0)
            return r2
        Lc:
            java.util.Map<java.lang.String, com.bytedance.msdk.m.j.cw> r1 = com.bytedance.msdk.m.xt.j.f25185m     // Catch: java.lang.Throwable -> L37
            java.lang.Object r1 = r1.get(r4)     // Catch: java.lang.Throwable -> L37
            com.bytedance.msdk.m.j.cw r1 = (com.bytedance.msdk.m.j.cw) r1     // Catch: java.lang.Throwable -> L37
            if (r1 == 0) goto L18
            monitor-exit(r0)
            return r1
        L18:
            com.bytedance.msdk.core.ws.cw r3 = com.bytedance.msdk.core.xt.xt()     // Catch: java.lang.Throwable -> L37
            com.bytedance.msdk.core.oq.j r3 = r3.j(r4)     // Catch: java.lang.Throwable -> L37
            if (r3 != 0) goto L24
            monitor-exit(r0)
            return r2
        L24:
            int r2 = r4.hashCode()     // Catch: java.lang.Throwable -> L37
            switch(r2) {
                case -1128782217: goto Lb9;
                case -995541405: goto Lac;
                case -902468465: goto L9e;
                case -759499589: goto L90;
                case 3432: goto L82;
                case 102199: goto L74;
                case 92668925: goto L66;
                case 93498907: goto L58;
                case 111433589: goto L49;
                case 1126045977: goto L3a;
                case 1630528717: goto L2d;
                default: goto L2b;
            }     // Catch: java.lang.Throwable -> L37
        L2b:
            goto Lc6
        L2d:
            java.lang.String r2 = "pangle_custom"
            boolean r2 = r4.equals(r2)     // Catch: java.lang.Throwable -> L37
            if (r2 == 0) goto Lc6
            goto Lb4
        L37:
            r4 = move-exception
            goto Lcf
        L3a:
            java.lang.String r2 = "mintegral"
            boolean r2 = r4.equals(r2)     // Catch: java.lang.Throwable -> L37
            if (r2 == 0) goto Lc6
            com.bytedance.msdk.m.j.tl r1 = new com.bytedance.msdk.m.j.tl     // Catch: java.lang.Throwable -> L37
            r1.<init>()     // Catch: java.lang.Throwable -> L37
            goto Lc6
        L49:
            java.lang.String r2 = "unity"
            boolean r2 = r4.equals(r2)     // Catch: java.lang.Throwable -> L37
            if (r2 == 0) goto Lc6
            com.bytedance.msdk.m.j.jy r1 = new com.bytedance.msdk.m.j.jy     // Catch: java.lang.Throwable -> L37
            r1.<init>()     // Catch: java.lang.Throwable -> L37
            goto Lc6
        L58:
            java.lang.String r2 = "baidu"
            boolean r2 = r4.equals(r2)     // Catch: java.lang.Throwable -> L37
            if (r2 == 0) goto Lc6
            com.bytedance.msdk.m.j.xt r1 = new com.bytedance.msdk.m.j.xt     // Catch: java.lang.Throwable -> L37
            r1.<init>()     // Catch: java.lang.Throwable -> L37
            goto Lc6
        L66:
            java.lang.String r2 = "admob"
            boolean r2 = r4.equals(r2)     // Catch: java.lang.Throwable -> L37
            if (r2 == 0) goto Lc6
            com.bytedance.msdk.m.j.j r1 = new com.bytedance.msdk.m.j.j     // Catch: java.lang.Throwable -> L37
            r1.<init>()     // Catch: java.lang.Throwable -> L37
            goto Lc6
        L74:
            java.lang.String r2 = "gdt"
            boolean r2 = r4.equals(r2)     // Catch: java.lang.Throwable -> L37
            if (r2 == 0) goto Lc6
            com.bytedance.msdk.m.j.up r1 = new com.bytedance.msdk.m.j.up     // Catch: java.lang.Throwable -> L37
            r1.<init>()     // Catch: java.lang.Throwable -> L37
            goto Lc6
        L82:
            java.lang.String r2 = "ks"
            boolean r2 = r4.equals(r2)     // Catch: java.lang.Throwable -> L37
            if (r2 == 0) goto Lc6
            com.bytedance.msdk.m.j.ae r1 = new com.bytedance.msdk.m.j.ae     // Catch: java.lang.Throwable -> L37
            r1.<init>()     // Catch: java.lang.Throwable -> L37
            goto Lc6
        L90:
            java.lang.String r2 = "xiaomi"
            boolean r2 = r4.equals(r2)     // Catch: java.lang.Throwable -> L37
            if (r2 == 0) goto Lc6
            com.bytedance.msdk.m.j.ws r1 = new com.bytedance.msdk.m.j.ws     // Catch: java.lang.Throwable -> L37
            r1.<init>()     // Catch: java.lang.Throwable -> L37
            goto Lc6
        L9e:
            java.lang.String r2 = "sigmob"
            boolean r2 = r4.equals(r2)     // Catch: java.lang.Throwable -> L37
            if (r2 == 0) goto Lc6
            com.bytedance.msdk.m.j.vl r1 = new com.bytedance.msdk.m.j.vl     // Catch: java.lang.Throwable -> L37
            r1.<init>()     // Catch: java.lang.Throwable -> L37
            goto Lc6
        Lac:
            java.lang.String r2 = "pangle"
            boolean r2 = r4.equals(r2)     // Catch: java.lang.Throwable -> L37
            if (r2 == 0) goto Lc6
        Lb4:
            com.bytedance.msdk.m.j.oq r1 = com.bytedance.msdk.m.j.oq.g()     // Catch: java.lang.Throwable -> L37
            goto Lc6
        Lb9:
            java.lang.String r2 = "klevin"
            boolean r2 = r4.equals(r2)     // Catch: java.lang.Throwable -> L37
            if (r2 == 0) goto Lc6
            com.bytedance.msdk.m.j.m r1 = new com.bytedance.msdk.m.j.m     // Catch: java.lang.Throwable -> L37
            r1.<init>()     // Catch: java.lang.Throwable -> L37
        Lc6:
            if (r1 == 0) goto Lcd
            java.util.Map<java.lang.String, com.bytedance.msdk.m.j.cw> r2 = com.bytedance.msdk.m.xt.j.f25185m     // Catch: java.lang.Throwable -> L37
            r2.put(r4, r1)     // Catch: java.lang.Throwable -> L37
        Lcd:
            monitor-exit(r0)
            return r1
        Lcf:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L37
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.m.xt.j.cw(java.lang.String):com.bytedance.msdk.m.j.cw");
    }

    public static void xt(String str) {
        final com.bytedance.msdk.m.j.cw cw;
        if (TextUtils.equals(MediationConstant.ADN_PANGLE, str) || (cw = cw(str)) == null) {
            return;
        }
        if ((TextUtils.equals(MediationConstant.ADN_MINTEGRAL, str) || TextUtils.equals(MediationConstant.ADN_KLEVIN, str)) && !com.bytedance.msdk.j.up.m.up()) {
            if (cw.up()) {
                return;
            }
            com.bytedance.msdk.j.up.m.xt(new Runnable() { // from class: com.bytedance.msdk.m.xt.j.5
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.msdk.m.j.cw.this.tl();
                }
            });
            return;
        }
        cw.tl();
    }

    protected void j(Context context) {
        Runnable runnable = new Runnable() { // from class: com.bytedance.msdk.m.xt.j.2
            @Override // java.lang.Runnable
            public void run() {
                j.this.up();
                j.this.m();
                j.this.f25187j.set(true);
                j.this.av();
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            com.bytedance.msdk.j.up.m.cw(runnable);
        }
    }

    public void j(Context context, boolean z5, boolean z6, com.bytedance.msdk.core.m.xt xtVar) {
        this.cw = xtVar;
        this.f25187j.set(false);
        this.xt.set(false);
        this.ae = z5;
        this.tl = z6;
        cw(context);
    }
}
