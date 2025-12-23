package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.util.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n<K, V, T extends V> extends a.AbstractC0924a<K, V, T> implements kotlin.properties.e<a<K, V>, V> {
    @Override // kotlin.properties.e
    @Nullable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public T a(@NotNull a<K, V> thisRef, @NotNull kotlin.reflect.n<?> property) {
        g0.p(thisRef, "thisRef");
        g0.p(property, "property");
        return c(thisRef);
    }

    public n(int i6) {
        super(i6);
    }
}
