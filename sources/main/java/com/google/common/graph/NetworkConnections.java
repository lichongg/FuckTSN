package com.google.common.graph;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
interface NetworkConnections<N, E> {
    void addInEdge(E e6, N n6, boolean z5);

    void addOutEdge(E e6, N n6);

    N adjacentNode(E e6);

    Set<N> adjacentNodes();

    Set<E> edgesConnecting(N n6);

    Set<E> inEdges();

    Set<E> incidentEdges();

    Set<E> outEdges();

    Set<N> predecessors();

    @CanIgnoreReturnValue
    N removeInEdge(E e6, boolean z5);

    @CanIgnoreReturnValue
    N removeOutEdge(E e6);

    Set<N> successors();
}
