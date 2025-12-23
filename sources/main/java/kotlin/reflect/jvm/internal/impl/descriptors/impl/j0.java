package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.h2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class j0 extends n implements kotlin.reflect.jvm.internal.impl.descriptors.v0 {

    /* renamed from: m, reason: collision with root package name */
    static final /* synthetic */ boolean f44758m = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f44759e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f44760f;

    /* renamed from: g, reason: collision with root package name */
    private final Modality f44761g;

    /* renamed from: h, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.w0 f44762h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f44763i;

    /* renamed from: j, reason: collision with root package name */
    private final CallableMemberDescriptor.Kind f44764j;

    /* renamed from: k, reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.descriptors.s f44765k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    private kotlin.reflect.jvm.internal.impl.descriptors.y f44766l;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean D0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.n
    @NotNull
    /* renamed from: F0 */
    public abstract kotlin.reflect.jvm.internal.impl.descriptors.v0 a();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public <V> V N(a.InterfaceC0876a<V> interfaceC0876a) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean S() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g1
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.y c(@NotNull h2 h2Var) {
        if (h2Var == null) {
            T(7);
        }
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean i0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean isInfix() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean isOperator() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean isSuspend() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean n0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean q0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean y() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(@NotNull Modality modality, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.w0 w0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, boolean z5, boolean z6, boolean z7, CallableMemberDescriptor.Kind kind, @NotNull e1 e1Var) {
        super(w0Var.b(), gVar, fVar, e1Var);
        if (modality == null) {
            T(0);
        }
        if (sVar == null) {
            T(1);
        }
        if (w0Var == null) {
            T(2);
        }
        if (gVar == null) {
            T(3);
        }
        if (fVar == null) {
            T(4);
        }
        if (e1Var == null) {
            T(5);
        }
        this.f44766l = null;
        this.f44761g = modality;
        this.f44765k = sVar;
        this.f44762h = w0Var;
        this.f44759e = z5;
        this.f44760f = z6;
        this.f44763i = z7;
        this.f44764j = kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.v0 e0(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.s sVar, CallableMemberDescriptor.Kind kind, boolean z5) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @NotNull
    protected Collection<kotlin.reflect.jvm.internal.impl.descriptors.v0> G0(boolean z5) {
        ArrayList arrayList = new ArrayList(0);
        for (kotlin.reflect.jvm.internal.impl.descriptors.w0 w0Var : h0().e()) {
            kotlin.reflect.jvm.internal.impl.descriptors.l getter = z5 ? w0Var.getGetter() : w0Var.getSetter();
            if (getter != null) {
                arrayList.add(getter);
            }
        }
        return arrayList;
    }

    public void H0(boolean z5) {
        this.f44759e = z5;
    }

    public void I0(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.y yVar) {
        this.f44766l = yVar;
    }

    public void J0(kotlin.reflect.jvm.internal.impl.descriptors.s sVar) {
        this.f44765k = sVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void R(@NotNull Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == null) {
            T(16);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.v0
    public boolean Y() {
        return this.f44759e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public List<j1> getTypeParameters() {
        List<j1> list = Collections.EMPTY_LIST;
        if (list == null) {
            T(9);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.s getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.s sVar = this.f44765k;
        if (sVar == null) {
            T(11);
        }
        return sVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    public CallableMemberDescriptor.Kind h() {
        CallableMemberDescriptor.Kind kind = this.f44764j;
        if (kind == null) {
            T(6);
        }
        return kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.v0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.w0 h0() {
        kotlin.reflect.jvm.internal.impl.descriptors.w0 w0Var = this.f44762h;
        if (w0Var == null) {
            T(13);
        }
        return w0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    @NotNull
    public Modality i() {
        Modality modality = this.f44761g;
        if (modality == null) {
            T(10);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean isExternal() {
        return this.f44760f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean isInline() {
        return this.f44763i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    @NotNull
    public y.a<? extends kotlin.reflect.jvm.internal.impl.descriptors.y> n() {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.y x0() {
        return this.f44766l;
    }

    private static /* synthetic */ void T(int i6) {
        String str;
        int i7;
        switch (i6) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 7:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i6) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                i7 = 2;
                break;
            case 7:
            default:
                i7 = 3;
                break;
        }
        Object[] objArr = new Object[i7];
        switch (i6) {
            case 1:
                objArr[0] = "visibility";
                break;
            case 2:
                objArr[0] = "correspondingProperty";
                break;
            case 3:
                objArr[0] = "annotations";
                break;
            case 4:
                objArr[0] = CommonNetImpl.NAME;
                break;
            case 5:
                objArr[0] = SocialConstants.PARAM_SOURCE;
                break;
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 7:
                objArr[0] = "substitutor";
                break;
            case 16:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "modality";
                break;
        }
        switch (i6) {
            case 6:
                objArr[1] = "getKind";
                break;
            case 7:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 8:
                objArr[1] = "substitute";
                break;
            case 9:
                objArr[1] = "getTypeParameters";
                break;
            case 10:
                objArr[1] = "getModality";
                break;
            case 11:
                objArr[1] = "getVisibility";
                break;
            case 12:
                objArr[1] = "getCorrespondingVariable";
                break;
            case 13:
                objArr[1] = "getCorrespondingProperty";
                break;
            case 14:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 15:
                objArr[1] = "getOverriddenDescriptors";
                break;
        }
        switch (i6) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                break;
            case 7:
                objArr[2] = "substitute";
                break;
            case 16:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i6) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                throw new IllegalStateException(format);
            case 7:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public List<z0> A0() {
        List<z0> A0 = h0().A0();
        if (A0 == null) {
            T(14);
        }
        return A0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public z0 c0() {
        return h0().c0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public z0 f0() {
        return h0().f0();
    }
}
