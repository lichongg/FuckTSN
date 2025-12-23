package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
/* loaded from: D:\Downloads\app\classes5.dex */
public interface MutableValueGraph<N, V> extends ValueGraph<N, V> {
    @CanIgnoreReturnValue
    boolean addNode(N n6);

    @CanIgnoreReturnValue
    V putEdgeValue(EndpointPair<N> endpointPair, V v5);

    @CanIgnoreReturnValue
    V putEdgeValue(N n6, N n7, V v5);

    @CanIgnoreReturnValue
    V removeEdge(EndpointPair<N> endpointPair);

    @CanIgnoreReturnValue
    V removeEdge(N n6, N n7);

    @CanIgnoreReturnValue
    boolean removeNode(N n6);
}
