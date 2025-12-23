package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.h1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class t0 extends h {

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private final Function1<kotlin.reflect.jvm.internal.impl.types.t0, Void> f44890k;

    /* renamed from: l, reason: collision with root package name */
    private final List<kotlin.reflect.jvm.internal.impl.types.t0> f44891l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f44892m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private t0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z5, @NotNull Variance variance, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, int i6, @NotNull e1 e1Var, @Nullable Function1<kotlin.reflect.jvm.internal.impl.types.t0, Void> function1, @NotNull h1 h1Var, @NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar) {
        super(nVar, kVar, gVar, fVar, variance, z5, i6, e1Var, h1Var);
        if (kVar == null) {
            T(19);
        }
        if (gVar == null) {
            T(20);
        }
        if (variance == null) {
            T(21);
        }
        if (fVar == null) {
            T(22);
        }
        if (e1Var == null) {
            T(23);
        }
        if (h1Var == null) {
            T(24);
        }
        if (nVar == null) {
            T(25);
        }
        this.f44891l = new ArrayList(1);
        this.f44892m = false;
        this.f44890k = function1;
    }

    private void I0() {
        if (this.f44892m) {
            return;
        }
        throw new IllegalStateException("Type parameter descriptor is not initialized: " + P0());
    }

    private void J0() {
        if (this.f44892m) {
            throw new IllegalStateException("Type parameter descriptor is already initialized: " + P0());
        }
    }

    public static t0 K0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z5, @NotNull Variance variance, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, int i6, @NotNull e1 e1Var, @Nullable Function1<kotlin.reflect.jvm.internal.impl.types.t0, Void> function1, @NotNull h1 h1Var, @NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar) {
        if (kVar == null) {
            T(12);
        }
        if (gVar == null) {
            T(13);
        }
        if (variance == null) {
            T(14);
        }
        if (fVar == null) {
            T(15);
        }
        if (e1Var == null) {
            T(16);
        }
        if (h1Var == null) {
            T(17);
        }
        if (nVar == null) {
            T(18);
        }
        return new t0(kVar, gVar, z5, variance, fVar, i6, e1Var, function1, h1Var, nVar);
    }

    public static t0 L0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z5, @NotNull Variance variance, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, int i6, @NotNull e1 e1Var, @NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar) {
        if (kVar == null) {
            T(6);
        }
        if (gVar == null) {
            T(7);
        }
        if (variance == null) {
            T(8);
        }
        if (fVar == null) {
            T(9);
        }
        if (e1Var == null) {
            T(10);
        }
        if (nVar == null) {
            T(11);
        }
        return K0(kVar, gVar, z5, variance, fVar, i6, e1Var, null, h1.a.f44688a, nVar);
    }

    @NotNull
    public static j1 M0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z5, @NotNull Variance variance, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, int i6, @NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar) {
        if (kVar == null) {
            T(0);
        }
        if (gVar == null) {
            T(1);
        }
        if (variance == null) {
            T(2);
        }
        if (fVar == null) {
            T(3);
        }
        if (nVar == null) {
            T(4);
        }
        t0 L0 = L0(kVar, gVar, z5, variance, fVar, i6, e1.f44683a, nVar);
        L0.H0(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.m(kVar).z());
        L0.Q0();
        return L0;
    }

    private String P0() {
        return getName() + " declared in " + kotlin.reflect.jvm.internal.impl.resolve.i.m(b());
    }

    private static /* synthetic */ void T(int i6) {
        String str = (i6 == 5 || i6 == 28) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i6 == 5 || i6 == 28) ? 2 : 3];
        switch (i6) {
            case 1:
            case 7:
            case 13:
            case 20:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 14:
            case 21:
                objArr[0] = "variance";
                break;
            case 3:
            case 9:
            case 15:
            case 22:
                objArr[0] = CommonNetImpl.NAME;
                break;
            case 4:
            case 11:
            case 18:
            case 25:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 28:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 16:
            case 23:
                objArr[0] = SocialConstants.PARAM_SOURCE;
                break;
            case 17:
                objArr[0] = "supertypeLoopsResolver";
                break;
            case 24:
                objArr[0] = "supertypeLoopsChecker";
                break;
            case 26:
                objArr[0] = "bound";
                break;
            case 27:
                objArr[0] = "type";
                break;
        }
        if (i6 == 5) {
            objArr[1] = "createWithDefaultBound";
        } else if (i6 != 28) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        } else {
            objArr[1] = "resolveUpperBounds";
        }
        switch (i6) {
            case 5:
            case 28:
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createForFurtherModification";
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "<init>";
                break;
            case 26:
                objArr[2] = "addUpperBound";
                break;
            case 27:
                objArr[2] = "reportSupertypeLoopError";
                break;
            default:
                objArr[2] = "createWithDefaultBound";
                break;
        }
        String format = String.format(str, objArr);
        if (i6 != 5 && i6 != 28) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.h
    protected void F0(@NotNull kotlin.reflect.jvm.internal.impl.types.t0 t0Var) {
        if (t0Var == null) {
            T(27);
        }
        Function1<kotlin.reflect.jvm.internal.impl.types.t0, Void> function1 = this.f44890k;
        if (function1 == null) {
            return;
        }
        function1.invoke(t0Var);
    }

    public void H0(@NotNull kotlin.reflect.jvm.internal.impl.types.t0 t0Var) {
        if (t0Var == null) {
            T(26);
        }
        J0();
        N0(t0Var);
    }

    public boolean O0() {
        return this.f44892m;
    }

    private void N0(kotlin.reflect.jvm.internal.impl.types.t0 t0Var) {
        if (kotlin.reflect.jvm.internal.impl.types.x0.a(t0Var)) {
            return;
        }
        this.f44891l.add(t0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.h
    @NotNull
    protected List<kotlin.reflect.jvm.internal.impl.types.t0> G0() {
        I0();
        List<kotlin.reflect.jvm.internal.impl.types.t0> list = this.f44891l;
        if (list == null) {
            T(28);
        }
        return list;
    }

    public void Q0() {
        J0();
        this.f44892m = true;
    }
}
