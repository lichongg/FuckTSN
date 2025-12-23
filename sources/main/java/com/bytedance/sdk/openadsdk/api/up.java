package com.bytedance.sdk.openadsdk.api;

import android.os.Build;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {
    public static boolean j() {
        if (Build.VERSION.SDK_INT >= 24) {
            return false;
        }
        m.cw("csj sdk only support android os >= android 7.0（API-24）");
        return true;
    }
}
