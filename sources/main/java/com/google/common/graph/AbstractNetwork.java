package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class AbstractNetwork<N, E> implements Network<N, E> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.graph.AbstractNetwork$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractGraph<N> {
        @Override // com.google.common.graph.PredecessorsFunction
        public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
            return predecessors((AnonymousClass1) obj);
        }

        @Override // com.google.common.graph.SuccessorsFunction
        public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
            return successors((AnonymousClass1) obj);
        }

        AnonymousClass1() {
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public Set<N> adjacentNodes(N n6) {
            return AbstractNetwork.this.adjacentNodes(n6);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public boolean allowsSelfLoops() {
            return AbstractNetwork.this.allowsSelfLoops();
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public Set<EndpointPair<N>> edges() {
            return AbstractNetwork.this.allowsParallelEdges() ? super.edges() : new AbstractSet<EndpointPair<N>>() { // from class: com.google.common.graph.AbstractNetwork.1.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(@NullableDecl Object obj) {
                    if (!(obj instanceof EndpointPair)) {
                        return false;
                    }
                    EndpointPair<?> endpointPair = (EndpointPair) obj;
                    return AnonymousClass1.this.isOrderingCompatible(endpointPair) && AnonymousClass1.this.nodes().contains(endpointPair.nodeU()) && AnonymousClass1.this.successors((AnonymousClass1) endpointPair.nodeU()).contains(endpointPair.nodeV());
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator<EndpointPair<N>> iterator() {
                    return Iterators.transform(AbstractNetwork.this.edges().iterator(), new Function<E, EndpointPair<N>>() { // from class: com.google.common.graph.AbstractNetwork.1.1.1
                        @Override // com.google.common.base.Function
                        public /* bridge */ /* synthetic */ Object apply(Object obj) {
                            return apply((C05321) obj);
                        }

                        @Override // com.google.common.base.Function
                        public EndpointPair<N> apply(E e6) {
                            return AbstractNetwork.this.incidentNodes(e6);
                        }
                    });
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return AbstractNetwork.this.edges().size();
                }
            };
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public boolean isDirected() {
            return AbstractNetwork.this.isDirected();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public ElementOrder<N> nodeOrder() {
            return AbstractNetwork.this.nodeOrder();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public Set<N> nodes() {
            return AbstractNetwork.this.nodes();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
        public Set<N> predecessors(N n6) {
            return AbstractNetwork.this.predecessors((AbstractNetwork) n6);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
        public Set<N> successors(N n6) {
            return AbstractNetwork.this.successors((AbstractNetwork) n6);
        }
    }

    @Override // com.google.common.graph.Network
    @NullableDecl
    public E edgeConnectingOrNull(N n6, N n7) {
        Set<E> edgesConnecting = edgesConnecting(n6, n7);
        int size = edgesConnecting.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return edgesConnecting.iterator().next();
        }
        throw new IllegalArgumentException(String.format("Cannot call edgeConnecting() when parallel edges exist between %s and %s. Consider calling edgesConnecting() instead.", n6, n7));
    }

    @Override // com.google.common.graph.Network
    public Set<E> edgesConnecting(N n6, N n7) {
        Set<E> outEdges = outEdges(n6);
        Set<E> inEdges = inEdges(n7);
        return outEdges.size() <= inEdges.size() ? Collections.unmodifiableSet(Sets.filter(outEdges, connectedPredicate(n6, n7))) : Collections.unmodifiableSet(Sets.filter(inEdges, connectedPredicate(n7, n6)));
    }

    @Override // com.google.common.graph.Network
    public final boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Network)) {
            return false;
        }
        Network network = (Network) obj;
        return isDirected() == network.isDirected() && nodes().equals(network.nodes()) && edgeIncidentNodesMap(this).equals(edgeIncidentNodesMap(network));
    }

    @Override // com.google.common.graph.Network
    public boolean hasEdgeConnecting(N n6, N n7) {
        return !edgesConnecting(n6, n7).isEmpty();
    }

    private Predicate<E> connectedPredicate(final N n6, final N n7) {
        return new Predicate<E>() { // from class: com.google.common.graph.AbstractNetwork.2
            @Override // com.google.common.base.Predicate
            public boolean apply(E e6) {
                return AbstractNetwork.this.incidentNodes(e6).adjacentNode(n6).equals(n7);
            }
        };
    }

    private static <N, E> Map<E, EndpointPair<N>> edgeIncidentNodesMap(final Network<N, E> network) {
        return Maps.asMap(network.edges(), new Function<E, EndpointPair<N>>() { // from class: com.google.common.graph.AbstractNetwork.3
            @Override // com.google.common.base.Function
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((AnonymousClass3) obj);
            }

            @Override // com.google.common.base.Function
            public EndpointPair<N> apply(E e6) {
                return Network.this.incidentNodes(e6);
            }
        });
    }

    @Override // com.google.common.graph.Network
    public Graph<N> asGraph() {
        return new AnonymousClass1();
    }

    @Override // com.google.common.graph.Network
    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        if (isOrderingCompatible(endpointPair)) {
            return !edgesConnecting(endpointPair.nodeU(), endpointPair.nodeV()).isEmpty();
        }
        return false;
    }

    public String toString() {
        return "isDirected: " + isDirected() + ", allowsParallelEdges: " + allowsParallelEdges() + ", allowsSelfLoops: " + allowsSelfLoops() + ", nodes: " + nodes() + ", edges: " + edgeIncidentNodesMap(this);
    }

    @Override // com.google.common.graph.Network
    public Set<E> adjacentEdges(E e6) {
        EndpointPair<N> incidentNodes = incidentNodes(e6);
        return Sets.difference(Sets.union(incidentEdges(incidentNodes.nodeU()), incidentEdges(incidentNodes.nodeV())), ImmutableSet.of((Object) e6));
    }

    @Override // com.google.common.graph.Network
    public int degree(N n6) {
        if (isDirected()) {
            return IntMath.saturatedAdd(inEdges(n6).size(), outEdges(n6).size());
        }
        return IntMath.saturatedAdd(incidentEdges(n6).size(), edgesConnecting(n6, n6).size());
    }

    @Override // com.google.common.graph.Network
    public final int hashCode() {
        return edgeIncidentNodesMap(this).hashCode();
    }

    @Override // com.google.common.graph.Network
    public int inDegree(N n6) {
        if (isDirected()) {
            return inEdges(n6).size();
        }
        return degree(n6);
    }

    protected final boolean isOrderingCompatible(EndpointPair<?> endpointPair) {
        if (!endpointPair.isOrdered() && isDirected()) {
            return false;
        }
        return true;
    }

    @Override // com.google.common.graph.Network
    public int outDegree(N n6) {
        if (isDirected()) {
            return outEdges(n6).size();
        }
        return degree(n6);
    }

    protected final void validateEndpoints(EndpointPair<?> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        Preconditions.checkArgument(isOrderingCompatible(endpointPair), "Mismatch: unordered endpoints cannot be used with directed graphs");
    }

    @Override // com.google.common.graph.Network
    @NullableDecl
    public E edgeConnectingOrNull(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return edgeConnectingOrNull(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.Network
    public Set<E> edgesConnecting(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return edgesConnecting(endpointPair.nodeU(), endpointPair.nodeV());
    }
}
