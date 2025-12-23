package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.h2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class c extends m implements z0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        super(gVar, kotlin.reflect.jvm.internal.impl.name.h.f46363i);
        if (gVar == null) {
            T(0);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public <V> V N(a.InterfaceC0876a<V> interfaceC0876a) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public z0 c0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public z0 f0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean n0() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar) {
        super(gVar, fVar);
        if (gVar == null) {
            T(1);
        }
        if (fVar == null) {
            T(2);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public List<z0> A0() {
        List<z0> list = Collections.EMPTY_LIST;
        if (list == null) {
            T(4);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g1
    @Nullable
    public z0 c(@NotNull h2 h2Var) {
        if (h2Var == null) {
            T(3);
        }
        if (!h2Var.k()) {
            kotlin.reflect.jvm.internal.impl.types.t0 p5 = b() instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? h2Var.p(getType(), Variance.OUT_VARIANCE) : h2Var.p(getType(), Variance.INVARIANT);
            if (p5 == null) {
                return null;
            }
            if (p5 != getType()) {
                return new n0(b(), new kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.k(p5), getAnnotations());
            }
        }
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.a> e() {
        Set set = Collections.EMPTY_SET;
        if (set == null) {
            T(8);
        }
        return set;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public List<q1> g() {
        List<q1> list = Collections.EMPTY_LIST;
        if (list == null) {
            T(7);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n
    @NotNull
    public e1 getSource() {
        e1 e1Var = e1.f44683a;
        if (e1Var == null) {
            T(11);
        }
        return e1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public List<j1> getTypeParameters() {
        List<j1> list = Collections.EMPTY_LIST;
        if (list == null) {
            T(5);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.s getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.s sVar = kotlin.reflect.jvm.internal.impl.descriptors.r.f44949f;
        if (sVar == null) {
            T(9);
        }
        return sVar;
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
            case 11:
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
            case 11:
                i7 = 2;
                break;
            default:
                i7 = 3;
                break;
        }
        Object[] objArr = new Object[i7];
        switch (i6) {
            case 2:
                objArr[0] = CommonNetImpl.NAME;
                break;
            case 3:
                objArr[0] = "substitutor";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        switch (i6) {
            case 4:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 5:
                objArr[1] = "getTypeParameters";
                break;
            case 6:
                objArr[1] = "getType";
                break;
            case 7:
                objArr[1] = "getValueParameters";
                break;
            case 8:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 9:
                objArr[1] = "getVisibility";
                break;
            case 10:
                objArr[1] = "getOriginal";
                break;
            case 11:
                objArr[1] = "getSource";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
        }
        switch (i6) {
            case 3:
                objArr[2] = "substitute";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
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
            case 11:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R W(kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> mVar, D d6) {
        return mVar.g(this, d6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public kotlin.reflect.jvm.internal.impl.types.t0 getReturnType() {
        return getType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1
    @NotNull
    public kotlin.reflect.jvm.internal.impl.types.t0 getType() {
        kotlin.reflect.jvm.internal.impl.types.t0 type = getValue().getType();
        if (type == null) {
            T(6);
        }
        return type;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.m, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.t0 a() {
        return this;
    }
}
