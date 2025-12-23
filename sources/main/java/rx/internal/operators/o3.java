package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.e;
import rx.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o3<T> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    final long f53305a;

    /* renamed from: b, reason: collision with root package name */
    final TimeUnit f53306b;

    /* renamed from: c, reason: collision with root package name */
    final rx.h f53307c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.l<T> implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super T> f53308a;

        @Override // rx.f
        public void onCompleted() {
            this.f53308a.onCompleted();
            unsubscribe();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53308a.onError(th);
            unsubscribe();
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f53308a.onNext(t5);
        }

        public a(rx.l<? super T> lVar) {
            super(lVar);
            this.f53308a = lVar;
        }

        @Override // rx.functions.a
        public void call() {
            onCompleted();
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        h.a a6 = this.f53307c.a();
        lVar.add(a6);
        a aVar = new a(new rx.observers.g(lVar));
        a6.e(aVar, this.f53305a, this.f53306b);
        return aVar;
    }

    public o3(long j6, TimeUnit timeUnit, rx.h hVar) {
        this.f53305a = j6;
        this.f53306b = timeUnit;
        this.f53307c = hVar;
    }
}
