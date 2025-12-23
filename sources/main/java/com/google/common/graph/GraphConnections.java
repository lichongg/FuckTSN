package com.google.common.graph;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
interface GraphConnections<N, V> {
    void addPredecessor(N n6, V v5);

    @CanIgnoreReturnValue
    V addSuccessor(N n6, V v5);

    Set<N> adjacentNodes();

    Set<N> predecessors();

    void removePredecessor(N n6);

    @CanIgnoreReturnValue
    V removeSuccessor(N n6);

    Set<N> successors();

    @NullableDecl
    V value(N n6);
}
