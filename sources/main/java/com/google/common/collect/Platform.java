package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
final class Platform {
    private Platform() {
    }

    static <T> T[] copy(Object[] objArr, int i6, int i7, T[] tArr) {
        return (T[]) Arrays.copyOfRange(objArr, i6, i7, tArr.getClass());
    }

    static <T> T[] newArray(T[] tArr, int i6) {
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i6));
    }

    static <K, V> Map<K, V> newHashMapWithExpectedSize(int i6) {
        return CompactHashMap.createWithExpectedSize(i6);
    }

    static <E> Set<E> newHashSetWithExpectedSize(int i6) {
        return CompactHashSet.createWithExpectedSize(i6);
    }

    static <K, V> Map<K, V> newLinkedHashMapWithExpectedSize(int i6) {
        return CompactLinkedHashMap.createWithExpectedSize(i6);
    }

    static <E> Set<E> newLinkedHashSetWithExpectedSize(int i6) {
        return CompactLinkedHashSet.createWithExpectedSize(i6);
    }

    static <E> Set<E> preservesInsertionOrderOnAddsSet() {
        return CompactHashSet.create();
    }

    static <K, V> Map<K, V> preservesInsertionOrderOnPutsMap() {
        return CompactHashMap.create();
    }

    static MapMaker tryWeakKeys(MapMaker mapMaker) {
        return mapMaker.weakKeys();
    }

    static int reduceExponentIfGwt(int i6) {
        return i6;
    }

    static int reduceIterationsIfGwt(int i6) {
        return i6;
    }
}
