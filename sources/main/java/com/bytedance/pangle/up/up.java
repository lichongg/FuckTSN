package com.bytedance.pangle.up;

import com.bytedance.pangle.m;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {

    /* renamed from: j, reason: collision with root package name */
    private static m f25540j;

    public static void j(m mVar) {
        f25540j = mVar;
    }

    public static void cw(Runnable runnable) {
        f25540j.cw(runnable);
    }

    public static void j(Runnable runnable, boolean z5) {
        if (z5) {
            j(runnable);
        } else {
            xt(runnable);
        }
    }

    public static void xt(Runnable runnable) {
        f25540j.xt(runnable);
    }

    public static void j(Runnable runnable) {
        f25540j.j(runnable);
    }
}
