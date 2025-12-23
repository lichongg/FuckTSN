package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Emitter;
import rx.e;
import rx.exceptions.MissingBackpressureException;
import rx.internal.subscriptions.CancellableSubscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a0<T> implements e.a<T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.b<Emitter<T>> f52488a;

    /* renamed from: b, reason: collision with root package name */
    final Emitter.BackpressureMode f52489b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class b<T> extends AtomicLong implements Emitter<T>, rx.g, rx.m {
        private static final long serialVersionUID = 7326289992464377023L;

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super T> f52491a;

        /* renamed from: b, reason: collision with root package name */
        final rx.subscriptions.e f52492b = new rx.subscriptions.e();

        @Override // rx.Emitter
        public final void a(rx.functions.n nVar) {
            b(new CancellableSubscription(nVar));
        }

        @Override // rx.Emitter
        public final void b(rx.m mVar) {
            this.f52492b.b(mVar);
        }

        @Override // rx.m
        public final boolean isUnsubscribed() {
            return this.f52492b.isUnsubscribed();
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f52491a.isUnsubscribed()) {
                return;
            }
            try {
                this.f52491a.onCompleted();
            } finally {
                this.f52492b.unsubscribe();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f52491a.isUnsubscribed()) {
                return;
            }
            try {
                this.f52491a.onError(th);
            } finally {
                this.f52492b.unsubscribe();
            }
        }

        @Override // rx.m
        public final void unsubscribe() {
            this.f52492b.unsubscribe();
            e();
        }

        public b(rx.l<? super T> lVar) {
            this.f52491a = lVar;
        }

        @Override // rx.g
        public final void request(long j6) {
            if (rx.internal.operators.a.j(j6)) {
                rx.internal.operators.a.b(this, j6);
                d();
            }
        }

        @Override // rx.Emitter
        public final long requested() {
            return get();
        }

        void d() {
        }

        void e() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c<T> extends b<T> {
        private static final long serialVersionUID = 2427151001689639875L;

        /* renamed from: c, reason: collision with root package name */
        final Queue<Object> f52493c;

        /* renamed from: d, reason: collision with root package name */
        Throwable f52494d;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f52495e;

        /* renamed from: f, reason: collision with root package name */
        final AtomicInteger f52496f;

        @Override // rx.internal.operators.a0.b, rx.f
        public void onCompleted() {
            this.f52495e = true;
            f();
        }

        @Override // rx.internal.operators.a0.b
        void e() {
            if (this.f52496f.getAndIncrement() == 0) {
                this.f52493c.clear();
            }
        }

        void f() {
            if (this.f52496f.getAndIncrement() != 0) {
                return;
            }
            rx.l<? super T> lVar = this.f52491a;
            Queue<Object> queue = this.f52493c;
            int i6 = 1;
            do {
                long j6 = get();
                long j7 = 0;
                while (j7 != j6) {
                    if (lVar.isUnsubscribed()) {
                        queue.clear();
                        return;
                    }
                    boolean z5 = this.f52495e;
                    Object poll = queue.poll();
                    boolean z6 = poll == null;
                    if (z5 && z6) {
                        Throwable th = this.f52494d;
                        if (th != null) {
                            super.onError(th);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    }
                    if (z6) {
                        break;
                    }
                    lVar.onNext((Object) v.e(poll));
                    j7++;
                }
                if (j7 == j6) {
                    if (lVar.isUnsubscribed()) {
                        queue.clear();
                        return;
                    }
                    boolean z7 = this.f52495e;
                    boolean isEmpty = queue.isEmpty();
                    if (z7 && isEmpty) {
                        Throwable th2 = this.f52494d;
                        if (th2 != null) {
                            super.onError(th2);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    }
                }
                if (j7 != 0) {
                    rx.internal.operators.a.i(this, j7);
                }
                i6 = this.f52496f.addAndGet(-i6);
            } while (i6 != 0);
        }

        @Override // rx.internal.operators.a0.b, rx.f
        public void onError(Throwable th) {
            this.f52494d = th;
            this.f52495e = true;
            f();
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f52493c.offer(v.j(t5));
            f();
        }

        public c(rx.l<? super T> lVar, int i6) {
            super(lVar);
            Queue<Object> gVar;
            if (rx.internal.util.unsafe.n0.f()) {
                gVar = new rx.internal.util.unsafe.h0<>(i6);
            } else {
                gVar = new rx.internal.util.atomic.g<>(i6);
            }
            this.f52493c = gVar;
            this.f52496f = new AtomicInteger();
        }

        @Override // rx.internal.operators.a0.b
        void d() {
            f();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class e<T> extends g<T> {
        private static final long serialVersionUID = 338953216916120960L;

        /* renamed from: c, reason: collision with root package name */
        private boolean f52497c;

        @Override // rx.internal.operators.a0.g
        void f() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }

        @Override // rx.internal.operators.a0.b, rx.f
        public void onCompleted() {
            if (this.f52497c) {
                return;
            }
            this.f52497c = true;
            super.onCompleted();
        }

        @Override // rx.internal.operators.a0.b, rx.f
        public void onError(Throwable th) {
            if (this.f52497c) {
                rx.plugins.c.I(th);
            } else {
                this.f52497c = true;
                super.onError(th);
            }
        }

        @Override // rx.internal.operators.a0.g, rx.f
        public void onNext(T t5) {
            if (this.f52497c) {
                return;
            }
            super.onNext(t5);
        }

        public e(rx.l<? super T> lVar) {
            super(lVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class f<T> extends b<T> {
        private static final long serialVersionUID = 4023437720691792495L;

        /* renamed from: c, reason: collision with root package name */
        final AtomicReference<Object> f52498c;

        /* renamed from: d, reason: collision with root package name */
        Throwable f52499d;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f52500e;

        /* renamed from: f, reason: collision with root package name */
        final AtomicInteger f52501f;

        @Override // rx.internal.operators.a0.b, rx.f
        public void onCompleted() {
            this.f52500e = true;
            f();
        }

        @Override // rx.internal.operators.a0.b
        void e() {
            if (this.f52501f.getAndIncrement() == 0) {
                this.f52498c.lazySet(null);
            }
        }

        void f() {
            if (this.f52501f.getAndIncrement() != 0) {
                return;
            }
            rx.l<? super T> lVar = this.f52491a;
            AtomicReference<Object> atomicReference = this.f52498c;
            int i6 = 1;
            do {
                long j6 = get();
                long j7 = 0;
                while (true) {
                    if (j7 == j6) {
                        break;
                    }
                    if (lVar.isUnsubscribed()) {
                        atomicReference.lazySet(null);
                        return;
                    }
                    boolean z5 = this.f52500e;
                    Object andSet = atomicReference.getAndSet(null);
                    boolean z6 = andSet == null;
                    if (z5 && z6) {
                        Throwable th = this.f52499d;
                        if (th != null) {
                            super.onError(th);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    }
                    if (z6) {
                        break;
                    }
                    lVar.onNext((Object) v.e(andSet));
                    j7++;
                }
                if (j7 == j6) {
                    if (lVar.isUnsubscribed()) {
                        atomicReference.lazySet(null);
                        return;
                    }
                    boolean z7 = this.f52500e;
                    boolean z8 = atomicReference.get() == null;
                    if (z7 && z8) {
                        Throwable th2 = this.f52499d;
                        if (th2 != null) {
                            super.onError(th2);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    }
                }
                if (j7 != 0) {
                    rx.internal.operators.a.i(this, j7);
                }
                i6 = this.f52501f.addAndGet(-i6);
            } while (i6 != 0);
        }

        @Override // rx.internal.operators.a0.b, rx.f
        public void onError(Throwable th) {
            this.f52499d = th;
            this.f52500e = true;
            f();
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f52498c.set(v.j(t5));
            f();
        }

        public f(rx.l<? super T> lVar) {
            super(lVar);
            this.f52498c = new AtomicReference<>();
            this.f52501f = new AtomicInteger();
        }

        @Override // rx.internal.operators.a0.b
        void d() {
            f();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class g<T> extends b<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        abstract void f();

        public void onNext(T t5) {
            if (this.f52491a.isUnsubscribed()) {
                return;
            }
            if (get() == 0) {
                f();
            } else {
                this.f52491a.onNext(t5);
                rx.internal.operators.a.i(this, 1L);
            }
        }

        public g(rx.l<? super T> lVar) {
            super(lVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class h<T> extends b<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        @Override // rx.f
        public void onNext(T t5) {
            long j6;
            if (this.f52491a.isUnsubscribed()) {
                return;
            }
            this.f52491a.onNext(t5);
            do {
                j6 = get();
                if (j6 == 0) {
                    return;
                }
            } while (!compareAndSet(j6, j6 - 1));
        }

        public h(rx.l<? super T> lVar) {
            super(lVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f52490a;

        static {
            int[] iArr = new int[Emitter.BackpressureMode.values().length];
            f52490a = iArr;
            try {
                iArr[Emitter.BackpressureMode.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f52490a[Emitter.BackpressureMode.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f52490a[Emitter.BackpressureMode.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f52490a[Emitter.BackpressureMode.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class d<T> extends g<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        public d(rx.l<? super T> lVar) {
            super(lVar);
        }

        @Override // rx.internal.operators.a0.g
        void f() {
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        int i6 = a.f52490a[this.f52489b.ordinal()];
        b cVar = i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 != 4 ? new c(lVar, rx.internal.util.j.f54163d) : new f(lVar) : new d(lVar) : new e(lVar) : new h(lVar);
        lVar.add(cVar);
        lVar.setProducer(cVar);
        this.f52488a.call(cVar);
    }

    public a0(rx.functions.b<Emitter<T>> bVar, Emitter.BackpressureMode backpressureMode) {
        this.f52488a = bVar;
        this.f52489b = backpressureMode;
    }
}
