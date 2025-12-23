package rx.internal.schedulers;

import androidx.camera.view.p;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.h;
import rx.internal.util.RxThreadFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a extends rx.h implements j {

    /* renamed from: c, reason: collision with root package name */
    private static final long f53967c;

    /* renamed from: d, reason: collision with root package name */
    private static final TimeUnit f53968d = TimeUnit.SECONDS;

    /* renamed from: e, reason: collision with root package name */
    static final c f53969e;

    /* renamed from: f, reason: collision with root package name */
    static final C1060a f53970f;

    /* renamed from: a, reason: collision with root package name */
    final ThreadFactory f53971a;

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference<C1060a> f53972b = new AtomicReference<>(f53970f);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: rx.internal.schedulers.a$a, reason: collision with other inner class name */
    static final class C1060a {

        /* renamed from: a, reason: collision with root package name */
        private final ThreadFactory f53973a;

        /* renamed from: b, reason: collision with root package name */
        private final long f53974b;

        /* renamed from: c, reason: collision with root package name */
        private final ConcurrentLinkedQueue<c> f53975c;

        /* renamed from: d, reason: collision with root package name */
        private final rx.subscriptions.b f53976d;

        /* renamed from: e, reason: collision with root package name */
        private final ScheduledExecutorService f53977e;

        /* renamed from: f, reason: collision with root package name */
        private final Future<?> f53978f;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.schedulers.a$a$a, reason: collision with other inner class name */
        class ThreadFactoryC1061a implements ThreadFactory {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ThreadFactory f53979a;

            ThreadFactoryC1061a(ThreadFactory threadFactory) {
                this.f53979a = threadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread newThread = this.f53979a.newThread(runnable);
                newThread.setName(newThread.getName() + " (Evictor)");
                return newThread;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.schedulers.a$a$b */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C1060a.this.a();
            }
        }

        void a() {
            if (this.f53975c.isEmpty()) {
                return;
            }
            long c6 = c();
            Iterator<c> it = this.f53975c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.P() > c6) {
                    return;
                }
                if (this.f53975c.remove(next)) {
                    this.f53976d.f(next);
                }
            }
        }

        c b() {
            if (this.f53976d.isUnsubscribed()) {
                return a.f53969e;
            }
            while (!this.f53975c.isEmpty()) {
                c poll = this.f53975c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.f53973a);
            this.f53976d.a(cVar);
            return cVar;
        }

        void e() {
            try {
                Future<?> future = this.f53978f;
                if (future != null) {
                    future.cancel(true);
                }
                ScheduledExecutorService scheduledExecutorService = this.f53977e;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                }
                this.f53976d.unsubscribe();
            } catch (Throwable th) {
                this.f53976d.unsubscribe();
                throw th;
            }
        }

        C1060a(ThreadFactory threadFactory, long j6, TimeUnit timeUnit) {
            long j7;
            ScheduledExecutorService scheduledExecutorService;
            ScheduledFuture<?> scheduledFuture;
            this.f53973a = threadFactory;
            if (timeUnit != null) {
                j7 = timeUnit.toNanos(j6);
            } else {
                j7 = 0;
            }
            long j8 = j7;
            this.f53974b = j8;
            this.f53975c = new ConcurrentLinkedQueue<>();
            this.f53976d = new rx.subscriptions.b();
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactoryC1061a(threadFactory));
                h.N(scheduledExecutorService);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(new b(), j8, j8, TimeUnit.NANOSECONDS);
            } else {
                scheduledExecutorService = null;
                scheduledFuture = null;
            }
            this.f53977e = scheduledExecutorService;
            this.f53978f = scheduledFuture;
        }

        long c() {
            return System.nanoTime();
        }

        void d(c cVar) {
            cVar.Q(c() + this.f53974b);
            this.f53975c.offer(cVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b extends h.a implements rx.functions.a {

        /* renamed from: b, reason: collision with root package name */
        private final C1060a f53983b;

        /* renamed from: c, reason: collision with root package name */
        private final c f53984c;

        /* renamed from: a, reason: collision with root package name */
        private final rx.subscriptions.b f53982a = new rx.subscriptions.b();

        /* renamed from: d, reason: collision with root package name */
        final AtomicBoolean f53985d = new AtomicBoolean();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.schedulers.a$b$a, reason: collision with other inner class name */
        class C1062a implements rx.functions.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ rx.functions.a f53986a;

            C1062a(rx.functions.a aVar) {
                this.f53986a = aVar;
            }

            @Override // rx.functions.a
            public void call() {
                if (b.this.isUnsubscribed()) {
                    return;
                }
                this.f53986a.call();
            }
        }

        @Override // rx.functions.a
        public void call() {
            this.f53983b.d(this.f53984c);
        }

        @Override // rx.h.a
        public rx.m d(rx.functions.a aVar) {
            return e(aVar, 0L, null);
        }

        @Override // rx.h.a
        public rx.m e(rx.functions.a aVar, long j6, TimeUnit timeUnit) {
            if (this.f53982a.isUnsubscribed()) {
                return rx.subscriptions.f.e();
            }
            ScheduledAction B = this.f53984c.B(new C1062a(aVar), j6, timeUnit);
            this.f53982a.a(B);
            B.addParent(this.f53982a);
            return B;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f53982a.isUnsubscribed();
        }

        @Override // rx.m
        public void unsubscribe() {
            if (this.f53985d.compareAndSet(false, true)) {
                this.f53984c.d(this);
            }
            this.f53982a.unsubscribe();
        }

        b(C1060a c1060a) {
            this.f53983b = c1060a;
            this.f53984c = c1060a.b();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c extends h {

        /* renamed from: l, reason: collision with root package name */
        private long f53988l;

        public long P() {
            return this.f53988l;
        }

        public void Q(long j6) {
            this.f53988l = j6;
        }

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f53988l = 0L;
        }
    }

    static {
        c cVar = new c(RxThreadFactory.NONE);
        f53969e = cVar;
        cVar.unsubscribe();
        C1060a c1060a = new C1060a(null, 0L, null);
        f53970f = c1060a;
        c1060a.e();
        f53967c = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    @Override // rx.h
    public h.a a() {
        return new b(this.f53972b.get());
    }

    @Override // rx.internal.schedulers.j
    public void shutdown() {
        C1060a c1060a;
        C1060a c1060a2;
        do {
            c1060a = this.f53972b.get();
            c1060a2 = f53970f;
            if (c1060a == c1060a2) {
                return;
            }
        } while (!p.a(this.f53972b, c1060a, c1060a2));
        c1060a.e();
    }

    @Override // rx.internal.schedulers.j
    public void start() {
        C1060a c1060a = new C1060a(this.f53971a, f53967c, f53968d);
        if (p.a(this.f53972b, f53970f, c1060a)) {
            return;
        }
        c1060a.e();
    }

    public a(ThreadFactory threadFactory) {
        this.f53971a = threadFactory;
        start();
    }
}
