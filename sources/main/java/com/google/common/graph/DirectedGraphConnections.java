package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class DirectedGraphConnections<N, V> implements GraphConnections<N, V> {
    private static final Object PRED = new Object();
    private final Map<N, Object> adjacentNodeValues;
    private int predecessorCount;
    private int successorCount;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class PredAndSucc {
        private final Object successorValue;

        PredAndSucc(Object obj) {
            this.successorValue = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isPredecessor(@NullableDecl Object obj) {
        return obj == PRED || (obj instanceof PredAndSucc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isSuccessor(@NullableDecl Object obj) {
        return (obj == PRED || obj == null) ? false : true;
    }

    static <N, V> DirectedGraphConnections<N, V> of() {
        return new DirectedGraphConnections<>(new HashMap(4, 1.0f), 0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <N, V> DirectedGraphConnections<N, V> ofImmutable(Set<N> set, Map<N, V> map) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        for (N n6 : set) {
            Object put = hashMap.put(n6, PRED);
            if (put != null) {
                hashMap.put(n6, new PredAndSucc(put));
            }
        }
        return new DirectedGraphConnections<>(ImmutableMap.copyOf((Map) hashMap), set.size(), map.size());
    }

    @Override // com.google.common.graph.GraphConnections
    public void addPredecessor(N n6, V v5) {
        Map<N, Object> map = this.adjacentNodeValues;
        Object obj = PRED;
        Object put = map.put(n6, obj);
        if (put == null) {
            int i6 = this.predecessorCount + 1;
            this.predecessorCount = i6;
            Graphs.checkPositive(i6);
        } else if (put instanceof PredAndSucc) {
            this.adjacentNodeValues.put(n6, put);
        } else if (put != obj) {
            this.adjacentNodeValues.put(n6, new PredAndSucc(put));
            int i7 = this.predecessorCount + 1;
            this.predecessorCount = i7;
            Graphs.checkPositive(i7);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.GraphConnections
    public V addSuccessor(N n6, V v5) {
        V v6 = (V) this.adjacentNodeValues.put(n6, v5);
        if (v6 == 0) {
            int i6 = this.successorCount + 1;
            this.successorCount = i6;
            Graphs.checkPositive(i6);
            return null;
        }
        if (v6 instanceof PredAndSucc) {
            this.adjacentNodeValues.put(n6, new PredAndSucc(v5));
            return (V) ((PredAndSucc) v6).successorValue;
        }
        if (v6 != PRED) {
            return v6;
        }
        this.adjacentNodeValues.put(n6, new PredAndSucc(v5));
        int i7 = this.successorCount + 1;
        this.successorCount = i7;
        Graphs.checkPositive(i7);
        return null;
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> adjacentNodes() {
        return Collections.unmodifiableSet(this.adjacentNodeValues.keySet());
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> predecessors() {
        return new AbstractSet<N>() { // from class: com.google.common.graph.DirectedGraphConnections.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                return DirectedGraphConnections.isPredecessor(DirectedGraphConnections.this.adjacentNodeValues.get(obj));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<N> iterator() {
                final Iterator it = DirectedGraphConnections.this.adjacentNodeValues.entrySet().iterator();
                return new AbstractIterator<N>() { // from class: com.google.common.graph.DirectedGraphConnections.1.1
                    @Override // com.google.common.collect.AbstractIterator
                    protected N computeNext() {
                        while (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            if (DirectedGraphConnections.isPredecessor(entry.getValue())) {
                                return (N) entry.getKey();
                            }
                        }
                        return endOfData();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return DirectedGraphConnections.this.predecessorCount;
            }
        };
    }

    @Override // com.google.common.graph.GraphConnections
    public void removePredecessor(N n6) {
        Object obj = this.adjacentNodeValues.get(n6);
        if (obj == PRED) {
            this.adjacentNodeValues.remove(n6);
            int i6 = this.predecessorCount - 1;
            this.predecessorCount = i6;
            Graphs.checkNonNegative(i6);
            return;
        }
        if (obj instanceof PredAndSucc) {
            this.adjacentNodeValues.put(n6, ((PredAndSucc) obj).successorValue);
            int i7 = this.predecessorCount - 1;
            this.predecessorCount = i7;
            Graphs.checkNonNegative(i7);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.GraphConnections
    public V removeSuccessor(Object obj) {
        Object obj2;
        V v5 = (V) this.adjacentNodeValues.get(obj);
        if (v5 == 0 || v5 == (obj2 = PRED)) {
            return null;
        }
        if (v5 instanceof PredAndSucc) {
            this.adjacentNodeValues.put(obj, obj2);
            int i6 = this.successorCount - 1;
            this.successorCount = i6;
            Graphs.checkNonNegative(i6);
            return (V) ((PredAndSucc) v5).successorValue;
        }
        this.adjacentNodeValues.remove(obj);
        int i7 = this.successorCount - 1;
        this.successorCount = i7;
        Graphs.checkNonNegative(i7);
        return v5;
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> successors() {
        return new AbstractSet<N>() { // from class: com.google.common.graph.DirectedGraphConnections.2
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                return DirectedGraphConnections.isSuccessor(DirectedGraphConnections.this.adjacentNodeValues.get(obj));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<N> iterator() {
                final Iterator it = DirectedGraphConnections.this.adjacentNodeValues.entrySet().iterator();
                return new AbstractIterator<N>() { // from class: com.google.common.graph.DirectedGraphConnections.2.1
                    @Override // com.google.common.collect.AbstractIterator
                    protected N computeNext() {
                        while (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            if (DirectedGraphConnections.isSuccessor(entry.getValue())) {
                                return (N) entry.getKey();
                            }
                        }
                        return endOfData();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return DirectedGraphConnections.this.successorCount;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.GraphConnections
    public V value(N n6) {
        V v5 = (V) this.adjacentNodeValues.get(n6);
        if (v5 == PRED) {
            return null;
        }
        return v5 instanceof PredAndSucc ? (V) ((PredAndSucc) v5).successorValue : v5;
    }

    private DirectedGraphConnections(Map<N, Object> map, int i6, int i7) {
        boolean z5;
        this.adjacentNodeValues = (Map) Preconditions.checkNotNull(map);
        this.predecessorCount = Graphs.checkNonNegative(i6);
        this.successorCount = Graphs.checkNonNegative(i7);
        if (i6 <= map.size() && i7 <= map.size()) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkState(z5);
    }
}
