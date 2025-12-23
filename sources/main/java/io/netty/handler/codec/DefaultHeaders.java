package io.netty.handler.codec;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.handler.codec.Headers;
import io.netty.util.HashingStrategy;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultHeaders<K, V, T extends Headers<K, V, T>> implements Headers<K, V, T> {
    static final int HASH_CODE_SEED = -1028477387;
    private final HeaderEntry<K, V>[] entries;
    private final byte hashMask;
    private final HashingStrategy<K> hashingStrategy;
    protected final HeaderEntry<K, V> head;
    private final NameValidator<K> nameValidator;
    int size;
    private final ValueConverter<V> valueConverter;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.DefaultHeaders$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class HeaderEntry<K, V> implements Map.Entry<K, V> {
        protected HeaderEntry<K, V> after;
        protected HeaderEntry<K, V> before;
        protected final int hash;
        protected final K key;
        protected HeaderEntry<K, V> next;
        protected V value;

        protected HeaderEntry(int i6, K k6) {
            this.hash = i6;
            this.key = k6;
        }

        public final HeaderEntry<K, V> after() {
            return this.after;
        }

        public final HeaderEntry<K, V> before() {
            return this.before;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (getKey() != null ? getKey().equals(entry.getKey()) : entry.getKey() == null) {
                if (getValue() == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (getValue().equals(entry.getValue())) {
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
        public int hashCode() {
            K k6 = this.key;
            int hashCode = k6 == null ? 0 : k6.hashCode();
            V v5 = this.value;
            return hashCode ^ (v5 != null ? v5.hashCode() : 0);
        }

        protected final void pointNeighborsToThis() {
            this.before.after = this;
            this.after.before = this;
        }

        protected void remove() {
            HeaderEntry<K, V> headerEntry = this.before;
            headerEntry.after = this.after;
            this.after.before = headerEntry;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v5) {
            ObjectUtil.checkNotNull(v5, "value");
            V v6 = this.value;
            this.value = v5;
            return v6;
        }

        public final String toString() {
            return this.key.toString() + '=' + this.value.toString();
        }

        HeaderEntry(int i6, K k6, V v5, HeaderEntry<K, V> headerEntry, HeaderEntry<K, V> headerEntry2) {
            this.hash = i6;
            this.key = k6;
            this.value = v5;
            this.next = headerEntry;
            this.after = headerEntry2;
            this.before = headerEntry2.before;
            pointNeighborsToThis();
        }

        HeaderEntry() {
            this.hash = -1;
            this.key = null;
            this.after = this;
            this.before = this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class HeaderIterator implements Iterator<Map.Entry<K, V>> {
        private HeaderEntry<K, V> current;

        private HeaderIterator() {
            this.current = DefaultHeaders.this.head;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.current.after != DefaultHeaders.this.head;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            HeaderEntry<K, V> headerEntry = this.current.after;
            this.current = headerEntry;
            if (headerEntry != DefaultHeaders.this.head) {
                return headerEntry;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("read only");
        }

        /* synthetic */ HeaderIterator(DefaultHeaders defaultHeaders, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface NameValidator<K> {
        public static final NameValidator NOT_NULL = new NameValidator() { // from class: io.netty.handler.codec.DefaultHeaders.NameValidator.1
            @Override // io.netty.handler.codec.DefaultHeaders.NameValidator
            public void validateName(Object obj) {
                ObjectUtil.checkNotNull(obj, CommonNetImpl.NAME);
            }
        };

        void validateName(K k6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class ValueIterator implements Iterator<V> {
        private final int hash;
        private final K name;
        private HeaderEntry<K, V> next;
        private HeaderEntry<K, V> previous;
        private HeaderEntry<K, V> removalPrevious;

        ValueIterator(K k6) {
            this.name = (K) ObjectUtil.checkNotNull(k6, CommonNetImpl.NAME);
            int hashCode = DefaultHeaders.this.hashingStrategy.hashCode(k6);
            this.hash = hashCode;
            calculateNext(DefaultHeaders.this.entries[DefaultHeaders.this.index(hashCode)]);
        }

        private void calculateNext(HeaderEntry<K, V> headerEntry) {
            while (headerEntry != null) {
                if (headerEntry.hash == this.hash && DefaultHeaders.this.hashingStrategy.equals(this.name, headerEntry.key)) {
                    this.next = headerEntry;
                    return;
                }
                headerEntry = headerEntry.next;
            }
            this.next = null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            HeaderEntry<K, V> headerEntry = this.previous;
            if (headerEntry == null) {
                throw new IllegalStateException();
            }
            this.removalPrevious = DefaultHeaders.this.remove0(headerEntry, this.removalPrevious);
            this.previous = null;
        }

        @Override // java.util.Iterator
        public V next() {
            if (hasNext()) {
                HeaderEntry<K, V> headerEntry = this.previous;
                if (headerEntry != null) {
                    this.removalPrevious = headerEntry;
                }
                HeaderEntry<K, V> headerEntry2 = this.next;
                this.previous = headerEntry2;
                calculateNext(headerEntry2.next);
                return this.previous.value;
            }
            throw new NoSuchElementException();
        }
    }

    public DefaultHeaders(ValueConverter<V> valueConverter) {
        this(HashingStrategy.JAVA_HASHER, valueConverter);
    }

    private V remove0(int i6, int i7, K k6) {
        HeaderEntry<K, V> headerEntry = this.entries[i7];
        V v5 = null;
        if (headerEntry == null) {
            return null;
        }
        for (HeaderEntry<K, V> headerEntry2 = headerEntry.next; headerEntry2 != null; headerEntry2 = headerEntry.next) {
            if (headerEntry2.hash == i6 && this.hashingStrategy.equals(k6, headerEntry2.key)) {
                v5 = headerEntry2.value;
                headerEntry.next = headerEntry2.next;
                headerEntry2.remove();
                this.size--;
            } else {
                headerEntry = headerEntry2;
            }
        }
        HeaderEntry<K, V> headerEntry3 = this.entries[i7];
        if (headerEntry3.hash == i6 && this.hashingStrategy.equals(k6, headerEntry3.key)) {
            if (v5 == null) {
                v5 = headerEntry3.value;
            }
            this.entries[i7] = headerEntry3.next;
            headerEntry3.remove();
            this.size--;
        }
        return v5;
    }

    @Override // io.netty.handler.codec.Headers
    public T add(K k6, V v5) {
        this.nameValidator.validateName(k6);
        ObjectUtil.checkNotNull(v5, "value");
        int hashCode = this.hashingStrategy.hashCode(k6);
        add0(hashCode, index(hashCode), k6, v5);
        return thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public T addObject(K k6, Object obj) {
        return add((DefaultHeaders<K, V, T>) k6, (K) this.valueConverter.convertObject(ObjectUtil.checkNotNull(obj, "value")));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean contains(K k6) {
        return get(k6) != null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Headers) {
            return equals((Headers) obj, HashingStrategy.JAVA_HASHER);
        }
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public V get(K k6) {
        ObjectUtil.checkNotNull(k6, CommonNetImpl.NAME);
        int hashCode = this.hashingStrategy.hashCode(k6);
        V v5 = null;
        for (HeaderEntry<K, V> headerEntry = this.entries[index(hashCode)]; headerEntry != null; headerEntry = headerEntry.next) {
            if (headerEntry.hash == hashCode && this.hashingStrategy.equals(k6, headerEntry.key)) {
                v5 = headerEntry.value;
            }
        }
        return v5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.handler.codec.Headers
    public V getAndRemove(K k6) {
        int hashCode = this.hashingStrategy.hashCode(k6);
        return (V) remove0(hashCode, index(hashCode), ObjectUtil.checkNotNull(k6, CommonNetImpl.NAME));
    }

    @Override // io.netty.handler.codec.Headers
    public Boolean getBoolean(K k6) {
        V v5 = get(k6);
        if (v5 != null) {
            try {
                return Boolean.valueOf(this.valueConverter.convertToBoolean(v5));
            } catch (RuntimeException unused) {
            }
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Boolean getBooleanAndRemove(K k6) {
        V andRemove = getAndRemove(k6);
        if (andRemove != null) {
            try {
                return Boolean.valueOf(this.valueConverter.convertToBoolean(andRemove));
            } catch (RuntimeException unused) {
            }
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Byte getByte(K k6) {
        V v5 = get(k6);
        if (v5 != null) {
            try {
                return Byte.valueOf(this.valueConverter.convertToByte(v5));
            } catch (RuntimeException unused) {
            }
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Byte getByteAndRemove(K k6) {
        V andRemove = getAndRemove(k6);
        if (andRemove != null) {
            try {
                return Byte.valueOf(this.valueConverter.convertToByte(andRemove));
            } catch (RuntimeException unused) {
            }
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Character getChar(K k6) {
        V v5 = get(k6);
        if (v5 != null) {
            try {
                return Character.valueOf(this.valueConverter.convertToChar(v5));
            } catch (RuntimeException unused) {
            }
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Character getCharAndRemove(K k6) {
        V andRemove = getAndRemove(k6);
        if (andRemove != null) {
            try {
                return Character.valueOf(this.valueConverter.convertToChar(andRemove));
            } catch (RuntimeException unused) {
            }
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Double getDouble(K k6) {
        V v5 = get(k6);
        if (v5 != null) {
            try {
                return Double.valueOf(this.valueConverter.convertToDouble(v5));
            } catch (RuntimeException unused) {
            }
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Double getDoubleAndRemove(K k6) {
        V andRemove = getAndRemove(k6);
        if (andRemove != null) {
            try {
                return Double.valueOf(this.valueConverter.convertToDouble(andRemove));
            } catch (RuntimeException unused) {
            }
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Float getFloat(K k6) {
        V v5 = get(k6);
        if (v5 != null) {
            try {
                return Float.valueOf(this.valueConverter.convertToFloat(v5));
            } catch (RuntimeException unused) {
            }
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Float getFloatAndRemove(K k6) {
        V andRemove = getAndRemove(k6);
        if (andRemove != null) {
            try {
                return Float.valueOf(this.valueConverter.convertToFloat(andRemove));
            } catch (RuntimeException unused) {
            }
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Integer getInt(K k6) {
        V v5 = get(k6);
        if (v5 != null) {
            try {
                return Integer.valueOf(this.valueConverter.convertToInt(v5));
            } catch (RuntimeException unused) {
            }
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Integer getIntAndRemove(K k6) {
        V andRemove = getAndRemove(k6);
        if (andRemove != null) {
            try {
                return Integer.valueOf(this.valueConverter.convertToInt(andRemove));
            } catch (RuntimeException unused) {
            }
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Long getLong(K k6) {
        V v5 = get(k6);
        if (v5 != null) {
            try {
                return Long.valueOf(this.valueConverter.convertToLong(v5));
            } catch (RuntimeException unused) {
            }
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Long getLongAndRemove(K k6) {
        V andRemove = getAndRemove(k6);
        if (andRemove != null) {
            try {
                return Long.valueOf(this.valueConverter.convertToLong(andRemove));
            } catch (RuntimeException unused) {
            }
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Short getShort(K k6) {
        V v5 = get(k6);
        if (v5 != null) {
            try {
                return Short.valueOf(this.valueConverter.convertToShort(v5));
            } catch (RuntimeException unused) {
            }
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Short getShortAndRemove(K k6) {
        V andRemove = getAndRemove(k6);
        if (andRemove != null) {
            try {
                return Short.valueOf(this.valueConverter.convertToShort(andRemove));
            } catch (RuntimeException unused) {
            }
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Long getTimeMillis(K k6) {
        V v5 = get(k6);
        if (v5 != null) {
            try {
                return Long.valueOf(this.valueConverter.convertToTimeMillis(v5));
            } catch (RuntimeException unused) {
            }
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Long getTimeMillisAndRemove(K k6) {
        V andRemove = getAndRemove(k6);
        if (andRemove != null) {
            try {
                return Long.valueOf(this.valueConverter.convertToTimeMillis(andRemove));
            } catch (RuntimeException unused) {
            }
        }
        return null;
    }

    public int hashCode() {
        return hashCode(HashingStrategy.JAVA_HASHER);
    }

    @Override // io.netty.handler.codec.Headers
    public T set(K k6, V v5) {
        this.nameValidator.validateName(k6);
        ObjectUtil.checkNotNull(v5, "value");
        int hashCode = this.hashingStrategy.hashCode(k6);
        int index = index(hashCode);
        remove0(hashCode, index, k6);
        add0(hashCode, index, k6, v5);
        return thisT();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.handler.codec.Headers
    public T setObject(K k6, Object obj) {
        ObjectUtil.checkNotNull(obj, "value");
        return (T) set((DefaultHeaders<K, V, T>) k6, (K) ObjectUtil.checkNotNull(this.valueConverter.convertObject(obj), "convertedValue"));
    }

    public DefaultHeaders(ValueConverter<V> valueConverter, NameValidator<K> nameValidator) {
        this(HashingStrategy.JAVA_HASHER, valueConverter, nameValidator);
    }

    private void add0(int i6, int i7, K k6, V v5) {
        HeaderEntry<K, V>[] headerEntryArr = this.entries;
        headerEntryArr[i7] = newHeaderEntry(i6, k6, v5, headerEntryArr[i7]);
        this.size++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int index(int i6) {
        return i6 & this.hashMask;
    }

    @Override // io.netty.handler.codec.Headers
    public T addBoolean(K k6, boolean z5) {
        return add((DefaultHeaders<K, V, T>) k6, (K) this.valueConverter.convertBoolean(z5));
    }

    @Override // io.netty.handler.codec.Headers
    public T addByte(K k6, byte b6) {
        return add((DefaultHeaders<K, V, T>) k6, (K) this.valueConverter.convertByte(b6));
    }

    @Override // io.netty.handler.codec.Headers
    public T addChar(K k6, char c6) {
        return add((DefaultHeaders<K, V, T>) k6, (K) this.valueConverter.convertChar(c6));
    }

    @Override // io.netty.handler.codec.Headers
    public T addDouble(K k6, double d6) {
        return add((DefaultHeaders<K, V, T>) k6, (K) this.valueConverter.convertDouble(d6));
    }

    @Override // io.netty.handler.codec.Headers
    public T addFloat(K k6, float f6) {
        return add((DefaultHeaders<K, V, T>) k6, (K) this.valueConverter.convertFloat(f6));
    }

    protected void addImpl(Headers<? extends K, ? extends V, ?> headers) {
        if (!(headers instanceof DefaultHeaders)) {
            for (Map.Entry<? extends K, ? extends V> entry : headers) {
                add((DefaultHeaders<K, V, T>) entry.getKey(), (K) entry.getValue());
            }
            return;
        }
        DefaultHeaders defaultHeaders = (DefaultHeaders) headers;
        HeaderEntry<K, V> headerEntry = defaultHeaders.head.after;
        if (defaultHeaders.hashingStrategy == this.hashingStrategy && defaultHeaders.nameValidator == this.nameValidator) {
            while (headerEntry != defaultHeaders.head) {
                int i6 = headerEntry.hash;
                add0(i6, index(i6), headerEntry.key, headerEntry.value);
                headerEntry = headerEntry.after;
            }
        } else {
            while (headerEntry != defaultHeaders.head) {
                add((DefaultHeaders<K, V, T>) headerEntry.key, (K) headerEntry.value);
                headerEntry = headerEntry.after;
            }
        }
    }

    @Override // io.netty.handler.codec.Headers
    public T addInt(K k6, int i6) {
        return add((DefaultHeaders<K, V, T>) k6, (K) this.valueConverter.convertInt(i6));
    }

    @Override // io.netty.handler.codec.Headers
    public T addLong(K k6, long j6) {
        return add((DefaultHeaders<K, V, T>) k6, (K) this.valueConverter.convertLong(j6));
    }

    @Override // io.netty.handler.codec.Headers
    public T addObject(K k6, Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            addObject((DefaultHeaders<K, V, T>) k6, it.next());
        }
        return thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public T addShort(K k6, short s5) {
        return add((DefaultHeaders<K, V, T>) k6, (K) this.valueConverter.convertShort(s5));
    }

    @Override // io.netty.handler.codec.Headers
    public T addTimeMillis(K k6, long j6) {
        return add((DefaultHeaders<K, V, T>) k6, (K) this.valueConverter.convertTimeMillis(j6));
    }

    @Override // io.netty.handler.codec.Headers
    public T clear() {
        Arrays.fill(this.entries, (Object) null);
        HeaderEntry<K, V> headerEntry = this.head;
        headerEntry.after = headerEntry;
        headerEntry.before = headerEntry;
        this.size = 0;
        return thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public boolean contains(K k6, V v5) {
        return contains(k6, v5, HashingStrategy.JAVA_HASHER);
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsBoolean(K k6, boolean z5) {
        return contains(k6, this.valueConverter.convertBoolean(z5));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsByte(K k6, byte b6) {
        return contains(k6, this.valueConverter.convertByte(b6));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsChar(K k6, char c6) {
        return contains(k6, this.valueConverter.convertChar(c6));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsDouble(K k6, double d6) {
        return contains(k6, this.valueConverter.convertDouble(d6));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsFloat(K k6, float f6) {
        return contains(k6, this.valueConverter.convertFloat(f6));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsInt(K k6, int i6) {
        return contains(k6, this.valueConverter.convertInt(i6));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsLong(K k6, long j6) {
        return contains(k6, this.valueConverter.convertLong(j6));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsObject(K k6, Object obj) {
        return contains(k6, this.valueConverter.convertObject(ObjectUtil.checkNotNull(obj, "value")));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsShort(K k6, short s5) {
        return contains(k6, this.valueConverter.convertShort(s5));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsTimeMillis(K k6, long j6) {
        return contains(k6, this.valueConverter.convertTimeMillis(j6));
    }

    public DefaultHeaders<K, V, T> copy() {
        DefaultHeaders<K, V, T> defaultHeaders = new DefaultHeaders<>(this.hashingStrategy, this.valueConverter, this.nameValidator, this.entries.length);
        defaultHeaders.addImpl(this);
        return defaultHeaders;
    }

    @Override // io.netty.handler.codec.Headers
    public List<V> getAll(K k6) {
        ObjectUtil.checkNotNull(k6, CommonNetImpl.NAME);
        LinkedList linkedList = new LinkedList();
        int hashCode = this.hashingStrategy.hashCode(k6);
        for (HeaderEntry<K, V> headerEntry = this.entries[index(hashCode)]; headerEntry != null; headerEntry = headerEntry.next) {
            if (headerEntry.hash == hashCode && this.hashingStrategy.equals(k6, headerEntry.key)) {
                linkedList.addFirst(headerEntry.getValue());
            }
        }
        return linkedList;
    }

    public final int hashCode(HashingStrategy<V> hashingStrategy) {
        int i6 = HASH_CODE_SEED;
        for (K k6 : names()) {
            i6 = (i6 * 31) + this.hashingStrategy.hashCode(k6);
            List<V> all = getAll(k6);
            for (int i7 = 0; i7 < all.size(); i7++) {
                i6 = (i6 * 31) + hashingStrategy.hashCode(all.get(i7));
            }
        }
        return i6;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean isEmpty() {
        HeaderEntry<K, V> headerEntry = this.head;
        return headerEntry == headerEntry.after;
    }

    @Override // io.netty.handler.codec.Headers, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new HeaderIterator(this, null);
    }

    protected HeaderEntry<K, V> newHeaderEntry(int i6, K k6, V v5, HeaderEntry<K, V> headerEntry) {
        return new HeaderEntry<>(i6, k6, v5, headerEntry, this.head);
    }

    @Override // io.netty.handler.codec.Headers
    public T setAll(Headers<? extends K, ? extends V, ?> headers) {
        if (headers != this) {
            Iterator<? extends K> it = headers.names().iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
            addImpl(headers);
        }
        return thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public T setBoolean(K k6, boolean z5) {
        return set((DefaultHeaders<K, V, T>) k6, (K) this.valueConverter.convertBoolean(z5));
    }

    @Override // io.netty.handler.codec.Headers
    public T setByte(K k6, byte b6) {
        return set((DefaultHeaders<K, V, T>) k6, (K) this.valueConverter.convertByte(b6));
    }

    @Override // io.netty.handler.codec.Headers
    public T setChar(K k6, char c6) {
        return set((DefaultHeaders<K, V, T>) k6, (K) this.valueConverter.convertChar(c6));
    }

    @Override // io.netty.handler.codec.Headers
    public T setDouble(K k6, double d6) {
        return set((DefaultHeaders<K, V, T>) k6, (K) this.valueConverter.convertDouble(d6));
    }

    @Override // io.netty.handler.codec.Headers
    public T setFloat(K k6, float f6) {
        return set((DefaultHeaders<K, V, T>) k6, (K) this.valueConverter.convertFloat(f6));
    }

    @Override // io.netty.handler.codec.Headers
    public T setInt(K k6, int i6) {
        return set((DefaultHeaders<K, V, T>) k6, (K) this.valueConverter.convertInt(i6));
    }

    @Override // io.netty.handler.codec.Headers
    public T setLong(K k6, long j6) {
        return set((DefaultHeaders<K, V, T>) k6, (K) this.valueConverter.convertLong(j6));
    }

    @Override // io.netty.handler.codec.Headers
    public T setShort(K k6, short s5) {
        return set((DefaultHeaders<K, V, T>) k6, (K) this.valueConverter.convertShort(s5));
    }

    @Override // io.netty.handler.codec.Headers
    public T setTimeMillis(K k6, long j6) {
        return set((DefaultHeaders<K, V, T>) k6, (K) this.valueConverter.convertTimeMillis(j6));
    }

    @Override // io.netty.handler.codec.Headers
    public int size() {
        return this.size;
    }

    protected ValueConverter<V> valueConverter() {
        return this.valueConverter;
    }

    public Iterator<V> valueIterator(K k6) {
        return new ValueIterator(k6);
    }

    public DefaultHeaders(HashingStrategy<K> hashingStrategy, ValueConverter<V> valueConverter) {
        this(hashingStrategy, valueConverter, NameValidator.NOT_NULL);
    }

    public final boolean contains(K k6, V v5, HashingStrategy<? super V> hashingStrategy) {
        ObjectUtil.checkNotNull(k6, CommonNetImpl.NAME);
        int hashCode = this.hashingStrategy.hashCode(k6);
        for (HeaderEntry<K, V> headerEntry = this.entries[index(hashCode)]; headerEntry != null; headerEntry = headerEntry.next) {
            if (headerEntry.hash == hashCode && this.hashingStrategy.equals(k6, headerEntry.key) && hashingStrategy.equals(v5, headerEntry.value)) {
                return true;
            }
        }
        return false;
    }

    public final boolean equals(Headers<K, V, ?> headers, HashingStrategy<V> hashingStrategy) {
        if (headers.size() != size()) {
            return false;
        }
        if (this == headers) {
            return true;
        }
        for (K k6 : names()) {
            List<V> all = headers.getAll(k6);
            List<V> all2 = getAll(k6);
            if (all.size() != all2.size()) {
                return false;
            }
            for (int i6 = 0; i6 < all.size(); i6++) {
                if (!hashingStrategy.equals(all.get(i6), all2.get(i6))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // io.netty.handler.codec.Headers
    public List<V> getAllAndRemove(K k6) {
        List<V> all = getAll(k6);
        remove(k6);
        return all;
    }

    @Override // io.netty.handler.codec.Headers
    public V getAndRemove(K k6, V v5) {
        V andRemove = getAndRemove(k6);
        return andRemove == null ? v5 : andRemove;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean getBoolean(K k6, boolean z5) {
        Boolean bool = getBoolean(k6);
        return bool != null ? bool.booleanValue() : z5;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean getBooleanAndRemove(K k6, boolean z5) {
        Boolean booleanAndRemove = getBooleanAndRemove(k6);
        return booleanAndRemove != null ? booleanAndRemove.booleanValue() : z5;
    }

    @Override // io.netty.handler.codec.Headers
    public byte getByte(K k6, byte b6) {
        Byte b7 = getByte(k6);
        return b7 != null ? b7.byteValue() : b6;
    }

    @Override // io.netty.handler.codec.Headers
    public byte getByteAndRemove(K k6, byte b6) {
        Byte byteAndRemove = getByteAndRemove(k6);
        return byteAndRemove != null ? byteAndRemove.byteValue() : b6;
    }

    @Override // io.netty.handler.codec.Headers
    public char getChar(K k6, char c6) {
        Character ch = getChar(k6);
        return ch != null ? ch.charValue() : c6;
    }

    @Override // io.netty.handler.codec.Headers
    public char getCharAndRemove(K k6, char c6) {
        Character charAndRemove = getCharAndRemove(k6);
        return charAndRemove != null ? charAndRemove.charValue() : c6;
    }

    @Override // io.netty.handler.codec.Headers
    public double getDouble(K k6, double d6) {
        Double d7 = getDouble(k6);
        return d7 != null ? d7.doubleValue() : d6;
    }

    @Override // io.netty.handler.codec.Headers
    public double getDoubleAndRemove(K k6, double d6) {
        Double doubleAndRemove = getDoubleAndRemove(k6);
        return doubleAndRemove != null ? doubleAndRemove.doubleValue() : d6;
    }

    @Override // io.netty.handler.codec.Headers
    public float getFloat(K k6, float f6) {
        Float f7 = getFloat(k6);
        return f7 != null ? f7.floatValue() : f6;
    }

    @Override // io.netty.handler.codec.Headers
    public float getFloatAndRemove(K k6, float f6) {
        Float floatAndRemove = getFloatAndRemove(k6);
        return floatAndRemove != null ? floatAndRemove.floatValue() : f6;
    }

    @Override // io.netty.handler.codec.Headers
    public int getInt(K k6, int i6) {
        Integer num = getInt(k6);
        return num != null ? num.intValue() : i6;
    }

    @Override // io.netty.handler.codec.Headers
    public int getIntAndRemove(K k6, int i6) {
        Integer intAndRemove = getIntAndRemove(k6);
        return intAndRemove != null ? intAndRemove.intValue() : i6;
    }

    @Override // io.netty.handler.codec.Headers
    public long getLong(K k6, long j6) {
        Long l6 = getLong(k6);
        return l6 != null ? l6.longValue() : j6;
    }

    @Override // io.netty.handler.codec.Headers
    public long getLongAndRemove(K k6, long j6) {
        Long longAndRemove = getLongAndRemove(k6);
        return longAndRemove != null ? longAndRemove.longValue() : j6;
    }

    @Override // io.netty.handler.codec.Headers
    public short getShort(K k6, short s5) {
        Short sh = getShort(k6);
        return sh != null ? sh.shortValue() : s5;
    }

    @Override // io.netty.handler.codec.Headers
    public short getShortAndRemove(K k6, short s5) {
        Short shortAndRemove = getShortAndRemove(k6);
        return shortAndRemove != null ? shortAndRemove.shortValue() : s5;
    }

    @Override // io.netty.handler.codec.Headers
    public long getTimeMillis(K k6, long j6) {
        Long timeMillis = getTimeMillis(k6);
        return timeMillis != null ? timeMillis.longValue() : j6;
    }

    @Override // io.netty.handler.codec.Headers
    public long getTimeMillisAndRemove(K k6, long j6) {
        Long timeMillisAndRemove = getTimeMillisAndRemove(k6);
        return timeMillisAndRemove != null ? timeMillisAndRemove.longValue() : j6;
    }

    @Override // io.netty.handler.codec.Headers
    public Set<K> names() {
        if (isEmpty()) {
            return Collections.EMPTY_SET;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(size());
        for (HeaderEntry<K, V> headerEntry = this.head.after; headerEntry != this.head; headerEntry = headerEntry.after) {
            linkedHashSet.add(headerEntry.getKey());
        }
        return linkedHashSet;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean remove(K k6) {
        if (getAndRemove(k6) != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        return HeadersUtils.toString(getClass(), iterator(), size());
    }

    public DefaultHeaders(HashingStrategy<K> hashingStrategy, ValueConverter<V> valueConverter, NameValidator<K> nameValidator) {
        this(hashingStrategy, valueConverter, nameValidator, 16);
    }

    @Override // io.netty.handler.codec.Headers
    public T setObject(K k6, Iterable<?> iterable) {
        Object next;
        this.nameValidator.validateName(k6);
        int hashCode = this.hashingStrategy.hashCode(k6);
        int index = index(hashCode);
        remove0(hashCode, index, k6);
        Iterator<?> it = iterable.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            add0(hashCode, index, k6, this.valueConverter.convertObject(next));
        }
        return thisT();
    }

    public DefaultHeaders(HashingStrategy<K> hashingStrategy, ValueConverter<V> valueConverter, NameValidator<K> nameValidator, int i6) {
        this.valueConverter = (ValueConverter) ObjectUtil.checkNotNull(valueConverter, "valueConverter");
        this.nameValidator = (NameValidator) ObjectUtil.checkNotNull(nameValidator, "nameValidator");
        this.hashingStrategy = (HashingStrategy) ObjectUtil.checkNotNull(hashingStrategy, "nameHashingStrategy");
        this.entries = new HeaderEntry[MathUtil.findNextPositivePowerOfTwo(Math.max(2, Math.min(i6, 128)))];
        this.hashMask = (byte) (r2.length - 1);
        this.head = new HeaderEntry<>();
    }

    @Override // io.netty.handler.codec.Headers
    public T addObject(K k6, Object... objArr) {
        for (Object obj : objArr) {
            addObject((DefaultHeaders<K, V, T>) k6, obj);
        }
        return thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public T add(K k6, Iterable<? extends V> iterable) {
        this.nameValidator.validateName(k6);
        int hashCode = this.hashingStrategy.hashCode(k6);
        int index = index(hashCode);
        Iterator<? extends V> it = iterable.iterator();
        while (it.hasNext()) {
            add0(hashCode, index, k6, it.next());
        }
        return thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public V get(K k6, V v5) {
        V v6 = get(k6);
        return v6 == null ? v5 : v6;
    }

    @Override // io.netty.handler.codec.Headers
    public T set(K k6, Iterable<? extends V> iterable) {
        V next;
        this.nameValidator.validateName(k6);
        ObjectUtil.checkNotNull(iterable, "values");
        int hashCode = this.hashingStrategy.hashCode(k6);
        int index = index(hashCode);
        remove0(hashCode, index, k6);
        Iterator<? extends V> it = iterable.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            add0(hashCode, index, k6, next);
        }
        return thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public T setObject(K k6, Object... objArr) {
        this.nameValidator.validateName(k6);
        int hashCode = this.hashingStrategy.hashCode(k6);
        int index = index(hashCode);
        remove0(hashCode, index, k6);
        for (Object obj : objArr) {
            if (obj == null) {
                break;
            }
            add0(hashCode, index, k6, this.valueConverter.convertObject(obj));
        }
        return thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public T add(K k6, V... vArr) {
        this.nameValidator.validateName(k6);
        int hashCode = this.hashingStrategy.hashCode(k6);
        int index = index(hashCode);
        for (V v5 : vArr) {
            add0(hashCode, index, k6, v5);
        }
        return thisT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HeaderEntry<K, V> remove0(HeaderEntry<K, V> headerEntry, HeaderEntry<K, V> headerEntry2) {
        int index = index(headerEntry.hash);
        HeaderEntry<K, V>[] headerEntryArr = this.entries;
        if (headerEntryArr[index] == headerEntry) {
            headerEntry2 = headerEntry.next;
            headerEntryArr[index] = headerEntry2;
        } else {
            headerEntry2.next = headerEntry.next;
        }
        headerEntry.remove();
        this.size--;
        return headerEntry2;
    }

    @Override // io.netty.handler.codec.Headers
    public T set(K k6, V... vArr) {
        this.nameValidator.validateName(k6);
        ObjectUtil.checkNotNull(vArr, "values");
        int hashCode = this.hashingStrategy.hashCode(k6);
        int index = index(hashCode);
        remove0(hashCode, index, k6);
        for (V v5 : vArr) {
            if (v5 == null) {
                break;
            }
            add0(hashCode, index, k6, v5);
        }
        return thisT();
    }

    private T thisT() {
        return this;
    }

    @Override // io.netty.handler.codec.Headers
    public T add(Headers<? extends K, ? extends V, ?> headers) {
        if (headers != this) {
            addImpl(headers);
            return thisT();
        }
        throw new IllegalArgumentException("can't add to itself.");
    }

    @Override // io.netty.handler.codec.Headers
    public T set(Headers<? extends K, ? extends V, ?> headers) {
        if (headers != this) {
            clear();
            addImpl(headers);
        }
        return thisT();
    }
}
