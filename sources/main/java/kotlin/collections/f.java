package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.1")
@SourceDebugExtension({"SMAP\nAbstractMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractMap.kt\nkotlin/collections/AbstractMap\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,153:1\n1761#2,3:154\n1740#2,3:157\n295#2,2:160\n*S KotlinDebug\n*F\n+ 1 AbstractMap.kt\nkotlin/collections/AbstractMap\n*L\n28#1:154,3\n60#1:157,3\n141#1:160,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class f<K, V> implements Map<K, V>, m3.a {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f43638c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private volatile Set<? extends K> f43639a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private volatile Collection<? extends V> f43640b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nAbstractMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractMap.kt\nkotlin/collections/AbstractMap$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,153:1\n1#2:154\n*E\n"})
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        public final boolean a(@NotNull Map.Entry<?, ?> e6, @Nullable Object obj) {
            kotlin.jvm.internal.g0.p(e6, "e");
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return kotlin.jvm.internal.g0.g(e6.getKey(), entry.getKey()) && kotlin.jvm.internal.g0.g(e6.getValue(), entry.getValue());
        }

        public final int b(@NotNull Map.Entry<?, ?> e6) {
            kotlin.jvm.internal.g0.p(e6, "e");
            Object key = e6.getKey();
            int hashCode = key != null ? key.hashCode() : 0;
            Object value = e6.getValue();
            return hashCode ^ (value != null ? value.hashCode() : 0);
        }

        @NotNull
        public final String c(@NotNull Map.Entry<?, ?> e6) {
            kotlin.jvm.internal.g0.p(e6, "e");
            StringBuilder sb = new StringBuilder();
            sb.append(e6.getKey());
            sb.append('=');
            sb.append(e6.getValue());
            return sb.toString();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends k<K> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f<K, V> f43641b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class a implements Iterator<K>, m3.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Iterator<Map.Entry<K, V>> f43642a;

            /* JADX WARN: Multi-variable type inference failed */
            a(Iterator<? extends Map.Entry<? extends K, ? extends V>> it) {
                this.f43642a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f43642a.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                return this.f43642a.next().getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        b(f<K, ? extends V> fVar) {
            this.f43641b = fVar;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public boolean contains(Object obj) {
            return this.f43641b.containsKey(obj);
        }

        @Override // kotlin.collections.b
        public int getSize() {
            return this.f43641b.size();
        }

        @Override // kotlin.collections.k, kotlin.collections.b, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(this.f43641b.entrySet().iterator());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c extends kotlin.collections.b<V> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f<K, V> f43643a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class a implements Iterator<V>, m3.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Iterator<Map.Entry<K, V>> f43644a;

            /* JADX WARN: Multi-variable type inference failed */
            a(Iterator<? extends Map.Entry<? extends K, ? extends V>> it) {
                this.f43644a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f43644a.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                return this.f43644a.next().getValue();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        c(f<K, ? extends V> fVar) {
            this.f43643a = fVar;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public boolean contains(Object obj) {
            return this.f43643a.containsValue(obj);
        }

        @Override // kotlin.collections.b
        public int getSize() {
            return this.f43643a.size();
        }

        @Override // kotlin.collections.b, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(this.f43643a.entrySet().iterator());
        }
    }

    public final boolean c(@Nullable Map.Entry<?, ?> entry) {
        if (entry == null) {
            return false;
        }
        Object key = entry.getKey();
        Object value = entry.getValue();
        kotlin.jvm.internal.g0.n(this, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        V v5 = get(key);
        if (!kotlin.jvm.internal.g0.g(value, v5)) {
            return false;
        }
        if (v5 != null) {
            return true;
        }
        kotlin.jvm.internal.g0.n(this, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.containsKey, *>");
        return containsKey(key);
    }

    public abstract Set<Map.Entry<K, V>> d();

    @Override // java.util.Map
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        Set<Map.Entry<K, V>> entrySet = map.entrySet();
        if (androidx.activity.k.a(entrySet) && entrySet.isEmpty()) {
            return true;
        }
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            if (!c((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private final String i(Object obj) {
        return obj == this ? "(this Map)" : String.valueOf(obj);
    }

    private final String j(Map.Entry<? extends K, ? extends V> entry) {
        return i(entry.getKey()) + '=' + i(entry.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence k(f fVar, Map.Entry it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return fVar.j(it);
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @NotNull
    public Set<K> e() {
        if (this.f43639a == null) {
            this.f43639a = new b(this);
        }
        Set<? extends K> set = this.f43639a;
        kotlin.jvm.internal.g0.m(set);
        return set;
    }

    @NotNull
    public Collection<V> g() {
        if (this.f43640b == null) {
            this.f43640b = new c(this);
        }
        Collection<? extends V> collection = this.f43640b;
        kotlin.jvm.internal.g0.m(collection);
        return collection;
    }

    @Override // java.util.Map
    public V put(K k6, V v5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    protected f() {
    }

    private final Map.Entry<K, V> h(K k6) {
        Object obj;
        Iterator<T> it = entrySet().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (kotlin.jvm.internal.g0.g(((Map.Entry) obj).getKey(), k6)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (Map.Entry) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        if (h(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        Set<Map.Entry<K, V>> entrySet = entrySet();
        if (androidx.activity.k.a(entrySet) && entrySet.isEmpty()) {
            return false;
        }
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.g0.g(((Map.Entry) it.next()).getValue(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return d();
    }

    public int f() {
        return entrySet().size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V get(Object obj) {
        Map.Entry<K, V> h6 = h(obj);
        if (h6 != null) {
            return h6.getValue();
        }
        return null;
    }

    @Override // java.util.Map
    public int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return e();
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return f();
    }

    @NotNull
    public String toString() {
        return r0.r3(entrySet(), ", ", "{", "}", 0, null, new Function1() { // from class: kotlin.collections.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence k6;
                k6 = f.k(f.this, (Map.Entry) obj);
                return k6;
            }
        }, 24, null);
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return g();
    }
}
