package com.bytedance.sdk.openadsdk.f.j.j.j;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final TTDrawFeedAd.DrawVideoListener f31373j;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
    
        return null;
     */
    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object apply(android.util.SparseArray<java.lang.Object> r3) {
        /*
            r2 = this;
            com.bytedance.sdk.openadsdk.TTDrawFeedAd$DrawVideoListener r0 = r2.f31373j
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            com.bykv.j.j.j.j.a r3 = com.bykv.j.j.j.j.a.j(r3)
            com.bykv.vk.openvk.api.proto.ValueSet r3 = r3.k()
            r0 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            int r3 = r3.intValue(r0)
            switch(r3) {
                case 171101: goto L1f;
                case 171102: goto L19;
                default: goto L18;
            }
        L18:
            goto L24
        L19:
            com.bytedance.sdk.openadsdk.TTDrawFeedAd$DrawVideoListener r3 = r2.f31373j
            r3.onClickRetry()
            goto L24
        L1f:
            com.bytedance.sdk.openadsdk.TTDrawFeedAd$DrawVideoListener r3 = r2.f31373j
            r3.onClick()
        L24:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.f.j.j.j.j.apply(android.util.SparseArray):java.lang.Object");
    }

    public j(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.f31373j = drawVideoListener;
    }
}
