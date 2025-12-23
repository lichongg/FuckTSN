package com.bytedance.sdk.openadsdk.r.j.j.j;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final CSJSplashAd.SplashCardListener f31813j;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x003a, code lost:
    
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
            com.bytedance.sdk.openadsdk.CSJSplashAd$SplashCardListener r0 = r4.f31813j
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            com.bykv.j.j.j.j.a r5 = com.bykv.j.j.j.j.a.j(r5)
            com.bykv.vk.openvk.api.proto.ValueSet r5 = r5.k()
            r0 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            int r0 = r5.intValue(r0)
            switch(r0) {
                case 112102: goto L35;
                case 112103: goto L2f;
                case 121201: goto L19;
                default: goto L18;
            }
        L18:
            goto L3a
        L19:
            com.bytedance.sdk.openadsdk.i.j.j.xt r0 = new com.bytedance.sdk.openadsdk.i.j.j.xt
            r2 = 0
            java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
            java.lang.Object r5 = r5.objectValue(r2, r3)
            java.util.function.Function r5 = com.bytedance.sdk.openadsdk.i.j.j.az.j(r5)
            r0.<init>(r5)
            com.bytedance.sdk.openadsdk.CSJSplashAd$SplashCardListener r5 = r4.f31813j
            r5.onSplashCardReadyToShow(r0)
            goto L3a
        L2f:
            com.bytedance.sdk.openadsdk.CSJSplashAd$SplashCardListener r5 = r4.f31813j
            r5.onSplashCardClose()
            goto L3a
        L35:
            com.bytedance.sdk.openadsdk.CSJSplashAd$SplashCardListener r5 = r4.f31813j
            r5.onSplashCardClick()
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.r.j.j.j.xt.apply(android.util.SparseArray):java.lang.Object");
    }

    public xt(CSJSplashAd.SplashCardListener splashCardListener) {
        this.f31813j = splashCardListener;
    }
}
