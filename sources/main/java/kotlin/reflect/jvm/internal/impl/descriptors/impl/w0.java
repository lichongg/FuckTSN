package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.s1;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.h2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class w0 extends n implements s1 {

    /* renamed from: f, reason: collision with root package name */
    static final /* synthetic */ boolean f44905f = false;

    /* renamed from: e, reason: collision with root package name */
    protected kotlin.reflect.jvm.internal.impl.types.t0 f44906e;

    @Nullable
    public <V> V N(a.InterfaceC0876a<V> interfaceC0876a) {
        return null;
    }

    public z0 c0() {
        return null;
    }

    public z0 f0() {
        return null;
    }

    public boolean isConst() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean n0() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @Nullable kotlin.reflect.jvm.internal.impl.types.t0 t0Var, @NotNull e1 e1Var) {
        super(kVar, gVar, fVar, e1Var);
        if (kVar == null) {
            T(0);
        }
        if (gVar == null) {
            T(1);
        }
        if (fVar == null) {
            T(2);
        }
        if (e1Var == null) {
            T(3);
        }
        this.f44906e = t0Var;
    }

    @NotNull
    public List<z0> A0() {
        List<z0> list = Collections.EMPTY_LIST;
        if (list == null) {
            T(9);
        }
        return list;
    }

    public void F0(kotlin.reflect.jvm.internal.impl.types.t0 t0Var) {
        this.f44906e = t0Var;
    }

    @NotNull
    public Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.a> e() {
        Set set = Collections.EMPTY_SET;
        if (set == null) {
            T(7);
        }
        return set;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public List<q1> g() {
        List<q1> list = Collections.EMPTY_LIST;
        if (list == null) {
            T(6);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1
    @NotNull
    public kotlin.reflect.jvm.internal.impl.types.t0 getType() {
        kotlin.reflect.jvm.internal.impl.types.t0 t0Var = this.f44906e;
        if (t0Var == null) {
            T(4);
        }
        return t0Var;
    }

    @NotNull
    public List<j1> getTypeParameters() {
        List<j1> list = Collections.EMPTY_LIST;
        if (list == null) {
            T(8);
        }
        return list;
    }

    private static /* synthetic */ void T(int i6) {
        String str;
        int i7;
        switch (i6) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i6) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                i7 = 2;
                break;
            default:
                i7 = 3;
                break;
        }
        Object[] objArr = new Object[i7];
        switch (i6) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = CommonNetImpl.NAME;
                break;
            case 3:
                objArr[0] = SocialConstants.PARAM_SOURCE;
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i6) {
            case 4:
                objArr[1] = "getType";
                break;
            case 5:
                objArr[1] = "getOriginal";
                break;
            case 6:
                objArr[1] = "getValueParameters";
                break;
            case 7:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 10:
                objArr[1] = "getReturnType";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
        }
        switch (i6) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i6) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.n
    @NotNull
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public s1 a() {
        s1 s1Var = (s1) super.a();
        if (s1Var == null) {
            T(5);
        }
        return s1Var;
    }

    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.l c(h2 h2Var) {
        return c(h2Var);
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.types.t0 getReturnType() {
        kotlin.reflect.jvm.internal.impl.types.t0 type = getType();
        if (type == null) {
            T(10);
        }
        return type;
    }
}
