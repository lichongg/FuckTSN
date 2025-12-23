package rx.internal.schedulers;

import androidx.camera.view.p;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.h;
import rx.internal.util.RxThreadFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b extends rx.h implements j {

    /* renamed from: c, reason: collision with root package name */
    static final String f53989c = "rx.scheduler.max-computation-threads";

    /* renamed from: d, reason: collision with root package name */
    static final int f53990d;

    /* renamed from: e, reason: collision with root package name */
    static final c f53991e;

    /* renamed from: f, reason: collision with root package name */
    static final C1065b f53992f;

    /* renamed from: a, reason: collision with root package name */
    final ThreadFactory f53993a;

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference<C1065b> f53994b = new AtomicReference<>(f53992f);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends h.a {

        /* renamed from: a, reason: collision with root package name */
        private final rx.internal.util.m f53995a;

        /* renamed from: b, reason: collision with root package name */
        private final rx.subscriptions.b f53996b;

        /* renamed from: c, reason: collision with root package name */
        private final rx.internal.util.m f53997c;

        /* renamed from: d, reason: collision with root package name */
        private final c f53998d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.schedulers.b$a$a, reason: collision with other inner class name */
        class C1063a implements rx.functions.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ rx.functions.a f53999a;

            C1063a(rx.functions.a aVar) {
                this.f53999a = aVar;
            }

            @Override // rx.functions.a
            public void call() {
                if (a.this.isUnsubscribed()) {
                    return;
                }
                this.f53999a.call();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.schedulers.b$a$b, reason: collision with other inner class name */
        class C1064b implements rx.functions.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ rx.functions.a f54001a;

            C1064b(rx.functions.a aVar) {
                this.f54001a = aVar;
            }

            @Override // rx.functions.a
            public void call() {
                if (a.this.isUnsubscribed()) {
                    return;
                }
                this.f54001a.call();
            }
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f53997c.isUnsubscribed();
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f53997c.unsubscribe();
        }

        a(c cVar) {
            rx.internal.util.m mVar = new rx.internal.util.m();
            this.f53995a = mVar;
            rx.subscriptions.b bVar = new rx.subscriptions.b();
            this.f53996b = bVar;
            this.f53997c = new rx.internal.util.m(mVar, bVar);
            this.f53998d = cVar;
        }

        @Override // rx.h.a
        public rx.m d(rx.functions.a aVar) {
            if (isUnsubscribed()) {
                return rx.subscriptions.f.e();
            }
            return this.f53998d.G(new C1063a(aVar), 0L, null, this.f53995a);
        }

        @Override // rx.h.a
        public rx.m e(rx.functions.a aVar, long j6, TimeUnit timeUnit) {
            if (isUnsubscribed()) {
                return rx.subscriptions.f.e();
            }
            return this.f53998d.H(new C1064b(aVar), j6, timeUnit, this.f53996b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: rx.internal.schedulers.b$b, reason: collision with other inner class name */
    static final class C1065b {

        /* renamed from: a, reason: collision with root package name */
        final int f54003a;

        /* renamed from: b, reason: collision with root package name */
        final c[] f54004b;

        /* renamed from: c, reason: collision with root package name */
        long f54005c;

        public c a() {
            int i6 = this.f54003a;
            if (i6 == 0) {
                return b.f53991e;
            }
            c[] cVarArr = this.f54004b;
            long j6 = this.f54005c;
            this.f54005c = 1 + j6;
            return cVarArr[(int) (j6 % i6)];
        }

        public void b() {
            for (c cVar : this.f54004b) {
                cVar.unsubscribe();
            }
        }

        C1065b(ThreadFactory threadFactory, int i6) {
            this.f54003a = i6;
            this.f54004b = new c[i6];
            for (int i7 = 0; i7 < i6; i7++) {
                this.f54004b[i7] = new c(threadFactory);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c extends h {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        int intValue = Integer.getInteger(f53989c, 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        f53990d = intValue;
        c cVar = new c(RxThreadFactory.NONE);
        f53991e = cVar;
        cVar.unsubscribe();
        f53992f = new C1065b(null, 0);
    }

    @Override // rx.h
    public h.a a() {
        return new a(this.f53994b.get().a());
    }

    public rx.m e(rx.functions.a aVar) {
        return this.f53994b.get().a().B(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    @Override // rx.internal.schedulers.j
    public void shutdown() {
        C1065b c1065b;
        C1065b c1065b2;
        do {
            c1065b = this.f53994b.get();
            c1065b2 = f53992f;
            if (c1065b == c1065b2) {
                return;
            }
        } while (!p.a(this.f53994b, c1065b, c1065b2));
        c1065b.b();
    }

    @Override // rx.internal.schedulers.j
    public void start() {
        C1065b c1065b = new C1065b(this.f53993a, f53990d);
        if (p.a(this.f53994b, f53992f, c1065b)) {
            return;
        }
        c1065b.b();
    }

    public b(ThreadFactory threadFactory) {
        this.f53993a = threadFactory;
        start();
    }
}
