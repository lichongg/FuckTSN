package com.bytedance.j.xt.r;

import android.os.SystemClock;
import com.bytedance.j.xt.a;
import com.bytedance.j.xt.cw;
import com.bytedance.j.xt.e;
import com.bytedance.j.xt.tl.i;
import com.bytedance.j.xt.tl.o;
import com.bytedance.j.xt.up.j.f;
import com.bytedance.sdk.component.utils.vl;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class b implements Thread.UncaughtExceptionHandler {

    /* renamed from: e, reason: collision with root package name */
    private static b f24222e;

    /* renamed from: a, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f24223a;

    /* renamed from: c, reason: collision with root package name */
    private c f24225c;

    /* renamed from: b, reason: collision with root package name */
    private HashSet<Thread.UncaughtExceptionHandler> f24224b = new HashSet<>();

    /* renamed from: d, reason: collision with root package name */
    private long f24226d = -1;

    static class a extends com.bytedance.j.cw.j.xt.a {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f24227c;

        a(String str) {
            this.f24227c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.bytedance.j.xt.cw.b bVar = new com.bytedance.j.xt.cw.b();
                bVar.l("data", this.f24227c);
                bVar.l("userdefine", 1);
                com.bytedance.j.xt.cw.b a6 = f.c().a(cw.CUSTOM_JAVA, bVar);
                if (a6 != null) {
                    a.d.b().a(a6.k());
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void a(Thread thread, Throwable th) {
        try {
            Iterator<Thread.UncaughtExceptionHandler> it = this.f24224b.iterator();
            while (it.hasNext()) {
                try {
                    it.next().uncaughtException(thread, th);
                } catch (Throwable unused) {
                }
            }
            this.f24223a.uncaughtException(thread, th);
        } catch (Throwable unused2) {
        }
    }

    public static b b() {
        if (f24222e == null) {
            f24222e = new b();
        }
        return f24222e;
    }

    public static void d(String str) {
        if (str == null) {
            return;
        }
        com.bytedance.j.cw.j.xt.b.a().b(new a(str));
    }

    public void c(c cVar) {
        this.f24225c = cVar;
    }

    private b() {
        f();
    }

    private boolean e(Thread thread, Throwable th) {
        com.bytedance.j.xt.c f6 = e.l().f();
        if (f6 != null) {
            try {
                if (!f6.j(th, thread)) {
                    return false;
                }
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    private void f() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != this) {
            Thread.setDefaultUncaughtExceptionHandler(this);
            if (this.f24223a == null) {
                this.f24223a = defaultUncaughtExceptionHandler;
            } else {
                this.f24224b.add(defaultUncaughtExceptionHandler);
            }
        }
    }

    private void g(Thread thread, Throwable th) {
        List<Object> g6 = e.l().g();
        cw cwVar = cw.JAVA;
        Iterator<Object> it = g6.iterator();
        while (it.hasNext()) {
            it.next();
            try {
                o.b(th);
            } catch (Throwable th2) {
                i.c(th2);
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        c cVar;
        if (SystemClock.uptimeMillis() - this.f24226d < 20000) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.f24226d = SystemClock.uptimeMillis();
            boolean e6 = e(thread, th);
            if (!e6) {
                return;
            }
            cw cwVar = cw.JAVA;
            g(thread, th);
            if (e6 && (cVar = this.f24225c) != null && cVar.j(th)) {
                this.f24225c.a(currentTimeMillis, thread, th);
                vl.j("crash_dispatcher", "end dispose ".concat(String.valueOf(th)));
            }
        } catch (Throwable th2) {
            try {
                i.b(th2);
            } finally {
                a(thread, th);
            }
        }
    }
}
