package rx.internal.operators;

import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class x<T, R> implements e.a<R> {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<T> f53772a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.o<R> f53773b;

    /* renamed from: c, reason: collision with root package name */
    final rx.functions.c<R, ? super T> f53774c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T, R> extends u<T, R> {

        /* renamed from: j, reason: collision with root package name */
        final rx.functions.c<R, ? super T> f53775j;

        @Override // rx.f
        public void onNext(T t5) {
            if (this.f53565i) {
                return;
            }
            try {
                this.f53775j.call(this.f53515c, t5);
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(th);
            }
        }

        public a(rx.l<? super R> lVar, R r5, rx.functions.c<R, ? super T> cVar) {
            super(lVar);
            this.f53515c = r5;
            this.f53514b = true;
            this.f53775j = cVar;
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super R> lVar) {
        try {
            new a(lVar, this.f53773b.call(), this.f53774c).B(this.f53772a);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            lVar.onError(th);
        }
    }

    public x(rx.e<T> eVar, rx.functions.o<R> oVar, rx.functions.c<R, ? super T> cVar) {
        this.f53772a = eVar;
        this.f53773b = oVar;
        this.f53774c = cVar;
    }
}
