package com.bytedance.sdk.openadsdk.core.wq.j;

import com.bytedance.sdk.openadsdk.TTAdLoadType;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {

    /* renamed from: j, reason: collision with root package name */
    private static Boolean f31293j;

    private static boolean j() {
        if (f31293j == null) {
            try {
                Class.forName("com.bytedance.sdk.openadsdk.TTAdLoadType");
                f31293j = Boolean.TRUE;
            } catch (Throwable unused) {
                f31293j = Boolean.FALSE;
            }
        }
        return f31293j.booleanValue();
    }

    public static int j(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (j()) {
            try {
                if (TTAdLoadType.LOAD == obj) {
                    return 3;
                }
                if (TTAdLoadType.PRELOAD == obj) {
                    return 1;
                }
                TTAdLoadType tTAdLoadType = TTAdLoadType.UNKNOWN;
            } catch (Throwable unused) {
            }
        }
        return -1;
    }
}
