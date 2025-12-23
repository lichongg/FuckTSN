package rx.internal.util;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.e;
import rx.functions.p;
import rx.h;
import rx.internal.producers.SingleProducer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class k<T> extends rx.e<T> {

    /* renamed from: c, reason: collision with root package name */
    static final boolean f54167c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();

    /* renamed from: b, reason: collision with root package name */
    final T f54168b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements p<rx.functions.a, rx.m> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.internal.schedulers.b f54169a;

        a(rx.internal.schedulers.b bVar) {
            this.f54169a = bVar;
        }

        @Override // rx.functions.p
        public rx.m call(rx.functions.a aVar) {
            return this.f54169a.e(aVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements p<rx.functions.a, rx.m> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.h f54171a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.functions.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ rx.functions.a f54173a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ h.a f54174b;

            a(rx.functions.a aVar, h.a aVar2) {
                this.f54173a = aVar;
                this.f54174b = aVar2;
            }

            @Override // rx.functions.a
            public void call() {
                try {
                    this.f54173a.call();
                } finally {
                    this.f54174b.unsubscribe();
                }
            }
        }

        b(rx.h hVar) {
            this.f54171a = hVar;
        }

        @Override // rx.functions.p
        public rx.m call(rx.functions.a aVar) {
            h.a a6 = this.f54171a.a();
            a6.d(new a(aVar, a6));
            return a6;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c<R> implements e.a<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f54176a;

        c(p pVar) {
            this.f54176a = pVar;
        }

        @Override // rx.functions.b
        public void call(rx.l<? super R> lVar) {
            rx.e eVar = (rx.e) this.f54176a.call(k.this.f54168b);
            if (eVar instanceof k) {
                lVar.setProducer(k.x7(lVar, ((k) eVar).f54168b));
            } else {
                eVar.J6(rx.observers.h.f(lVar));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class d<T> implements e.a<T> {

        /* renamed from: a, reason: collision with root package name */
        final T f54178a;

        @Override // rx.functions.b
        public void call(rx.l<? super T> lVar) {
            lVar.setProducer(k.x7(lVar, this.f54178a));
        }

        d(T t5) {
            this.f54178a = t5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class e<T> implements e.a<T> {

        /* renamed from: a, reason: collision with root package name */
        final T f54179a;

        /* renamed from: b, reason: collision with root package name */
        final p<rx.functions.a, rx.m> f54180b;

        @Override // rx.functions.b
        public void call(rx.l<? super T> lVar) {
            lVar.setProducer(new f(lVar, this.f54179a, this.f54180b));
        }

        e(T t5, p<rx.functions.a, rx.m> pVar) {
            this.f54179a = t5;
            this.f54180b = pVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class f<T> extends AtomicBoolean implements rx.g, rx.functions.a {
        private static final long serialVersionUID = -2466317989629281651L;

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super T> f54181a;

        /* renamed from: b, reason: collision with root package name */
        final T f54182b;

        /* renamed from: c, reason: collision with root package name */
        final p<rx.functions.a, rx.m> f54183c;

        @Override // rx.functions.a
        public void call() {
            rx.l<? super T> lVar = this.f54181a;
            if (lVar.isUnsubscribed()) {
                return;
            }
            T t5 = this.f54182b;
            try {
                lVar.onNext(t5);
                if (lVar.isUnsubscribed()) {
                    return;
                }
                lVar.onCompleted();
            } catch (Throwable th) {
                rx.exceptions.a.g(th, lVar, t5);
            }
        }

        @Override // rx.g
        public void request(long j6) {
            if (j6 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j6);
            }
            if (j6 == 0 || !compareAndSet(false, true)) {
                return;
            }
            this.f54181a.add(this.f54183c.call(this));
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.f54182b + ", " + get() + "]";
        }

        public f(rx.l<? super T> lVar, T t5, p<rx.functions.a, rx.m> pVar) {
            this.f54181a = lVar;
            this.f54182b = t5;
            this.f54183c = pVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class g<T> implements rx.g {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super T> f54184a;

        /* renamed from: b, reason: collision with root package name */
        final T f54185b;

        /* renamed from: c, reason: collision with root package name */
        boolean f54186c;

        @Override // rx.g
        public void request(long j6) {
            if (this.f54186c) {
                return;
            }
            if (j6 < 0) {
                throw new IllegalStateException("n >= required but it was " + j6);
            }
            if (j6 == 0) {
                return;
            }
            this.f54186c = true;
            rx.l<? super T> lVar = this.f54184a;
            if (lVar.isUnsubscribed()) {
                return;
            }
            T t5 = this.f54185b;
            try {
                lVar.onNext(t5);
                if (lVar.isUnsubscribed()) {
                    return;
                }
                lVar.onCompleted();
            } catch (Throwable th) {
                rx.exceptions.a.g(th, lVar, t5);
            }
        }

        public g(rx.l<? super T> lVar, T t5) {
            this.f54184a = lVar;
            this.f54185b = t5;
        }
    }

    protected k(T t5) {
        super(rx.plugins.c.G(new d(t5)));
        this.f54168b = t5;
    }

    public static <T> k<T> w7(T t5) {
        return new k<>(t5);
    }

    static <T> rx.g x7(rx.l<? super T> lVar, T t5) {
        return f54167c ? new SingleProducer(lVar, t5) : new g(lVar, t5);
    }

    public rx.e<T> A7(rx.h hVar) {
        return rx.e.I6(new e(this.f54168b, hVar instanceof rx.internal.schedulers.b ? new a((rx.internal.schedulers.b) hVar) : new b(hVar)));
    }

    public T y7() {
        return this.f54168b;
    }

    public <R> rx.e<R> z7(p<? super T, ? extends rx.e<? extends R>> pVar) {
        return rx.e.I6(new c(pVar));
    }
}
