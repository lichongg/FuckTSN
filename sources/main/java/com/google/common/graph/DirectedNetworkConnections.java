package com.google.common.graph;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class DirectedNetworkConnections<N, E> extends AbstractDirectedNetworkConnections<N, E> {
    static <N, E> DirectedNetworkConnections<N, E> of() {
        return new DirectedNetworkConnections<>(HashBiMap.create(2), HashBiMap.create(2), 0);
    }

    static <N, E> DirectedNetworkConnections<N, E> ofImmutable(Map<E, N> map, Map<E, N> map2, int i6) {
        return new DirectedNetworkConnections<>(ImmutableBiMap.copyOf((Map) map), ImmutableBiMap.copyOf((Map) map2), i6);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> edgesConnecting(N n6) {
        return new EdgesConnecting(((BiMap) this.outEdgeMap).inverse(), n6);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> predecessors() {
        return Collections.unmodifiableSet(((BiMap) this.inEdgeMap).values());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> successors() {
        return Collections.unmodifiableSet(((BiMap) this.outEdgeMap).values());
    }

    protected DirectedNetworkConnections(Map<E, N> map, Map<E, N> map2, int i6) {
        super(map, map2, i6);
    }
}
