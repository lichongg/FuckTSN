package com.google.common.graph;

import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
interface BaseGraph<N> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    Set<N> adjacentNodes(N n6);

    boolean allowsSelfLoops();

    int degree(N n6);

    Set<EndpointPair<N>> edges();

    boolean hasEdgeConnecting(EndpointPair<N> endpointPair);

    boolean hasEdgeConnecting(N n6, N n7);

    int inDegree(N n6);

    Set<EndpointPair<N>> incidentEdges(N n6);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N n6);

    Set<N> predecessors(N n6);

    @Override // com.google.common.graph.SuccessorsFunction
    Set<N> successors(N n6);
}
