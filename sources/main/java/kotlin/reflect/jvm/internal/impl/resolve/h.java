package kotlin.reflect.jvm.internal.impl.resolve;

import com.tencent.open.SocialConstants;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.m0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.e2;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.t1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class h {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a extends kotlin.reflect.jvm.internal.impl.descriptors.impl.i {
        private static /* synthetic */ void T(int i6) {
            Object[] objArr = new Object[3];
            if (i6 != 1) {
                objArr[0] = "containingClass";
            } else {
                objArr[0] = SocialConstants.PARAM_SOURCE;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory$DefaultClassConstructorDescriptor";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull e1 e1Var, boolean z5) {
            super(dVar, null, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b(), true, CallableMemberDescriptor.Kind.DECLARATION, e1Var);
            if (dVar == null) {
                T(0);
            }
            if (e1Var == null) {
                T(1);
            }
            l1(Collections.EMPTY_LIST, i.k(dVar, z5));
        }
    }

    private static /* synthetic */ void a(int i6) {
        String str = (i6 == 12 || i6 == 23 || i6 == 25) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i6 == 12 || i6 == 23 || i6 == 25) ? 2 : 3];
        switch (i6) {
            case 1:
            case 4:
            case 8:
            case 14:
            case 16:
            case 18:
            case 31:
            case 33:
            case 35:
                objArr[0] = "annotations";
                break;
            case 2:
            case 5:
            case 9:
                objArr[0] = "parameterAnnotations";
                break;
            case 3:
            case 7:
            case 13:
            case 15:
            case 17:
            default:
                objArr[0] = "propertyDescriptor";
                break;
            case 6:
            case 11:
            case 19:
                objArr[0] = "sourceElement";
                break;
            case 10:
                objArr[0] = "visibility";
                break;
            case 12:
            case 23:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
                break;
            case 20:
                objArr[0] = "containingClass";
                break;
            case 21:
                objArr[0] = SocialConstants.PARAM_SOURCE;
                break;
            case 22:
            case 24:
            case 26:
                objArr[0] = "enumClass";
                break;
            case 27:
            case 28:
            case 29:
                objArr[0] = "descriptor";
                break;
            case 30:
            case 32:
            case 34:
                objArr[0] = "owner";
                break;
        }
        if (i6 == 12) {
            objArr[1] = "createSetter";
        } else if (i6 == 23) {
            objArr[1] = "createEnumValuesMethod";
        } else if (i6 != 25) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
        } else {
            objArr[1] = "createEnumValueOfMethod";
        }
        switch (i6) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "createSetter";
                break;
            case 12:
            case 23:
            case 25:
                break;
            case 13:
            case 14:
                objArr[2] = "createDefaultGetter";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[2] = "createGetter";
                break;
            case 20:
            case 21:
                objArr[2] = "createPrimaryConstructorForObject";
                break;
            case 22:
                objArr[2] = "createEnumValuesMethod";
                break;
            case 24:
                objArr[2] = "createEnumValueOfMethod";
                break;
            case 26:
                objArr[2] = "createEnumEntriesProperty";
                break;
            case 27:
                objArr[2] = "isEnumValuesMethod";
                break;
            case 28:
                objArr[2] = "isEnumValueOfMethod";
                break;
            case 29:
                objArr[2] = "isEnumSpecialMethod";
                break;
            case 30:
            case 31:
                objArr[2] = "createExtensionReceiverParameterForCallable";
                break;
            case 32:
            case 33:
                objArr[2] = "createContextReceiverParameterForCallable";
                break;
            case 34:
            case 35:
                objArr[2] = "createContextReceiverParameterForClass";
                break;
            default:
                objArr[2] = "createDefaultSetter";
                break;
        }
        String format = String.format(str, objArr);
        if (i6 != 12 && i6 != 23 && i6 != 25) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Nullable
    public static z0 b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar, @Nullable t0 t0Var, @Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, int i6) {
        if (aVar == null) {
            a(32);
        }
        if (gVar == null) {
            a(33);
        }
        if (t0Var == null) {
            return null;
        }
        return new n0(aVar, new kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.c(aVar, t0Var, fVar, null), gVar, kotlin.reflect.jvm.internal.impl.name.g.a(i6));
    }

    @Nullable
    public static z0 c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @Nullable t0 t0Var, @Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, int i6) {
        if (dVar == null) {
            a(34);
        }
        if (gVar == null) {
            a(35);
        }
        if (t0Var == null) {
            return null;
        }
        return new n0(dVar, new kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.b(dVar, t0Var, fVar, null), gVar, kotlin.reflect.jvm.internal.impl.name.g.a(i6));
    }

    @NotNull
    public static l0 d(@NotNull w0 w0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        if (w0Var == null) {
            a(13);
        }
        if (gVar == null) {
            a(14);
        }
        return j(w0Var, gVar, true, false, false);
    }

    @NotNull
    public static m0 e(@NotNull w0 w0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar2) {
        if (w0Var == null) {
            a(0);
        }
        if (gVar == null) {
            a(1);
        }
        if (gVar2 == null) {
            a(2);
        }
        return n(w0Var, gVar, gVar2, true, false, false, w0Var.getSource());
    }

    @Nullable
    public static w0 f(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (dVar == null) {
            a(26);
        }
        f0 g6 = i.g(dVar);
        kotlin.reflect.jvm.internal.impl.descriptors.d a6 = u.a(g6).a(g6);
        if (a6 == null) {
            return null;
        }
        g.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g b6 = aVar.b();
        Modality modality = Modality.FINAL;
        kotlin.reflect.jvm.internal.impl.descriptors.s sVar = kotlin.reflect.jvm.internal.impl.descriptors.r.f44948e;
        kotlin.reflect.jvm.internal.impl.name.f fVar = kotlin.reflect.jvm.internal.impl.builtins.o.f44561e;
        CallableMemberDescriptor.Kind kind = CallableMemberDescriptor.Kind.SYNTHESIZED;
        k0 K0 = k0.K0(dVar, b6, modality, sVar, false, fVar, kind, dVar.getSource(), false, false, false, false, false, false);
        l0 l0Var = new l0(K0, aVar.b(), modality, sVar, false, false, false, kind, null, dVar.getSource());
        K0.Q0(l0Var, null);
        kotlin.reflect.jvm.internal.impl.types.e1 j6 = kotlin.reflect.jvm.internal.impl.types.w0.j(t1.f47332b.k(), a6.o(), Collections.singletonList(new e2(dVar.s())), false);
        List<? extends j1> list = Collections.EMPTY_LIST;
        K0.X0(j6, list, null, null, list);
        l0Var.L0(K0.getReturnType());
        return K0;
    }

    @NotNull
    public static d1 g(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (dVar == null) {
            a(24);
        }
        g.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0;
        o0 g12 = o0.g1(dVar, aVar.b(), kotlin.reflect.jvm.internal.impl.builtins.o.f44562f, CallableMemberDescriptor.Kind.SYNTHESIZED, dVar.getSource());
        u0 u0Var = new u0(g12, null, 0, aVar.b(), kotlin.reflect.jvm.internal.impl.name.f.h("value"), kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.m(dVar).X(), false, false, false, null, dVar.getSource());
        List<z0> list = Collections.EMPTY_LIST;
        o0 M0 = g12.M0(null, null, list, list, Collections.singletonList(u0Var), dVar.s(), Modality.FINAL, kotlin.reflect.jvm.internal.impl.descriptors.r.f44948e);
        if (M0 == null) {
            a(25);
        }
        return M0;
    }

    @NotNull
    public static d1 h(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (dVar == null) {
            a(22);
        }
        o0 g12 = o0.g1(dVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b(), kotlin.reflect.jvm.internal.impl.builtins.o.f44560d, CallableMemberDescriptor.Kind.SYNTHESIZED, dVar.getSource());
        List<z0> list = Collections.EMPTY_LIST;
        o0 M0 = g12.M0(null, null, list, list, list, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.m(dVar).m(Variance.INVARIANT, dVar.s()), Modality.FINAL, kotlin.reflect.jvm.internal.impl.descriptors.r.f44948e);
        if (M0 == null) {
            a(23);
        }
        return M0;
    }

    @Nullable
    public static z0 i(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar, @Nullable t0 t0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        if (aVar == null) {
            a(30);
        }
        if (gVar == null) {
            a(31);
        }
        if (t0Var == null) {
            return null;
        }
        return new n0(aVar, new kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.d(aVar, t0Var, null), gVar);
    }

    @NotNull
    public static l0 j(@NotNull w0 w0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z5, boolean z6, boolean z7) {
        if (w0Var == null) {
            a(15);
        }
        if (gVar == null) {
            a(16);
        }
        return k(w0Var, gVar, z5, z6, z7, w0Var.getSource());
    }

    @NotNull
    public static l0 k(@NotNull w0 w0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z5, boolean z6, boolean z7, @NotNull e1 e1Var) {
        if (w0Var == null) {
            a(17);
        }
        if (gVar == null) {
            a(18);
        }
        if (e1Var == null) {
            a(19);
        }
        return new l0(w0Var, gVar, w0Var.i(), w0Var.getVisibility(), z5, z6, z7, CallableMemberDescriptor.Kind.DECLARATION, null, e1Var);
    }

    @NotNull
    public static kotlin.reflect.jvm.internal.impl.descriptors.impl.i l(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull e1 e1Var) {
        if (dVar == null) {
            a(20);
        }
        if (e1Var == null) {
            a(21);
        }
        return new a(dVar, e1Var, false);
    }

    @NotNull
    public static m0 m(@NotNull w0 w0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar2, boolean z5, boolean z6, boolean z7, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar, @NotNull e1 e1Var) {
        if (w0Var == null) {
            a(7);
        }
        if (gVar == null) {
            a(8);
        }
        if (gVar2 == null) {
            a(9);
        }
        if (sVar == null) {
            a(10);
        }
        if (e1Var == null) {
            a(11);
        }
        m0 m0Var = new m0(w0Var, gVar, w0Var.i(), sVar, z5, z6, z7, CallableMemberDescriptor.Kind.DECLARATION, null, e1Var);
        m0Var.M0(m0.K0(m0Var, w0Var.getType(), gVar2));
        return m0Var;
    }

    @NotNull
    public static m0 n(@NotNull w0 w0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar2, boolean z5, boolean z6, boolean z7, @NotNull e1 e1Var) {
        if (w0Var == null) {
            a(3);
        }
        if (gVar == null) {
            a(4);
        }
        if (gVar2 == null) {
            a(5);
        }
        if (e1Var == null) {
            a(6);
        }
        return m(w0Var, gVar, gVar2, z5, z6, z7, w0Var.getVisibility(), e1Var);
    }

    private static boolean o(@NotNull y yVar) {
        if (yVar == null) {
            a(29);
        }
        return yVar.h() == CallableMemberDescriptor.Kind.SYNTHESIZED && i.A(yVar.b());
    }

    public static boolean p(@NotNull y yVar) {
        if (yVar == null) {
            a(28);
        }
        return yVar.getName().equals(kotlin.reflect.jvm.internal.impl.builtins.o.f44562f) && o(yVar);
    }

    public static boolean q(@NotNull y yVar) {
        if (yVar == null) {
            a(27);
        }
        return yVar.getName().equals(kotlin.reflect.jvm.internal.impl.builtins.o.f44560d) && o(yVar);
    }
}
