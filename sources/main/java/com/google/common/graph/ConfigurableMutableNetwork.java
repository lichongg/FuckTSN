package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class ConfigurableMutableNetwork<N, E> extends ConfigurableNetwork<N, E> implements MutableNetwork<N, E> {
    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean addEdge(N n6, N n7, E e6) {
        Preconditions.checkNotNull(n6, "nodeU");
        Preconditions.checkNotNull(n7, "nodeV");
        Preconditions.checkNotNull(e6, "edge");
        if (containsEdge(e6)) {
            EndpointPair<N> incidentNodes = incidentNodes(e6);
            EndpointPair of = EndpointPair.of(this, n6, n7);
            Preconditions.checkArgument(incidentNodes.equals(of), "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s.", e6, incidentNodes, of);
            return false;
        }
        NetworkConnections<N, E> networkConnections = this.nodeConnections.get(n6);
        if (!allowsParallelEdges()) {
            Preconditions.checkArgument(networkConnections == null || !networkConnections.successors().contains(n7), "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder.", n6, n7);
        }
        boolean equals = n6.equals(n7);
        if (!allowsSelfLoops()) {
            Preconditions.checkArgument(!equals, "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", n6);
        }
        if (networkConnections == null) {
            networkConnections = addNodeInternal(n6);
        }
        networkConnections.addOutEdge(e6, n7);
        NetworkConnections<N, E> networkConnections2 = this.nodeConnections.get(n7);
        if (networkConnections2 == null) {
            networkConnections2 = addNodeInternal(n7);
        }
        networkConnections2.addInEdge(e6, n6, equals);
        this.edgeToReferenceNode.put(e6, n6);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean addNode(N n6) {
        Preconditions.checkNotNull(n6, "node");
        if (containsNode(n6)) {
            return false;
        }
        addNodeInternal(n6);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean removeEdge(E e6) {
        Preconditions.checkNotNull(e6, "edge");
        N n6 = this.edgeToReferenceNode.get(e6);
        boolean z5 = false;
        if (n6 == null) {
            return false;
        }
        NetworkConnections<N, E> networkConnections = this.nodeConnections.get(n6);
        N adjacentNode = networkConnections.adjacentNode(e6);
        NetworkConnections<N, E> networkConnections2 = this.nodeConnections.get(adjacentNode);
        networkConnections.removeOutEdge(e6);
        if (allowsSelfLoops() && n6.equals(adjacentNode)) {
            z5 = true;
        }
        networkConnections2.removeInEdge(e6, z5);
        this.edgeToReferenceNode.remove(e6);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean removeNode(N n6) {
        Preconditions.checkNotNull(n6, "node");
        NetworkConnections<N, E> networkConnections = this.nodeConnections.get(n6);
        if (networkConnections == null) {
            return false;
        }
        UnmodifiableIterator<E> it = ImmutableList.copyOf((Collection) networkConnections.incidentEdges()).iterator();
        while (it.hasNext()) {
            removeEdge(it.next());
        }
        this.nodeConnections.remove(n6);
        return true;
    }

    ConfigurableMutableNetwork(NetworkBuilder<? super N, ? super E> networkBuilder) {
        super(networkBuilder);
    }

    @CanIgnoreReturnValue
    private NetworkConnections<N, E> addNodeInternal(N n6) {
        boolean z5;
        NetworkConnections<N, E> newConnections = newConnections();
        if (this.nodeConnections.put(n6, newConnections) == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkState(z5);
        return newConnections;
    }

    private NetworkConnections<N, E> newConnections() {
        if (isDirected()) {
            if (allowsParallelEdges()) {
                return DirectedMultiNetworkConnections.of();
            }
            return DirectedNetworkConnections.of();
        }
        if (allowsParallelEdges()) {
            return UndirectedMultiNetworkConnections.of();
        }
        return UndirectedNetworkConnections.of();
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean addEdge(EndpointPair<N> endpointPair, E e6) {
        validateEndpoints(endpointPair);
        return addEdge(endpointPair.nodeU(), endpointPair.nodeV(), e6);
    }
}
