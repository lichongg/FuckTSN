package rx.internal.operators;

import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class d2<T> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.b<? super Long> f52699a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f52700a;

        a(b bVar) {
            this.f52700a = bVar;
        }

        @Override // rx.g
        public void request(long j6) {
            d2.this.f52699a.call(Long.valueOf(j6));
            this.f52700a.j(j6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        private final rx.l<? super T> f52702a;

        @Override // rx.f
        public void onCompleted() {
            this.f52702a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52702a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f52702a.onNext(t5);
        }

        b(rx.l<? super T> lVar) {
            this.f52702a = lVar;
            request(0L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(long j6) {
            request(j6);
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        b bVar = new b(lVar);
        lVar.setProducer(new a(bVar));
        lVar.add(bVar);
        return bVar;
    }

    public d2(rx.functions.b<? super Long> bVar) {
        this.f52699a = bVar;
    }
}
