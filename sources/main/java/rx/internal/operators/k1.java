package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class k1<T, K, V> implements e.a<Map<K, Collection<V>>>, rx.functions.o<Map<K, Collection<V>>> {

    /* renamed from: a, reason: collision with root package name */
    private final rx.functions.p<? super T, ? extends K> f53091a;

    /* renamed from: b, reason: collision with root package name */
    private final rx.functions.p<? super T, ? extends V> f53092b;

    /* renamed from: c, reason: collision with root package name */
    private final rx.functions.o<? extends Map<K, Collection<V>>> f53093c;

    /* renamed from: d, reason: collision with root package name */
    private final rx.functions.p<? super K, ? extends Collection<V>> f53094d;

    /* renamed from: e, reason: collision with root package name */
    private final rx.e<T> f53095e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a<K, V> implements rx.functions.p<K, Collection<V>> {

        /* renamed from: a, reason: collision with root package name */
        private static final a<Object, Object> f53096a = new a<>();

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.p
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((a<K, V>) obj);
        }

        static <K, V> a<K, V> a() {
            return (a<K, V>) f53096a;
        }

        @Override // rx.functions.p
        public Collection<V> call(K k6) {
            return new ArrayList();
        }

        private a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b<T, K, V> extends u<T, Map<K, Collection<V>>> {

        /* renamed from: j, reason: collision with root package name */
        private final rx.functions.p<? super T, ? extends K> f53097j;

        /* renamed from: k, reason: collision with root package name */
        private final rx.functions.p<? super T, ? extends V> f53098k;

        /* renamed from: l, reason: collision with root package name */
        private final rx.functions.p<? super K, ? extends Collection<V>> f53099l;

        @Override // rx.f
        public void onNext(T t5) {
            if (this.f53565i) {
                return;
            }
            try {
                K call = this.f53097j.call(t5);
                V call2 = this.f53098k.call(t5);
                Collection<V> collection = (Collection) ((Map) this.f53515c).get(call);
                if (collection == null) {
                    collection = this.f53099l.call(call);
                    ((Map) this.f53515c).put(call, collection);
                }
                collection.add(call2);
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        b(rx.l<? super Map<K, Collection<V>>> lVar, Map<K, Collection<V>> map, rx.functions.p<? super T, ? extends K> pVar, rx.functions.p<? super T, ? extends V> pVar2, rx.functions.p<? super K, ? extends Collection<V>> pVar3) {
            super(lVar);
            this.f53515c = map;
            this.f53514b = true;
            this.f53097j = pVar;
            this.f53098k = pVar2;
            this.f53099l = pVar3;
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public k1(rx.e<T> eVar, rx.functions.p<? super T, ? extends K> pVar, rx.functions.p<? super T, ? extends V> pVar2) {
        this(eVar, pVar, pVar2, null, a.a());
    }

    public k1(rx.e<T> eVar, rx.functions.p<? super T, ? extends K> pVar, rx.functions.p<? super T, ? extends V> pVar2, rx.functions.o<? extends Map<K, Collection<V>>> oVar) {
        this(eVar, pVar, pVar2, oVar, a.a());
    }

    @Override // rx.functions.o, java.util.concurrent.Callable
    public Map<K, Collection<V>> call() {
        return new HashMap();
    }

    @Override // rx.functions.b
    public void call(rx.l<? super Map<K, Collection<V>>> lVar) {
        try {
            new b(lVar, this.f53093c.call(), this.f53091a, this.f53092b, this.f53094d).B(this.f53095e);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            lVar.onError(th);
        }
    }

    public k1(rx.e<T> eVar, rx.functions.p<? super T, ? extends K> pVar, rx.functions.p<? super T, ? extends V> pVar2, rx.functions.o<? extends Map<K, Collection<V>>> oVar, rx.functions.p<? super K, ? extends Collection<V>> pVar3) {
        this.f53095e = eVar;
        this.f53091a = pVar;
        this.f53092b = pVar2;
        if (oVar == null) {
            this.f53093c = this;
        } else {
            this.f53093c = oVar;
        }
        this.f53094d = pVar3;
    }
}
