package com.bytedance.sdk.component.utils;

import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes4.dex */
public class av {
    public static void j(Object obj, String str) {
        if (obj == null) {
            xt(str);
        }
    }

    public static void j(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            xt(str2);
        }
    }

    private static void xt(String str) {
        throw new IllegalArgumentException(str);
    }

    public static void j(boolean z5, String str) {
        if (z5) {
            return;
        }
        xt(str);
    }

    public static void j(String str) {
        xt(str);
    }
}
