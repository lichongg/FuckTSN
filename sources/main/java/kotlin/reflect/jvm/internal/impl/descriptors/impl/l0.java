package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.tencent.open.SocialConstants;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class l0 extends j0 implements kotlin.reflect.jvm.internal.impl.descriptors.x0 {

    /* renamed from: n, reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.types.t0 f44805n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.x0 f44806o;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.x0> e() {
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.v0> G0 = super.G0(true);
        if (G0 == null) {
            T(6);
        }
        return G0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.w0 w0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull Modality modality, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar, boolean z5, boolean z6, boolean z7, @NotNull CallableMemberDescriptor.Kind kind, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.x0 x0Var, @NotNull e1 e1Var) {
        super(modality, sVar, w0Var, gVar, kotlin.reflect.jvm.internal.impl.name.f.k("<get-" + w0Var.getName() + ">"), z5, z6, z7, kind, e1Var);
        if (w0Var == null) {
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
        if (kind == null) {
            T(4);
        }
        if (e1Var == null) {
            T(5);
        }
        this.f44806o = x0Var != null ? x0Var : this;
    }

    private static /* synthetic */ void T(int i6) {
        String str = (i6 == 6 || i6 == 7 || i6 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i6 == 6 || i6 == 7 || i6 == 8) ? 2 : 3];
        switch (i6) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "visibility";
                break;
            case 4:
                objArr[0] = "kind";
                break;
            case 5:
                objArr[0] = SocialConstants.PARAM_SOURCE;
                break;
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        if (i6 == 6) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i6 == 7) {
            objArr[1] = "getValueParameters";
        } else if (i6 != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i6 != 6 && i6 != 7 && i6 != 8) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i6 != 6 && i6 != 7 && i6 != 8) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.j0, kotlin.reflect.jvm.internal.impl.descriptors.impl.n
    @NotNull
    /* renamed from: K0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.x0 a() {
        kotlin.reflect.jvm.internal.impl.descriptors.x0 x0Var = this.f44806o;
        if (x0Var == null) {
            T(8);
        }
        return x0Var;
    }

    public void L0(kotlin.reflect.jvm.internal.impl.types.t0 t0Var) {
        if (t0Var == null) {
            t0Var = h0().getType();
        }
        this.f44805n = t0Var;
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public kotlin.reflect.jvm.internal.impl.types.t0 getReturnType() {
        return this.f44805n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R W(kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> mVar, D d6) {
        return mVar.j(this, d6);
    }
}
