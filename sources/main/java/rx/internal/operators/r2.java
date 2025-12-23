package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.e;
import rx.internal.util.BackpressureDrainManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class r2<T> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    private final Long f53439a;

    /* renamed from: b, reason: collision with root package name */
    private final rx.functions.a f53440b;

    /* renamed from: c, reason: collision with root package name */
    private final a.d f53441c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.l<T> implements BackpressureDrainManager.a {

        /* renamed from: b, reason: collision with root package name */
        private final AtomicLong f53443b;

        /* renamed from: c, reason: collision with root package name */
        private final rx.l<? super T> f53444c;

        /* renamed from: e, reason: collision with root package name */
        private final BackpressureDrainManager f53446e;

        /* renamed from: f, reason: collision with root package name */
        private final rx.functions.a f53447f;

        /* renamed from: g, reason: collision with root package name */
        private final a.d f53448g;

        /* renamed from: a, reason: collision with root package name */
        private final ConcurrentLinkedQueue<Object> f53442a = new ConcurrentLinkedQueue<>();

        /* renamed from: d, reason: collision with root package name */
        private final AtomicBoolean f53445d = new AtomicBoolean(false);

        /* JADX WARN: Removed duplicated region for block: B:17:0x0049 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private boolean g() {
            /*
                r6 = this;
                java.util.concurrent.atomic.AtomicLong r0 = r6.f53443b
                r1 = 1
                if (r0 != 0) goto L6
                return r1
            L6:
                java.util.concurrent.atomic.AtomicLong r0 = r6.f53443b
                long r2 = r0.get()
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 > 0) goto L4a
                r0 = 0
                rx.a$d r4 = r6.f53448g     // Catch: rx.exceptions.MissingBackpressureException -> L23
                boolean r4 = r4.a()     // Catch: rx.exceptions.MissingBackpressureException -> L23
                if (r4 == 0) goto L34
                java.lang.Object r4 = r6.poll()     // Catch: rx.exceptions.MissingBackpressureException -> L23
                if (r4 == 0) goto L34
                r4 = 1
                goto L35
            L23:
                r4 = move-exception
                java.util.concurrent.atomic.AtomicBoolean r5 = r6.f53445d
                boolean r5 = r5.compareAndSet(r0, r1)
                if (r5 == 0) goto L34
                r6.unsubscribe()
                rx.l<? super T> r5 = r6.f53444c
                r5.onError(r4)
            L34:
                r4 = 0
            L35:
                rx.functions.a r5 = r6.f53447f
                if (r5 == 0) goto L47
                r5.call()     // Catch: java.lang.Throwable -> L3d
                goto L47
            L3d:
                r1 = move-exception
                rx.exceptions.a.e(r1)
                rx.internal.util.BackpressureDrainManager r2 = r6.f53446e
                r2.terminateAndDrain(r1)
                return r0
            L47:
                if (r4 != 0) goto L4a
                return r0
            L4a:
                java.util.concurrent.atomic.AtomicLong r0 = r6.f53443b
                r4 = 1
                long r4 = r2 - r4
                boolean r0 = r0.compareAndSet(r2, r4)
                if (r0 == 0) goto L6
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.r2.a.g():boolean");
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean accept(Object obj) {
            return v.a(this.f53444c, obj);
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void e(Throwable th) {
            if (th != null) {
                this.f53444c.onError(th);
            } else {
                this.f53444c.onCompleted();
            }
        }

        protected rx.g j() {
            return this.f53446e;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f53445d.get()) {
                return;
            }
            this.f53446e.terminateAndDrain();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f53445d.get()) {
                return;
            }
            this.f53446e.terminateAndDrain(th);
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            return this.f53442a.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.f53442a.poll();
            AtomicLong atomicLong = this.f53443b;
            if (atomicLong != null && poll != null) {
                atomicLong.incrementAndGet();
            }
            return poll;
        }

        public a(rx.l<? super T> lVar, Long l6, rx.functions.a aVar, a.d dVar) {
            AtomicLong atomicLong;
            this.f53444c = lVar;
            if (l6 != null) {
                atomicLong = new AtomicLong(l6.longValue());
            } else {
                atomicLong = null;
            }
            this.f53443b = atomicLong;
            this.f53447f = aVar;
            this.f53446e = new BackpressureDrainManager(this);
            this.f53448g = dVar;
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (!g()) {
                return;
            }
            this.f53442a.offer(v.j(t5));
            this.f53446e.drain();
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    r2() {
        this.f53439a = null;
        this.f53440b = null;
        this.f53441c = rx.a.f52236b;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        static final r2<?> f53449a = new r2<>();

        b() {
        }
    }

    public static <T> r2<T> a() {
        return (r2<T>) b.f53449a;
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        a aVar = new a(lVar, this.f53439a, this.f53440b, this.f53441c);
        lVar.add(aVar);
        lVar.setProducer(aVar.j());
        return aVar;
    }

    public r2(long j6) {
        this(j6, null, rx.a.f52236b);
    }

    public r2(long j6, rx.functions.a aVar) {
        this(j6, aVar, rx.a.f52236b);
    }

    public r2(long j6, rx.functions.a aVar, a.d dVar) {
        if (j6 <= 0) {
            throw new IllegalArgumentException("Buffer capacity must be > 0");
        }
        if (dVar != null) {
            this.f53439a = Long.valueOf(j6);
            this.f53440b = aVar;
            this.f53441c = dVar;
            return;
        }
        throw new NullPointerException("The BackpressureOverflow strategy must not be null");
    }
}
