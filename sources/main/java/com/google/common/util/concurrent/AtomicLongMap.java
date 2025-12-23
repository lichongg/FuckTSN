package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class AtomicLongMap<K> implements Serializable {

    @MonotonicNonNullDecl
    private transient Map<K, Long> asMap;
    private final ConcurrentHashMap<K, AtomicLong> map;

    public static <K> AtomicLongMap<K> create() {
        return new AtomicLongMap<>(new ConcurrentHashMap());
    }

    @CanIgnoreReturnValue
    public long remove(K k6) {
        long j6;
        AtomicLong atomicLong = this.map.get(k6);
        if (atomicLong == null) {
            return 0L;
        }
        do {
            j6 = atomicLong.get();
            if (j6 == 0) {
                break;
            }
        } while (!atomicLong.compareAndSet(j6, 0L));
        this.map.remove(k6, atomicLong);
        return j6;
    }

    boolean replace(K k6, long j6, long j7) {
        if (j6 == 0) {
            return putIfAbsent(k6, j7) == 0;
        }
        AtomicLong atomicLong = this.map.get(k6);
        if (atomicLong == null) {
            return false;
        }
        return atomicLong.compareAndSet(j6, j7);
    }

    public static <K> AtomicLongMap<K> create(Map<? extends K, ? extends Long> map) {
        AtomicLongMap<K> create = create();
        create.putAll(map);
        return create;
    }

    private Map<K, Long> createAsMap() {
        return Collections.unmodifiableMap(Maps.transformValues(this.map, new Function<AtomicLong, Long>() { // from class: com.google.common.util.concurrent.AtomicLongMap.1
            @Override // com.google.common.base.Function
            public Long apply(AtomicLong atomicLong) {
                return Long.valueOf(atomicLong.get());
            }
        }));
    }

    @CanIgnoreReturnValue
    public long addAndGet(K k6, long j6) {
        AtomicLong atomicLong;
        long j7;
        long j8;
        do {
            atomicLong = this.map.get(k6);
            if (atomicLong == null && (atomicLong = this.map.putIfAbsent(k6, new AtomicLong(j6))) == null) {
                break;
            }
            do {
                j7 = atomicLong.get();
                if (j7 != 0) {
                    j8 = j7 + j6;
                }
            } while (!atomicLong.compareAndSet(j7, j8));
            return j8;
        } while (!this.map.replace(k6, atomicLong, new AtomicLong(j6)));
        return j6;
    }

    public Map<K, Long> asMap() {
        Map<K, Long> map = this.asMap;
        if (map != null) {
            return map;
        }
        Map<K, Long> createAsMap = createAsMap();
        this.asMap = createAsMap;
        return createAsMap;
    }

    public void clear() {
        this.map.clear();
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @CanIgnoreReturnValue
    public long decrementAndGet(K k6) {
        return addAndGet(k6, -1L);
    }

    public long get(K k6) {
        AtomicLong atomicLong = this.map.get(k6);
        if (atomicLong == null) {
            return 0L;
        }
        return atomicLong.get();
    }

    @CanIgnoreReturnValue
    public long getAndAdd(K k6, long j6) {
        AtomicLong atomicLong;
        long j7;
        do {
            atomicLong = this.map.get(k6);
            if (atomicLong == null && (atomicLong = this.map.putIfAbsent(k6, new AtomicLong(j6))) == null) {
                return 0L;
            }
            do {
                j7 = atomicLong.get();
                if (j7 == 0) {
                }
            } while (!atomicLong.compareAndSet(j7, j7 + j6));
            return j7;
        } while (!this.map.replace(k6, atomicLong, new AtomicLong(j6)));
        return 0L;
    }

    @CanIgnoreReturnValue
    public long getAndDecrement(K k6) {
        return getAndAdd(k6, -1L);
    }

    @CanIgnoreReturnValue
    public long getAndIncrement(K k6) {
        return getAndAdd(k6, 1L);
    }

    @CanIgnoreReturnValue
    public long incrementAndGet(K k6) {
        return addAndGet(k6, 1L);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @CanIgnoreReturnValue
    public long put(K k6, long j6) {
        AtomicLong atomicLong;
        long j7;
        do {
            atomicLong = this.map.get(k6);
            if (atomicLong == null && (atomicLong = this.map.putIfAbsent(k6, new AtomicLong(j6))) == null) {
                return 0L;
            }
            do {
                j7 = atomicLong.get();
                if (j7 == 0) {
                }
            } while (!atomicLong.compareAndSet(j7, j6));
            return j7;
        } while (!this.map.replace(k6, atomicLong, new AtomicLong(j6)));
        return 0L;
    }

    long putIfAbsent(K k6, long j6) {
        AtomicLong atomicLong;
        do {
            atomicLong = this.map.get(k6);
            if (atomicLong == null && (atomicLong = this.map.putIfAbsent(k6, new AtomicLong(j6))) == null) {
                return 0L;
            }
            long j7 = atomicLong.get();
            if (j7 != 0) {
                return j7;
            }
        } while (!this.map.replace(k6, atomicLong, new AtomicLong(j6)));
        return 0L;
    }

    public void removeAllZeros() {
        Iterator<Map.Entry<K, AtomicLong>> it = this.map.entrySet().iterator();
        while (it.hasNext()) {
            AtomicLong value = it.next().getValue();
            if (value != null && value.get() == 0) {
                it.remove();
            }
        }
    }

    @CanIgnoreReturnValue
    @Beta
    public boolean removeIfZero(K k6) {
        return remove(k6, 0L);
    }

    public int size() {
        return this.map.size();
    }

    public long sum() {
        Iterator<AtomicLong> it = this.map.values().iterator();
        long j6 = 0;
        while (it.hasNext()) {
            j6 += it.next().get();
        }
        return j6;
    }

    public String toString() {
        return this.map.toString();
    }

    private AtomicLongMap(ConcurrentHashMap<K, AtomicLong> concurrentHashMap) {
        this.map = (ConcurrentHashMap) Preconditions.checkNotNull(concurrentHashMap);
    }

    public void putAll(Map<? extends K, ? extends Long> map) {
        for (Map.Entry<? extends K, ? extends Long> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue().longValue());
        }
    }

    boolean remove(K k6, long j6) {
        AtomicLong atomicLong = this.map.get(k6);
        if (atomicLong == null) {
            return false;
        }
        long j7 = atomicLong.get();
        if (j7 != j6) {
            return false;
        }
        if (j7 != 0 && !atomicLong.compareAndSet(j7, 0L)) {
            return false;
        }
        this.map.remove(k6, atomicLong);
        return true;
    }
}
