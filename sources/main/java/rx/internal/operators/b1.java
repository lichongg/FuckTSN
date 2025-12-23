package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.e;
import rx.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b1<T> implements e.a<T> {

    /* renamed from: a, reason: collision with root package name */
    final long f52576a;

    /* renamed from: b, reason: collision with root package name */
    final TimeUnit f52577b;

    /* renamed from: c, reason: collision with root package name */
    final rx.h f52578c;

    /* renamed from: d, reason: collision with root package name */
    final rx.e<T> f52579d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.l<T> implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super T> f52580a;

        /* renamed from: b, reason: collision with root package name */
        volatile boolean f52581b;

        @Override // rx.functions.a
        public void call() {
            this.f52581b = true;
        }

        @Override // rx.f
        public void onCompleted() {
            try {
                this.f52580a.onCompleted();
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            try {
                this.f52580a.onError(th);
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (this.f52581b) {
                this.f52580a.onNext(t5);
            }
        }

        a(rx.l<? super T> lVar) {
            this.f52580a = lVar;
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        h.a a6 = this.f52578c.a();
        a aVar = new a(lVar);
        aVar.add(a6);
        lVar.add(aVar);
        a6.e(aVar, this.f52576a, this.f52577b);
        this.f52579d.J6(aVar);
    }

    public b1(rx.e<T> eVar, long j6, TimeUnit timeUnit, rx.h hVar) {
        this.f52579d = eVar;
        this.f52576a = j6;
        this.f52577b = timeUnit;
        this.f52578c = hVar;
    }
}
