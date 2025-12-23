package com.amap.api.col.p0003l;

import com.amap.api.col.p0003l.z7;
import java.lang.Thread;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a8 extends c8 {

    /* renamed from: d, reason: collision with root package name */
    private static Thread.UncaughtExceptionHandler f5633d = new a();

    /* renamed from: e, reason: collision with root package name */
    private static a8 f5634e = new a8(new z7.b().d(f5633d).c("amap-global-threadPool").h());

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Thread.UncaughtExceptionHandler {
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(Thread thread, Throwable th) {
            v5.p(th, "TPool", "ThreadPool");
        }

        a() {
        }
    }

    public static a8 h() {
        return f5634e;
    }

    public static a8 i(z7 z7Var) {
        return new a8(z7Var);
    }

    @Deprecated
    public static synchronized a8 j() {
        a8 a8Var;
        synchronized (a8.class) {
            try {
                if (f5634e == null) {
                    f5634e = new a8(new z7.b().d(f5633d).h());
                }
                a8Var = f5634e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return a8Var;
    }

    @Deprecated
    public static a8 k() {
        return new a8(new z7.b().d(f5633d).h());
    }

    private a8(z7 z7Var) {
        try {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(z7Var.a(), z7Var.b(), z7Var.d(), TimeUnit.SECONDS, z7Var.c(), z7Var);
            this.f5858a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Throwable th) {
            v5.p(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }
}
