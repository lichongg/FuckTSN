package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.m0;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.s;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.o1;
import kotlin.reflect.jvm.internal.impl.storage.j;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class f extends k0 implements a {
    private final boolean E;

    @Nullable
    private final Pair<a.InterfaceC0876a<?>, ?> F;
    private t0 G;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.w0, kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean n0() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected f(@NotNull k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull Modality modality, @NotNull s sVar, boolean z5, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull e1 e1Var, @Nullable w0 w0Var, @NotNull CallableMemberDescriptor.Kind kind, boolean z6, @Nullable Pair<a.InterfaceC0876a<?>, ?> pair) {
        super(kVar, w0Var, gVar, modality, sVar, z5, fVar, kind, e1Var, false, false, false, false, false, false);
        if (kVar == null) {
            T(0);
        }
        if (gVar == null) {
            T(1);
        }
        if (modality == null) {
            T(2);
        }
        if (sVar == null) {
            T(3);
        }
        if (fVar == null) {
            T(4);
        }
        if (e1Var == null) {
            T(5);
        }
        if (kind == null) {
            T(6);
        }
        this.G = null;
        this.E = z6;
        this.F = pair;
    }

    private static /* synthetic */ void T(int i6) {
        String str = i6 != 21 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i6 != 21 ? 3 : 2];
        switch (i6) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = CommonNetImpl.NAME;
                break;
            case 5:
            case 12:
            case 18:
                objArr[0] = SocialConstants.PARAM_SOURCE;
                break;
            case 6:
            case 16:
                objArr[0] = "kind";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 14:
                objArr[0] = "newModality";
                break;
            case 15:
                objArr[0] = "newVisibility";
                break;
            case 17:
                objArr[0] = "newName";
                break;
            case 19:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
            case 22:
                objArr[0] = "inType";
                break;
        }
        if (i6 != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i6) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "create";
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            case 21:
                break;
            case 22:
                objArr[2] = "setInType";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i6 == 21) {
            throw new IllegalStateException(format);
        }
    }

    @NotNull
    public static f b1(@NotNull k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull Modality modality, @NotNull s sVar, boolean z5, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull e1 e1Var, boolean z6) {
        if (kVar == null) {
            T(7);
        }
        if (gVar == null) {
            T(8);
        }
        if (modality == null) {
            T(9);
        }
        if (sVar == null) {
            T(10);
        }
        if (fVar == null) {
            T(11);
        }
        if (e1Var == null) {
            T(12);
        }
        return new f(kVar, gVar, modality, sVar, z5, fVar, e1Var, null, CallableMemberDescriptor.Kind.DECLARATION, z6, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k0
    @NotNull
    protected k0 L0(@NotNull k kVar, @NotNull Modality modality, @NotNull s sVar, @Nullable w0 w0Var, @NotNull CallableMemberDescriptor.Kind kind, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull e1 e1Var) {
        if (kVar == null) {
            T(13);
        }
        if (modality == null) {
            T(14);
        }
        if (sVar == null) {
            T(15);
        }
        if (kind == null) {
            T(16);
        }
        if (fVar == null) {
            T(17);
        }
        if (e1Var == null) {
            T(18);
        }
        return new f(kVar, getAnnotations(), modality, sVar, C(), fVar, e1Var, w0Var, kind, this.E, this.F);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k0, kotlin.reflect.jvm.internal.impl.descriptors.impl.w0, kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public <V> V N(a.InterfaceC0876a<V> interfaceC0876a) {
        Pair<a.InterfaceC0876a<?>, ?> pair = this.F;
        if (pair == null || !pair.getFirst().equals(interfaceC0876a)) {
            return null;
        }
        return (V) this.F.getSecond();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k0
    public void V0(@NotNull t0 t0Var) {
        if (t0Var == null) {
            T(22);
        }
        this.G = t0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.a
    @NotNull
    public a k0(@Nullable t0 t0Var, @NotNull List<t0> list, @NotNull t0 t0Var2, @Nullable Pair<a.InterfaceC0876a<?>, ?> pair) {
        l0 l0Var;
        m0 m0Var;
        if (list == null) {
            T(19);
        }
        if (t0Var2 == null) {
            T(20);
        }
        w0 a6 = a() == this ? null : a();
        f fVar = new f(b(), getAnnotations(), i(), getVisibility(), C(), getName(), getSource(), a6, h(), this.E, pair);
        l0 getter = getGetter();
        if (getter != null) {
            l0 l0Var2 = new l0(fVar, getter.getAnnotations(), getter.i(), getter.getVisibility(), getter.Y(), getter.isExternal(), getter.isInline(), h(), a6 == null ? null : a6.getGetter(), getter.getSource());
            l0Var2.I0(getter.x0());
            l0Var2.L0(t0Var2);
            l0Var = l0Var2;
        } else {
            l0Var = null;
        }
        y0 setter = getSetter();
        if (setter != null) {
            m0Var = new m0(fVar, setter.getAnnotations(), setter.i(), setter.getVisibility(), setter.Y(), setter.isExternal(), setter.isInline(), h(), a6 == null ? null : a6.getSetter(), setter.getSource());
            m0Var.I0(m0Var.x0());
            m0Var.M0(setter.g().get(0));
        } else {
            m0Var = null;
        }
        fVar.R0(l0Var, m0Var, O(), D());
        fVar.W0(S0());
        Function0<j<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>>> function0 = this.f44916i;
        if (function0 != null) {
            fVar.G0(this.f44915h, function0);
        }
        fVar.R(e());
        fVar.X0(t0Var2, getTypeParameters(), c0(), t0Var != null ? kotlin.reflect.jvm.internal.impl.resolve.h.i(this, t0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b()) : null, f0.J());
        return fVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k0, kotlin.reflect.jvm.internal.impl.descriptors.impl.w0, kotlin.reflect.jvm.internal.impl.descriptors.s1
    public boolean isConst() {
        t0 type = getType();
        if (this.E && kotlin.reflect.jvm.internal.impl.descriptors.h.a(type)) {
            if (!o1.i(type) || kotlin.reflect.jvm.internal.impl.builtins.j.w0(type)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
