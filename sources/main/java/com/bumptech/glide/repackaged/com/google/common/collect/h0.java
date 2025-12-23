package com.bumptech.glide.repackaged.com.google.common.collect;

import com.bumptech.glide.repackaged.com.google.common.collect.p;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class h0<K, V> extends ImmutableMap<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final transient Map.Entry<K, V>[] f15907a;

    /* renamed from: b, reason: collision with root package name */
    private final transient o<K, V>[] f15908b;

    /* renamed from: c, reason: collision with root package name */
    private final transient int f15909c;

    static <V> V b(Object obj, o<?, V>[] oVarArr, int i6) {
        if (obj == null) {
            return null;
        }
        for (o<?, V> oVar = oVarArr[i6 & k.b(obj.hashCode())]; oVar != null; oVar = oVar.b()) {
            if (obj.equals(oVar.getKey())) {
                return oVar.getValue();
            }
        }
        return null;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap
    boolean isPartialView() {
        return false;
    }

    static void a(Object obj, Map.Entry<?, ?> entry, o<?, ?> oVar) {
        while (oVar != null) {
            ImmutableMap.checkNoConflict(!obj.equals(oVar.getKey()), "key", entry, oVar);
            oVar = oVar.b();
        }
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new p.a(this, this.f15907a);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        return (V) b(obj, this.f15908b, this.f15909c);
    }

    @Override // java.util.Map
    public int size() {
        return this.f15907a.length;
    }
}
