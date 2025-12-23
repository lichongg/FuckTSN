package com.bytedance.j.xt.j;

import android.content.Context;
import androidx.annotation.NonNull;

/* loaded from: D:\Downloads\app\classes3.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static volatile c f24210b;

    /* renamed from: a, reason: collision with root package name */
    private final a f24211a;

    public static c a(Context context) {
        if (f24210b == null) {
            synchronized (c.class) {
                try {
                    if (f24210b == null) {
                        f24210b = new c(context);
                    }
                } finally {
                }
            }
        }
        return f24210b;
    }

    public void b() {
        this.f24211a.c();
    }

    private c(@NonNull Context context) {
        this.f24211a = new a(context);
    }
}
