package rx.internal.operators;

import rx.e;
import rx.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class x3<T> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.h f53809a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.l f53810a;

        a(rx.l lVar) {
            this.f53810a = lVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f53810a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53810a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f53810a.onNext(t5);
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f53810a.setProducer(gVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.l f53812a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.functions.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ h.a f53814a;

            a(h.a aVar) {
                this.f53814a = aVar;
            }

            @Override // rx.functions.a
            public void call() {
                b.this.f53812a.unsubscribe();
                this.f53814a.unsubscribe();
            }
        }

        b(rx.l lVar) {
            this.f53812a = lVar;
        }

        @Override // rx.functions.a
        public void call() {
            h.a a6 = x3.this.f53809a.a();
            a6.d(new a(a6));
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        a aVar = new a(lVar);
        lVar.add(rx.subscriptions.f.a(new b(aVar)));
        return aVar;
    }

    public x3(rx.h hVar) {
        this.f53809a = hVar;
    }
}
