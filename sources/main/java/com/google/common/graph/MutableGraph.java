package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
/* loaded from: D:\Downloads\app\classes5.dex */
public interface MutableGraph<N> extends Graph<N> {
    @CanIgnoreReturnValue
    boolean addNode(N n6);

    @CanIgnoreReturnValue
    boolean putEdge(EndpointPair<N> endpointPair);

    @CanIgnoreReturnValue
    boolean putEdge(N n6, N n7);

    @CanIgnoreReturnValue
    boolean removeEdge(EndpointPair<N> endpointPair);

    @CanIgnoreReturnValue
    boolean removeEdge(N n6, N n7);

    @CanIgnoreReturnValue
    boolean removeNode(N n6);
}
