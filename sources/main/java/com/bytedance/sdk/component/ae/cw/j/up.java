package com.bytedance.sdk.component.ae.cw.j;

import android.content.Context;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {

    /* renamed from: j, reason: collision with root package name */
    public static String f26071j = "com.bytedance.openadsdk";
    public static String xt = "content://" + f26071j + ".TTMultiProvider";

    static {
        j();
    }

    public static void j() {
        Context context = xt.getContext();
        if (context != null) {
            f26071j = context.getPackageName();
            xt = "content://" + f26071j + ".TTMultiProvider";
        }
    }
}
