package com.bytedance.sdk.openadsdk.i.j;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final TTAdNative.CSJSplashAdListener f31501j;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0079, code lost:
    
        return null;
     */
    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object apply(android.util.SparseArray<java.lang.Object> r6) {
        /*
            r5 = this;
            com.bytedance.sdk.openadsdk.TTAdNative$CSJSplashAdListener r0 = r5.f31501j
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            com.bykv.j.j.j.j.a r6 = com.bykv.j.j.j.j.a.j(r6)
            com.bykv.vk.openvk.api.proto.ValueSet r6 = r6.k()
            r0 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            int r0 = r6.intValue(r0)
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            r3 = 0
            switch(r0) {
                case 114102: goto L67;
                case 114103: goto L54;
                case 114104: goto L3d;
                case 114105: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L79
        L1c:
            com.bytedance.sdk.openadsdk.i.j.j.xt r0 = new com.bytedance.sdk.openadsdk.i.j.j.xt
            java.lang.Object r3 = r6.objectValue(r3, r2)
            java.util.function.Function r3 = com.bytedance.sdk.openadsdk.i.j.j.az.j(r3)
            r0.<init>(r3)
            com.bytedance.sdk.openadsdk.i.j.j.j r3 = new com.bytedance.sdk.openadsdk.i.j.j.j
            r4 = 1
            java.lang.Object r6 = r6.objectValue(r4, r2)
            java.util.function.Function r6 = com.bytedance.sdk.openadsdk.i.j.j.az.j(r6)
            r3.<init>(r6)
            com.bytedance.sdk.openadsdk.TTAdNative$CSJSplashAdListener r6 = r5.f31501j
            r6.onSplashRenderFail(r0, r3)
            goto L79
        L3d:
            com.bytedance.sdk.openadsdk.i.j.j.xt r0 = new com.bytedance.sdk.openadsdk.i.j.j.xt
            java.lang.Class r2 = a1.a.a()
            java.lang.Object r6 = r6.objectValue(r3, r2)
            java.util.function.Function r6 = a1.b.a(r6)
            r0.<init>(r6)
            com.bytedance.sdk.openadsdk.TTAdNative$CSJSplashAdListener r6 = r5.f31501j
            r6.onSplashRenderSuccess(r0)
            goto L79
        L54:
            com.bytedance.sdk.openadsdk.i.j.j.j r0 = new com.bytedance.sdk.openadsdk.i.j.j.j
            java.lang.Object r6 = r6.objectValue(r3, r2)
            java.util.function.Function r6 = com.bytedance.sdk.openadsdk.i.j.j.az.j(r6)
            r0.<init>(r6)
            com.bytedance.sdk.openadsdk.TTAdNative$CSJSplashAdListener r6 = r5.f31501j
            r6.onSplashLoadFail(r0)
            goto L79
        L67:
            java.lang.Object r6 = r6.objectValue(r3, r2)
            java.util.function.Function r6 = com.bytedance.sdk.openadsdk.i.j.j.az.j(r6)
            com.bytedance.sdk.openadsdk.i.j.j.xt r0 = new com.bytedance.sdk.openadsdk.i.j.j.xt
            r0.<init>(r6)
            com.bytedance.sdk.openadsdk.TTAdNative$CSJSplashAdListener r6 = r5.f31501j
            r6.onSplashLoadSuccess(r0)
        L79:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.i.j.xt.apply(android.util.SparseArray):java.lang.Object");
    }

    public xt(TTAdNative.CSJSplashAdListener cSJSplashAdListener) {
        this.f31501j = cSJSplashAdListener;
    }
}
