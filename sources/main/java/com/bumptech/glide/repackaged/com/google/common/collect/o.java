package com.bumptech.glide.repackaged.com.google.common.collect;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
class o<K, V> extends m<K, V> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<K, V> extends b<K, V> {

        /* renamed from: d, reason: collision with root package name */
        private final transient o<K, V> f15929d;

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.o
        o<K, V> c() {
            return this.f15929d;
        }

        a(K k6, V v5, o<K, V> oVar, o<K, V> oVar2) {
            super(k6, v5, oVar);
            this.f15929d = oVar2;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b<K, V> extends o<K, V> {

        /* renamed from: c, reason: collision with root package name */
        private final transient o<K, V> f15930c;

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.o
        final boolean d() {
            return false;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.o
        final o<K, V> b() {
            return this.f15930c;
        }

        b(K k6, V v5, o<K, V> oVar) {
            super(k6, v5);
            this.f15930c = oVar;
        }
    }

    o<K, V> b() {
        return null;
    }

    o<K, V> c() {
        return null;
    }

    boolean d() {
        return true;
    }

    static <K, V> o<K, V>[] a(int i6) {
        return new o[i6];
    }

    o(K k6, V v5) {
        super(k6, v5);
        f.a(k6, v5);
    }
}
