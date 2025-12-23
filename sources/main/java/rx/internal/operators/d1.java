package rx.internal.operators;

import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d1<T> implements e.a<T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<T> f52697a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends t<T, T> {

        /* renamed from: i, reason: collision with root package name */
        static final Object f52698i = new Object();

        @Override // rx.internal.operators.t, rx.f
        public void onCompleted() {
            Object obj = this.f53515c;
            if (obj == f52698i) {
                g();
            } else {
                j(obj);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.f
        public void onNext(T t5) {
            this.f53515c = t5;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [R, java.lang.Object] */
        public a(rx.l<? super T> lVar) {
            super(lVar);
            this.f53515c = f52698i;
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        new a(lVar).B(this.f52697a);
    }

    public d1(rx.e<T> eVar) {
        this.f52697a = eVar;
    }
}
