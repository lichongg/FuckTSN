package com.bytedance.sdk.openadsdk.mediation.xt.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class cw implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private PluginValueSet f31787j;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003d, code lost:
    
        return null;
     */
    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object apply(android.util.SparseArray<java.lang.Object> r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L4
            return r0
        L4:
            com.bykv.j.j.j.j.e r5 = com.bykv.j.j.j.j.e.i(r5)
            com.bykv.vk.openvk.api.proto.PluginValueSet r5 = r5.k()
            r1 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            int r1 = r5.intValue(r1)
            r2 = -99999985(0xfffffffffa0a1f0f, float:-1.7929173E35)
            java.lang.Class<java.lang.Class> r3 = java.lang.Class.class
            r5.objectValue(r2, r3)
            r2 = -99999986(0xfffffffffa0a1f0e, float:-1.792917E35)
            if (r1 == r2) goto L3e
            switch(r1) {
                case 268013: goto L2c;
                case 268014: goto L28;
                case 268015: goto L24;
                default: goto L23;
            }
        L23:
            goto L3d
        L24:
            r4.xt()
            goto L3d
        L28:
            r4.j()
            goto L3d
        L2c:
            r1 = 0
            int r1 = r5.intValue(r1)
            r2 = 1
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            java.lang.Object r5 = r5.objectValue(r2, r3)
            java.lang.String r5 = (java.lang.String) r5
            r4.j(r1, r5)
        L3d:
            return r0
        L3e:
            com.bykv.vk.openvk.api.proto.PluginValueSet r5 = r4.cw()
            android.util.SparseArray r5 = r5.sparseArray()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.mediation.xt.xt.cw.apply(android.util.SparseArray):java.lang.Object");
    }

    public abstract void j();

    public abstract void j(int i6, String str);

    public abstract void xt();

    public PluginValueSet cw() {
        PluginValueSet pluginValueSet = this.f31787j;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet r5 = r();
        this.f31787j = r5;
        return r5;
    }

    private PluginValueSet r() {
        return e.a().k();
    }
}
