package rx.internal.operators;

import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class y1<T, V> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<? extends T> f53847a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.p<? super T, ? extends rx.e<V>> f53848b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.subjects.c f53849a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.observers.g f53850b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.y1$a$a, reason: collision with other inner class name */
        class C1057a implements rx.functions.p<V, T> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Object f53852a;

            C1057a(Object obj) {
                this.f53852a = obj;
            }

            @Override // rx.functions.p
            public T call(V v5) {
                return (T) this.f53852a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.subjects.c cVar, rx.observers.g gVar) {
            super(lVar);
            this.f53849a = cVar;
            this.f53850b = gVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f53849a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53850b.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.f
        public void onNext(T t5) {
            try {
                this.f53849a.onNext(y1.this.f53848b.call(t5).D5(1).q1(null).c3(new C1057a(t5)));
            } catch (Throwable th) {
                rx.exceptions.a.f(th, this);
            }
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        rx.observers.g gVar = new rx.observers.g(lVar);
        rx.subjects.c y7 = rx.subjects.c.y7();
        lVar.add(rx.e.h3(y7).J6(rx.observers.h.e(gVar)));
        return new a(lVar, y7, gVar);
    }

    public y1(rx.e<? extends T> eVar, rx.functions.p<? super T, ? extends rx.e<V>> pVar) {
        this.f53847a = eVar;
        this.f53848b = pVar;
    }
}
