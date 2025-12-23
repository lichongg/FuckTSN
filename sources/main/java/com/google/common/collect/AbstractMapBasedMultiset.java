package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class AbstractMapBasedMultiset<E> extends AbstractMultiset<E> implements Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 0;
    transient ObjectCountHashMap<E> backingMap;
    transient long size;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    abstract class Itr<T> implements Iterator<T> {
        int entryIndex;
        int expectedModCount;
        int toRemove = -1;

        abstract T result(int i6);

        Itr() {
            this.entryIndex = AbstractMapBasedMultiset.this.backingMap.firstIndex();
            this.expectedModCount = AbstractMapBasedMultiset.this.backingMap.modCount;
        }

        private void checkForConcurrentModification() {
            if (AbstractMapBasedMultiset.this.backingMap.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            checkForConcurrentModification();
            if (this.entryIndex >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T result = result(this.entryIndex);
                int i6 = this.entryIndex;
                this.toRemove = i6;
                this.entryIndex = AbstractMapBasedMultiset.this.backingMap.nextIndex(i6);
                return result;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            boolean z5;
            checkForConcurrentModification();
            if (this.toRemove != -1) {
                z5 = true;
            } else {
                z5 = false;
            }
            CollectPreconditions.checkRemove(z5);
            AbstractMapBasedMultiset.this.size -= r0.backingMap.removeEntry(this.toRemove);
            this.entryIndex = AbstractMapBasedMultiset.this.backingMap.nextIndexAfterRemove(this.entryIndex, this.toRemove);
            this.toRemove = -1;
            this.expectedModCount = AbstractMapBasedMultiset.this.backingMap.modCount;
        }
    }

    abstract void init(int i6);

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int setCount(@NullableDecl E e6, int i6) {
        CollectPreconditions.checkNonnegative(i6, "count");
        ObjectCountHashMap<E> objectCountHashMap = this.backingMap;
        int remove = i6 == 0 ? objectCountHashMap.remove(e6) : objectCountHashMap.put(e6, i6);
        this.size += i6 - remove;
        return remove;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int add(@NullableDecl E e6, int i6) {
        if (i6 == 0) {
            return count(e6);
        }
        Preconditions.checkArgument(i6 > 0, "occurrences cannot be negative: %s", i6);
        int indexOf = this.backingMap.indexOf(e6);
        if (indexOf == -1) {
            this.backingMap.put(e6, i6);
            this.size += i6;
            return 0;
        }
        int value = this.backingMap.getValue(indexOf);
        long j6 = i6;
        long j7 = value + j6;
        Preconditions.checkArgument(j7 <= 2147483647L, "too many occurrences: %s", j7);
        this.backingMap.setValue(indexOf, (int) j7);
        this.size += j6;
        return value;
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.backingMap.clear();
        this.size = 0L;
    }

    @Override // com.google.common.collect.Multiset
    public final int count(@NullableDecl Object obj) {
        return this.backingMap.get(obj);
    }

    @Override // com.google.common.collect.AbstractMultiset
    final int distinctElements() {
        return this.backingMap.size();
    }

    @Override // com.google.common.collect.AbstractMultiset
    final Iterator<E> elementIterator() {
        return new AbstractMapBasedMultiset<E>.Itr<E>() { // from class: com.google.common.collect.AbstractMapBasedMultiset.1
            @Override // com.google.common.collect.AbstractMapBasedMultiset.Itr
            E result(int i6) {
                return AbstractMapBasedMultiset.this.backingMap.getKey(i6);
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset
    final Iterator<Multiset.Entry<E>> entryIterator() {
        return new AbstractMapBasedMultiset<E>.Itr<Multiset.Entry<E>>() { // from class: com.google.common.collect.AbstractMapBasedMultiset.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.AbstractMapBasedMultiset.Itr
            public Multiset.Entry<E> result(int i6) {
                return AbstractMapBasedMultiset.this.backingMap.getEntry(i6);
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int remove(@NullableDecl Object obj, int i6) {
        if (i6 == 0) {
            return count(obj);
        }
        Preconditions.checkArgument(i6 > 0, "occurrences cannot be negative: %s", i6);
        int indexOf = this.backingMap.indexOf(obj);
        if (indexOf == -1) {
            return 0;
        }
        int value = this.backingMap.getValue(indexOf);
        if (value > i6) {
            this.backingMap.setValue(indexOf, value - i6);
        } else {
            this.backingMap.removeEntry(indexOf);
            i6 = value;
        }
        this.size -= i6;
        return value;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final int size() {
        return Ints.saturatedCast(this.size);
    }

    AbstractMapBasedMultiset(int i6) {
        init(i6);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readCount = Serialization.readCount(objectInputStream);
        init(3);
        Serialization.populateMultiset(this, objectInputStream, readCount);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultiset(this, objectOutputStream);
    }

    void addTo(Multiset<? super E> multiset) {
        Preconditions.checkNotNull(multiset);
        int firstIndex = this.backingMap.firstIndex();
        while (firstIndex >= 0) {
            multiset.add(this.backingMap.getKey(firstIndex), this.backingMap.getValue(firstIndex));
            firstIndex = this.backingMap.nextIndex(firstIndex);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public final Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final boolean setCount(@NullableDecl E e6, int i6, int i7) {
        CollectPreconditions.checkNonnegative(i6, "oldCount");
        CollectPreconditions.checkNonnegative(i7, "newCount");
        int indexOf = this.backingMap.indexOf(e6);
        if (indexOf == -1) {
            if (i6 != 0) {
                return false;
            }
            if (i7 > 0) {
                this.backingMap.put(e6, i7);
                this.size += i7;
            }
            return true;
        }
        if (this.backingMap.getValue(indexOf) != i6) {
            return false;
        }
        if (i7 == 0) {
            this.backingMap.removeEntry(indexOf);
            this.size -= i6;
        } else {
            this.backingMap.setValue(indexOf, i7);
            this.size += i7 - i6;
        }
        return true;
    }
}
