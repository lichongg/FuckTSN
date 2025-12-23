package com.google.common.graph;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class ConfigurableNetwork<N, E> extends AbstractNetwork<N, E> {
    private final boolean allowsParallelEdges;
    private final boolean allowsSelfLoops;
    private final ElementOrder<E> edgeOrder;
    protected final MapIteratorCache<E, N> edgeToReferenceNode;
    private final boolean isDirected;
    protected final MapIteratorCache<N, NetworkConnections<N, E>> nodeConnections;
    private final ElementOrder<N> nodeOrder;

    ConfigurableNetwork(NetworkBuilder<? super N, ? super E> networkBuilder) {
        this(networkBuilder, networkBuilder.nodeOrder.createMap(networkBuilder.expectedNodeCount.or((Optional<Integer>) 10).intValue()), networkBuilder.edgeOrder.createMap(networkBuilder.expectedEdgeCount.or((Optional<Integer>) 20).intValue()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
        return predecessors((ConfigurableNetwork<N, E>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
        return successors((ConfigurableNetwork<N, E>) obj);
    }

    @Override // com.google.common.graph.Network
    public boolean allowsParallelEdges() {
        return this.allowsParallelEdges;
    }

    @Override // com.google.common.graph.Network
    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    protected final NetworkConnections<N, E> checkedConnections(N n6) {
        NetworkConnections<N, E> networkConnections = this.nodeConnections.get(n6);
        if (networkConnections != null) {
            return networkConnections;
        }
        Preconditions.checkNotNull(n6);
        throw new IllegalArgumentException(String.format("Node %s is not an element of this graph.", n6));
    }

    protected final N checkedReferenceNode(E e6) {
        N n6 = this.edgeToReferenceNode.get(e6);
        if (n6 != null) {
            return n6;
        }
        Preconditions.checkNotNull(e6);
        throw new IllegalArgumentException(String.format("Edge %s is not an element of this graph.", e6));
    }

    protected final boolean containsEdge(@NullableDecl E e6) {
        return this.edgeToReferenceNode.containsKey(e6);
    }

    protected final boolean containsNode(@NullableDecl N n6) {
        return this.nodeConnections.containsKey(n6);
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<E> edgeOrder() {
        return this.edgeOrder;
    }

    @Override // com.google.common.graph.Network
    public Set<E> edges() {
        return this.edgeToReferenceNode.unmodifiableKeySet();
    }

    @Override // com.google.common.graph.Network
    public boolean isDirected() {
        return this.isDirected;
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<N> nodeOrder() {
        return this.nodeOrder;
    }

    @Override // com.google.common.graph.Network
    public Set<N> nodes() {
        return this.nodeConnections.unmodifiableKeySet();
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
    public Set<N> predecessors(N n6) {
        return checkedConnections(n6).predecessors();
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
    public Set<N> successors(N n6) {
        return checkedConnections(n6).successors();
    }

    @Override // com.google.common.graph.Network
    public Set<N> adjacentNodes(N n6) {
        return checkedConnections(n6).adjacentNodes();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> edgesConnecting(N n6, N n7) {
        NetworkConnections<N, E> checkedConnections = checkedConnections(n6);
        if (!this.allowsSelfLoops && n6 == n7) {
            return ImmutableSet.of();
        }
        Preconditions.checkArgument(containsNode(n7), "Node %s is not an element of this graph.", n7);
        return checkedConnections.edgesConnecting(n7);
    }

    @Override // com.google.common.graph.Network
    public Set<E> inEdges(N n6) {
        return checkedConnections(n6).inEdges();
    }

    @Override // com.google.common.graph.Network
    public Set<E> incidentEdges(N n6) {
        return checkedConnections(n6).incidentEdges();
    }

    @Override // com.google.common.graph.Network
    public EndpointPair<N> incidentNodes(E e6) {
        N checkedReferenceNode = checkedReferenceNode(e6);
        return EndpointPair.of(this, checkedReferenceNode, this.nodeConnections.get(checkedReferenceNode).adjacentNode(e6));
    }

    @Override // com.google.common.graph.Network
    public Set<E> outEdges(N n6) {
        return checkedConnections(n6).outEdges();
    }

    ConfigurableNetwork(NetworkBuilder<? super N, ? super E> networkBuilder, Map<N, NetworkConnections<N, E>> map, Map<E, N> map2) {
        this.isDirected = networkBuilder.directed;
        this.allowsParallelEdges = networkBuilder.allowsParallelEdges;
        this.allowsSelfLoops = networkBuilder.allowsSelfLoops;
        this.nodeOrder = (ElementOrder<N>) networkBuilder.nodeOrder.cast();
        this.edgeOrder = (ElementOrder<E>) networkBuilder.edgeOrder.cast();
        this.nodeConnections = map instanceof TreeMap ? new MapRetrievalCache<>(map) : new MapIteratorCache<>(map);
        this.edgeToReferenceNode = new MapIteratorCache<>(map2);
    }
}
