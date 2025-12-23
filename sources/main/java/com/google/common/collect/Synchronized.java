package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Table;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
final class Synchronized {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.collect.Synchronized$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class SynchronizedAsMap<K, V> extends SynchronizedMap<K, Collection<V>> {
        private static final long serialVersionUID = 0;

        @MonotonicNonNullDecl
        transient Set<Map.Entry<K, Collection<V>>> asMapEntrySet;

        @MonotonicNonNullDecl
        transient Collection<Collection<V>> asMapValues;

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<Map.Entry<K, Collection<V>>> entrySet() {
            Set<Map.Entry<K, Collection<V>>> set;
            synchronized (this.mutex) {
                try {
                    if (this.asMapEntrySet == null) {
                        this.asMapEntrySet = new SynchronizedAsMapEntries(delegate().entrySet(), this.mutex);
                    }
                    set = this.asMapEntrySet;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Collection<V> get(Object obj) {
            Collection<V> typePreservingCollection;
            synchronized (this.mutex) {
                Collection collection = (Collection) super.get(obj);
                typePreservingCollection = collection == null ? null : Synchronized.typePreservingCollection(collection, this.mutex);
            }
            return typePreservingCollection;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Collection<Collection<V>> values() {
            Collection<Collection<V>> collection;
            synchronized (this.mutex) {
                try {
                    if (this.asMapValues == null) {
                        this.asMapValues = new SynchronizedAsMapValues(delegate().values(), this.mutex);
                    }
                    collection = this.asMapValues;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return collection;
        }

        SynchronizedAsMap(Map<K, Collection<V>> map, @NullableDecl Object obj) {
            super(map, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public boolean containsValue(Object obj) {
            return values().contains(obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class SynchronizedAsMapEntries<K, V> extends SynchronizedSet<Map.Entry<K, Collection<V>>> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            Object[] arrayImpl;
            synchronized (this.mutex) {
                arrayImpl = ObjectArrays.toArrayImpl(delegate());
            }
            return arrayImpl;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            boolean containsEntryImpl;
            synchronized (this.mutex) {
                containsEntryImpl = Maps.containsEntryImpl(delegate(), obj);
            }
            return containsEntryImpl;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            boolean containsAllImpl;
            synchronized (this.mutex) {
                containsAllImpl = Collections2.containsAllImpl(delegate(), collection);
            }
            return containsAllImpl;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            boolean equalsImpl;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equalsImpl = Sets.equalsImpl(delegate(), obj);
            }
            return equalsImpl;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, Collection<V>>> iterator() {
            return new TransformedIterator<Map.Entry<K, Collection<V>>, Map.Entry<K, Collection<V>>>(super.iterator()) { // from class: com.google.common.collect.Synchronized.SynchronizedAsMapEntries.1
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.google.common.collect.TransformedIterator
                public Map.Entry<K, Collection<V>> transform(final Map.Entry<K, Collection<V>> entry) {
                    return new ForwardingMapEntry<K, Collection<V>>() { // from class: com.google.common.collect.Synchronized.SynchronizedAsMapEntries.1.1
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
                        public Map.Entry<K, Collection<V>> delegate() {
                            return entry;
                        }

                        @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
                        public Collection<V> getValue() {
                            return Synchronized.typePreservingCollection((Collection) entry.getValue(), SynchronizedAsMapEntries.this.mutex);
                        }
                    };
                }
            };
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean removeEntryImpl;
            synchronized (this.mutex) {
                removeEntryImpl = Maps.removeEntryImpl(delegate(), obj);
            }
            return removeEntryImpl;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            boolean removeAll;
            synchronized (this.mutex) {
                removeAll = Iterators.removeAll(delegate().iterator(), collection);
            }
            return removeAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            boolean retainAll;
            synchronized (this.mutex) {
                retainAll = Iterators.retainAll(delegate().iterator(), collection);
            }
            return retainAll;
        }

        SynchronizedAsMapEntries(Set<Map.Entry<K, Collection<V>>> set, @NullableDecl Object obj) {
            super(set, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            synchronized (this.mutex) {
                tArr2 = (T[]) ObjectArrays.toArrayImpl(delegate(), tArr);
            }
            return tArr2;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class SynchronizedAsMapValues<V> extends SynchronizedCollection<Collection<V>> {
        private static final long serialVersionUID = 0;

        SynchronizedAsMapValues(Collection<Collection<V>> collection, @NullableDecl Object obj) {
            super(collection, obj, null);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Collection<V>> iterator() {
            return new TransformedIterator<Collection<V>, Collection<V>>(super.iterator()) { // from class: com.google.common.collect.Synchronized.SynchronizedAsMapValues.1
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.google.common.collect.TransformedIterator
                public Collection<V> transform(Collection<V> collection) {
                    return Synchronized.typePreservingCollection(collection, SynchronizedAsMapValues.this.mutex);
                }
            };
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    static class SynchronizedBiMap<K, V> extends SynchronizedMap<K, V> implements BiMap<K, V>, Serializable {
        private static final long serialVersionUID = 0;

        @RetainedWith
        @MonotonicNonNullDecl
        private transient BiMap<V, K> inverse;

        @MonotonicNonNullDecl
        private transient Set<V> valueSet;

        /* synthetic */ SynchronizedBiMap(BiMap biMap, Object obj, BiMap biMap2, AnonymousClass1 anonymousClass1) {
            this(biMap, obj, biMap2);
        }

        private SynchronizedBiMap(BiMap<K, V> biMap, @NullableDecl Object obj, @NullableDecl BiMap<V, K> biMap2) {
            super(biMap, obj);
            this.inverse = biMap2;
        }

        @Override // com.google.common.collect.BiMap
        public V forcePut(K k6, V v5) {
            V forcePut;
            synchronized (this.mutex) {
                forcePut = delegate().forcePut(k6, v5);
            }
            return forcePut;
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<V, K> inverse() {
            BiMap<V, K> biMap;
            synchronized (this.mutex) {
                try {
                    if (this.inverse == null) {
                        this.inverse = new SynchronizedBiMap(delegate().inverse(), this.mutex, this);
                    }
                    biMap = this.inverse;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return biMap;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<V> values() {
            Set<V> set;
            synchronized (this.mutex) {
                try {
                    if (this.valueSet == null) {
                        this.valueSet = Synchronized.set(delegate().values(), this.mutex);
                    }
                    set = this.valueSet;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public BiMap<K, V> delegate() {
            return (BiMap) super.delegate();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    static class SynchronizedCollection<E> extends SynchronizedObject implements Collection<E> {
        private static final long serialVersionUID = 0;

        /* synthetic */ SynchronizedCollection(Collection collection, Object obj, AnonymousClass1 anonymousClass1) {
            this(collection, obj);
        }

        public Object[] toArray() {
            Object[] array;
            synchronized (this.mutex) {
                array = delegate().toArray();
            }
            return array;
        }

        private SynchronizedCollection(Collection<E> collection, @NullableDecl Object obj) {
            super(collection, obj);
        }

        @Override // java.util.Collection
        public boolean add(E e6) {
            boolean add;
            synchronized (this.mutex) {
                add = delegate().add(e6);
            }
            return add;
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            boolean addAll;
            synchronized (this.mutex) {
                addAll = delegate().addAll(collection);
            }
            return addAll;
        }

        @Override // java.util.Collection
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        public boolean contains(Object obj) {
            boolean contains;
            synchronized (this.mutex) {
                contains = delegate().contains(obj);
            }
            return contains;
        }

        public boolean containsAll(Collection<?> collection) {
            boolean containsAll;
            synchronized (this.mutex) {
                containsAll = delegate().containsAll(collection);
            }
            return containsAll;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Collection<E> delegate() {
            return (Collection) super.delegate();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        public boolean remove(Object obj) {
            boolean remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj);
            }
            return remove;
        }

        public boolean removeAll(Collection<?> collection) {
            boolean removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(collection);
            }
            return removeAll;
        }

        public boolean retainAll(Collection<?> collection) {
            boolean retainAll;
            synchronized (this.mutex) {
                retainAll = delegate().retainAll(collection);
            }
            return retainAll;
        }

        @Override // java.util.Collection
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        public Iterator<E> iterator() {
            return delegate().iterator();
        }

        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            synchronized (this.mutex) {
                tArr2 = (T[]) delegate().toArray(tArr);
            }
            return tArr2;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class SynchronizedDeque<E> extends SynchronizedQueue<E> implements Deque<E> {
        private static final long serialVersionUID = 0;

        @Override // java.util.Deque
        public void addFirst(E e6) {
            synchronized (this.mutex) {
                delegate().addFirst(e6);
            }
        }

        @Override // java.util.Deque
        public void addLast(E e6) {
            synchronized (this.mutex) {
                delegate().addLast(e6);
            }
        }

        @Override // java.util.Deque
        public Iterator<E> descendingIterator() {
            Iterator<E> descendingIterator;
            synchronized (this.mutex) {
                descendingIterator = delegate().descendingIterator();
            }
            return descendingIterator;
        }

        @Override // java.util.Deque
        public E getFirst() {
            E first;
            synchronized (this.mutex) {
                first = delegate().getFirst();
            }
            return first;
        }

        @Override // java.util.Deque
        public E getLast() {
            E last;
            synchronized (this.mutex) {
                last = delegate().getLast();
            }
            return last;
        }

        @Override // java.util.Deque
        public boolean offerFirst(E e6) {
            boolean offerFirst;
            synchronized (this.mutex) {
                offerFirst = delegate().offerFirst(e6);
            }
            return offerFirst;
        }

        @Override // java.util.Deque
        public boolean offerLast(E e6) {
            boolean offerLast;
            synchronized (this.mutex) {
                offerLast = delegate().offerLast(e6);
            }
            return offerLast;
        }

        @Override // java.util.Deque
        public E peekFirst() {
            E peekFirst;
            synchronized (this.mutex) {
                peekFirst = delegate().peekFirst();
            }
            return peekFirst;
        }

        @Override // java.util.Deque
        public E peekLast() {
            E peekLast;
            synchronized (this.mutex) {
                peekLast = delegate().peekLast();
            }
            return peekLast;
        }

        @Override // java.util.Deque
        public E pollFirst() {
            E pollFirst;
            synchronized (this.mutex) {
                pollFirst = delegate().pollFirst();
            }
            return pollFirst;
        }

        @Override // java.util.Deque
        public E pollLast() {
            E pollLast;
            synchronized (this.mutex) {
                pollLast = delegate().pollLast();
            }
            return pollLast;
        }

        @Override // java.util.Deque
        public E pop() {
            E pop;
            synchronized (this.mutex) {
                pop = delegate().pop();
            }
            return pop;
        }

        @Override // java.util.Deque
        public void push(E e6) {
            synchronized (this.mutex) {
                delegate().push(e6);
            }
        }

        @Override // java.util.Deque
        public E removeFirst() {
            E removeFirst;
            synchronized (this.mutex) {
                removeFirst = delegate().removeFirst();
            }
            return removeFirst;
        }

        @Override // java.util.Deque
        public boolean removeFirstOccurrence(Object obj) {
            boolean removeFirstOccurrence;
            synchronized (this.mutex) {
                removeFirstOccurrence = delegate().removeFirstOccurrence(obj);
            }
            return removeFirstOccurrence;
        }

        @Override // java.util.Deque
        public E removeLast() {
            E removeLast;
            synchronized (this.mutex) {
                removeLast = delegate().removeLast();
            }
            return removeLast;
        }

        @Override // java.util.Deque
        public boolean removeLastOccurrence(Object obj) {
            boolean removeLastOccurrence;
            synchronized (this.mutex) {
                removeLastOccurrence = delegate().removeLastOccurrence(obj);
            }
            return removeLastOccurrence;
        }

        SynchronizedDeque(Deque<E> deque, @NullableDecl Object obj) {
            super(deque, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Deque<E> delegate() {
            return (Deque) super.delegate();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @GwtIncompatible
    private static class SynchronizedEntry<K, V> extends SynchronizedObject implements Map.Entry<K, V> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Map.Entry<K, V> delegate() {
            return (Map.Entry) super.delegate();
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            boolean equals;
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            K key;
            synchronized (this.mutex) {
                key = delegate().getKey();
            }
            return key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            V value;
            synchronized (this.mutex) {
                value = delegate().getValue();
            }
            return value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v5) {
            V value;
            synchronized (this.mutex) {
                value = delegate().setValue(v5);
            }
            return value;
        }

        SynchronizedEntry(Map.Entry<K, V> entry, @NullableDecl Object obj) {
            super(entry, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        private static final long serialVersionUID = 0;

        SynchronizedList(List<E> list, @NullableDecl Object obj) {
            super(list, obj, null);
        }

        @Override // java.util.List
        public ListIterator<E> listIterator() {
            return delegate().listIterator();
        }

        @Override // java.util.List
        public void add(int i6, E e6) {
            synchronized (this.mutex) {
                delegate().add(i6, e6);
            }
        }

        @Override // java.util.List
        public boolean addAll(int i6, Collection<? extends E> collection) {
            boolean addAll;
            synchronized (this.mutex) {
                addAll = delegate().addAll(i6, collection);
            }
            return addAll;
        }

        @Override // java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // java.util.List
        public E get(int i6) {
            E e6;
            synchronized (this.mutex) {
                e6 = delegate().get(i6);
            }
            return e6;
        }

        @Override // java.util.Collection, java.util.List
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            int indexOf;
            synchronized (this.mutex) {
                indexOf = delegate().indexOf(obj);
            }
            return indexOf;
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            int lastIndexOf;
            synchronized (this.mutex) {
                lastIndexOf = delegate().lastIndexOf(obj);
            }
            return lastIndexOf;
        }

        @Override // java.util.List
        public ListIterator<E> listIterator(int i6) {
            return delegate().listIterator(i6);
        }

        @Override // java.util.List
        public E remove(int i6) {
            E remove;
            synchronized (this.mutex) {
                remove = delegate().remove(i6);
            }
            return remove;
        }

        @Override // java.util.List
        public E set(int i6, E e6) {
            E e7;
            synchronized (this.mutex) {
                e7 = delegate().set(i6, e6);
            }
            return e7;
        }

        @Override // java.util.List
        public List<E> subList(int i6, int i7) {
            List<E> list;
            synchronized (this.mutex) {
                list = Synchronized.list(delegate().subList(i6, i7), this.mutex);
            }
            return list;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public List<E> delegate() {
            return (List) super.delegate();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class SynchronizedListMultimap<K, V> extends SynchronizedMultimap<K, V> implements ListMultimap<K, V> {
        private static final long serialVersionUID = 0;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((SynchronizedListMultimap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedListMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public List<V> get(K k6) {
            List<V> list;
            synchronized (this.mutex) {
                list = Synchronized.list(delegate().get((ListMultimap<K, V>) k6), this.mutex);
            }
            return list;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public List<V> removeAll(Object obj) {
            List<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public List<V> replaceValues(K k6, Iterable<? extends V> iterable) {
            List<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues((ListMultimap<K, V>) k6, (Iterable) iterable);
            }
            return replaceValues;
        }

        SynchronizedListMultimap(ListMultimap<K, V> listMultimap, @NullableDecl Object obj) {
            super(listMultimap, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public ListMultimap<K, V> delegate() {
            return (ListMultimap) super.delegate();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class SynchronizedMap<K, V> extends SynchronizedObject implements Map<K, V> {
        private static final long serialVersionUID = 0;

        @MonotonicNonNullDecl
        transient Set<Map.Entry<K, V>> entrySet;

        @MonotonicNonNullDecl
        transient Set<K> keySet;

        @MonotonicNonNullDecl
        transient Collection<V> values;

        @Override // java.util.Map
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            boolean containsKey;
            synchronized (this.mutex) {
                containsKey = delegate().containsKey(obj);
            }
            return containsKey;
        }

        public boolean containsValue(Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = delegate().containsValue(obj);
            }
            return containsValue;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Map<K, V> delegate() {
            return (Map) super.delegate();
        }

        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set;
            synchronized (this.mutex) {
                try {
                    if (this.entrySet == null) {
                        this.entrySet = Synchronized.set(delegate().entrySet(), this.mutex);
                    }
                    set = this.entrySet;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        public V get(Object obj) {
            V v5;
            synchronized (this.mutex) {
                v5 = delegate().get(obj);
            }
            return v5;
        }

        @Override // java.util.Map
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            Set<K> set;
            synchronized (this.mutex) {
                try {
                    if (this.keySet == null) {
                        this.keySet = Synchronized.set(delegate().keySet(), this.mutex);
                    }
                    set = this.keySet;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // java.util.Map
        public V put(K k6, V v5) {
            V put;
            synchronized (this.mutex) {
                put = delegate().put(k6, v5);
            }
            return put;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            synchronized (this.mutex) {
                delegate().putAll(map);
            }
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            V remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj);
            }
            return remove;
        }

        @Override // java.util.Map
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.mutex) {
                try {
                    if (this.values == null) {
                        this.values = Synchronized.collection(delegate().values(), this.mutex);
                    }
                    collection = this.values;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return collection;
        }

        SynchronizedMap(Map<K, V> map, @NullableDecl Object obj) {
            super(map, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class SynchronizedMultimap<K, V> extends SynchronizedObject implements Multimap<K, V> {
        private static final long serialVersionUID = 0;

        @MonotonicNonNullDecl
        transient Map<K, Collection<V>> asMap;

        @MonotonicNonNullDecl
        transient Collection<Map.Entry<K, V>> entries;

        @MonotonicNonNullDecl
        transient Set<K> keySet;

        @MonotonicNonNullDecl
        transient Multiset<K> keys;

        @MonotonicNonNullDecl
        transient Collection<V> valuesCollection;

        @Override // com.google.common.collect.Multimap
        public boolean putAll(K k6, Iterable<? extends V> iterable) {
            boolean putAll;
            synchronized (this.mutex) {
                putAll = delegate().putAll(k6, iterable);
            }
            return putAll;
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> map;
            synchronized (this.mutex) {
                try {
                    if (this.asMap == null) {
                        this.asMap = new SynchronizedAsMap(delegate().asMap(), this.mutex);
                    }
                    map = this.asMap;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return map;
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsEntry(Object obj, Object obj2) {
            boolean containsEntry;
            synchronized (this.mutex) {
                containsEntry = delegate().containsEntry(obj, obj2);
            }
            return containsEntry;
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(Object obj) {
            boolean containsKey;
            synchronized (this.mutex) {
                containsKey = delegate().containsKey(obj);
            }
            return containsKey;
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsValue(Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = delegate().containsValue(obj);
            }
            return containsValue;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Multimap<K, V> delegate() {
            return (Multimap) super.delegate();
        }

        @Override // com.google.common.collect.Multimap
        public Collection<Map.Entry<K, V>> entries() {
            Collection<Map.Entry<K, V>> collection;
            synchronized (this.mutex) {
                try {
                    if (this.entries == null) {
                        this.entries = Synchronized.typePreservingCollection(delegate().entries(), this.mutex);
                    }
                    collection = this.entries;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return collection;
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        public Collection<V> get(K k6) {
            Collection<V> typePreservingCollection;
            synchronized (this.mutex) {
                typePreservingCollection = Synchronized.typePreservingCollection(delegate().get(k6), this.mutex);
            }
            return typePreservingCollection;
        }

        @Override // com.google.common.collect.Multimap
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // com.google.common.collect.Multimap
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        @Override // com.google.common.collect.Multimap
        public Set<K> keySet() {
            Set<K> set;
            synchronized (this.mutex) {
                try {
                    if (this.keySet == null) {
                        this.keySet = Synchronized.typePreservingSet(delegate().keySet(), this.mutex);
                    }
                    set = this.keySet;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // com.google.common.collect.Multimap
        public Multiset<K> keys() {
            Multiset<K> multiset;
            synchronized (this.mutex) {
                try {
                    if (this.keys == null) {
                        this.keys = Synchronized.multiset(delegate().keys(), this.mutex);
                    }
                    multiset = this.keys;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return multiset;
        }

        @Override // com.google.common.collect.Multimap
        public boolean put(K k6, V v5) {
            boolean put;
            synchronized (this.mutex) {
                put = delegate().put(k6, v5);
            }
            return put;
        }

        @Override // com.google.common.collect.Multimap
        public boolean remove(Object obj, Object obj2) {
            boolean remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj, obj2);
            }
            return remove;
        }

        public Collection<V> removeAll(Object obj) {
            Collection<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        public Collection<V> replaceValues(K k6, Iterable<? extends V> iterable) {
            Collection<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues(k6, iterable);
            }
            return replaceValues;
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        @Override // com.google.common.collect.Multimap
        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.mutex) {
                try {
                    if (this.valuesCollection == null) {
                        this.valuesCollection = Synchronized.collection(delegate().values(), this.mutex);
                    }
                    collection = this.valuesCollection;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return collection;
        }

        SynchronizedMultimap(Multimap<K, V> multimap, @NullableDecl Object obj) {
            super(multimap, obj);
        }

        @Override // com.google.common.collect.Multimap
        public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
            boolean putAll;
            synchronized (this.mutex) {
                putAll = delegate().putAll(multimap);
            }
            return putAll;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class SynchronizedMultiset<E> extends SynchronizedCollection<E> implements Multiset<E> {
        private static final long serialVersionUID = 0;

        @MonotonicNonNullDecl
        transient Set<E> elementSet;

        @MonotonicNonNullDecl
        transient Set<Multiset.Entry<E>> entrySet;

        SynchronizedMultiset(Multiset<E> multiset, @NullableDecl Object obj) {
            super(multiset, obj, null);
        }

        @Override // com.google.common.collect.Multiset
        public int setCount(E e6, int i6) {
            int count;
            synchronized (this.mutex) {
                count = delegate().setCount(e6, i6);
            }
            return count;
        }

        @Override // com.google.common.collect.Multiset
        public int add(E e6, int i6) {
            int add;
            synchronized (this.mutex) {
                add = delegate().add(e6, i6);
            }
            return add;
        }

        @Override // com.google.common.collect.Multiset
        public int count(Object obj) {
            int count;
            synchronized (this.mutex) {
                count = delegate().count(obj);
            }
            return count;
        }

        @Override // com.google.common.collect.Multiset
        public Set<E> elementSet() {
            Set<E> set;
            synchronized (this.mutex) {
                try {
                    if (this.elementSet == null) {
                        this.elementSet = Synchronized.typePreservingSet(delegate().elementSet(), this.mutex);
                    }
                    set = this.elementSet;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // com.google.common.collect.Multiset
        public Set<Multiset.Entry<E>> entrySet() {
            Set<Multiset.Entry<E>> set;
            synchronized (this.mutex) {
                try {
                    if (this.entrySet == null) {
                        this.entrySet = Synchronized.typePreservingSet(delegate().entrySet(), this.mutex);
                    }
                    set = this.entrySet;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // java.util.Collection, com.google.common.collect.Multiset
        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // java.util.Collection, com.google.common.collect.Multiset
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // com.google.common.collect.Multiset
        public int remove(Object obj, int i6) {
            int remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj, i6);
            }
            return remove;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Multiset<E> delegate() {
            return (Multiset) super.delegate();
        }

        @Override // com.google.common.collect.Multiset
        public boolean setCount(E e6, int i6, int i7) {
            boolean count;
            synchronized (this.mutex) {
                count = delegate().setCount(e6, i6, i7);
            }
            return count;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @GwtIncompatible
    @VisibleForTesting
    static class SynchronizedNavigableMap<K, V> extends SynchronizedSortedMap<K, V> implements NavigableMap<K, V> {
        private static final long serialVersionUID = 0;

        @MonotonicNonNullDecl
        transient NavigableSet<K> descendingKeySet;

        @MonotonicNonNullDecl
        transient NavigableMap<K, V> descendingMap;

        @MonotonicNonNullDecl
        transient NavigableSet<K> navigableKeySet;

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k6, boolean z5) {
            NavigableMap<K, V> navigableMap;
            synchronized (this.mutex) {
                navigableMap = Synchronized.navigableMap(delegate().headMap(k6, z5), this.mutex);
            }
            return navigableMap;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k6, boolean z5, K k7, boolean z6) {
            NavigableMap<K, V> navigableMap;
            synchronized (this.mutex) {
                navigableMap = Synchronized.navigableMap(delegate().subMap(k6, z5, k7, z6), this.mutex);
            }
            return navigableMap;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k6, boolean z5) {
            NavigableMap<K, V> navigableMap;
            synchronized (this.mutex) {
                navigableMap = Synchronized.navigableMap(delegate().tailMap(k6, z5), this.mutex);
            }
            return navigableMap;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k6) {
            Map.Entry<K, V> nullableSynchronizedEntry;
            synchronized (this.mutex) {
                nullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(delegate().ceilingEntry(k6), this.mutex);
            }
            return nullableSynchronizedEntry;
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k6) {
            K ceilingKey;
            synchronized (this.mutex) {
                ceilingKey = delegate().ceilingKey(k6);
            }
            return ceilingKey;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            synchronized (this.mutex) {
                try {
                    NavigableSet<K> navigableSet = this.descendingKeySet;
                    if (navigableSet != null) {
                        return navigableSet;
                    }
                    NavigableSet<K> navigableSet2 = Synchronized.navigableSet(delegate().descendingKeySet(), this.mutex);
                    this.descendingKeySet = navigableSet2;
                    return navigableSet2;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            synchronized (this.mutex) {
                try {
                    NavigableMap<K, V> navigableMap = this.descendingMap;
                    if (navigableMap != null) {
                        return navigableMap;
                    }
                    NavigableMap<K, V> navigableMap2 = Synchronized.navigableMap(delegate().descendingMap(), this.mutex);
                    this.descendingMap = navigableMap2;
                    return navigableMap2;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            Map.Entry<K, V> nullableSynchronizedEntry;
            synchronized (this.mutex) {
                nullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(delegate().firstEntry(), this.mutex);
            }
            return nullableSynchronizedEntry;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k6) {
            Map.Entry<K, V> nullableSynchronizedEntry;
            synchronized (this.mutex) {
                nullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(delegate().floorEntry(k6), this.mutex);
            }
            return nullableSynchronizedEntry;
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k6) {
            K floorKey;
            synchronized (this.mutex) {
                floorKey = delegate().floorKey(k6);
            }
            return floorKey;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k6) {
            Map.Entry<K, V> nullableSynchronizedEntry;
            synchronized (this.mutex) {
                nullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(delegate().higherEntry(k6), this.mutex);
            }
            return nullableSynchronizedEntry;
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k6) {
            K higherKey;
            synchronized (this.mutex) {
                higherKey = delegate().higherKey(k6);
            }
            return higherKey;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            Map.Entry<K, V> nullableSynchronizedEntry;
            synchronized (this.mutex) {
                nullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(delegate().lastEntry(), this.mutex);
            }
            return nullableSynchronizedEntry;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k6) {
            Map.Entry<K, V> nullableSynchronizedEntry;
            synchronized (this.mutex) {
                nullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(delegate().lowerEntry(k6), this.mutex);
            }
            return nullableSynchronizedEntry;
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k6) {
            K lowerKey;
            synchronized (this.mutex) {
                lowerKey = delegate().lowerKey(k6);
            }
            return lowerKey;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            synchronized (this.mutex) {
                try {
                    NavigableSet<K> navigableSet = this.navigableKeySet;
                    if (navigableSet != null) {
                        return navigableSet;
                    }
                    NavigableSet<K> navigableSet2 = Synchronized.navigableSet(delegate().navigableKeySet(), this.mutex);
                    this.navigableKeySet = navigableSet2;
                    return navigableSet2;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            Map.Entry<K, V> nullableSynchronizedEntry;
            synchronized (this.mutex) {
                nullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(delegate().pollFirstEntry(), this.mutex);
            }
            return nullableSynchronizedEntry;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            Map.Entry<K, V> nullableSynchronizedEntry;
            synchronized (this.mutex) {
                nullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(delegate().pollLastEntry(), this.mutex);
            }
            return nullableSynchronizedEntry;
        }

        SynchronizedNavigableMap(NavigableMap<K, V> navigableMap, @NullableDecl Object obj) {
            super(navigableMap, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public NavigableMap<K, V> delegate() {
            return (NavigableMap) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(K k6) {
            return headMap(k6, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(K k6, K k7) {
            return subMap(k6, true, k7, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(K k6) {
            return tailMap(k6, true);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @GwtIncompatible
    @VisibleForTesting
    static class SynchronizedNavigableSet<E> extends SynchronizedSortedSet<E> implements NavigableSet<E> {
        private static final long serialVersionUID = 0;

        @MonotonicNonNullDecl
        transient NavigableSet<E> descendingSet;

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e6, boolean z5) {
            NavigableSet<E> navigableSet;
            synchronized (this.mutex) {
                navigableSet = Synchronized.navigableSet(delegate().headSet(e6, z5), this.mutex);
            }
            return navigableSet;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e6, boolean z5, E e7, boolean z6) {
            NavigableSet<E> navigableSet;
            synchronized (this.mutex) {
                navigableSet = Synchronized.navigableSet(delegate().subSet(e6, z5, e7, z6), this.mutex);
            }
            return navigableSet;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e6, boolean z5) {
            NavigableSet<E> navigableSet;
            synchronized (this.mutex) {
                navigableSet = Synchronized.navigableSet(delegate().tailSet(e6, z5), this.mutex);
            }
            return navigableSet;
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e6) {
            E ceiling;
            synchronized (this.mutex) {
                ceiling = delegate().ceiling(e6);
            }
            return ceiling;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            synchronized (this.mutex) {
                try {
                    NavigableSet<E> navigableSet = this.descendingSet;
                    if (navigableSet != null) {
                        return navigableSet;
                    }
                    NavigableSet<E> navigableSet2 = Synchronized.navigableSet(delegate().descendingSet(), this.mutex);
                    this.descendingSet = navigableSet2;
                    return navigableSet2;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.NavigableSet
        public E floor(E e6) {
            E floor;
            synchronized (this.mutex) {
                floor = delegate().floor(e6);
            }
            return floor;
        }

        @Override // java.util.NavigableSet
        public E higher(E e6) {
            E higher;
            synchronized (this.mutex) {
                higher = delegate().higher(e6);
            }
            return higher;
        }

        @Override // java.util.NavigableSet
        public E lower(E e6) {
            E lower;
            synchronized (this.mutex) {
                lower = delegate().lower(e6);
            }
            return lower;
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            E pollFirst;
            synchronized (this.mutex) {
                pollFirst = delegate().pollFirst();
            }
            return pollFirst;
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            E pollLast;
            synchronized (this.mutex) {
                pollLast = delegate().pollLast();
            }
            return pollLast;
        }

        SynchronizedNavigableSet(NavigableSet<E> navigableSet, @NullableDecl Object obj) {
            super(navigableSet, obj);
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return delegate().descendingIterator();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> headSet(E e6) {
            return headSet(e6, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> tailSet(E e6) {
            return tailSet(e6, true);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public NavigableSet<E> delegate() {
            return (NavigableSet) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> subSet(E e6, E e7) {
            return subSet(e6, true, e7, false);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class SynchronizedObject implements Serializable {

        @GwtIncompatible
        private static final long serialVersionUID = 0;
        final Object delegate;
        final Object mutex;

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            synchronized (this.mutex) {
                objectOutputStream.defaultWriteObject();
            }
        }

        Object delegate() {
            return this.delegate;
        }

        public String toString() {
            String obj;
            synchronized (this.mutex) {
                obj = this.delegate.toString();
            }
            return obj;
        }

        SynchronizedObject(Object obj, @NullableDecl Object obj2) {
            this.delegate = Preconditions.checkNotNull(obj);
            this.mutex = obj2 == null ? this : obj2;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class SynchronizedQueue<E> extends SynchronizedCollection<E> implements Queue<E> {
        private static final long serialVersionUID = 0;

        SynchronizedQueue(Queue<E> queue, @NullableDecl Object obj) {
            super(queue, obj, null);
        }

        @Override // java.util.Queue
        public E element() {
            E element;
            synchronized (this.mutex) {
                element = delegate().element();
            }
            return element;
        }

        @Override // java.util.Queue
        public boolean offer(E e6) {
            boolean offer;
            synchronized (this.mutex) {
                offer = delegate().offer(e6);
            }
            return offer;
        }

        @Override // java.util.Queue
        public E peek() {
            E peek;
            synchronized (this.mutex) {
                peek = delegate().peek();
            }
            return peek;
        }

        @Override // java.util.Queue
        public E poll() {
            E poll;
            synchronized (this.mutex) {
                poll = delegate().poll();
            }
            return poll;
        }

        @Override // java.util.Queue
        public E remove() {
            E remove;
            synchronized (this.mutex) {
                remove = delegate().remove();
            }
            return remove;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Queue<E> delegate() {
            return (Queue) super.delegate();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        private static final long serialVersionUID = 0;

        SynchronizedSet(Set<E> set, @NullableDecl Object obj) {
            super(set, obj, null);
        }

        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Set<E> delegate() {
            return (Set) super.delegate();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class SynchronizedSetMultimap<K, V> extends SynchronizedMultimap<K, V> implements SetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        @MonotonicNonNullDecl
        transient Set<Map.Entry<K, V>> entrySet;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((SynchronizedSetMultimap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedSetMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public Set<Map.Entry<K, V>> entries() {
            Set<Map.Entry<K, V>> set;
            synchronized (this.mutex) {
                try {
                    if (this.entrySet == null) {
                        this.entrySet = Synchronized.set(delegate().entries(), this.mutex);
                    }
                    set = this.entrySet;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public Set<V> get(K k6) {
            Set<V> set;
            synchronized (this.mutex) {
                set = Synchronized.set(delegate().get((SetMultimap<K, V>) k6), this.mutex);
            }
            return set;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public Set<V> removeAll(Object obj) {
            Set<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public Set<V> replaceValues(K k6, Iterable<? extends V> iterable) {
            Set<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues((SetMultimap<K, V>) k6, (Iterable) iterable);
            }
            return replaceValues;
        }

        SynchronizedSetMultimap(SetMultimap<K, V> setMultimap, @NullableDecl Object obj) {
            super(setMultimap, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public SetMultimap<K, V> delegate() {
            return (SetMultimap) super.delegate();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        private static final long serialVersionUID = 0;

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.mutex) {
                comparator = delegate().comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            K firstKey;
            synchronized (this.mutex) {
                firstKey = delegate().firstKey();
            }
            return firstKey;
        }

        public SortedMap<K, V> headMap(K k6) {
            SortedMap<K, V> sortedMap;
            synchronized (this.mutex) {
                sortedMap = Synchronized.sortedMap(delegate().headMap(k6), this.mutex);
            }
            return sortedMap;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            K lastKey;
            synchronized (this.mutex) {
                lastKey = delegate().lastKey();
            }
            return lastKey;
        }

        public SortedMap<K, V> subMap(K k6, K k7) {
            SortedMap<K, V> sortedMap;
            synchronized (this.mutex) {
                sortedMap = Synchronized.sortedMap(delegate().subMap(k6, k7), this.mutex);
            }
            return sortedMap;
        }

        public SortedMap<K, V> tailMap(K k6) {
            SortedMap<K, V> sortedMap;
            synchronized (this.mutex) {
                sortedMap = Synchronized.sortedMap(delegate().tailMap(k6), this.mutex);
            }
            return sortedMap;
        }

        SynchronizedSortedMap(SortedMap<K, V> sortedMap, @NullableDecl Object obj) {
            super(sortedMap, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public SortedMap<K, V> delegate() {
            return (SortedMap) super.delegate();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        private static final long serialVersionUID = 0;

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            Comparator<? super E> comparator;
            synchronized (this.mutex) {
                comparator = delegate().comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedSet
        public E first() {
            E first;
            synchronized (this.mutex) {
                first = delegate().first();
            }
            return first;
        }

        public SortedSet<E> headSet(E e6) {
            SortedSet<E> sortedSet;
            synchronized (this.mutex) {
                sortedSet = Synchronized.sortedSet(delegate().headSet(e6), this.mutex);
            }
            return sortedSet;
        }

        @Override // java.util.SortedSet
        public E last() {
            E last;
            synchronized (this.mutex) {
                last = delegate().last();
            }
            return last;
        }

        public SortedSet<E> subSet(E e6, E e7) {
            SortedSet<E> sortedSet;
            synchronized (this.mutex) {
                sortedSet = Synchronized.sortedSet(delegate().subSet(e6, e7), this.mutex);
            }
            return sortedSet;
        }

        public SortedSet<E> tailSet(E e6) {
            SortedSet<E> sortedSet;
            synchronized (this.mutex) {
                sortedSet = Synchronized.sortedSet(delegate().tailSet(e6), this.mutex);
            }
            return sortedSet;
        }

        SynchronizedSortedSet(SortedSet<E> sortedSet, @NullableDecl Object obj) {
            super(sortedSet, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public SortedSet<E> delegate() {
            return (SortedSet) super.delegate();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class SynchronizedSortedSetMultimap<K, V> extends SynchronizedSetMultimap<K, V> implements SortedSetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((SynchronizedSortedSetMultimap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedSortedSetMultimap<K, V>) obj, iterable);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Set get(Object obj) {
            return get((SynchronizedSortedSetMultimap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Set replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedSortedSetMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.SortedSetMultimap
        public Comparator<? super V> valueComparator() {
            Comparator<? super V> valueComparator;
            synchronized (this.mutex) {
                valueComparator = delegate().valueComparator();
            }
            return valueComparator;
        }

        SynchronizedSortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap, @NullableDecl Object obj) {
            super(sortedSetMultimap, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public SortedSet<V> get(K k6) {
            SortedSet<V> sortedSet;
            synchronized (this.mutex) {
                sortedSet = Synchronized.sortedSet(delegate().get((SortedSetMultimap<K, V>) k6), this.mutex);
            }
            return sortedSet;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public SortedSet<V> removeAll(Object obj) {
            SortedSet<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public SortedSet<V> replaceValues(K k6, Iterable<? extends V> iterable) {
            SortedSet<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues((SortedSetMultimap<K, V>) k6, (Iterable) iterable);
            }
            return replaceValues;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public SortedSetMultimap<K, V> delegate() {
            return (SortedSetMultimap) super.delegate();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class SynchronizedTable<R, C, V> extends SynchronizedObject implements Table<R, C, V> {
        @Override // com.google.common.collect.Table
        public Set<Table.Cell<R, C, V>> cellSet() {
            Set<Table.Cell<R, C, V>> set;
            synchronized (this.mutex) {
                set = Synchronized.set(delegate().cellSet(), this.mutex);
            }
            return set;
        }

        @Override // com.google.common.collect.Table
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        @Override // com.google.common.collect.Table
        public Map<R, V> column(@NullableDecl C c6) {
            Map<R, V> map;
            synchronized (this.mutex) {
                map = Synchronized.map(delegate().column(c6), this.mutex);
            }
            return map;
        }

        @Override // com.google.common.collect.Table
        public Set<C> columnKeySet() {
            Set<C> set;
            synchronized (this.mutex) {
                set = Synchronized.set(delegate().columnKeySet(), this.mutex);
            }
            return set;
        }

        @Override // com.google.common.collect.Table
        public Map<C, Map<R, V>> columnMap() {
            Map<C, Map<R, V>> map;
            synchronized (this.mutex) {
                map = Synchronized.map(Maps.transformValues(delegate().columnMap(), new Function<Map<R, V>, Map<R, V>>() { // from class: com.google.common.collect.Synchronized.SynchronizedTable.2
                    @Override // com.google.common.base.Function
                    public Map<R, V> apply(Map<R, V> map2) {
                        return Synchronized.map(map2, SynchronizedTable.this.mutex);
                    }
                }), this.mutex);
            }
            return map;
        }

        @Override // com.google.common.collect.Table
        public boolean contains(@NullableDecl Object obj, @NullableDecl Object obj2) {
            boolean contains;
            synchronized (this.mutex) {
                contains = delegate().contains(obj, obj2);
            }
            return contains;
        }

        @Override // com.google.common.collect.Table
        public boolean containsColumn(@NullableDecl Object obj) {
            boolean containsColumn;
            synchronized (this.mutex) {
                containsColumn = delegate().containsColumn(obj);
            }
            return containsColumn;
        }

        @Override // com.google.common.collect.Table
        public boolean containsRow(@NullableDecl Object obj) {
            boolean containsRow;
            synchronized (this.mutex) {
                containsRow = delegate().containsRow(obj);
            }
            return containsRow;
        }

        @Override // com.google.common.collect.Table
        public boolean containsValue(@NullableDecl Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = delegate().containsValue(obj);
            }
            return containsValue;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Table<R, C, V> delegate() {
            return (Table) super.delegate();
        }

        @Override // com.google.common.collect.Table
        public boolean equals(@NullableDecl Object obj) {
            boolean equals;
            if (this == obj) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // com.google.common.collect.Table
        public V get(@NullableDecl Object obj, @NullableDecl Object obj2) {
            V v5;
            synchronized (this.mutex) {
                v5 = delegate().get(obj, obj2);
            }
            return v5;
        }

        @Override // com.google.common.collect.Table
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // com.google.common.collect.Table
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        @Override // com.google.common.collect.Table
        public V put(@NullableDecl R r5, @NullableDecl C c6, @NullableDecl V v5) {
            V put;
            synchronized (this.mutex) {
                put = delegate().put(r5, c6, v5);
            }
            return put;
        }

        @Override // com.google.common.collect.Table
        public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
            synchronized (this.mutex) {
                delegate().putAll(table);
            }
        }

        @Override // com.google.common.collect.Table
        public V remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
            V remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj, obj2);
            }
            return remove;
        }

        @Override // com.google.common.collect.Table
        public Map<C, V> row(@NullableDecl R r5) {
            Map<C, V> map;
            synchronized (this.mutex) {
                map = Synchronized.map(delegate().row(r5), this.mutex);
            }
            return map;
        }

        @Override // com.google.common.collect.Table
        public Set<R> rowKeySet() {
            Set<R> set;
            synchronized (this.mutex) {
                set = Synchronized.set(delegate().rowKeySet(), this.mutex);
            }
            return set;
        }

        @Override // com.google.common.collect.Table
        public Map<R, Map<C, V>> rowMap() {
            Map<R, Map<C, V>> map;
            synchronized (this.mutex) {
                map = Synchronized.map(Maps.transformValues(delegate().rowMap(), new Function<Map<C, V>, Map<C, V>>() { // from class: com.google.common.collect.Synchronized.SynchronizedTable.1
                    @Override // com.google.common.base.Function
                    public Map<C, V> apply(Map<C, V> map2) {
                        return Synchronized.map(map2, SynchronizedTable.this.mutex);
                    }
                }), this.mutex);
            }
            return map;
        }

        @Override // com.google.common.collect.Table
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        @Override // com.google.common.collect.Table
        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.mutex) {
                collection = Synchronized.collection(delegate().values(), this.mutex);
            }
            return collection;
        }

        SynchronizedTable(Table<R, C, V> table, Object obj) {
            super(table, obj);
        }
    }

    @GwtIncompatible
    static <K, V> NavigableMap<K, V> navigableMap(NavigableMap<K, V> navigableMap) {
        return navigableMap(navigableMap, null);
    }

    @GwtIncompatible
    static <E> NavigableSet<E> navigableSet(NavigableSet<E> navigableSet, @NullableDecl Object obj) {
        return new SynchronizedNavigableSet(navigableSet, obj);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        private static final long serialVersionUID = 0;

        SynchronizedRandomAccessList(List<E> list, @NullableDecl Object obj) {
            super(list, obj);
        }
    }

    static <K, V> BiMap<K, V> biMap(BiMap<K, V> biMap, @NullableDecl Object obj) {
        return !(biMap instanceof SynchronizedBiMap) ? biMap instanceof ImmutableBiMap ? biMap : new SynchronizedBiMap(biMap, obj, null, 0 == true ? 1 : 0) : biMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Collection<E> collection(Collection<E> collection, @NullableDecl Object obj) {
        return new SynchronizedCollection(collection, obj, null);
    }

    static <E> Deque<E> deque(Deque<E> deque, @NullableDecl Object obj) {
        return new SynchronizedDeque(deque, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> List<E> list(List<E> list, @NullableDecl Object obj) {
        return list instanceof RandomAccess ? new SynchronizedRandomAccessList(list, obj) : new SynchronizedList(list, obj);
    }

    static <K, V> ListMultimap<K, V> listMultimap(ListMultimap<K, V> listMultimap, @NullableDecl Object obj) {
        return !(listMultimap instanceof SynchronizedListMultimap) ? listMultimap instanceof BaseImmutableMultimap ? listMultimap : new SynchronizedListMultimap(listMultimap, obj) : listMultimap;
    }

    @VisibleForTesting
    static <K, V> Map<K, V> map(Map<K, V> map, @NullableDecl Object obj) {
        return new SynchronizedMap(map, obj);
    }

    static <K, V> Multimap<K, V> multimap(Multimap<K, V> multimap, @NullableDecl Object obj) {
        return !(multimap instanceof SynchronizedMultimap) ? multimap instanceof BaseImmutableMultimap ? multimap : new SynchronizedMultimap(multimap, obj) : multimap;
    }

    static <E> Multiset<E> multiset(Multiset<E> multiset, @NullableDecl Object obj) {
        return !(multiset instanceof SynchronizedMultiset) ? multiset instanceof ImmutableMultiset ? multiset : new SynchronizedMultiset(multiset, obj) : multiset;
    }

    @GwtIncompatible
    static <K, V> NavigableMap<K, V> navigableMap(NavigableMap<K, V> navigableMap, @NullableDecl Object obj) {
        return new SynchronizedNavigableMap(navigableMap, obj);
    }

    @GwtIncompatible
    static <E> NavigableSet<E> navigableSet(NavigableSet<E> navigableSet) {
        return navigableSet(navigableSet, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GwtIncompatible
    public static <K, V> Map.Entry<K, V> nullableSynchronizedEntry(@NullableDecl Map.Entry<K, V> entry, @NullableDecl Object obj) {
        if (entry == null) {
            return null;
        }
        return new SynchronizedEntry(entry, obj);
    }

    static <E> Queue<E> queue(Queue<E> queue, @NullableDecl Object obj) {
        return queue instanceof SynchronizedQueue ? queue : new SynchronizedQueue(queue, obj);
    }

    @VisibleForTesting
    static <E> Set<E> set(Set<E> set, @NullableDecl Object obj) {
        return new SynchronizedSet(set, obj);
    }

    static <K, V> SetMultimap<K, V> setMultimap(SetMultimap<K, V> setMultimap, @NullableDecl Object obj) {
        return !(setMultimap instanceof SynchronizedSetMultimap) ? setMultimap instanceof BaseImmutableMultimap ? setMultimap : new SynchronizedSetMultimap(setMultimap, obj) : setMultimap;
    }

    static <K, V> SortedMap<K, V> sortedMap(SortedMap<K, V> sortedMap, @NullableDecl Object obj) {
        return new SynchronizedSortedMap(sortedMap, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> SortedSet<E> sortedSet(SortedSet<E> sortedSet, @NullableDecl Object obj) {
        return new SynchronizedSortedSet(sortedSet, obj);
    }

    static <K, V> SortedSetMultimap<K, V> sortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap, @NullableDecl Object obj) {
        return sortedSetMultimap instanceof SynchronizedSortedSetMultimap ? sortedSetMultimap : new SynchronizedSortedSetMultimap(sortedSetMultimap, obj);
    }

    static <R, C, V> Table<R, C, V> table(Table<R, C, V> table, Object obj) {
        return new SynchronizedTable(table, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Collection<E> typePreservingCollection(Collection<E> collection, @NullableDecl Object obj) {
        return collection instanceof SortedSet ? sortedSet((SortedSet) collection, obj) : collection instanceof Set ? set((Set) collection, obj) : collection instanceof List ? list((List) collection, obj) : collection(collection, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Set<E> typePreservingSet(Set<E> set, @NullableDecl Object obj) {
        return set instanceof SortedSet ? sortedSet((SortedSet) set, obj) : set(set, obj);
    }

    private Synchronized() {
    }
}
