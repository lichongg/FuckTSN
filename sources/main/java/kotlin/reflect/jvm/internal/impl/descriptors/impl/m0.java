package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.tencent.open.SocialConstants;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class m0 extends j0 implements y0 {

    /* renamed from: p, reason: collision with root package name */
    static final /* synthetic */ boolean f44808p = false;

    /* renamed from: n, reason: collision with root package name */
    private q1 f44809n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private final y0 f44810o;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public Collection<? extends y0> e() {
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.v0> G0 = super.G0(false);
        if (G0 == null) {
            T(10);
        }
        return G0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.w0 w0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull Modality modality, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar, boolean z5, boolean z6, boolean z7, @NotNull CallableMemberDescriptor.Kind kind, @Nullable y0 y0Var, @NotNull e1 e1Var) {
        super(modality, sVar, w0Var, gVar, kotlin.reflect.jvm.internal.impl.name.f.k("<set-" + w0Var.getName() + ">"), z5, z6, z7, kind, e1Var);
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
        this.f44810o = y0Var != null ? y0Var : this;
    }

    public static u0 K0(@NotNull y0 y0Var, @NotNull kotlin.reflect.jvm.internal.impl.types.t0 t0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        if (y0Var == null) {
            T(7);
        }
        if (t0Var == null) {
            T(8);
        }
        if (gVar == null) {
            T(9);
        }
        return new u0(y0Var, null, 0, gVar, kotlin.reflect.jvm.internal.impl.name.h.f46370p, t0Var, false, false, false, null, e1.f44683a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.j0, kotlin.reflect.jvm.internal.impl.descriptors.impl.n
    @NotNull
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public y0 a() {
        y0 y0Var = this.f44810o;
        if (y0Var == null) {
            T(13);
        }
        return y0Var;
    }

    public void M0(@NotNull q1 q1Var) {
        if (q1Var == null) {
            T(6);
        }
        this.f44809n = q1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public List<q1> g() {
        q1 q1Var = this.f44809n;
        if (q1Var == null) {
            throw new IllegalStateException();
        }
        List<q1> singletonList = Collections.singletonList(q1Var);
        if (singletonList == null) {
            T(11);
        }
        return singletonList;
    }

    private static /* synthetic */ void T(int i6) {
        String str;
        int i7;
        switch (i6) {
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i6) {
            case 10:
            case 11:
            case 12:
            case 13:
                i7 = 2;
                break;
            default:
                i7 = 3;
                break;
        }
        Object[] objArr = new Object[i7];
        switch (i6) {
            case 1:
            case 9:
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
                objArr[0] = "parameter";
                break;
            case 7:
                objArr[0] = "setterDescriptor";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        switch (i6) {
            case 10:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 11:
                objArr[1] = "getValueParameters";
                break;
            case 12:
                objArr[1] = "getReturnType";
                break;
            case 13:
                objArr[1] = "getOriginal";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
        }
        switch (i6) {
            case 6:
                objArr[2] = "initialize";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSetterParameter";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i6) {
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R W(kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> mVar, D d6) {
        return mVar.d(this, d6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.types.t0 getReturnType() {
        kotlin.reflect.jvm.internal.impl.types.e1 a02 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.m(this).a0();
        if (a02 == null) {
            T(12);
        }
        return a02;
    }
}
