package io.netty.util.collection;

import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface ByteObjectMap<V> extends Map<Byte, V> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface PrimitiveEntry<V> {
        byte key();

        void setValue(V v5);

        V value();
    }

    boolean containsKey(byte b6);

    Iterable<PrimitiveEntry<V>> entries();

    V get(byte b6);

    V put(byte b6, V v5);

    V remove(byte b6);
}
