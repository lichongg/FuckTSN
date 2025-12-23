package com.bytedance.msdk.j.up;

import java.util.IllegalFormatException;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class r {
    public static void j(Object obj) {
        j(obj, true, "Object can not be null.", "");
    }

    private static boolean j(Object obj, boolean z5, String str, Object... objArr) {
        if (obj != null) {
            return true;
        }
        String j6 = j(str, objArr);
        if (z5) {
            throw new NullPointerException(j6);
        }
        cw.r("TTMediationSDK_ADAPTER", j6);
        return false;
    }

    private static String j(String str, Object... objArr) {
        String valueOf = String.valueOf(str);
        try {
            return String.format(valueOf, objArr);
        } catch (IllegalFormatException e6) {
            cw.r("TTMediationSDK_ADAPTER", "MoPub preconditions had a format exception: " + e6.getMessage());
            return valueOf;
        }
    }
}
