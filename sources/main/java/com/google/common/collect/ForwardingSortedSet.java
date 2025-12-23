package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ForwardingSortedSet<E> extends ForwardingSet<E> implements SortedSet<E> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract SortedSet<E> delegate();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingCollection
    @Beta
    protected boolean standardContains(@NullableDecl Object obj) {
        return unsafeCompare(tailSet(obj).first(), obj) == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingCollection
    @Beta
    protected boolean standardRemove(@NullableDecl Object obj) {
        try {
            Iterator<E> it = tailSet(obj).iterator();
            if (it.hasNext() && unsafeCompare(it.next(), obj) == 0) {
                it.remove();
                return true;
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    protected ForwardingSortedSet() {
    }

    private int unsafeCompare(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Comparator<? super E> comparator = comparator();
        if (comparator == null) {
            return ((Comparable) obj).compareTo(obj2);
        }
        return comparator.compare(obj, obj2);
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // java.util.SortedSet
    public E first() {
        return delegate().first();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(E e6) {
        return delegate().headSet(e6);
    }

    @Override // java.util.SortedSet
    public E last() {
        return delegate().last();
    }

    @Beta
    protected SortedSet<E> standardSubSet(E e6, E e7) {
        return tailSet(e6).headSet(e7);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> subSet(E e6, E e7) {
        return delegate().subSet(e6, e7);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(E e6) {
        return delegate().tailSet(e6);
    }
}
