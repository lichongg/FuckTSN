package com.bytedance.sdk.component.tl.xt.j.j;

import com.bytedance.sdk.component.tl.j.up;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    private static String f26770j = "com.bytedance.openadsdk";
    private static String xt = "content://" + f26770j + ".TTMultiProvider";

    public static String j(up upVar) {
        if (upVar.getContext() != null) {
            f26770j = upVar.getContext().getPackageName();
            xt = "content://" + f26770j + ".TTMultiProvider";
        }
        return xt;
    }
}
