package io.netty.handler.codec;

import io.netty.handler.codec.Headers;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class EmptyHeaders<K, V, T extends Headers<K, V, T>> implements Headers<K, V, T> {
    @Override // io.netty.handler.codec.Headers
    public T add(K k6, V v5) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T addObject(K k6, Object obj) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public boolean contains(K k6) {
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsBoolean(K k6, boolean z5) {
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsByte(K k6, byte b6) {
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsChar(K k6, char c6) {
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsDouble(K k6, double d6) {
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsFloat(K k6, float f6) {
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsInt(K k6, int i6) {
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsLong(K k6, long j6) {
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsObject(K k6, Object obj) {
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsShort(K k6, short s5) {
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsTimeMillis(K k6, long j6) {
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public V get(K k6) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public V getAndRemove(K k6) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Boolean getBoolean(K k6) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Boolean getBooleanAndRemove(K k6) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public byte getByte(K k6, byte b6) {
        return b6;
    }

    @Override // io.netty.handler.codec.Headers
    public byte getByteAndRemove(K k6, byte b6) {
        return b6;
    }

    @Override // io.netty.handler.codec.Headers
    public char getChar(K k6, char c6) {
        return c6;
    }

    @Override // io.netty.handler.codec.Headers
    public char getCharAndRemove(K k6, char c6) {
        return c6;
    }

    @Override // io.netty.handler.codec.Headers
    public double getDouble(K k6, double d6) {
        return d6;
    }

    @Override // io.netty.handler.codec.Headers
    public double getDoubleAndRemove(K k6, double d6) {
        return d6;
    }

    @Override // io.netty.handler.codec.Headers
    public float getFloat(K k6, float f6) {
        return f6;
    }

    @Override // io.netty.handler.codec.Headers
    public float getFloatAndRemove(K k6, float f6) {
        return f6;
    }

    @Override // io.netty.handler.codec.Headers
    public int getInt(K k6, int i6) {
        return i6;
    }

    @Override // io.netty.handler.codec.Headers
    public int getIntAndRemove(K k6, int i6) {
        return i6;
    }

    @Override // io.netty.handler.codec.Headers
    public long getLong(K k6, long j6) {
        return j6;
    }

    @Override // io.netty.handler.codec.Headers
    public long getLongAndRemove(K k6, long j6) {
        return j6;
    }

    @Override // io.netty.handler.codec.Headers
    public Short getShort(K k6) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Short getShortAndRemove(K k6) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public long getTimeMillis(K k6, long j6) {
        return j6;
    }

    @Override // io.netty.handler.codec.Headers
    public long getTimeMillisAndRemove(K k6, long j6) {
        return j6;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean isEmpty() {
        return true;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean remove(K k6) {
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public T set(K k6, V v5) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T setObject(K k6, Object obj) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public int size() {
        return 0;
    }

    @Override // io.netty.handler.codec.Headers
    public T add(K k6, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T addBoolean(K k6, boolean z5) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T addByte(K k6, byte b6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T addChar(K k6, char c6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T addDouble(K k6, double d6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T addFloat(K k6, float f6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T addInt(K k6, int i6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T addLong(K k6, long j6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T addObject(K k6, Iterable<?> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T addShort(K k6, short s5) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T addTimeMillis(K k6, long j6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public boolean contains(K k6, V v5) {
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Headers) {
            return isEmpty() && ((Headers) obj).isEmpty();
        }
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public V get(K k6, V v5) {
        return v5;
    }

    @Override // io.netty.handler.codec.Headers
    public List<V> getAll(K k6) {
        return Collections.EMPTY_LIST;
    }

    @Override // io.netty.handler.codec.Headers
    public List<V> getAllAndRemove(K k6) {
        return Collections.EMPTY_LIST;
    }

    @Override // io.netty.handler.codec.Headers
    public V getAndRemove(K k6, V v5) {
        return v5;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean getBoolean(K k6, boolean z5) {
        return z5;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean getBooleanAndRemove(K k6, boolean z5) {
        return z5;
    }

    @Override // io.netty.handler.codec.Headers
    public Byte getByte(K k6) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Byte getByteAndRemove(K k6) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Character getChar(K k6) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Character getCharAndRemove(K k6) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Double getDouble(K k6) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Double getDoubleAndRemove(K k6) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Float getFloat(K k6) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Float getFloatAndRemove(K k6) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Integer getInt(K k6) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Integer getIntAndRemove(K k6) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Long getLong(K k6) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Long getLongAndRemove(K k6) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public short getShort(K k6, short s5) {
        return s5;
    }

    @Override // io.netty.handler.codec.Headers
    public short getShortAndRemove(K k6, short s5) {
        return s5;
    }

    @Override // io.netty.handler.codec.Headers
    public Long getTimeMillis(K k6) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Long getTimeMillisAndRemove(K k6) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return Collections.EMPTY_LIST.iterator();
    }

    @Override // io.netty.handler.codec.Headers
    public Set<K> names() {
        return Collections.EMPTY_SET;
    }

    @Override // io.netty.handler.codec.Headers
    public T set(K k6, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T setAll(Headers<? extends K, ? extends V, ?> headers) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T setBoolean(K k6, boolean z5) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T setByte(K k6, byte b6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T setChar(K k6, char c6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T setDouble(K k6, double d6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T setFloat(K k6, float f6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T setInt(K k6, int i6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T setLong(K k6, long j6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T setObject(K k6, Iterable<?> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T setShort(K k6, short s5) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T setTimeMillis(K k6, long j6) {
        throw new UnsupportedOperationException("read only");
    }

    public String toString() {
        return getClass().getSimpleName() + "[]";
    }

    public Iterator<V> valueIterator(K k6) {
        return Collections.EMPTY_LIST.iterator();
    }

    @Override // io.netty.handler.codec.Headers
    public T add(K k6, V... vArr) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T addObject(K k6, Object... objArr) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T clear() {
        return thisT();
    }

    public int hashCode() {
        return -1028477387;
    }

    @Override // io.netty.handler.codec.Headers
    public T set(K k6, V... vArr) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T setObject(K k6, Object... objArr) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T add(Headers<? extends K, ? extends V, ?> headers) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T set(Headers<? extends K, ? extends V, ?> headers) {
        throw new UnsupportedOperationException("read only");
    }

    private T thisT() {
        return this;
    }
}
