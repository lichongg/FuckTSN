package com.bytedance.sdk.openadsdk.mediation.xt.j.xt;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final IMediationInterstitialFullAdListener f31786j;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:
    
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
            com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener r0 = r3.f31786j
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            com.bykv.j.j.j.j.a r4 = com.bykv.j.j.j.j.a.j(r4)
            com.bykv.vk.openvk.api.proto.ValueSet r4 = r4.k()
            r0 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            int r0 = r4.intValue(r0)
            r2 = 0
            switch(r0) {
                case 131101: goto L61;
                case 131102: goto L5b;
                case 131103: goto L55;
                case 131104: goto L4f;
                case 131105: goto L49;
                case 131106: goto L3a;
                case 131107: goto L34;
                case 131108: goto L2e;
                case 131109: goto L28;
                case 131110: goto L1a;
                default: goto L19;
            }
        L19:
            goto L66
        L1a:
            java.lang.Class<android.os.Bundle> r0 = android.os.Bundle.class
            java.lang.Object r4 = r4.objectValue(r2, r0)
            android.os.Bundle r4 = (android.os.Bundle) r4
            com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener r0 = r3.f31786j
            r0.onRewardVerify(r4)
            goto L66
        L28:
            com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener r4 = r3.f31786j
            r4.onAdLeftApplication()
            goto L66
        L2e:
            com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener r4 = r3.f31786j
            r4.onAdOpened()
            goto L66
        L34:
            com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener r4 = r3.f31786j
            r4.onVideoError()
            goto L66
        L3a:
            int r0 = r4.intValue(r2)
            r2 = 1
            java.lang.String r4 = r4.stringValue(r2)
            com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener r2 = r3.f31786j
            r2.onInterstitialFullShowFail(r0, r4)
            goto L66
        L49:
            com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener r4 = r3.f31786j
            r4.onSkippedVideo()
            goto L66
        L4f:
            com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener r4 = r3.f31786j
            r4.onVideoComplete()
            goto L66
        L55:
            com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener r4 = r3.f31786j
            r4.onAdClose()
            goto L66
        L5b:
            com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener r4 = r3.f31786j
            r4.onAdVideoBarClick()
            goto L66
        L61:
            com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener r4 = r3.f31786j
            r4.onAdShow()
        L66:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.mediation.xt.j.xt.xt.apply(android.util.SparseArray):java.lang.Object");
    }

    public xt(IMediationInterstitialFullAdListener iMediationInterstitialFullAdListener) {
        this.f31786j = iMediationInterstitialFullAdListener;
    }
}
