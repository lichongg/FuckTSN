package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class UndirectedMultiNetworkConnections<N, E> extends AbstractUndirectedNetworkConnections<N, E> {

    @LazyInit
    private transient Reference<Multiset<N>> adjacentNodesReference;

    /* JADX INFO: Access modifiers changed from: private */
    public Multiset<N> adjacentNodesMultiset() {
        Multiset<N> multiset = (Multiset) getReference(this.adjacentNodesReference);
        if (multiset != null) {
            return multiset;
        }
        HashMultiset create = HashMultiset.create(this.incidentEdgeMap.values());
        this.adjacentNodesReference = new SoftReference(create);
        return create;
    }

    @NullableDecl
    private static <T> T getReference(@NullableDecl Reference<T> reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    static <N, E> UndirectedMultiNetworkConnections<N, E> of() {
        return new UndirectedMultiNetworkConnections<>(new HashMap(2, 1.0f));
    }

    static <N, E> UndirectedMultiNetworkConnections<N, E> ofImmutable(Map<E, N> map) {
        return new UndirectedMultiNetworkConnections<>(ImmutableMap.copyOf((Map) map));
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public void addInEdge(E e6, N n6, boolean z5) {
        if (z5) {
            return;
        }
        addOutEdge(e6, n6);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> edgesConnecting(final N n6) {
        return new MultiEdgesConnecting<E>(this.incidentEdgeMap, n6) { // from class: com.google.common.graph.UndirectedMultiNetworkConnections.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return UndirectedMultiNetworkConnections.this.adjacentNodesMultiset().count(n6);
            }
        };
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public N removeInEdge(E e6, boolean z5) {
        if (z5) {
            return null;
        }
        return removeOutEdge(e6);
    }

    private UndirectedMultiNetworkConnections(Map<E, N> map) {
        super(map);
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public void addOutEdge(E e6, N n6) {
        super.addOutEdge(e6, n6);
        Multiset multiset = (Multiset) getReference(this.adjacentNodesReference);
        if (multiset != null) {
            Preconditions.checkState(multiset.add(n6));
        }
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> adjacentNodes() {
        return Collections.unmodifiableSet(adjacentNodesMultiset().elementSet());
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public N removeOutEdge(E e6) {
        N n6 = (N) super.removeOutEdge(e6);
        Multiset multiset = (Multiset) getReference(this.adjacentNodesReference);
        if (multiset != null) {
            Preconditions.checkState(multiset.remove(n6));
        }
        return n6;
    }
}
