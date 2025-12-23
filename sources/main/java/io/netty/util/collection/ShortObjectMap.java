package io.netty.util.collection;

import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface ShortObjectMap<V> extends Map<Short, V> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface PrimitiveEntry<V> {
        short key();

        void setValue(V v5);

        V value();
    }

    boolean containsKey(short s5);

    Iterable<PrimitiveEntry<V>> entries();

    V get(short s5);

    V put(short s5, V v5);

    V remove(short s5);
}
