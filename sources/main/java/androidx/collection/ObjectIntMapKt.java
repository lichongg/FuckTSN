package androidx.collection;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ObjectIntMapKt {

    @NotNull
    private static final MutableObjectIntMap<Object> EmptyObjectIntMap = new MutableObjectIntMap<>(0);

    @NotNull
    public static final <K> MutableObjectIntMap<K> mutableObjectIntMapOf() {
        return new MutableObjectIntMap<>(0, 1, null);
    }

    @NotNull
    public static final <K> ObjectIntMap<K> objectIntMapOf(K k6, int i6) {
        MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0, 1, null);
        mutableObjectIntMap.set(k6, i6);
        return mutableObjectIntMap;
    }

    @NotNull
    public static final <K> ObjectIntMap<K> emptyObjectIntMap() {
        MutableObjectIntMap<Object> mutableObjectIntMap = EmptyObjectIntMap;
        g0.n(mutableObjectIntMap, "null cannot be cast to non-null type androidx.collection.ObjectIntMap<K of androidx.collection.ObjectIntMapKt.emptyObjectIntMap>");
        return mutableObjectIntMap;
    }

    @NotNull
    public static final <K> MutableObjectIntMap<K> mutableObjectIntMapOf(K k6, int i6) {
        MutableObjectIntMap<K> mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, null);
        mutableObjectIntMap.set(k6, i6);
        return mutableObjectIntMap;
    }

    @NotNull
    public static final <K> ObjectIntMap<K> objectIntMap() {
        MutableObjectIntMap<Object> mutableObjectIntMap = EmptyObjectIntMap;
        g0.n(mutableObjectIntMap, "null cannot be cast to non-null type androidx.collection.ObjectIntMap<K of androidx.collection.ObjectIntMapKt.objectIntMap>");
        return mutableObjectIntMap;
    }

    @NotNull
    public static final <K> ObjectIntMap<K> objectIntMapOf(K k6, int i6, K k7, int i7) {
        MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0, 1, null);
        mutableObjectIntMap.set(k6, i6);
        mutableObjectIntMap.set(k7, i7);
        return mutableObjectIntMap;
    }

    @NotNull
    public static final <K> MutableObjectIntMap<K> mutableObjectIntMapOf(K k6, int i6, K k7, int i7) {
        MutableObjectIntMap<K> mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, null);
        mutableObjectIntMap.set(k6, i6);
        mutableObjectIntMap.set(k7, i7);
        return mutableObjectIntMap;
    }

    @NotNull
    public static final <K> ObjectIntMap<K> objectIntMapOf(K k6, int i6, K k7, int i7, K k8, int i8) {
        MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0, 1, null);
        mutableObjectIntMap.set(k6, i6);
        mutableObjectIntMap.set(k7, i7);
        mutableObjectIntMap.set(k8, i8);
        return mutableObjectIntMap;
    }

    @NotNull
    public static final <K> MutableObjectIntMap<K> mutableObjectIntMapOf(K k6, int i6, K k7, int i7, K k8, int i8) {
        MutableObjectIntMap<K> mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, null);
        mutableObjectIntMap.set(k6, i6);
        mutableObjectIntMap.set(k7, i7);
        mutableObjectIntMap.set(k8, i8);
        return mutableObjectIntMap;
    }

    @NotNull
    public static final <K> ObjectIntMap<K> objectIntMapOf(K k6, int i6, K k7, int i7, K k8, int i8, K k9, int i9) {
        MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0, 1, null);
        mutableObjectIntMap.set(k6, i6);
        mutableObjectIntMap.set(k7, i7);
        mutableObjectIntMap.set(k8, i8);
        mutableObjectIntMap.set(k9, i9);
        return mutableObjectIntMap;
    }

    @NotNull
    public static final <K> MutableObjectIntMap<K> mutableObjectIntMapOf(K k6, int i6, K k7, int i7, K k8, int i8, K k9, int i9) {
        MutableObjectIntMap<K> mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, null);
        mutableObjectIntMap.set(k6, i6);
        mutableObjectIntMap.set(k7, i7);
        mutableObjectIntMap.set(k8, i8);
        mutableObjectIntMap.set(k9, i9);
        return mutableObjectIntMap;
    }

    @NotNull
    public static final <K> ObjectIntMap<K> objectIntMapOf(K k6, int i6, K k7, int i7, K k8, int i8, K k9, int i9, K k10, int i10) {
        MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0, 1, null);
        mutableObjectIntMap.set(k6, i6);
        mutableObjectIntMap.set(k7, i7);
        mutableObjectIntMap.set(k8, i8);
        mutableObjectIntMap.set(k9, i9);
        mutableObjectIntMap.set(k10, i10);
        return mutableObjectIntMap;
    }

    @NotNull
    public static final <K> MutableObjectIntMap<K> mutableObjectIntMapOf(K k6, int i6, K k7, int i7, K k8, int i8, K k9, int i9, K k10, int i10) {
        MutableObjectIntMap<K> mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, null);
        mutableObjectIntMap.set(k6, i6);
        mutableObjectIntMap.set(k7, i7);
        mutableObjectIntMap.set(k8, i8);
        mutableObjectIntMap.set(k9, i9);
        mutableObjectIntMap.set(k10, i10);
        return mutableObjectIntMap;
    }
}
