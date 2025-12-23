package com.alibaba.fastjson.util;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import ms.bz.bd.c.Pgl.pblu;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AntiCollisionHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int KEY = 16777619;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int M_MASK = -2023358765;
    static final int SEED = -2128831035;
    private static final long serialVersionUID = 362498820763181265L;
    private transient Set<Map.Entry<K, V>> entrySet;
    volatile transient Set<K> keySet;
    final float loadFactor;
    volatile transient int modCount;
    final int random;
    transient int size;
    transient Entry<K, V>[] table;
    int threshold;
    volatile transient Collection<V> values;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.alibaba.fastjson.util.AntiCollisionHashMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class Entry<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        Entry<K, V> next;
        V value;

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K key = getKey();
            Object key2 = entry.getKey();
            if (key == key2 || (key != null && key.equals(key2))) {
                V value = getValue();
                Object value2 = entry.getValue();
                if (value == value2) {
                    return true;
                }
                if (value != null && value.equals(value2)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            K k6 = this.key;
            int hashCode = k6 == null ? 0 : k6.hashCode();
            V v5 = this.value;
            return hashCode ^ (v5 != null ? v5.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v5) {
            V v6 = this.value;
            this.value = v5;
            return v6;
        }

        public final String toString() {
            return getKey() + ContainerUtils.KEY_VALUE_DELIMITER + getValue();
        }

        Entry(int i6, K k6, V v5, Entry<K, V> entry) {
            this.value = v5;
            this.next = entry;
            this.key = k6;
            this.hash = i6;
        }

        void recordAccess(AntiCollisionHashMap<K, V> antiCollisionHashMap) {
        }

        void recordRemoval(AntiCollisionHashMap<K, V> antiCollisionHashMap) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class EntryIterator extends AntiCollisionHashMap<K, V>.HashIterator<Map.Entry<K, V>> {
        private EntryIterator() {
            super();
        }

        /* synthetic */ EntryIterator(AntiCollisionHashMap antiCollisionHashMap, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        private EntrySet() {
        }

        /* synthetic */ EntrySet(AntiCollisionHashMap antiCollisionHashMap, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AntiCollisionHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Entry<K, V> entry2 = AntiCollisionHashMap.this.getEntry(entry.getKey());
            return entry2 != null && entry2.equals(entry);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return AntiCollisionHashMap.this.newEntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return AntiCollisionHashMap.this.removeMapping(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AntiCollisionHashMap.this.size;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private abstract class HashIterator<E> implements Iterator<E> {
        Entry<K, V> current;
        int expectedModCount;
        int index;
        Entry<K, V> next;

        HashIterator() {
            Entry<K, V> entry;
            this.expectedModCount = AntiCollisionHashMap.this.modCount;
            if (AntiCollisionHashMap.this.size > 0) {
                Entry<K, V>[] entryArr = AntiCollisionHashMap.this.table;
                do {
                    int i6 = this.index;
                    if (i6 >= entryArr.length) {
                        return;
                    }
                    this.index = i6 + 1;
                    entry = entryArr[i6];
                    this.next = entry;
                } while (entry == null);
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.next != null;
        }

        final Entry<K, V> nextEntry() {
            Entry<K, V> entry;
            if (AntiCollisionHashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            Entry<K, V> entry2 = this.next;
            if (entry2 == null) {
                throw new NoSuchElementException();
            }
            Entry<K, V> entry3 = entry2.next;
            this.next = entry3;
            if (entry3 == null) {
                Entry<K, V>[] entryArr = AntiCollisionHashMap.this.table;
                do {
                    int i6 = this.index;
                    if (i6 >= entryArr.length) {
                        break;
                    }
                    this.index = i6 + 1;
                    entry = entryArr[i6];
                    this.next = entry;
                } while (entry == null);
            }
            this.current = entry2;
            return entry2;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.current == null) {
                throw new IllegalStateException();
            }
            if (AntiCollisionHashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            K k6 = this.current.key;
            this.current = null;
            AntiCollisionHashMap.this.removeEntryForKey(k6);
            this.expectedModCount = AntiCollisionHashMap.this.modCount;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class KeyIterator extends AntiCollisionHashMap<K, V>.HashIterator<K> {
        private KeyIterator() {
            super();
        }

        /* synthetic */ KeyIterator(AntiCollisionHashMap antiCollisionHashMap, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class KeySet extends AbstractSet<K> {
        private KeySet() {
        }

        /* synthetic */ KeySet(AntiCollisionHashMap antiCollisionHashMap, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AntiCollisionHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return AntiCollisionHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return AntiCollisionHashMap.this.newKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return AntiCollisionHashMap.this.removeEntryForKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AntiCollisionHashMap.this.size;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class ValueIterator extends AntiCollisionHashMap<K, V>.HashIterator<V> {
        private ValueIterator() {
            super();
        }

        /* synthetic */ ValueIterator(AntiCollisionHashMap antiCollisionHashMap, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Iterator
        public V next() {
            return nextEntry().value;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class Values extends AbstractCollection<V> {
        private Values() {
        }

        /* synthetic */ Values(AntiCollisionHashMap antiCollisionHashMap, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AntiCollisionHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return AntiCollisionHashMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return AntiCollisionHashMap.this.newValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AntiCollisionHashMap.this.size;
        }
    }

    public AntiCollisionHashMap(int i6, float f6) {
        this.keySet = null;
        this.values = null;
        this.random = new Random().nextInt(pblu.f50357u);
        this.entrySet = null;
        if (i6 < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + i6);
        }
        i6 = i6 > 1073741824 ? 1073741824 : i6;
        if (f6 <= 0.0f || Float.isNaN(f6)) {
            throw new IllegalArgumentException("Illegal load factor: " + f6);
        }
        int i7 = 1;
        while (i7 < i6) {
            i7 <<= 1;
        }
        this.loadFactor = f6;
        this.threshold = (int) (i7 * f6);
        this.table = new Entry[i7];
        init();
    }

    @Override // java.util.AbstractMap
    public Object clone() {
        AntiCollisionHashMap antiCollisionHashMap;
        try {
            antiCollisionHashMap = (AntiCollisionHashMap) super.clone();
        } catch (CloneNotSupportedException unused) {
            antiCollisionHashMap = null;
        }
        antiCollisionHashMap.table = new Entry[this.table.length];
        antiCollisionHashMap.entrySet = null;
        antiCollisionHashMap.modCount = 0;
        antiCollisionHashMap.size = 0;
        antiCollisionHashMap.init();
        antiCollisionHashMap.putAllForCreate(this);
        return antiCollisionHashMap;
    }

    private boolean containsNullValue() {
        for (Entry<K, V> entry : this.table) {
            for (; entry != null; entry = entry.next) {
                if (entry.value == null) {
                    return true;
                }
            }
        }
        return false;
    }

    private Set<Map.Entry<K, V>> entrySet0() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet(this, null);
        this.entrySet = entrySet;
        return entrySet;
    }

    private V getForNullKey() {
        for (Entry<K, V> entry = this.table[0]; entry != null; entry = entry.next) {
            if (entry.key == null) {
                return entry.value;
            }
        }
        return null;
    }

    static int hash(int i6) {
        int i7 = i6 * i6;
        int i8 = i7 ^ ((i7 >>> 20) ^ (i7 >>> 12));
        return (i8 >>> 4) ^ ((i8 >>> 7) ^ i8);
    }

    static int indexFor(int i6, int i7) {
        return i6 & (i7 - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void putForCreate(K k6, V v5) {
        K k7;
        int hash = k6 == 0 ? 0 : k6 instanceof String ? hash(hashString((String) k6)) : hash(k6.hashCode());
        int indexFor = indexFor(hash, this.table.length);
        for (Entry<K, V> entry = this.table[indexFor]; entry != null; entry = entry.next) {
            if (entry.hash == hash && ((k7 = entry.key) == k6 || (k6 != 0 && k6.equals(k7)))) {
                entry.value = v5;
                return;
            }
        }
        createEntry(hash, k6, v5, indexFor);
    }

    private V putForNullKey(V v5) {
        for (Entry<K, V> entry = this.table[0]; entry != null; entry = entry.next) {
            if (entry.key == null) {
                V v6 = entry.value;
                entry.value = v5;
                entry.recordAccess(this);
                return v6;
            }
        }
        this.modCount++;
        addEntry(0, null, v5, 0);
        return null;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Iterator<Map.Entry<K, V>> it = this.size > 0 ? entrySet0().iterator() : null;
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.table.length);
        objectOutputStream.writeInt(this.size);
        if (it != null) {
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                objectOutputStream.writeObject(next.getKey());
                objectOutputStream.writeObject(next.getValue());
            }
        }
    }

    void addEntry(int i6, K k6, V v5, int i7) {
        Entry<K, V>[] entryArr = this.table;
        entryArr[i7] = new Entry<>(i6, k6, v5, entryArr[i7]);
        int i8 = this.size;
        this.size = i8 + 1;
        if (i8 >= this.threshold) {
            resize(this.table.length * 2);
        }
    }

    int capacity() {
        return this.table.length;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.modCount++;
        Entry<K, V>[] entryArr = this.table;
        for (int i6 = 0; i6 < entryArr.length; i6++) {
            entryArr[i6] = null;
        }
        this.size = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            return containsNullValue();
        }
        for (Entry<K, V> entry : this.table) {
            for (; entry != null; entry = entry.next) {
                if (obj.equals(entry.value)) {
                    return true;
                }
            }
        }
        return false;
    }

    void createEntry(int i6, K k6, V v5, int i7) {
        Entry<K, V>[] entryArr = this.table;
        entryArr[i7] = new Entry<>(i6, k6, v5, entryArr[i7]);
        this.size++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        K k6;
        if (obj == null) {
            return getForNullKey();
        }
        int hash = obj instanceof String ? hash(hashString((String) obj)) : hash(obj.hashCode());
        Entry<K, V>[] entryArr = this.table;
        for (Entry<K, V> entry = entryArr[indexFor(hash, entryArr.length)]; entry != null; entry = entry.next) {
            if (entry.hash == hash && ((k6 = entry.key) == obj || obj.equals(k6))) {
                return entry.value;
            }
        }
        return null;
    }

    final Entry<K, V> getEntry(Object obj) {
        K k6;
        int hash = obj == null ? 0 : obj instanceof String ? hash(hashString((String) obj)) : hash(obj.hashCode());
        Entry<K, V>[] entryArr = this.table;
        for (Entry<K, V> entry = entryArr[indexFor(hash, entryArr.length)]; entry != null; entry = entry.next) {
            if (entry.hash == hash && ((k6 = entry.key) == obj || (obj != null && obj.equals(k6)))) {
                return entry;
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet(this, null);
        this.keySet = keySet;
        return keySet;
    }

    float loadFactor() {
        return this.loadFactor;
    }

    Iterator<Map.Entry<K, V>> newEntryIterator() {
        return new EntryIterator(this, null);
    }

    Iterator<K> newKeyIterator() {
        return new KeyIterator(this, null);
    }

    Iterator<V> newValueIterator() {
        return new ValueIterator(this, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k6, V v5) {
        K k7;
        if (k6 == 0) {
            return putForNullKey(v5);
        }
        int hash = k6 instanceof String ? hash(hashString((String) k6)) : hash(k6.hashCode());
        int indexFor = indexFor(hash, this.table.length);
        for (Entry<K, V> entry = this.table[indexFor]; entry != null; entry = entry.next) {
            if (entry.hash == hash && ((k7 = entry.key) == k6 || k6.equals(k7))) {
                V v6 = entry.value;
                entry.value = v5;
                entry.recordAccess(this);
                return v6;
            }
        }
        this.modCount++;
        addEntry(hash, k6, v5, indexFor);
        return null;
    }

    final Entry<K, V> removeEntryForKey(Object obj) {
        K k6;
        int hash = obj == null ? 0 : obj instanceof String ? hash(hashString((String) obj)) : hash(obj.hashCode());
        int indexFor = indexFor(hash, this.table.length);
        Entry<K, V> entry = this.table[indexFor];
        Entry<K, V> entry2 = entry;
        while (entry != null) {
            Entry<K, V> entry3 = entry.next;
            if (entry.hash == hash && ((k6 = entry.key) == obj || (obj != null && obj.equals(k6)))) {
                this.modCount++;
                this.size--;
                if (entry2 == entry) {
                    this.table[indexFor] = entry3;
                } else {
                    entry2.next = entry3;
                }
                entry.recordRemoval(this);
                return entry;
            }
            entry2 = entry;
            entry = entry3;
        }
        return entry;
    }

    final Entry<K, V> removeMapping(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return null;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        int hash = key == null ? 0 : key instanceof String ? hash(hashString((String) key)) : hash(key.hashCode());
        int indexFor = indexFor(hash, this.table.length);
        Entry<K, V> entry2 = this.table[indexFor];
        Entry<K, V> entry3 = entry2;
        while (entry2 != null) {
            Entry<K, V> entry4 = entry2.next;
            if (entry2.hash == hash && entry2.equals(entry)) {
                this.modCount++;
                this.size--;
                if (entry3 == entry2) {
                    this.table[indexFor] = entry4;
                } else {
                    entry3.next = entry4;
                }
                entry2.recordRemoval(this);
                return entry2;
            }
            entry3 = entry2;
            entry2 = entry4;
        }
        return entry2;
    }

    void resize(int i6) {
        if (this.table.length == 1073741824) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        Entry<K, V>[] entryArr = new Entry[i6];
        transfer(entryArr);
        this.table = entryArr;
        this.threshold = (int) (i6 * this.loadFactor);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    void transfer(Entry[] entryArr) {
        Entry<K, V>[] entryArr2 = this.table;
        int length = entryArr.length;
        for (int i6 = 0; i6 < entryArr2.length; i6++) {
            Entry<K, V> entry = entryArr2[i6];
            if (entry != null) {
                entryArr2[i6] = null;
                while (true) {
                    Entry<K, V> entry2 = entry.next;
                    int indexFor = indexFor(entry.hash, length);
                    entry.next = entryArr[indexFor];
                    entryArr[indexFor] = entry;
                    if (entry2 == null) {
                        break;
                    } else {
                        entry = entry2;
                    }
                }
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Values values = new Values(this, null);
        this.values = values;
        return values;
    }

    private int hashString(String str) {
        int i6 = this.random * SEED;
        for (int i7 = 0; i7 < str.length(); i7++) {
            i6 = (i6 * KEY) ^ str.charAt(i7);
        }
        return ((i6 >> 1) ^ i6) & M_MASK;
    }

    private void putAllForCreate(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            putForCreate(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.table = new Entry[objectInputStream.readInt()];
        init();
        int readInt = objectInputStream.readInt();
        for (int i6 = 0; i6 < readInt; i6++) {
            putForCreate(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (getEntry(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return entrySet0();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        int size = map.size();
        if (size != 0) {
            if (size > this.threshold) {
                int i6 = (int) ((size / this.loadFactor) + 1.0f);
                if (i6 > 1073741824) {
                    i6 = 1073741824;
                }
                int length = this.table.length;
                while (length < i6) {
                    length <<= 1;
                }
                if (length > this.table.length) {
                    resize(length);
                }
            }
            for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Entry<K, V> removeEntryForKey = removeEntryForKey(obj);
        if (removeEntryForKey == null) {
            return null;
        }
        return removeEntryForKey.value;
    }

    public AntiCollisionHashMap(int i6) {
        this(i6, 0.75f);
    }

    public AntiCollisionHashMap() {
        this.keySet = null;
        this.values = null;
        this.random = new Random().nextInt(pblu.f50357u);
        this.entrySet = null;
        this.loadFactor = 0.75f;
        this.threshold = 12;
        this.table = new Entry[16];
        init();
    }

    void init() {
    }

    public AntiCollisionHashMap(Map<? extends K, ? extends V> map) {
        this(Math.max(((int) (map.size() / 0.75f)) + 1, 16), 0.75f);
        putAllForCreate(map);
    }
}
