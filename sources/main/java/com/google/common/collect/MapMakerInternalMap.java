package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap.InternalEntry;
import com.google.common.collect.MapMakerInternalMap.Segment;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
class MapMakerInternalMap<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    static final long CLEANUP_EXECUTOR_DELAY_SECS = 60;
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final WeakValueReference<Object, Object, DummyInternalEntry> UNSET_WEAK_VALUE_REFERENCE = new WeakValueReference<Object, Object, DummyInternalEntry>() { // from class: com.google.common.collect.MapMakerInternalMap.1
        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public WeakValueReference<Object, Object, DummyInternalEntry> copyFor(ReferenceQueue<Object> referenceQueue, DummyInternalEntry dummyInternalEntry) {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public Object get() {
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public DummyInternalEntry getEntry() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public void clear() {
        }
    };
    private static final long serialVersionUID = 5;
    final int concurrencyLevel;
    final transient InternalEntryHelper<K, V, E, S> entryHelper;

    @MonotonicNonNullDecl
    transient Set<Map.Entry<K, V>> entrySet;
    final Equivalence<Object> keyEquivalence;

    @MonotonicNonNullDecl
    transient Set<K> keySet;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient Segment<K, V, E, S>[] segments;

    @MonotonicNonNullDecl
    transient Collection<V> values;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class AbstractSerializationProxy<K, V> extends ForwardingConcurrentMap<K, V> implements Serializable {
        private static final long serialVersionUID = 3;
        final int concurrencyLevel;
        transient ConcurrentMap<K, V> delegate;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;

        void writeMapTo(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(this.delegate.size());
            for (Map.Entry<K, V> entry : this.delegate.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }

        AbstractSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i6, ConcurrentMap<K, V> concurrentMap) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.concurrencyLevel = i6;
            this.delegate = concurrentMap;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingConcurrentMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public ConcurrentMap<K, V> delegate() {
            return this.delegate;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void readEntries(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            while (true) {
                Object readObject = objectInputStream.readObject();
                if (readObject == null) {
                    return;
                }
                this.delegate.put(readObject, objectInputStream.readObject());
            }
        }

        MapMaker readMapMaker(ObjectInputStream objectInputStream) throws IOException {
            return new MapMaker().initialCapacity(objectInputStream.readInt()).setKeyStrength(this.keyStrength).setValueStrength(this.valueStrength).keyEquivalence(this.keyEquivalence).concurrencyLevel(this.concurrencyLevel);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class AbstractStrongKeyEntry<K, V, E extends InternalEntry<K, V, E>> implements InternalEntry<K, V, E> {
        final int hash;
        final K key;

        @NullableDecl
        final E next;

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public int getHash() {
            return this.hash;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public K getKey() {
            return this.key;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public E getNext() {
            return this.next;
        }

        AbstractStrongKeyEntry(K k6, int i6, @NullableDecl E e6) {
            this.key = k6;
            this.hash = i6;
            this.next = e6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class AbstractWeakKeyEntry<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<K> implements InternalEntry<K, V, E> {
        final int hash;

        @NullableDecl
        final E next;

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public int getHash() {
            return this.hash;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public E getNext() {
            return this.next;
        }

        AbstractWeakKeyEntry(ReferenceQueue<K> referenceQueue, K k6, int i6, @NullableDecl E e6) {
            super(k6, referenceQueue);
            this.hash = i6;
            this.next = e6;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public K getKey() {
            return get();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class CleanupMapTask implements Runnable {
        final WeakReference<MapMakerInternalMap<?, ?, ?, ?>> mapReference;

        @Override // java.lang.Runnable
        public void run() {
            MapMakerInternalMap<?, ?, ?, ?> mapMakerInternalMap = this.mapReference.get();
            if (mapMakerInternalMap == null) {
                throw new CancellationException();
            }
            for (Segment<?, ?, ?, ?> segment : mapMakerInternalMap.segments) {
                segment.runCleanup();
            }
        }

        public CleanupMapTask(MapMakerInternalMap<?, ?, ?, ?> mapMakerInternalMap) {
            this.mapReference = new WeakReference<>(mapMakerInternalMap);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class DummyInternalEntry implements InternalEntry<Object, Object, DummyInternalEntry> {
        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public int getHash() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public Object getKey() {
            throw new AssertionError();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public DummyInternalEntry getNext() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public Object getValue() {
            throw new AssertionError();
        }

        private DummyInternalEntry() {
            throw new AssertionError();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class EntryIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<Map.Entry<K, V>> {
        EntryIterator() {
            super();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.HashIterator, java.util.Iterator
        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class EntrySet extends SafeToArraySet<Map.Entry<K, V>> {
        EntrySet() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = MapMakerInternalMap.this.get(key)) != null && MapMakerInternalMap.this.valueEquivalence().equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && MapMakerInternalMap.this.remove(key, entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    abstract class HashIterator<T> implements Iterator<T> {

        @MonotonicNonNullDecl
        Segment<K, V, E, S> currentSegment;

        @MonotonicNonNullDecl
        AtomicReferenceArray<E> currentTable;

        @NullableDecl
        MapMakerInternalMap<K, V, E, S>.WriteThroughEntry lastReturned;

        @NullableDecl
        E nextEntry;

        @NullableDecl
        MapMakerInternalMap<K, V, E, S>.WriteThroughEntry nextExternal;
        int nextSegmentIndex;
        int nextTableIndex = -1;

        final void advance() {
            this.nextExternal = null;
            if (nextInChain() || nextInTable()) {
                return;
            }
            while (true) {
                int i6 = this.nextSegmentIndex;
                if (i6 < 0) {
                    return;
                }
                Segment<K, V, E, S>[] segmentArr = MapMakerInternalMap.this.segments;
                this.nextSegmentIndex = i6 - 1;
                Segment<K, V, E, S> segment = segmentArr[i6];
                this.currentSegment = segment;
                if (segment.count != 0) {
                    this.currentTable = this.currentSegment.table;
                    this.nextTableIndex = r0.length() - 1;
                    if (nextInTable()) {
                        return;
                    }
                }
            }
        }

        @Override // java.util.Iterator
        public abstract T next();

        HashIterator() {
            this.nextSegmentIndex = MapMakerInternalMap.this.segments.length - 1;
            advance();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextExternal != null;
        }

        MapMakerInternalMap<K, V, E, S>.WriteThroughEntry nextEntry() {
            MapMakerInternalMap<K, V, E, S>.WriteThroughEntry writeThroughEntry = this.nextExternal;
            if (writeThroughEntry == null) {
                throw new NoSuchElementException();
            }
            this.lastReturned = writeThroughEntry;
            advance();
            return this.lastReturned;
        }

        boolean nextInChain() {
            E e6 = this.nextEntry;
            if (e6 == null) {
                return false;
            }
            while (true) {
                this.nextEntry = (E) e6.getNext();
                E e7 = this.nextEntry;
                if (e7 == null) {
                    return false;
                }
                if (advanceTo(e7)) {
                    return true;
                }
                e6 = this.nextEntry;
            }
        }

        boolean nextInTable() {
            while (true) {
                int i6 = this.nextTableIndex;
                if (i6 < 0) {
                    return false;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.currentTable;
                this.nextTableIndex = i6 - 1;
                E e6 = atomicReferenceArray.get(i6);
                this.nextEntry = e6;
                if (e6 != null && (advanceTo(e6) || nextInChain())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            CollectPreconditions.checkRemove(this.lastReturned != null);
            MapMakerInternalMap.this.remove(this.lastReturned.getKey());
            this.lastReturned = null;
        }

        boolean advanceTo(E e6) {
            try {
                Object key = e6.getKey();
                Object liveValue = MapMakerInternalMap.this.getLiveValue(e6);
                if (liveValue != null) {
                    this.nextExternal = new WriteThroughEntry(key, liveValue);
                    this.currentSegment.postReadCleanup();
                    return true;
                }
                this.currentSegment.postReadCleanup();
                return false;
            } catch (Throwable th) {
                this.currentSegment.postReadCleanup();
                throw th;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface InternalEntry<K, V, E extends InternalEntry<K, V, E>> {
        int getHash();

        K getKey();

        E getNext();

        V getValue();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface InternalEntryHelper<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> {
        E copy(S s5, E e6, @NullableDecl E e7);

        Strength keyStrength();

        E newEntry(S s5, K k6, int i6, @NullableDecl E e6);

        S newSegment(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i6, int i7);

        void setValue(S s5, E e6, V v5);

        Strength valueStrength();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class KeyIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<K> {
        KeyIterator() {
            super();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.HashIterator, java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class KeySet extends SafeToArraySet<K> {
        KeySet() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return MapMakerInternalMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class SafeToArraySet<E> extends AbstractSet<E> {
        private SafeToArraySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return MapMakerInternalMap.toArrayList(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.toArrayList(this).toArray(tArr);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class Segment<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {
        volatile int count;

        @Weak
        final MapMakerInternalMap<K, V, E, S> map;
        final int maxSegmentSize;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();

        @MonotonicNonNullDecl
        volatile AtomicReferenceArray<E> table;
        int threshold;

        abstract E castForTesting(InternalEntry<K, V, ?> internalEntry);

        /* JADX WARN: Multi-variable type inference failed */
        @GuardedBy("this")
        void drainKeyReferenceQueue(ReferenceQueue<K> referenceQueue) {
            int i6 = 0;
            do {
                Reference<? extends K> poll = referenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.reclaimKey((InternalEntry) poll);
                i6++;
            } while (i6 != 16);
        }

        @GuardedBy("this")
        void drainValueReferenceQueue(ReferenceQueue<V> referenceQueue) {
            int i6 = 0;
            do {
                Reference<? extends V> poll = referenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.reclaimValue((WeakValueReference) poll);
                i6++;
            } while (i6 != 16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        V remove(Object obj, int i6) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i6;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                for (InternalEntry internalEntry2 = internalEntry; internalEntry2 != null; internalEntry2 = internalEntry2.getNext()) {
                    Object key = internalEntry2.getKey();
                    if (internalEntry2.getHash() == i6 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        V v5 = (V) internalEntry2.getValue();
                        if (v5 == null && !isCollected(internalEntry2)) {
                            return null;
                        }
                        this.modCount++;
                        InternalEntry removeFromChain = removeFromChain(internalEntry, internalEntry2);
                        int i7 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i7;
                        return v5;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean replace(K k6, int i6, V v5, V v6) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i6;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                for (InternalEntry internalEntry2 = internalEntry; internalEntry2 != null; internalEntry2 = internalEntry2.getNext()) {
                    Object key = internalEntry2.getKey();
                    if (internalEntry2.getHash() == i6 && key != null && this.map.keyEquivalence.equivalent(k6, key)) {
                        Object value = internalEntry2.getValue();
                        if (value != null) {
                            if (!this.map.valueEquivalence().equivalent(v5, value)) {
                                return false;
                            }
                            this.modCount++;
                            setValue(internalEntry2, v6);
                            return true;
                        }
                        if (isCollected(internalEntry2)) {
                            this.modCount++;
                            InternalEntry removeFromChain = removeFromChain(internalEntry, internalEntry2);
                            int i7 = this.count - 1;
                            atomicReferenceArray.set(length, removeFromChain);
                            this.count = i7;
                        }
                        return false;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        abstract S self();

        void clear() {
            if (this.count != 0) {
                lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    for (int i6 = 0; i6 < atomicReferenceArray.length(); i6++) {
                        atomicReferenceArray.set(i6, null);
                    }
                    maybeClearReferenceQueues();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                    unlock();
                } catch (Throwable th) {
                    unlock();
                    throw th;
                }
            }
        }

        boolean containsKey(Object obj, int i6) {
            try {
                boolean z5 = false;
                if (this.count == 0) {
                    return false;
                }
                E liveEntry = getLiveEntry(obj, i6);
                if (liveEntry != null) {
                    if (liveEntry.getValue() != null) {
                        z5 = true;
                    }
                }
                return z5;
            } finally {
                postReadCleanup();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @VisibleForTesting
        boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i6 = 0; i6 < length; i6++) {
                        for (E e6 = atomicReferenceArray.get(i6); e6 != null; e6 = e6.getNext()) {
                            Object liveValue = getLiveValue(e6);
                            if (liveValue != null && this.map.valueEquivalence().equivalent(obj, liveValue)) {
                                postReadCleanup();
                                return true;
                            }
                        }
                    }
                }
                return false;
            } finally {
                postReadCleanup();
            }
        }

        E copyEntry(E e6, E e7) {
            return this.map.entryHelper.copy(self(), e6, e7);
        }

        E copyForTesting(InternalEntry<K, V, ?> internalEntry, @NullableDecl InternalEntry<K, V, ?> internalEntry2) {
            return this.map.entryHelper.copy(self(), castForTesting(internalEntry), castForTesting(internalEntry2));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @GuardedBy("this")
        void expand() {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i6 = this.count;
            ArrayCompositeDisposable arrayCompositeDisposable = (AtomicReferenceArray<E>) newEntryArray(length << 1);
            this.threshold = (arrayCompositeDisposable.length() * 3) / 4;
            int length2 = arrayCompositeDisposable.length() - 1;
            for (int i7 = 0; i7 < length; i7++) {
                E e6 = atomicReferenceArray.get(i7);
                if (e6 != null) {
                    InternalEntry next = e6.getNext();
                    int hash = e6.getHash() & length2;
                    if (next == null) {
                        arrayCompositeDisposable.set(hash, e6);
                    } else {
                        InternalEntry internalEntry = e6;
                        while (next != null) {
                            int hash2 = next.getHash() & length2;
                            if (hash2 != hash) {
                                internalEntry = next;
                                hash = hash2;
                            }
                            next = next.getNext();
                        }
                        arrayCompositeDisposable.set(hash, internalEntry);
                        while (e6 != internalEntry) {
                            int hash3 = e6.getHash() & length2;
                            InternalEntry copyEntry = copyEntry(e6, (InternalEntry) arrayCompositeDisposable.get(hash3));
                            if (copyEntry != null) {
                                arrayCompositeDisposable.set(hash3, copyEntry);
                            } else {
                                i6--;
                            }
                            e6 = e6.getNext();
                        }
                    }
                }
            }
            this.table = arrayCompositeDisposable;
            this.count = i6;
        }

        E getEntry(Object obj, int i6) {
            if (this.count == 0) {
                return null;
            }
            for (E first = getFirst(i6); first != null; first = (E) first.getNext()) {
                if (first.getHash() == i6) {
                    Object key = first.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                        return first;
                    }
                }
            }
            return null;
        }

        E getFirst(int i6) {
            return this.table.get(i6 & (r0.length() - 1));
        }

        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            throw new AssertionError();
        }

        ReferenceQueue<V> getValueReferenceQueueForTesting() {
            throw new AssertionError();
        }

        WeakValueReference<K, V, E> getWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry) {
            throw new AssertionError();
        }

        AtomicReferenceArray<E> newEntryArray(int i6) {
            return new AtomicReferenceArray<>(i6);
        }

        E newEntryForTesting(K k6, int i6, @NullableDecl InternalEntry<K, V, ?> internalEntry) {
            return this.map.entryHelper.newEntry(self(), k6, i6, castForTesting(internalEntry));
        }

        WeakValueReference<K, V, E> newWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry, V v5) {
            throw new AssertionError();
        }

        void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                runCleanup();
            }
        }

        @GuardedBy("this")
        E removeFromChain(E e6, E e7) {
            int i6 = this.count;
            E e8 = (E) e7.getNext();
            while (e6 != e7) {
                E copyEntry = copyEntry(e6, e8);
                if (copyEntry != null) {
                    e8 = copyEntry;
                } else {
                    i6--;
                }
                e6 = (E) e6.getNext();
            }
            this.count = i6;
            return e8;
        }

        void setTableEntryForTesting(int i6, InternalEntry<K, V, ?> internalEntry) {
            this.table.set(i6, castForTesting(internalEntry));
        }

        void setValue(E e6, V v5) {
            this.map.entryHelper.setValue(self(), e6, v5);
        }

        void setValueForTesting(InternalEntry<K, V, ?> internalEntry, V v5) {
            this.map.entryHelper.setValue(self(), castForTesting(internalEntry), v5);
        }

        void setWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> weakValueReference) {
            throw new AssertionError();
        }

        Segment(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i6, int i7) {
            this.map = mapMakerInternalMap;
            this.maxSegmentSize = i7;
            initTable(newEntryArray(i6));
        }

        static <K, V, E extends InternalEntry<K, V, E>> boolean isCollected(E e6) {
            if (e6.getValue() == null) {
                return true;
            }
            return false;
        }

        <T> void clearReferenceQueue(ReferenceQueue<T> referenceQueue) {
            while (referenceQueue.poll() != null) {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        boolean clearValueForTesting(K k6, int i6, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> weakValueReference) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i6;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                for (InternalEntry internalEntry2 = internalEntry; internalEntry2 != null; internalEntry2 = internalEntry2.getNext()) {
                    Object key = internalEntry2.getKey();
                    if (internalEntry2.getHash() == i6 && key != null && this.map.keyEquivalence.equivalent(k6, key)) {
                        if (((WeakValueEntry) internalEntry2).getValueReference() != weakValueReference) {
                            return false;
                        }
                        atomicReferenceArray.set(length, removeFromChain(internalEntry, internalEntry2));
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        V get(Object obj, int i6) {
            try {
                E liveEntry = getLiveEntry(obj, i6);
                if (liveEntry == null) {
                    postReadCleanup();
                    return null;
                }
                V v5 = (V) liveEntry.getValue();
                if (v5 == null) {
                    tryDrainReferenceQueues();
                }
                return v5;
            } finally {
                postReadCleanup();
            }
        }

        E getLiveEntry(Object obj, int i6) {
            return getEntry(obj, i6);
        }

        @NullableDecl
        V getLiveValue(E e6) {
            if (e6.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v5 = (V) e6.getValue();
            if (v5 == null) {
                tryDrainReferenceQueues();
                return null;
            }
            return v5;
        }

        @NullableDecl
        V getLiveValueForTesting(InternalEntry<K, V, ?> internalEntry) {
            return getLiveValue(castForTesting(internalEntry));
        }

        void initTable(AtomicReferenceArray<E> atomicReferenceArray) {
            int length = (atomicReferenceArray.length() * 3) / 4;
            this.threshold = length;
            if (length == this.maxSegmentSize) {
                this.threshold = length + 1;
            }
            this.table = atomicReferenceArray;
        }

        @GuardedBy("this")
        void preWriteCleanup() {
            runLockedCleanup();
        }

        /* JADX WARN: Multi-variable type inference failed */
        V put(K k6, int i6, V v5, boolean z5) {
            lock();
            try {
                preWriteCleanup();
                int i7 = this.count + 1;
                if (i7 > this.threshold) {
                    expand();
                    i7 = this.count + 1;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i6;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                for (InternalEntry internalEntry2 = internalEntry; internalEntry2 != null; internalEntry2 = internalEntry2.getNext()) {
                    Object key = internalEntry2.getKey();
                    if (internalEntry2.getHash() == i6 && key != null && this.map.keyEquivalence.equivalent(k6, key)) {
                        V v6 = (V) internalEntry2.getValue();
                        if (v6 == null) {
                            this.modCount++;
                            setValue(internalEntry2, v5);
                            this.count = this.count;
                            unlock();
                            return null;
                        }
                        if (z5) {
                            unlock();
                            return v6;
                        }
                        this.modCount++;
                        setValue(internalEntry2, v5);
                        unlock();
                        return v6;
                    }
                }
                this.modCount++;
                InternalEntry newEntry = this.map.entryHelper.newEntry(self(), k6, i6, internalEntry);
                setValue(newEntry, v5);
                atomicReferenceArray.set(length, newEntry);
                this.count = i7;
                unlock();
                return null;
            } catch (Throwable th) {
                unlock();
                throw th;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        boolean reclaimKey(E e6, int i6) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = i6 & (atomicReferenceArray.length() - 1);
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                for (InternalEntry internalEntry2 = internalEntry; internalEntry2 != null; internalEntry2 = internalEntry2.getNext()) {
                    if (internalEntry2 == e6) {
                        this.modCount++;
                        InternalEntry removeFromChain = removeFromChain(internalEntry, internalEntry2);
                        int i7 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i7;
                        return true;
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        boolean reclaimValue(K k6, int i6, WeakValueReference<K, V, E> weakValueReference) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i6;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                for (InternalEntry internalEntry2 = internalEntry; internalEntry2 != null; internalEntry2 = internalEntry2.getNext()) {
                    Object key = internalEntry2.getKey();
                    if (internalEntry2.getHash() == i6 && key != null && this.map.keyEquivalence.equivalent(k6, key)) {
                        if (((WeakValueEntry) internalEntry2).getValueReference() != weakValueReference) {
                            return false;
                        }
                        this.modCount++;
                        InternalEntry removeFromChain = removeFromChain(internalEntry, internalEntry2);
                        int i7 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i7;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @GuardedBy("this")
        boolean removeEntryForTesting(E e6) {
            int hash = e6.getHash();
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = hash & (atomicReferenceArray.length() - 1);
            InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
            for (InternalEntry internalEntry2 = internalEntry; internalEntry2 != null; internalEntry2 = internalEntry2.getNext()) {
                if (internalEntry2 == e6) {
                    this.modCount++;
                    InternalEntry removeFromChain = removeFromChain(internalEntry, internalEntry2);
                    int i6 = this.count - 1;
                    atomicReferenceArray.set(length, removeFromChain);
                    this.count = i6;
                    return true;
                }
            }
            return false;
        }

        E removeFromChainForTesting(InternalEntry<K, V, ?> internalEntry, InternalEntry<K, V, ?> internalEntry2) {
            return removeFromChain(castForTesting(internalEntry), castForTesting(internalEntry2));
        }

        @CanIgnoreReturnValue
        boolean removeTableEntryForTesting(InternalEntry<K, V, ?> internalEntry) {
            return removeEntryForTesting(castForTesting(internalEntry));
        }

        void runCleanup() {
            runLockedCleanup();
        }

        void runLockedCleanup() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        void maybeClearReferenceQueues() {
        }

        @GuardedBy("this")
        void maybeDrainReferenceQueues() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
        
            if (r8.map.valueEquivalence().equivalent(r11, r4.getValue()) == false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
        
            r5 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
        
            r8.modCount++;
            r9 = removeFromChain(r3, r4);
            r10 = r8.count - 1;
            r0.set(r1, r9);
            r8.count = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
        
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
        
            if (isCollected(r4) == false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
        
            return false;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean remove(java.lang.Object r9, int r10, java.lang.Object r11) {
            /*
                r8 = this;
                r8.lock()
                r8.preWriteCleanup()     // Catch: java.lang.Throwable -> L5c
                java.util.concurrent.atomic.AtomicReferenceArray<E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>> r0 = r8.table     // Catch: java.lang.Throwable -> L5c
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L5c
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r10
                java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L5c
                com.google.common.collect.MapMakerInternalMap$InternalEntry r3 = (com.google.common.collect.MapMakerInternalMap.InternalEntry) r3     // Catch: java.lang.Throwable -> L5c
                r4 = r3
            L16:
                r5 = 0
                if (r4 == 0) goto L67
                java.lang.Object r6 = r4.getKey()     // Catch: java.lang.Throwable -> L5c
                int r7 = r4.getHash()     // Catch: java.lang.Throwable -> L5c
                if (r7 != r10) goto L62
                if (r6 == 0) goto L62
                com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r7 = r8.map     // Catch: java.lang.Throwable -> L5c
                com.google.common.base.Equivalence<java.lang.Object> r7 = r7.keyEquivalence     // Catch: java.lang.Throwable -> L5c
                boolean r6 = r7.equivalent(r9, r6)     // Catch: java.lang.Throwable -> L5c
                if (r6 == 0) goto L62
                java.lang.Object r9 = r4.getValue()     // Catch: java.lang.Throwable -> L5c
                com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r10 = r8.map     // Catch: java.lang.Throwable -> L5c
                com.google.common.base.Equivalence r10 = r10.valueEquivalence()     // Catch: java.lang.Throwable -> L5c
                boolean r9 = r10.equivalent(r11, r9)     // Catch: java.lang.Throwable -> L5c
                if (r9 == 0) goto L41
                r5 = 1
                goto L47
            L41:
                boolean r9 = isCollected(r4)     // Catch: java.lang.Throwable -> L5c
                if (r9 == 0) goto L5e
            L47:
                int r9 = r8.modCount     // Catch: java.lang.Throwable -> L5c
                int r9 = r9 + r2
                r8.modCount = r9     // Catch: java.lang.Throwable -> L5c
                com.google.common.collect.MapMakerInternalMap$InternalEntry r9 = r8.removeFromChain(r3, r4)     // Catch: java.lang.Throwable -> L5c
                int r10 = r8.count     // Catch: java.lang.Throwable -> L5c
                int r10 = r10 - r2
                r0.set(r1, r9)     // Catch: java.lang.Throwable -> L5c
                r8.count = r10     // Catch: java.lang.Throwable -> L5c
                r8.unlock()
                return r5
            L5c:
                r9 = move-exception
                goto L6b
            L5e:
                r8.unlock()
                return r5
            L62:
                com.google.common.collect.MapMakerInternalMap$InternalEntry r4 = r4.getNext()     // Catch: java.lang.Throwable -> L5c
                goto L16
            L67:
                r8.unlock()
                return r5
            L6b:
                r8.unlock()
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.remove(java.lang.Object, int, java.lang.Object):boolean");
        }

        /* JADX WARN: Multi-variable type inference failed */
        V replace(K k6, int i6, V v5) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i6;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                for (InternalEntry internalEntry2 = internalEntry; internalEntry2 != null; internalEntry2 = internalEntry2.getNext()) {
                    Object key = internalEntry2.getKey();
                    if (internalEntry2.getHash() == i6 && key != null && this.map.keyEquivalence.equivalent(k6, key)) {
                        V v6 = (V) internalEntry2.getValue();
                        if (v6 == null) {
                            if (isCollected(internalEntry2)) {
                                this.modCount++;
                                InternalEntry removeFromChain = removeFromChain(internalEntry, internalEntry2);
                                int i7 = this.count - 1;
                                atomicReferenceArray.set(length, removeFromChain);
                                this.count = i7;
                            }
                            return null;
                        }
                        this.modCount++;
                        setValue(internalEntry2, v5);
                        return v6;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        private Object readResolve() {
            return this.delegate;
        }

        SerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i6, ConcurrentMap<K, V> concurrentMap) {
            super(strength, strength2, equivalence, equivalence2, i6, concurrentMap);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = readMapMaker(objectInputStream).makeMap();
            readEntries(objectInputStream);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            writeMapTo(objectOutputStream);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum Strength {
        STRONG { // from class: com.google.common.collect.MapMakerInternalMap.Strength.1
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }
        },
        WEAK { // from class: com.google.common.collect.MapMakerInternalMap.Strength.2
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        };

        abstract Equivalence<Object> defaultEquivalence();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class StrongKeyDummyValueEntry<K> extends AbstractStrongKeyEntry<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>> implements StrongValueEntry<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class Helper<K> implements InternalEntryHelper<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> {
            private static final Helper<?> INSTANCE = new Helper<>();

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry newEntry(Segment segment, Object obj, int i6, @NullableDecl InternalEntry internalEntry) {
                return newEntry((StrongKeyDummyValueSegment<StrongKeyDummyValueSegment<K>>) segment, (StrongKeyDummyValueSegment<K>) obj, i6, (StrongKeyDummyValueEntry<StrongKeyDummyValueSegment<K>>) internalEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public void setValue(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, StrongKeyDummyValueEntry<K> strongKeyDummyValueEntry, MapMaker.Dummy dummy) {
            }

            static <K> Helper<K> instance() {
                return (Helper<K>) INSTANCE;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public StrongKeyDummyValueEntry<K> copy(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, StrongKeyDummyValueEntry<K> strongKeyDummyValueEntry, @NullableDecl StrongKeyDummyValueEntry<K> strongKeyDummyValueEntry2) {
                return strongKeyDummyValueEntry.copy(strongKeyDummyValueEntry2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.STRONG;
            }

            public StrongKeyDummyValueEntry<K> newEntry(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, K k6, int i6, @NullableDecl StrongKeyDummyValueEntry<K> strongKeyDummyValueEntry) {
                return new StrongKeyDummyValueEntry<>(k6, i6, strongKeyDummyValueEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public StrongKeyDummyValueSegment<K> newSegment(MapMakerInternalMap<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i6, int i7) {
                return new StrongKeyDummyValueSegment<>(mapMakerInternalMap, i6, i7);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.STRONG;
            }

            Helper() {
            }
        }

        StrongKeyDummyValueEntry<K> copy(StrongKeyDummyValueEntry<K> strongKeyDummyValueEntry) {
            return new StrongKeyDummyValueEntry<>(this.key, this.hash, strongKeyDummyValueEntry);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }

        StrongKeyDummyValueEntry(K k6, int i6, @NullableDecl StrongKeyDummyValueEntry<K> strongKeyDummyValueEntry) {
            super(k6, i6, strongKeyDummyValueEntry);
        }

        void setValue(MapMaker.Dummy dummy) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class StrongKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyDummyValueSegment<K> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyDummyValueEntry<K> castForTesting(InternalEntry<K, MapMaker.Dummy, ?> internalEntry) {
            return (StrongKeyDummyValueEntry) internalEntry;
        }

        StrongKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i6, int i7) {
            super(mapMakerInternalMap, i6, i7);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class StrongKeyStrongValueEntry<K, V> extends AbstractStrongKeyEntry<K, V, StrongKeyStrongValueEntry<K, V>> implements StrongValueEntry<K, V, StrongKeyStrongValueEntry<K, V>> {

        @NullableDecl
        private volatile V value;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class Helper<K, V> implements InternalEntryHelper<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> {
            private static final Helper<?, ?> INSTANCE = new Helper<>();

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry newEntry(Segment segment, Object obj, int i6, @NullableDecl InternalEntry internalEntry) {
                return newEntry((StrongKeyStrongValueSegment<StrongKeyStrongValueSegment<K, V>, V>) segment, (StrongKeyStrongValueSegment<K, V>) obj, i6, (StrongKeyStrongValueEntry<StrongKeyStrongValueSegment<K, V>, V>) internalEntry);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ void setValue(Segment segment, InternalEntry internalEntry, Object obj) {
                setValue((StrongKeyStrongValueSegment<K, StrongKeyStrongValueEntry<K, V>>) segment, (StrongKeyStrongValueEntry<K, StrongKeyStrongValueEntry<K, V>>) internalEntry, (StrongKeyStrongValueEntry<K, V>) obj);
            }

            static <K, V> Helper<K, V> instance() {
                return (Helper<K, V>) INSTANCE;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public StrongKeyStrongValueEntry<K, V> copy(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry, @NullableDecl StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry2) {
                return strongKeyStrongValueEntry.copy(strongKeyStrongValueEntry2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.STRONG;
            }

            public StrongKeyStrongValueEntry<K, V> newEntry(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, K k6, int i6, @NullableDecl StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry) {
                return new StrongKeyStrongValueEntry<>(k6, i6, strongKeyStrongValueEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public StrongKeyStrongValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i6, int i7) {
                return new StrongKeyStrongValueSegment<>(mapMakerInternalMap, i6, i7);
            }

            public void setValue(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry, V v5) {
                strongKeyStrongValueEntry.setValue(v5);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.STRONG;
            }

            Helper() {
            }
        }

        StrongKeyStrongValueEntry<K, V> copy(StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry) {
            StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry2 = new StrongKeyStrongValueEntry<>(this.key, this.hash, strongKeyStrongValueEntry);
            strongKeyStrongValueEntry2.value = this.value;
            return strongKeyStrongValueEntry2;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        @NullableDecl
        public V getValue() {
            return this.value;
        }

        void setValue(V v5) {
            this.value = v5;
        }

        StrongKeyStrongValueEntry(K k6, int i6, @NullableDecl StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry) {
            super(k6, i6, strongKeyStrongValueEntry);
            this.value = null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyStrongValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyStrongValueEntry<K, V> castForTesting(InternalEntry<K, V, ?> internalEntry) {
            return (StrongKeyStrongValueEntry) internalEntry;
        }

        StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i6, int i7) {
            super(mapMakerInternalMap, i6, i7);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class StrongKeyWeakValueEntry<K, V> extends AbstractStrongKeyEntry<K, V, StrongKeyWeakValueEntry<K, V>> implements WeakValueEntry<K, V, StrongKeyWeakValueEntry<K, V>> {
        private volatile WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> valueReference;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class Helper<K, V> implements InternalEntryHelper<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> {
            private static final Helper<?, ?> INSTANCE = new Helper<>();

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry newEntry(Segment segment, Object obj, int i6, @NullableDecl InternalEntry internalEntry) {
                return newEntry((StrongKeyWeakValueSegment<StrongKeyWeakValueSegment<K, V>, V>) segment, (StrongKeyWeakValueSegment<K, V>) obj, i6, (StrongKeyWeakValueEntry<StrongKeyWeakValueSegment<K, V>, V>) internalEntry);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ void setValue(Segment segment, InternalEntry internalEntry, Object obj) {
                setValue((StrongKeyWeakValueSegment<K, StrongKeyWeakValueEntry<K, V>>) segment, (StrongKeyWeakValueEntry<K, StrongKeyWeakValueEntry<K, V>>) internalEntry, (StrongKeyWeakValueEntry<K, V>) obj);
            }

            static <K, V> Helper<K, V> instance() {
                return (Helper<K, V>) INSTANCE;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public StrongKeyWeakValueEntry<K, V> copy(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry, @NullableDecl StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry2) {
                if (Segment.isCollected(strongKeyWeakValueEntry)) {
                    return null;
                }
                return strongKeyWeakValueEntry.copy(((StrongKeyWeakValueSegment) strongKeyWeakValueSegment).queueForValues, strongKeyWeakValueEntry2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.STRONG;
            }

            public StrongKeyWeakValueEntry<K, V> newEntry(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, K k6, int i6, @NullableDecl StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry) {
                return new StrongKeyWeakValueEntry<>(k6, i6, strongKeyWeakValueEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public StrongKeyWeakValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i6, int i7) {
                return new StrongKeyWeakValueSegment<>(mapMakerInternalMap, i6, i7);
            }

            public void setValue(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry, V v5) {
                strongKeyWeakValueEntry.setValue(v5, ((StrongKeyWeakValueSegment) strongKeyWeakValueSegment).queueForValues);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.WEAK;
            }

            Helper() {
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public void clearValue() {
            this.valueReference.clear();
        }

        StrongKeyWeakValueEntry<K, V> copy(ReferenceQueue<V> referenceQueue, StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry) {
            StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry2 = new StrongKeyWeakValueEntry<>(this.key, this.hash, strongKeyWeakValueEntry);
            strongKeyWeakValueEntry2.valueReference = this.valueReference.copyFor(referenceQueue, strongKeyWeakValueEntry2);
            return strongKeyWeakValueEntry2;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public V getValue() {
            return this.valueReference.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> getValueReference() {
            return this.valueReference;
        }

        void setValue(V v5, ReferenceQueue<V> referenceQueue) {
            WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> weakValueReference = this.valueReference;
            this.valueReference = new WeakValueReferenceImpl(referenceQueue, v5, this);
            weakValueReference.clear();
        }

        StrongKeyWeakValueEntry(K k6, int i6, @NullableDecl StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry) {
            super(k6, i6, strongKeyWeakValueEntry);
            this.valueReference = MapMakerInternalMap.unsetWeakValueReference();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<V> queueForValues;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyWeakValueEntry<K, V> castForTesting(InternalEntry<K, V, ?> internalEntry) {
            return (StrongKeyWeakValueEntry) internalEntry;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> newWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry, V v5) {
            return new WeakValueReferenceImpl(this.queueForValues, v5, castForTesting((InternalEntry) internalEntry));
        }

        StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i6, int i7) {
            super(mapMakerInternalMap, i6, i7);
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> getWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry) {
            return castForTesting((InternalEntry) internalEntry).getValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> weakValueReference) {
            StrongKeyWeakValueEntry<K, V> castForTesting = castForTesting((InternalEntry) internalEntry);
            WeakValueReference weakValueReference2 = ((StrongKeyWeakValueEntry) castForTesting).valueReference;
            ((StrongKeyWeakValueEntry) castForTesting).valueReference = weakValueReference;
            weakValueReference2.clear();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface StrongValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class ValueIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<V> {
        ValueIterator() {
            super();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.HashIterator, java.util.Iterator
        public V next() {
            return nextEntry().getValue();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class Values extends AbstractCollection<V> {
        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return MapMakerInternalMap.toArrayList(this).toArray();
        }

        Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return MapMakerInternalMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.toArrayList(this).toArray(tArr);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WeakKeyDummyValueEntry<K> extends AbstractWeakKeyEntry<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>> implements StrongValueEntry<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class Helper<K> implements InternalEntryHelper<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> {
            private static final Helper<?> INSTANCE = new Helper<>();

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry newEntry(Segment segment, Object obj, int i6, @NullableDecl InternalEntry internalEntry) {
                return newEntry((WeakKeyDummyValueSegment<WeakKeyDummyValueSegment<K>>) segment, (WeakKeyDummyValueSegment<K>) obj, i6, (WeakKeyDummyValueEntry<WeakKeyDummyValueSegment<K>>) internalEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public void setValue(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, WeakKeyDummyValueEntry<K> weakKeyDummyValueEntry, MapMaker.Dummy dummy) {
            }

            static <K> Helper<K> instance() {
                return (Helper<K>) INSTANCE;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public WeakKeyDummyValueEntry<K> copy(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, WeakKeyDummyValueEntry<K> weakKeyDummyValueEntry, @NullableDecl WeakKeyDummyValueEntry<K> weakKeyDummyValueEntry2) {
                if (weakKeyDummyValueEntry.getKey() == null) {
                    return null;
                }
                return weakKeyDummyValueEntry.copy(((WeakKeyDummyValueSegment) weakKeyDummyValueSegment).queueForKeys, weakKeyDummyValueEntry2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.WEAK;
            }

            public WeakKeyDummyValueEntry<K> newEntry(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, K k6, int i6, @NullableDecl WeakKeyDummyValueEntry<K> weakKeyDummyValueEntry) {
                return new WeakKeyDummyValueEntry<>(((WeakKeyDummyValueSegment) weakKeyDummyValueSegment).queueForKeys, k6, i6, weakKeyDummyValueEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public WeakKeyDummyValueSegment<K> newSegment(MapMakerInternalMap<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i6, int i7) {
                return new WeakKeyDummyValueSegment<>(mapMakerInternalMap, i6, i7);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.STRONG;
            }

            Helper() {
            }
        }

        WeakKeyDummyValueEntry<K> copy(ReferenceQueue<K> referenceQueue, WeakKeyDummyValueEntry<K> weakKeyDummyValueEntry) {
            return new WeakKeyDummyValueEntry<>(referenceQueue, getKey(), this.hash, weakKeyDummyValueEntry);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }

        WeakKeyDummyValueEntry(ReferenceQueue<K> referenceQueue, K k6, int i6, @NullableDecl WeakKeyDummyValueEntry<K> weakKeyDummyValueEntry) {
            super(referenceQueue, k6, i6, weakKeyDummyValueEntry);
        }

        void setValue(MapMaker.Dummy dummy) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WeakKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> {
        private final ReferenceQueue<K> queueForKeys;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyDummyValueSegment<K> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyDummyValueEntry<K> castForTesting(InternalEntry<K, MapMaker.Dummy, ?> internalEntry) {
            return (WeakKeyDummyValueEntry) internalEntry;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        WeakKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i6, int i7) {
            super(mapMakerInternalMap, i6, i7);
            this.queueForKeys = new ReferenceQueue<>();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WeakKeyStrongValueEntry<K, V> extends AbstractWeakKeyEntry<K, V, WeakKeyStrongValueEntry<K, V>> implements StrongValueEntry<K, V, WeakKeyStrongValueEntry<K, V>> {

        @NullableDecl
        private volatile V value;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class Helper<K, V> implements InternalEntryHelper<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> {
            private static final Helper<?, ?> INSTANCE = new Helper<>();

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry newEntry(Segment segment, Object obj, int i6, @NullableDecl InternalEntry internalEntry) {
                return newEntry((WeakKeyStrongValueSegment<WeakKeyStrongValueSegment<K, V>, V>) segment, (WeakKeyStrongValueSegment<K, V>) obj, i6, (WeakKeyStrongValueEntry<WeakKeyStrongValueSegment<K, V>, V>) internalEntry);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ void setValue(Segment segment, InternalEntry internalEntry, Object obj) {
                setValue((WeakKeyStrongValueSegment<K, WeakKeyStrongValueEntry<K, V>>) segment, (WeakKeyStrongValueEntry<K, WeakKeyStrongValueEntry<K, V>>) internalEntry, (WeakKeyStrongValueEntry<K, V>) obj);
            }

            static <K, V> Helper<K, V> instance() {
                return (Helper<K, V>) INSTANCE;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public WeakKeyStrongValueEntry<K, V> copy(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry, @NullableDecl WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry2) {
                if (weakKeyStrongValueEntry.getKey() == null) {
                    return null;
                }
                return weakKeyStrongValueEntry.copy(((WeakKeyStrongValueSegment) weakKeyStrongValueSegment).queueForKeys, weakKeyStrongValueEntry2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.WEAK;
            }

            public WeakKeyStrongValueEntry<K, V> newEntry(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, K k6, int i6, @NullableDecl WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry) {
                return new WeakKeyStrongValueEntry<>(((WeakKeyStrongValueSegment) weakKeyStrongValueSegment).queueForKeys, k6, i6, weakKeyStrongValueEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public WeakKeyStrongValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i6, int i7) {
                return new WeakKeyStrongValueSegment<>(mapMakerInternalMap, i6, i7);
            }

            public void setValue(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry, V v5) {
                weakKeyStrongValueEntry.setValue(v5);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.STRONG;
            }

            Helper() {
            }
        }

        WeakKeyStrongValueEntry<K, V> copy(ReferenceQueue<K> referenceQueue, WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry) {
            WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry2 = new WeakKeyStrongValueEntry<>(referenceQueue, getKey(), this.hash, weakKeyStrongValueEntry);
            weakKeyStrongValueEntry2.setValue(this.value);
            return weakKeyStrongValueEntry2;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        @NullableDecl
        public V getValue() {
            return this.value;
        }

        void setValue(V v5) {
            this.value = v5;
        }

        WeakKeyStrongValueEntry(ReferenceQueue<K> referenceQueue, K k6, int i6, @NullableDecl WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry) {
            super(referenceQueue, k6, i6, weakKeyStrongValueEntry);
            this.value = null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyStrongValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyStrongValueEntry<K, V> castForTesting(InternalEntry<K, V, ?> internalEntry) {
            return (WeakKeyStrongValueEntry) internalEntry;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i6, int i7) {
            super(mapMakerInternalMap, i6, i7);
            this.queueForKeys = new ReferenceQueue<>();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WeakKeyWeakValueEntry<K, V> extends AbstractWeakKeyEntry<K, V, WeakKeyWeakValueEntry<K, V>> implements WeakValueEntry<K, V, WeakKeyWeakValueEntry<K, V>> {
        private volatile WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> valueReference;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class Helper<K, V> implements InternalEntryHelper<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> {
            private static final Helper<?, ?> INSTANCE = new Helper<>();

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ InternalEntry newEntry(Segment segment, Object obj, int i6, @NullableDecl InternalEntry internalEntry) {
                return newEntry((WeakKeyWeakValueSegment<WeakKeyWeakValueSegment<K, V>, V>) segment, (WeakKeyWeakValueSegment<K, V>) obj, i6, (WeakKeyWeakValueEntry<WeakKeyWeakValueSegment<K, V>, V>) internalEntry);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public /* bridge */ /* synthetic */ void setValue(Segment segment, InternalEntry internalEntry, Object obj) {
                setValue((WeakKeyWeakValueSegment<K, WeakKeyWeakValueEntry<K, V>>) segment, (WeakKeyWeakValueEntry<K, WeakKeyWeakValueEntry<K, V>>) internalEntry, (WeakKeyWeakValueEntry<K, V>) obj);
            }

            static <K, V> Helper<K, V> instance() {
                return (Helper<K, V>) INSTANCE;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public WeakKeyWeakValueEntry<K, V> copy(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry, @NullableDecl WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry2) {
                if (weakKeyWeakValueEntry.getKey() == null || Segment.isCollected(weakKeyWeakValueEntry)) {
                    return null;
                }
                return weakKeyWeakValueEntry.copy(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForKeys, ((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForValues, weakKeyWeakValueEntry2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.WEAK;
            }

            public WeakKeyWeakValueEntry<K, V> newEntry(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, K k6, int i6, @NullableDecl WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry) {
                return new WeakKeyWeakValueEntry<>(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForKeys, k6, i6, weakKeyWeakValueEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public WeakKeyWeakValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i6, int i7) {
                return new WeakKeyWeakValueSegment<>(mapMakerInternalMap, i6, i7);
            }

            public void setValue(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry, V v5) {
                weakKeyWeakValueEntry.setValue(v5, ((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForValues);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.WEAK;
            }

            Helper() {
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public void clearValue() {
            this.valueReference.clear();
        }

        WeakKeyWeakValueEntry<K, V> copy(ReferenceQueue<K> referenceQueue, ReferenceQueue<V> referenceQueue2, WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry) {
            WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry2 = new WeakKeyWeakValueEntry<>(referenceQueue, getKey(), this.hash, weakKeyWeakValueEntry);
            weakKeyWeakValueEntry2.valueReference = this.valueReference.copyFor(referenceQueue2, weakKeyWeakValueEntry2);
            return weakKeyWeakValueEntry2;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public V getValue() {
            return this.valueReference.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> getValueReference() {
            return this.valueReference;
        }

        void setValue(V v5, ReferenceQueue<V> referenceQueue) {
            WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> weakValueReference = this.valueReference;
            this.valueReference = new WeakValueReferenceImpl(referenceQueue, v5, this);
            weakValueReference.clear();
        }

        WeakKeyWeakValueEntry(ReferenceQueue<K> referenceQueue, K k6, int i6, @NullableDecl WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry) {
            super(referenceQueue, k6, i6, weakKeyWeakValueEntry);
            this.valueReference = MapMakerInternalMap.unsetWeakValueReference();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;
        private final ReferenceQueue<V> queueForValues;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyWeakValueEntry<K, V> castForTesting(InternalEntry<K, V, ?> internalEntry) {
            return (WeakKeyWeakValueEntry) internalEntry;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> newWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry, V v5) {
            return new WeakValueReferenceImpl(this.queueForValues, v5, castForTesting((InternalEntry) internalEntry));
        }

        WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i6, int i7) {
            super(mapMakerInternalMap, i6, i7);
            this.queueForKeys = new ReferenceQueue<>();
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> getWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry) {
            return castForTesting((InternalEntry) internalEntry).getValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> weakValueReference) {
            WeakKeyWeakValueEntry<K, V> castForTesting = castForTesting((InternalEntry) internalEntry);
            WeakValueReference weakValueReference2 = ((WeakKeyWeakValueEntry) castForTesting).valueReference;
            ((WeakKeyWeakValueEntry) castForTesting).valueReference = weakValueReference;
            weakValueReference2.clear();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface WeakValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {
        void clearValue();

        WeakValueReference<K, V, E> getValueReference();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface WeakValueReference<K, V, E extends InternalEntry<K, V, E>> {
        void clear();

        WeakValueReference<K, V, E> copyFor(ReferenceQueue<V> referenceQueue, E e6);

        @NullableDecl
        V get();

        E getEntry();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WeakValueReferenceImpl<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<V> implements WeakValueReference<K, V, E> {

        @Weak
        final E entry;

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public WeakValueReference<K, V, E> copyFor(ReferenceQueue<V> referenceQueue, E e6) {
            return new WeakValueReferenceImpl(referenceQueue, get(), e6);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public E getEntry() {
            return this.entry;
        }

        WeakValueReferenceImpl(ReferenceQueue<V> referenceQueue, V v5, E e6) {
            super(v5, referenceQueue);
            this.entry = e6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class WriteThroughEntry extends AbstractMapEntry<K, V> {
        final K key;
        V value;

        WriteThroughEntry(K k6, V v5) {
            this.key = k6;
            this.value = v5;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (this.key.equals(entry.getKey()) && this.value.equals(entry.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public int hashCode() {
            return this.key.hashCode() ^ this.value.hashCode();
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V setValue(V v5) {
            V v6 = (V) MapMakerInternalMap.this.put(this.key, v5);
            this.value = v5;
            return v6;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V remove(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean replace(K k6, @NullableDecl V v5, V v6) {
        Preconditions.checkNotNull(k6);
        Preconditions.checkNotNull(v6);
        if (v5 == null) {
            return false;
        }
        int hash = hash(k6);
        return segmentFor(hash).replace(k6, hash, v5, v6);
    }

    static int rehash(int i6) {
        int i7 = i6 + ((i6 << 15) ^ (-12931));
        int i8 = i7 ^ (i7 >>> 10);
        int i9 = i8 + (i8 << 3);
        int i10 = i9 ^ (i9 >>> 6);
        int i11 = i10 + (i10 << 2) + (i10 << 14);
        return i11 ^ (i11 >>> 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ArrayList<E> toArrayList(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.addAll(arrayList, collection.iterator());
        return arrayList;
    }

    static <K, V, E extends InternalEntry<K, V, E>> WeakValueReference<K, V, E> unsetWeakValueReference() {
        return (WeakValueReference<K, V, E>) UNSET_WEAK_VALUE_REFERENCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V, E, S> segment : this.segments) {
            segment.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).containsKey(obj, hash);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        Segment<K, V, E, S>[] segmentArr = this.segments;
        long j6 = -1;
        int i6 = 0;
        while (i6 < 3) {
            long j7 = 0;
            for (StrongKeyDummyValueSegment strongKeyDummyValueSegment : segmentArr) {
                int i7 = strongKeyDummyValueSegment.count;
                AtomicReferenceArray<E> atomicReferenceArray = strongKeyDummyValueSegment.table;
                for (int i8 = 0; i8 < atomicReferenceArray.length(); i8++) {
                    for (E e6 = atomicReferenceArray.get(i8); e6 != null; e6 = e6.getNext()) {
                        Object liveValue = strongKeyDummyValueSegment.getLiveValue(e6);
                        if (liveValue != null && valueEquivalence().equivalent(obj, liveValue)) {
                            return true;
                        }
                    }
                }
                j7 += strongKeyDummyValueSegment.modCount;
            }
            if (j7 == j6) {
                return false;
            }
            i6++;
            j6 = j7;
        }
        return false;
    }

    Segment<K, V, E, S> createSegment(int i6, int i7) {
        return this.entryHelper.newSegment(this, i6, i7);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.entrySet = entrySet;
        return entrySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).get(obj, hash);
    }

    E getEntry(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).getEntry(obj, hash);
    }

    int hash(Object obj) {
        return rehash(this.keyEquivalence.hash(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V, E, S>[] segmentArr = this.segments;
        long j6 = 0;
        for (int i6 = 0; i6 < segmentArr.length; i6++) {
            if (segmentArr[i6].count != 0) {
                return false;
            }
            j6 += segmentArr[i6].modCount;
        }
        if (j6 == 0) {
            return true;
        }
        for (int i7 = 0; i7 < segmentArr.length; i7++) {
            if (segmentArr[i7].count != 0) {
                return false;
            }
            j6 -= segmentArr[i7].modCount;
        }
        return j6 == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.keySet = keySet;
        return keySet;
    }

    @VisibleForTesting
    Strength keyStrength() {
        return this.entryHelper.keyStrength();
    }

    final Segment<K, V, E, S>[] newSegmentArray(int i6) {
        return new Segment[i6];
    }

    Segment<K, V, E, S> segmentFor(int i6) {
        return this.segments[(i6 >>> this.segmentShift) & this.segmentMask];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j6 = 0;
        for (int i6 = 0; i6 < this.segments.length; i6++) {
            j6 += r0[i6].count;
        }
        return Ints.saturatedCast(j6);
    }

    @VisibleForTesting
    Equivalence<Object> valueEquivalence() {
        return this.entryHelper.valueStrength().defaultEquivalence();
    }

    @VisibleForTesting
    Strength valueStrength() {
        return this.entryHelper.valueStrength();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Values values = new Values();
        this.values = values;
        return values;
    }

    Object writeReplace() {
        return new SerializationProxy(this.entryHelper.keyStrength(), this.entryHelper.valueStrength(), this.keyEquivalence, this.entryHelper.valueStrength().defaultEquivalence(), this.concurrencyLevel, this);
    }

    private MapMakerInternalMap(MapMaker mapMaker, InternalEntryHelper<K, V, E, S> internalEntryHelper) {
        this.concurrencyLevel = Math.min(mapMaker.getConcurrencyLevel(), 65536);
        this.keyEquivalence = mapMaker.getKeyEquivalence();
        this.entryHelper = internalEntryHelper;
        int min = Math.min(mapMaker.getInitialCapacity(), 1073741824);
        int i6 = 0;
        int i7 = 1;
        int i8 = 1;
        int i9 = 0;
        while (i8 < this.concurrencyLevel) {
            i9++;
            i8 <<= 1;
        }
        this.segmentShift = 32 - i9;
        this.segmentMask = i8 - 1;
        this.segments = newSegmentArray(i8);
        int i10 = min / i8;
        while (i7 < (i8 * i10 < min ? i10 + 1 : i10)) {
            i7 <<= 1;
        }
        while (true) {
            Segment<K, V, E, S>[] segmentArr = this.segments;
            if (i6 < segmentArr.length) {
                segmentArr[i6] = createSegment(i7, -1);
                i6++;
            } else {
                return;
            }
        }
    }

    static <K, V> MapMakerInternalMap<K, V, ? extends InternalEntry<K, V, ?>, ?> create(MapMaker mapMaker) {
        Strength keyStrength = mapMaker.getKeyStrength();
        Strength strength = Strength.STRONG;
        if (keyStrength == strength && mapMaker.getValueStrength() == strength) {
            return new MapMakerInternalMap<>(mapMaker, StrongKeyStrongValueEntry.Helper.instance());
        }
        if (mapMaker.getKeyStrength() == strength && mapMaker.getValueStrength() == Strength.WEAK) {
            return new MapMakerInternalMap<>(mapMaker, StrongKeyWeakValueEntry.Helper.instance());
        }
        Strength keyStrength2 = mapMaker.getKeyStrength();
        Strength strength2 = Strength.WEAK;
        if (keyStrength2 == strength2 && mapMaker.getValueStrength() == strength) {
            return new MapMakerInternalMap<>(mapMaker, WeakKeyStrongValueEntry.Helper.instance());
        }
        if (mapMaker.getKeyStrength() == strength2 && mapMaker.getValueStrength() == strength2) {
            return new MapMakerInternalMap<>(mapMaker, WeakKeyWeakValueEntry.Helper.instance());
        }
        throw new AssertionError();
    }

    static <K> MapMakerInternalMap<K, MapMaker.Dummy, ? extends InternalEntry<K, MapMaker.Dummy, ?>, ?> createWithDummyValues(MapMaker mapMaker) {
        Strength keyStrength = mapMaker.getKeyStrength();
        Strength strength = Strength.STRONG;
        if (keyStrength == strength && mapMaker.getValueStrength() == strength) {
            return new MapMakerInternalMap<>(mapMaker, StrongKeyDummyValueEntry.Helper.instance());
        }
        Strength keyStrength2 = mapMaker.getKeyStrength();
        Strength strength2 = Strength.WEAK;
        if (keyStrength2 == strength2 && mapMaker.getValueStrength() == strength) {
            return new MapMakerInternalMap<>(mapMaker, WeakKeyDummyValueEntry.Helper.instance());
        }
        if (mapMaker.getValueStrength() == strength2) {
            throw new IllegalArgumentException("Map cannot have both weak and dummy values");
        }
        throw new AssertionError();
    }

    @VisibleForTesting
    E copyEntry(E e6, E e7) {
        return segmentFor(e6.getHash()).copyEntry(e6, e7);
    }

    V getLiveValue(E e6) {
        V v5;
        if (e6.getKey() == null || (v5 = (V) e6.getValue()) == null) {
            return null;
        }
        return v5;
    }

    @VisibleForTesting
    boolean isLiveForTesting(InternalEntry<K, V, ?> internalEntry) {
        if (segmentFor(internalEntry.getHash()).getLiveValueForTesting(internalEntry) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V put(K k6, V v5) {
        Preconditions.checkNotNull(k6);
        Preconditions.checkNotNull(v5);
        int hash = hash(k6);
        return segmentFor(hash).put(k6, hash, v5, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V putIfAbsent(K k6, V v5) {
        Preconditions.checkNotNull(k6);
        Preconditions.checkNotNull(v5);
        int hash = hash(k6);
        return segmentFor(hash).put(k6, hash, v5, true);
    }

    void reclaimKey(E e6) {
        int hash = e6.getHash();
        segmentFor(hash).reclaimKey(e6, hash);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void reclaimValue(WeakValueReference<K, V, E> weakValueReference) {
        E entry = weakValueReference.getEntry();
        int hash = entry.getHash();
        segmentFor(hash).reclaimValue(entry.getKey(), hash, weakValueReference);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V replace(K k6, V v5) {
        Preconditions.checkNotNull(k6);
        Preconditions.checkNotNull(v5);
        int hash = hash(k6);
        return segmentFor(hash).replace(k6, hash, v5);
    }
}
