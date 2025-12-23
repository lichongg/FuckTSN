package com.bytedance.sdk.openadsdk.i.cw.xt;

import android.util.SparseArray;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class tl implements Function<SparseArray<Object>, Object> {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x006d, code lost:
    
        return null;
     */
    @Override // java.util.function.Function
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object apply(android.util.SparseArray<java.lang.Object> r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L4
            return r0
        L4:
            com.bykv.j.j.j.j.e r6 = com.bykv.j.j.j.j.e.i(r6)
            com.bykv.vk.openvk.api.proto.PluginValueSet r6 = r6.k()
            r1 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            int r1 = r6.intValue(r1)
            r2 = -99999985(0xfffffffffa0a1f0f, float:-1.7929173E35)
            java.lang.Class<java.lang.Class> r3 = java.lang.Class.class
            r6.objectValue(r2, r3)
            r2 = -99999986(0xfffffffffa0a1f0e, float:-1.792917E35)
            if (r1 == r2) goto L6e
            r2 = 0
            switch(r1) {
                case 210101: goto L62;
                case 210102: goto L46;
                case 210103: goto L3a;
                case 210104: goto L25;
                default: goto L24;
            }
        L24:
            goto L6d
        L25:
            com.bytedance.sdk.openadsdk.i.cw.j.xt r1 = new com.bytedance.sdk.openadsdk.i.cw.j.xt
            java.lang.Class r3 = a1.a.a()
            java.lang.Object r6 = r6.objectValue(r2, r3)
            java.util.function.Function r6 = a1.b.a(r6)
            r1.<init>(r6)
            r5.j(r1)
            goto L6d
        L3a:
            double r1 = r6.doubleValue(r2)
            java.lang.Double r6 = java.lang.Double.valueOf(r1)
            r5.xt(r6)
            goto L6d
        L46:
            double r1 = r6.doubleValue(r2)
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r2 = 1
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            java.lang.Object r2 = r6.objectValue(r2, r3)
            java.lang.String r2 = (java.lang.String) r2
            r4 = 2
            java.lang.Object r6 = r6.objectValue(r4, r3)
            java.lang.String r6 = (java.lang.String) r6
            r5.j(r1, r2, r6)
            goto L6d
        L62:
            double r1 = r6.doubleValue(r2)
            java.lang.Double r6 = java.lang.Double.valueOf(r1)
            r5.j(r6)
        L6d:
            return r0
        L6e:
            android.util.SparseArray r6 = new android.util.SparseArray
            r6.<init>()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.i.cw.xt.tl.apply(android.util.SparseArray):java.lang.Object");
    }

    public abstract void j(com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar);

    public abstract void j(Double d6);

    public abstract void j(Double d6, String str, String str2);

    public abstract void xt(Double d6);
}
