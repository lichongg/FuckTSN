package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.h;
import rx.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h4<T> implements i.t<T> {

    /* renamed from: a, reason: collision with root package name */
    final i.t<T> f52900a;

    /* renamed from: b, reason: collision with root package name */
    final long f52901b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f52902c;

    /* renamed from: d, reason: collision with root package name */
    final rx.h f52903d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.k<T> implements rx.functions.a {

        /* renamed from: b, reason: collision with root package name */
        final rx.k<? super T> f52904b;

        /* renamed from: c, reason: collision with root package name */
        final h.a f52905c;

        /* renamed from: d, reason: collision with root package name */
        final long f52906d;

        /* renamed from: e, reason: collision with root package name */
        final TimeUnit f52907e;

        /* renamed from: f, reason: collision with root package name */
        T f52908f;

        /* renamed from: g, reason: collision with root package name */
        Throwable f52909g;

        @Override // rx.functions.a
        public void call() {
            try {
                Throwable th = this.f52909g;
                if (th != null) {
                    this.f52909g = null;
                    this.f52904b.onError(th);
                } else {
                    T t5 = this.f52908f;
                    this.f52908f = null;
                    this.f52904b.d(t5);
                }
                this.f52905c.unsubscribe();
            } catch (Throwable th2) {
                this.f52905c.unsubscribe();
                throw th2;
            }
        }

        @Override // rx.k
        public void d(T t5) {
            this.f52908f = t5;
            this.f52905c.e(this, this.f52906d, this.f52907e);
        }

        @Override // rx.k
        public void onError(Throwable th) {
            this.f52909g = th;
            this.f52905c.e(this, this.f52906d, this.f52907e);
        }

        public a(rx.k<? super T> kVar, h.a aVar, long j6, TimeUnit timeUnit) {
            this.f52904b = kVar;
            this.f52905c = aVar;
            this.f52906d = j6;
            this.f52907e = timeUnit;
        }
    }

    @Override // rx.functions.b
    public void call(rx.k<? super T> kVar) {
        h.a a6 = this.f52903d.a();
        a aVar = new a(kVar, a6, this.f52901b, this.f52902c);
        kVar.b(a6);
        kVar.b(aVar);
        this.f52900a.call(aVar);
    }

    public h4(i.t<T> tVar, long j6, TimeUnit timeUnit, rx.h hVar) {
        this.f52900a = tVar;
        this.f52903d = hVar;
        this.f52901b = j6;
        this.f52902c = timeUnit;
    }
}
