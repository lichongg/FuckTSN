package com.ss.android.downloadlib;

import w2.l;

/* loaded from: D:\Downloads\app\classes6.dex */
public class h {

    /* renamed from: b, reason: collision with root package name */
    private static volatile h f38123b;

    /* renamed from: a, reason: collision with root package name */
    private l f38124a = null;

    public static h a() {
        if (f38123b == null) {
            synchronized (h.class) {
                try {
                    if (f38123b == null) {
                        f38123b = new h();
                    }
                } finally {
                }
            }
        }
        return f38123b;
    }

    public l b() {
        return this.f38124a;
    }

    private h() {
    }
}
