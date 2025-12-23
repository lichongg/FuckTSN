package com.volcengine.mobsecBiz.metasec.ml;

import android.content.Context;
import com.volcengine.mobsecBiz.matrix.pgla;
import ms.bz.bd.c.Pgl.m0;
import ms.bz.bd.c.Pgl.n0;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\Downloads\app\classes7.dex */
public final class c {
    public static synchronized b a(String str) {
        b bVar;
        synchronized (c.class) {
            m0 e6 = n0.e(str);
            bVar = e6 != null ? new b(e6) : null;
        }
        return bVar;
    }

    public static synchronized boolean b(Context context, a aVar) {
        boolean d6;
        synchronized (c.class) {
            d6 = n0.d(context, aVar.b());
        }
        return d6;
    }

    public static synchronized void c(String str) {
        synchronized (c.class) {
            n0.c(str);
        }
    }

    public static void d() {
        int i6 = n0.f50312d;
        int i7 = pbly.f50381b;
        pgla.a(67108868, 0, 0L, null, null);
    }

    public static void e() {
        int i6 = n0.f50312d;
        int i7 = pbly.f50381b;
        pgla.a(67108869, 0, 0L, null, null);
    }

    public static String f() {
        int i6 = n0.f50312d;
        int i7 = pbly.f50381b;
        return (String) pgla.a(67108867, 0, 0L, null, null);
    }

    private c() {
    }
}
