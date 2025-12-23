package rx.observables;

import rx.e;
import rx.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class d<K, T> extends rx.e<T> {

    /* renamed from: b, reason: collision with root package name */
    private final K f54379b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements e.a<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.e f54380a;

        a(rx.e eVar) {
            this.f54380a = eVar;
        }

        @Override // rx.functions.b
        public void call(l<? super T> lVar) {
            this.f54380a.J6(lVar);
        }
    }

    public static <K, T> d<K, T> w7(K k6, e.a<T> aVar) {
        return new d<>(k6, aVar);
    }

    public static <K, T> d<K, T> x7(K k6, rx.e<T> eVar) {
        return new d<>(k6, new a(eVar));
    }

    public K y7() {
        return this.f54379b;
    }

    protected d(K k6, e.a<T> aVar) {
        super(aVar);
        this.f54379b = k6;
    }
}
