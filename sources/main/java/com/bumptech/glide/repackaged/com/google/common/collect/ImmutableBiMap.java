package com.bumptech.glide.repackaged.com.google.common.collect;

import com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements d {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a<K, V> extends ImmutableMap.b<K, V> {
        public ImmutableBiMap<K, V> c() {
            int i6 = this.f15873c;
            if (i6 == 0) {
                return ImmutableBiMap.of();
            }
            if (i6 == 1) {
                return ImmutableBiMap.of((Object) this.f15872b[0].getKey(), (Object) this.f15872b[0].getValue());
            }
            if (this.f15871a != null) {
                if (this.f15874d) {
                    this.f15872b = (o[]) a0.a(this.f15872b, i6);
                }
                Arrays.sort(this.f15872b, 0, this.f15873c, b0.a(this.f15871a).c(x.d()));
            }
            int i7 = this.f15873c;
            o<K, V>[] oVarArr = this.f15872b;
            this.f15874d = i7 == oVarArr.length;
            return f0.f(i7, oVarArr);
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a<K, V> b(K k6, V v5) {
            super.b(k6, v5);
            return this;
        }
    }

    public static <K, V> ImmutableBiMap<K, V> of() {
        return f0.f15891g;
    }

    public abstract ImmutableBiMap<V, K> inverse();

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k6, V v5) {
        return new n0(k6, v5);
    }

    ImmutableBiMap() {
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<V> values() {
        return inverse().keySet();
    }
}
