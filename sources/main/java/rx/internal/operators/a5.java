package rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a5<T, U> implements i.t<T> {

    /* renamed from: a, reason: collision with root package name */
    final i.t<T> f52565a;

    /* renamed from: b, reason: collision with root package name */
    final rx.e<? extends U> f52566b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T, U> extends rx.k<T> {

        /* renamed from: b, reason: collision with root package name */
        final rx.k<? super T> f52567b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicBoolean f52568c = new AtomicBoolean();

        /* renamed from: d, reason: collision with root package name */
        final rx.l<U> f52569d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.a5$a$a, reason: collision with other inner class name */
        final class C1027a extends rx.l<U> {
            C1027a() {
            }

            @Override // rx.f
            public void onCompleted() {
                onError(new CancellationException("Single::takeUntil(Observable) - Stream was canceled before emitting a terminal event."));
            }

            @Override // rx.f
            public void onError(Throwable th) {
                a.this.onError(th);
            }

            @Override // rx.f
            public void onNext(U u5) {
                onCompleted();
            }
        }

        @Override // rx.k
        public void d(T t5) {
            if (this.f52568c.compareAndSet(false, true)) {
                unsubscribe();
                this.f52567b.d(t5);
            }
        }

        @Override // rx.k
        public void onError(Throwable th) {
            if (!this.f52568c.compareAndSet(false, true)) {
                rx.plugins.c.I(th);
            } else {
                unsubscribe();
                this.f52567b.onError(th);
            }
        }

        a(rx.k<? super T> kVar) {
            this.f52567b = kVar;
            C1027a c1027a = new C1027a();
            this.f52569d = c1027a;
            b(c1027a);
        }
    }

    @Override // rx.functions.b
    public void call(rx.k<? super T> kVar) {
        a aVar = new a(kVar);
        kVar.b(aVar);
        this.f52566b.r5(aVar.f52569d);
        this.f52565a.call(aVar);
    }

    public a5(i.t<T> tVar, rx.e<? extends U> eVar) {
        this.f52565a = tVar;
        this.f52566b = eVar;
    }
}
