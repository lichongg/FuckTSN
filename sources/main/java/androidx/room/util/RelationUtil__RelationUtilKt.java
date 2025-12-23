package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final /* synthetic */ class RelationUtil__RelationUtilKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <V> void recursiveFetchLongSparseArray(@NotNull LongSparseArray<V> map, boolean z5, @NotNull Function1<? super LongSparseArray<V>, n1> fetchBlock) {
        int i6;
        g0.p(map, "map");
        g0.p(fetchBlock, "fetchBlock");
        LongSparseArray<? extends V> longSparseArray = new LongSparseArray<>(999);
        int size = map.size();
        int i7 = 0;
        loop0: while (true) {
            i6 = 0;
            while (i7 < size) {
                if (z5) {
                    longSparseArray.put(map.keyAt(i7), map.valueAt(i7));
                } else {
                    longSparseArray.put(map.keyAt(i7), null);
                }
                i7++;
                i6++;
                if (i6 == 999) {
                    fetchBlock.invoke(longSparseArray);
                    if (!z5) {
                        map.putAll(longSparseArray);
                    }
                    longSparseArray.clear();
                }
            }
            break loop0;
        }
        if (i6 > 0) {
            fetchBlock.invoke(longSparseArray);
            if (z5) {
                return;
            }
            map.putAll(longSparseArray);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <K, V> void recursiveFetchMap(@NotNull Map<K, V> map, boolean z5, @NotNull Function1<? super Map<K, V>, n1> fetchBlock) {
        int i6;
        g0.p(map, "map");
        g0.p(fetchBlock, "fetchBlock");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        loop0: while (true) {
            i6 = 0;
            for (K k6 : map.keySet()) {
                if (z5) {
                    linkedHashMap.put(k6, map.get(k6));
                } else {
                    linkedHashMap.put(k6, null);
                }
                i6++;
                if (i6 == 999) {
                    fetchBlock.invoke(linkedHashMap);
                    if (!z5) {
                        map.putAll(linkedHashMap);
                    }
                    linkedHashMap.clear();
                }
            }
            break loop0;
        }
        if (i6 > 0) {
            fetchBlock.invoke(linkedHashMap);
            if (z5) {
                return;
            }
            map.putAll(linkedHashMap);
        }
    }
}
