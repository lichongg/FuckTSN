package com.amap.api.col.p0003l;

import com.amap.api.col.p0003l.b8;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class c8 {

    /* renamed from: a, reason: collision with root package name */
    protected ThreadPoolExecutor f5858a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<b8, Future<?>> f5859b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    protected b8.a f5860c = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements b8.a {
        a() {
        }

        @Override // com.amap.api.col.3l.b8.a
        public final void a(b8 b8Var) {
            c8.this.d(b8Var, true);
        }

        @Override // com.amap.api.col.3l.b8.a
        public final void b(b8 b8Var) {
            c8.this.d(b8Var, false);
        }
    }

    private synchronized void c(b8 b8Var, Future<?> future) {
        try {
            this.f5859b.put(b8Var, future);
        } catch (Throwable th) {
            v5.p(th, "TPool", "addQueue");
            th.printStackTrace();
        }
    }

    private synchronized boolean e(b8 b8Var) {
        boolean z5;
        try {
            z5 = this.f5859b.containsKey(b8Var);
        } catch (Throwable th) {
            v5.p(th, "TPool", "contain");
            th.printStackTrace();
            z5 = false;
        }
        return z5;
    }

    protected final synchronized void d(b8 b8Var, boolean z5) {
        try {
            Future<?> remove = this.f5859b.remove(b8Var);
            if (z5 && remove != null) {
                remove.cancel(true);
            }
        } catch (Throwable th) {
            v5.p(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
    }

    public final void a(long j6, TimeUnit timeUnit) {
        try {
            ThreadPoolExecutor threadPoolExecutor = this.f5858a;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.awaitTermination(j6, timeUnit);
            }
        } catch (InterruptedException unused) {
        }
    }

    public final Executor f() {
        return this.f5858a;
    }

    public final void g() {
        try {
            Iterator<Map.Entry<b8, Future<?>>> it = this.f5859b.entrySet().iterator();
            while (it.hasNext()) {
                Future<?> future = this.f5859b.get(it.next().getKey());
                if (future != null) {
                    try {
                        future.cancel(true);
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            }
            this.f5859b.clear();
        } catch (Throwable th) {
            v5.p(th, "TPool", "destroy");
            th.printStackTrace();
        }
        ThreadPoolExecutor threadPoolExecutor = this.f5858a;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
        }
    }

    public final void b(b8 b8Var) {
        ThreadPoolExecutor threadPoolExecutor;
        if (!e(b8Var) && (threadPoolExecutor = this.f5858a) != null && !threadPoolExecutor.isShutdown()) {
            b8Var.f5730f = this.f5860c;
            try {
                Future<?> submit = this.f5858a.submit(b8Var);
                if (submit != null) {
                    c(b8Var, submit);
                }
            } catch (RejectedExecutionException e6) {
                v5.p(e6, "TPool", "addTask");
            }
        }
    }
}
