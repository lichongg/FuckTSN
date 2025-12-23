package io.netty.util.collection;

import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface IntObjectMap<V> extends Map<Integer, V> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface PrimitiveEntry<V> {
        int key();

        void setValue(V v5);

        V value();
    }

    boolean containsKey(int i6);

    Iterable<PrimitiveEntry<V>> entries();

    V get(int i6);

    V put(int i6, V v5);

    V remove(int i6);
}
