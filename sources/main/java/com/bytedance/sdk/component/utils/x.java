package com.bytedance.sdk.component.utils;

import android.os.Build;
import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes4.dex */
public class x {

    /* renamed from: j, reason: collision with root package name */
    private static volatile String f26905j;

    public static String j() {
        if (!TextUtils.isEmpty(f26905j)) {
            return f26905j;
        }
        String str = Build.MODEL;
        f26905j = str;
        return str;
    }
}
