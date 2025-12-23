package rx.internal.operators;

import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c3<T> implements e.b<T, T> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.l f52637a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f52637a = lVar2;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f52637a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52637a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f52637a.onNext(t5);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        static final c3<Object> f52639a = new c3<>();

        b() {
        }
    }

    public static <T> c3<T> a() {
        return (c3<T>) b.f52639a;
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        return new rx.observers.g(new a(lVar, lVar));
    }

    c3() {
    }
}
