package kotlin.collections;

import java.util.Map;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "MapAccessorsKt")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f1 {
    @InlineOnly
    private static final <V, V1 extends V> V1 a(Map<? super String, ? extends V> map, Object obj, kotlin.reflect.n<?> property) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(property, "property");
        return (V1) j1.a(map, property.getName());
    }

    @InlineOnly
    @JvmName(name = "getVar")
    private static final <V, V1 extends V> V1 b(Map<? super String, ? extends V> map, Object obj, kotlin.reflect.n<?> property) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(property, "property");
        return (V1) j1.a(map, property.getName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <V> void c(Map<? super String, ? super V> map, Object obj, kotlin.reflect.n<?> property, V v5) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(property, "property");
        map.put(property.getName(), v5);
    }
}
