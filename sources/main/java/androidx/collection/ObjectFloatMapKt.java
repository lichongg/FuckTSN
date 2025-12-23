package androidx.collection;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ObjectFloatMapKt {

    @NotNull
    private static final MutableObjectFloatMap<Object> EmptyObjectFloatMap = new MutableObjectFloatMap<>(0);

    @NotNull
    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf() {
        return new MutableObjectFloatMap<>(0, 1, null);
    }

    @NotNull
    public static final <K> ObjectFloatMap<K> objectFloatMapOf(K k6, float f6) {
        MutableObjectFloatMap mutableObjectFloatMap = new MutableObjectFloatMap(0, 1, null);
        mutableObjectFloatMap.set(k6, f6);
        return mutableObjectFloatMap;
    }

    @NotNull
    public static final <K> ObjectFloatMap<K> emptyObjectFloatMap() {
        MutableObjectFloatMap<Object> mutableObjectFloatMap = EmptyObjectFloatMap;
        g0.n(mutableObjectFloatMap, "null cannot be cast to non-null type androidx.collection.ObjectFloatMap<K of androidx.collection.ObjectFloatMapKt.emptyObjectFloatMap>");
        return mutableObjectFloatMap;
    }

    @NotNull
    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf(K k6, float f6) {
        MutableObjectFloatMap<K> mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
        mutableObjectFloatMap.set(k6, f6);
        return mutableObjectFloatMap;
    }

    @NotNull
    public static final <K> ObjectFloatMap<K> objectFloatMap() {
        MutableObjectFloatMap<Object> mutableObjectFloatMap = EmptyObjectFloatMap;
        g0.n(mutableObjectFloatMap, "null cannot be cast to non-null type androidx.collection.ObjectFloatMap<K of androidx.collection.ObjectFloatMapKt.objectFloatMap>");
        return mutableObjectFloatMap;
    }

    @NotNull
    public static final <K> ObjectFloatMap<K> objectFloatMapOf(K k6, float f6, K k7, float f7) {
        MutableObjectFloatMap mutableObjectFloatMap = new MutableObjectFloatMap(0, 1, null);
        mutableObjectFloatMap.set(k6, f6);
        mutableObjectFloatMap.set(k7, f7);
        return mutableObjectFloatMap;
    }

    @NotNull
    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf(K k6, float f6, K k7, float f7) {
        MutableObjectFloatMap<K> mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
        mutableObjectFloatMap.set(k6, f6);
        mutableObjectFloatMap.set(k7, f7);
        return mutableObjectFloatMap;
    }

    @NotNull
    public static final <K> ObjectFloatMap<K> objectFloatMapOf(K k6, float f6, K k7, float f7, K k8, float f8) {
        MutableObjectFloatMap mutableObjectFloatMap = new MutableObjectFloatMap(0, 1, null);
        mutableObjectFloatMap.set(k6, f6);
        mutableObjectFloatMap.set(k7, f7);
        mutableObjectFloatMap.set(k8, f8);
        return mutableObjectFloatMap;
    }

    @NotNull
    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf(K k6, float f6, K k7, float f7, K k8, float f8) {
        MutableObjectFloatMap<K> mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
        mutableObjectFloatMap.set(k6, f6);
        mutableObjectFloatMap.set(k7, f7);
        mutableObjectFloatMap.set(k8, f8);
        return mutableObjectFloatMap;
    }

    @NotNull
    public static final <K> ObjectFloatMap<K> objectFloatMapOf(K k6, float f6, K k7, float f7, K k8, float f8, K k9, float f9) {
        MutableObjectFloatMap mutableObjectFloatMap = new MutableObjectFloatMap(0, 1, null);
        mutableObjectFloatMap.set(k6, f6);
        mutableObjectFloatMap.set(k7, f7);
        mutableObjectFloatMap.set(k8, f8);
        mutableObjectFloatMap.set(k9, f9);
        return mutableObjectFloatMap;
    }

    @NotNull
    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf(K k6, float f6, K k7, float f7, K k8, float f8, K k9, float f9) {
        MutableObjectFloatMap<K> mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
        mutableObjectFloatMap.set(k6, f6);
        mutableObjectFloatMap.set(k7, f7);
        mutableObjectFloatMap.set(k8, f8);
        mutableObjectFloatMap.set(k9, f9);
        return mutableObjectFloatMap;
    }

    @NotNull
    public static final <K> ObjectFloatMap<K> objectFloatMapOf(K k6, float f6, K k7, float f7, K k8, float f8, K k9, float f9, K k10, float f10) {
        MutableObjectFloatMap mutableObjectFloatMap = new MutableObjectFloatMap(0, 1, null);
        mutableObjectFloatMap.set(k6, f6);
        mutableObjectFloatMap.set(k7, f7);
        mutableObjectFloatMap.set(k8, f8);
        mutableObjectFloatMap.set(k9, f9);
        mutableObjectFloatMap.set(k10, f10);
        return mutableObjectFloatMap;
    }

    @NotNull
    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf(K k6, float f6, K k7, float f7, K k8, float f8, K k9, float f9, K k10, float f10) {
        MutableObjectFloatMap<K> mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
        mutableObjectFloatMap.set(k6, f6);
        mutableObjectFloatMap.set(k7, f7);
        mutableObjectFloatMap.set(k8, f8);
        mutableObjectFloatMap.set(k9, f9);
        mutableObjectFloatMap.set(k10, f10);
        return mutableObjectFloatMap;
    }
}
