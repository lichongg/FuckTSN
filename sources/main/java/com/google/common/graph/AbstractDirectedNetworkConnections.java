package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class AbstractDirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
    protected final Map<E, N> inEdgeMap;
    protected final Map<E, N> outEdgeMap;
    private int selfLoopCount;

    @Override // com.google.common.graph.NetworkConnections
    public void addInEdge(E e6, N n6, boolean z5) {
        if (z5) {
            int i6 = this.selfLoopCount + 1;
            this.selfLoopCount = i6;
            Graphs.checkPositive(i6);
        }
        Preconditions.checkState(this.inEdgeMap.put(e6, n6) == null);
    }

    @Override // com.google.common.graph.NetworkConnections
    public void addOutEdge(E e6, N n6) {
        Preconditions.checkState(this.outEdgeMap.put(e6, n6) == null);
    }

    @Override // com.google.common.graph.NetworkConnections
    public N adjacentNode(E e6) {
        return (N) Preconditions.checkNotNull(this.outEdgeMap.get(e6));
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> inEdges() {
        return Collections.unmodifiableSet(this.inEdgeMap.keySet());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> incidentEdges() {
        return new AbstractSet<E>() { // from class: com.google.common.graph.AbstractDirectedNetworkConnections.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                return AbstractDirectedNetworkConnections.this.inEdgeMap.containsKey(obj) || AbstractDirectedNetworkConnections.this.outEdgeMap.containsKey(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<E> iterator() {
                return Iterators.unmodifiableIterator((AbstractDirectedNetworkConnections.this.selfLoopCount == 0 ? Iterables.concat(AbstractDirectedNetworkConnections.this.inEdgeMap.keySet(), AbstractDirectedNetworkConnections.this.outEdgeMap.keySet()) : Sets.union(AbstractDirectedNetworkConnections.this.inEdgeMap.keySet(), AbstractDirectedNetworkConnections.this.outEdgeMap.keySet())).iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return IntMath.saturatedAdd(AbstractDirectedNetworkConnections.this.inEdgeMap.size(), AbstractDirectedNetworkConnections.this.outEdgeMap.size() - AbstractDirectedNetworkConnections.this.selfLoopCount);
            }
        };
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> outEdges() {
        return Collections.unmodifiableSet(this.outEdgeMap.keySet());
    }

    @Override // com.google.common.graph.NetworkConnections
    public N removeInEdge(E e6, boolean z5) {
        if (z5) {
            int i6 = this.selfLoopCount - 1;
            this.selfLoopCount = i6;
            Graphs.checkNonNegative(i6);
        }
        return (N) Preconditions.checkNotNull(this.inEdgeMap.remove(e6));
    }

    @Override // com.google.common.graph.NetworkConnections
    public N removeOutEdge(E e6) {
        return (N) Preconditions.checkNotNull(this.outEdgeMap.remove(e6));
    }

    protected AbstractDirectedNetworkConnections(Map<E, N> map, Map<E, N> map2, int i6) {
        boolean z5;
        this.inEdgeMap = (Map) Preconditions.checkNotNull(map);
        this.outEdgeMap = (Map) Preconditions.checkNotNull(map2);
        this.selfLoopCount = Graphs.checkNonNegative(i6);
        if (i6 <= map.size() && i6 <= map2.size()) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkState(z5);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> adjacentNodes() {
        return Sets.union(predecessors(), successors());
    }
}
