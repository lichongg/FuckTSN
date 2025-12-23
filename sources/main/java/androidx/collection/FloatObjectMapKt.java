package androidx.collection;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class FloatObjectMapKt {

    @NotNull
    private static final MutableFloatObjectMap EmptyFloatObjectMap = new MutableFloatObjectMap(0);

    @NotNull
    public static final <V> FloatObjectMap<V> floatObjectMapOf() {
        MutableFloatObjectMap mutableFloatObjectMap = EmptyFloatObjectMap;
        g0.n(mutableFloatObjectMap, "null cannot be cast to non-null type androidx.collection.FloatObjectMap<V of androidx.collection.FloatObjectMapKt.floatObjectMapOf>");
        return mutableFloatObjectMap;
    }

    @NotNull
    public static final <V> MutableFloatObjectMap<V> mutableFloatObjectMapOf() {
        return new MutableFloatObjectMap<>(0, 1, null);
    }

    @NotNull
    public static final <V> FloatObjectMap<V> emptyFloatObjectMap() {
        MutableFloatObjectMap mutableFloatObjectMap = EmptyFloatObjectMap;
        g0.n(mutableFloatObjectMap, "null cannot be cast to non-null type androidx.collection.FloatObjectMap<V of androidx.collection.FloatObjectMapKt.emptyFloatObjectMap>");
        return mutableFloatObjectMap;
    }

    @NotNull
    public static final <V> FloatObjectMap<V> floatObjectMapOf(float f6, V v5) {
        MutableFloatObjectMap mutableFloatObjectMap = new MutableFloatObjectMap(0, 1, null);
        mutableFloatObjectMap.set(f6, v5);
        return mutableFloatObjectMap;
    }

    @NotNull
    public static final <V> MutableFloatObjectMap<V> mutableFloatObjectMapOf(float f6, V v5) {
        MutableFloatObjectMap<V> mutableFloatObjectMap = new MutableFloatObjectMap<>(0, 1, null);
        mutableFloatObjectMap.set(f6, v5);
        return mutableFloatObjectMap;
    }

    @NotNull
    public static final <V> FloatObjectMap<V> floatObjectMapOf(float f6, V v5, float f7, V v6) {
        MutableFloatObjectMap mutableFloatObjectMap = new MutableFloatObjectMap(0, 1, null);
        mutableFloatObjectMap.set(f6, v5);
        mutableFloatObjectMap.set(f7, v6);
        return mutableFloatObjectMap;
    }

    @NotNull
    public static final <V> MutableFloatObjectMap<V> mutableFloatObjectMapOf(float f6, V v5, float f7, V v6) {
        MutableFloatObjectMap<V> mutableFloatObjectMap = new MutableFloatObjectMap<>(0, 1, null);
        mutableFloatObjectMap.set(f6, v5);
        mutableFloatObjectMap.set(f7, v6);
        return mutableFloatObjectMap;
    }

    @NotNull
    public static final <V> FloatObjectMap<V> floatObjectMapOf(float f6, V v5, float f7, V v6, float f8, V v7) {
        MutableFloatObjectMap mutableFloatObjectMap = new MutableFloatObjectMap(0, 1, null);
        mutableFloatObjectMap.set(f6, v5);
        mutableFloatObjectMap.set(f7, v6);
        mutableFloatObjectMap.set(f8, v7);
        return mutableFloatObjectMap;
    }

    @NotNull
    public static final <V> MutableFloatObjectMap<V> mutableFloatObjectMapOf(float f6, V v5, float f7, V v6, float f8, V v7) {
        MutableFloatObjectMap<V> mutableFloatObjectMap = new MutableFloatObjectMap<>(0, 1, null);
        mutableFloatObjectMap.set(f6, v5);
        mutableFloatObjectMap.set(f7, v6);
        mutableFloatObjectMap.set(f8, v7);
        return mutableFloatObjectMap;
    }

    @NotNull
    public static final <V> FloatObjectMap<V> floatObjectMapOf(float f6, V v5, float f7, V v6, float f8, V v7, float f9, V v8) {
        MutableFloatObjectMap mutableFloatObjectMap = new MutableFloatObjectMap(0, 1, null);
        mutableFloatObjectMap.set(f6, v5);
        mutableFloatObjectMap.set(f7, v6);
        mutableFloatObjectMap.set(f8, v7);
        mutableFloatObjectMap.set(f9, v8);
        return mutableFloatObjectMap;
    }

    @NotNull
    public static final <V> MutableFloatObjectMap<V> mutableFloatObjectMapOf(float f6, V v5, float f7, V v6, float f8, V v7, float f9, V v8) {
        MutableFloatObjectMap<V> mutableFloatObjectMap = new MutableFloatObjectMap<>(0, 1, null);
        mutableFloatObjectMap.set(f6, v5);
        mutableFloatObjectMap.set(f7, v6);
        mutableFloatObjectMap.set(f8, v7);
        mutableFloatObjectMap.set(f9, v8);
        return mutableFloatObjectMap;
    }

    @NotNull
    public static final <V> FloatObjectMap<V> floatObjectMapOf(float f6, V v5, float f7, V v6, float f8, V v7, float f9, V v8, float f10, V v9) {
        MutableFloatObjectMap mutableFloatObjectMap = new MutableFloatObjectMap(0, 1, null);
        mutableFloatObjectMap.set(f6, v5);
        mutableFloatObjectMap.set(f7, v6);
        mutableFloatObjectMap.set(f8, v7);
        mutableFloatObjectMap.set(f9, v8);
        mutableFloatObjectMap.set(f10, v9);
        return mutableFloatObjectMap;
    }

    @NotNull
    public static final <V> MutableFloatObjectMap<V> mutableFloatObjectMapOf(float f6, V v5, float f7, V v6, float f8, V v7, float f9, V v8, float f10, V v9) {
        MutableFloatObjectMap<V> mutableFloatObjectMap = new MutableFloatObjectMap<>(0, 1, null);
        mutableFloatObjectMap.set(f6, v5);
        mutableFloatObjectMap.set(f7, v6);
        mutableFloatObjectMap.set(f8, v7);
        mutableFloatObjectMap.set(f9, v8);
        mutableFloatObjectMap.set(f10, v9);
        return mutableFloatObjectMap;
    }
}
