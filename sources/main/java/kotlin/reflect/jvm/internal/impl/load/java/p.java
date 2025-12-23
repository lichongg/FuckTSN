package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.b2;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nErasedOverridabilityCondition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ErasedOverridabilityCondition.kt\norg/jetbrains/kotlin/load/java/ErasedOverridabilityCondition\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,63:1\n1255#2,2:64\n*S KotlinDebug\n*F\n+ 1 ErasedOverridabilityCondition.kt\norg/jetbrains/kotlin/load/java/ErasedOverridabilityCondition\n*L\n44#1:64,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p implements ExternalOverridabilityCondition {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45730a;

        static {
            int[] iArr = new int[OverridingUtil.OverrideCompatibilityInfo.Result.values().length];
            try {
                iArr[OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f45730a = iArr;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    @NotNull
    public ExternalOverridabilityCondition.Contract a() {
        return ExternalOverridabilityCondition.Contract.SUCCESS_ONLY;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    @NotNull
    public ExternalOverridabilityCondition.Result b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a superDescriptor, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a subDescriptor, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        kotlin.jvm.internal.g0.p(superDescriptor, "superDescriptor");
        kotlin.jvm.internal.g0.p(subDescriptor, "subDescriptor");
        if (subDescriptor instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.e) {
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.e eVar = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.e) subDescriptor;
            List<j1> typeParameters = eVar.getTypeParameters();
            kotlin.jvm.internal.g0.o(typeParameters, "getTypeParameters(...)");
            if (typeParameters.isEmpty()) {
                OverridingUtil.OverrideCompatibilityInfo w5 = OverridingUtil.w(superDescriptor, subDescriptor);
                b2 b2Var = null;
                byte b6 = 0;
                if ((w5 != null ? w5.c() : null) != null) {
                    return ExternalOverridabilityCondition.Result.UNKNOWN;
                }
                List<q1> g6 = eVar.g();
                kotlin.jvm.internal.g0.o(g6, "getValueParameters(...)");
                kotlin.sequences.m N1 = kotlin.sequences.p.N1(kotlin.collections.f0.E1(g6), o.f45728a);
                t0 returnType = eVar.getReturnType();
                kotlin.jvm.internal.g0.m(returnType);
                kotlin.sequences.m S2 = kotlin.sequences.p.S2(N1, returnType);
                z0 f02 = eVar.f0();
                for (t0 t0Var : kotlin.sequences.p.R2(S2, kotlin.collections.f0.R(f02 != null ? f02.getType() : null))) {
                    if (!t0Var.G0().isEmpty() && !(t0Var.L0() instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.types.j)) {
                        return ExternalOverridabilityCondition.Result.UNKNOWN;
                    }
                }
                kotlin.reflect.jvm.internal.impl.descriptors.a c6 = superDescriptor.c(new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.h(b2Var, 1, b6 == true ? 1 : 0).c());
                if (c6 == null) {
                    return ExternalOverridabilityCondition.Result.UNKNOWN;
                }
                if (c6 instanceof d1) {
                    d1 d1Var = (d1) c6;
                    List<j1> typeParameters2 = d1Var.getTypeParameters();
                    kotlin.jvm.internal.g0.o(typeParameters2, "getTypeParameters(...)");
                    if (!typeParameters2.isEmpty()) {
                        c6 = d1Var.n().k(kotlin.collections.f0.J()).build();
                        kotlin.jvm.internal.g0.m(c6);
                    }
                }
                OverridingUtil.OverrideCompatibilityInfo.Result c7 = OverridingUtil.f46633f.F(c6, subDescriptor, false).c();
                kotlin.jvm.internal.g0.o(c7, "getResult(...)");
                return a.f45730a[c7.ordinal()] == 1 ? ExternalOverridabilityCondition.Result.OVERRIDABLE : ExternalOverridabilityCondition.Result.UNKNOWN;
            }
        }
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t0 d(q1 q1Var) {
        return q1Var.getType();
    }
}
