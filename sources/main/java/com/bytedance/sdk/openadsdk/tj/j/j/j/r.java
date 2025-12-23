package com.bytedance.sdk.openadsdk.tj.j.j.j;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final TTAdNative.NativeAdListener f31836j;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005d, code lost:
    
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
            com.bytedance.sdk.openadsdk.TTAdNative$NativeAdListener r0 = r4.f31836j
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            com.bykv.j.j.j.j.a r5 = com.bykv.j.j.j.j.a.j(r5)
            com.bykv.vk.openvk.api.proto.ValueSet r5 = r5.k()
            r0 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            int r0 = r5.intValue(r0)
            r2 = 0
            switch(r0) {
                case 143101: goto L4f;
                case 143102: goto L1a;
                default: goto L19;
            }
        L19:
            goto L5d
        L1a:
            java.lang.Class<java.util.List> r0 = java.util.List.class
            java.lang.Object r5 = r5.objectValue(r2, r0)
            java.util.List r5 = (java.util.List) r5
            if (r5 != 0) goto L29
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>(r2)
        L29:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r5 = r5.iterator()
        L32:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L49
            java.lang.Object r2 = r5.next()
            com.bytedance.sdk.openadsdk.i.j.j.vl r3 = new com.bytedance.sdk.openadsdk.i.j.j.vl
            java.util.function.Function r2 = com.bytedance.sdk.openadsdk.i.j.j.az.j(r2)
            r3.<init>(r2)
            r0.add(r3)
            goto L32
        L49:
            com.bytedance.sdk.openadsdk.TTAdNative$NativeAdListener r5 = r4.f31836j
            r5.onNativeAdLoad(r0)
            goto L5d
        L4f:
            int r0 = r5.intValue(r2)
            r2 = 1
            java.lang.String r5 = r5.stringValue(r2)
            com.bytedance.sdk.openadsdk.TTAdNative$NativeAdListener r2 = r4.f31836j
            r2.onError(r0, r5)
        L5d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.tj.j.j.j.r.apply(android.util.SparseArray):java.lang.Object");
    }

    public r(TTAdNative.NativeAdListener nativeAdListener) {
        this.f31836j = nativeAdListener;
    }
}
