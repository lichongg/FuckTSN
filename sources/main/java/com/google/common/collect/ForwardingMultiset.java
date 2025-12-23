package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ForwardingMultiset<E> extends ForwardingCollection<E> implements Multiset<E> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Beta
    protected class StandardElementSet extends Multisets.ElementSet<E> {
        public StandardElementSet() {
        }

        @Override // com.google.common.collect.Multisets.ElementSet
        Multiset<E> multiset() {
            return ForwardingMultiset.this;
        }

        @Override // com.google.common.collect.Multisets.ElementSet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return Multisets.elementIterator(multiset().entrySet().iterator());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract Multiset<E> delegate();

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int setCount(E e6, int i6) {
        return delegate().setCount(e6, i6);
    }

    protected boolean standardAdd(E e6) {
        add(e6, 1);
        return true;
    }

    @Override // com.google.common.collect.ForwardingCollection
    protected boolean standardRemove(Object obj) {
        return remove(obj, 1) > 0;
    }

    protected int standardSetCount(E e6, int i6) {
        return Multisets.setCountImpl(this, e6, i6);
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public boolean equals(@NullableDecl Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public boolean setCount(E e6, int i6, int i7) {
        return delegate().setCount(e6, i6, i7);
    }

    protected boolean standardSetCount(E e6, int i6, int i7) {
        return Multisets.setCountImpl(this, e6, i6, i7);
    }

    protected ForwardingMultiset() {
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int add(E e6, int i6) {
        return delegate().add(e6, i6);
    }

    @Override // com.google.common.collect.Multiset
    public int count(Object obj) {
        return delegate().count(obj);
    }

    public Set<E> elementSet() {
        return delegate().elementSet();
    }

    public Set<Multiset.Entry<E>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(Object obj, int i6) {
        return delegate().remove(obj, i6);
    }

    @Override // com.google.common.collect.ForwardingCollection
    @Beta
    protected boolean standardAddAll(Collection<? extends E> collection) {
        return Multisets.addAllImpl(this, collection);
    }

    @Override // com.google.common.collect.ForwardingCollection
    protected void standardClear() {
        Iterators.clear(entrySet().iterator());
    }

    @Override // com.google.common.collect.ForwardingCollection
    protected boolean standardContains(@NullableDecl Object obj) {
        if (count(obj) > 0) {
            return true;
        }
        return false;
    }

    @Beta
    protected int standardCount(@NullableDecl Object obj) {
        for (Multiset.Entry<E> entry : entrySet()) {
            if (Objects.equal(entry.getElement(), obj)) {
                return entry.getCount();
            }
        }
        return 0;
    }

    protected boolean standardEquals(@NullableDecl Object obj) {
        return Multisets.equalsImpl(this, obj);
    }

    protected int standardHashCode() {
        return entrySet().hashCode();
    }

    protected Iterator<E> standardIterator() {
        return Multisets.iteratorImpl(this);
    }

    @Override // com.google.common.collect.ForwardingCollection
    protected boolean standardRemoveAll(Collection<?> collection) {
        return Multisets.removeAllImpl(this, collection);
    }

    @Override // com.google.common.collect.ForwardingCollection
    protected boolean standardRetainAll(Collection<?> collection) {
        return Multisets.retainAllImpl(this, collection);
    }

    protected int standardSize() {
        return Multisets.linearTimeSizeImpl(this);
    }

    @Override // com.google.common.collect.ForwardingCollection
    protected String standardToString() {
        return entrySet().toString();
    }
}
