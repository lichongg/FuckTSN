package com.bytedance.j.xt.tl;

import java.io.Closeable;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class h {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
