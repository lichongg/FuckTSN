package rx.internal.operators;

import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class k2<T> implements e.b<T, T> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.l f53100a;

        a(rx.l lVar) {
            this.f53100a = lVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f53100a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53100a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        static final k2<?> f53102a = new k2<>();

        b() {
        }
    }

    public static <T> k2<T> a() {
        return (k2<T>) b.f53102a;
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        a aVar = new a(lVar);
        lVar.add(aVar);
        return aVar;
    }

    k2() {
    }
}
