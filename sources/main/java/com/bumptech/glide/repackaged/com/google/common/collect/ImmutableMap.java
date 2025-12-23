package com.bumptech.glide.repackaged.com.google.common.collect;

import com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class ImmutableMap<K, V> implements Serializable, Map<K, V> {
    static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];
    private transient ImmutableSet<Map.Entry<K, V>> entrySet;
    private transient ImmutableSet<K> keySet;
    private transient ImmutableCollection<V> values;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends u0<K> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ u0 f15869a;

        a(u0 u0Var) {
            this.f15869a = u0Var;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f15869a.hasNext();
        }

        @Override // java.util.Iterator
        public K next() {
            return (K) ((Map.Entry) this.f15869a.next()).getKey();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b<K, V> {

        /* renamed from: a, reason: collision with root package name */
        Comparator<? super V> f15871a;

        /* renamed from: b, reason: collision with root package name */
        o<K, V>[] f15872b;

        /* renamed from: c, reason: collision with root package name */
        int f15873c;

        /* renamed from: d, reason: collision with root package name */
        boolean f15874d;

        public b() {
            this(4);
        }

        b(int i6) {
            this.f15872b = new o[i6];
            this.f15873c = 0;
            this.f15874d = false;
        }

        private void a(int i6) {
            o<K, V>[] oVarArr = this.f15872b;
            if (i6 > oVarArr.length) {
                this.f15872b = (o[]) a0.a(oVarArr, ImmutableCollection.b.c(oVarArr.length, i6));
                this.f15874d = false;
            }
        }

        public b<K, V> b(K k6, V v5) {
            a(this.f15873c + 1);
            o<K, V> entryOf = ImmutableMap.entryOf(k6, v5);
            o<K, V>[] oVarArr = this.f15872b;
            int i6 = this.f15873c;
            this.f15873c = i6 + 1;
            oVarArr[i6] = entryOf;
            return this;
        }
    }

    abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();

    @Override // java.util.Map
    public abstract V get(Object obj);

    boolean isHashCodeFast() {
        return false;
    }

    abstract boolean isPartialView();

    static void checkNoConflict(boolean z5, String str, Map.Entry<?, ?> entry, Map.Entry<?, ?> entry2) {
        if (z5) {
            return;
        }
        throw new IllegalArgumentException("Multiple entries with same " + str + ": " + entry + " and " + entry2);
    }

    static <K, V> o<K, V> entryOf(K k6, V v5) {
        return new o<>(k6, v5);
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    @Override // java.util.Map
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.keySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<K> createKeySet = createKeySet();
        this.keySet = createKeySet;
        return createKeySet;
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k6, V v5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.values;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        r rVar = new r(this);
        this.values = rVar;
        return rVar;
    }

    ImmutableMap() {
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        if (get(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    ImmutableSet<K> createKeySet() {
        if (isEmpty()) {
            return ImmutableSet.of();
        }
        return new q(this);
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return x.a(this, obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return m0.b(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    u0<K> keyIterator() {
        return new a(entrySet().iterator());
    }

    public String toString() {
        return x.c(this);
    }
}
