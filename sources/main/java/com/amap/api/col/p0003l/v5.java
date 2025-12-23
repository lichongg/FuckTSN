package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Looper;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.stub.StubApp;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class v5 extends r5 implements Thread.UncaughtExceptionHandler {

    /* renamed from: e, reason: collision with root package name */
    private static ExecutorService f7466e;

    /* renamed from: g, reason: collision with root package name */
    private static WeakReference<Context> f7468g;

    /* renamed from: d, reason: collision with root package name */
    private Context f7470d;

    /* renamed from: f, reason: collision with root package name */
    private static Set<Integer> f7467f = Collections.synchronizedSet(new HashSet());

    /* renamed from: h, reason: collision with root package name */
    private static final ThreadFactory f7469h = new b();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends b8 {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ p4 f7471d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f7472e;

        a(p4 p4Var, boolean z5) {
            this.f7471d = p4Var;
            this.f7472e = z5;
        }

        @Override // com.amap.api.col.p0003l.b8
        public final void runTask() {
            try {
                synchronized (Looper.getMainLooper()) {
                    s5.e(this.f7471d);
                }
                if (this.f7472e) {
                    w5.e(v5.this.f7470d);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f7474a = new AtomicInteger(1);

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
            return new a(runnable, "pama#" + this.f7474a.getAndIncrement());
        }

        b() {
        }
    }

    public static void i(Context context, p4 p4Var, String str, String str2, String str3) {
        w5.g(context, p4Var, str, 0, str2, str3);
    }

    public static void n(Context context, p4 p4Var, String str, String str2, String str3) {
        w5.g(context, p4Var, str, 1, str2, str3);
    }

    public static synchronized v5 g(Context context, p4 p4Var) throws fk {
        synchronized (v5.class) {
            if (p4Var == null) {
                throw new fk("sdk info is null");
            }
            if (p4Var.a() == null || "".equals(p4Var.a())) {
                throw new fk("sdk name is invalid");
            }
            try {
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (!f7467f.add(Integer.valueOf(p4Var.hashCode()))) {
                return (v5) r5.f7180c;
            }
            r5 r5Var = r5.f7180c;
            if (r5Var == null) {
                r5.f7180c = new v5(context);
            } else {
                r5Var.f7182b = false;
            }
            r5 r5Var2 = r5.f7180c;
            r5Var2.c(p4Var, r5Var2.f7182b);
            return (v5) r5.f7180c;
        }
    }

    public static void h(Context context) {
        if (context == null) {
            return;
        }
        try {
            f7468g = new WeakReference<>(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        } catch (Throwable unused) {
        }
    }

    public static void j(p4 p4Var, String str, fk fkVar) {
        if (fkVar != null) {
            l(p4Var, str, fkVar.c(), fkVar.d(), fkVar.e(), fkVar.b());
        }
    }

    public static void k(p4 p4Var, String str, String str2, String str3, String str4) {
        l(p4Var, str, str2, str3, "", str4);
    }

    public static void l(p4 p4Var, String str, String str2, String str3, String str4, String str5) {
        try {
            if (r5.f7180c != null) {
                r5.f7180c.b(p4Var, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",csid:" + str4 + ",code:" + str5, SplashMonitorInfo.ERROR_NET_MSG);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018 A[Catch: all -> 0x0028, TryCatch #1 {all -> 0x0028, blocks: (B:9:0x0014, B:11:0x0018, B:13:0x0020, B:15:0x0024, B:16:0x002a), top: B:8:0x0014, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void m() {
        /*
            java.lang.Class<com.amap.api.col.3l.v5> r0 = com.amap.api.col.p0003l.v5.class
            monitor-enter(r0)
            java.util.concurrent.ExecutorService r1 = com.amap.api.col.p0003l.v5.f7466e     // Catch: java.lang.Throwable -> Lb
            if (r1 == 0) goto Ld
            r1.shutdown()     // Catch: java.lang.Throwable -> Lb
            goto Ld
        Lb:
            r1 = move-exception
            goto L11
        Ld:
            com.amap.api.col.p0003l.o6.d()     // Catch: java.lang.Throwable -> Lb
            goto L14
        L11:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L34
        L14:
            com.amap.api.col.3l.r5 r1 = com.amap.api.col.p0003l.r5.f7180c     // Catch: java.lang.Throwable -> L28
            if (r1 == 0) goto L2a
            java.lang.Thread$UncaughtExceptionHandler r1 = java.lang.Thread.getDefaultUncaughtExceptionHandler()     // Catch: java.lang.Throwable -> L28
            com.amap.api.col.3l.r5 r2 = com.amap.api.col.p0003l.r5.f7180c     // Catch: java.lang.Throwable -> L28
            if (r1 != r2) goto L2a
            java.lang.Thread$UncaughtExceptionHandler r1 = r2.f7181a     // Catch: java.lang.Throwable -> L28
            if (r1 == 0) goto L2a
            java.lang.Thread.setDefaultUncaughtExceptionHandler(r1)     // Catch: java.lang.Throwable -> L28
            goto L2a
        L28:
            r1 = move-exception
            goto L2f
        L2a:
            r1 = 0
            com.amap.api.col.p0003l.r5.f7180c = r1     // Catch: java.lang.Throwable -> L28
            monitor-exit(r0)
            return
        L2f:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L34
            monitor-exit(r0)
            return
        L34:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L34
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.v5.m():void");
    }

    public static void o(p4 p4Var, String str, String str2) {
        try {
            r5 r5Var = r5.f7180c;
            if (r5Var != null) {
                r5Var.b(p4Var, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void p(Throwable th, String str, String str2) {
        try {
            r5 r5Var = r5.f7180c;
            if (r5Var != null) {
                r5Var.d(th, 1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void q() {
        WeakReference<Context> weakReference = f7468g;
        if (weakReference != null && weakReference.get() != null) {
            s5.c(f7468g.get());
            return;
        }
        r5 r5Var = r5.f7180c;
        if (r5Var != null) {
            r5Var.a();
        }
    }

    @Deprecated
    public static synchronized ExecutorService r() {
        ExecutorService executorService;
        synchronized (v5.class) {
            try {
                ExecutorService executorService2 = f7466e;
                if (executorService2 == null || executorService2.isShutdown()) {
                    f7466e = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(256), f7469h);
                }
            } catch (Throwable unused) {
            }
            executorService = f7466e;
        }
        return executorService;
    }

    @Override // com.amap.api.col.p0003l.r5
    protected final void a() {
        s5.c(this.f7470d);
    }

    @Override // com.amap.api.col.p0003l.r5
    protected final void b(p4 p4Var, String str, String str2) {
        w5.l(p4Var, this.f7470d, str2, str);
    }

    @Override // com.amap.api.col.p0003l.r5
    protected final void d(Throwable th, int i6, String str, String str2) {
        w5.k(this.f7470d, th, i6, str, str2);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        if (th == null) {
            return;
        }
        d(th, 0, null, null);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f7181a;
        if (uncaughtExceptionHandler != null) {
            try {
                Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
            } catch (Throwable unused) {
            }
            this.f7181a.uncaughtException(thread, th);
        }
    }

    private v5(Context context) {
        this.f7470d = context;
        try {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            this.f7181a = defaultUncaughtExceptionHandler;
            if (defaultUncaughtExceptionHandler == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f7182b = true;
                return;
            }
            String obj = defaultUncaughtExceptionHandler.toString();
            if (!obj.startsWith("com.amap.apis.utils.core.dynamiccore") && (obj.indexOf("com.amap.api") != -1 || obj.indexOf("com.loc") != -1)) {
                this.f7182b = false;
            } else {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f7182b = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.p0003l.r5
    protected final void c(p4 p4Var, boolean z5) {
        try {
            a8.h().b(new a(p4Var, z5));
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
