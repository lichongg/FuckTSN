package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class AbstractBaseGraph<N> implements BaseGraph<N> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class IncidentEdgeSet<N> extends AbstractSet<EndpointPair<N>> {
        protected final BaseGraph<N> graph;
        protected final N node;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static final class Directed<N> extends IncidentEdgeSet<N> {
            private Directed(BaseGraph<N> baseGraph, N n6) {
                super(baseGraph, n6);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair endpointPair = (EndpointPair) obj;
                if (!endpointPair.isOrdered()) {
                    return false;
                }
                Object source = endpointPair.source();
                Object target = endpointPair.target();
                if (this.node.equals(source) && this.graph.successors((BaseGraph<N>) this.node).contains(target)) {
                    return true;
                }
                return this.node.equals(target) && this.graph.predecessors((BaseGraph<N>) this.node).contains(source);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return Iterators.unmodifiableIterator(Iterators.concat(Iterators.transform(this.graph.predecessors((BaseGraph<N>) this.node).iterator(), new Function<N, EndpointPair<N>>() { // from class: com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.Directed.1
                    @Override // com.google.common.base.Function
                    public /* bridge */ /* synthetic */ Object apply(Object obj) {
                        return apply((AnonymousClass1) obj);
                    }

                    @Override // com.google.common.base.Function
                    public EndpointPair<N> apply(N n6) {
                        return EndpointPair.ordered(n6, Directed.this.node);
                    }
                }), Iterators.transform(Sets.difference(this.graph.successors((BaseGraph<N>) this.node), ImmutableSet.of(this.node)).iterator(), new Function<N, EndpointPair<N>>() { // from class: com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.Directed.2
                    @Override // com.google.common.base.Function
                    public /* bridge */ /* synthetic */ Object apply(Object obj) {
                        return apply((AnonymousClass2) obj);
                    }

                    @Override // com.google.common.base.Function
                    public EndpointPair<N> apply(N n6) {
                        return EndpointPair.ordered(Directed.this.node, n6);
                    }
                })));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return (this.graph.inDegree(this.node) + this.graph.outDegree(this.node)) - (this.graph.successors((BaseGraph<N>) this.node).contains(this.node) ? 1 : 0);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static final class Undirected<N> extends IncidentEdgeSet<N> {
            private Undirected(BaseGraph<N> baseGraph, N n6) {
                super(baseGraph, n6);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair endpointPair = (EndpointPair) obj;
                if (endpointPair.isOrdered()) {
                    return false;
                }
                Set<N> adjacentNodes = this.graph.adjacentNodes(this.node);
                Object nodeU = endpointPair.nodeU();
                Object nodeV = endpointPair.nodeV();
                if (this.node.equals(nodeV) && adjacentNodes.contains(nodeU)) {
                    return true;
                }
                return this.node.equals(nodeU) && adjacentNodes.contains(nodeV);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return Iterators.unmodifiableIterator(Iterators.transform(this.graph.adjacentNodes(this.node).iterator(), new Function<N, EndpointPair<N>>() { // from class: com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.Undirected.1
                    @Override // com.google.common.base.Function
                    public /* bridge */ /* synthetic */ Object apply(Object obj) {
                        return apply((AnonymousClass1) obj);
                    }

                    @Override // com.google.common.base.Function
                    public EndpointPair<N> apply(N n6) {
                        return EndpointPair.unordered(Undirected.this.node, n6);
                    }
                }));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.graph.adjacentNodes(this.node).size();
            }
        }

        private IncidentEdgeSet(BaseGraph<N> baseGraph, N n6) {
            this.graph = baseGraph;
            this.node = n6;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public static <N> IncidentEdgeSet<N> of(BaseGraph<N> baseGraph, N n6) {
            if (baseGraph.isDirected()) {
                return new Directed(baseGraph, n6);
            }
            return new Undirected(baseGraph, n6);
        }
    }

    @Override // com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(N n6, N n7) {
        Preconditions.checkNotNull(n6);
        Preconditions.checkNotNull(n7);
        return nodes().contains(n6) && successors((AbstractBaseGraph<N>) n6).contains(n7);
    }

    @Override // com.google.common.graph.BaseGraph
    public Set<EndpointPair<N>> edges() {
        return new AbstractSet<EndpointPair<N>>() { // from class: com.google.common.graph.AbstractBaseGraph.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair<?> endpointPair = (EndpointPair) obj;
                return AbstractBaseGraph.this.isOrderingCompatible(endpointPair) && AbstractBaseGraph.this.nodes().contains(endpointPair.nodeU()) && AbstractBaseGraph.this.successors((AbstractBaseGraph) endpointPair.nodeU()).contains(endpointPair.nodeV());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return EndpointPairIterator.of(AbstractBaseGraph.this);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return Ints.saturatedCast(AbstractBaseGraph.this.edgeCount());
            }
        };
    }

    AbstractBaseGraph() {
    }

    @Override // com.google.common.graph.BaseGraph
    public int degree(N n6) {
        int i6;
        if (isDirected()) {
            return IntMath.saturatedAdd(predecessors((AbstractBaseGraph<N>) n6).size(), successors((AbstractBaseGraph<N>) n6).size());
        }
        Set<N> adjacentNodes = adjacentNodes(n6);
        if (allowsSelfLoops() && adjacentNodes.contains(n6)) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        return IntMath.saturatedAdd(adjacentNodes.size(), i6);
    }

    protected long edgeCount() {
        boolean z5;
        long j6 = 0;
        while (nodes().iterator().hasNext()) {
            j6 += degree(r0.next());
        }
        if ((1 & j6) == 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkState(z5);
        return j6 >>> 1;
    }

    @Override // com.google.common.graph.BaseGraph
    public int inDegree(N n6) {
        if (isDirected()) {
            return predecessors((AbstractBaseGraph<N>) n6).size();
        }
        return degree(n6);
    }

    @Override // com.google.common.graph.BaseGraph
    public Set<EndpointPair<N>> incidentEdges(N n6) {
        Preconditions.checkNotNull(n6);
        Preconditions.checkArgument(nodes().contains(n6), "Node %s is not an element of this graph.", n6);
        return IncidentEdgeSet.of((BaseGraph) this, (Object) n6);
    }

    protected final boolean isOrderingCompatible(EndpointPair<?> endpointPair) {
        if (!endpointPair.isOrdered() && isDirected()) {
            return false;
        }
        return true;
    }

    @Override // com.google.common.graph.BaseGraph
    public int outDegree(N n6) {
        if (isDirected()) {
            return successors((AbstractBaseGraph<N>) n6).size();
        }
        return degree(n6);
    }

    protected final void validateEndpoints(EndpointPair<?> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        Preconditions.checkArgument(isOrderingCompatible(endpointPair), "Mismatch: unordered endpoints cannot be used with directed graphs");
    }

    @Override // com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        if (!isOrderingCompatible(endpointPair)) {
            return false;
        }
        N nodeU = endpointPair.nodeU();
        return nodes().contains(nodeU) && successors((AbstractBaseGraph<N>) nodeU).contains(endpointPair.nodeV());
    }
}
