package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class AbstractUndirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
    protected final Map<E, N> incidentEdgeMap;

    @Override // com.google.common.graph.NetworkConnections
    public void addInEdge(E e6, N n6, boolean z5) {
        if (z5) {
            return;
        }
        addOutEdge(e6, n6);
    }

    @Override // com.google.common.graph.NetworkConnections
    public void addOutEdge(E e6, N n6) {
        Preconditions.checkState(this.incidentEdgeMap.put(e6, n6) == null);
    }

    @Override // com.google.common.graph.NetworkConnections
    public N adjacentNode(E e6) {
        return (N) Preconditions.checkNotNull(this.incidentEdgeMap.get(e6));
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> incidentEdges() {
        return Collections.unmodifiableSet(this.incidentEdgeMap.keySet());
    }

    @Override // com.google.common.graph.NetworkConnections
    public N removeInEdge(E e6, boolean z5) {
        if (z5) {
            return null;
        }
        return removeOutEdge(e6);
    }

    @Override // com.google.common.graph.NetworkConnections
    public N removeOutEdge(E e6) {
        return (N) Preconditions.checkNotNull(this.incidentEdgeMap.remove(e6));
    }

    protected AbstractUndirectedNetworkConnections(Map<E, N> map) {
        this.incidentEdgeMap = (Map) Preconditions.checkNotNull(map);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> inEdges() {
        return incidentEdges();
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> outEdges() {
        return incidentEdges();
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> predecessors() {
        return adjacentNodes();
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> successors() {
        return adjacentNodes();
    }
}
