package com.bytedance.sdk.openadsdk.x.j.j.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private ValueSet f31989j = a.f22763c;
    private final TTFullScreenVideoAd.FullScreenVideoAdInteractionListener xt;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0036, code lost:
    
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
            com.bytedance.sdk.openadsdk.TTFullScreenVideoAd$FullScreenVideoAdInteractionListener r0 = r2.xt
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            com.bykv.j.j.j.j.a r3 = com.bykv.j.j.j.j.a.j(r3)
            com.bykv.vk.openvk.api.proto.ValueSet r3 = r3.k()
            r0 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            int r3 = r3.intValue(r0)
            switch(r3) {
                case 131101: goto L31;
                case 131102: goto L2b;
                case 131103: goto L25;
                case 131104: goto L1f;
                case 131105: goto L19;
                default: goto L18;
            }
        L18:
            goto L36
        L19:
            com.bytedance.sdk.openadsdk.TTFullScreenVideoAd$FullScreenVideoAdInteractionListener r3 = r2.xt
            r3.onSkippedVideo()
            goto L36
        L1f:
            com.bytedance.sdk.openadsdk.TTFullScreenVideoAd$FullScreenVideoAdInteractionListener r3 = r2.xt
            r3.onVideoComplete()
            goto L36
        L25:
            com.bytedance.sdk.openadsdk.TTFullScreenVideoAd$FullScreenVideoAdInteractionListener r3 = r2.xt
            r3.onAdClose()
            goto L36
        L2b:
            com.bytedance.sdk.openadsdk.TTFullScreenVideoAd$FullScreenVideoAdInteractionListener r3 = r2.xt
            r3.onAdVideoBarClick()
            goto L36
        L31:
            com.bytedance.sdk.openadsdk.TTFullScreenVideoAd$FullScreenVideoAdInteractionListener r3 = r2.xt
            r3.onAdShow()
        L36:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.x.j.j.j.j.apply(android.util.SparseArray):java.lang.Object");
    }

    public j(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.xt = fullScreenVideoAdInteractionListener;
    }
}
