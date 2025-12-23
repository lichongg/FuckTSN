package com.bytedance.sdk.openadsdk.ch.j.j.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final ValueSet f27748j = a.f22763c;
    private final TTNativeAd.AdInteractionListener xt;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0063, code lost:
    
        return null;
     */
    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object apply(android.util.SparseArray<java.lang.Object> r7) {
        /*
            r6 = this;
            com.bytedance.sdk.openadsdk.TTNativeAd$AdInteractionListener r0 = r6.xt
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            com.bykv.j.j.j.j.a r7 = com.bykv.j.j.j.j.a.j(r7)
            com.bykv.vk.openvk.api.proto.ValueSet r7 = r7.k()
            r0 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            int r0 = r7.intValue(r0)
            r2 = 1
            java.lang.Class<android.view.View> r3 = android.view.View.class
            java.lang.Class<java.lang.Object> r4 = java.lang.Object.class
            r5 = 0
            switch(r0) {
                case 141101: goto L4b;
                case 141102: goto L32;
                case 141103: goto L1f;
                default: goto L1e;
            }
        L1e:
            goto L63
        L1f:
            com.bytedance.sdk.openadsdk.i.j.j.vl r0 = new com.bytedance.sdk.openadsdk.i.j.j.vl
            java.lang.Object r7 = r7.objectValue(r5, r4)
            java.util.function.Function r7 = com.bytedance.sdk.openadsdk.i.j.j.az.j(r7)
            r0.<init>(r7)
            com.bytedance.sdk.openadsdk.TTNativeAd$AdInteractionListener r7 = r6.xt
            r7.onAdShow(r0)
            goto L63
        L32:
            java.lang.Object r0 = r7.objectValue(r5, r3)
            android.view.View r0 = (android.view.View) r0
            com.bytedance.sdk.openadsdk.i.j.j.vl r3 = new com.bytedance.sdk.openadsdk.i.j.j.vl
            java.lang.Object r7 = r7.objectValue(r2, r4)
            java.util.function.Function r7 = com.bytedance.sdk.openadsdk.i.j.j.az.j(r7)
            r3.<init>(r7)
            com.bytedance.sdk.openadsdk.TTNativeAd$AdInteractionListener r7 = r6.xt
            r7.onAdCreativeClick(r0, r3)
            goto L63
        L4b:
            java.lang.Object r0 = r7.objectValue(r5, r3)
            android.view.View r0 = (android.view.View) r0
            com.bytedance.sdk.openadsdk.i.j.j.vl r3 = new com.bytedance.sdk.openadsdk.i.j.j.vl
            java.lang.Object r7 = r7.objectValue(r2, r4)
            java.util.function.Function r7 = com.bytedance.sdk.openadsdk.i.j.j.az.j(r7)
            r3.<init>(r7)
            com.bytedance.sdk.openadsdk.TTNativeAd$AdInteractionListener r7 = r6.xt
            r7.onAdClicked(r0, r3)
        L63:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.ch.j.j.j.j.apply(android.util.SparseArray):java.lang.Object");
    }

    public j(TTNativeAd.AdInteractionListener adInteractionListener) {
        this.xt = adInteractionListener;
    }
}
