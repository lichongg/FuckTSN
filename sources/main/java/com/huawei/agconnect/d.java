package com.huawei.agconnect;

import android.content.Context;

/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class d {
    public abstract e d();

    public abstract <T> T e(Class<? super T> cls);

    public abstract Context getContext();

    public abstract String getIdentifier();

    public static synchronized void f(Context context) {
        synchronized (d.class) {
            com.huawei.agconnect.core.a.b.l(context);
        }
    }

    public static synchronized void g(Context context, f fVar) {
        synchronized (d.class) {
            com.huawei.agconnect.core.a.b.n(context, fVar);
        }
    }

    public static d a(e eVar) {
        return com.huawei.agconnect.core.a.b.i(eVar);
    }

    public static d b() {
        return com.huawei.agconnect.core.a.b.h();
    }

    public static d c(String str) {
        return com.huawei.agconnect.core.a.b.k(str);
    }
}
