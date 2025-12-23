package io.netty.util.internal;

import java.util.Queue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface PriorityQueue<T> extends Queue<T> {
    void clearIgnoringIndexes();

    boolean containsTyped(T t5);

    void priorityChanged(T t5);

    boolean removeTyped(T t5);
}
