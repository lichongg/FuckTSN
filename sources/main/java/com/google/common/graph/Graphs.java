package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Graphs {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum NodeVisitState {
        PENDING,
        COMPLETE
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class TransposedGraph<N> extends ForwardingGraph<N> {
        private final Graph<N> graph;

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(N n6, N n7) {
            return delegate().hasEdgeConnecting(n7, n6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.PredecessorsFunction
        public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
            return predecessors((TransposedGraph<N>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.SuccessorsFunction
        public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
            return successors((TransposedGraph<N>) obj);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.graph.ForwardingGraph
        public Graph<N> delegate() {
            return this.graph;
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
            return delegate().hasEdgeConnecting(Graphs.transpose(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
        public Set<N> predecessors(N n6) {
            return delegate().successors((Graph<N>) n6);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
        public Set<N> successors(N n6) {
            return delegate().predecessors((Graph<N>) n6);
        }

        TransposedGraph(Graph<N> graph) {
            this.graph = graph;
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int inDegree(N n6) {
            return delegate().outDegree(n6);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int outDegree(N n6) {
            return delegate().inDegree(n6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class TransposedNetwork<N, E> extends ForwardingNetwork<N, E> {
        private final Network<N, E> network;

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public E edgeConnectingOrNull(N n6, N n7) {
            return delegate().edgeConnectingOrNull(n7, n6);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public Set<E> edgesConnecting(N n6, N n7) {
            return delegate().edgesConnecting(n7, n6);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public boolean hasEdgeConnecting(N n6, N n7) {
            return delegate().hasEdgeConnecting(n7, n6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.PredecessorsFunction
        public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
            return predecessors((TransposedNetwork<N, E>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.SuccessorsFunction
        public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
            return successors((TransposedNetwork<N, E>) obj);
        }

        @Override // com.google.common.graph.ForwardingNetwork
        protected Network<N, E> delegate() {
            return this.network;
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public E edgeConnectingOrNull(EndpointPair<N> endpointPair) {
            return delegate().edgeConnectingOrNull(Graphs.transpose(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public Set<E> edgesConnecting(EndpointPair<N> endpointPair) {
            return delegate().edgesConnecting(Graphs.transpose(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
            return delegate().hasEdgeConnecting(Graphs.transpose(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
        public Set<N> predecessors(N n6) {
            return delegate().successors((Network<N, E>) n6);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
        public Set<N> successors(N n6) {
            return delegate().predecessors((Network<N, E>) n6);
        }

        TransposedNetwork(Network<N, E> network) {
            this.network = network;
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public int inDegree(N n6) {
            return delegate().outDegree(n6);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public Set<E> inEdges(N n6) {
            return delegate().outEdges(n6);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public EndpointPair<N> incidentNodes(E e6) {
            EndpointPair<N> incidentNodes = delegate().incidentNodes(e6);
            return EndpointPair.of((Network<?, ?>) this.network, (Object) incidentNodes.nodeV(), (Object) incidentNodes.nodeU());
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public int outDegree(N n6) {
            return delegate().inDegree(n6);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public Set<E> outEdges(N n6) {
            return delegate().inEdges(n6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class TransposedValueGraph<N, V> extends ForwardingValueGraph<N, V> {
        private final ValueGraph<N, V> graph;

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.ValueGraph
        @NullableDecl
        public V edgeValueOrDefault(N n6, N n7, @NullableDecl V v5) {
            return delegate().edgeValueOrDefault(n7, n6, v5);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(N n6, N n7) {
            return delegate().hasEdgeConnecting(n7, n6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.PredecessorsFunction
        public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
            return predecessors((TransposedValueGraph<N, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.SuccessorsFunction
        public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
            return successors((TransposedValueGraph<N, V>) obj);
        }

        @Override // com.google.common.graph.ForwardingValueGraph
        protected ValueGraph<N, V> delegate() {
            return this.graph;
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.ValueGraph
        @NullableDecl
        public V edgeValueOrDefault(EndpointPair<N> endpointPair, @NullableDecl V v5) {
            return delegate().edgeValueOrDefault(Graphs.transpose(endpointPair), v5);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
            return delegate().hasEdgeConnecting(Graphs.transpose(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
        public Set<N> predecessors(N n6) {
            return delegate().successors((ValueGraph<N, V>) n6);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
        public Set<N> successors(N n6) {
            return delegate().predecessors((ValueGraph<N, V>) n6);
        }

        TransposedValueGraph(ValueGraph<N, V> valueGraph) {
            this.graph = valueGraph;
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int inDegree(N n6) {
            return delegate().outDegree(n6);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int outDegree(N n6) {
            return delegate().inDegree(n6);
        }
    }

    @CanIgnoreReturnValue
    static int checkNonNegative(int i6) {
        Preconditions.checkArgument(i6 >= 0, "Not true that %s is non-negative.", i6);
        return i6;
    }

    @CanIgnoreReturnValue
    static int checkPositive(int i6) {
        Preconditions.checkArgument(i6 > 0, "Not true that %s is positive.", i6);
        return i6;
    }

    public static <N> MutableGraph<N> copyOf(Graph<N> graph) {
        MutableGraph<N> mutableGraph = (MutableGraph<N>) GraphBuilder.from(graph).expectedNodeCount(graph.nodes().size()).build();
        Iterator<N> it = graph.nodes().iterator();
        while (it.hasNext()) {
            mutableGraph.addNode(it.next());
        }
        for (EndpointPair<N> endpointPair : graph.edges()) {
            mutableGraph.putEdge(endpointPair.nodeU(), endpointPair.nodeV());
        }
        return mutableGraph;
    }

    public static <N> boolean hasCycle(Graph<N> graph) {
        int size = graph.edges().size();
        if (size == 0) {
            return false;
        }
        if (!graph.isDirected() && size >= graph.nodes().size()) {
            return true;
        }
        HashMap newHashMapWithExpectedSize = Maps.newHashMapWithExpectedSize(graph.nodes().size());
        Iterator<N> it = graph.nodes().iterator();
        while (it.hasNext()) {
            if (subgraphHasCycle(graph, newHashMapWithExpectedSize, it.next(), null)) {
                return true;
            }
        }
        return false;
    }

    public static <N> MutableGraph<N> inducedSubgraph(Graph<N> graph, Iterable<? extends N> iterable) {
        ConfigurableMutableGraph configurableMutableGraph = iterable instanceof Collection ? (MutableGraph<N>) GraphBuilder.from(graph).expectedNodeCount(((Collection) iterable).size()).build() : (MutableGraph<N>) GraphBuilder.from(graph).build();
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            configurableMutableGraph.addNode(it.next());
        }
        for (N n6 : configurableMutableGraph.nodes()) {
            for (N n7 : graph.successors((Graph<N>) n6)) {
                if (configurableMutableGraph.nodes().contains(n7)) {
                    configurableMutableGraph.putEdge(n6, n7);
                }
            }
        }
        return configurableMutableGraph;
    }

    public static <N> Graph<N> transpose(Graph<N> graph) {
        return !graph.isDirected() ? graph : graph instanceof TransposedGraph ? ((TransposedGraph) graph).graph : new TransposedGraph(graph);
    }

    @CanIgnoreReturnValue
    static long checkNonNegative(long j6) {
        Preconditions.checkArgument(j6 >= 0, "Not true that %s is non-negative.", j6);
        return j6;
    }

    @CanIgnoreReturnValue
    static long checkPositive(long j6) {
        Preconditions.checkArgument(j6 > 0, "Not true that %s is positive.", j6);
        return j6;
    }

    private Graphs() {
    }

    private static boolean canTraverseWithoutReusingEdge(Graph<?> graph, Object obj, @NullableDecl Object obj2) {
        if (!graph.isDirected() && Objects.equal(obj2, obj)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <N> Set<N> reachableNodes(Graph<N> graph, N n6) {
        Preconditions.checkArgument(graph.nodes().contains(n6), "Node %s is not an element of this graph.", n6);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayDeque arrayDeque = new ArrayDeque();
        linkedHashSet.add(n6);
        arrayDeque.add(n6);
        while (!arrayDeque.isEmpty()) {
            for (Object obj : graph.successors((Graph<N>) arrayDeque.remove())) {
                if (linkedHashSet.add(obj)) {
                    arrayDeque.add(obj);
                }
            }
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    private static <N> boolean subgraphHasCycle(Graph<N> graph, Map<Object, NodeVisitState> map, N n6, @NullableDecl N n7) {
        NodeVisitState nodeVisitState = map.get(n6);
        if (nodeVisitState == NodeVisitState.COMPLETE) {
            return false;
        }
        NodeVisitState nodeVisitState2 = NodeVisitState.PENDING;
        if (nodeVisitState == nodeVisitState2) {
            return true;
        }
        map.put(n6, nodeVisitState2);
        for (N n8 : graph.successors((Graph<N>) n6)) {
            if (canTraverseWithoutReusingEdge(graph, n8, n7) && subgraphHasCycle(graph, map, n8, n6)) {
                return true;
            }
        }
        map.put(n6, NodeVisitState.COMPLETE);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <N> Graph<N> transitiveClosure(Graph<N> graph) {
        ConfigurableMutableGraph build = GraphBuilder.from(graph).allowsSelfLoops(true).build();
        if (graph.isDirected()) {
            for (N n6 : graph.nodes()) {
                Iterator it = reachableNodes(graph, n6).iterator();
                while (it.hasNext()) {
                    build.putEdge(n6, it.next());
                }
            }
        } else {
            HashSet hashSet = new HashSet();
            for (N n7 : graph.nodes()) {
                if (!hashSet.contains(n7)) {
                    Set reachableNodes = reachableNodes(graph, n7);
                    hashSet.addAll(reachableNodes);
                    int i6 = 1;
                    for (Object obj : reachableNodes) {
                        int i7 = i6 + 1;
                        Iterator it2 = Iterables.limit(reachableNodes, i6).iterator();
                        while (it2.hasNext()) {
                            build.putEdge(obj, it2.next());
                        }
                        i6 = i7;
                    }
                }
            }
        }
        return build;
    }

    public static <N, V> ValueGraph<N, V> transpose(ValueGraph<N, V> valueGraph) {
        if (!valueGraph.isDirected()) {
            return valueGraph;
        }
        if (valueGraph instanceof TransposedValueGraph) {
            return ((TransposedValueGraph) valueGraph).graph;
        }
        return new TransposedValueGraph(valueGraph);
    }

    public static <N, V> MutableValueGraph<N, V> copyOf(ValueGraph<N, V> valueGraph) {
        MutableValueGraph<N, V> mutableValueGraph = (MutableValueGraph<N, V>) ValueGraphBuilder.from(valueGraph).expectedNodeCount(valueGraph.nodes().size()).build();
        Iterator<N> it = valueGraph.nodes().iterator();
        while (it.hasNext()) {
            mutableValueGraph.addNode(it.next());
        }
        for (EndpointPair<N> endpointPair : valueGraph.edges()) {
            mutableValueGraph.putEdgeValue(endpointPair.nodeU(), endpointPair.nodeV(), valueGraph.edgeValueOrDefault(endpointPair.nodeU(), endpointPair.nodeV(), null));
        }
        return mutableValueGraph;
    }

    public static boolean hasCycle(Network<?, ?> network) {
        if (network.isDirected() || !network.allowsParallelEdges() || network.edges().size() <= network.asGraph().edges().size()) {
            return hasCycle(network.asGraph());
        }
        return true;
    }

    public static <N, E> Network<N, E> transpose(Network<N, E> network) {
        if (!network.isDirected()) {
            return network;
        }
        if (network instanceof TransposedNetwork) {
            return ((TransposedNetwork) network).network;
        }
        return new TransposedNetwork(network);
    }

    public static <N, V> MutableValueGraph<N, V> inducedSubgraph(ValueGraph<N, V> valueGraph, Iterable<? extends N> iterable) {
        ConfigurableMutableValueGraph configurableMutableValueGraph;
        if (iterable instanceof Collection) {
            configurableMutableValueGraph = (MutableValueGraph<N, V>) ValueGraphBuilder.from(valueGraph).expectedNodeCount(((Collection) iterable).size()).build();
        } else {
            configurableMutableValueGraph = (MutableValueGraph<N, V>) ValueGraphBuilder.from(valueGraph).build();
        }
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            configurableMutableValueGraph.addNode(it.next());
        }
        for (N n6 : configurableMutableValueGraph.nodes()) {
            for (N n7 : valueGraph.successors((ValueGraph<N, V>) n6)) {
                if (configurableMutableValueGraph.nodes().contains(n7)) {
                    configurableMutableValueGraph.putEdgeValue(n6, n7, valueGraph.edgeValueOrDefault(n6, n7, null));
                }
            }
        }
        return configurableMutableValueGraph;
    }

    public static <N, E> MutableNetwork<N, E> copyOf(Network<N, E> network) {
        MutableNetwork<N, E> mutableNetwork = (MutableNetwork<N, E>) NetworkBuilder.from(network).expectedNodeCount(network.nodes().size()).expectedEdgeCount(network.edges().size()).build();
        Iterator<N> it = network.nodes().iterator();
        while (it.hasNext()) {
            mutableNetwork.addNode(it.next());
        }
        for (E e6 : network.edges()) {
            EndpointPair<N> incidentNodes = network.incidentNodes(e6);
            mutableNetwork.addEdge(incidentNodes.nodeU(), incidentNodes.nodeV(), e6);
        }
        return mutableNetwork;
    }

    static <N> EndpointPair<N> transpose(EndpointPair<N> endpointPair) {
        return endpointPair.isOrdered() ? EndpointPair.ordered(endpointPair.target(), endpointPair.source()) : endpointPair;
    }

    public static <N, E> MutableNetwork<N, E> inducedSubgraph(Network<N, E> network, Iterable<? extends N> iterable) {
        ConfigurableMutableNetwork configurableMutableNetwork;
        if (iterable instanceof Collection) {
            configurableMutableNetwork = (MutableNetwork<N, E>) NetworkBuilder.from(network).expectedNodeCount(((Collection) iterable).size()).build();
        } else {
            configurableMutableNetwork = (MutableNetwork<N, E>) NetworkBuilder.from(network).build();
        }
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            configurableMutableNetwork.addNode(it.next());
        }
        for (E e6 : configurableMutableNetwork.nodes()) {
            for (E e7 : network.outEdges(e6)) {
                N adjacentNode = network.incidentNodes(e7).adjacentNode(e6);
                if (configurableMutableNetwork.nodes().contains(adjacentNode)) {
                    configurableMutableNetwork.addEdge(e6, adjacentNode, e7);
                }
            }
        }
        return configurableMutableNetwork;
    }
}
