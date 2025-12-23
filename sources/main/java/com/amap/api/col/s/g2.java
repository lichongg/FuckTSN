package com.amap.api.col.s;

import android.content.Context;
import android.os.Looper;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class g2 extends d2 implements Thread.UncaughtExceptionHandler {

    /* renamed from: f, reason: collision with root package name */
    private static WeakReference<Context> f8088f;

    /* renamed from: d, reason: collision with root package name */
    private Context f8090d;

    /* renamed from: e, reason: collision with root package name */
    private static Set<Integer> f8087e = Collections.synchronizedSet(new HashSet());

    /* renamed from: g, reason: collision with root package name */
    private static final ThreadFactory f8089g = new b();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends z3 {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ i1 f8091b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f8092c;

        a(i1 i1Var, boolean z5) {
            this.f8091b = i1Var;
            this.f8092c = z5;
        }

        @Override // com.amap.api.col.s.z3
        public final void a() {
            try {
                synchronized (Looper.getMainLooper()) {
                    e2.e(this.f8091b);
                }
                if (this.f8092c) {
                    h2.d(g2.this.f8090d);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f8094a = new AtomicInteger(1);

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        final class a extends Thread {
            a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                try {
                    super.run();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new a(runnable, "pama#" + this.f8094a.getAndIncrement());
        }

        b() {
        }
    }

    public static synchronized g2 g(Context context, i1 i1Var) throws bv {
        synchronized (g2.class) {
            if (i1Var == null) {
                throw new bv("sdk info is null");
            }
            if (i1Var.d() == null || "".equals(i1Var.d())) {
                throw new bv("sdk name is invalid");
            }
            try {
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (!f8087e.add(Integer.valueOf(i1Var.hashCode()))) {
                return (g2) d2.f7987c;
            }
            d2 d2Var = d2.f7987c;
            if (d2Var == null) {
                d2.f7987c = new g2(context);
            } else {
                d2Var.f7989b = false;
            }
            d2 d2Var2 = d2.f7987c;
            d2Var2.c(i1Var, d2Var2.f7989b);
            return (g2) d2.f7987c;
        }
    }

    public static void i(i1 i1Var, String str, String str2, String str3, String str4) {
        j(i1Var, str, str2, str3, "", str4);
    }

    public static void j(i1 i1Var, String str, String str2, String str3, String str4, String str5) {
        try {
            if (d2.f7987c != null) {
                d2.f7987c.b(i1Var, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",csid:" + str4 + ",code:" + str5, SplashMonitorInfo.ERROR_NET_MSG);
            }
        } catch (Throwable unused) {
        }
    }

    public static void k() {
        WeakReference<Context> weakReference = f8088f;
        if (weakReference != null && weakReference.get() != null) {
            e2.c(f8088f.get());
            return;
        }
        d2 d2Var = d2.f7987c;
        if (d2Var != null) {
            d2Var.a();
        }
    }

    public static void l(i1 i1Var, String str, String str2) {
        try {
            d2 d2Var = d2.f7987c;
            if (d2Var != null) {
                d2Var.b(i1Var, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized g2 n() {
        g2 g2Var;
        synchronized (g2.class) {
            g2Var = (g2) d2.f7987c;
        }
        return g2Var;
    }

    public static void o(Throwable th, String str, String str2) {
        try {
            d2 d2Var = d2.f7987c;
            if (d2Var != null) {
                d2Var.d(th, 1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.amap.api.col.s.d2
    protected final void a() {
        e2.c(this.f8090d);
    }

    @Override // com.amap.api.col.s.d2
    protected final void b(i1 i1Var, String str, String str2) {
        h2.h(i1Var, this.f8090d, str2, str);
    }

    @Override // com.amap.api.col.s.d2
    protected final void d(Throwable th, int i6, String str, String str2) {
        h2.g(this.f8090d, th, i6, str, str2);
    }

    public final void m(Throwable th, String str, String str2) {
        if (th == null) {
            return;
        }
        try {
            d(th, 1, str, str2);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        if (th == null) {
            return;
        }
        d(th, 0, null, null);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f7988a;
        if (uncaughtExceptionHandler != null) {
            try {
                Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
            } catch (Throwable unused) {
            }
            this.f7988a.uncaughtException(thread, th);
        }
    }

    private g2(Context context) {
        this.f8090d = context;
        try {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            this.f7988a = defaultUncaughtExceptionHandler;
            if (defaultUncaughtExceptionHandler == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f7989b = true;
                return;
            }
            String obj = defaultUncaughtExceptionHandler.toString();
            if (!obj.startsWith("com.amap.apis.utils.core.dynamiccore") && (obj.indexOf("com.amap.api") != -1 || obj.indexOf("com.loc") != -1)) {
                this.f7989b = false;
            } else {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f7989b = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void h(i1 i1Var, String str, bv bvVar) {
        j(i1Var, str, bvVar.c(), bvVar.d(), bvVar.e(), bvVar.b());
    }

    @Override // com.amap.api.col.s.d2
    protected final void c(i1 i1Var, boolean z5) {
        try {
            y3.e().c(new a(i1Var, z5));
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
