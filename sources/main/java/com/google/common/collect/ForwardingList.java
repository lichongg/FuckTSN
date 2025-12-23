package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ForwardingList<E> extends ForwardingCollection<E> implements List<E> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract List<E> delegate();

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return delegate().listIterator();
    }

    protected ListIterator<E> standardListIterator() {
        return listIterator(0);
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@NullableDecl Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i6) {
        return delegate().listIterator(i6);
    }

    @Beta
    protected ListIterator<E> standardListIterator(int i6) {
        return Lists.listIteratorImpl(this, i6);
    }

    protected ForwardingList() {
    }

    public void add(int i6, E e6) {
        delegate().add(i6, e6);
    }

    @CanIgnoreReturnValue
    public boolean addAll(int i6, Collection<? extends E> collection) {
        return delegate().addAll(i6, collection);
    }

    @Override // java.util.List
    public E get(int i6) {
        return delegate().get(i6);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return delegate().indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return delegate().lastIndexOf(obj);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    public E remove(int i6) {
        return delegate().remove(i6);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    public E set(int i6, E e6) {
        return delegate().set(i6, e6);
    }

    protected boolean standardAdd(E e6) {
        add(size(), e6);
        return true;
    }

    protected boolean standardAddAll(int i6, Iterable<? extends E> iterable) {
        return Lists.addAllImpl(this, i6, iterable);
    }

    @Beta
    protected boolean standardEquals(@NullableDecl Object obj) {
        return Lists.equalsImpl(this, obj);
    }

    @Beta
    protected int standardHashCode() {
        return Lists.hashCodeImpl(this);
    }

    protected int standardIndexOf(@NullableDecl Object obj) {
        return Lists.indexOfImpl(this, obj);
    }

    protected Iterator<E> standardIterator() {
        return listIterator();
    }

    protected int standardLastIndexOf(@NullableDecl Object obj) {
        return Lists.lastIndexOfImpl(this, obj);
    }

    @Beta
    protected List<E> standardSubList(int i6, int i7) {
        return Lists.subListImpl(this, i6, i7);
    }

    @Override // java.util.List
    public List<E> subList(int i6, int i7) {
        return delegate().subList(i6, i7);
    }
}
