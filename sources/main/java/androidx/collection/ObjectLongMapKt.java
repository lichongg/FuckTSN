package androidx.collection;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ObjectLongMapKt {

    @NotNull
    private static final MutableObjectLongMap<Object> EmptyObjectLongMap = new MutableObjectLongMap<>(0);

    @NotNull
    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf() {
        return new MutableObjectLongMap<>(0, 1, null);
    }

    @NotNull
    public static final <K> ObjectLongMap<K> objectLongMapOf(K k6, long j6) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, null);
        mutableObjectLongMap.set(k6, j6);
        return mutableObjectLongMap;
    }

    @NotNull
    public static final <K> ObjectLongMap<K> emptyObjectLongMap() {
        MutableObjectLongMap<Object> mutableObjectLongMap = EmptyObjectLongMap;
        g0.n(mutableObjectLongMap, "null cannot be cast to non-null type androidx.collection.ObjectLongMap<K of androidx.collection.ObjectLongMapKt.emptyObjectLongMap>");
        return mutableObjectLongMap;
    }

    @NotNull
    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K k6, long j6) {
        MutableObjectLongMap<K> mutableObjectLongMap = new MutableObjectLongMap<>(0, 1, null);
        mutableObjectLongMap.set(k6, j6);
        return mutableObjectLongMap;
    }

    @NotNull
    public static final <K> ObjectLongMap<K> objectLongMap() {
        MutableObjectLongMap<Object> mutableObjectLongMap = EmptyObjectLongMap;
        g0.n(mutableObjectLongMap, "null cannot be cast to non-null type androidx.collection.ObjectLongMap<K of androidx.collection.ObjectLongMapKt.objectLongMap>");
        return mutableObjectLongMap;
    }

    @NotNull
    public static final <K> ObjectLongMap<K> objectLongMapOf(K k6, long j6, K k7, long j7) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, null);
        mutableObjectLongMap.set(k6, j6);
        mutableObjectLongMap.set(k7, j7);
        return mutableObjectLongMap;
    }

    @NotNull
    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K k6, long j6, K k7, long j7) {
        MutableObjectLongMap<K> mutableObjectLongMap = new MutableObjectLongMap<>(0, 1, null);
        mutableObjectLongMap.set(k6, j6);
        mutableObjectLongMap.set(k7, j7);
        return mutableObjectLongMap;
    }

    @NotNull
    public static final <K> ObjectLongMap<K> objectLongMapOf(K k6, long j6, K k7, long j7, K k8, long j8) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, null);
        mutableObjectLongMap.set(k6, j6);
        mutableObjectLongMap.set(k7, j7);
        mutableObjectLongMap.set(k8, j8);
        return mutableObjectLongMap;
    }

    @NotNull
    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K k6, long j6, K k7, long j7, K k8, long j8) {
        MutableObjectLongMap<K> mutableObjectLongMap = new MutableObjectLongMap<>(0, 1, null);
        mutableObjectLongMap.set(k6, j6);
        mutableObjectLongMap.set(k7, j7);
        mutableObjectLongMap.set(k8, j8);
        return mutableObjectLongMap;
    }

    @NotNull
    public static final <K> ObjectLongMap<K> objectLongMapOf(K k6, long j6, K k7, long j7, K k8, long j8, K k9, long j9) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, null);
        mutableObjectLongMap.set(k6, j6);
        mutableObjectLongMap.set(k7, j7);
        mutableObjectLongMap.set(k8, j8);
        mutableObjectLongMap.set(k9, j9);
        return mutableObjectLongMap;
    }

    @NotNull
    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K k6, long j6, K k7, long j7, K k8, long j8, K k9, long j9) {
        MutableObjectLongMap<K> mutableObjectLongMap = new MutableObjectLongMap<>(0, 1, null);
        mutableObjectLongMap.set(k6, j6);
        mutableObjectLongMap.set(k7, j7);
        mutableObjectLongMap.set(k8, j8);
        mutableObjectLongMap.set(k9, j9);
        return mutableObjectLongMap;
    }

    @NotNull
    public static final <K> ObjectLongMap<K> objectLongMapOf(K k6, long j6, K k7, long j7, K k8, long j8, K k9, long j9, K k10, long j10) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, null);
        mutableObjectLongMap.set(k6, j6);
        mutableObjectLongMap.set(k7, j7);
        mutableObjectLongMap.set(k8, j8);
        mutableObjectLongMap.set(k9, j9);
        mutableObjectLongMap.set(k10, j10);
        return mutableObjectLongMap;
    }

    @NotNull
    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K k6, long j6, K k7, long j7, K k8, long j8, K k9, long j9, K k10, long j10) {
        MutableObjectLongMap<K> mutableObjectLongMap = new MutableObjectLongMap<>(0, 1, null);
        mutableObjectLongMap.set(k6, j6);
        mutableObjectLongMap.set(k7, j7);
        mutableObjectLongMap.set(k8, j8);
        mutableObjectLongMap.set(k9, j9);
        mutableObjectLongMap.set(k10, j10);
        return mutableObjectLongMap;
    }
}
