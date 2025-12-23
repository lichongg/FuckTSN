package com.google.common.graph;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class ConfigurableValueGraph<N, V> extends AbstractValueGraph<N, V> {
    private final boolean allowsSelfLoops;
    protected long edgeCount;
    private final boolean isDirected;
    protected final MapIteratorCache<N, GraphConnections<N, V>> nodeConnections;
    private final ElementOrder<N> nodeOrder;

    ConfigurableValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        this(abstractGraphBuilder, abstractGraphBuilder.nodeOrder.createMap(abstractGraphBuilder.expectedNodeCount.or((Optional<Integer>) 10).intValue()), 0L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ValueGraph
    @NullableDecl
    public V edgeValueOrDefault(N n6, N n7, @NullableDecl V v5) {
        return (V) edgeValueOrDefault_internal(Preconditions.checkNotNull(n6), Preconditions.checkNotNull(n7), v5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(N n6, N n7) {
        return hasEdgeConnecting_internal(Preconditions.checkNotNull(n6), Preconditions.checkNotNull(n7));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
        return predecessors((ConfigurableValueGraph<N, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
        return successors((ConfigurableValueGraph<N, V>) obj);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    protected final GraphConnections<N, V> checkedConnections(N n6) {
        GraphConnections<N, V> graphConnections = this.nodeConnections.get(n6);
        if (graphConnections != null) {
            return graphConnections;
        }
        Preconditions.checkNotNull(n6);
        throw new IllegalArgumentException("Node " + n6 + " is not an element of this graph.");
    }

    protected final boolean containsNode(@NullableDecl N n6) {
        return this.nodeConnections.containsKey(n6);
    }

    @Override // com.google.common.graph.AbstractBaseGraph
    protected long edgeCount() {
        return this.edgeCount;
    }

    @Override // com.google.common.graph.ValueGraph
    @NullableDecl
    public V edgeValueOrDefault(EndpointPair<N> endpointPair, @NullableDecl V v5) {
        validateEndpoints(endpointPair);
        return edgeValueOrDefault_internal(endpointPair.nodeU(), endpointPair.nodeV(), v5);
    }

    protected final V edgeValueOrDefault_internal(N n6, N n7, V v5) {
        GraphConnections<N, V> graphConnections = this.nodeConnections.get(n6);
        V value = graphConnections == null ? null : graphConnections.value(n7);
        return value == null ? v5 : value;
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        return isOrderingCompatible(endpointPair) && hasEdgeConnecting_internal(endpointPair.nodeU(), endpointPair.nodeV());
    }

    protected final boolean hasEdgeConnecting_internal(N n6, N n7) {
        GraphConnections<N, V> graphConnections = this.nodeConnections.get(n6);
        return graphConnections != null && graphConnections.successors().contains(n7);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean isDirected() {
        return this.isDirected;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public ElementOrder<N> nodeOrder() {
        return this.nodeOrder;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public Set<N> nodes() {
        return this.nodeConnections.unmodifiableKeySet();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
    public Set<N> predecessors(N n6) {
        return checkedConnections(n6).predecessors();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
    public Set<N> successors(N n6) {
        return checkedConnections(n6).successors();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public Set<N> adjacentNodes(N n6) {
        return checkedConnections(n6).adjacentNodes();
    }

    ConfigurableValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder, Map<N, GraphConnections<N, V>> map, long j6) {
        this.isDirected = abstractGraphBuilder.directed;
        this.allowsSelfLoops = abstractGraphBuilder.allowsSelfLoops;
        this.nodeOrder = (ElementOrder<N>) abstractGraphBuilder.nodeOrder.cast();
        this.nodeConnections = map instanceof TreeMap ? new MapRetrievalCache<>(map) : new MapIteratorCache<>(map);
        this.edgeCount = Graphs.checkNonNegative(j6);
    }
}
