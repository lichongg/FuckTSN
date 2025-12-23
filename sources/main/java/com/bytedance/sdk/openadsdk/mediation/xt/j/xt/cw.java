package com.bytedance.sdk.openadsdk.mediation.xt.j.xt;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final IMediationNativeAdTokenCallback f31782j;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0041, code lost:
    
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
            com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback r0 = r5.f31782j
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            com.bykv.j.j.j.j.a r6 = com.bykv.j.j.j.j.a.j(r6)
            com.bykv.vk.openvk.api.proto.ValueSet r6 = r6.k()
            r0 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            int r0 = r6.intValue(r0)
            r2 = 1
            r3 = 0
            switch(r0) {
                case 270026: goto L29;
                case 270027: goto L1b;
                default: goto L1a;
            }
        L1a:
            goto L41
        L1b:
            int r0 = r6.intValue(r3)
            java.lang.String r6 = r6.stringValue(r2)
            com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback r2 = r5.f31782j
            r2.onAdTokenLoadedFail(r0, r6)
            goto L41
        L29:
            java.lang.String r0 = r6.stringValue(r3)
            com.bytedance.sdk.openadsdk.mediation.xt.j.j.cw r3 = new com.bytedance.sdk.openadsdk.mediation.xt.j.j.cw
            java.lang.Class<java.lang.Object> r4 = java.lang.Object.class
            java.lang.Object r6 = r6.objectValue(r2, r4)
            java.util.function.Function r6 = com.bytedance.sdk.openadsdk.i.j.j.az.j(r6)
            r3.<init>(r6)
            com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback r6 = r5.f31782j
            r6.onAdTokenLoaded(r0, r3)
        L41:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.mediation.xt.j.xt.cw.apply(android.util.SparseArray):java.lang.Object");
    }

    public cw(IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        this.f31782j = iMediationNativeAdTokenCallback;
    }
}
