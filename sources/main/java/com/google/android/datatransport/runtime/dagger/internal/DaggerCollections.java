package com.google.android.datatransport.runtime.dagger.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class DaggerCollections {
    private static final int MAX_POWER_OF_TWO = 1073741824;

    private static int calculateInitialCapacity(int i6) {
        if (i6 < 3) {
            return i6 + 1;
        }
        if (i6 < 1073741824) {
            return (int) ((i6 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    static <T> HashSet<T> newHashSetWithExpectedSize(int i6) {
        return new HashSet<>(calculateInitialCapacity(i6));
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMapWithExpectedSize(int i6) {
        return new LinkedHashMap<>(calculateInitialCapacity(i6));
    }

    public static <T> List<T> presizedList(int i6) {
        return i6 == 0 ? Collections.EMPTY_LIST : new ArrayList(i6);
    }

    private DaggerCollections() {
    }

    public static boolean hasDuplicates(List<?> list) {
        if (list.size() < 2) {
            return false;
        }
        if (list.size() == new HashSet(list).size()) {
            return false;
        }
        return true;
    }
}
