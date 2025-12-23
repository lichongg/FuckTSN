package androidx.collection;

import kotlin.Pair;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ArrayMapKt {
    @NotNull
    public static final <K, V> ArrayMap<K, V> arrayMapOf() {
        return new ArrayMap<>();
    }

    @NotNull
    public static final <K, V> ArrayMap<K, V> arrayMapOf(@NotNull Pair<? extends K, ? extends V>... pairs) {
        g0.p(pairs, "pairs");
        ArrayMap<K, V> arrayMap = new ArrayMap<>(pairs.length);
        for (Pair<? extends K, ? extends V> pair : pairs) {
            arrayMap.put(pair.getFirst(), pair.getSecond());
        }
        return arrayMap;
    }
}
