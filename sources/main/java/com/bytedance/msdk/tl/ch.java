package com.bytedance.msdk.tl;

import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ch {
    public static void j(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            j(str2);
        }
    }

    private static void j(String str) {
        throw new IllegalArgumentException(str);
    }
}
