package rx.internal.operators;

import rx.e;
import rx.exceptions.OnErrorThrowable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class r0<T, R> implements e.a<R> {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<T> f53414a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.p<? super T, ? extends R> f53415b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T, R> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super R> f53416a;

        /* renamed from: b, reason: collision with root package name */
        final rx.functions.p<? super T, ? extends R> f53417b;

        /* renamed from: c, reason: collision with root package name */
        boolean f53418c;

        @Override // rx.f
        public void onCompleted() {
            if (this.f53418c) {
                return;
            }
            this.f53416a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f53418c) {
                rx.plugins.c.I(th);
            } else {
                this.f53418c = true;
                this.f53416a.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            try {
                this.f53416a.onNext(this.f53417b.call(t5));
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t5));
            }
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f53416a.setProducer(gVar);
        }

        public a(rx.l<? super R> lVar, rx.functions.p<? super T, ? extends R> pVar) {
            this.f53416a = lVar;
            this.f53417b = pVar;
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super R> lVar) {
        a aVar = new a(lVar, this.f53415b);
        lVar.add(aVar);
        this.f53414a.J6(aVar);
    }

    public r0(rx.e<T> eVar, rx.functions.p<? super T, ? extends R> pVar) {
        this.f53414a = eVar;
        this.f53415b = pVar;
    }
}
