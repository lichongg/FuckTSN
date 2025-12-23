package io.netty.util.collection;

import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface LongObjectMap<V> extends Map<Long, V> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface PrimitiveEntry<V> {
        long key();

        void setValue(V v5);

        V value();
    }

    boolean containsKey(long j6);

    Iterable<PrimitiveEntry<V>> entries();

    V get(long j6);

    V put(long j6, V v5);

    V remove(long j6);
}
