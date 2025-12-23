package rx.internal.operators;

import rx.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class t4<T> implements i.t<T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.i<? extends T> f53557a;

    /* renamed from: b, reason: collision with root package name */
    final rx.e<?> f53558b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.k<T> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.k f53559b;

        a(rx.k kVar) {
            this.f53559b = kVar;
        }

        @Override // rx.k
        public void d(T t5) {
            this.f53559b.d(t5);
        }

        @Override // rx.k
        public void onError(Throwable th) {
            this.f53559b.onError(th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends rx.l<Object> {

        /* renamed from: a, reason: collision with root package name */
        boolean f53561a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.k f53562b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.e f53563c;

        b(rx.k kVar, rx.subscriptions.e eVar) {
            this.f53562b = kVar;
            this.f53563c = eVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f53561a) {
                return;
            }
            this.f53561a = true;
            this.f53563c.b(this.f53562b);
            t4.this.f53557a.j0(this.f53562b);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f53561a) {
                rx.plugins.c.I(th);
            } else {
                this.f53561a = true;
                this.f53562b.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(Object obj) {
            onCompleted();
        }
    }

    @Override // rx.functions.b
    public void call(rx.k<? super T> kVar) {
        a aVar = new a(kVar);
        rx.subscriptions.e eVar = new rx.subscriptions.e();
        kVar.b(eVar);
        b bVar = new b(aVar, eVar);
        eVar.b(bVar);
        this.f53558b.r5(bVar);
    }

    public t4(rx.i<? extends T> iVar, rx.e<?> eVar) {
        this.f53557a = iVar;
        this.f53558b = eVar;
    }
}
