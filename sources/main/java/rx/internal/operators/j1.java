package rx.internal.operators;

import java.util.HashMap;
import java.util.Map;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j1<T, K, V> implements e.a<Map<K, V>>, rx.functions.o<Map<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<T> f53003a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.p<? super T, ? extends K> f53004b;

    /* renamed from: c, reason: collision with root package name */
    final rx.functions.p<? super T, ? extends V> f53005c;

    /* renamed from: d, reason: collision with root package name */
    final rx.functions.o<? extends Map<K, V>> f53006d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T, K, V> extends u<T, Map<K, V>> {

        /* renamed from: j, reason: collision with root package name */
        final rx.functions.p<? super T, ? extends K> f53007j;

        /* renamed from: k, reason: collision with root package name */
        final rx.functions.p<? super T, ? extends V> f53008k;

        @Override // rx.f
        public void onNext(T t5) {
            if (this.f53565i) {
                return;
            }
            try {
                ((Map) this.f53515c).put(this.f53007j.call(t5), this.f53008k.call(t5));
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        a(rx.l<? super Map<K, V>> lVar, Map<K, V> map, rx.functions.p<? super T, ? extends K> pVar, rx.functions.p<? super T, ? extends V> pVar2) {
            super(lVar);
            this.f53515c = map;
            this.f53514b = true;
            this.f53007j = pVar;
            this.f53008k = pVar2;
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public j1(rx.e<T> eVar, rx.functions.p<? super T, ? extends K> pVar, rx.functions.p<? super T, ? extends V> pVar2) {
        this(eVar, pVar, pVar2, null);
    }

    public j1(rx.e<T> eVar, rx.functions.p<? super T, ? extends K> pVar, rx.functions.p<? super T, ? extends V> pVar2, rx.functions.o<? extends Map<K, V>> oVar) {
        this.f53003a = eVar;
        this.f53004b = pVar;
        this.f53005c = pVar2;
        if (oVar == null) {
            this.f53006d = this;
        } else {
            this.f53006d = oVar;
        }
    }

    @Override // rx.functions.o, java.util.concurrent.Callable
    public Map<K, V> call() {
        return new HashMap();
    }

    @Override // rx.functions.b
    public void call(rx.l<? super Map<K, V>> lVar) {
        try {
            new a(lVar, this.f53006d.call(), this.f53004b, this.f53005c).B(this.f53003a);
        } catch (Throwable th) {
            rx.exceptions.a.f(th, lVar);
        }
    }
}
