package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    final int concurrencyLevel;

    @NullableDecl
    final CacheLoader<? super K, V> defaultLoader;
    final EntryFactory entryFactory;

    @MonotonicNonNullDecl
    Set<Map.Entry<K, V>> entrySet;
    final long expireAfterAccessNanos;
    final long expireAfterWriteNanos;
    final AbstractCache.StatsCounter globalStatsCounter;
    final Equivalence<Object> keyEquivalence;

    @MonotonicNonNullDecl
    Set<K> keySet;
    final Strength keyStrength;
    final long maxWeight;
    final long refreshNanos;
    final RemovalListener<K, V> removalListener;
    final Queue<RemovalNotification<K, V>> removalNotificationQueue;
    final int segmentMask;
    final int segmentShift;
    final Segment<K, V>[] segments;
    final Ticker ticker;
    final Equivalence<Object> valueEquivalence;
    final Strength valueStrength;

    @MonotonicNonNullDecl
    Collection<V> values;
    final Weigher<K, V> weigher;
    static final Logger logger = Logger.getLogger(LocalCache.class.getName());
    static final ValueReference<Object, Object> UNSET = new ValueReference<Object, Object>() { // from class: com.google.common.cache.LocalCache.1
        @Override // com.google.common.cache.LocalCache.ValueReference
        public Object get() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<Object, Object> getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 0;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public Object waitForValue() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(Object obj) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<Object, Object> copyFor(ReferenceQueue<Object> referenceQueue, @NullableDecl Object obj, ReferenceEntry<Object, Object> referenceEntry) {
            return this;
        }
    };
    static final Queue<?> DISCARDING_QUEUE = new AbstractQueue<Object>() { // from class: com.google.common.cache.LocalCache.2
        @Override // java.util.Queue
        public boolean offer(Object obj) {
            return true;
        }

        @Override // java.util.Queue
        public Object peek() {
            return null;
        }

        @Override // java.util.Queue
        public Object poll() {
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Object> iterator() {
            return ImmutableSet.of().iterator();
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    abstract class AbstractCacheSet<T> extends AbstractSet<T> {

        @Weak
        final ConcurrentMap<?, ?> map;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return LocalCache.toArrayList(this).toArray();
        }

        AbstractCacheSet(ConcurrentMap<?, ?> concurrentMap) {
            this.map = concurrentMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.map.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.toArrayList(this).toArray(eArr);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class AbstractReferenceEntry<K, V> implements ReferenceEntry<K, V> {
        @Override // com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j6) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<K, V> valueReference) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j6) {
            throw new UnsupportedOperationException();
        }

        AbstractReferenceEntry() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class AccessQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> head = new AbstractReferenceEntry<K, V>() { // from class: com.google.common.cache.LocalCache.AccessQueue.1
            ReferenceEntry<K, V> nextAccess = this;
            ReferenceEntry<K, V> previousAccess = this;

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public ReferenceEntry<K, V> getNextInAccessQueue() {
                return this.nextAccess;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public ReferenceEntry<K, V> getPreviousInAccessQueue() {
                return this.previousAccess;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
                this.nextAccess = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
                this.previousAccess = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public long getAccessTime() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setAccessTime(long j6) {
            }
        };

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ReferenceEntry<K, V> nextInAccessQueue = this.head.getNextInAccessQueue();
            while (true) {
                ReferenceEntry<K, V> referenceEntry = this.head;
                if (nextInAccessQueue == referenceEntry) {
                    referenceEntry.setNextInAccessQueue(referenceEntry);
                    ReferenceEntry<K, V> referenceEntry2 = this.head;
                    referenceEntry2.setPreviousInAccessQueue(referenceEntry2);
                    return;
                } else {
                    ReferenceEntry<K, V> nextInAccessQueue2 = nextInAccessQueue.getNextInAccessQueue();
                    LocalCache.nullifyAccessOrder(nextInAccessQueue);
                    nextInAccessQueue = nextInAccessQueue2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((ReferenceEntry) obj).getNextInAccessQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.head.getNextInAccessQueue() == this.head;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<ReferenceEntry<K, V>> iterator() {
            return new AbstractSequentialIterator<ReferenceEntry<K, V>>(peek()) { // from class: com.google.common.cache.LocalCache.AccessQueue.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractSequentialIterator
                public ReferenceEntry<K, V> computeNext(ReferenceEntry<K, V> referenceEntry) {
                    ReferenceEntry<K, V> nextInAccessQueue = referenceEntry.getNextInAccessQueue();
                    if (nextInAccessQueue == AccessQueue.this.head) {
                        return null;
                    }
                    return nextInAccessQueue;
                }
            };
        }

        @Override // java.util.Queue
        public boolean offer(ReferenceEntry<K, V> referenceEntry) {
            LocalCache.connectAccessOrder(referenceEntry.getPreviousInAccessQueue(), referenceEntry.getNextInAccessQueue());
            LocalCache.connectAccessOrder(this.head.getPreviousInAccessQueue(), referenceEntry);
            LocalCache.connectAccessOrder(referenceEntry, this.head);
            return true;
        }

        @Override // java.util.Queue
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> nextInAccessQueue = this.head.getNextInAccessQueue();
            if (nextInAccessQueue == this.head) {
                return null;
            }
            return nextInAccessQueue;
        }

        @Override // java.util.Queue
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> nextInAccessQueue = this.head.getNextInAccessQueue();
            if (nextInAccessQueue == this.head) {
                return null;
            }
            remove(nextInAccessQueue);
            return nextInAccessQueue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry<K, V> previousInAccessQueue = referenceEntry.getPreviousInAccessQueue();
            ReferenceEntry<K, V> nextInAccessQueue = referenceEntry.getNextInAccessQueue();
            LocalCache.connectAccessOrder(previousInAccessQueue, nextInAccessQueue);
            LocalCache.nullifyAccessOrder(referenceEntry);
            return nextInAccessQueue != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i6 = 0;
            for (ReferenceEntry<K, V> nextInAccessQueue = this.head.getNextInAccessQueue(); nextInAccessQueue != this.head; nextInAccessQueue = nextInAccessQueue.getNextInAccessQueue()) {
                i6++;
            }
            return i6;
        }

        AccessQueue() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum EntryFactory {
        STRONG { // from class: com.google.common.cache.LocalCache.EntryFactory.1
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k6, int i6, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new StrongEntry(k6, i6, referenceEntry);
            }
        },
        STRONG_ACCESS { // from class: com.google.common.cache.LocalCache.EntryFactory.2
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k6, int i6, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new StrongAccessEntry(k6, i6, referenceEntry);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        STRONG_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.3
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k6, int i6, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new StrongWriteEntry(k6, i6, referenceEntry);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        STRONG_ACCESS_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.4
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k6, int i6, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new StrongAccessWriteEntry(k6, i6, referenceEntry);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.EntryFactory.5
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k6, int i6, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new WeakEntry(segment.keyReferenceQueue, k6, i6, referenceEntry);
            }
        },
        WEAK_ACCESS { // from class: com.google.common.cache.LocalCache.EntryFactory.6
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k6, int i6, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new WeakAccessEntry(segment.keyReferenceQueue, k6, i6, referenceEntry);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        WEAK_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.7
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k6, int i6, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new WeakWriteEntry(segment.keyReferenceQueue, k6, i6, referenceEntry);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        WEAK_ACCESS_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.8
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k6, int i6, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new WeakAccessWriteEntry(segment.keyReferenceQueue, k6, i6, referenceEntry);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        };

        static final int ACCESS_MASK = 1;
        static final int WEAK_MASK = 4;
        static final int WRITE_MASK = 2;
        static final EntryFactory[] factories = {STRONG, STRONG_ACCESS, STRONG_WRITE, STRONG_ACCESS_WRITE, WEAK, WEAK_ACCESS, WEAK_WRITE, WEAK_ACCESS_WRITE};

        abstract <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k6, int i6, @NullableDecl ReferenceEntry<K, V> referenceEntry);

        static EntryFactory getFactory(Strength strength, boolean z5, boolean z6) {
            return factories[(strength == Strength.WEAK ? 4 : 0) | (z5 ? 1 : 0) | (z6 ? 2 : 0)];
        }

        <K, V> void copyAccessEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.setAccessTime(referenceEntry.getAccessTime());
            LocalCache.connectAccessOrder(referenceEntry.getPreviousInAccessQueue(), referenceEntry2);
            LocalCache.connectAccessOrder(referenceEntry2, referenceEntry.getNextInAccessQueue());
            LocalCache.nullifyAccessOrder(referenceEntry);
        }

        <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            return newEntry(segment, referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry2);
        }

        <K, V> void copyWriteEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.setWriteTime(referenceEntry.getWriteTime());
            LocalCache.connectWriteOrder(referenceEntry.getPreviousInWriteQueue(), referenceEntry2);
            LocalCache.connectWriteOrder(referenceEntry2, referenceEntry.getNextInWriteQueue());
            LocalCache.nullifyWriteOrder(referenceEntry);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class EntryIterator extends LocalCache<K, V>.HashIterator<Map.Entry<K, V>> {
        EntryIterator() {
            super();
        }

        @Override // com.google.common.cache.LocalCache.HashIterator, java.util.Iterator
        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class EntrySet extends LocalCache<K, V>.AbstractCacheSet<Map.Entry<K, V>> {
        EntrySet(ConcurrentMap<?, ?> concurrentMap) {
            super(concurrentMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = LocalCache.this.get(key)) != null && LocalCache.this.valueEquivalence.equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && LocalCache.this.remove(key, entry.getValue());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    abstract class HashIterator<T> implements Iterator<T> {

        @MonotonicNonNullDecl
        Segment<K, V> currentSegment;

        @MonotonicNonNullDecl
        AtomicReferenceArray<ReferenceEntry<K, V>> currentTable;

        @NullableDecl
        LocalCache<K, V>.WriteThroughEntry lastReturned;

        @NullableDecl
        ReferenceEntry<K, V> nextEntry;

        @NullableDecl
        LocalCache<K, V>.WriteThroughEntry nextExternal;
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
                Segment<K, V>[] segmentArr = LocalCache.this.segments;
                this.nextSegmentIndex = i6 - 1;
                Segment<K, V> segment = segmentArr[i6];
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
            this.nextSegmentIndex = LocalCache.this.segments.length - 1;
            advance();
        }

        boolean advanceTo(ReferenceEntry<K, V> referenceEntry) {
            try {
                long read = LocalCache.this.ticker.read();
                K key = referenceEntry.getKey();
                Object liveValue = LocalCache.this.getLiveValue(referenceEntry, read);
                if (liveValue == null) {
                    this.currentSegment.postReadCleanup();
                    return false;
                }
                this.nextExternal = new WriteThroughEntry(key, liveValue);
                this.currentSegment.postReadCleanup();
                return true;
            } catch (Throwable th) {
                this.currentSegment.postReadCleanup();
                throw th;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextExternal != null;
        }

        LocalCache<K, V>.WriteThroughEntry nextEntry() {
            LocalCache<K, V>.WriteThroughEntry writeThroughEntry = this.nextExternal;
            if (writeThroughEntry == null) {
                throw new NoSuchElementException();
            }
            this.lastReturned = writeThroughEntry;
            advance();
            return this.lastReturned;
        }

        boolean nextInChain() {
            ReferenceEntry<K, V> referenceEntry = this.nextEntry;
            if (referenceEntry == null) {
                return false;
            }
            while (true) {
                this.nextEntry = referenceEntry.getNext();
                ReferenceEntry<K, V> referenceEntry2 = this.nextEntry;
                if (referenceEntry2 == null) {
                    return false;
                }
                if (advanceTo(referenceEntry2)) {
                    return true;
                }
                referenceEntry = this.nextEntry;
            }
        }

        boolean nextInTable() {
            while (true) {
                int i6 = this.nextTableIndex;
                if (i6 < 0) {
                    return false;
                }
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.currentTable;
                this.nextTableIndex = i6 - 1;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i6);
                this.nextEntry = referenceEntry;
                if (referenceEntry != null && (advanceTo(referenceEntry) || nextInChain())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.checkState(this.lastReturned != null);
            LocalCache.this.remove(this.lastReturned.getKey());
            this.lastReturned = null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class KeyIterator extends LocalCache<K, V>.HashIterator<K> {
        KeyIterator() {
            super();
        }

        @Override // com.google.common.cache.LocalCache.HashIterator, java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class KeySet extends LocalCache<K, V>.AbstractCacheSet<K> {
        KeySet(ConcurrentMap<?, ?> concurrentMap) {
            super(concurrentMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.map.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return this.map.remove(obj) != null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class LoadingSerializationProxy<K, V> extends ManualSerializationProxy<K, V> implements LoadingCache<K, V>, Serializable {
        private static final long serialVersionUID = 1;

        @MonotonicNonNullDecl
        transient LoadingCache<K, V> autoDelegate;

        private Object readResolve() {
            return this.autoDelegate;
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public final V apply(K k6) {
            return this.autoDelegate.apply(k6);
        }

        @Override // com.google.common.cache.LoadingCache
        public V get(K k6) throws ExecutionException {
            return this.autoDelegate.get(k6);
        }

        @Override // com.google.common.cache.LoadingCache
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.autoDelegate.getAll(iterable);
        }

        @Override // com.google.common.cache.LoadingCache
        public V getUnchecked(K k6) {
            return this.autoDelegate.getUnchecked(k6);
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(K k6) {
            this.autoDelegate.refresh(k6);
        }

        LoadingSerializationProxy(LocalCache<K, V> localCache) {
            super(localCache);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.autoDelegate = (LoadingCache<K, V>) recreateCacheBuilder().build(this.loader);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class LoadingValueReference<K, V> implements ValueReference<K, V> {
        final SettableFuture<V> futureValue;
        volatile ValueReference<K, V> oldValue;
        final Stopwatch stopwatch;

        public LoadingValueReference() {
            this(LocalCache.unset());
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return true;
        }

        public LoadingValueReference(ValueReference<K, V> valueReference) {
            this.futureValue = SettableFuture.create();
            this.stopwatch = Stopwatch.createUnstarted();
            this.oldValue = valueReference;
        }

        public long elapsedNanos() {
            return this.stopwatch.elapsed(TimeUnit.NANOSECONDS);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V get() {
            return this.oldValue.get();
        }

        public ValueReference<K, V> getOldValue() {
            return this.oldValue;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.oldValue.getWeight();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return this.oldValue.isActive();
        }

        public ListenableFuture<V> loadFuture(K k6, CacheLoader<? super K, V> cacheLoader) {
            try {
                this.stopwatch.start();
                V v5 = this.oldValue.get();
                if (v5 == null) {
                    V load = cacheLoader.load(k6);
                    return set(load) ? this.futureValue : Futures.immediateFuture(load);
                }
                ListenableFuture<V> reload = cacheLoader.reload(k6, v5);
                return reload == null ? Futures.immediateFuture(null) : Futures.transform(reload, new Function<V, V>() { // from class: com.google.common.cache.LocalCache.LoadingValueReference.1
                    @Override // com.google.common.base.Function
                    public V apply(V v6) {
                        LoadingValueReference.this.set(v6);
                        return v6;
                    }
                }, MoreExecutors.directExecutor());
            } catch (Throwable th) {
                ListenableFuture<V> fullyFailedFuture = setException(th) ? this.futureValue : fullyFailedFuture(th);
                if (th instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return fullyFailedFuture;
            }
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(@NullableDecl V v5) {
            if (v5 != null) {
                set(v5);
            } else {
                this.oldValue = LocalCache.unset();
            }
        }

        public boolean set(@NullableDecl V v5) {
            return this.futureValue.set(v5);
        }

        public boolean setException(Throwable th) {
            return this.futureValue.setException(th);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V waitForValue() throws ExecutionException {
            return (V) Uninterruptibles.getUninterruptibly(this.futureValue);
        }

        private ListenableFuture<V> fullyFailedFuture(Throwable th) {
            return Futures.immediateFailedFuture(th);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, @NullableDecl V v5, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements LoadingCache<K, V> {
        private static final long serialVersionUID = 1;

        LocalLoadingCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
            super();
        }

        @Override // com.google.common.cache.LoadingCache
        public V get(K k6) throws ExecutionException {
            return this.localCache.getOrLoad(k6);
        }

        @Override // com.google.common.cache.LoadingCache
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.localCache.getAll(iterable);
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(K k6) {
            this.localCache.refresh(k6);
        }

        @Override // com.google.common.cache.LocalCache.LocalManualCache
        Object writeReplace() {
            return new LoadingSerializationProxy(this.localCache);
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public final V apply(K k6) {
            return getUnchecked(k6);
        }

        @Override // com.google.common.cache.LoadingCache
        public V getUnchecked(K k6) {
            try {
                return get(k6);
            } catch (ExecutionException e6) {
                throw new UncheckedExecutionException(e6.getCause());
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class LocalManualCache<K, V> implements Cache<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        final LocalCache<K, V> localCache;

        @Override // com.google.common.cache.Cache
        public void invalidateAll(Iterable<?> iterable) {
            this.localCache.invalidateAll(iterable);
        }

        LocalManualCache(CacheBuilder<? super K, ? super V> cacheBuilder) {
            this(new LocalCache(cacheBuilder, null));
        }

        @Override // com.google.common.cache.Cache
        public ConcurrentMap<K, V> asMap() {
            return this.localCache;
        }

        @Override // com.google.common.cache.Cache
        public void cleanUp() {
            this.localCache.cleanUp();
        }

        @Override // com.google.common.cache.Cache
        public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
            return this.localCache.getAllPresent(iterable);
        }

        @Override // com.google.common.cache.Cache
        @NullableDecl
        public V getIfPresent(Object obj) {
            return this.localCache.getIfPresent(obj);
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll() {
            this.localCache.clear();
        }

        @Override // com.google.common.cache.Cache
        public void put(K k6, V v5) {
            this.localCache.put(k6, v5);
        }

        @Override // com.google.common.cache.Cache
        public void putAll(Map<? extends K, ? extends V> map) {
            this.localCache.putAll(map);
        }

        @Override // com.google.common.cache.Cache
        public long size() {
            return this.localCache.longSize();
        }

        @Override // com.google.common.cache.Cache
        public CacheStats stats() {
            AbstractCache.SimpleStatsCounter simpleStatsCounter = new AbstractCache.SimpleStatsCounter();
            simpleStatsCounter.incrementBy(this.localCache.globalStatsCounter);
            for (Segment<K, V> segment : this.localCache.segments) {
                simpleStatsCounter.incrementBy(segment.statsCounter);
            }
            return simpleStatsCounter.snapshot();
        }

        Object writeReplace() {
            return new ManualSerializationProxy(this.localCache);
        }

        private LocalManualCache(LocalCache<K, V> localCache) {
            this.localCache = localCache;
        }

        @Override // com.google.common.cache.Cache
        public V get(K k6, final Callable<? extends V> callable) throws ExecutionException {
            Preconditions.checkNotNull(callable);
            return this.localCache.get(k6, new CacheLoader<Object, V>() { // from class: com.google.common.cache.LocalCache.LocalManualCache.1
                @Override // com.google.common.cache.CacheLoader
                public V load(Object obj) throws Exception {
                    return (V) callable.call();
                }
            });
        }

        @Override // com.google.common.cache.Cache
        public void invalidate(Object obj) {
            Preconditions.checkNotNull(obj);
            this.localCache.remove(obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class ManualSerializationProxy<K, V> extends ForwardingCache<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        final int concurrencyLevel;

        @MonotonicNonNullDecl
        transient Cache<K, V> delegate;
        final long expireAfterAccessNanos;
        final long expireAfterWriteNanos;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final CacheLoader<? super K, V> loader;
        final long maxWeight;
        final RemovalListener<? super K, ? super V> removalListener;

        @NullableDecl
        final Ticker ticker;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;
        final Weigher<K, V> weigher;

        ManualSerializationProxy(LocalCache<K, V> localCache) {
            this(localCache.keyStrength, localCache.valueStrength, localCache.keyEquivalence, localCache.valueEquivalence, localCache.expireAfterWriteNanos, localCache.expireAfterAccessNanos, localCache.maxWeight, localCache.weigher, localCache.concurrencyLevel, localCache.removalListener, localCache.ticker, localCache.defaultLoader);
        }

        private ManualSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j6, long j7, long j8, Weigher<K, V> weigher, int i6, RemovalListener<? super K, ? super V> removalListener, Ticker ticker, CacheLoader<? super K, V> cacheLoader) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.expireAfterWriteNanos = j6;
            this.expireAfterAccessNanos = j7;
            this.maxWeight = j8;
            this.weigher = weigher;
            this.concurrencyLevel = i6;
            this.removalListener = removalListener;
            this.ticker = (ticker == Ticker.systemTicker() || ticker == CacheBuilder.NULL_TICKER) ? null : ticker;
            this.loader = cacheLoader;
        }

        private Object readResolve() {
            return this.delegate;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        public Cache<K, V> delegate() {
            return this.delegate;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = (Cache<K, V>) recreateCacheBuilder().build();
        }

        CacheBuilder<K, V> recreateCacheBuilder() {
            CacheBuilder<K, V> cacheBuilder = (CacheBuilder<K, V>) CacheBuilder.newBuilder().setKeyStrength(this.keyStrength).setValueStrength(this.valueStrength).keyEquivalence(this.keyEquivalence).valueEquivalence(this.valueEquivalence).concurrencyLevel(this.concurrencyLevel).removalListener(this.removalListener);
            cacheBuilder.strictParsing = false;
            long j6 = this.expireAfterWriteNanos;
            if (j6 > 0) {
                cacheBuilder.expireAfterWrite(j6, TimeUnit.NANOSECONDS);
            }
            long j7 = this.expireAfterAccessNanos;
            if (j7 > 0) {
                cacheBuilder.expireAfterAccess(j7, TimeUnit.NANOSECONDS);
            }
            Weigher weigher = this.weigher;
            if (weigher != CacheBuilder.OneWeigher.INSTANCE) {
                cacheBuilder.weigher(weigher);
                long j8 = this.maxWeight;
                if (j8 != -1) {
                    cacheBuilder.maximumWeight(j8);
                }
            } else {
                long j9 = this.maxWeight;
                if (j9 != -1) {
                    cacheBuilder.maximumSize(j9);
                }
            }
            Ticker ticker = this.ticker;
            if (ticker != null) {
                cacheBuilder.ticker(ticker);
            }
            return cacheBuilder;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum NullEntry implements ReferenceEntry<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            return 0;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public Object getKey() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNext() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference<Object, Object> getValueReference() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return 0L;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return 0L;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNextInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNextInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getPreviousInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getPreviousInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j6) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<Object, Object> valueReference) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j6) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class Segment<K, V> extends ReentrantLock {

        @GuardedBy("this")
        final Queue<ReferenceEntry<K, V>> accessQueue;
        volatile int count;

        @NullableDecl
        final ReferenceQueue<K> keyReferenceQueue;

        @Weak
        final LocalCache<K, V> map;
        final long maxSegmentWeight;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        final Queue<ReferenceEntry<K, V>> recencyQueue;
        final AbstractCache.StatsCounter statsCounter;

        @MonotonicNonNullDecl
        volatile AtomicReferenceArray<ReferenceEntry<K, V>> table;
        int threshold;

        @GuardedBy("this")
        long totalWeight;

        @NullableDecl
        final ReferenceQueue<V> valueReferenceQueue;

        @GuardedBy("this")
        final Queue<ReferenceEntry<K, V>> writeQueue;

        @GuardedBy("this")
        void drainKeyReferenceQueue() {
            int i6 = 0;
            do {
                Reference<? extends K> poll = this.keyReferenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.reclaimKey((ReferenceEntry) poll);
                i6++;
            } while (i6 != 16);
        }

        @GuardedBy("this")
        void drainValueReferenceQueue() {
            int i6 = 0;
            do {
                Reference<? extends V> poll = this.valueReferenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.reclaimValue((ValueReference) poll);
                i6++;
            } while (i6 != 16);
        }

        V get(K k6, int i6, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            K k7;
            int i7;
            CacheLoader<? super K, V> cacheLoader2;
            ReferenceEntry<K, V> entry;
            Preconditions.checkNotNull(k6);
            Preconditions.checkNotNull(cacheLoader);
            try {
                try {
                } catch (ExecutionException e6) {
                    e = e6;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    postReadCleanup();
                    throw th2;
                }
                try {
                    if (this.count == 0 || (entry = getEntry(k6, i6)) == null) {
                        k7 = k6;
                        i7 = i6;
                        cacheLoader2 = cacheLoader;
                    } else {
                        long read = this.map.ticker.read();
                        V liveValue = getLiveValue(entry, read);
                        if (liveValue != null) {
                            recordRead(entry, read);
                            this.statsCounter.recordHits(1);
                            V scheduleRefresh = scheduleRefresh(entry, k6, i6, liveValue, read, cacheLoader);
                            postReadCleanup();
                            return scheduleRefresh;
                        }
                        k7 = k6;
                        i7 = i6;
                        cacheLoader2 = cacheLoader;
                        ValueReference<K, V> valueReference = entry.getValueReference();
                        if (valueReference.isLoading()) {
                            V waitForLoadingValue = waitForLoadingValue(entry, k7, valueReference);
                            postReadCleanup();
                            return waitForLoadingValue;
                        }
                    }
                    V lockedGetOrLoad = lockedGetOrLoad(k7, i7, cacheLoader2);
                    postReadCleanup();
                    return lockedGetOrLoad;
                } catch (ExecutionException e7) {
                    e = e7;
                    ExecutionException executionException = e;
                    Throwable cause = executionException.getCause();
                    if (cause instanceof Error) {
                        throw new ExecutionError((Error) cause);
                    }
                    if (cause instanceof RuntimeException) {
                        throw new UncheckedExecutionException(cause);
                    }
                    throw executionException;
                }
            } catch (Throwable th3) {
                th = th3;
                Throwable th22 = th;
                postReadCleanup();
                throw th22;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
        
            r9 = r5.getValueReference();
            r8 = r9.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        
            if (r8 == null) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x004e, code lost:
        
            if (r9.isActive() == false) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0050, code lost:
        
            r12 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
        
            r10 = r12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0053, code lost:
        
            r11.modCount++;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
        
            r12 = removeValueFromChain(r4, r5, r6, r13, r8, r9, r10);
            r13 = r11.count - 1;
            r0.set(r1, r12);
            r11.count = r13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0068, code lost:
        
            unlock();
            postWriteCleanup();
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x006e, code lost:
        
            return r8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0042, code lost:
        
            r12 = com.google.common.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0046, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0047, code lost:
        
            r12 = r0;
         */
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        V remove(java.lang.Object r12, int r13) {
            /*
                r11 = this;
                r11.lock()
                com.google.common.cache.LocalCache<K, V> r0 = r11.map     // Catch: java.lang.Throwable -> L72
                com.google.common.base.Ticker r0 = r0.ticker     // Catch: java.lang.Throwable -> L72
                long r0 = r0.read()     // Catch: java.lang.Throwable -> L72
                r11.preWriteCleanup(r0)     // Catch: java.lang.Throwable -> L72
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r0 = r11.table     // Catch: java.lang.Throwable -> L72
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L72
                int r1 = r1 + (-1)
                r1 = r1 & r13
                java.lang.Object r2 = r0.get(r1)     // Catch: java.lang.Throwable -> L72
                r4 = r2
                com.google.common.cache.ReferenceEntry r4 = (com.google.common.cache.ReferenceEntry) r4     // Catch: java.lang.Throwable -> L72
                r5 = r4
            L1f:
                r2 = 0
                if (r5 == 0) goto L75
                java.lang.Object r6 = r5.getKey()     // Catch: java.lang.Throwable -> L72
                int r3 = r5.getHash()     // Catch: java.lang.Throwable -> L72
                if (r3 != r13) goto L7d
                if (r6 == 0) goto L7d
                com.google.common.cache.LocalCache<K, V> r3 = r11.map     // Catch: java.lang.Throwable -> L72
                com.google.common.base.Equivalence<java.lang.Object> r3 = r3.keyEquivalence     // Catch: java.lang.Throwable -> L72
                boolean r3 = r3.equivalent(r12, r6)     // Catch: java.lang.Throwable -> L72
                if (r3 == 0) goto L7d
                com.google.common.cache.LocalCache$ValueReference r9 = r5.getValueReference()     // Catch: java.lang.Throwable -> L72
                java.lang.Object r8 = r9.get()     // Catch: java.lang.Throwable -> L72
                if (r8 == 0) goto L4a
                com.google.common.cache.RemovalCause r12 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L46
            L44:
                r10 = r12
                goto L53
            L46:
                r0 = move-exception
                r12 = r0
                r3 = r11
                goto L85
            L4a:
                boolean r12 = r9.isActive()     // Catch: java.lang.Throwable -> L72
                if (r12 == 0) goto L75
                com.google.common.cache.RemovalCause r12 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L72
                goto L44
            L53:
                int r12 = r11.modCount     // Catch: java.lang.Throwable -> L72
                int r12 = r12 + 1
                r11.modCount = r12     // Catch: java.lang.Throwable -> L72
                r3 = r11
                r7 = r13
                com.google.common.cache.ReferenceEntry r12 = r3.removeValueFromChain(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L6f
                int r13 = r3.count     // Catch: java.lang.Throwable -> L6f
                int r13 = r13 + (-1)
                r0.set(r1, r12)     // Catch: java.lang.Throwable -> L6f
                r3.count = r13     // Catch: java.lang.Throwable -> L6f
                r11.unlock()
                r11.postWriteCleanup()
                return r8
            L6f:
                r0 = move-exception
            L70:
                r12 = r0
                goto L85
            L72:
                r0 = move-exception
                r3 = r11
                goto L70
            L75:
                r3 = r11
                r11.unlock()
                r11.postWriteCleanup()
                return r2
            L7d:
                r3 = r11
                r7 = r13
                com.google.common.cache.ReferenceEntry r5 = r5.getNext()     // Catch: java.lang.Throwable -> L6f
                r13 = r7
                goto L1f
            L85:
                r11.unlock()
                r11.postWriteCleanup()
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.remove(java.lang.Object, int):java.lang.Object");
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x006f, code lost:
        
            return false;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean replace(K r17, int r18, V r19, V r20) {
            /*
                r16 = this;
                r1 = r16
                r3 = r18
                r1.lock()
                com.google.common.cache.LocalCache<K, V> r0 = r1.map     // Catch: java.lang.Throwable -> L67
                com.google.common.base.Ticker r0 = r0.ticker     // Catch: java.lang.Throwable -> L67
                long r7 = r0.read()     // Catch: java.lang.Throwable -> L67
                r1.preWriteCleanup(r7)     // Catch: java.lang.Throwable -> L67
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r0 = r1.table     // Catch: java.lang.Throwable -> L67
                int r2 = r0.length()     // Catch: java.lang.Throwable -> L67
                r9 = 1
                int r2 = r2 - r9
                r10 = r3 & r2
                java.lang.Object r2 = r0.get(r10)     // Catch: java.lang.Throwable -> L67
                com.google.common.cache.ReferenceEntry r2 = (com.google.common.cache.ReferenceEntry) r2     // Catch: java.lang.Throwable -> L67
                r4 = r2
            L23:
                r11 = 0
                if (r4 == 0) goto L69
                r5 = r4
                java.lang.Object r4 = r5.getKey()     // Catch: java.lang.Throwable -> L67
                int r6 = r5.getHash()     // Catch: java.lang.Throwable -> L67
                if (r6 != r3) goto La9
                if (r4 == 0) goto La9
                com.google.common.cache.LocalCache<K, V> r6 = r1.map     // Catch: java.lang.Throwable -> L67
                com.google.common.base.Equivalence<java.lang.Object> r6 = r6.keyEquivalence     // Catch: java.lang.Throwable -> L67
                r12 = r17
                boolean r6 = r6.equivalent(r12, r4)     // Catch: java.lang.Throwable -> L67
                if (r6 == 0) goto La9
                r13 = r7
                com.google.common.cache.LocalCache$ValueReference r7 = r5.getValueReference()     // Catch: java.lang.Throwable -> L67
                java.lang.Object r6 = r7.get()     // Catch: java.lang.Throwable -> L67
                if (r6 != 0) goto L70
                boolean r8 = r7.isActive()     // Catch: java.lang.Throwable -> L67
                if (r8 == 0) goto L69
                int r8 = r1.modCount     // Catch: java.lang.Throwable -> L67
                int r8 = r8 + r9
                r1.modCount = r8     // Catch: java.lang.Throwable -> L67
                com.google.common.cache.RemovalCause r8 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L67
                r15 = r5
                r5 = r3
                r3 = r15
                com.google.common.cache.ReferenceEntry r2 = r1.removeValueFromChain(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L67
                int r3 = r1.count     // Catch: java.lang.Throwable -> L67
                int r3 = r3 - r9
                r0.set(r10, r2)     // Catch: java.lang.Throwable -> L67
                r1.count = r3     // Catch: java.lang.Throwable -> L67
                goto L69
            L67:
                r0 = move-exception
                goto Lba
            L69:
                r1.unlock()
                r1.postWriteCleanup()
                return r11
            L70:
                r0 = r5
                r4 = r6
                com.google.common.cache.LocalCache<K, V> r2 = r1.map     // Catch: java.lang.Throwable -> L67
                com.google.common.base.Equivalence<java.lang.Object> r2 = r2.valueEquivalence     // Catch: java.lang.Throwable -> L67
                r3 = r19
                boolean r2 = r2.equivalent(r3, r4)     // Catch: java.lang.Throwable -> L67
                if (r2 == 0) goto La4
                int r2 = r1.modCount     // Catch: java.lang.Throwable -> L67
                int r2 = r2 + r9
                r1.modCount = r2     // Catch: java.lang.Throwable -> L67
                int r5 = r7.getWeight()     // Catch: java.lang.Throwable -> L67
                com.google.common.cache.RemovalCause r6 = com.google.common.cache.RemovalCause.REPLACED     // Catch: java.lang.Throwable -> L67
                r3 = r18
                r2 = r12
                r1.enqueueNotification(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L67
                r1 = r16
                r3 = r17
                r4 = r20
                r2 = r0
                r5 = r13
                r1.setValue(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L67
                r1.evictEntries(r2)     // Catch: java.lang.Throwable -> L67
                r1.unlock()
                r1.postWriteCleanup()
                return r9
            La4:
                r2 = r0
                r1.recordLockedRead(r2, r13)     // Catch: java.lang.Throwable -> L67
                goto L69
            La9:
                r3 = r19
                r4 = r2
                r2 = r5
                r13 = r7
                com.google.common.cache.ReferenceEntry r2 = r2.getNext()     // Catch: java.lang.Throwable -> L67
                r3 = r4
                r4 = r2
                r2 = r3
                r3 = r18
                r7 = r13
                goto L23
            Lba:
                r1.unlock()
                r1.postWriteCleanup()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.replace(java.lang.Object, int, java.lang.Object, java.lang.Object):boolean");
        }

        void cleanUp() {
            runLockedCleanup(this.map.ticker.read());
            runUnlockedCleanup();
        }

        void clear() {
            RemovalCause removalCause;
            if (this.count == 0) {
                return;
            }
            lock();
            try {
                preWriteCleanup(this.map.ticker.read());
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                for (int i6 = 0; i6 < atomicReferenceArray.length(); i6++) {
                    for (ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i6); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                        if (referenceEntry.getValueReference().isActive()) {
                            K key = referenceEntry.getKey();
                            V v5 = referenceEntry.getValueReference().get();
                            try {
                                if (key != null && v5 != null) {
                                    removalCause = RemovalCause.EXPLICIT;
                                    enqueueNotification(key, referenceEntry.getHash(), v5, referenceEntry.getValueReference().getWeight(), removalCause);
                                }
                                enqueueNotification(key, referenceEntry.getHash(), v5, referenceEntry.getValueReference().getWeight(), removalCause);
                            } catch (Throwable th) {
                                th = th;
                                unlock();
                                postWriteCleanup();
                                throw th;
                            }
                            removalCause = RemovalCause.COLLECTED;
                        }
                    }
                }
                for (int i7 = 0; i7 < atomicReferenceArray.length(); i7++) {
                    atomicReferenceArray.set(i7, null);
                }
                clearReferenceQueues();
                this.writeQueue.clear();
                this.accessQueue.clear();
                this.readCount.set(0);
                this.modCount++;
                this.count = 0;
                unlock();
                postWriteCleanup();
            } catch (Throwable th2) {
                th = th2;
            }
        }

        void clearKeyReferenceQueue() {
            while (this.keyReferenceQueue.poll() != null) {
            }
        }

        void clearReferenceQueues() {
            if (this.map.usesKeyReferences()) {
                clearKeyReferenceQueue();
            }
            if (this.map.usesValueReferences()) {
                clearValueReferenceQueue();
            }
        }

        void clearValueReferenceQueue() {
            while (this.valueReferenceQueue.poll() != null) {
            }
        }

        boolean containsKey(Object obj, int i6) {
            try {
                if (this.count == 0) {
                    return false;
                }
                ReferenceEntry<K, V> liveEntry = getLiveEntry(obj, i6, this.map.ticker.read());
                if (liveEntry == null) {
                    return false;
                }
                return liveEntry.getValueReference().get() != null;
            } finally {
                postReadCleanup();
            }
        }

        @VisibleForTesting
        boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    long read = this.map.ticker.read();
                    AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i6 = 0; i6 < length; i6++) {
                        for (ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i6); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                            V liveValue = getLiveValue(referenceEntry, read);
                            if (liveValue != null && this.map.valueEquivalence.equivalent(obj, liveValue)) {
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

        @GuardedBy("this")
        void drainRecencyQueue() {
            while (true) {
                ReferenceEntry<K, V> poll = this.recencyQueue.poll();
                if (poll == null) {
                    return;
                }
                if (this.accessQueue.contains(poll)) {
                    this.accessQueue.add(poll);
                }
            }
        }

        @GuardedBy("this")
        void drainReferenceQueues() {
            if (this.map.usesKeyReferences()) {
                drainKeyReferenceQueue();
            }
            if (this.map.usesValueReferences()) {
                drainValueReferenceQueue();
            }
        }

        @GuardedBy("this")
        void enqueueNotification(@NullableDecl K k6, int i6, @NullableDecl V v5, int i7, RemovalCause removalCause) {
            this.totalWeight -= i7;
            if (removalCause.wasEvicted()) {
                this.statsCounter.recordEviction();
            }
            if (this.map.removalNotificationQueue != LocalCache.DISCARDING_QUEUE) {
                this.map.removalNotificationQueue.offer(RemovalNotification.create(k6, v5, removalCause));
            }
        }

        @GuardedBy("this")
        void evictEntries(ReferenceEntry<K, V> referenceEntry) {
            if (this.map.evictsBySize()) {
                drainRecencyQueue();
                if (referenceEntry.getValueReference().getWeight() > this.maxSegmentWeight && !removeEntry(referenceEntry, referenceEntry.getHash(), RemovalCause.SIZE)) {
                    throw new AssertionError();
                }
                while (this.totalWeight > this.maxSegmentWeight) {
                    ReferenceEntry<K, V> nextEvictable = getNextEvictable();
                    if (!removeEntry(nextEvictable, nextEvictable.getHash(), RemovalCause.SIZE)) {
                        throw new AssertionError();
                    }
                }
            }
        }

        @GuardedBy("this")
        void expand() {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i6 = this.count;
            AtomicReferenceArray<ReferenceEntry<K, V>> newEntryArray = newEntryArray(length << 1);
            this.threshold = (newEntryArray.length() * 3) / 4;
            int length2 = newEntryArray.length() - 1;
            for (int i7 = 0; i7 < length; i7++) {
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i7);
                if (referenceEntry != null) {
                    ReferenceEntry<K, V> next = referenceEntry.getNext();
                    int hash = referenceEntry.getHash() & length2;
                    if (next == null) {
                        newEntryArray.set(hash, referenceEntry);
                    } else {
                        ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                        while (next != null) {
                            int hash2 = next.getHash() & length2;
                            if (hash2 != hash) {
                                referenceEntry2 = next;
                                hash = hash2;
                            }
                            next = next.getNext();
                        }
                        newEntryArray.set(hash, referenceEntry2);
                        while (referenceEntry != referenceEntry2) {
                            int hash3 = referenceEntry.getHash() & length2;
                            ReferenceEntry<K, V> copyEntry = copyEntry(referenceEntry, newEntryArray.get(hash3));
                            if (copyEntry != null) {
                                newEntryArray.set(hash3, copyEntry);
                            } else {
                                removeCollectedEntry(referenceEntry);
                                i6--;
                            }
                            referenceEntry = referenceEntry.getNext();
                        }
                    }
                }
            }
            this.table = newEntryArray;
            this.count = i6;
        }

        ReferenceEntry<K, V> getFirst(int i6) {
            return this.table.get(i6 & (r0.length() - 1));
        }

        @GuardedBy("this")
        ReferenceEntry<K, V> getNextEvictable() {
            for (ReferenceEntry<K, V> referenceEntry : this.accessQueue) {
                if (referenceEntry.getValueReference().getWeight() > 0) {
                    return referenceEntry;
                }
            }
            throw new AssertionError();
        }

        V lockedGetOrLoad(K k6, int i6, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            LoadingValueReference<K, V> loadingValueReference;
            ValueReference<K, V> valueReference;
            boolean z5;
            V loadSync;
            int i7 = i6;
            lock();
            try {
                long read = this.map.ticker.read();
                preWriteCleanup(read);
                int i8 = this.count - 1;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i7 & (atomicReferenceArray.length() - 1);
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    loadingValueReference = null;
                    if (referenceEntry2 == null) {
                        valueReference = null;
                        break;
                    }
                    long j6 = read;
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i7 && key != null && this.map.keyEquivalence.equivalent(k6, key)) {
                        valueReference = referenceEntry2.getValueReference();
                        if (valueReference.isLoading()) {
                            z5 = false;
                        } else {
                            V v5 = valueReference.get();
                            if (v5 == null) {
                                enqueueNotification(key, i7, v5, valueReference.getWeight(), RemovalCause.COLLECTED);
                                i7 = i6;
                            } else {
                                if (!this.map.isExpired(referenceEntry2, j6)) {
                                    recordLockedRead(referenceEntry2, j6);
                                    this.statsCounter.recordHits(1);
                                    unlock();
                                    postWriteCleanup();
                                    return v5;
                                }
                                i7 = i6;
                                enqueueNotification(key, i7, v5, valueReference.getWeight(), RemovalCause.EXPIRED);
                            }
                            this.writeQueue.remove(referenceEntry2);
                            this.accessQueue.remove(referenceEntry2);
                            this.count = i8;
                        }
                    } else {
                        referenceEntry2 = referenceEntry2.getNext();
                        read = j6;
                    }
                }
                z5 = true;
                if (z5) {
                    loadingValueReference = new LoadingValueReference<>();
                    if (referenceEntry2 == null) {
                        referenceEntry2 = newEntry(k6, i7, referenceEntry);
                        referenceEntry2.setValueReference(loadingValueReference);
                        atomicReferenceArray.set(length, referenceEntry2);
                    } else {
                        referenceEntry2.setValueReference(loadingValueReference);
                    }
                }
                unlock();
                postWriteCleanup();
                if (!z5) {
                    return waitForLoadingValue(referenceEntry2, k6, valueReference);
                }
                try {
                    synchronized (referenceEntry2) {
                        loadSync = loadSync(k6, i7, loadingValueReference, cacheLoader);
                    }
                    return loadSync;
                } finally {
                    this.statsCounter.recordMisses(1);
                }
            } catch (Throwable th) {
                unlock();
                postWriteCleanup();
                throw th;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @GuardedBy("this")
        ReferenceEntry<K, V> newEntry(K k6, int i6, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            return this.map.entryFactory.newEntry(this, Preconditions.checkNotNull(k6), i6, referenceEntry);
        }

        AtomicReferenceArray<ReferenceEntry<K, V>> newEntryArray(int i6) {
            return new AtomicReferenceArray<>(i6);
        }

        void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                cleanUp();
            }
        }

        @GuardedBy("this")
        void recordLockedRead(ReferenceEntry<K, V> referenceEntry, long j6) {
            if (this.map.recordsAccess()) {
                referenceEntry.setAccessTime(j6);
            }
            this.accessQueue.add(referenceEntry);
        }

        void recordRead(ReferenceEntry<K, V> referenceEntry, long j6) {
            if (this.map.recordsAccess()) {
                referenceEntry.setAccessTime(j6);
            }
            this.recencyQueue.add(referenceEntry);
        }

        @VisibleForTesting
        @GuardedBy("this")
        boolean removeEntry(ReferenceEntry<K, V> referenceEntry, int i6, RemovalCause removalCause) {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i6;
            ReferenceEntry<K, V> referenceEntry2 = atomicReferenceArray.get(length);
            for (ReferenceEntry<K, V> referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                if (referenceEntry3 == referenceEntry) {
                    this.modCount++;
                    ReferenceEntry<K, V> removeValueFromChain = removeValueFromChain(referenceEntry2, referenceEntry3, referenceEntry3.getKey(), i6, referenceEntry3.getValueReference().get(), referenceEntry3.getValueReference(), removalCause);
                    int i7 = this.count - 1;
                    atomicReferenceArray.set(length, removeValueFromChain);
                    this.count = i7;
                    return true;
                }
            }
            return false;
        }

        @NullableDecl
        @GuardedBy("this")
        ReferenceEntry<K, V> removeEntryFromChain(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            int i6 = this.count;
            ReferenceEntry<K, V> next = referenceEntry2.getNext();
            while (referenceEntry != referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = copyEntry(referenceEntry, next);
                if (copyEntry != null) {
                    next = copyEntry;
                } else {
                    removeCollectedEntry(referenceEntry);
                    i6--;
                }
                referenceEntry = referenceEntry.getNext();
            }
            this.count = i6;
            return next;
        }

        V scheduleRefresh(ReferenceEntry<K, V> referenceEntry, K k6, int i6, V v5, long j6, CacheLoader<? super K, V> cacheLoader) {
            V refresh;
            return (!this.map.refreshes() || j6 - referenceEntry.getWriteTime() <= this.map.refreshNanos || referenceEntry.getValueReference().isLoading() || (refresh = refresh(k6, i6, cacheLoader, true)) == null) ? v5 : refresh;
        }

        Segment(LocalCache<K, V> localCache, int i6, long j6, AbstractCache.StatsCounter statsCounter) {
            ReferenceQueue<K> referenceQueue;
            Queue<ReferenceEntry<K, V>> discardingQueue;
            Queue<ReferenceEntry<K, V>> discardingQueue2;
            Queue<ReferenceEntry<K, V>> discardingQueue3;
            this.map = localCache;
            this.maxSegmentWeight = j6;
            this.statsCounter = (AbstractCache.StatsCounter) Preconditions.checkNotNull(statsCounter);
            initTable(newEntryArray(i6));
            if (localCache.usesKeyReferences()) {
                referenceQueue = new ReferenceQueue<>();
            } else {
                referenceQueue = null;
            }
            this.keyReferenceQueue = referenceQueue;
            this.valueReferenceQueue = localCache.usesValueReferences() ? new ReferenceQueue<>() : null;
            if (localCache.usesAccessQueue()) {
                discardingQueue = new ConcurrentLinkedQueue<>();
            } else {
                discardingQueue = LocalCache.discardingQueue();
            }
            this.recencyQueue = discardingQueue;
            if (localCache.usesWriteQueue()) {
                discardingQueue2 = new WriteQueue<>();
            } else {
                discardingQueue2 = LocalCache.discardingQueue();
            }
            this.writeQueue = discardingQueue2;
            if (localCache.usesAccessQueue()) {
                discardingQueue3 = new AccessQueue<>();
            } else {
                discardingQueue3 = LocalCache.discardingQueue();
            }
            this.accessQueue = discardingQueue3;
        }

        @GuardedBy("this")
        ReferenceEntry<K, V> copyEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            if (referenceEntry.getKey() == null) {
                return null;
            }
            ValueReference<K, V> valueReference = referenceEntry.getValueReference();
            V v5 = valueReference.get();
            if (v5 == null && valueReference.isActive()) {
                return null;
            }
            ReferenceEntry<K, V> copyEntry = this.map.entryFactory.copyEntry(this, referenceEntry, referenceEntry2);
            copyEntry.setValueReference(valueReference.copyFor(this.valueReferenceQueue, v5, copyEntry));
            return copyEntry;
        }

        @GuardedBy("this")
        void expireEntries(long j6) {
            ReferenceEntry<K, V> peek;
            ReferenceEntry<K, V> peek2;
            drainRecencyQueue();
            do {
                peek = this.writeQueue.peek();
                if (peek == null || !this.map.isExpired(peek, j6)) {
                    do {
                        peek2 = this.accessQueue.peek();
                        if (peek2 == null || !this.map.isExpired(peek2, j6)) {
                            return;
                        }
                    } while (removeEntry(peek2, peek2.getHash(), RemovalCause.EXPIRED));
                    throw new AssertionError();
                }
            } while (removeEntry(peek, peek.getHash(), RemovalCause.EXPIRED));
            throw new AssertionError();
        }

        V getAndRecordStats(K k6, int i6, LoadingValueReference<K, V> loadingValueReference, ListenableFuture<V> listenableFuture) throws ExecutionException {
            V v5;
            try {
                v5 = (V) Uninterruptibles.getUninterruptibly(listenableFuture);
                try {
                    if (v5 != null) {
                        this.statsCounter.recordLoadSuccess(loadingValueReference.elapsedNanos());
                        storeLoadedValue(k6, i6, loadingValueReference, v5);
                        return v5;
                    }
                    throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + k6 + ".");
                } catch (Throwable th) {
                    th = th;
                    if (v5 == null) {
                        this.statsCounter.recordLoadException(loadingValueReference.elapsedNanos());
                        removeLoadingValue(k6, i6, loadingValueReference);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                v5 = null;
            }
        }

        @NullableDecl
        ReferenceEntry<K, V> getEntry(Object obj, int i6) {
            for (ReferenceEntry<K, V> first = getFirst(i6); first != null; first = first.getNext()) {
                if (first.getHash() == i6) {
                    K key = first.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                        return first;
                    }
                }
            }
            return null;
        }

        @NullableDecl
        ReferenceEntry<K, V> getLiveEntry(Object obj, int i6, long j6) {
            ReferenceEntry<K, V> entry = getEntry(obj, i6);
            if (entry == null) {
                return null;
            }
            if (this.map.isExpired(entry, j6)) {
                tryExpireEntries(j6);
                return null;
            }
            return entry;
        }

        V getLiveValue(ReferenceEntry<K, V> referenceEntry, long j6) {
            if (referenceEntry.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v5 = referenceEntry.getValueReference().get();
            if (v5 == null) {
                tryDrainReferenceQueues();
                return null;
            }
            if (this.map.isExpired(referenceEntry, j6)) {
                tryExpireEntries(j6);
                return null;
            }
            return v5;
        }

        void initTable(AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            if (!this.map.customWeigher()) {
                int i6 = this.threshold;
                if (i6 == this.maxSegmentWeight) {
                    this.threshold = i6 + 1;
                }
            }
            this.table = atomicReferenceArray;
        }

        /* JADX WARN: Finally extract failed */
        @NullableDecl
        LoadingValueReference<K, V> insertLoadingValueReference(K k6, int i6, boolean z5) {
            lock();
            try {
                long read = this.map.ticker.read();
                preWriteCleanup(read);
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i6;
                ReferenceEntry<K, V> referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i6 && key != null && this.map.keyEquivalence.equivalent(k6, key)) {
                        ValueReference<K, V> valueReference = referenceEntry2.getValueReference();
                        if (!valueReference.isLoading() && (!z5 || read - referenceEntry2.getWriteTime() >= this.map.refreshNanos)) {
                            this.modCount++;
                            LoadingValueReference<K, V> loadingValueReference = new LoadingValueReference<>(valueReference);
                            referenceEntry2.setValueReference(loadingValueReference);
                            unlock();
                            postWriteCleanup();
                            return loadingValueReference;
                        }
                        unlock();
                        postWriteCleanup();
                        return null;
                    }
                }
                this.modCount++;
                LoadingValueReference<K, V> loadingValueReference2 = new LoadingValueReference<>();
                ReferenceEntry<K, V> newEntry = newEntry(k6, i6, referenceEntry);
                newEntry.setValueReference(loadingValueReference2);
                atomicReferenceArray.set(length, newEntry);
                unlock();
                postWriteCleanup();
                return loadingValueReference2;
            } catch (Throwable th) {
                unlock();
                postWriteCleanup();
                throw th;
            }
        }

        ListenableFuture<V> loadAsync(final K k6, final int i6, final LoadingValueReference<K, V> loadingValueReference, CacheLoader<? super K, V> cacheLoader) {
            final ListenableFuture<V> loadFuture = loadingValueReference.loadFuture(k6, cacheLoader);
            loadFuture.addListener(new Runnable() { // from class: com.google.common.cache.LocalCache.Segment.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Segment.this.getAndRecordStats(k6, i6, loadingValueReference, loadFuture);
                    } catch (Throwable th) {
                        LocalCache.logger.log(Level.WARNING, "Exception thrown during refresh", th);
                        loadingValueReference.setException(th);
                    }
                }
            }, MoreExecutors.directExecutor());
            return loadFuture;
        }

        V loadSync(K k6, int i6, LoadingValueReference<K, V> loadingValueReference, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            return getAndRecordStats(k6, i6, loadingValueReference, loadingValueReference.loadFuture(k6, cacheLoader));
        }

        void postWriteCleanup() {
            runUnlockedCleanup();
        }

        @GuardedBy("this")
        void preWriteCleanup(long j6) {
            runLockedCleanup(j6);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0088, code lost:
        
            unlock();
            postWriteCleanup();
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x008e, code lost:
        
            return null;
         */
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        V put(K r13, int r14, V r15, boolean r16) {
            /*
                Method dump skipped, instructions count: 242
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.put(java.lang.Object, int, java.lang.Object, boolean):java.lang.Object");
        }

        boolean reclaimKey(ReferenceEntry<K, V> referenceEntry, int i6) {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray;
            int length;
            ReferenceEntry<K, V> referenceEntry2;
            ReferenceEntry<K, V> referenceEntry3;
            lock();
            try {
                atomicReferenceArray = this.table;
                length = (atomicReferenceArray.length() - 1) & i6;
                referenceEntry2 = atomicReferenceArray.get(length);
                referenceEntry3 = referenceEntry2;
            } catch (Throwable th) {
                th = th;
            }
            while (referenceEntry3 != null) {
                if (referenceEntry3 == referenceEntry) {
                    this.modCount++;
                    ReferenceEntry<K, V> removeValueFromChain = removeValueFromChain(referenceEntry2, referenceEntry3, referenceEntry3.getKey(), i6, referenceEntry3.getValueReference().get(), referenceEntry3.getValueReference(), RemovalCause.COLLECTED);
                    int i7 = this.count - 1;
                    atomicReferenceArray.set(length, removeValueFromChain);
                    this.count = i7;
                    unlock();
                    postWriteCleanup();
                    return true;
                }
                int i8 = i6;
                try {
                    referenceEntry3 = referenceEntry3.getNext();
                    i6 = i8;
                } catch (Throwable th2) {
                    th = th2;
                }
                th = th2;
                Throwable th3 = th;
                unlock();
                postWriteCleanup();
                throw th3;
            }
            unlock();
            postWriteCleanup();
            return false;
        }

        boolean reclaimValue(K k6, int i6, ValueReference<K, V> valueReference) {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray;
            int length;
            ReferenceEntry<K, V> referenceEntry;
            ReferenceEntry<K, V> referenceEntry2;
            lock();
            try {
                atomicReferenceArray = this.table;
                length = (atomicReferenceArray.length() - 1) & i6;
                referenceEntry = atomicReferenceArray.get(length);
                referenceEntry2 = referenceEntry;
            } catch (Throwable th) {
                th = th;
            }
            while (referenceEntry2 != null) {
                K key = referenceEntry2.getKey();
                if (referenceEntry2.getHash() == i6 && key != null && this.map.keyEquivalence.equivalent(k6, key)) {
                    if (referenceEntry2.getValueReference() == valueReference) {
                        this.modCount++;
                        ReferenceEntry<K, V> removeValueFromChain = removeValueFromChain(referenceEntry, referenceEntry2, key, i6, valueReference.get(), valueReference, RemovalCause.COLLECTED);
                        int i7 = this.count - 1;
                        atomicReferenceArray.set(length, removeValueFromChain);
                        this.count = i7;
                        unlock();
                        if (!isHeldByCurrentThread()) {
                            postWriteCleanup();
                        }
                        return true;
                    }
                    unlock();
                    if (!isHeldByCurrentThread()) {
                        postWriteCleanup();
                    }
                    return false;
                }
                int i8 = i6;
                ValueReference<K, V> valueReference2 = valueReference;
                try {
                    referenceEntry2 = referenceEntry2.getNext();
                    i6 = i8;
                    valueReference = valueReference2;
                } catch (Throwable th2) {
                    th = th2;
                }
                th = th2;
                Throwable th3 = th;
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                    throw th3;
                }
                throw th3;
            }
            unlock();
            if (!isHeldByCurrentThread()) {
                postWriteCleanup();
            }
            return false;
        }

        @GuardedBy("this")
        void recordWrite(ReferenceEntry<K, V> referenceEntry, int i6, long j6) {
            drainRecencyQueue();
            this.totalWeight += i6;
            if (this.map.recordsAccess()) {
                referenceEntry.setAccessTime(j6);
            }
            if (this.map.recordsWrite()) {
                referenceEntry.setWriteTime(j6);
            }
            this.accessQueue.add(referenceEntry);
            this.writeQueue.add(referenceEntry);
        }

        @NullableDecl
        V refresh(K k6, int i6, CacheLoader<? super K, V> cacheLoader, boolean z5) {
            LoadingValueReference<K, V> insertLoadingValueReference = insertLoadingValueReference(k6, i6, z5);
            if (insertLoadingValueReference == null) {
                return null;
            }
            ListenableFuture<V> loadAsync = loadAsync(k6, i6, insertLoadingValueReference, cacheLoader);
            if (loadAsync.isDone()) {
                try {
                    return (V) Uninterruptibles.getUninterruptibly(loadAsync);
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        @GuardedBy("this")
        void removeCollectedEntry(ReferenceEntry<K, V> referenceEntry) {
            enqueueNotification(referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry.getValueReference().get(), referenceEntry.getValueReference().getWeight(), RemovalCause.COLLECTED);
            this.writeQueue.remove(referenceEntry);
            this.accessQueue.remove(referenceEntry);
        }

        boolean removeLoadingValue(K k6, int i6, LoadingValueReference<K, V> loadingValueReference) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i6;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i6 && key != null && this.map.keyEquivalence.equivalent(k6, key)) {
                        if (referenceEntry2.getValueReference() == loadingValueReference) {
                            if (loadingValueReference.isActive()) {
                                referenceEntry2.setValueReference(loadingValueReference.getOldValue());
                            } else {
                                atomicReferenceArray.set(length, removeEntryFromChain(referenceEntry, referenceEntry2));
                            }
                            unlock();
                            postWriteCleanup();
                            return true;
                        }
                    } else {
                        referenceEntry2 = referenceEntry2.getNext();
                    }
                }
                unlock();
                postWriteCleanup();
                return false;
            } catch (Throwable th) {
                unlock();
                postWriteCleanup();
                throw th;
            }
        }

        @NullableDecl
        @GuardedBy("this")
        ReferenceEntry<K, V> removeValueFromChain(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, @NullableDecl K k6, int i6, V v5, ValueReference<K, V> valueReference, RemovalCause removalCause) {
            enqueueNotification(k6, i6, v5, valueReference.getWeight(), removalCause);
            this.writeQueue.remove(referenceEntry2);
            this.accessQueue.remove(referenceEntry2);
            if (valueReference.isLoading()) {
                valueReference.notifyNewValue(null);
                return referenceEntry;
            }
            return removeEntryFromChain(referenceEntry, referenceEntry2);
        }

        void runLockedCleanup(long j6) {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                    expireEntries(j6);
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        void runUnlockedCleanup() {
            if (!isHeldByCurrentThread()) {
                this.map.processPendingNotifications();
            }
        }

        @GuardedBy("this")
        void setValue(ReferenceEntry<K, V> referenceEntry, K k6, V v5, long j6) {
            boolean z5;
            ValueReference<K, V> valueReference = referenceEntry.getValueReference();
            int weigh = this.map.weigher.weigh(k6, v5);
            if (weigh >= 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            Preconditions.checkState(z5, "Weights must be non-negative");
            referenceEntry.setValueReference(this.map.valueStrength.referenceValue(this, referenceEntry, v5, weigh));
            recordWrite(referenceEntry, weigh, j6);
            valueReference.notifyNewValue(v5);
        }

        boolean storeLoadedValue(K k6, int i6, LoadingValueReference<K, V> loadingValueReference, V v5) {
            RemovalCause removalCause;
            lock();
            try {
                long read = this.map.ticker.read();
                preWriteCleanup(read);
                int i7 = this.count + 1;
                if (i7 > this.threshold) {
                    expand();
                    i7 = this.count + 1;
                }
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i6 & (atomicReferenceArray.length() - 1);
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 != null) {
                        K key = referenceEntry2.getKey();
                        if (referenceEntry2.getHash() == i6 && key != null && this.map.keyEquivalence.equivalent(k6, key)) {
                            ValueReference<K, V> valueReference = referenceEntry2.getValueReference();
                            V v6 = valueReference.get();
                            if (loadingValueReference != valueReference && (v6 != null || valueReference == LocalCache.UNSET)) {
                                enqueueNotification(k6, i6, v5, 0, RemovalCause.REPLACED);
                                unlock();
                                postWriteCleanup();
                                return false;
                            }
                            this.modCount++;
                            if (loadingValueReference.isActive()) {
                                if (v6 == null) {
                                    removalCause = RemovalCause.COLLECTED;
                                } else {
                                    removalCause = RemovalCause.REPLACED;
                                }
                                enqueueNotification(k6, i6, v6, loadingValueReference.getWeight(), removalCause);
                                i7--;
                            }
                            ReferenceEntry<K, V> referenceEntry3 = referenceEntry2;
                            setValue(referenceEntry3, k6, v5, read);
                            this.count = i7;
                            evictEntries(referenceEntry3);
                        } else {
                            referenceEntry2 = referenceEntry2.getNext();
                        }
                    } else {
                        this.modCount++;
                        ReferenceEntry<K, V> newEntry = newEntry(k6, i6, referenceEntry);
                        setValue(newEntry, k6, v5, read);
                        atomicReferenceArray.set(length, newEntry);
                        this.count = i7;
                        evictEntries(newEntry);
                        break;
                    }
                }
                unlock();
                postWriteCleanup();
                return true;
            } catch (Throwable th) {
                unlock();
                postWriteCleanup();
                throw th;
            }
        }

        void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        void tryExpireEntries(long j6) {
            if (tryLock()) {
                try {
                    expireEntries(j6);
                } finally {
                    unlock();
                }
            }
        }

        V waitForLoadingValue(ReferenceEntry<K, V> referenceEntry, K k6, ValueReference<K, V> valueReference) throws ExecutionException {
            if (valueReference.isLoading()) {
                Preconditions.checkState(!Thread.holdsLock(referenceEntry), "Recursive load of: %s", k6);
                try {
                    V waitForValue = valueReference.waitForValue();
                    if (waitForValue != null) {
                        recordRead(referenceEntry, this.map.ticker.read());
                        return waitForValue;
                    }
                    throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + k6 + ".");
                } finally {
                    this.statsCounter.recordMisses(1);
                }
            }
            throw new AssertionError();
        }

        @NullableDecl
        V get(Object obj, int i6) {
            try {
                if (this.count != 0) {
                    long read = this.map.ticker.read();
                    ReferenceEntry<K, V> liveEntry = getLiveEntry(obj, i6, read);
                    if (liveEntry == null) {
                        postReadCleanup();
                        return null;
                    }
                    V v5 = liveEntry.getValueReference().get();
                    if (v5 != null) {
                        recordRead(liveEntry, read);
                        V scheduleRefresh = scheduleRefresh(liveEntry, liveEntry.getKey(), i6, v5, read, this.map.defaultLoader);
                        postReadCleanup();
                        return scheduleRefresh;
                    }
                    tryDrainReferenceQueues();
                }
                postReadCleanup();
                return null;
            } catch (Throwable th) {
                postReadCleanup();
                throw th;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
        
            r10 = r6.getValueReference();
            r9 = r10.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0048, code lost:
        
            if (r12.map.valueEquivalence.equivalent(r15, r9) == false) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0052, code lost:
        
            if (r9 != null) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0058, code lost:
        
            if (r10.isActive() == false) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x005a, code lost:
        
            r13 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
        
            r11 = r13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x005d, code lost:
        
            r12.modCount++;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0064, code lost:
        
            r13 = removeValueFromChain(r5, r6, r7, r14, r9, r10, r11);
            r14 = r12.count - 1;
            r0.set(r1, r13);
            r12.count = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0072, code lost:
        
            if (r11 != com.google.common.cache.RemovalCause.EXPLICIT) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0075, code lost:
        
            r2 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0076, code lost:
        
            unlock();
            postWriteCleanup();
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x007c, code lost:
        
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x004a, code lost:
        
            r13 = com.google.common.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x004e, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x004f, code lost:
        
            r13 = r0;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean remove(java.lang.Object r13, int r14, java.lang.Object r15) {
            /*
                r12 = this;
                r12.lock()
                com.google.common.cache.LocalCache<K, V> r0 = r12.map     // Catch: java.lang.Throwable -> L80
                com.google.common.base.Ticker r0 = r0.ticker     // Catch: java.lang.Throwable -> L80
                long r0 = r0.read()     // Catch: java.lang.Throwable -> L80
                r12.preWriteCleanup(r0)     // Catch: java.lang.Throwable -> L80
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r0 = r12.table     // Catch: java.lang.Throwable -> L80
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L80
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r14
                java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L80
                r5 = r3
                com.google.common.cache.ReferenceEntry r5 = (com.google.common.cache.ReferenceEntry) r5     // Catch: java.lang.Throwable -> L80
                r6 = r5
            L1f:
                r3 = 0
                if (r6 == 0) goto L92
                java.lang.Object r7 = r6.getKey()     // Catch: java.lang.Throwable -> L80
                int r4 = r6.getHash()     // Catch: java.lang.Throwable -> L80
                if (r4 != r14) goto L8a
                if (r7 == 0) goto L8a
                com.google.common.cache.LocalCache<K, V> r4 = r12.map     // Catch: java.lang.Throwable -> L80
                com.google.common.base.Equivalence<java.lang.Object> r4 = r4.keyEquivalence     // Catch: java.lang.Throwable -> L80
                boolean r4 = r4.equivalent(r13, r7)     // Catch: java.lang.Throwable -> L80
                if (r4 == 0) goto L8a
                com.google.common.cache.LocalCache$ValueReference r10 = r6.getValueReference()     // Catch: java.lang.Throwable -> L80
                java.lang.Object r9 = r10.get()     // Catch: java.lang.Throwable -> L80
                com.google.common.cache.LocalCache<K, V> r13 = r12.map     // Catch: java.lang.Throwable -> L80
                com.google.common.base.Equivalence<java.lang.Object> r13 = r13.valueEquivalence     // Catch: java.lang.Throwable -> L80
                boolean r13 = r13.equivalent(r15, r9)     // Catch: java.lang.Throwable -> L80
                if (r13 == 0) goto L52
                com.google.common.cache.RemovalCause r13 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L4e
            L4c:
                r11 = r13
                goto L5d
            L4e:
                r0 = move-exception
                r13 = r0
                r4 = r12
                goto L94
            L52:
                if (r9 != 0) goto L92
                boolean r13 = r10.isActive()     // Catch: java.lang.Throwable -> L80
                if (r13 == 0) goto L92
                com.google.common.cache.RemovalCause r13 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L80
                goto L4c
            L5d:
                int r13 = r12.modCount     // Catch: java.lang.Throwable -> L80
                int r13 = r13 + r2
                r12.modCount = r13     // Catch: java.lang.Throwable -> L80
                r4 = r12
                r8 = r14
                com.google.common.cache.ReferenceEntry r13 = r4.removeValueFromChain(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L7d
                int r14 = r4.count     // Catch: java.lang.Throwable -> L7d
                int r14 = r14 - r2
                r0.set(r1, r13)     // Catch: java.lang.Throwable -> L7d
                r4.count = r14     // Catch: java.lang.Throwable -> L7d
                com.google.common.cache.RemovalCause r13 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L7d
                if (r11 != r13) goto L75
                goto L76
            L75:
                r2 = 0
            L76:
                r12.unlock()
                r12.postWriteCleanup()
                return r2
            L7d:
                r0 = move-exception
            L7e:
                r13 = r0
                goto L94
            L80:
                r0 = move-exception
                r4 = r12
                goto L7e
            L83:
                r12.unlock()
                r12.postWriteCleanup()
                return r3
            L8a:
                r4 = r12
                r8 = r14
                com.google.common.cache.ReferenceEntry r6 = r6.getNext()     // Catch: java.lang.Throwable -> L7d
                r14 = r8
                goto L1f
            L92:
                r4 = r12
                goto L83
            L94:
                r12.unlock()
                r12.postWriteCleanup()
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.remove(java.lang.Object, int, java.lang.Object):boolean");
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x006c, code lost:
        
            return null;
         */
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        V replace(K r14, int r15, V r16) {
            /*
                r13 = this;
                r13.lock()
                com.google.common.cache.LocalCache<K, V> r0 = r13.map     // Catch: java.lang.Throwable -> L63
                com.google.common.base.Ticker r0 = r0.ticker     // Catch: java.lang.Throwable -> L63
                long r7 = r0.read()     // Catch: java.lang.Throwable -> L63
                r13.preWriteCleanup(r7)     // Catch: java.lang.Throwable -> L63
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r0 = r13.table     // Catch: java.lang.Throwable -> L63
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L63
                int r1 = r1 + (-1)
                r9 = r15 & r1
                java.lang.Object r1 = r0.get(r9)     // Catch: java.lang.Throwable -> L63
                r2 = r1
                com.google.common.cache.ReferenceEntry r2 = (com.google.common.cache.ReferenceEntry) r2     // Catch: java.lang.Throwable -> L63
                r1 = r2
            L20:
                r10 = 0
                if (r1 == 0) goto L66
                java.lang.Object r4 = r1.getKey()     // Catch: java.lang.Throwable -> L63
                int r5 = r1.getHash()     // Catch: java.lang.Throwable -> L63
                if (r5 != r15) goto L95
                if (r4 == 0) goto L95
                com.google.common.cache.LocalCache<K, V> r5 = r13.map     // Catch: java.lang.Throwable -> L63
                com.google.common.base.Equivalence<java.lang.Object> r5 = r5.keyEquivalence     // Catch: java.lang.Throwable -> L63
                boolean r5 = r5.equivalent(r14, r4)     // Catch: java.lang.Throwable -> L63
                if (r5 == 0) goto L95
                r11 = r7
                com.google.common.cache.LocalCache$ValueReference r7 = r1.getValueReference()     // Catch: java.lang.Throwable -> L63
                java.lang.Object r6 = r7.get()     // Catch: java.lang.Throwable -> L63
                if (r6 != 0) goto L6d
                boolean r14 = r7.isActive()     // Catch: java.lang.Throwable -> L63
                if (r14 == 0) goto L66
                int r14 = r13.modCount     // Catch: java.lang.Throwable -> L63
                int r14 = r14 + 1
                r13.modCount = r14     // Catch: java.lang.Throwable -> L63
                com.google.common.cache.RemovalCause r8 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L63
                r5 = r15
                r3 = r1
                r1 = r13
                com.google.common.cache.ReferenceEntry r14 = r1.removeValueFromChain(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L63
                int r2 = r13.count     // Catch: java.lang.Throwable -> L63
                int r2 = r2 + (-1)
                r0.set(r9, r14)     // Catch: java.lang.Throwable -> L63
                r13.count = r2     // Catch: java.lang.Throwable -> L63
                goto L66
            L63:
                r0 = move-exception
                r14 = r0
                goto La0
            L66:
                r13.unlock()
                r13.postWriteCleanup()
                return r10
            L6d:
                r0 = r1
                r4 = r6
                int r2 = r13.modCount     // Catch: java.lang.Throwable -> L63
                int r2 = r2 + 1
                r13.modCount = r2     // Catch: java.lang.Throwable -> L63
                int r5 = r7.getWeight()     // Catch: java.lang.Throwable -> L63
                com.google.common.cache.RemovalCause r6 = com.google.common.cache.RemovalCause.REPLACED     // Catch: java.lang.Throwable -> L63
                r1 = r13
                r2 = r14
                r3 = r15
                r1.enqueueNotification(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L63
                r7 = r4
                r1 = r13
                r3 = r14
                r4 = r16
                r2 = r0
                r5 = r11
                r1.setValue(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L63
                r13.evictEntries(r2)     // Catch: java.lang.Throwable -> L63
                r13.unlock()
                r13.postWriteCleanup()
                return r7
            L95:
                r3 = r2
                r5 = r7
                r2 = r1
                com.google.common.cache.ReferenceEntry r2 = r2.getNext()     // Catch: java.lang.Throwable -> L63
                r1 = r2
                r2 = r3
                r7 = r5
                goto L20
            La0:
                r13.unlock()
                r13.postWriteCleanup()
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.replace(java.lang.Object, int, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class SoftValueReference<K, V> extends SoftReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> entry;

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v5, ReferenceEntry<K, V> referenceEntry) {
            return new SoftValueReference(referenceQueue, v5, referenceEntry);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return this.entry;
        }

        SoftValueReference(ReferenceQueue<V> referenceQueue, V v5, ReferenceEntry<K, V> referenceEntry) {
            super(v5, referenceQueue);
            this.entry = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V waitForValue() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(V v5) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum Strength {
        STRONG { // from class: com.google.common.cache.LocalCache.Strength.1
            @Override // com.google.common.cache.LocalCache.Strength
            <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v5, int i6) {
                return i6 == 1 ? new StrongValueReference(v5) : new WeightedStrongValueReference(v5, i6);
            }

            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }
        },
        SOFT { // from class: com.google.common.cache.LocalCache.Strength.2
            @Override // com.google.common.cache.LocalCache.Strength
            <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v5, int i6) {
                return i6 == 1 ? new SoftValueReference(segment.valueReferenceQueue, v5, referenceEntry) : new WeightedSoftValueReference(segment.valueReferenceQueue, v5, referenceEntry, i6);
            }

            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.Strength.3
            @Override // com.google.common.cache.LocalCache.Strength
            <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v5, int i6) {
                return i6 == 1 ? new WeakValueReference(segment.valueReferenceQueue, v5, referenceEntry) : new WeightedWeakValueReference(segment.valueReferenceQueue, v5, referenceEntry, i6);
            }

            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        };

        abstract Equivalence<Object> defaultEquivalence();

        abstract <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v5, int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class StrongAccessEntry<K, V> extends StrongEntry<K, V> {
        volatile long accessTime;
        ReferenceEntry<K, V> nextAccess;
        ReferenceEntry<K, V> previousAccess;

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.accessTime;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.nextAccess;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j6) {
            this.accessTime = j6;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.nextAccess = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.previousAccess = referenceEntry;
        }

        StrongAccessEntry(K k6, int i6, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(k6, i6, referenceEntry);
            this.accessTime = Long.MAX_VALUE;
            this.nextAccess = LocalCache.nullEntry();
            this.previousAccess = LocalCache.nullEntry();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class StrongAccessWriteEntry<K, V> extends StrongEntry<K, V> {
        volatile long accessTime;
        ReferenceEntry<K, V> nextAccess;
        ReferenceEntry<K, V> nextWrite;
        ReferenceEntry<K, V> previousAccess;
        ReferenceEntry<K, V> previousWrite;
        volatile long writeTime;

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.accessTime;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.nextAccess;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.nextWrite;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.writeTime;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j6) {
            this.accessTime = j6;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.nextAccess = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.nextWrite = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.previousAccess = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.previousWrite = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j6) {
            this.writeTime = j6;
        }

        StrongAccessWriteEntry(K k6, int i6, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(k6, i6, referenceEntry);
            this.accessTime = Long.MAX_VALUE;
            this.nextAccess = LocalCache.nullEntry();
            this.previousAccess = LocalCache.nullEntry();
            this.writeTime = Long.MAX_VALUE;
            this.nextWrite = LocalCache.nullEntry();
            this.previousWrite = LocalCache.nullEntry();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class StrongEntry<K, V> extends AbstractReferenceEntry<K, V> {
        final int hash;
        final K key;

        @NullableDecl
        final ReferenceEntry<K, V> next;
        volatile ValueReference<K, V> valueReference = LocalCache.unset();

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public int getHash() {
            return this.hash;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public K getKey() {
            return this.key;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            return this.next;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            return this.valueReference;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<K, V> valueReference) {
            this.valueReference = valueReference;
        }

        StrongEntry(K k6, int i6, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            this.key = k6;
            this.hash = i6;
            this.next = referenceEntry;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class StrongValueReference<K, V> implements ValueReference<K, V> {
        final V referent;

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V get() {
            return this.referent;
        }

        StrongValueReference(V v5) {
            this.referent = v5;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V waitForValue() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(V v5) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v5, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class StrongWriteEntry<K, V> extends StrongEntry<K, V> {
        ReferenceEntry<K, V> nextWrite;
        ReferenceEntry<K, V> previousWrite;
        volatile long writeTime;

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.nextWrite;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.writeTime;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.nextWrite = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.previousWrite = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j6) {
            this.writeTime = j6;
        }

        StrongWriteEntry(K k6, int i6, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(k6, i6, referenceEntry);
            this.writeTime = Long.MAX_VALUE;
            this.nextWrite = LocalCache.nullEntry();
            this.previousWrite = LocalCache.nullEntry();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class ValueIterator extends LocalCache<K, V>.HashIterator<V> {
        ValueIterator() {
            super();
        }

        @Override // com.google.common.cache.LocalCache.HashIterator, java.util.Iterator
        public V next() {
            return nextEntry().getValue();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface ValueReference<K, V> {
        ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, @NullableDecl V v5, ReferenceEntry<K, V> referenceEntry);

        @NullableDecl
        V get();

        @NullableDecl
        ReferenceEntry<K, V> getEntry();

        int getWeight();

        boolean isActive();

        boolean isLoading();

        void notifyNewValue(@NullableDecl V v5);

        V waitForValue() throws ExecutionException;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class Values extends AbstractCollection<V> {
        private final ConcurrentMap<?, ?> map;

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return LocalCache.toArrayList(this).toArray();
        }

        Values(ConcurrentMap<?, ?> concurrentMap) {
            this.map = concurrentMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.map.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.map.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.toArrayList(this).toArray(eArr);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WeakAccessEntry<K, V> extends WeakEntry<K, V> {
        volatile long accessTime;
        ReferenceEntry<K, V> nextAccess;
        ReferenceEntry<K, V> previousAccess;

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.accessTime;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.nextAccess;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j6) {
            this.accessTime = j6;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.nextAccess = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.previousAccess = referenceEntry;
        }

        WeakAccessEntry(ReferenceQueue<K> referenceQueue, K k6, int i6, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k6, i6, referenceEntry);
            this.accessTime = Long.MAX_VALUE;
            this.nextAccess = LocalCache.nullEntry();
            this.previousAccess = LocalCache.nullEntry();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WeakAccessWriteEntry<K, V> extends WeakEntry<K, V> {
        volatile long accessTime;
        ReferenceEntry<K, V> nextAccess;
        ReferenceEntry<K, V> nextWrite;
        ReferenceEntry<K, V> previousAccess;
        ReferenceEntry<K, V> previousWrite;
        volatile long writeTime;

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.accessTime;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.nextAccess;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.nextWrite;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.writeTime;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j6) {
            this.accessTime = j6;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.nextAccess = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.nextWrite = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.previousAccess = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.previousWrite = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j6) {
            this.writeTime = j6;
        }

        WeakAccessWriteEntry(ReferenceQueue<K> referenceQueue, K k6, int i6, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k6, i6, referenceEntry);
            this.accessTime = Long.MAX_VALUE;
            this.nextAccess = LocalCache.nullEntry();
            this.previousAccess = LocalCache.nullEntry();
            this.writeTime = Long.MAX_VALUE;
            this.nextWrite = LocalCache.nullEntry();
            this.previousWrite = LocalCache.nullEntry();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class WeakEntry<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {
        final int hash;

        @NullableDecl
        final ReferenceEntry<K, V> next;
        volatile ValueReference<K, V> valueReference;

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            return this.hash;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            return this.next;
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            return this.valueReference;
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long j6) {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<K, V> valueReference) {
            this.valueReference = valueReference;
        }

        public void setWriteTime(long j6) {
            throw new UnsupportedOperationException();
        }

        WeakEntry(ReferenceQueue<K> referenceQueue, K k6, int i6, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(k6, referenceQueue);
            this.valueReference = LocalCache.unset();
            this.hash = i6;
            this.next = referenceEntry;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public K getKey() {
            return get();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class WeakValueReference<K, V> extends WeakReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> entry;

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v5, ReferenceEntry<K, V> referenceEntry) {
            return new WeakValueReference(referenceQueue, v5, referenceEntry);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return this.entry;
        }

        WeakValueReference(ReferenceQueue<V> referenceQueue, V v5, ReferenceEntry<K, V> referenceEntry) {
            super(v5, referenceQueue);
            this.entry = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V waitForValue() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(V v5) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WeakWriteEntry<K, V> extends WeakEntry<K, V> {
        ReferenceEntry<K, V> nextWrite;
        ReferenceEntry<K, V> previousWrite;
        volatile long writeTime;

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.nextWrite;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.writeTime;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.nextWrite = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.previousWrite = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j6) {
            this.writeTime = j6;
        }

        WeakWriteEntry(ReferenceQueue<K> referenceQueue, K k6, int i6, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k6, i6, referenceEntry);
            this.writeTime = Long.MAX_VALUE;
            this.nextWrite = LocalCache.nullEntry();
            this.previousWrite = LocalCache.nullEntry();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WeightedSoftValueReference<K, V> extends SoftValueReference<K, V> {
        final int weight;

        @Override // com.google.common.cache.LocalCache.SoftValueReference, com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v5, ReferenceEntry<K, V> referenceEntry) {
            return new WeightedSoftValueReference(referenceQueue, v5, referenceEntry, this.weight);
        }

        @Override // com.google.common.cache.LocalCache.SoftValueReference, com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.weight;
        }

        WeightedSoftValueReference(ReferenceQueue<V> referenceQueue, V v5, ReferenceEntry<K, V> referenceEntry, int i6) {
            super(referenceQueue, v5, referenceEntry);
            this.weight = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WeightedStrongValueReference<K, V> extends StrongValueReference<K, V> {
        final int weight;

        @Override // com.google.common.cache.LocalCache.StrongValueReference, com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.weight;
        }

        WeightedStrongValueReference(V v5, int i6) {
            super(v5);
            this.weight = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WeightedWeakValueReference<K, V> extends WeakValueReference<K, V> {
        final int weight;

        @Override // com.google.common.cache.LocalCache.WeakValueReference, com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v5, ReferenceEntry<K, V> referenceEntry) {
            return new WeightedWeakValueReference(referenceQueue, v5, referenceEntry, this.weight);
        }

        @Override // com.google.common.cache.LocalCache.WeakValueReference, com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.weight;
        }

        WeightedWeakValueReference(ReferenceQueue<V> referenceQueue, V v5, ReferenceEntry<K, V> referenceEntry, int i6) {
            super(referenceQueue, v5, referenceEntry);
            this.weight = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WriteQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> head = new AbstractReferenceEntry<K, V>() { // from class: com.google.common.cache.LocalCache.WriteQueue.1
            ReferenceEntry<K, V> nextWrite = this;
            ReferenceEntry<K, V> previousWrite = this;

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public ReferenceEntry<K, V> getNextInWriteQueue() {
                return this.nextWrite;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public ReferenceEntry<K, V> getPreviousInWriteQueue() {
                return this.previousWrite;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
                this.nextWrite = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
                this.previousWrite = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public long getWriteTime() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setWriteTime(long j6) {
            }
        };

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ReferenceEntry<K, V> nextInWriteQueue = this.head.getNextInWriteQueue();
            while (true) {
                ReferenceEntry<K, V> referenceEntry = this.head;
                if (nextInWriteQueue == referenceEntry) {
                    referenceEntry.setNextInWriteQueue(referenceEntry);
                    ReferenceEntry<K, V> referenceEntry2 = this.head;
                    referenceEntry2.setPreviousInWriteQueue(referenceEntry2);
                    return;
                } else {
                    ReferenceEntry<K, V> nextInWriteQueue2 = nextInWriteQueue.getNextInWriteQueue();
                    LocalCache.nullifyWriteOrder(nextInWriteQueue);
                    nextInWriteQueue = nextInWriteQueue2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((ReferenceEntry) obj).getNextInWriteQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.head.getNextInWriteQueue() == this.head;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<ReferenceEntry<K, V>> iterator() {
            return new AbstractSequentialIterator<ReferenceEntry<K, V>>(peek()) { // from class: com.google.common.cache.LocalCache.WriteQueue.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractSequentialIterator
                public ReferenceEntry<K, V> computeNext(ReferenceEntry<K, V> referenceEntry) {
                    ReferenceEntry<K, V> nextInWriteQueue = referenceEntry.getNextInWriteQueue();
                    if (nextInWriteQueue == WriteQueue.this.head) {
                        return null;
                    }
                    return nextInWriteQueue;
                }
            };
        }

        @Override // java.util.Queue
        public boolean offer(ReferenceEntry<K, V> referenceEntry) {
            LocalCache.connectWriteOrder(referenceEntry.getPreviousInWriteQueue(), referenceEntry.getNextInWriteQueue());
            LocalCache.connectWriteOrder(this.head.getPreviousInWriteQueue(), referenceEntry);
            LocalCache.connectWriteOrder(referenceEntry, this.head);
            return true;
        }

        @Override // java.util.Queue
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> nextInWriteQueue = this.head.getNextInWriteQueue();
            if (nextInWriteQueue == this.head) {
                return null;
            }
            return nextInWriteQueue;
        }

        @Override // java.util.Queue
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> nextInWriteQueue = this.head.getNextInWriteQueue();
            if (nextInWriteQueue == this.head) {
                return null;
            }
            remove(nextInWriteQueue);
            return nextInWriteQueue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry<K, V> previousInWriteQueue = referenceEntry.getPreviousInWriteQueue();
            ReferenceEntry<K, V> nextInWriteQueue = referenceEntry.getNextInWriteQueue();
            LocalCache.connectWriteOrder(previousInWriteQueue, nextInWriteQueue);
            LocalCache.nullifyWriteOrder(referenceEntry);
            return nextInWriteQueue != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i6 = 0;
            for (ReferenceEntry<K, V> nextInWriteQueue = this.head.getNextInWriteQueue(); nextInWriteQueue != this.head; nextInWriteQueue = nextInWriteQueue.getNextInWriteQueue()) {
                i6++;
            }
            return i6;
        }

        WriteQueue() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class WriteThroughEntry implements Map.Entry<K, V> {
        final K key;
        V value;

        WriteThroughEntry(K k6, V v5) {
            this.key = k6;
            this.value = v5;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (this.key.equals(entry.getKey()) && this.value.equals(entry.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.key.hashCode() ^ this.value.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v5) {
            V v6 = (V) LocalCache.this.put(this.key, v5);
            this.value = v5;
            return v6;
        }

        public String toString() {
            return getKey() + ContainerUtils.KEY_VALUE_DELIMITER + getValue();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).get(obj, hash);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k6, @NullableDecl V v5, V v6) {
        Preconditions.checkNotNull(k6);
        Preconditions.checkNotNull(v6);
        if (v5 == null) {
            return false;
        }
        int hash = hash(k6);
        return segmentFor(hash).replace(k6, hash, v5, v6);
    }

    static <E> Queue<E> discardingQueue() {
        return (Queue<E>) DISCARDING_QUEUE;
    }

    static <K, V> ReferenceEntry<K, V> nullEntry() {
        return NullEntry.INSTANCE;
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

    static <K, V> ValueReference<K, V> unset() {
        return (ValueReference<K, V>) UNSET;
    }

    public void cleanUp() {
        for (Segment<K, V> segment : this.segments) {
            segment.cleanUp();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V> segment : this.segments) {
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

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        long read = this.ticker.read();
        Segment<K, V>[] segmentArr = this.segments;
        long j6 = -1;
        int i6 = 0;
        while (i6 < 3) {
            int length = segmentArr.length;
            long j7 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                Segment<K, V> segment = segmentArr[i7];
                int i8 = segment.count;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = segment.table;
                for (int i9 = 0; i9 < atomicReferenceArray.length(); i9++) {
                    ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i9);
                    while (referenceEntry != null) {
                        Segment<K, V>[] segmentArr2 = segmentArr;
                        V liveValue = segment.getLiveValue(referenceEntry, read);
                        ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                        if (liveValue != null && this.valueEquivalence.equivalent(obj, liveValue)) {
                            return true;
                        }
                        referenceEntry = referenceEntry2.getNext();
                        segmentArr = segmentArr2;
                    }
                }
                j7 += segment.modCount;
            }
            Segment<K, V>[] segmentArr3 = segmentArr;
            if (j7 == j6) {
                return false;
            }
            i6++;
            j6 = j7;
            segmentArr = segmentArr3;
        }
        return false;
    }

    Segment<K, V> createSegment(int i6, long j6, AbstractCache.StatsCounter statsCounter) {
        return new Segment<>(this, i6, j6, statsCounter);
    }

    boolean customWeigher() {
        return this.weigher != CacheBuilder.OneWeigher.INSTANCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @GwtIncompatible
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet(this);
        this.entrySet = entrySet;
        return entrySet;
    }

    boolean evictsBySize() {
        return this.maxWeight >= 0;
    }

    boolean expiresAfterAccess() {
        return this.expireAfterAccessNanos > 0;
    }

    boolean expiresAfterWrite() {
        return this.expireAfterWriteNanos > 0;
    }

    ReferenceEntry<K, V> getEntry(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).getEntry(obj, hash);
    }

    V getOrLoad(K k6) throws ExecutionException {
        return get(k6, this.defaultLoader);
    }

    int hash(@NullableDecl Object obj) {
        return rehash(this.keyEquivalence.hash(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V>[] segmentArr = this.segments;
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
        KeySet keySet = new KeySet(this);
        this.keySet = keySet;
        return keySet;
    }

    long longSize() {
        long j6 = 0;
        for (int i6 = 0; i6 < this.segments.length; i6++) {
            j6 += Math.max(0, r0[i6].count);
        }
        return j6;
    }

    final Segment<K, V>[] newSegmentArray(int i6) {
        return new Segment[i6];
    }

    void processPendingNotifications() {
        while (true) {
            RemovalNotification<K, V> poll = this.removalNotificationQueue.poll();
            if (poll == null) {
                return;
            }
            try {
                this.removalListener.onRemoval(poll);
            } catch (Throwable th) {
                logger.log(Level.WARNING, "Exception thrown by removal listener", th);
            }
        }
    }

    boolean refreshes() {
        return this.refreshNanos > 0;
    }

    Segment<K, V> segmentFor(int i6) {
        return this.segments[(i6 >>> this.segmentShift) & this.segmentMask];
    }

    boolean usesKeyReferences() {
        return this.keyStrength != Strength.STRONG;
    }

    boolean usesValueReferences() {
        return this.valueStrength != Strength.STRONG;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Values values = new Values(this);
        this.values = values;
        return values;
    }

    LocalCache(CacheBuilder<? super K, ? super V> cacheBuilder, @NullableDecl CacheLoader<? super K, V> cacheLoader) {
        Queue<RemovalNotification<K, V>> concurrentLinkedQueue;
        this.concurrencyLevel = Math.min(cacheBuilder.getConcurrencyLevel(), 65536);
        Strength keyStrength = cacheBuilder.getKeyStrength();
        this.keyStrength = keyStrength;
        this.valueStrength = cacheBuilder.getValueStrength();
        this.keyEquivalence = cacheBuilder.getKeyEquivalence();
        this.valueEquivalence = cacheBuilder.getValueEquivalence();
        long maximumWeight = cacheBuilder.getMaximumWeight();
        this.maxWeight = maximumWeight;
        this.weigher = (Weigher<K, V>) cacheBuilder.getWeigher();
        this.expireAfterAccessNanos = cacheBuilder.getExpireAfterAccessNanos();
        this.expireAfterWriteNanos = cacheBuilder.getExpireAfterWriteNanos();
        this.refreshNanos = cacheBuilder.getRefreshNanos();
        CacheBuilder.NullListener nullListener = (RemovalListener<K, V>) cacheBuilder.getRemovalListener();
        this.removalListener = nullListener;
        if (nullListener == CacheBuilder.NullListener.INSTANCE) {
            concurrentLinkedQueue = discardingQueue();
        } else {
            concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        }
        this.removalNotificationQueue = concurrentLinkedQueue;
        this.ticker = cacheBuilder.getTicker(recordsTime());
        this.entryFactory = EntryFactory.getFactory(keyStrength, usesAccessEntries(), usesWriteEntries());
        this.globalStatsCounter = cacheBuilder.getStatsCounterSupplier().get();
        this.defaultLoader = cacheLoader;
        int min = Math.min(cacheBuilder.getInitialCapacity(), 1073741824);
        if (evictsBySize() && !customWeigher()) {
            min = (int) Math.min(min, maximumWeight);
        }
        int i6 = 0;
        int i7 = 1;
        int i8 = 1;
        int i9 = 0;
        while (i8 < this.concurrencyLevel && (!evictsBySize() || i8 * 20 <= this.maxWeight)) {
            i9++;
            i8 <<= 1;
        }
        this.segmentShift = 32 - i9;
        this.segmentMask = i8 - 1;
        this.segments = newSegmentArray(i8);
        int i10 = min / i8;
        while (i7 < (i10 * i8 < min ? i10 + 1 : i10)) {
            i7 <<= 1;
        }
        if (evictsBySize()) {
            long j6 = this.maxWeight;
            long j7 = i8;
            long j8 = (j6 / j7) + 1;
            long j9 = j6 % j7;
            while (true) {
                Segment<K, V>[] segmentArr = this.segments;
                if (i6 < segmentArr.length) {
                    if (i6 == j9) {
                        j8--;
                    }
                    segmentArr[i6] = createSegment(i7, j8, cacheBuilder.getStatsCounterSupplier().get());
                    i6++;
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                Segment<K, V>[] segmentArr2 = this.segments;
                if (i6 < segmentArr2.length) {
                    segmentArr2[i6] = createSegment(i7, -1L, cacheBuilder.getStatsCounterSupplier().get());
                    i6++;
                } else {
                    return;
                }
            }
        }
    }

    static <K, V> void connectAccessOrder(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextInAccessQueue(referenceEntry2);
        referenceEntry2.setPreviousInAccessQueue(referenceEntry);
    }

    static <K, V> void connectWriteOrder(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextInWriteQueue(referenceEntry2);
        referenceEntry2.setPreviousInWriteQueue(referenceEntry);
    }

    static <K, V> void nullifyAccessOrder(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry<K, V> nullEntry = nullEntry();
        referenceEntry.setNextInAccessQueue(nullEntry);
        referenceEntry.setPreviousInAccessQueue(nullEntry);
    }

    static <K, V> void nullifyWriteOrder(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry<K, V> nullEntry = nullEntry();
        referenceEntry.setNextInWriteQueue(nullEntry);
        referenceEntry.setPreviousInWriteQueue(nullEntry);
    }

    @VisibleForTesting
    ReferenceEntry<K, V> copyEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        return segmentFor(referenceEntry.getHash()).copyEntry(referenceEntry, referenceEntry2);
    }

    boolean expires() {
        if (!expiresAfterWrite() && !expiresAfterAccess()) {
            return false;
        }
        return true;
    }

    V get(K k6, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        int hash = hash(Preconditions.checkNotNull(k6));
        return segmentFor(hash).get(k6, hash, cacheLoader);
    }

    /* JADX WARN: Multi-variable type inference failed */
    ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
        LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
        LinkedHashSet newLinkedHashSet = Sets.newLinkedHashSet();
        int i6 = 0;
        int i7 = 0;
        for (K k6 : iterable) {
            Object obj = get(k6);
            if (!newLinkedHashMap.containsKey(k6)) {
                newLinkedHashMap.put(k6, obj);
                if (obj == null) {
                    i7++;
                    newLinkedHashSet.add(k6);
                } else {
                    i6++;
                }
            }
        }
        try {
            if (!newLinkedHashSet.isEmpty()) {
                try {
                    Map loadAll = loadAll(newLinkedHashSet, this.defaultLoader);
                    for (Object obj2 : newLinkedHashSet) {
                        Object obj3 = loadAll.get(obj2);
                        if (obj3 != null) {
                            newLinkedHashMap.put(obj2, obj3);
                        } else {
                            throw new CacheLoader.InvalidCacheLoadException("loadAll failed to return a value for " + obj2);
                        }
                    }
                } catch (CacheLoader.UnsupportedLoadingOperationException unused) {
                    for (Object obj4 : newLinkedHashSet) {
                        i7--;
                        newLinkedHashMap.put(obj4, get(obj4, this.defaultLoader));
                    }
                }
            }
            ImmutableMap<K, V> copyOf = ImmutableMap.copyOf((Map) newLinkedHashMap);
            this.globalStatsCounter.recordHits(i6);
            this.globalStatsCounter.recordMisses(i7);
            return copyOf;
        } catch (Throwable th) {
            this.globalStatsCounter.recordHits(i6);
            this.globalStatsCounter.recordMisses(i7);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
        LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
        int i6 = 0;
        int i7 = 0;
        for (Object obj : iterable) {
            V v5 = get(obj);
            if (v5 == null) {
                i7++;
            } else {
                newLinkedHashMap.put(obj, v5);
                i6++;
            }
        }
        this.globalStatsCounter.recordHits(i6);
        this.globalStatsCounter.recordMisses(i7);
        return ImmutableMap.copyOf((Map) newLinkedHashMap);
    }

    @NullableDecl
    public V getIfPresent(Object obj) {
        int hash = hash(Preconditions.checkNotNull(obj));
        V v5 = segmentFor(hash).get(obj, hash);
        if (v5 == null) {
            this.globalStatsCounter.recordMisses(1);
            return v5;
        }
        this.globalStatsCounter.recordHits(1);
        return v5;
    }

    @NullableDecl
    V getLiveValue(ReferenceEntry<K, V> referenceEntry, long j6) {
        V v5;
        if (referenceEntry.getKey() == null || (v5 = referenceEntry.getValueReference().get()) == null || isExpired(referenceEntry, j6)) {
            return null;
        }
        return v5;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @NullableDecl
    public V getOrDefault(@NullableDecl Object obj, @NullableDecl V v5) {
        V v6 = get(obj);
        if (v6 != null) {
            return v6;
        }
        return v5;
    }

    void invalidateAll(Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    boolean isExpired(ReferenceEntry<K, V> referenceEntry, long j6) {
        Preconditions.checkNotNull(referenceEntry);
        if (expiresAfterAccess() && j6 - referenceEntry.getAccessTime() >= this.expireAfterAccessNanos) {
            return true;
        }
        if (expiresAfterWrite() && j6 - referenceEntry.getWriteTime() >= this.expireAfterWriteNanos) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    boolean isLive(ReferenceEntry<K, V> referenceEntry, long j6) {
        if (segmentFor(referenceEntry.getHash()).getLiveValue(referenceEntry, j6) != null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00b9  */
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.util.Map<K, V> loadAll(java.util.Set<? extends K> r7, com.google.common.cache.CacheLoader<? super K, V> r8) throws java.util.concurrent.ExecutionException {
        /*
            r6 = this;
            com.google.common.base.Preconditions.checkNotNull(r8)
            com.google.common.base.Preconditions.checkNotNull(r7)
            com.google.common.base.Stopwatch r0 = com.google.common.base.Stopwatch.createStarted()
            r1 = 1
            r2 = 0
            java.util.Map r7 = r8.loadAll(r7)     // Catch: java.lang.Throwable -> L8e java.lang.Error -> L91 java.lang.Exception -> L98 java.lang.RuntimeException -> L9f java.lang.InterruptedException -> La6 com.google.common.cache.CacheLoader.UnsupportedLoadingOperationException -> Lb4
            if (r7 == 0) goto L6c
            r0.stop()
            java.util.Set r3 = r7.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L1d:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L3c
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            if (r5 == 0) goto L3a
            if (r4 != 0) goto L36
            goto L3a
        L36:
            r6.put(r5, r4)
            goto L1d
        L3a:
            r2 = 1
            goto L1d
        L3c:
            if (r2 != 0) goto L4a
            com.google.common.cache.AbstractCache$StatsCounter r8 = r6.globalStatsCounter
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.elapsed(r1)
            r8.recordLoadSuccess(r0)
            return r7
        L4a:
            com.google.common.cache.AbstractCache$StatsCounter r7 = r6.globalStatsCounter
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.elapsed(r1)
            r7.recordLoadException(r0)
            com.google.common.cache.CacheLoader$InvalidCacheLoadException r7 = new com.google.common.cache.CacheLoader$InvalidCacheLoadException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            java.lang.String r8 = " returned null keys or values from loadAll"
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r7.<init>(r8)
            throw r7
        L6c:
            com.google.common.cache.AbstractCache$StatsCounter r7 = r6.globalStatsCounter
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.elapsed(r1)
            r7.recordLoadException(r0)
            com.google.common.cache.CacheLoader$InvalidCacheLoadException r7 = new com.google.common.cache.CacheLoader$InvalidCacheLoadException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            java.lang.String r8 = " returned null map from loadAll"
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r7.<init>(r8)
            throw r7
        L8e:
            r7 = move-exception
            r1 = 0
            goto Lb7
        L91:
            r7 = move-exception
            com.google.common.util.concurrent.ExecutionError r8 = new com.google.common.util.concurrent.ExecutionError     // Catch: java.lang.Throwable -> L8e
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L8e
            throw r8     // Catch: java.lang.Throwable -> L8e
        L98:
            r7 = move-exception
            java.util.concurrent.ExecutionException r8 = new java.util.concurrent.ExecutionException     // Catch: java.lang.Throwable -> L8e
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L8e
            throw r8     // Catch: java.lang.Throwable -> L8e
        L9f:
            r7 = move-exception
            com.google.common.util.concurrent.UncheckedExecutionException r8 = new com.google.common.util.concurrent.UncheckedExecutionException     // Catch: java.lang.Throwable -> L8e
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L8e
            throw r8     // Catch: java.lang.Throwable -> L8e
        La6:
            r7 = move-exception
            java.lang.Thread r8 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L8e
            r8.interrupt()     // Catch: java.lang.Throwable -> L8e
            java.util.concurrent.ExecutionException r8 = new java.util.concurrent.ExecutionException     // Catch: java.lang.Throwable -> L8e
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L8e
            throw r8     // Catch: java.lang.Throwable -> L8e
        Lb4:
            r7 = move-exception
            throw r7     // Catch: java.lang.Throwable -> Lb6
        Lb6:
            r7 = move-exception
        Lb7:
            if (r1 != 0) goto Lc4
            com.google.common.cache.AbstractCache$StatsCounter r8 = r6.globalStatsCounter
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.elapsed(r1)
            r8.recordLoadException(r0)
        Lc4:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.loadAll(java.util.Set, com.google.common.cache.CacheLoader):java.util.Map");
    }

    @VisibleForTesting
    ReferenceEntry<K, V> newEntry(K k6, int i6, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
        Segment<K, V> segmentFor = segmentFor(i6);
        segmentFor.lock();
        try {
            return segmentFor.newEntry(k6, i6, referenceEntry);
        } finally {
            segmentFor.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @VisibleForTesting
    ValueReference<K, V> newValueReference(ReferenceEntry<K, V> referenceEntry, V v5, int i6) {
        return this.valueStrength.referenceValue(segmentFor(referenceEntry.getHash()), referenceEntry, Preconditions.checkNotNull(v5), i6);
    }

    @Override // java.util.AbstractMap, java.util.Map
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
    public V putIfAbsent(K k6, V v5) {
        Preconditions.checkNotNull(k6);
        Preconditions.checkNotNull(v5);
        int hash = hash(k6);
        return segmentFor(hash).put(k6, hash, v5, true);
    }

    void reclaimKey(ReferenceEntry<K, V> referenceEntry) {
        int hash = referenceEntry.getHash();
        segmentFor(hash).reclaimKey(referenceEntry, hash);
    }

    void reclaimValue(ValueReference<K, V> valueReference) {
        ReferenceEntry<K, V> entry = valueReference.getEntry();
        int hash = entry.getHash();
        segmentFor(hash).reclaimValue(entry.getKey(), hash, valueReference);
    }

    boolean recordsAccess() {
        return expiresAfterAccess();
    }

    boolean recordsTime() {
        if (!recordsWrite() && !recordsAccess()) {
            return false;
        }
        return true;
    }

    boolean recordsWrite() {
        if (!expiresAfterWrite() && !refreshes()) {
            return false;
        }
        return true;
    }

    void refresh(K k6) {
        int hash = hash(Preconditions.checkNotNull(k6));
        segmentFor(hash).refresh(k6, hash, this.defaultLoader, false);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash, obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return Ints.saturatedCast(longSize());
    }

    boolean usesAccessEntries() {
        if (!usesAccessQueue() && !recordsAccess()) {
            return false;
        }
        return true;
    }

    boolean usesAccessQueue() {
        if (!expiresAfterAccess() && !evictsBySize()) {
            return false;
        }
        return true;
    }

    boolean usesWriteEntries() {
        if (!usesWriteQueue() && !recordsWrite()) {
            return false;
        }
        return true;
    }

    boolean usesWriteQueue() {
        return expiresAfterWrite();
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k6, V v5) {
        Preconditions.checkNotNull(k6);
        Preconditions.checkNotNull(v5);
        int hash = hash(k6);
        return segmentFor(hash).replace(k6, hash, v5);
    }
}
