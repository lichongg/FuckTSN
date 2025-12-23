package com.amap.api.col.s;

import com.amap.api.col.s.z3;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class a4 {

    /* renamed from: a, reason: collision with root package name */
    protected ThreadPoolExecutor f7869a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<z3, Future<?>> f7870b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    protected z3.a f7871c = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements z3.a {
        a() {
        }

        @Override // com.amap.api.col.s.z3.a
        public final void a(z3 z3Var) {
            a4.this.a(z3Var);
        }
    }

    private synchronized void b(z3 z3Var, Future<?> future) {
        try {
            this.f7870b.put(z3Var, future);
        } catch (Throwable th) {
            g2.o(th, "TPool", "addQueue");
            th.printStackTrace();
        }
    }

    private synchronized boolean d(z3 z3Var) {
        boolean z5;
        try {
            z5 = this.f7870b.containsKey(z3Var);
        } catch (Throwable th) {
            g2.o(th, "TPool", "contain");
            th.printStackTrace();
            z5 = false;
        }
        return z5;
    }

    protected final synchronized void a(z3 z3Var) {
        try {
            this.f7870b.remove(z3Var);
        } catch (Throwable th) {
            g2.o(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
    }

    public final void c(z3 z3Var) {
        ThreadPoolExecutor threadPoolExecutor;
        if (!d(z3Var) && (threadPoolExecutor = this.f7869a) != null && !threadPoolExecutor.isShutdown()) {
            z3Var.f8784a = this.f7871c;
            try {
                Future<?> submit = this.f7869a.submit(z3Var);
                if (submit != null) {
                    b(z3Var, submit);
                }
            } catch (RejectedExecutionException e6) {
                g2.o(e6, "TPool", "addTask");
            }
        }
    }
}
