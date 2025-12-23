package com.bytedance.sdk.openadsdk.core.dislike.j;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private static r cw;

    /* renamed from: j, reason: collision with root package name */
    private static volatile boolean f28874j;
    private static cw xt;

    public static void j(cw cwVar, r rVar) {
        if (f28874j) {
            return;
        }
        f28874j = true;
        xt = cwVar;
        cw = rVar;
    }

    public static r xt() {
        return cw;
    }

    public static cw j() {
        return xt;
    }
}
