package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class q0 {
    public static final void a(@NotNull m0 m0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull Collection<l0> packageFragments) {
        kotlin.jvm.internal.g0.p(m0Var, "<this>");
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        kotlin.jvm.internal.g0.p(packageFragments, "packageFragments");
        if (m0Var instanceof r0) {
            ((r0) m0Var).b(fqName, packageFragments);
        } else {
            packageFragments.addAll(m0Var.a(fqName));
        }
    }

    public static final boolean b(@NotNull m0 m0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.g0.p(m0Var, "<this>");
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        return m0Var instanceof r0 ? ((r0) m0Var).c(fqName) : c(m0Var, fqName).isEmpty();
    }

    @NotNull
    public static final List<l0> c(@NotNull m0 m0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.g0.p(m0Var, "<this>");
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        a(m0Var, fqName, arrayList);
        return arrayList;
    }
}
