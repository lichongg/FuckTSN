package kotlin;

import com.daimajia.numberprogressbar.BuildConfig;
import kotlin.internal.InlineOnly;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f0 {
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <V> V a(kotlin.reflect.o<? extends V> oVar, Object obj, kotlin.reflect.n<?> property) {
        kotlin.jvm.internal.g0.p(oVar, "<this>");
        kotlin.jvm.internal.g0.p(property, "property");
        return oVar.get();
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <T, V> V b(kotlin.reflect.p<T, ? extends V> pVar, T t5, kotlin.reflect.n<?> property) {
        kotlin.jvm.internal.g0.p(pVar, "<this>");
        kotlin.jvm.internal.g0.p(property, "property");
        return pVar.get(t5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <V> void c(kotlin.reflect.k<V> kVar, Object obj, kotlin.reflect.n<?> property, V v5) {
        kotlin.jvm.internal.g0.p(kVar, "<this>");
        kotlin.jvm.internal.g0.p(property, "property");
        kVar.set(v5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <T, V> void d(kotlin.reflect.l<T, V> lVar, T t5, kotlin.reflect.n<?> property, V v5) {
        kotlin.jvm.internal.g0.p(lVar, "<this>");
        kotlin.jvm.internal.g0.p(property, "property");
        lVar.set(t5, v5);
    }
}
