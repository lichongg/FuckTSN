package cn.jiguang.bb;

import android.content.Context;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d {
    public static synchronized void a(Context context) {
        synchronized (d.class) {
            cn.jiguang.e.c.a(context, 1);
            f.c("LogRefManager", "Log reference count increased to: 1");
        }
    }

    public static synchronized void b(Context context) {
        synchronized (d.class) {
            int c6 = cn.jiguang.e.c.c(context);
            if (c6 > 0) {
                int i6 = c6 - 1;
                cn.jiguang.e.c.a(context, i6);
                f.c("LogRefManager", "Log reference count decreased to: " + i6);
            }
        }
    }

    public static synchronized boolean c(Context context) {
        boolean z5;
        synchronized (d.class) {
            z5 = cn.jiguang.e.c.c(context) == 0;
            f.c("LogRefManager", "Can clear log: " + z5);
        }
        return z5;
    }
}
