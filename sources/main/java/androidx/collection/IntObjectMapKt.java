package androidx.collection;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class IntObjectMapKt {

    @NotNull
    private static final MutableIntObjectMap EmptyIntObjectMap = new MutableIntObjectMap(0);

    @NotNull
    public static final <V> IntObjectMap<V> intObjectMapOf() {
        MutableIntObjectMap mutableIntObjectMap = EmptyIntObjectMap;
        g0.n(mutableIntObjectMap, "null cannot be cast to non-null type androidx.collection.IntObjectMap<V of androidx.collection.IntObjectMapKt.intObjectMapOf>");
        return mutableIntObjectMap;
    }

    @NotNull
    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf() {
        return new MutableIntObjectMap<>(0, 1, null);
    }

    @NotNull
    public static final <V> IntObjectMap<V> emptyIntObjectMap() {
        MutableIntObjectMap mutableIntObjectMap = EmptyIntObjectMap;
        g0.n(mutableIntObjectMap, "null cannot be cast to non-null type androidx.collection.IntObjectMap<V of androidx.collection.IntObjectMapKt.emptyIntObjectMap>");
        return mutableIntObjectMap;
    }

    @NotNull
    public static final <V> IntObjectMap<V> intObjectMapOf(int i6, V v5) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, null);
        mutableIntObjectMap.set(i6, v5);
        return mutableIntObjectMap;
    }

    @NotNull
    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf(int i6, V v5) {
        MutableIntObjectMap<V> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
        mutableIntObjectMap.set(i6, v5);
        return mutableIntObjectMap;
    }

    @NotNull
    public static final <V> IntObjectMap<V> intObjectMapOf(int i6, V v5, int i7, V v6) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, null);
        mutableIntObjectMap.set(i6, v5);
        mutableIntObjectMap.set(i7, v6);
        return mutableIntObjectMap;
    }

    @NotNull
    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf(int i6, V v5, int i7, V v6) {
        MutableIntObjectMap<V> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
        mutableIntObjectMap.set(i6, v5);
        mutableIntObjectMap.set(i7, v6);
        return mutableIntObjectMap;
    }

    @NotNull
    public static final <V> IntObjectMap<V> intObjectMapOf(int i6, V v5, int i7, V v6, int i8, V v7) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, null);
        mutableIntObjectMap.set(i6, v5);
        mutableIntObjectMap.set(i7, v6);
        mutableIntObjectMap.set(i8, v7);
        return mutableIntObjectMap;
    }

    @NotNull
    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf(int i6, V v5, int i7, V v6, int i8, V v7) {
        MutableIntObjectMap<V> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
        mutableIntObjectMap.set(i6, v5);
        mutableIntObjectMap.set(i7, v6);
        mutableIntObjectMap.set(i8, v7);
        return mutableIntObjectMap;
    }

    @NotNull
    public static final <V> IntObjectMap<V> intObjectMapOf(int i6, V v5, int i7, V v6, int i8, V v7, int i9, V v8) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, null);
        mutableIntObjectMap.set(i6, v5);
        mutableIntObjectMap.set(i7, v6);
        mutableIntObjectMap.set(i8, v7);
        mutableIntObjectMap.set(i9, v8);
        return mutableIntObjectMap;
    }

    @NotNull
    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf(int i6, V v5, int i7, V v6, int i8, V v7, int i9, V v8) {
        MutableIntObjectMap<V> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
        mutableIntObjectMap.set(i6, v5);
        mutableIntObjectMap.set(i7, v6);
        mutableIntObjectMap.set(i8, v7);
        mutableIntObjectMap.set(i9, v8);
        return mutableIntObjectMap;
    }

    @NotNull
    public static final <V> IntObjectMap<V> intObjectMapOf(int i6, V v5, int i7, V v6, int i8, V v7, int i9, V v8, int i10, V v9) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, null);
        mutableIntObjectMap.set(i6, v5);
        mutableIntObjectMap.set(i7, v6);
        mutableIntObjectMap.set(i8, v7);
        mutableIntObjectMap.set(i9, v8);
        mutableIntObjectMap.set(i10, v9);
        return mutableIntObjectMap;
    }

    @NotNull
    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf(int i6, V v5, int i7, V v6, int i8, V v7, int i9, V v8, int i10, V v9) {
        MutableIntObjectMap<V> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
        mutableIntObjectMap.set(i6, v5);
        mutableIntObjectMap.set(i7, v6);
        mutableIntObjectMap.set(i8, v7);
        mutableIntObjectMap.set(i9, v8);
        mutableIntObjectMap.set(i10, v9);
        return mutableIntObjectMap;
    }
}
