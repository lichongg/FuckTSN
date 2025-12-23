package rx.internal.operators;

import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d0<T, U> implements e.a<T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<? extends T> f52691a;

    /* renamed from: b, reason: collision with root package name */
    final rx.e<U> f52692b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<U> {

        /* renamed from: a, reason: collision with root package name */
        boolean f52693a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.l f52694b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.e f52695c;

        a(rx.l lVar, rx.subscriptions.e eVar) {
            this.f52694b = lVar;
            this.f52695c = eVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f52693a) {
                return;
            }
            this.f52693a = true;
            this.f52695c.b(rx.subscriptions.f.e());
            d0.this.f52691a.J6(this.f52694b);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f52693a) {
                rx.plugins.c.I(th);
            } else {
                this.f52693a = true;
                this.f52694b.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(U u5) {
            onCompleted();
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        rx.subscriptions.e eVar = new rx.subscriptions.e();
        lVar.add(eVar);
        a aVar = new a(rx.observers.h.f(lVar), eVar);
        eVar.b(aVar);
        this.f52692b.J6(aVar);
    }

    public d0(rx.e<? extends T> eVar, rx.e<U> eVar2) {
        this.f52691a = eVar;
        this.f52692b = eVar2;
    }
}
