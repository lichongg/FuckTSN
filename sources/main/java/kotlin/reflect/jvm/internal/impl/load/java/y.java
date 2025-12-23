package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.kotlin.s;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class y implements ExternalOverridabilityCondition {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f45859a = new a(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        public final boolean a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a superDescriptor, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a subDescriptor) {
            kotlin.jvm.internal.g0.p(superDescriptor, "superDescriptor");
            kotlin.jvm.internal.g0.p(subDescriptor, "subDescriptor");
            if ((subDescriptor instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.e) && (superDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.y)) {
                kotlin.reflect.jvm.internal.impl.load.java.descriptors.e eVar = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.e) subDescriptor;
                eVar.g().size();
                kotlin.reflect.jvm.internal.impl.descriptors.y yVar = (kotlin.reflect.jvm.internal.impl.descriptors.y) superDescriptor;
                yVar.g().size();
                List<q1> g6 = eVar.a().g();
                kotlin.jvm.internal.g0.o(g6, "getValueParameters(...)");
                List<q1> g7 = yVar.a().g();
                kotlin.jvm.internal.g0.o(g7, "getValueParameters(...)");
                for (Pair pair : kotlin.collections.f0.o6(g6, g7)) {
                    q1 q1Var = (q1) pair.component1();
                    q1 q1Var2 = (q1) pair.component2();
                    kotlin.jvm.internal.g0.m(q1Var);
                    boolean z5 = c((kotlin.reflect.jvm.internal.impl.descriptors.y) subDescriptor, q1Var) instanceof s.d;
                    kotlin.jvm.internal.g0.m(q1Var2);
                    if (z5 != (c(yVar, q1Var2) instanceof s.d)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private final boolean b(kotlin.reflect.jvm.internal.impl.descriptors.y yVar) {
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar;
            if (yVar.g().size() != 1) {
                return false;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.k b6 = yVar.b();
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar2 = null;
            if (b6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) b6;
            } else {
                dVar = null;
            }
            if (dVar == null) {
                return false;
            }
            List<q1> g6 = yVar.g();
            kotlin.jvm.internal.g0.o(g6, "getValueParameters(...)");
            kotlin.reflect.jvm.internal.impl.descriptors.f c6 = ((q1) kotlin.collections.f0.m5(g6)).getType().I0().c();
            if (c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                dVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.d) c6;
            }
            if (dVar2 == null || !kotlin.reflect.jvm.internal.impl.builtins.j.s0(dVar) || !kotlin.jvm.internal.g0.g(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.o(dVar), kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.o(dVar2))) {
                return false;
            }
            return true;
        }

        private final kotlin.reflect.jvm.internal.impl.load.kotlin.s c(kotlin.reflect.jvm.internal.impl.descriptors.y yVar, q1 q1Var) {
            if (!kotlin.reflect.jvm.internal.impl.load.kotlin.c0.e(yVar) && !b(yVar)) {
                t0 type = q1Var.getType();
                kotlin.jvm.internal.g0.o(type, "getType(...)");
                return kotlin.reflect.jvm.internal.impl.load.kotlin.c0.g(type);
            }
            t0 type2 = q1Var.getType();
            kotlin.jvm.internal.g0.o(type2, "getType(...)");
            return kotlin.reflect.jvm.internal.impl.load.kotlin.c0.g(kotlin.reflect.jvm.internal.impl.types.typeUtil.e.C(type2));
        }
    }

    private final boolean c(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if ((aVar instanceof CallableMemberDescriptor) && (aVar2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.y) && !kotlin.reflect.jvm.internal.impl.builtins.j.h0(aVar2)) {
            h hVar = h.f45434o;
            kotlin.reflect.jvm.internal.impl.descriptors.y yVar = (kotlin.reflect.jvm.internal.impl.descriptors.y) aVar2;
            kotlin.reflect.jvm.internal.impl.name.f name = yVar.getName();
            kotlin.jvm.internal.g0.o(name, "getName(...)");
            if (!hVar.n(name)) {
                SpecialGenericSignatures.a aVar3 = SpecialGenericSignatures.f45335a;
                kotlin.reflect.jvm.internal.impl.name.f name2 = yVar.getName();
                kotlin.jvm.internal.g0.o(name2, "getName(...)");
                if (!aVar3.k(name2)) {
                    return false;
                }
            }
            CallableMemberDescriptor j6 = r0.j((CallableMemberDescriptor) aVar);
            boolean z5 = aVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.y;
            kotlin.reflect.jvm.internal.impl.descriptors.y yVar2 = z5 ? (kotlin.reflect.jvm.internal.impl.descriptors.y) aVar : null;
            if (!(yVar2 != null && yVar.D0() == yVar2.D0()) && (j6 == null || !yVar.D0())) {
                return true;
            }
            if ((dVar instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.c) && yVar.x0() == null && j6 != null && !r0.l(dVar, j6)) {
                if ((j6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.y) && z5 && h.l((kotlin.reflect.jvm.internal.impl.descriptors.y) j6) != null) {
                    String c6 = kotlin.reflect.jvm.internal.impl.load.kotlin.c0.c(yVar, false, false, 2, null);
                    kotlin.reflect.jvm.internal.impl.descriptors.y a6 = ((kotlin.reflect.jvm.internal.impl.descriptors.y) aVar).a();
                    kotlin.jvm.internal.g0.o(a6, "getOriginal(...)");
                    if (kotlin.jvm.internal.g0.g(c6, kotlin.reflect.jvm.internal.impl.load.kotlin.c0.c(a6, false, false, 2, null))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    @NotNull
    public ExternalOverridabilityCondition.Contract a() {
        return ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    @NotNull
    public ExternalOverridabilityCondition.Result b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a superDescriptor, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a subDescriptor, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        kotlin.jvm.internal.g0.p(superDescriptor, "superDescriptor");
        kotlin.jvm.internal.g0.p(subDescriptor, "subDescriptor");
        return c(superDescriptor, subDescriptor, dVar) ? ExternalOverridabilityCondition.Result.INCOMPATIBLE : f45859a.a(superDescriptor, subDescriptor) ? ExternalOverridabilityCondition.Result.INCOMPATIBLE : ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
