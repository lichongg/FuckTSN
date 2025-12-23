package com.bytedance.msdk.j.up;

import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up {
    public static String j() {
        return "TTMediationSDK_";
    }

    public static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return j();
        }
        return "TTMediationSDK_" + str + "_";
    }

    public static String xt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return j();
        }
        if (TextUtils.isEmpty(str2)) {
            return j(str);
        }
        return "TTMediationSDK_" + str + "_" + str2 + "_";
    }

    public static String j(com.bytedance.msdk.core.oq.xt xtVar) {
        if (xtVar != null && !TextUtils.isEmpty(xtVar.rn())) {
            return "TTMediationSDK_" + xtVar.rn() + "_";
        }
        return j();
    }

    public static String j(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return j();
        }
        if (TextUtils.isEmpty(str2)) {
            return j(str);
        }
        return "TTMediationSDK_" + str + "_" + str2 + "_";
    }
}
