package com.google.common.graph;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.Immutable;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Immutable(containerOf = {"N", ExifInterface.LONGITUDE_EAST})
@Beta
/* loaded from: D:\Downloads\app\classes5.dex */
public final class ImmutableNetwork<N, E> extends ConfigurableNetwork<N, E> {
    public static <N, E> ImmutableNetwork<N, E> copyOf(Network<N, E> network) {
        return network instanceof ImmutableNetwork ? (ImmutableNetwork) network : new ImmutableNetwork<>(network);
    }

    private static <N, E> Function<E, N> adjacentNodeFn(final Network<N, E> network, final N n6) {
        return new Function<E, N>() { // from class: com.google.common.graph.ImmutableNetwork.3
            @Override // com.google.common.base.Function
            public N apply(E e6) {
                return Network.this.incidentNodes(e6).adjacentNode(n6);
            }
        };
    }

    @Deprecated
    public static <N, E> ImmutableNetwork<N, E> copyOf(ImmutableNetwork<N, E> immutableNetwork) {
        return (ImmutableNetwork) Preconditions.checkNotNull(immutableNetwork);
    }

    private static <N, E> Function<E, N> sourceNodeFn(final Network<N, E> network) {
        return new Function<E, N>() { // from class: com.google.common.graph.ImmutableNetwork.1
            @Override // com.google.common.base.Function
            public N apply(E e6) {
                return Network.this.incidentNodes(e6).source();
            }
        };
    }

    private static <N, E> Function<E, N> targetNodeFn(final Network<N, E> network) {
        return new Function<E, N>() { // from class: com.google.common.graph.ImmutableNetwork.2
            @Override // com.google.common.base.Function
            public N apply(E e6) {
                return Network.this.incidentNodes(e6).target();
            }
        };
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public ImmutableGraph<N> asGraph() {
        return new ImmutableGraph<>(super.asGraph());
    }

    private ImmutableNetwork(Network<N, E> network) {
        super(NetworkBuilder.from(network), getNodeConnections(network), getEdgeToReferenceNode(network));
    }

    private static <N, E> NetworkConnections<N, E> connectionsOf(Network<N, E> network, N n6) {
        if (network.isDirected()) {
            Map asMap = Maps.asMap(network.inEdges(n6), sourceNodeFn(network));
            Map asMap2 = Maps.asMap(network.outEdges(n6), targetNodeFn(network));
            int size = network.edgesConnecting(n6, n6).size();
            if (network.allowsParallelEdges()) {
                return DirectedMultiNetworkConnections.ofImmutable(asMap, asMap2, size);
            }
            return DirectedNetworkConnections.ofImmutable(asMap, asMap2, size);
        }
        Map asMap3 = Maps.asMap(network.incidentEdges(n6), adjacentNodeFn(network, n6));
        if (network.allowsParallelEdges()) {
            return UndirectedMultiNetworkConnections.ofImmutable(asMap3);
        }
        return UndirectedNetworkConnections.ofImmutable(asMap3);
    }

    private static <N, E> Map<E, N> getEdgeToReferenceNode(Network<N, E> network) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (E e6 : network.edges()) {
            builder.put(e6, network.incidentNodes(e6).nodeU());
        }
        return builder.build();
    }

    private static <N, E> Map<N, NetworkConnections<N, E>> getNodeConnections(Network<N, E> network) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (N n6 : network.nodes()) {
            builder.put(n6, connectionsOf(network, n6));
        }
        return builder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set adjacentNodes(Object obj) {
        return super.adjacentNodes(obj);
    }

    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ boolean allowsParallelEdges() {
        return super.allowsParallelEdges();
    }

    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ boolean allowsSelfLoops() {
        return super.allowsSelfLoops();
    }

    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ ElementOrder edgeOrder() {
        return super.edgeOrder();
    }

    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set edges() {
        return super.edges();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set edgesConnecting(Object obj, Object obj2) {
        return super.edgesConnecting(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set inEdges(Object obj) {
        return super.inEdges(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set incidentEdges(Object obj) {
        return super.incidentEdges(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ EndpointPair incidentNodes(Object obj) {
        return super.incidentNodes(obj);
    }

    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ boolean isDirected() {
        return super.isDirected();
    }

    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ ElementOrder nodeOrder() {
        return super.nodeOrder();
    }

    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set nodes() {
        return super.nodes();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set outEdges(Object obj) {
        return super.outEdges(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ Set predecessors(Object obj) {
        return super.predecessors((ImmutableNetwork<N, E>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ Set successors(Object obj) {
        return super.successors((ImmutableNetwork<N, E>) obj);
    }
}
