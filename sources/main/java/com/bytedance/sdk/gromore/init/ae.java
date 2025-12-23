package com.bytedance.sdk.gromore.init;

import com.bytedance.sdk.openadsdk.core.la;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae extends com.bytedance.sdk.openadsdk.core.wq.r {

    /* renamed from: j, reason: collision with root package name */
    private final la f27330j;
    private tl xt;

    public ae(la laVar) {
        this.f27330j = laVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b0, code lost:
    
        r4 = r6.apply(com.bytedance.sdk.openadsdk.i.r.j().j(5).j(java.lang.Object.class).xt());
     */
    @Override // com.bytedance.sdk.openadsdk.core.wq.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T applyFunction(int r4, com.bykv.vk.openvk.api.proto.PluginValueSet r5, java.lang.Class<T> r6) {
        /*
            r3 = this;
            r6 = -99999986(0xfffffffffa0a1f0e, float:-1.792917E35)
            r0 = 0
            if (r4 != r6) goto Lf
            com.bytedance.sdk.openadsdk.core.la r4 = r3.f27330j
            if (r4 == 0) goto Le8
            android.util.SparseArray r4 = r4.j()
            return r4
        Lf:
            r6 = 6
            if (r4 != r6) goto L7a
            if (r5 == 0) goto L1f
            r4 = 10
            java.lang.Class<android.os.Bundle> r6 = android.os.Bundle.class
            java.lang.Object r4 = r5.objectValue(r4, r6)
            android.os.Bundle r4 = (android.os.Bundle) r4
            goto L20
        L1f:
            r4 = r0
        L20:
            if (r5 == 0) goto L2d
            r6 = 9
            java.lang.Class<java.lang.Class> r1 = java.lang.Class.class
            java.lang.Object r6 = r5.objectValue(r6, r1)
            java.lang.Class r6 = (java.lang.Class) r6
            goto L2e
        L2d:
            r6 = r0
        L2e:
            if (r4 == 0) goto L4a
            java.lang.String r1 = "mediation_manager"
            java.lang.String r2 = r4.getString(r1)
            boolean r1 = android.text.TextUtils.equals(r2, r1)
            if (r1 == 0) goto L4a
            com.bytedance.sdk.gromore.init.tl r4 = r3.xt
            if (r4 != 0) goto L47
            com.bytedance.sdk.gromore.init.tl r4 = new com.bytedance.sdk.gromore.init.tl
            r4.<init>()
            r3.xt = r4
        L47:
            com.bytedance.sdk.gromore.init.tl r4 = r3.xt
            return r4
        L4a:
            boolean r1 = com.bytedance.sdk.openadsdk.core.wq.j.r.j(r6, r4)
            if (r1 == 0) goto L6d
            com.bytedance.sdk.openadsdk.core.la r1 = r3.f27330j
            if (r1 == 0) goto L6c
            android.util.SparseArray r5 = r5.sparseArray()
            java.lang.Object r5 = r1.apply(r5)
            boolean r1 = r5 instanceof com.bytedance.sdk.openadsdk.core.wq.j.r.j
            if (r1 == 0) goto L6c
            com.bytedance.sdk.gromore.init.g r0 = new com.bytedance.sdk.gromore.init.g
            com.bytedance.sdk.openadsdk.core.wq.j.r$j r5 = (com.bytedance.sdk.openadsdk.core.wq.j.r.j) r5
            r0.<init>(r5)
            java.lang.Object r4 = com.bytedance.sdk.openadsdk.core.wq.j.r.j(r0, r6, r4)
            return r4
        L6c:
            return r0
        L6d:
            com.bytedance.sdk.openadsdk.core.la r4 = r3.f27330j
            if (r4 == 0) goto Le8
            android.util.SparseArray r5 = r5.sparseArray()
            java.lang.Object r4 = r4.apply(r5)
            return r4
        L7a:
            r6 = 4
            if (r4 != r6) goto Ldb
            java.lang.Class<java.lang.Object> r4 = java.lang.Object.class
            if (r5 == 0) goto L88
            r6 = 8
            java.lang.Object r6 = r5.objectValue(r6, r4)
            goto L89
        L88:
            r6 = r0
        L89:
            boolean r1 = com.bytedance.sdk.openadsdk.core.h.m()
            if (r1 == 0) goto Lce
            boolean r1 = com.bykv.j.j.j.j.f.a(r6)
            if (r1 == 0) goto Lce
            java.util.function.Function r6 = a1.b.a(r6)
            android.util.SparseArray r1 = com.bytedance.sdk.openadsdk.i.cw.j(r6)
            com.bykv.j.j.j.j.e r1 = com.bykv.j.j.j.j.e.i(r1)
            com.bykv.vk.openvk.api.proto.PluginValueSet r1 = r1.k()
            if (r1 == 0) goto Lce
            r2 = 10000(0x2710, float:1.4013E-41)
            int r1 = r1.intValue(r2)
            r2 = 1
            if (r1 != r2) goto Lce
            com.bytedance.sdk.openadsdk.i.r r1 = com.bytedance.sdk.openadsdk.i.r.j()
            r2 = 5
            com.bytedance.sdk.openadsdk.i.r r1 = r1.j(r2)
            com.bytedance.sdk.openadsdk.i.r r4 = r1.j(r4)
            android.util.SparseArray r4 = r4.xt()
            java.lang.Object r4 = com.bytedance.msdk.core.ae.a.a(r6, r4)
            if (r4 == 0) goto Lce
            com.bytedance.msdk.core.j r6 = com.bytedance.msdk.core.j.qv()
            r6.j(r4)
        Lce:
            com.bytedance.sdk.openadsdk.core.la r4 = r3.f27330j
            if (r4 == 0) goto Le8
            android.util.SparseArray r5 = r5.sparseArray()
            java.lang.Object r4 = r4.apply(r5)
            return r4
        Ldb:
            com.bytedance.sdk.openadsdk.core.la r4 = r3.f27330j
            if (r4 == 0) goto Le8
            android.util.SparseArray r5 = r5.sparseArray()
            java.lang.Object r4 = r4.apply(r5)
            return r4
        Le8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.gromore.init.ae.applyFunction(int, com.bykv.vk.openvk.api.proto.PluginValueSet, java.lang.Class):java.lang.Object");
    }
}
