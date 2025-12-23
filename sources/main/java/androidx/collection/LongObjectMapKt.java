package androidx.collection;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class LongObjectMapKt {

    @NotNull
    private static final MutableLongObjectMap EmptyLongObjectMap = new MutableLongObjectMap(0);

    @NotNull
    public static final <V> LongObjectMap<V> longObjectMapOf() {
        MutableLongObjectMap mutableLongObjectMap = EmptyLongObjectMap;
        g0.n(mutableLongObjectMap, "null cannot be cast to non-null type androidx.collection.LongObjectMap<V of androidx.collection.LongObjectMapKt.longObjectMapOf>");
        return mutableLongObjectMap;
    }

    @NotNull
    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf() {
        return new MutableLongObjectMap<>(0, 1, null);
    }

    @NotNull
    public static final <V> LongObjectMap<V> emptyLongObjectMap() {
        MutableLongObjectMap mutableLongObjectMap = EmptyLongObjectMap;
        g0.n(mutableLongObjectMap, "null cannot be cast to non-null type androidx.collection.LongObjectMap<V of androidx.collection.LongObjectMapKt.emptyLongObjectMap>");
        return mutableLongObjectMap;
    }

    @NotNull
    public static final <V> LongObjectMap<V> longObjectMapOf(long j6, V v5) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j6, v5);
        return mutableLongObjectMap;
    }

    @NotNull
    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j6, V v5) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j6, v5);
        return mutableLongObjectMap;
    }

    @NotNull
    public static final <V> LongObjectMap<V> longObjectMapOf(long j6, V v5, long j7, V v6) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j6, v5);
        mutableLongObjectMap.set(j7, v6);
        return mutableLongObjectMap;
    }

    @NotNull
    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j6, V v5, long j7, V v6) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j6, v5);
        mutableLongObjectMap.set(j7, v6);
        return mutableLongObjectMap;
    }

    @NotNull
    public static final <V> LongObjectMap<V> longObjectMapOf(long j6, V v5, long j7, V v6, long j8, V v7) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j6, v5);
        mutableLongObjectMap.set(j7, v6);
        mutableLongObjectMap.set(j8, v7);
        return mutableLongObjectMap;
    }

    @NotNull
    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j6, V v5, long j7, V v6, long j8, V v7) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j6, v5);
        mutableLongObjectMap.set(j7, v6);
        mutableLongObjectMap.set(j8, v7);
        return mutableLongObjectMap;
    }

    @NotNull
    public static final <V> LongObjectMap<V> longObjectMapOf(long j6, V v5, long j7, V v6, long j8, V v7, long j9, V v8) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j6, v5);
        mutableLongObjectMap.set(j7, v6);
        mutableLongObjectMap.set(j8, v7);
        mutableLongObjectMap.set(j9, v8);
        return mutableLongObjectMap;
    }

    @NotNull
    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j6, V v5, long j7, V v6, long j8, V v7, long j9, V v8) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j6, v5);
        mutableLongObjectMap.set(j7, v6);
        mutableLongObjectMap.set(j8, v7);
        mutableLongObjectMap.set(j9, v8);
        return mutableLongObjectMap;
    }

    @NotNull
    public static final <V> LongObjectMap<V> longObjectMapOf(long j6, V v5, long j7, V v6, long j8, V v7, long j9, V v8, long j10, V v9) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j6, v5);
        mutableLongObjectMap.set(j7, v6);
        mutableLongObjectMap.set(j8, v7);
        mutableLongObjectMap.set(j9, v8);
        mutableLongObjectMap.set(j10, v9);
        return mutableLongObjectMap;
    }

    @NotNull
    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j6, V v5, long j7, V v6, long j8, V v7, long j9, V v8, long j10, V v9) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j6, v5);
        mutableLongObjectMap.set(j7, v6);
        mutableLongObjectMap.set(j8, v7);
        mutableLongObjectMap.set(j9, v8);
        mutableLongObjectMap.set(j10, v9);
        return mutableLongObjectMap;
    }
}
