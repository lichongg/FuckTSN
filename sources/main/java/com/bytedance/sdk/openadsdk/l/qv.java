package com.bytedance.sdk.openadsdk.l;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.vl;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class qv {

    /* renamed from: j, reason: collision with root package name */
    private static Map<String, Field> f31562j = new HashMap();

    public static void j(String str) {
        try {
            if (com.bytedance.sdk.openadsdk.core.h.xt < 5500) {
                tl(str);
                return;
            }
            Function<SparseArray<Object>, Object> m6 = com.bytedance.sdk.openadsdk.core.oq.i().m(4);
            if (m6 != null) {
                m6.apply(com.bytedance.sdk.openadsdk.i.r.j().j(100).j(Void.class).j(0, str).xt());
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    public static int cw(String str) {
        if (TextUtils.equals("com.byted.pangle", str)) {
            return 7012;
        }
        return j(str, 103);
    }

    public static int r(String str) {
        return TextUtils.equals("com.byted.pangle", str) ? com.bytedance.sdk.openadsdk.core.h.xt : j(str, 102);
    }

    private static void tl(String str) {
        try {
            Class.forName("com.bytedance.pangle.Zeus").getDeclaredMethod("unInstallPlugin", String.class).invoke(null, str);
        } catch (Throwable unused) {
        }
    }

    public static int xt(String str) {
        return TextUtils.equals("com.byted.pangle", str) ? com.bytedance.sdk.openadsdk.core.h.xt : j(str, 101);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
    
        r4 = r0.apply(com.bytedance.sdk.openadsdk.i.r.j().j(105).j(java.lang.Boolean.class).j(0, r4).xt());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean ae(java.lang.String r4) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            com.bytedance.sdk.openadsdk.core.oq r0 = com.bytedance.sdk.openadsdk.core.oq.i()     // Catch: java.lang.Throwable -> L38
            r2 = 4
            java.util.function.Function r0 = r0.m(r2)     // Catch: java.lang.Throwable -> L38
            if (r0 == 0) goto L43
            com.bytedance.sdk.openadsdk.i.r r2 = com.bytedance.sdk.openadsdk.i.r.j()     // Catch: java.lang.Throwable -> L38
            r3 = 105(0x69, float:1.47E-43)
            com.bytedance.sdk.openadsdk.i.r r2 = r2.j(r3)     // Catch: java.lang.Throwable -> L38
            java.lang.Class<java.lang.Boolean> r3 = java.lang.Boolean.class
            com.bytedance.sdk.openadsdk.i.r r2 = r2.j(r3)     // Catch: java.lang.Throwable -> L38
            com.bytedance.sdk.openadsdk.i.r r4 = r2.j(r1, r4)     // Catch: java.lang.Throwable -> L38
            android.util.SparseArray r4 = r4.xt()     // Catch: java.lang.Throwable -> L38
            java.lang.Object r4 = com.bytedance.msdk.core.ae.a.a(r0, r4)     // Catch: java.lang.Throwable -> L38
            if (r4 == 0) goto L43
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch: java.lang.Throwable -> L38
            boolean r4 = r4.booleanValue()     // Catch: java.lang.Throwable -> L38
            return r4
        L38:
            r4 = move-exception
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r4
            java.lang.String r4 = "ZeusUtil"
            com.bytedance.sdk.component.utils.vl.xt(r4, r0)
        L43:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.l.qv.ae(java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
    
        r4 = r0.apply(com.bytedance.sdk.openadsdk.i.r.j().j(104).j(java.lang.Boolean.class).j(0, r4).xt());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m(java.lang.String r4) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            com.bytedance.sdk.openadsdk.core.oq r0 = com.bytedance.sdk.openadsdk.core.oq.i()     // Catch: java.lang.Throwable -> L38
            r2 = 4
            java.util.function.Function r0 = r0.m(r2)     // Catch: java.lang.Throwable -> L38
            if (r0 == 0) goto L43
            com.bytedance.sdk.openadsdk.i.r r2 = com.bytedance.sdk.openadsdk.i.r.j()     // Catch: java.lang.Throwable -> L38
            r3 = 104(0x68, float:1.46E-43)
            com.bytedance.sdk.openadsdk.i.r r2 = r2.j(r3)     // Catch: java.lang.Throwable -> L38
            java.lang.Class<java.lang.Boolean> r3 = java.lang.Boolean.class
            com.bytedance.sdk.openadsdk.i.r r2 = r2.j(r3)     // Catch: java.lang.Throwable -> L38
            com.bytedance.sdk.openadsdk.i.r r4 = r2.j(r1, r4)     // Catch: java.lang.Throwable -> L38
            android.util.SparseArray r4 = r4.xt()     // Catch: java.lang.Throwable -> L38
            java.lang.Object r4 = com.bytedance.msdk.core.ae.a.a(r0, r4)     // Catch: java.lang.Throwable -> L38
            if (r4 == 0) goto L43
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch: java.lang.Throwable -> L38
            boolean r4 = r4.booleanValue()     // Catch: java.lang.Throwable -> L38
            return r4
        L38:
            r4 = move-exception
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r4
            java.lang.String r4 = "ZeusUtil"
            com.bytedance.sdk.component.utils.vl.xt(r4, r0)
        L43:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.l.qv.m(java.lang.String):boolean");
    }

    public static JSONObject up(String str) {
        Object apply;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Function<SparseArray<Object>, Object> m6 = com.bytedance.sdk.openadsdk.core.oq.i().m(4);
            if (m6 != null) {
                apply = m6.apply(com.bytedance.sdk.openadsdk.i.r.j().j(13).j(JSONObject.class).j(0, str).xt());
                if (apply instanceof JSONObject) {
                    return (JSONObject) apply;
                }
            }
        } catch (Throwable th) {
            vl.xt("ZeusUtil", th);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
    
        r3 = r1.apply(com.bytedance.sdk.openadsdk.i.r.j().j(r4).j(java.lang.Integer.class).j(0, r3).xt());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int j(java.lang.String r3, int r4) {
        /*
            r0 = 0
            com.bytedance.sdk.openadsdk.core.oq r1 = com.bytedance.sdk.openadsdk.core.oq.i()     // Catch: java.lang.Throwable -> L2f
            r2 = 4
            java.util.function.Function r1 = r1.m(r2)     // Catch: java.lang.Throwable -> L2f
            if (r1 == 0) goto L3a
            com.bytedance.sdk.openadsdk.i.r r2 = com.bytedance.sdk.openadsdk.i.r.j()     // Catch: java.lang.Throwable -> L2f
            com.bytedance.sdk.openadsdk.i.r r4 = r2.j(r4)     // Catch: java.lang.Throwable -> L2f
            java.lang.Class<java.lang.Integer> r2 = java.lang.Integer.class
            com.bytedance.sdk.openadsdk.i.r r4 = r4.j(r2)     // Catch: java.lang.Throwable -> L2f
            com.bytedance.sdk.openadsdk.i.r r3 = r4.j(r0, r3)     // Catch: java.lang.Throwable -> L2f
            android.util.SparseArray r3 = r3.xt()     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r3 = com.bytedance.msdk.core.ae.a.a(r1, r3)     // Catch: java.lang.Throwable -> L2f
            if (r3 == 0) goto L3a
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Throwable -> L2f
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L2f
            return r3
        L2f:
            r3 = move-exception
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r0] = r3
            java.lang.String r3 = "ZeusUtil"
            com.bytedance.sdk.component.utils.vl.xt(r3, r4)
        L3a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.l.qv.j(java.lang.String, int):int");
    }
}
