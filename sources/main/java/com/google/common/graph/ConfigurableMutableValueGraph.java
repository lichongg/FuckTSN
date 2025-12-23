package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class ConfigurableMutableValueGraph<N, V> extends ConfigurableValueGraph<N, V> implements MutableValueGraph<N, V> {
    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public V putEdgeValue(N n6, N n7, V v5) {
        Preconditions.checkNotNull(n6, "nodeU");
        Preconditions.checkNotNull(n7, "nodeV");
        Preconditions.checkNotNull(v5, "value");
        if (!allowsSelfLoops()) {
            Preconditions.checkArgument(!n6.equals(n7), "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", n6);
        }
        GraphConnections<N, V> graphConnections = this.nodeConnections.get(n6);
        if (graphConnections == null) {
            graphConnections = addNodeInternal(n6);
        }
        V addSuccessor = graphConnections.addSuccessor(n7, v5);
        GraphConnections<N, V> graphConnections2 = this.nodeConnections.get(n7);
        if (graphConnections2 == null) {
            graphConnections2 = addNodeInternal(n7);
        }
        graphConnections2.addPredecessor(n6, v5);
        if (addSuccessor == null) {
            long j6 = this.edgeCount + 1;
            this.edgeCount = j6;
            Graphs.checkPositive(j6);
        }
        return addSuccessor;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public V removeEdge(N n6, N n7) {
        Preconditions.checkNotNull(n6, "nodeU");
        Preconditions.checkNotNull(n7, "nodeV");
        GraphConnections<N, V> graphConnections = this.nodeConnections.get(n6);
        GraphConnections<N, V> graphConnections2 = this.nodeConnections.get(n7);
        if (graphConnections == null || graphConnections2 == null) {
            return null;
        }
        V removeSuccessor = graphConnections.removeSuccessor(n7);
        if (removeSuccessor != null) {
            graphConnections2.removePredecessor(n6);
            long j6 = this.edgeCount - 1;
            this.edgeCount = j6;
            Graphs.checkNonNegative(j6);
        }
        return removeSuccessor;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public boolean addNode(N n6) {
        Preconditions.checkNotNull(n6, "node");
        if (containsNode(n6)) {
            return false;
        }
        addNodeInternal(n6);
        return true;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public boolean removeNode(N n6) {
        Preconditions.checkNotNull(n6, "node");
        GraphConnections<N, V> graphConnections = this.nodeConnections.get(n6);
        if (graphConnections == null) {
            return false;
        }
        if (allowsSelfLoops() && graphConnections.removeSuccessor(n6) != null) {
            graphConnections.removePredecessor(n6);
            this.edgeCount--;
        }
        Iterator<N> it = graphConnections.successors().iterator();
        while (it.hasNext()) {
            this.nodeConnections.getWithoutCaching(it.next()).removePredecessor(n6);
            this.edgeCount--;
        }
        if (isDirected()) {
            Iterator<N> it2 = graphConnections.predecessors().iterator();
            while (it2.hasNext()) {
                Preconditions.checkState(this.nodeConnections.getWithoutCaching(it2.next()).removeSuccessor(n6) != null);
                this.edgeCount--;
            }
        }
        this.nodeConnections.remove(n6);
        Graphs.checkNonNegative(this.edgeCount);
        return true;
    }

    ConfigurableMutableValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        super(abstractGraphBuilder);
    }

    @CanIgnoreReturnValue
    private GraphConnections<N, V> addNodeInternal(N n6) {
        boolean z5;
        GraphConnections<N, V> newConnections = newConnections();
        if (this.nodeConnections.put(n6, newConnections) == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkState(z5);
        return newConnections;
    }

    private GraphConnections<N, V> newConnections() {
        if (isDirected()) {
            return DirectedGraphConnections.of();
        }
        return UndirectedGraphConnections.of();
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public V removeEdge(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return removeEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public V putEdgeValue(EndpointPair<N> endpointPair, V v5) {
        validateEndpoints(endpointPair);
        return putEdgeValue(endpointPair.nodeU(), endpointPair.nodeV(), v5);
    }
}
