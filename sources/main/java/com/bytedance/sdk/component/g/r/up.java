package com.bytedance.sdk.component.g.r;

import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {

    /* renamed from: j, reason: collision with root package name */
    private static boolean f26448j = false;
    private static int xt = 4;

    public static boolean j() {
        return f26448j;
    }

    public static void j(String str, String str2) {
        if (f26448j && str2 != null && xt <= 4) {
            vl.j(vl.r(str), str2);
        }
    }
}
