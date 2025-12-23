package com.huawei.agconnect;

import android.content.Context;

@Deprecated
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class c {
    public abstract void e(String str);

    public abstract void f(String str);

    public abstract void g(String str);

    public abstract void h(String str);

    public abstract void i(String str);

    public abstract void j(g gVar);

    public abstract void k(h hVar);

    public abstract void l(String str, String str2);

    public abstract void m(String str);

    public static c a() {
        return com.huawei.agconnect.config.impl.c.n();
    }

    private static c b(String str) {
        return com.huawei.agconnect.config.impl.c.q(str);
    }

    public static c c(Context context) {
        return com.huawei.agconnect.config.impl.c.o(context);
    }

    private static c d(Context context, String str) {
        return com.huawei.agconnect.config.impl.c.p(context, str);
    }
}
