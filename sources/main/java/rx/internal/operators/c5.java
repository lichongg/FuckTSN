package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.h;
import rx.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c5<T> implements i.t<T> {

    /* renamed from: a, reason: collision with root package name */
    final i.t<T> f52672a;

    /* renamed from: b, reason: collision with root package name */
    final long f52673b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f52674c;

    /* renamed from: d, reason: collision with root package name */
    final rx.h f52675d;

    /* renamed from: e, reason: collision with root package name */
    final i.t<? extends T> f52676e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.k<T> implements rx.functions.a {

        /* renamed from: b, reason: collision with root package name */
        final rx.k<? super T> f52677b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicBoolean f52678c = new AtomicBoolean();

        /* renamed from: d, reason: collision with root package name */
        final i.t<? extends T> f52679d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.c5$a$a, reason: collision with other inner class name */
        static final class C1031a<T> extends rx.k<T> {

            /* renamed from: b, reason: collision with root package name */
            final rx.k<? super T> f52680b;

            @Override // rx.k
            public void d(T t5) {
                this.f52680b.d(t5);
            }

            @Override // rx.k
            public void onError(Throwable th) {
                this.f52680b.onError(th);
            }

            C1031a(rx.k<? super T> kVar) {
                this.f52680b = kVar;
            }
        }

        @Override // rx.functions.a
        public void call() {
            if (this.f52678c.compareAndSet(false, true)) {
                try {
                    i.t<? extends T> tVar = this.f52679d;
                    if (tVar == null) {
                        this.f52677b.onError(new TimeoutException());
                    } else {
                        C1031a c1031a = new C1031a(this.f52677b);
                        this.f52677b.b(c1031a);
                        tVar.call(c1031a);
                    }
                    unsubscribe();
                } catch (Throwable th) {
                    unsubscribe();
                    throw th;
                }
            }
        }

        @Override // rx.k
        public void d(T t5) {
            if (this.f52678c.compareAndSet(false, true)) {
                try {
                    this.f52677b.d(t5);
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // rx.k
        public void onError(Throwable th) {
            if (!this.f52678c.compareAndSet(false, true)) {
                rx.plugins.c.I(th);
                return;
            }
            try {
                this.f52677b.onError(th);
            } finally {
                unsubscribe();
            }
        }

        a(rx.k<? super T> kVar, i.t<? extends T> tVar) {
            this.f52677b = kVar;
            this.f52679d = tVar;
        }
    }

    @Override // rx.functions.b
    public void call(rx.k<? super T> kVar) {
        a aVar = new a(kVar, this.f52676e);
        h.a a6 = this.f52675d.a();
        aVar.b(a6);
        kVar.b(aVar);
        a6.e(aVar, this.f52673b, this.f52674c);
        this.f52672a.call(aVar);
    }

    public c5(i.t<T> tVar, long j6, TimeUnit timeUnit, rx.h hVar, i.t<? extends T> tVar2) {
        this.f52672a = tVar;
        this.f52673b = j6;
        this.f52674c = timeUnit;
        this.f52675d = hVar;
        this.f52676e = tVar2;
    }
}
