package com.bytedance.sdk.openadsdk.mediation.ad.j.j.xt;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final IMediationDislikeCallback f31662j;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0034, code lost:
    
        return null;
     */
    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object apply(android.util.SparseArray<java.lang.Object> r4) {
        /*
            r3 = this;
            com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback r0 = r3.f31662j
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            com.bykv.j.j.j.j.a r4 = com.bykv.j.j.j.j.a.j(r4)
            com.bykv.vk.openvk.api.proto.ValueSet r4 = r4.k()
            r0 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            int r0 = r4.intValue(r0)
            switch(r0) {
                case 268013: goto L25;
                case 268014: goto L1f;
                case 268015: goto L19;
                default: goto L18;
            }
        L18:
            goto L34
        L19:
            com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback r4 = r3.f31662j
            r4.onShow()
            goto L34
        L1f:
            com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback r4 = r3.f31662j
            r4.onCancel()
            goto L34
        L25:
            r0 = 0
            int r0 = r4.intValue(r0)
            r2 = 1
            java.lang.String r4 = r4.stringValue(r2)
            com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback r2 = r3.f31662j
            r2.onSelected(r0, r4)
        L34:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.mediation.ad.j.j.xt.xt.apply(android.util.SparseArray):java.lang.Object");
    }

    public xt(IMediationDislikeCallback iMediationDislikeCallback) {
        this.f31662j = iMediationDislikeCallback;
    }
}
