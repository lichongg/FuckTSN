package com.bytedance.sdk.openadsdk.core.qv.j;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.ss.android.j.j.cw.b;
import com.ss.android.j.j.cw.c;
import com.ss.android.j.j.cw.e;
import java.util.function.Function;
import java.util.function.LongSupplier;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class cw extends com.bytedance.sdk.openadsdk.core.wq.r implements e, LongSupplier {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x011b, code lost:
    
        return null;
     */
    @Override // com.bytedance.sdk.openadsdk.core.wq.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T applyFunction(int r6, com.bykv.vk.openvk.api.proto.PluginValueSet r7, java.lang.Class<T> r8) {
        /*
            r5 = this;
            r8 = 0
            if (r7 != 0) goto L4
            return r8
        L4:
            int r0 = com.bytedance.sdk.openadsdk.core.h.xt
            boolean r0 = com.bytedance.sdk.openadsdk.i.cw.r.j(r0)
            java.lang.Class<android.util.SparseArray> r1 = android.util.SparseArray.class
            if (r0 != 0) goto L1f
            r0 = -99999979(0xfffffffffa0a1f15, float:-1.7929185E35)
            java.lang.Object r7 = r7.objectValue(r0, r1)
            android.util.SparseArray r7 = (android.util.SparseArray) r7
            com.bykv.j.j.j.j.e r7 = com.bykv.j.j.j.j.e.i(r7)
            com.bykv.vk.openvk.api.proto.PluginValueSet r7 = r7.k()
        L1f:
            java.lang.Class<java.lang.Integer> r0 = java.lang.Integer.class
            r2 = 223608(0x36978, float:3.13342E-40)
            r3 = 223607(0x36977, float:3.1334E-40)
            r4 = -999902(0xfffffffffff0be22, float:NaN)
            switch(r6) {
                case 223600: goto L118;
                case 223601: goto Le6;
                case 223602: goto Lbc;
                case 223603: goto L92;
                case 223604: goto L71;
                case 223605: goto L50;
                case 223606: goto L2f;
                default: goto L2d;
            }
        L2d:
            goto L11b
        L2f:
            if (r7 == 0) goto L11b
            java.lang.Object r6 = r7.objectValue(r4, r1)
            android.util.SparseArray r6 = (android.util.SparseArray) r6
            com.bykv.j.j.j.j.e r6 = com.bykv.j.j.j.j.e.i(r6)
            com.bykv.vk.openvk.api.proto.PluginValueSet r6 = r6.k()
            java.lang.Class r7 = a1.a.a()
            java.lang.Object r6 = r6.objectValue(r3, r7)
            java.util.function.Function r6 = a1.b.a(r6)
            r5.onDownloadFinished(r6)
            goto L11b
        L50:
            if (r7 == 0) goto L11b
            java.lang.Object r6 = r7.objectValue(r4, r1)
            android.util.SparseArray r6 = (android.util.SparseArray) r6
            com.bykv.j.j.j.j.e r6 = com.bykv.j.j.j.j.e.i(r6)
            com.bykv.vk.openvk.api.proto.PluginValueSet r6 = r6.k()
            java.lang.Class r7 = a1.a.a()
            java.lang.Object r6 = r6.objectValue(r3, r7)
            java.util.function.Function r6 = a1.b.a(r6)
            r5.onInstalled(r6)
            goto L11b
        L71:
            if (r7 == 0) goto L11b
            java.lang.Object r6 = r7.objectValue(r4, r1)
            android.util.SparseArray r6 = (android.util.SparseArray) r6
            com.bykv.j.j.j.j.e r6 = com.bykv.j.j.j.j.e.i(r6)
            com.bykv.vk.openvk.api.proto.PluginValueSet r6 = r6.k()
            java.lang.Class r7 = a1.a.a()
            java.lang.Object r6 = r6.objectValue(r3, r7)
            java.util.function.Function r6 = a1.b.a(r6)
            r5.onDownloadFailed(r6)
            goto L11b
        L92:
            if (r7 == 0) goto L11b
            java.lang.Object r6 = r7.objectValue(r4, r1)
            android.util.SparseArray r6 = (android.util.SparseArray) r6
            com.bykv.j.j.j.j.e r6 = com.bykv.j.j.j.j.e.i(r6)
            com.bykv.vk.openvk.api.proto.PluginValueSet r6 = r6.k()
            java.lang.Class r7 = a1.a.a()
            java.lang.Object r7 = r6.objectValue(r3, r7)
            java.util.function.Function r7 = a1.b.a(r7)
            java.lang.Object r6 = r6.objectValue(r2, r0)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r5.onDownloadPaused(r7, r6)
            goto L11b
        Lbc:
            if (r7 == 0) goto L11b
            java.lang.Object r6 = r7.objectValue(r4, r1)
            android.util.SparseArray r6 = (android.util.SparseArray) r6
            com.bykv.j.j.j.j.e r6 = com.bykv.j.j.j.j.e.i(r6)
            com.bykv.vk.openvk.api.proto.PluginValueSet r6 = r6.k()
            java.lang.Class r7 = a1.a.a()
            java.lang.Object r7 = r6.objectValue(r3, r7)
            java.util.function.Function r7 = a1.b.a(r7)
            java.lang.Object r6 = r6.objectValue(r2, r0)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r5.onDownloadActive(r7, r6)
            goto L11b
        Le6:
            if (r7 == 0) goto L11b
            java.lang.Object r6 = r7.objectValue(r4, r1)
            android.util.SparseArray r6 = (android.util.SparseArray) r6
            com.bykv.j.j.j.j.e r6 = com.bykv.j.j.j.j.e.i(r6)
            com.bykv.vk.openvk.api.proto.PluginValueSet r6 = r6.k()
            r7 = 223201(0x367e1, float:3.12771E-40)
            java.lang.Class r0 = a1.a.a()
            java.lang.Object r7 = r6.objectValue(r7, r0)
            java.util.function.Function r7 = a1.b.a(r7)
            r0 = 223203(0x367e3, float:3.12774E-40)
            java.lang.Class r1 = a1.a.a()
            java.lang.Object r6 = r6.objectValue(r0, r1)
            java.util.function.Function r6 = a1.b.a(r6)
            r5.onDownloadStart(r7, r6)
            goto L11b
        L118:
            r5.j()
        L11b:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.qv.j.cw.applyFunction(int, com.bykv.vk.openvk.api.proto.PluginValueSet, java.lang.Class):java.lang.Object");
    }

    public abstract void onDownloadActive(long j6, long j7, String str);

    @Override // com.ss.android.j.j.cw.e
    public void onDownloadActive(com.ss.android.j.j.up.e eVar, int i6) {
        if (eVar == null) {
            return;
        }
        onDownloadActive(eVar.f38316c, eVar.f38317d, eVar.f38318e);
    }

    public abstract void onDownloadFailed(long j6, long j7, String str);

    @Override // com.ss.android.j.j.cw.e
    public void onDownloadFailed(com.ss.android.j.j.up.e eVar) {
        if (eVar == null) {
            return;
        }
        onDownloadFailed(eVar.f38316c, eVar.f38317d, eVar.f38318e);
    }

    public abstract void onDownloadFinished(long j6, long j7, String str);

    @Override // com.ss.android.j.j.cw.e
    public void onDownloadFinished(com.ss.android.j.j.up.e eVar) {
        if (eVar == null) {
            return;
        }
        onDownloadFinished(eVar.f38316c, eVar.f38317d, eVar.f38318e);
    }

    public abstract void onDownloadPaused(long j6, long j7, String str);

    @Override // com.ss.android.j.j.cw.e
    public void onDownloadPaused(com.ss.android.j.j.up.e eVar, int i6) {
        if (eVar == null) {
            return;
        }
        onDownloadPaused(eVar.f38316c, eVar.f38317d, eVar.f38318e);
    }

    public abstract void onDownloadStart();

    @Override // com.ss.android.j.j.cw.e
    public void onDownloadStart(b bVar, c cVar) {
        if (bVar == null) {
            return;
        }
        onDownloadStart();
    }

    public abstract void onInstalled(long j6, long j7, String str);

    @Override // com.ss.android.j.j.cw.e
    public void onInstalled(com.ss.android.j.j.up.e eVar) {
        if (eVar == null) {
            return;
        }
        String str = eVar.f38318e;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        onInstalled(eVar.f38316c, eVar.f38317d, str);
    }

    private void onDownloadActive(Function<SparseArray<Object>, Object> function, int i6) {
        PluginValueSet xt;
        if (function == null || (xt = com.bytedance.sdk.openadsdk.i.cw.xt(function)) == null) {
            return;
        }
        onDownloadActive(xt.longValue(223704), xt.longValue(223705), xt.stringValue(223706));
    }

    private void onDownloadFailed(Function<SparseArray<Object>, Object> function) {
        PluginValueSet xt;
        if (function == null || (xt = com.bytedance.sdk.openadsdk.i.cw.xt(function)) == null) {
            return;
        }
        onDownloadFailed(xt.longValue(223704), xt.longValue(223705), xt.stringValue(223706));
    }

    private void onDownloadFinished(Function<SparseArray<Object>, Object> function) {
        PluginValueSet xt;
        if (function == null || (xt = com.bytedance.sdk.openadsdk.i.cw.xt(function)) == null) {
            return;
        }
        onDownloadFinished(xt.longValue(223704), xt.longValue(223705), xt.stringValue(223706));
    }

    private void onDownloadPaused(Function<SparseArray<Object>, Object> function, int i6) {
        PluginValueSet xt;
        if (function == null || (xt = com.bytedance.sdk.openadsdk.i.cw.xt(function)) == null) {
            return;
        }
        onDownloadPaused(xt.longValue(223704), xt.longValue(223705), xt.stringValue(223706));
    }

    private void onDownloadStart(Function<SparseArray<Object>, Object> function, Function<SparseArray<Object>, Object> function2) {
        if (function == null || com.bytedance.sdk.openadsdk.i.cw.xt(function) == null) {
            return;
        }
        onDownloadStart();
    }

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }

    private void onInstalled(Function<SparseArray<Object>, Object> function) {
        PluginValueSet xt;
        if (function == null || (xt = com.bytedance.sdk.openadsdk.i.cw.xt(function)) == null) {
            return;
        }
        long longValue = xt.longValue(223704);
        long longValue2 = xt.longValue(223705);
        String stringValue = xt.stringValue(223706);
        if (stringValue == null) {
            stringValue = "";
        }
        onInstalled(longValue, longValue2, stringValue);
    }
}
