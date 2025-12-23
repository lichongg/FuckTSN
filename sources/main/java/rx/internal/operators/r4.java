package rx.internal.operators;

import rx.h;
import rx.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class r4<T> implements i.t<T> {

    /* renamed from: a, reason: collision with root package name */
    final i.t<T> f53456a;

    /* renamed from: b, reason: collision with root package name */
    final rx.h f53457b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.k<T> implements rx.functions.a {

        /* renamed from: b, reason: collision with root package name */
        final rx.k<? super T> f53458b;

        /* renamed from: c, reason: collision with root package name */
        final h.a f53459c;

        /* renamed from: d, reason: collision with root package name */
        T f53460d;

        /* renamed from: e, reason: collision with root package name */
        Throwable f53461e;

        @Override // rx.functions.a
        public void call() {
            try {
                Throwable th = this.f53461e;
                if (th != null) {
                    this.f53461e = null;
                    this.f53458b.onError(th);
                } else {
                    T t5 = this.f53460d;
                    this.f53460d = null;
                    this.f53458b.d(t5);
                }
                this.f53459c.unsubscribe();
            } catch (Throwable th2) {
                this.f53459c.unsubscribe();
                throw th2;
            }
        }

        @Override // rx.k
        public void d(T t5) {
            this.f53460d = t5;
            this.f53459c.d(this);
        }

        @Override // rx.k
        public void onError(Throwable th) {
            this.f53461e = th;
            this.f53459c.d(this);
        }

        public a(rx.k<? super T> kVar, h.a aVar) {
            this.f53458b = kVar;
            this.f53459c = aVar;
        }
    }

    @Override // rx.functions.b
    public void call(rx.k<? super T> kVar) {
        h.a a6 = this.f53457b.a();
        a aVar = new a(kVar, a6);
        kVar.b(a6);
        kVar.b(aVar);
        this.f53456a.call(aVar);
    }

    public r4(i.t<T> tVar, rx.h hVar) {
        this.f53456a = tVar;
        this.f53457b = hVar;
    }
}
