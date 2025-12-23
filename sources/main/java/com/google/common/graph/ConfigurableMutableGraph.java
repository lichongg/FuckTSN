package com.google.common.graph;

import com.google.common.graph.GraphConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class ConfigurableMutableGraph<N> extends ForwardingGraph<N> implements MutableGraph<N> {
    private final MutableValueGraph<N, GraphConstants.Presence> backingValueGraph;

    @Override // com.google.common.graph.MutableGraph
    public boolean putEdge(N n6, N n7) {
        return this.backingValueGraph.putEdgeValue(n6, n7, GraphConstants.Presence.EDGE_EXISTS) == null;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeEdge(N n6, N n7) {
        return this.backingValueGraph.removeEdge(n6, n7) != null;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean addNode(N n6) {
        return this.backingValueGraph.addNode(n6);
    }

    @Override // com.google.common.graph.ForwardingGraph
    protected BaseGraph<N> delegate() {
        return this.backingValueGraph;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean putEdge(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return putEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeEdge(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return removeEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeNode(N n6) {
        return this.backingValueGraph.removeNode(n6);
    }

    ConfigurableMutableGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        this.backingValueGraph = new ConfigurableMutableValueGraph(abstractGraphBuilder);
    }
}
