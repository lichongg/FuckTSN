package rx.internal.operators;

import rx.e;
import rx.exceptions.OnErrorThrowable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h0<T> implements e.a<T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<T> f52876a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.p<? super T, Boolean> f52877b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super T> f52878a;

        /* renamed from: b, reason: collision with root package name */
        final rx.functions.p<? super T, Boolean> f52879b;

        /* renamed from: c, reason: collision with root package name */
        boolean f52880c;

        @Override // rx.f
        public void onCompleted() {
            if (this.f52880c) {
                return;
            }
            this.f52878a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f52880c) {
                rx.plugins.c.I(th);
            } else {
                this.f52880c = true;
                this.f52878a.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            try {
                if (this.f52879b.call(t5).booleanValue()) {
                    this.f52878a.onNext(t5);
                } else {
                    request(1L);
                }
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t5));
            }
        }

        public a(rx.l<? super T> lVar, rx.functions.p<? super T, Boolean> pVar) {
            this.f52878a = lVar;
            this.f52879b = pVar;
            request(0L);
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            super.setProducer(gVar);
            this.f52878a.setProducer(gVar);
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        a aVar = new a(lVar, this.f52877b);
        lVar.add(aVar);
        this.f52876a.J6(aVar);
    }

    public h0(rx.e<T> eVar, rx.functions.p<? super T, Boolean> pVar) {
        this.f52876a = eVar;
        this.f52877b = pVar;
    }
}
