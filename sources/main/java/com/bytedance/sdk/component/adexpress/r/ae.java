package com.bytedance.sdk.component.adexpress.r;

import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae {
    public static boolean j(String str) {
        return TextUtils.equals(str, "fullscreen_interstitial_ad") || TextUtils.equals(str, "rewarded_video");
    }

    public static boolean xt(String str) {
        if (com.bytedance.sdk.component.adexpress.r.j() && j(str)) {
            return true;
        }
        return false;
    }
}
