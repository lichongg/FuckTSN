package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class o0 extends s implements d1 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected o0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @Nullable d1 d1Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull CallableMemberDescriptor.Kind kind, @NotNull e1 e1Var) {
        super(kVar, d1Var, gVar, fVar, kind, e1Var);
        if (kVar == null) {
            T(0);
        }
        if (gVar == null) {
            T(1);
        }
        if (fVar == null) {
            T(2);
        }
        if (kind == null) {
            T(3);
        }
        if (e1Var == null) {
            T(4);
        }
    }

    private static /* synthetic */ void T(int i6) {
        String str = (i6 == 13 || i6 == 18 || i6 == 23 || i6 == 24 || i6 == 29 || i6 == 30) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i6 == 13 || i6 == 18 || i6 == 23 || i6 == 24 || i6 == 29 || i6 == 30) ? 2 : 3];
        switch (i6) {
            case 1:
            case 6:
            case 27:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = CommonNetImpl.NAME;
                break;
            case 3:
            case 8:
            case 26:
                objArr[0] = "kind";
                break;
            case 4:
            case 9:
            case 28:
                objArr[0] = SocialConstants.PARAM_SOURCE;
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 15:
            case 20:
                objArr[0] = "typeParameters";
                break;
            case 11:
            case 16:
            case 21:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
            case 17:
            case 22:
                objArr[0] = "visibility";
                break;
            case 13:
            case 18:
            case 23:
            case 24:
            case 29:
            case 30:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
                break;
            case 14:
            case 19:
                objArr[0] = "contextReceiverParameters";
                break;
            case 25:
                objArr[0] = "newOwner";
                break;
        }
        if (i6 == 13 || i6 == 18 || i6 == 23) {
            objArr[1] = "initialize";
        } else if (i6 == 24) {
            objArr[1] = "getOriginal";
        } else if (i6 == 29) {
            objArr[1] = "copy";
        } else if (i6 != 30) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = "newCopyBuilder";
        }
        switch (i6) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[2] = "create";
                break;
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                objArr[2] = "initialize";
                break;
            case 13:
            case 18:
            case 23:
            case 24:
            case 29:
            case 30:
                break;
            case 25:
            case 26:
            case 27:
            case 28:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i6 != 13 && i6 != 18 && i6 != 23 && i6 != 24 && i6 != 29 && i6 != 30) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @NotNull
    public static o0 g1(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull CallableMemberDescriptor.Kind kind, @NotNull e1 e1Var) {
        if (kVar == null) {
            T(5);
        }
        if (gVar == null) {
            T(6);
        }
        if (fVar == null) {
            T(7);
        }
        if (kind == null) {
            T(8);
        }
        if (e1Var == null) {
            T(9);
        }
        return new o0(kVar, null, gVar, fVar, kind, e1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s
    @NotNull
    protected s G0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.y yVar, @NotNull CallableMemberDescriptor.Kind kind, @Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull e1 e1Var) {
        if (kVar == null) {
            T(25);
        }
        if (kind == null) {
            T(26);
        }
        if (gVar == null) {
            T(27);
        }
        if (e1Var == null) {
            T(28);
        }
        d1 d1Var = (d1) yVar;
        if (fVar == null) {
            fVar = getName();
        }
        return new o0(kVar, d1Var, gVar, fVar, kind, e1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s
    @NotNull
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public o0 M0(@Nullable z0 z0Var, @Nullable z0 z0Var2, @NotNull List<z0> list, @NotNull List<? extends j1> list2, @NotNull List<q1> list3, @Nullable kotlin.reflect.jvm.internal.impl.types.t0 t0Var, @Nullable Modality modality, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar) {
        if (list == null) {
            T(14);
        }
        if (list2 == null) {
            T(15);
        }
        if (list3 == null) {
            T(16);
        }
        if (sVar == null) {
            T(17);
        }
        o0 j12 = j1(z0Var, z0Var2, list, list2, list3, t0Var, modality, sVar, null);
        if (j12 == null) {
            T(18);
        }
        return j12;
    }

    @NotNull
    public o0 j1(@Nullable z0 z0Var, @Nullable z0 z0Var2, @NotNull List<z0> list, @NotNull List<? extends j1> list2, @NotNull List<q1> list3, @Nullable kotlin.reflect.jvm.internal.impl.types.t0 t0Var, @Nullable Modality modality, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar, @Nullable Map<? extends a.InterfaceC0876a<?>, ?> map) {
        if (list == null) {
            T(19);
        }
        if (list2 == null) {
            T(20);
        }
        if (list3 == null) {
            T(21);
        }
        if (sVar == null) {
            T(22);
        }
        super.M0(z0Var, z0Var2, list, list2, list3, t0Var, modality, sVar);
        if (map != null && !map.isEmpty()) {
            this.D = new LinkedHashMap(map);
        }
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    /* renamed from: f1 */
    public d1 e0(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.s sVar, CallableMemberDescriptor.Kind kind, boolean z5) {
        d1 d1Var = (d1) super.e0(kVar, modality, sVar, kind, z5);
        if (d1Var == null) {
            T(29);
        }
        return d1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.impl.n
    @NotNull
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public d1 a() {
        d1 d1Var = (d1) super.a();
        if (d1Var == null) {
            T(24);
        }
        return d1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.y
    @NotNull
    public y.a<? extends d1> n() {
        y.a n6 = super.n();
        if (n6 == null) {
            T(30);
        }
        return n6;
    }
}
