package kotlin.reflect.full;

import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.p2;
import kotlin.reflect.p;
import kotlin.reflect.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "KProperties")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j {
    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Object a(@NotNull p<?, ?> pVar) {
        g0.p(pVar, "<this>");
        return pVar.getDelegate(p2.f47544m.a());
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final <D> Object b(@NotNull q<D, ?, ?> qVar, D d6) {
        g0.p(qVar, "<this>");
        return qVar.getDelegate(d6, p2.f47544m.a());
    }
}
