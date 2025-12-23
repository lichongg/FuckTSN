package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\ndescriptorUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 descriptorUtil.kt\norg/jetbrains/kotlin/descriptors/DescriptorUtilKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 coreLib.kt\norg/jetbrains/kotlin/utils/CoreLibKt\n*L\n1#1,113:1\n1#2:114\n19#3:115\n*S KotlinDebug\n*F\n+ 1 descriptorUtil.kt\norg/jetbrains/kotlin/descriptors/DescriptorUtilKt\n*L\n38#1:115\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class q {
    @Nullable
    public static final f a(@NotNull k kVar) {
        kotlin.jvm.internal.g0.p(kVar, "<this>");
        k b6 = kVar.b();
        if (b6 != null && !(kVar instanceof l0)) {
            if (!b(b6)) {
                return a(b6);
            }
            if (b6 instanceof f) {
                return (f) b6;
            }
        }
        return null;
    }

    public static final boolean b(@NotNull k kVar) {
        kotlin.jvm.internal.g0.p(kVar, "<this>");
        return kVar.b() instanceof l0;
    }

    public static final boolean c(@NotNull y yVar) {
        kotlin.reflect.jvm.internal.impl.types.e1 s5;
        kotlin.reflect.jvm.internal.impl.types.t0 E;
        kotlin.reflect.jvm.internal.impl.types.t0 returnType;
        kotlin.jvm.internal.g0.p(yVar, "<this>");
        k b6 = yVar.b();
        d dVar = b6 instanceof d ? (d) b6 : null;
        if (dVar != null) {
            d dVar2 = kotlin.reflect.jvm.internal.impl.resolve.j.g(dVar) ? dVar : null;
            if (dVar2 != null && (s5 = dVar2.s()) != null && (E = kotlin.reflect.jvm.internal.impl.types.typeUtil.e.E(s5)) != null && (returnType = yVar.getReturnType()) != null && kotlin.jvm.internal.g0.g(yVar.getName(), kotlin.reflect.jvm.internal.impl.util.t.f47431e) && ((kotlin.reflect.jvm.internal.impl.types.typeUtil.e.t(returnType) || kotlin.reflect.jvm.internal.impl.types.typeUtil.e.u(returnType)) && yVar.g().size() == 1)) {
                kotlin.reflect.jvm.internal.impl.types.t0 type = yVar.g().get(0).getType();
                kotlin.jvm.internal.g0.o(type, "getType(...)");
                if (kotlin.jvm.internal.g0.g(kotlin.reflect.jvm.internal.impl.types.typeUtil.e.E(type), E) && yVar.A0().isEmpty() && yVar.f0() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    public static final d d(@NotNull f0 f0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull u3.b lookupLocation) {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k G;
        kotlin.jvm.internal.g0.p(f0Var, "<this>");
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        kotlin.jvm.internal.g0.p(lookupLocation, "lookupLocation");
        if (fqName.c()) {
            return null;
        }
        f g6 = f0Var.M(fqName.d()).r().g(fqName.f(), lookupLocation);
        d dVar = g6 instanceof d ? (d) g6 : null;
        if (dVar != null) {
            return dVar;
        }
        d d6 = d(f0Var, fqName.d(), lookupLocation);
        f g7 = (d6 == null || (G = d6.G()) == null) ? null : G.g(fqName.f(), lookupLocation);
        if (g7 instanceof d) {
            return (d) g7;
        }
        return null;
    }
}
