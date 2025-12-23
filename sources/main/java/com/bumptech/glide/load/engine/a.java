package com.bumptech.glide.load.engine;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.p;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f14992a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f14993b;

    /* renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    final Map<com.bumptech.glide.load.c, d> f14994c;

    /* renamed from: d, reason: collision with root package name */
    private final ReferenceQueue<p<?>> f14995d;

    /* renamed from: e, reason: collision with root package name */
    private p.a f14996e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f14997f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private volatile c f14998g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bumptech.glide.load.engine.a$a, reason: collision with other inner class name */
    class ThreadFactoryC0151a implements ThreadFactory {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bumptech.glide.load.engine.a$a$a, reason: collision with other inner class name */
        class RunnableC0152a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Runnable f14999a;

            RunnableC0152a(Runnable runnable) {
                this.f14999a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.f14999a.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(new RunnableC0152a(runnable), "glide-active-resources");
        }

        ThreadFactoryC0151a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    interface c {
        void a();
    }

    a(boolean z5) {
        this(z5, Executors.newSingleThreadExecutor(new ThreadFactoryC0151a()));
    }

    synchronized void a(com.bumptech.glide.load.c cVar, p<?> pVar) {
        d put = this.f14994c.put(cVar, new d(cVar, pVar, this.f14995d, this.f14992a));
        if (put != null) {
            put.a();
        }
    }

    void c(@NonNull d dVar) {
        u<?> uVar;
        synchronized (this) {
            this.f14994c.remove(dVar.f15002a);
            if (dVar.f15003b && (uVar = dVar.f15004c) != null) {
                this.f14996e.c(dVar.f15002a, new p<>(uVar, true, false, dVar.f15002a, this.f14996e));
            }
        }
    }

    synchronized void d(com.bumptech.glide.load.c cVar) {
        d remove = this.f14994c.remove(cVar);
        if (remove != null) {
            remove.a();
        }
    }

    @Nullable
    synchronized p<?> e(com.bumptech.glide.load.c cVar) {
        d dVar = this.f14994c.get(cVar);
        if (dVar == null) {
            return null;
        }
        p<?> pVar = dVar.get();
        if (pVar == null) {
            c(dVar);
        }
        return pVar;
    }

    void g(p.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f14996e = aVar;
            }
        }
    }

    @VisibleForTesting
    void h() {
        this.f14997f = true;
        Executor executor = this.f14993b;
        if (executor instanceof ExecutorService) {
            com.bumptech.glide.util.e.c((ExecutorService) executor);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    static final class d extends WeakReference<p<?>> {

        /* renamed from: a, reason: collision with root package name */
        final com.bumptech.glide.load.c f15002a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f15003b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        u<?> f15004c;

        void a() {
            this.f15004c = null;
            clear();
        }

        d(@NonNull com.bumptech.glide.load.c cVar, @NonNull p<?> pVar, @NonNull ReferenceQueue<? super p<?>> referenceQueue, boolean z5) {
            super(pVar, referenceQueue);
            u<?> uVar;
            this.f15002a = (com.bumptech.glide.load.c) com.bumptech.glide.util.k.d(cVar);
            if (pVar.d() && z5) {
                uVar = (u) com.bumptech.glide.util.k.d(pVar.c());
            } else {
                uVar = null;
            }
            this.f15004c = uVar;
            this.f15003b = pVar.d();
        }
    }

    void b() {
        while (!this.f14997f) {
            try {
                c((d) this.f14995d.remove());
                c cVar = this.f14998g;
                if (cVar != null) {
                    cVar.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @VisibleForTesting
    void f(c cVar) {
        this.f14998g = cVar;
    }

    @VisibleForTesting
    a(boolean z5, Executor executor) {
        this.f14994c = new HashMap();
        this.f14995d = new ReferenceQueue<>();
        this.f14992a = z5;
        this.f14993b = executor;
        executor.execute(new b());
    }
}
