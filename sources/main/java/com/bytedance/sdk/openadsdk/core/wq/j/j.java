package com.bytedance.sdk.openadsdk.core.wq.j;

import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static Boolean f31292j;

    private static boolean j() {
        if (f31292j == null) {
            try {
                Class.forName("com.bytedance.sdk.openadsdk.mediation.MediationConstant$AdIsReadyStatus");
                f31292j = Boolean.TRUE;
            } catch (Throwable unused) {
                f31292j = Boolean.FALSE;
            }
        }
        return f31292j.booleanValue();
    }

    public static Integer j(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        try {
            if (j()) {
                if (obj == MediationConstant.AdIsReadyStatus.ADN_NO_READY_API) {
                    return 1;
                }
                if (obj == MediationConstant.AdIsReadyStatus.AD_IS_READY) {
                    return 2;
                }
                if (obj == MediationConstant.AdIsReadyStatus.AD_IS_EXPIRED) {
                    return 3;
                }
                if (obj == MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY) {
                    return 4;
                }
            }
        } catch (Throwable th) {
            vl.j(th);
        }
        return null;
    }
}
