package rx.internal.operators;

import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p3<T, E> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    private final rx.e<? extends E> f53354a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.l f53355a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, boolean z5, rx.l lVar2) {
            super(lVar, z5);
            this.f53355a = lVar2;
        }

        @Override // rx.f
        public void onCompleted() {
            try {
                this.f53355a.onCompleted();
            } finally {
                this.f53355a.unsubscribe();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            try {
                this.f53355a.onError(th);
            } finally {
                this.f53355a.unsubscribe();
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f53355a.onNext(t5);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends rx.l<E> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.l f53357a;

        b(rx.l lVar) {
            this.f53357a = lVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f53357a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53357a.onError(th);
        }

        @Override // rx.f
        public void onNext(E e6) {
            onCompleted();
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        rx.observers.g gVar = new rx.observers.g(lVar, false);
        a aVar = new a(gVar, false, gVar);
        b bVar = new b(aVar);
        gVar.add(aVar);
        gVar.add(bVar);
        lVar.add(gVar);
        this.f53354a.J6(bVar);
        return aVar;
    }

    public p3(rx.e<? extends E> eVar) {
        this.f53354a = eVar;
    }
}
