package com.bytedance.sdk.openadsdk.a.j.j.j;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final TTRewardVideoAd.RewardAdInteractionListener f27517j;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0071, code lost:
    
        return null;
     */
    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object apply(android.util.SparseArray<java.lang.Object> r11) {
        /*
            r10 = this;
            com.bytedance.sdk.openadsdk.TTRewardVideoAd$RewardAdInteractionListener r0 = r10.f27517j
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            com.bykv.j.j.j.j.a r11 = com.bykv.j.j.j.j.a.j(r11)
            com.bykv.vk.openvk.api.proto.ValueSet r11 = r11.k()
            r0 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            int r0 = r11.intValue(r0)
            r2 = 2
            r3 = 1
            r4 = 0
            switch(r0) {
                case 121101: goto L6c;
                case 121102: goto L66;
                case 121103: goto L60;
                case 121104: goto L5a;
                case 121105: goto L54;
                case 121106: goto L38;
                case 121107: goto L22;
                case 121108: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L71
        L1c:
            com.bytedance.sdk.openadsdk.TTRewardVideoAd$RewardAdInteractionListener r11 = r10.f27517j
            r11.onSkippedVideo()
            goto L71
        L22:
            boolean r0 = r11.booleanValue(r4)
            int r3 = r11.intValue(r3)
            java.lang.Class<android.os.Bundle> r4 = android.os.Bundle.class
            java.lang.Object r11 = r11.objectValue(r2, r4)
            android.os.Bundle r11 = (android.os.Bundle) r11
            com.bytedance.sdk.openadsdk.TTRewardVideoAd$RewardAdInteractionListener r2 = r10.f27517j
            r2.onRewardArrived(r0, r3, r11)
            goto L71
        L38:
            boolean r5 = r11.booleanValue(r4)
            int r6 = r11.intValue(r3)
            java.lang.String r7 = r11.stringValue(r2)
            r0 = 3
            int r8 = r11.intValue(r0)
            r0 = 4
            java.lang.String r9 = r11.stringValue(r0)
            com.bytedance.sdk.openadsdk.TTRewardVideoAd$RewardAdInteractionListener r4 = r10.f27517j
            r4.onRewardVerify(r5, r6, r7, r8, r9)
            goto L71
        L54:
            com.bytedance.sdk.openadsdk.TTRewardVideoAd$RewardAdInteractionListener r11 = r10.f27517j
            r11.onVideoError()
            goto L71
        L5a:
            com.bytedance.sdk.openadsdk.TTRewardVideoAd$RewardAdInteractionListener r11 = r10.f27517j
            r11.onVideoComplete()
            goto L71
        L60:
            com.bytedance.sdk.openadsdk.TTRewardVideoAd$RewardAdInteractionListener r11 = r10.f27517j
            r11.onAdClose()
            goto L71
        L66:
            com.bytedance.sdk.openadsdk.TTRewardVideoAd$RewardAdInteractionListener r11 = r10.f27517j
            r11.onAdVideoBarClick()
            goto L71
        L6c:
            com.bytedance.sdk.openadsdk.TTRewardVideoAd$RewardAdInteractionListener r11 = r10.f27517j
            r11.onAdShow()
        L71:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.a.j.j.j.j.apply(android.util.SparseArray):java.lang.Object");
    }

    public j(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.f27517j = rewardAdInteractionListener;
    }
}
