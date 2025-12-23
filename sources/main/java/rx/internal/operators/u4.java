package rx.internal.operators;

import rx.exceptions.OnErrorThrowable;
import rx.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class u4<T, R> implements i.t<R> {

    /* renamed from: a, reason: collision with root package name */
    final rx.i<T> f53589a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.p<? super T, ? extends R> f53590b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T, R> extends rx.k<T> {

        /* renamed from: b, reason: collision with root package name */
        final rx.k<? super R> f53591b;

        /* renamed from: c, reason: collision with root package name */
        final rx.functions.p<? super T, ? extends R> f53592c;

        /* renamed from: d, reason: collision with root package name */
        boolean f53593d;

        @Override // rx.k
        public void d(T t5) {
            try {
                this.f53591b.d(this.f53592c.call(t5));
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t5));
            }
        }

        @Override // rx.k
        public void onError(Throwable th) {
            if (this.f53593d) {
                rx.plugins.c.I(th);
            } else {
                this.f53593d = true;
                this.f53591b.onError(th);
            }
        }

        public a(rx.k<? super R> kVar, rx.functions.p<? super T, ? extends R> pVar) {
            this.f53591b = kVar;
            this.f53592c = pVar;
        }
    }

    @Override // rx.functions.b
    public void call(rx.k<? super R> kVar) {
        a aVar = new a(kVar, this.f53590b);
        kVar.b(aVar);
        this.f53589a.j0(aVar);
    }

    public u4(rx.i<T> iVar, rx.functions.p<? super T, ? extends R> pVar) {
        this.f53589a = iVar;
        this.f53590b = pVar;
    }
}
