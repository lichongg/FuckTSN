package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ForwardingCollection<E> extends ForwardingObject implements Collection<E> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    public abstract Collection<E> delegate();

    protected Object[] standardToArray() {
        return toArray(new Object[size()]);
    }

    public Object[] toArray() {
        return delegate().toArray();
    }

    @CanIgnoreReturnValue
    public <T> T[] toArray(T[] tArr) {
        return (T[]) delegate().toArray(tArr);
    }

    protected ForwardingCollection() {
    }

    @CanIgnoreReturnValue
    public boolean add(E e6) {
        return delegate().add(e6);
    }

    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        return delegate().addAll(collection);
    }

    public void clear() {
        delegate().clear();
    }

    public boolean contains(Object obj) {
        return delegate().contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return delegate().containsAll(collection);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public Iterator<E> iterator() {
        return delegate().iterator();
    }

    @CanIgnoreReturnValue
    public boolean remove(Object obj) {
        return delegate().remove(obj);
    }

    @CanIgnoreReturnValue
    public boolean removeAll(Collection<?> collection) {
        return delegate().removeAll(collection);
    }

    @CanIgnoreReturnValue
    public boolean retainAll(Collection<?> collection) {
        return delegate().retainAll(collection);
    }

    @Override // java.util.Collection
    public int size() {
        return delegate().size();
    }

    protected boolean standardAddAll(Collection<? extends E> collection) {
        return Iterators.addAll(this, collection.iterator());
    }

    protected void standardClear() {
        Iterators.clear(iterator());
    }

    protected boolean standardContains(@NullableDecl Object obj) {
        return Iterators.contains(iterator(), obj);
    }

    protected boolean standardContainsAll(Collection<?> collection) {
        return Collections2.containsAllImpl(this, collection);
    }

    protected boolean standardIsEmpty() {
        return !iterator().hasNext();
    }

    protected boolean standardRemove(@NullableDecl Object obj) {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (Objects.equal(it.next(), obj)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    protected boolean standardRemoveAll(Collection<?> collection) {
        return Iterators.removeAll(iterator(), collection);
    }

    protected boolean standardRetainAll(Collection<?> collection) {
        return Iterators.retainAll(iterator(), collection);
    }

    protected <T> T[] standardToArray(T[] tArr) {
        return (T[]) ObjectArrays.toArrayImpl(this, tArr);
    }

    protected String standardToString() {
        return Collections2.toStringImpl(this);
    }
}
