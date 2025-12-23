package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import com.tencent.open.SocialConstants;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.i;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class b extends i implements a {
    static final /* synthetic */ boolean I = false;
    private Boolean G;
    private Boolean H;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @Nullable b bVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z5, @NotNull CallableMemberDescriptor.Kind kind, @NotNull e1 e1Var) {
        super(dVar, bVar, gVar, z5, kind, e1Var);
        if (dVar == null) {
            T(0);
        }
        if (gVar == null) {
            T(1);
        }
        if (kind == null) {
            T(2);
        }
        if (e1Var == null) {
            T(3);
        }
        this.G = null;
        this.H = null;
    }

    private static /* synthetic */ void T(int i6) {
        String str = (i6 == 11 || i6 == 18) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i6 == 11 || i6 == 18) ? 2 : 3];
        switch (i6) {
            case 1:
            case 5:
            case 9:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 13:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 10:
                objArr[0] = SocialConstants.PARAM_SOURCE;
                break;
            case 4:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 7:
            case 12:
                objArr[0] = "newOwner";
                break;
            case 11:
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
            case 14:
                objArr[0] = "sourceElement";
                break;
            case 16:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 17:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i6 == 11) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i6 != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i6) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "createJavaConstructor";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 11:
            case 18:
                break;
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[2] = "createDescriptor";
                break;
            case 16:
            case 17:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i6 != 11 && i6 != 18) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @NotNull
    public static b o1(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z5, @NotNull e1 e1Var) {
        if (dVar == null) {
            T(4);
        }
        if (gVar == null) {
            T(5);
        }
        if (e1Var == null) {
            T(6);
        }
        return new b(dVar, null, gVar, z5, CallableMemberDescriptor.Kind.DECLARATION, e1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s
    public boolean L0() {
        return this.G.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean n0() {
        return this.H.booleanValue();
    }

    @NotNull
    protected b n1(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @Nullable b bVar, @NotNull CallableMemberDescriptor.Kind kind, @NotNull e1 e1Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        if (dVar == null) {
            T(12);
        }
        if (kind == null) {
            T(13);
        }
        if (e1Var == null) {
            T(14);
        }
        if (gVar == null) {
            T(15);
        }
        return new b(dVar, bVar, gVar, this.E, kind, e1Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.i
    @NotNull
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public b G0(@NotNull k kVar, @Nullable y yVar, @NotNull CallableMemberDescriptor.Kind kind, @Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull e1 e1Var) {
        if (kVar == null) {
            T(7);
        }
        if (kind == null) {
            T(8);
        }
        if (gVar == null) {
            T(9);
        }
        if (e1Var == null) {
            T(10);
        }
        if (kind == CallableMemberDescriptor.Kind.DECLARATION || kind == CallableMemberDescriptor.Kind.SYNTHESIZED) {
            b n12 = n1((kotlin.reflect.jvm.internal.impl.descriptors.d) kVar, (b) yVar, kind, e1Var, gVar);
            n12.T0(L0());
            n12.U0(n0());
            return n12;
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + kVar + "\nkind: " + kind);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.a
    @NotNull
    /* renamed from: q1, reason: merged with bridge method [inline-methods] */
    public b k0(@Nullable t0 t0Var, @NotNull List<t0> list, @NotNull t0 t0Var2, @Nullable Pair<a.InterfaceC0876a<?>, ?> pair) {
        if (list == null) {
            T(16);
        }
        if (t0Var2 == null) {
            T(17);
        }
        b G0 = G0(b(), null, h(), null, getAnnotations(), getSource());
        G0.M0(t0Var == null ? null : kotlin.reflect.jvm.internal.impl.resolve.h.i(G0, t0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b()), c0(), f0.J(), getTypeParameters(), h.a(list, g(), G0), t0Var2, i(), getVisibility());
        if (pair != null) {
            G0.P0(pair.getFirst(), pair.getSecond());
        }
        return G0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s
    public void T0(boolean z5) {
        this.G = Boolean.valueOf(z5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s
    public void U0(boolean z5) {
        this.H = Boolean.valueOf(z5);
    }
}
