package com.google.common.graph;

import com.google.common.annotations.Beta;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
/* loaded from: D:\Downloads\app\classes5.dex */
public interface Network<N, E> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    Set<E> adjacentEdges(E e6);

    Set<N> adjacentNodes(N n6);

    boolean allowsParallelEdges();

    boolean allowsSelfLoops();

    Graph<N> asGraph();

    int degree(N n6);

    @NullableDecl
    E edgeConnectingOrNull(EndpointPair<N> endpointPair);

    @NullableDecl
    E edgeConnectingOrNull(N n6, N n7);

    ElementOrder<E> edgeOrder();

    Set<E> edges();

    Set<E> edgesConnecting(EndpointPair<N> endpointPair);

    Set<E> edgesConnecting(N n6, N n7);

    boolean equals(@NullableDecl Object obj);

    boolean hasEdgeConnecting(EndpointPair<N> endpointPair);

    boolean hasEdgeConnecting(N n6, N n7);

    int hashCode();

    int inDegree(N n6);

    Set<E> inEdges(N n6);

    Set<E> incidentEdges(N n6);

    EndpointPair<N> incidentNodes(E e6);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N n6);

    Set<E> outEdges(N n6);

    Set<N> predecessors(N n6);

    @Override // com.google.common.graph.SuccessorsFunction
    Set<N> successors(N n6);
}
