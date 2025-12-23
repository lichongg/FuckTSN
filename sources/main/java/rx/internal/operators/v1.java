package rx.internal.operators;

import rx.e;
import rx.internal.operators.w1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class v1<T, U> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.p<? super T, ? extends rx.e<U>> f53602a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final w1.b<T> f53603a;

        /* renamed from: b, reason: collision with root package name */
        final rx.l<?> f53604b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.observers.g f53605c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.e f53606d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.v1$a$a, reason: collision with other inner class name */
        class C1051a extends rx.l<U> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f53608a;

            C1051a(int i6) {
                this.f53608a = i6;
            }

            @Override // rx.f
            public void onCompleted() {
                a aVar = a.this;
                aVar.f53603a.b(this.f53608a, aVar.f53605c, aVar.f53604b);
                unsubscribe();
            }

            @Override // rx.f
            public void onError(Throwable th) {
                a.this.f53604b.onError(th);
            }

            @Override // rx.f
            public void onNext(U u5) {
                onCompleted();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.observers.g gVar, rx.subscriptions.e eVar) {
            super(lVar);
            this.f53605c = gVar;
            this.f53606d = eVar;
            this.f53603a = new w1.b<>();
            this.f53604b = this;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f53603a.c(this.f53605c, this);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53605c.onError(th);
            unsubscribe();
            this.f53603a.a();
        }

        @Override // rx.f
        public void onNext(T t5) {
            try {
                rx.e<U> call = v1.this.f53602a.call(t5);
                C1051a c1051a = new C1051a(this.f53603a.d(t5));
                this.f53606d.b(c1051a);
                call.J6(c1051a);
            } catch (Throwable th) {
                rx.exceptions.a.f(th, this);
            }
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        rx.observers.g gVar = new rx.observers.g(lVar);
        rx.subscriptions.e eVar = new rx.subscriptions.e();
        lVar.add(eVar);
        return new a(lVar, gVar, eVar);
    }

    public v1(rx.functions.p<? super T, ? extends rx.e<U>> pVar) {
        this.f53602a = pVar;
    }
}
