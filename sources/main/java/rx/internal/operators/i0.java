package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.internal.util.ExceptionsUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i0<T> implements e.a<T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<T> f52914a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.p<? super T, ? extends rx.b> f52915b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f52916c;

    /* renamed from: d, reason: collision with root package name */
    final int f52917d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super T> f52918a;

        /* renamed from: b, reason: collision with root package name */
        final rx.functions.p<? super T, ? extends rx.b> f52919b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f52920c;

        /* renamed from: d, reason: collision with root package name */
        final int f52921d;

        /* renamed from: e, reason: collision with root package name */
        final AtomicInteger f52922e = new AtomicInteger(1);

        /* renamed from: g, reason: collision with root package name */
        final AtomicReference<Throwable> f52924g = new AtomicReference<>();

        /* renamed from: f, reason: collision with root package name */
        final rx.subscriptions.b f52923f = new rx.subscriptions.b();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.i0$a$a, reason: collision with other inner class name */
        final class C1035a extends AtomicReference<rx.m> implements rx.d, rx.m {
            private static final long serialVersionUID = -8588259593722659900L;

            @Override // rx.d
            public void a(rx.m mVar) {
                if (compareAndSet(null, mVar)) {
                    return;
                }
                mVar.unsubscribe();
                if (get() != this) {
                    rx.plugins.c.I(new IllegalStateException("Subscription already set!"));
                }
            }

            C1035a() {
            }

            @Override // rx.d
            public void onCompleted() {
                a.this.j(this);
            }

            @Override // rx.d
            public void onError(Throwable th) {
                a.this.s(this, th);
            }

            @Override // rx.m
            public boolean isUnsubscribed() {
                if (get() == this) {
                    return true;
                }
                return false;
            }

            @Override // rx.m
            public void unsubscribe() {
                rx.m andSet = getAndSet(this);
                if (andSet != null && andSet != this) {
                    andSet.unsubscribe();
                }
            }
        }

        boolean g() {
            if (this.f52922e.decrementAndGet() != 0) {
                return false;
            }
            Throwable terminate = ExceptionsUtils.terminate(this.f52924g);
            if (terminate != null) {
                this.f52918a.onError(terminate);
                return true;
            }
            this.f52918a.onCompleted();
            return true;
        }

        public void j(a<T>.C1035a c1035a) {
            this.f52923f.f(c1035a);
            if (g() || this.f52921d == Integer.MAX_VALUE) {
                return;
            }
            request(1L);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f52920c) {
                ExceptionsUtils.addThrowable(this.f52924g, th);
                onCompleted();
                return;
            }
            this.f52923f.unsubscribe();
            if (androidx.camera.view.p.a(this.f52924g, null, th)) {
                this.f52918a.onError(ExceptionsUtils.terminate(this.f52924g));
            } else {
                rx.plugins.c.I(th);
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            try {
                rx.b call = this.f52919b.call(t5);
                if (call == null) {
                    throw new NullPointerException("The mapper returned a null Completable");
                }
                C1035a c1035a = new C1035a();
                this.f52923f.a(c1035a);
                this.f52922e.getAndIncrement();
                call.G0(c1035a);
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(th);
            }
        }

        public void s(a<T>.C1035a c1035a, Throwable th) {
            this.f52923f.f(c1035a);
            if (this.f52920c) {
                ExceptionsUtils.addThrowable(this.f52924g, th);
                if (g() || this.f52921d == Integer.MAX_VALUE) {
                    return;
                }
                request(1L);
                return;
            }
            this.f52923f.unsubscribe();
            unsubscribe();
            if (androidx.camera.view.p.a(this.f52924g, null, th)) {
                this.f52918a.onError(ExceptionsUtils.terminate(this.f52924g));
            } else {
                rx.plugins.c.I(th);
            }
        }

        a(rx.l<? super T> lVar, rx.functions.p<? super T, ? extends rx.b> pVar, boolean z5, int i6) {
            long j6;
            this.f52918a = lVar;
            this.f52919b = pVar;
            this.f52920c = z5;
            this.f52921d = i6;
            if (i6 != Integer.MAX_VALUE) {
                j6 = i6;
            } else {
                j6 = Long.MAX_VALUE;
            }
            request(j6);
        }

        @Override // rx.f
        public void onCompleted() {
            g();
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        a aVar = new a(lVar, this.f52915b, this.f52916c, this.f52917d);
        lVar.add(aVar);
        lVar.add(aVar.f52923f);
        this.f52914a.J6(aVar);
    }

    public i0(rx.e<T> eVar, rx.functions.p<? super T, ? extends rx.b> pVar, boolean z5, int i6) {
        if (pVar != null) {
            if (i6 > 0) {
                this.f52914a = eVar;
                this.f52915b = pVar;
                this.f52916c = z5;
                this.f52917d = i6;
                return;
            }
            throw new IllegalArgumentException("maxConcurrency > 0 required but it was " + i6);
        }
        throw new NullPointerException("mapper is null");
    }
}
