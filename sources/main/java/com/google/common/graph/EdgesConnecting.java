package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class EdgesConnecting<E> extends AbstractSet<E> {
    private final Map<?, E> nodeToOutEdge;
    private final Object targetNode;

    @NullableDecl
    private E getConnectingEdge() {
        return this.nodeToOutEdge.get(this.targetNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<E> iterator() {
        E connectingEdge = getConnectingEdge();
        return connectingEdge == null ? ImmutableSet.of().iterator() : Iterators.singletonIterator(connectingEdge);
    }

    EdgesConnecting(Map<?, E> map, Object obj) {
        this.nodeToOutEdge = (Map) Preconditions.checkNotNull(map);
        this.targetNode = Preconditions.checkNotNull(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        E connectingEdge = getConnectingEdge();
        if (connectingEdge != null && connectingEdge.equals(obj)) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        if (getConnectingEdge() == null) {
            return 0;
        }
        return 1;
    }
}
