package com.bytedance.sdk.openadsdk.l;

import android.os.Environment;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {
    public static String j() {
        try {
            return Environment.getExternalStorageState();
        } catch (Throwable unused) {
            return "";
        }
    }
}
