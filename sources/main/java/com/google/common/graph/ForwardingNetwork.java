package com.google.common.graph;

import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class ForwardingNetwork<N, E> extends AbstractNetwork<N, E> {
    protected abstract Network<N, E> delegate();

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public E edgeConnectingOrNull(N n6, N n7) {
        return delegate().edgeConnectingOrNull(n6, n7);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> edgesConnecting(N n6, N n7) {
        return delegate().edgesConnecting(n6, n7);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public boolean hasEdgeConnecting(N n6, N n7) {
        return delegate().hasEdgeConnecting(n6, n7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
        return predecessors((ForwardingNetwork<N, E>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
        return successors((ForwardingNetwork<N, E>) obj);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public E edgeConnectingOrNull(EndpointPair<N> endpointPair) {
        return delegate().edgeConnectingOrNull(endpointPair);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> edgesConnecting(EndpointPair<N> endpointPair) {
        return delegate().edgesConnecting(endpointPair);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        return delegate().hasEdgeConnecting(endpointPair);
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
    public Set<N> predecessors(N n6) {
        return delegate().predecessors((Network<N, E>) n6);
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
    public Set<N> successors(N n6) {
        return delegate().successors((Network<N, E>) n6);
    }

    ForwardingNetwork() {
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> adjacentEdges(E e6) {
        return delegate().adjacentEdges(e6);
    }

    @Override // com.google.common.graph.Network
    public Set<N> adjacentNodes(N n6) {
        return delegate().adjacentNodes(n6);
    }

    @Override // com.google.common.graph.Network
    public boolean allowsParallelEdges() {
        return delegate().allowsParallelEdges();
    }

    @Override // com.google.common.graph.Network
    public boolean allowsSelfLoops() {
        return delegate().allowsSelfLoops();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int degree(N n6) {
        return delegate().degree(n6);
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<E> edgeOrder() {
        return delegate().edgeOrder();
    }

    @Override // com.google.common.graph.Network
    public Set<E> edges() {
        return delegate().edges();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int inDegree(N n6) {
        return delegate().inDegree(n6);
    }

    @Override // com.google.common.graph.Network
    public Set<E> inEdges(N n6) {
        return delegate().inEdges(n6);
    }

    @Override // com.google.common.graph.Network
    public Set<E> incidentEdges(N n6) {
        return delegate().incidentEdges(n6);
    }

    @Override // com.google.common.graph.Network
    public EndpointPair<N> incidentNodes(E e6) {
        return delegate().incidentNodes(e6);
    }

    @Override // com.google.common.graph.Network
    public boolean isDirected() {
        return delegate().isDirected();
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<N> nodeOrder() {
        return delegate().nodeOrder();
    }

    @Override // com.google.common.graph.Network
    public Set<N> nodes() {
        return delegate().nodes();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int outDegree(N n6) {
        return delegate().outDegree(n6);
    }

    @Override // com.google.common.graph.Network
    public Set<E> outEdges(N n6) {
        return delegate().outEdges(n6);
    }
}
