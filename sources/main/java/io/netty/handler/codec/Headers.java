package io.netty.handler.codec;

import io.netty.handler.codec.Headers;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface Headers<K, V, T extends Headers<K, V, T>> extends Iterable<Map.Entry<K, V>> {
    T add(Headers<? extends K, ? extends V, ?> headers);

    T add(K k6, Iterable<? extends V> iterable);

    T add(K k6, V v5);

    T add(K k6, V... vArr);

    T addBoolean(K k6, boolean z5);

    T addByte(K k6, byte b6);

    T addChar(K k6, char c6);

    T addDouble(K k6, double d6);

    T addFloat(K k6, float f6);

    T addInt(K k6, int i6);

    T addLong(K k6, long j6);

    T addObject(K k6, Iterable<?> iterable);

    T addObject(K k6, Object obj);

    T addObject(K k6, Object... objArr);

    T addShort(K k6, short s5);

    T addTimeMillis(K k6, long j6);

    T clear();

    boolean contains(K k6);

    boolean contains(K k6, V v5);

    boolean containsBoolean(K k6, boolean z5);

    boolean containsByte(K k6, byte b6);

    boolean containsChar(K k6, char c6);

    boolean containsDouble(K k6, double d6);

    boolean containsFloat(K k6, float f6);

    boolean containsInt(K k6, int i6);

    boolean containsLong(K k6, long j6);

    boolean containsObject(K k6, Object obj);

    boolean containsShort(K k6, short s5);

    boolean containsTimeMillis(K k6, long j6);

    V get(K k6);

    V get(K k6, V v5);

    List<V> getAll(K k6);

    List<V> getAllAndRemove(K k6);

    V getAndRemove(K k6);

    V getAndRemove(K k6, V v5);

    Boolean getBoolean(K k6);

    boolean getBoolean(K k6, boolean z5);

    Boolean getBooleanAndRemove(K k6);

    boolean getBooleanAndRemove(K k6, boolean z5);

    byte getByte(K k6, byte b6);

    Byte getByte(K k6);

    byte getByteAndRemove(K k6, byte b6);

    Byte getByteAndRemove(K k6);

    char getChar(K k6, char c6);

    Character getChar(K k6);

    char getCharAndRemove(K k6, char c6);

    Character getCharAndRemove(K k6);

    double getDouble(K k6, double d6);

    Double getDouble(K k6);

    double getDoubleAndRemove(K k6, double d6);

    Double getDoubleAndRemove(K k6);

    float getFloat(K k6, float f6);

    Float getFloat(K k6);

    float getFloatAndRemove(K k6, float f6);

    Float getFloatAndRemove(K k6);

    int getInt(K k6, int i6);

    Integer getInt(K k6);

    int getIntAndRemove(K k6, int i6);

    Integer getIntAndRemove(K k6);

    long getLong(K k6, long j6);

    Long getLong(K k6);

    long getLongAndRemove(K k6, long j6);

    Long getLongAndRemove(K k6);

    Short getShort(K k6);

    short getShort(K k6, short s5);

    Short getShortAndRemove(K k6);

    short getShortAndRemove(K k6, short s5);

    long getTimeMillis(K k6, long j6);

    Long getTimeMillis(K k6);

    long getTimeMillisAndRemove(K k6, long j6);

    Long getTimeMillisAndRemove(K k6);

    boolean isEmpty();

    @Override // java.lang.Iterable
    Iterator<Map.Entry<K, V>> iterator();

    Set<K> names();

    boolean remove(K k6);

    T set(Headers<? extends K, ? extends V, ?> headers);

    T set(K k6, Iterable<? extends V> iterable);

    T set(K k6, V v5);

    T set(K k6, V... vArr);

    T setAll(Headers<? extends K, ? extends V, ?> headers);

    T setBoolean(K k6, boolean z5);

    T setByte(K k6, byte b6);

    T setChar(K k6, char c6);

    T setDouble(K k6, double d6);

    T setFloat(K k6, float f6);

    T setInt(K k6, int i6);

    T setLong(K k6, long j6);

    T setObject(K k6, Iterable<?> iterable);

    T setObject(K k6, Object obj);

    T setObject(K k6, Object... objArr);

    T setShort(K k6, short s5);

    T setTimeMillis(K k6, long j6);

    int size();
}
