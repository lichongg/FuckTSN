package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Immutable(containerOf = {"N"})
@Beta
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class EndpointPair<N> implements Iterable<N> {
    private final N nodeU;
    private final N nodeV;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.graph.EndpointPair$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Ordered<N> extends EndpointPair<N> {
        /* synthetic */ Ordered(Object obj, Object obj2, AnonymousClass1 anonymousClass1) {
            this(obj, obj2);
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            return isOrdered() == endpointPair.isOrdered() && source().equals(endpointPair.source()) && target().equals(endpointPair.target());
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean isOrdered() {
            return true;
        }

        private Ordered(N n6, N n7) {
            super(n6, n7, null);
        }

        public String toString() {
            return "<" + source() + " -> " + target() + ">";
        }

        @Override // com.google.common.graph.EndpointPair
        public int hashCode() {
            return Objects.hashCode(source(), target());
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.graph.EndpointPair
        public N source() {
            return nodeU();
        }

        @Override // com.google.common.graph.EndpointPair
        public N target() {
            return nodeV();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Unordered<N> extends EndpointPair<N> {
        /* synthetic */ Unordered(Object obj, Object obj2, AnonymousClass1 anonymousClass1) {
            this(obj, obj2);
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            if (isOrdered() != endpointPair.isOrdered()) {
                return false;
            }
            return nodeU().equals(endpointPair.nodeU()) ? nodeV().equals(endpointPair.nodeV()) : nodeU().equals(endpointPair.nodeV()) && nodeV().equals(endpointPair.nodeU());
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean isOrdered() {
            return false;
        }

        private Unordered(N n6, N n7) {
            super(n6, n7, null);
        }

        @Override // com.google.common.graph.EndpointPair
        public N source() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        @Override // com.google.common.graph.EndpointPair
        public N target() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        public String toString() {
            return "[" + nodeU() + ", " + nodeV() + "]";
        }

        @Override // com.google.common.graph.EndpointPair
        public int hashCode() {
            return nodeU().hashCode() + nodeV().hashCode();
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }
    }

    /* synthetic */ EndpointPair(Object obj, Object obj2, AnonymousClass1 anonymousClass1) {
        this(obj, obj2);
    }

    static <N> EndpointPair<N> of(Graph<?> graph, N n6, N n7) {
        return graph.isDirected() ? ordered(n6, n7) : unordered(n6, n7);
    }

    public abstract boolean equals(@NullableDecl Object obj);

    public abstract int hashCode();

    public abstract boolean isOrdered();

    public abstract N source();

    public abstract N target();

    private EndpointPair(N n6, N n7) {
        this.nodeU = (N) Preconditions.checkNotNull(n6);
        this.nodeV = (N) Preconditions.checkNotNull(n7);
    }

    static <N> EndpointPair<N> of(Network<?, ?> network, N n6, N n7) {
        return network.isDirected() ? ordered(n6, n7) : unordered(n6, n7);
    }

    public static <N> EndpointPair<N> ordered(N n6, N n7) {
        return new Ordered(n6, n7, null);
    }

    public static <N> EndpointPair<N> unordered(N n6, N n7) {
        return new Unordered(n7, n6, null);
    }

    public final N adjacentNode(Object obj) {
        if (obj.equals(this.nodeU)) {
            return this.nodeV;
        }
        if (obj.equals(this.nodeV)) {
            return this.nodeU;
        }
        throw new IllegalArgumentException("EndpointPair " + this + " does not contain node " + obj);
    }

    @Override // java.lang.Iterable
    public final UnmodifiableIterator<N> iterator() {
        return Iterators.forArray(this.nodeU, this.nodeV);
    }

    public final N nodeU() {
        return this.nodeU;
    }

    public final N nodeV() {
        return this.nodeV;
    }
}
