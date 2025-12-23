package kotlin.reflect.jvm.internal.impl.types;

import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class d0 {
    private static /* synthetic */ void a(int i6) {
        String str = i6 != 4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i6 != 4 ? 3 : 2];
        switch (i6) {
            case 1:
            case 6:
                objArr[0] = "originalSubstitution";
                break;
            case 2:
            case 7:
                objArr[0] = "newContainingDeclaration";
                break;
            case 3:
            case 8:
                objArr[0] = "result";
                break;
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            case 5:
            default:
                objArr[0] = "typeParameters";
                break;
        }
        if (i6 != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        } else {
            objArr[1] = "substituteTypeParameters";
        }
        if (i6 != 4) {
            objArr[2] = "substituteTypeParameters";
        }
        String format = String.format(str, objArr);
        if (i6 == 4) {
            throw new IllegalStateException(format);
        }
    }

    @NotNull
    public static h2 b(@NotNull List<kotlin.reflect.jvm.internal.impl.descriptors.j1> list, @NotNull f2 f2Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull List<kotlin.reflect.jvm.internal.impl.descriptors.j1> list2) {
        if (list == null) {
            a(0);
        }
        if (f2Var == null) {
            a(1);
        }
        if (kVar == null) {
            a(2);
        }
        if (list2 == null) {
            a(3);
        }
        h2 c6 = c(list, f2Var, kVar, list2, null);
        if (c6 != null) {
            return c6;
        }
        throw new AssertionError("Substitution failed");
    }

    @Nullable
    public static h2 c(@NotNull List<kotlin.reflect.jvm.internal.impl.descriptors.j1> list, @NotNull f2 f2Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull List<kotlin.reflect.jvm.internal.impl.descriptors.j1> list2, @Nullable boolean[] zArr) {
        if (list == null) {
            a(5);
        }
        if (f2Var == null) {
            a(6);
        }
        if (kVar == null) {
            a(7);
        }
        if (list2 == null) {
            a(8);
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        int i6 = 0;
        for (kotlin.reflect.jvm.internal.impl.descriptors.j1 j1Var : list) {
            kotlin.reflect.jvm.internal.impl.descriptors.impl.t0 L0 = kotlin.reflect.jvm.internal.impl.descriptors.impl.t0.L0(kVar, j1Var.getAnnotations(), j1Var.j(), j1Var.l(), j1Var.getName(), i6, kotlin.reflect.jvm.internal.impl.descriptors.e1.f44683a, j1Var.d0());
            hashMap.put(j1Var.o(), new e2(L0.s()));
            hashMap2.put(j1Var, L0);
            list2.add(L0);
            i6++;
        }
        x1 j6 = x1.j(hashMap);
        h2 h6 = h2.h(f2Var, j6);
        h2 h7 = h2.h(f2Var.h(), j6);
        for (kotlin.reflect.jvm.internal.impl.descriptors.j1 j1Var2 : list) {
            kotlin.reflect.jvm.internal.impl.descriptors.impl.t0 t0Var = (kotlin.reflect.jvm.internal.impl.descriptors.impl.t0) hashMap2.get(j1Var2);
            for (t0 t0Var2 : j1Var2.getUpperBounds()) {
                kotlin.reflect.jvm.internal.impl.descriptors.f c6 = t0Var2.I0().c();
                t0 p5 = (((c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.j1) && kotlin.reflect.jvm.internal.impl.types.typeUtil.e.q((kotlin.reflect.jvm.internal.impl.descriptors.j1) c6)) ? h6 : h7).p(t0Var2, Variance.OUT_VARIANCE);
                if (p5 == null) {
                    return null;
                }
                if (p5 != t0Var2 && zArr != null) {
                    zArr[0] = true;
                }
                t0Var.H0(p5);
            }
            t0Var.Q0();
        }
        return h6;
    }
}
