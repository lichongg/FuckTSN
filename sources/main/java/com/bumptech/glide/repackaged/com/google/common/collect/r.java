package com.bumptech.glide.repackaged.com.google.common.collect;

import com.google.j2objc.annotations.Weak;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class r<K, V> extends ImmutableCollection<V> {

    /* renamed from: a, reason: collision with root package name */
    @Weak
    private final ImmutableMap<K, V> f15937a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends u0<V> {

        /* renamed from: a, reason: collision with root package name */
        final u0<Map.Entry<K, V>> f15938a;

        a() {
            this.f15938a = r.this.f15937a.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f15938a.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return this.f15938a.next().getValue();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends l<V> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImmutableList f15940a;

        b(ImmutableList immutableList) {
            this.f15940a = immutableList;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.l
        ImmutableCollection<V> a() {
            return r.this;
        }

        @Override // java.util.List
        public V get(int i6) {
            return (V) ((Map.Entry) this.f15940a.get(i6)).getValue();
        }
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return true;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return obj != null && v.d(iterator(), obj);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    ImmutableList<V> createAsList() {
        return new b(this.f15937a.entrySet().asList());
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public u0<V> iterator() {
        return new a();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.f15937a.size();
    }

    r(ImmutableMap<K, V> immutableMap) {
        this.f15937a = immutableMap;
    }
}
