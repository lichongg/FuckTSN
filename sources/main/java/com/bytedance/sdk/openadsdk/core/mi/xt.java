package com.bytedance.sdk.openadsdk.core.mi;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    public static boolean j(long j6, long j7) {
        return (j6 & j7) == j7;
    }

    public static boolean j(long j6) {
        return j(j6, j.USE_ALOG.j());
    }

    public static boolean xt(long j6) {
        return j(j6, j.USE_PITAYA.j());
    }
}
