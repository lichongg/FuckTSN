package g3;

import java.util.Map;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.u0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "CollectionsJDK8Kt")
/* loaded from: D:\Downloads\app\classes7.dex */
public final class b {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final <K, V> V a(Map<? extends K, ? extends V> map, K k6, V v5) {
        Object orDefault;
        g0.p(map, "<this>");
        orDefault = map.getOrDefault(k6, v5);
        return (V) orDefault;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final <K, V> boolean b(Map<? extends K, ? extends V> map, K k6, V v5) {
        boolean remove;
        g0.p(map, "<this>");
        remove = u0.k(map).remove(k6, v5);
        return remove;
    }
}
