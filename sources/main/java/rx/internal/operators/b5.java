package rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b5<T, U> implements i.t<T> {

    /* renamed from: a, reason: collision with root package name */
    final i.t<T> f52606a;

    /* renamed from: b, reason: collision with root package name */
    final rx.i<? extends U> f52607b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T, U> extends rx.k<T> {

        /* renamed from: b, reason: collision with root package name */
        final rx.k<? super T> f52608b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicBoolean f52609c = new AtomicBoolean();

        /* renamed from: d, reason: collision with root package name */
        final rx.k<U> f52610d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.b5$a$a, reason: collision with other inner class name */
        final class C1029a extends rx.k<U> {
            C1029a() {
            }

            @Override // rx.k
            public void d(U u5) {
                onError(new CancellationException("Single::takeUntil(Single) - Stream was canceled before emitting a terminal event."));
            }

            @Override // rx.k
            public void onError(Throwable th) {
                a.this.onError(th);
            }
        }

        @Override // rx.k
        public void d(T t5) {
            if (this.f52609c.compareAndSet(false, true)) {
                unsubscribe();
                this.f52608b.d(t5);
            }
        }

        @Override // rx.k
        public void onError(Throwable th) {
            if (!this.f52609c.compareAndSet(false, true)) {
                rx.plugins.c.I(th);
            } else {
                unsubscribe();
                this.f52608b.onError(th);
            }
        }

        a(rx.k<? super T> kVar) {
            this.f52608b = kVar;
            C1029a c1029a = new C1029a();
            this.f52610d = c1029a;
            b(c1029a);
        }
    }

    @Override // rx.functions.b
    public void call(rx.k<? super T> kVar) {
        a aVar = new a(kVar);
        kVar.b(aVar);
        this.f52607b.j0(aVar.f52610d);
        this.f52606a.call(aVar);
    }

    public b5(i.t<T> tVar, rx.i<? extends U> iVar) {
        this.f52606a = tVar;
        this.f52607b = iVar;
    }
}
