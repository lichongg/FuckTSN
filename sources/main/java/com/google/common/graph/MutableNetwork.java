package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
/* loaded from: D:\Downloads\app\classes5.dex */
public interface MutableNetwork<N, E> extends Network<N, E> {
    @CanIgnoreReturnValue
    boolean addEdge(EndpointPair<N> endpointPair, E e6);

    @CanIgnoreReturnValue
    boolean addEdge(N n6, N n7, E e6);

    @CanIgnoreReturnValue
    boolean addNode(N n6);

    @CanIgnoreReturnValue
    boolean removeEdge(E e6);

    @CanIgnoreReturnValue
    boolean removeNode(N n6);
}
