package com.bytedance.sdk.openadsdk.core.multipro;

import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {

    /* renamed from: j, reason: collision with root package name */
    public static String f29579j = "com.bytedance.openadsdk";
    public static String xt = "content://" + f29579j + ".TTMultiProvider";

    static {
        j();
    }

    public static void j() {
        if (v.getContext() != null) {
            f29579j = v.getContext().getPackageName();
            xt = "content://" + f29579j + ".TTMultiProvider";
        }
    }
}
