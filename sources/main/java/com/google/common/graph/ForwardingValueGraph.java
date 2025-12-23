package com.google.common.graph;

import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class ForwardingValueGraph<N, V> extends AbstractValueGraph<N, V> {
    protected abstract ValueGraph<N, V> delegate();

    @Override // com.google.common.graph.ValueGraph
    @NullableDecl
    public V edgeValueOrDefault(N n6, N n7, @NullableDecl V v5) {
        return delegate().edgeValueOrDefault(n6, n7, v5);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(N n6, N n7) {
        return delegate().hasEdgeConnecting(n6, n7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
        return predecessors((ForwardingValueGraph<N, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
        return successors((ForwardingValueGraph<N, V>) obj);
    }

    @Override // com.google.common.graph.ValueGraph
    @NullableDecl
    public V edgeValueOrDefault(EndpointPair<N> endpointPair, @NullableDecl V v5) {
        return delegate().edgeValueOrDefault(endpointPair, v5);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        return delegate().hasEdgeConnecting(endpointPair);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
    public Set<N> predecessors(N n6) {
        return delegate().predecessors((ValueGraph<N, V>) n6);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
    public Set<N> successors(N n6) {
        return delegate().successors((ValueGraph<N, V>) n6);
    }

    ForwardingValueGraph() {
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public Set<N> adjacentNodes(N n6) {
        return delegate().adjacentNodes(n6);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean allowsSelfLoops() {
        return delegate().allowsSelfLoops();
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public int degree(N n6) {
        return delegate().degree(n6);
    }

    @Override // com.google.common.graph.AbstractBaseGraph
    protected long edgeCount() {
        return delegate().edges().size();
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public int inDegree(N n6) {
        return delegate().inDegree(n6);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean isDirected() {
        return delegate().isDirected();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public ElementOrder<N> nodeOrder() {
        return delegate().nodeOrder();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public Set<N> nodes() {
        return delegate().nodes();
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public int outDegree(N n6) {
        return delegate().outDegree(n6);
    }
}
