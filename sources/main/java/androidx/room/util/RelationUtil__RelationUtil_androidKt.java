package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final /* synthetic */ class RelationUtil__RelationUtil_androidKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <K, V> void recursiveFetchArrayMap(@NotNull ArrayMap<K, V> map, boolean z5, @NotNull Function1<? super ArrayMap<K, V>, n1> fetchBlock) {
        int i6;
        g0.p(map, "map");
        g0.p(fetchBlock, "fetchBlock");
        ArrayMap arrayMap = new ArrayMap(999);
        int size = map.size();
        int i7 = 0;
        loop0: while (true) {
            i6 = 0;
            while (i7 < size) {
                if (z5) {
                    arrayMap.put(map.keyAt(i7), map.valueAt(i7));
                } else {
                    arrayMap.put(map.keyAt(i7), null);
                }
                i7++;
                i6++;
                if (i6 == 999) {
                    fetchBlock.invoke(arrayMap);
                    if (!z5) {
                        map.putAll((Map) arrayMap);
                    }
                    arrayMap.clear();
                }
            }
            break loop0;
        }
        if (i6 > 0) {
            fetchBlock.invoke(arrayMap);
            if (z5) {
                return;
            }
            map.putAll((Map) arrayMap);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <K, V> void recursiveFetchHashMap(@NotNull HashMap<K, V> map, boolean z5, @NotNull Function1<? super HashMap<K, V>, n1> fetchBlock) {
        int i6;
        g0.p(map, "map");
        g0.p(fetchBlock, "fetchBlock");
        HashMap hashMap = new HashMap(999);
        loop0: while (true) {
            i6 = 0;
            for (K k6 : map.keySet()) {
                g0.o(k6, "next(...)");
                if (z5) {
                    hashMap.put(k6, map.get(k6));
                } else {
                    hashMap.put(k6, null);
                }
                i6++;
                if (i6 == 999) {
                    fetchBlock.invoke(hashMap);
                    if (!z5) {
                        map.putAll(hashMap);
                    }
                    hashMap.clear();
                }
            }
            break loop0;
        }
        if (i6 > 0) {
            fetchBlock.invoke(hashMap);
            if (z5) {
                return;
            }
            map.putAll(hashMap);
        }
    }
}
