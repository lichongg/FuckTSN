package rx.internal.operators;

import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class q3<T> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.p<? super T, Boolean> f53399a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f53400a;

        a(b bVar) {
            this.f53400a = bVar;
        }

        @Override // rx.g
        public void request(long j6) {
            this.f53400a.g(j6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        private final rx.l<? super T> f53402a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f53403b;

        b(rx.l<? super T> lVar) {
            this.f53402a = lVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f53403b) {
                return;
            }
            this.f53402a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f53403b) {
                return;
            }
            this.f53402a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f53402a.onNext(t5);
            try {
                if (q3.this.f53399a.call(t5).booleanValue()) {
                    this.f53403b = true;
                    this.f53402a.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th) {
                this.f53403b = true;
                rx.exceptions.a.g(th, this.f53402a, t5);
                unsubscribe();
            }
        }

        void g(long j6) {
            request(j6);
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        b bVar = new b(lVar);
        lVar.add(bVar);
        lVar.setProducer(new a(bVar));
        return bVar;
    }

    public q3(rx.functions.p<? super T, Boolean> pVar) {
        this.f53399a = pVar;
    }
}
