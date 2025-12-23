package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final e0<b0> f44643a = new e0<>("InvalidModuleNotifier");

    public static final void a(@NotNull f0 f0Var) {
        kotlin.jvm.internal.g0.p(f0Var, "<this>");
        b0 b0Var = (b0) f0Var.U(f44643a);
        if (b0Var != null) {
            b0Var.a(f0Var);
            return;
        }
        throw new InvalidModuleException("Accessing invalid module descriptor " + f0Var);
    }
}
