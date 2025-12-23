package com.bytedance.sdk.component.tl.xt.m;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static volatile xt f26789j;

    public static xt j(com.bytedance.sdk.component.tl.j.up upVar) {
        if (f26789j == null) {
            synchronized (xt.class) {
                try {
                    if (f26789j == null) {
                        f26789j = new cw(new m(upVar), upVar);
                    }
                } finally {
                }
            }
        }
        return f26789j;
    }
}
