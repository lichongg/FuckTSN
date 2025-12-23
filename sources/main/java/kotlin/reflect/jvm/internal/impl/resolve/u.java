package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final e0<t> f46811a = new e0<>("StdlibClassFinder");

    @NotNull
    public static final t a(@NotNull f0 f0Var) {
        g0.p(f0Var, "<this>");
        t tVar = (t) f0Var.U(f46811a);
        return tVar == null ? b.f46651a : tVar;
    }
}
