package com.bumptech.glide.repackaged.com.google.common.collect;

import com.bumptech.glide.repackaged.com.google.common.collect.o;
import com.bumptech.glide.repackaged.com.google.common.collect.p;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
class f0<K, V> extends ImmutableBiMap<K, V> {

    /* renamed from: g, reason: collision with root package name */
    static final f0<Object, Object> f15891g = new f0<>(null, null, ImmutableMap.EMPTY_ENTRY_ARRAY, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    private final transient o<K, V>[] f15892a;

    /* renamed from: b, reason: collision with root package name */
    private final transient o<K, V>[] f15893b;

    /* renamed from: c, reason: collision with root package name */
    private final transient Map.Entry<K, V>[] f15894c;

    /* renamed from: d, reason: collision with root package name */
    private final transient int f15895d;

    /* renamed from: e, reason: collision with root package name */
    private final transient int f15896e;

    /* renamed from: f, reason: collision with root package name */
    private transient ImmutableBiMap<V, K> f15897f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class b extends ImmutableBiMap<V, K> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        final class a extends p<V, K> {

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.bumptech.glide.repackaged.com.google.common.collect.f0$b$a$a, reason: collision with other inner class name */
            class C0171a extends l<Map.Entry<V, K>> {
                C0171a() {
                }

                @Override // com.bumptech.glide.repackaged.com.google.common.collect.l
                ImmutableCollection<Map.Entry<V, K>> a() {
                    return a.this;
                }

                @Override // java.util.List
                /* renamed from: d, reason: merged with bridge method [inline-methods] */
                public Map.Entry<V, K> get(int i6) {
                    Map.Entry entry = f0.this.f15894c[i6];
                    return x.b(entry.getValue(), entry.getKey());
                }
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.collect.p, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet
            boolean isHashCodeFast() {
                return true;
            }

            a() {
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.collect.p
            ImmutableMap<V, K> a() {
                return b.this;
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
            ImmutableList<Map.Entry<V, K>> createAsList() {
                return new C0171a();
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.collect.p, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
            public int hashCode() {
                return f0.this.f15896e;
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public u0<Map.Entry<V, K>> iterator() {
                return asList().iterator();
            }
        }

        private b() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap, java.util.Map
        public K get(Object obj) {
            if (obj != null && f0.this.f15893b != null) {
                for (o oVar = f0.this.f15893b[k.b(obj.hashCode()) & f0.this.f15895d]; oVar != null; oVar = oVar.c()) {
                    if (obj.equals(oVar.getValue())) {
                        return oVar.getKey();
                    }
                }
            }
            return null;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap
        boolean isPartialView() {
            return false;
        }

        /* synthetic */ b(f0 f0Var, a aVar) {
            this();
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap
        ImmutableSet<Map.Entry<V, K>> createEntrySet() {
            return new a();
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableBiMap
        public ImmutableBiMap<K, V> inverse() {
            return f0.this;
        }

        @Override // java.util.Map
        public int size() {
            return inverse().size();
        }
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap
    boolean isHashCodeFast() {
        return true;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap
    boolean isPartialView() {
        return false;
    }

    private static void e(Object obj, Map.Entry<?, ?> entry, o<?, ?> oVar) {
        while (oVar != null) {
            ImmutableMap.checkNoConflict(!obj.equals(oVar.getValue()), "value", entry, oVar);
            oVar = oVar.c();
        }
    }

    static <K, V> f0<K, V> f(int i6, Map.Entry<K, V>[] entryArr) {
        int i7 = i6;
        com.bumptech.glide.repackaged.com.google.common.base.d.k(i7, entryArr.length);
        int a6 = k.a(i7, 1.2d);
        int i8 = a6 - 1;
        o[] a7 = o.a(a6);
        o[] a8 = o.a(a6);
        Map.Entry<K, V>[] a9 = i7 == entryArr.length ? entryArr : o.a(i7);
        int i9 = 0;
        int i10 = 0;
        while (i9 < i7) {
            Map.Entry<K, V> entry = entryArr[i9];
            K key = entry.getKey();
            V value = entry.getValue();
            f.a(key, value);
            int hashCode = key.hashCode();
            int hashCode2 = value.hashCode();
            int b6 = k.b(hashCode) & i8;
            int b7 = k.b(hashCode2) & i8;
            o oVar = a7[b6];
            h0.a(key, entry, oVar);
            o oVar2 = a8[b7];
            e(value, entry, oVar2);
            o oVar3 = (oVar2 == null && oVar == null) ? ((entry instanceof o) && ((o) entry).d()) ? (o) entry : new o(key, value) : new o.a(key, value, oVar, oVar2);
            a7[b6] = oVar3;
            a8[b7] = oVar3;
            a9[i9] = oVar3;
            i10 += hashCode ^ hashCode2;
            i9++;
            i7 = i6;
        }
        return new f0<>(a7, a8, a9, i8, i10);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        o<K, V>[] oVarArr = this.f15892a;
        if (oVarArr == null) {
            return null;
        }
        return (V) h0.b(obj, oVarArr, this.f15895d);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap, java.util.Map
    public int hashCode() {
        return this.f15896e;
    }

    @Override // java.util.Map
    public int size() {
        return this.f15894c.length;
    }

    private f0(o<K, V>[] oVarArr, o<K, V>[] oVarArr2, Map.Entry<K, V>[] entryArr, int i6, int i7) {
        this.f15892a = oVarArr;
        this.f15893b = oVarArr2;
        this.f15894c = entryArr;
        this.f15895d = i6;
        this.f15896e = i7;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        if (isEmpty()) {
            return ImmutableSet.of();
        }
        return new p.a(this, this.f15894c);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableBiMap
    public ImmutableBiMap<V, K> inverse() {
        if (isEmpty()) {
            return ImmutableBiMap.of();
        }
        ImmutableBiMap<V, K> immutableBiMap = this.f15897f;
        if (immutableBiMap == null) {
            b bVar = new b(this, null);
            this.f15897f = bVar;
            return bVar;
        }
        return immutableBiMap;
    }
}
