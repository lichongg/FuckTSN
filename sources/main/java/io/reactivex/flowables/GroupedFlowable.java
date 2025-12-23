package io.reactivex.flowables;

import io.reactivex.Flowable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class GroupedFlowable<K, T> extends Flowable<T> {
    final K key;

    public K getKey() {
        return this.key;
    }

    protected GroupedFlowable(K k6) {
        this.key = k6;
    }
}
