package rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class z4<T> implements i.t<T> {

    /* renamed from: a, reason: collision with root package name */
    final i.t<T> f53940a;

    /* renamed from: b, reason: collision with root package name */
    final rx.b f53941b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.k<T> implements rx.d {

        /* renamed from: b, reason: collision with root package name */
        final rx.k<? super T> f53942b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicBoolean f53943c = new AtomicBoolean();

        @Override // rx.k
        public void d(T t5) {
            if (this.f53943c.compareAndSet(false, true)) {
                unsubscribe();
                this.f53942b.d(t5);
            }
        }

        @Override // rx.d
        public void onCompleted() {
            onError(new CancellationException("Single::takeUntil(Completable) - Stream was canceled before emitting a terminal event."));
        }

        @Override // rx.k
        public void onError(Throwable th) {
            if (!this.f53943c.compareAndSet(false, true)) {
                rx.plugins.c.I(th);
            } else {
                unsubscribe();
                this.f53942b.onError(th);
            }
        }

        a(rx.k<? super T> kVar) {
            this.f53942b = kVar;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
            b(mVar);
        }
    }

    @Override // rx.functions.b
    public void call(rx.k<? super T> kVar) {
        a aVar = new a(kVar);
        kVar.b(aVar);
        this.f53941b.q0(aVar);
        this.f53940a.call(aVar);
    }

    public z4(i.t<T> tVar, rx.b bVar) {
        this.f53940a = tVar;
        this.f53941b = bVar;
    }
}
