package io.netty.handler.codec.serialization;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class WeakReferenceMap<K, V> extends ReferenceMap<K, V> {
    @Override // io.netty.handler.codec.serialization.ReferenceMap
    Reference<V> fold(V v5) {
        return new WeakReference(v5);
    }

    WeakReferenceMap(Map<K, Reference<V>> map) {
        super(map);
    }
}
