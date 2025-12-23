package com.bytedance.sdk.openadsdk.core.wq.j;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static Boolean f31297j;

    private static boolean j() {
        if (f31297j == null) {
            try {
                Class.forName("com.bytedance.sdk.openadsdk.mediation.MediationConstant$BiddingLossReason");
                f31297j = Boolean.TRUE;
            } catch (Throwable unused) {
                f31297j = Boolean.FALSE;
            }
        }
        return f31297j.booleanValue();
    }

    public static Object j(int i6) {
        if (!j()) {
            return Integer.valueOf(i6);
        }
        try {
            if (i6 == 1) {
                return MediationConstant.BiddingLossReason.LOW_PRICE;
            }
            if (i6 == 2) {
                return MediationConstant.BiddingLossReason.TIME_OUT;
            }
            if (i6 == 3) {
                return MediationConstant.BiddingLossReason.NO_AD;
            }
            if (i6 == 4) {
                return MediationConstant.BiddingLossReason.AD_DATA_ERROR;
            }
            if (i6 != 10001) {
                return null;
            }
            return MediationConstant.BiddingLossReason.OTHER;
        } catch (Throwable unused) {
            return null;
        }
    }
}
