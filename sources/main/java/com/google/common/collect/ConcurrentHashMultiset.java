package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Serialization;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class ConcurrentHashMultiset<E> extends AbstractMultiset<E> implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient ConcurrentMap<E, AtomicInteger> countMap;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class EntrySet extends AbstractMultiset<E>.EntrySet {
        private EntrySet() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return snapshot().toArray();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMultiset.EntrySet, com.google.common.collect.Multisets.EntrySet
        public ConcurrentHashMultiset<E> multiset() {
            return ConcurrentHashMultiset.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) snapshot().toArray(tArr);
        }

        private List<Multiset.Entry<E>> snapshot() {
            ArrayList newArrayListWithExpectedSize = Lists.newArrayListWithExpectedSize(size());
            Iterators.addAll(newArrayListWithExpectedSize, iterator());
            return newArrayListWithExpectedSize;
        }
    }

    public static <E> ConcurrentHashMultiset<E> create() {
        return new ConcurrentHashMultiset<>(new ConcurrentHashMap());
    }

    @CanIgnoreReturnValue
    public boolean removeExactly(@NullableDecl Object obj, int i6) {
        int i7;
        int i8;
        if (i6 == 0) {
            return true;
        }
        CollectPreconditions.checkPositive(i6, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.safeGet(this.countMap, obj);
        if (atomicInteger == null) {
            return false;
        }
        do {
            i7 = atomicInteger.get();
            if (i7 < i6) {
                return false;
            }
            i8 = i7 - i6;
        } while (!atomicInteger.compareAndSet(i7, i8));
        if (i8 == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return true;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int setCount(E e6, int i6) {
        AtomicInteger atomicInteger;
        int i7;
        AtomicInteger atomicInteger2;
        Preconditions.checkNotNull(e6);
        CollectPreconditions.checkNonnegative(i6, "count");
        do {
            atomicInteger = (AtomicInteger) Maps.safeGet(this.countMap, e6);
            if (atomicInteger == null && (i6 == 0 || (atomicInteger = this.countMap.putIfAbsent(e6, new AtomicInteger(i6))) == null)) {
                return 0;
            }
            do {
                i7 = atomicInteger.get();
                if (i7 == 0) {
                    if (i6 != 0) {
                        atomicInteger2 = new AtomicInteger(i6);
                        if (this.countMap.putIfAbsent(e6, atomicInteger2) == null) {
                            break;
                        }
                    } else {
                        return 0;
                    }
                }
            } while (!atomicInteger.compareAndSet(i7, i6));
            if (i6 == 0) {
                this.countMap.remove(e6, atomicInteger);
            }
            return i7;
        } while (!this.countMap.replace(e6, atomicInteger, atomicInteger2));
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return snapshot().toArray();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class FieldSettersHolder {
        static final Serialization.FieldSetter<ConcurrentHashMultiset> COUNT_MAP_FIELD_SETTER = Serialization.getFieldSetter(ConcurrentHashMultiset.class, "countMap");

        private FieldSettersHolder() {
        }
    }

    public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> iterable) {
        ConcurrentHashMultiset<E> create = create();
        Iterables.addAll(create, iterable);
        return create;
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.countMap.clear();
    }

    @Override // com.google.common.collect.Multiset
    public int count(@NullableDecl Object obj) {
        AtomicInteger atomicInteger = (AtomicInteger) Maps.safeGet(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    @Override // com.google.common.collect.AbstractMultiset
    Set<E> createElementSet() {
        final Set<E> keySet = this.countMap.keySet();
        return new ForwardingSet<E>() { // from class: com.google.common.collect.ConcurrentHashMultiset.1
            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                return obj != null && Collections2.safeContains(keySet, obj);
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                return obj != null && Collections2.safeRemove(keySet, obj);
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
            public boolean containsAll(Collection<?> collection) {
                return standardContainsAll(collection);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
            public Set<E> delegate() {
                return keySet;
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                return standardRemoveAll(collection);
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset
    @Deprecated
    public Set<Multiset.Entry<E>> createEntrySet() {
        return new EntrySet();
    }

    @Override // com.google.common.collect.AbstractMultiset
    int distinctElements() {
        return this.countMap.size();
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator<E> elementIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator<Multiset.Entry<E>> entryIterator() {
        final AbstractIterator<Multiset.Entry<E>> abstractIterator = new AbstractIterator<Multiset.Entry<E>>() { // from class: com.google.common.collect.ConcurrentHashMultiset.2
            private final Iterator<Map.Entry<E, AtomicInteger>> mapEntries;

            {
                this.mapEntries = ConcurrentHashMultiset.this.countMap.entrySet().iterator();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            public Multiset.Entry<E> computeNext() {
                while (this.mapEntries.hasNext()) {
                    Map.Entry<E, AtomicInteger> next = this.mapEntries.next();
                    int i6 = next.getValue().get();
                    if (i6 != 0) {
                        return Multisets.immutableEntry(next.getKey(), i6);
                    }
                }
                return endOfData();
            }
        };
        return new ForwardingIterator<Multiset.Entry<E>>() { // from class: com.google.common.collect.ConcurrentHashMultiset.3

            @NullableDecl
            private Multiset.Entry<E> last;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.ForwardingIterator, com.google.common.collect.ForwardingObject
            public Iterator<Multiset.Entry<E>> delegate() {
                return abstractIterator;
            }

            @Override // com.google.common.collect.ForwardingIterator, java.util.Iterator
            public Multiset.Entry<E> next() {
                Multiset.Entry<E> entry = (Multiset.Entry) super.next();
                this.last = entry;
                return entry;
            }

            @Override // com.google.common.collect.ForwardingIterator, java.util.Iterator
            public void remove() {
                CollectPreconditions.checkRemove(this.last != null);
                ConcurrentHashMultiset.this.setCount(this.last.getElement(), 0);
                this.last = null;
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.countMap.isEmpty();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(@NullableDecl Object obj, int i6) {
        int i7;
        int max;
        if (i6 == 0) {
            return count(obj);
        }
        CollectPreconditions.checkPositive(i6, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.safeGet(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        do {
            i7 = atomicInteger.get();
            if (i7 == 0) {
                return 0;
            }
            max = Math.max(0, i7 - i6);
        } while (!atomicInteger.compareAndSet(i7, max));
        if (max == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return i7;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        long j6 = 0;
        while (this.countMap.values().iterator().hasNext()) {
            j6 += r0.next().get();
        }
        return Ints.saturatedCast(j6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) snapshot().toArray(tArr);
    }

    @VisibleForTesting
    ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        Preconditions.checkArgument(concurrentMap.isEmpty(), "the backing map (%s) must be empty", concurrentMap);
        this.countMap = concurrentMap;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        FieldSettersHolder.COUNT_MAP_FIELD_SETTER.set((Serialization.FieldSetter<ConcurrentHashMultiset>) this, objectInputStream.readObject());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private List<E> snapshot() {
        ArrayList newArrayListWithExpectedSize = Lists.newArrayListWithExpectedSize(size());
        for (Multiset.Entry entry : entrySet()) {
            Object element = entry.getElement();
            for (int count = entry.getCount(); count > 0; count--) {
                newArrayListWithExpectedSize.add(element);
            }
        }
        return newArrayListWithExpectedSize;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.countMap);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int add(E e6, int i6) {
        AtomicInteger atomicInteger;
        int i7;
        AtomicInteger atomicInteger2;
        Preconditions.checkNotNull(e6);
        if (i6 == 0) {
            return count(e6);
        }
        CollectPreconditions.checkPositive(i6, "occurences");
        do {
            atomicInteger = (AtomicInteger) Maps.safeGet(this.countMap, e6);
            if (atomicInteger == null && (atomicInteger = this.countMap.putIfAbsent(e6, new AtomicInteger(i6))) == null) {
                return 0;
            }
            do {
                i7 = atomicInteger.get();
                if (i7 != 0) {
                    try {
                    } catch (ArithmeticException unused) {
                        throw new IllegalArgumentException("Overflow adding " + i6 + " occurrences to a count of " + i7);
                    }
                } else {
                    atomicInteger2 = new AtomicInteger(i6);
                    if (this.countMap.putIfAbsent(e6, atomicInteger2) == null) {
                        break;
                    }
                }
            } while (!atomicInteger.compareAndSet(i7, IntMath.checkedAdd(i7, i6)));
            return i7;
        } while (!this.countMap.replace(e6, atomicInteger, atomicInteger2));
        return 0;
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@NullableDecl Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    @Beta
    public static <E> ConcurrentHashMultiset<E> create(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        return new ConcurrentHashMultiset<>(concurrentMap);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public boolean setCount(E e6, int i6, int i7) {
        Preconditions.checkNotNull(e6);
        CollectPreconditions.checkNonnegative(i6, "oldCount");
        CollectPreconditions.checkNonnegative(i7, "newCount");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.safeGet(this.countMap, e6);
        if (atomicInteger == null) {
            if (i6 != 0) {
                return false;
            }
            return i7 == 0 || this.countMap.putIfAbsent(e6, new AtomicInteger(i7)) == null;
        }
        int i8 = atomicInteger.get();
        if (i8 == i6) {
            if (i8 == 0) {
                if (i7 == 0) {
                    this.countMap.remove(e6, atomicInteger);
                    return true;
                }
                AtomicInteger atomicInteger2 = new AtomicInteger(i7);
                return this.countMap.putIfAbsent(e6, atomicInteger2) == null || this.countMap.replace(e6, atomicInteger, atomicInteger2);
            }
            if (atomicInteger.compareAndSet(i8, i7)) {
                if (i7 == 0) {
                    this.countMap.remove(e6, atomicInteger);
                }
                return true;
            }
        }
        return false;
    }
}
