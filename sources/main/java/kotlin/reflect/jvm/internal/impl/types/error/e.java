package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Collection;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.descriptors.s;
import kotlin.reflect.jvm.internal.impl.descriptors.v;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.h2;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e implements w0 {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ k0 f47219a;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public w0 a() {
        w0 a6 = this.f47219a.a();
        g0.o(a6, "getOriginal(...)");
        return a6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g1
    public w0 c(@NotNull h2 substitutor) {
        g0.p(substitutor, "substitutor");
        return this.f47219a.c(substitutor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public List<z0> A0() {
        List<z0> A0 = this.f47219a.A0();
        g0.o(A0, "getContextReceiverParameters(...)");
        return A0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.s1
    public boolean B0() {
        return this.f47219a.B0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.s1
    public boolean C() {
        return this.f47219a.C();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w0
    @Nullable
    public v D() {
        return this.f47219a.D();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public <V> V N(a.InterfaceC0876a<V> interfaceC0876a) {
        return (V) this.f47219a.N(interfaceC0876a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w0
    @Nullable
    public v O() {
        return this.f47219a.O();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void R(@NotNull Collection<? extends CallableMemberDescriptor> overriddenDescriptors) {
        g0.p(overriddenDescriptors, "overriddenDescriptors");
        this.f47219a.R(overriddenDescriptors);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R W(m<R, D> mVar, D d6) {
        return (R) this.f47219a.W(mVar, d6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.t1
    public boolean X() {
        return this.f47219a.X();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public k b() {
        k b6 = this.f47219a.b();
        g0.o(b6, "getContainingDeclaration(...)");
        return b6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public z0 c0() {
        return this.f47219a.c0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w0, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public Collection<? extends w0> e() {
        Collection<? extends w0> e6 = this.f47219a.e();
        g0.o(e6, "getOverriddenDescriptors(...)");
        return e6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    public CallableMemberDescriptor e0(k kVar, Modality modality, s sVar, CallableMemberDescriptor.Kind kind, boolean z5) {
        w0 e02 = this.f47219a.e0(kVar, modality, sVar, kind, z5);
        g0.o(e02, "copy(...)");
        return e02;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public z0 f0() {
        return this.f47219a.f0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public List<q1> g() {
        List<q1> g6 = this.f47219a.g();
        g0.o(g6, "getValueParameters(...)");
        return g6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g getAnnotations() {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations = this.f47219a.getAnnotations();
        g0.o(annotations, "<get-annotations>(...)");
        return annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w0
    @Nullable
    public x0 getGetter() {
        return this.f47219a.getGetter();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.f getName() {
        kotlin.reflect.jvm.internal.impl.name.f name = this.f47219a.getName();
        g0.o(name, "getName(...)");
        return name;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public t0 getReturnType() {
        return this.f47219a.getReturnType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w0
    @Nullable
    public y0 getSetter() {
        return this.f47219a.getSetter();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n
    @NotNull
    public e1 getSource() {
        e1 source = this.f47219a.getSource();
        g0.o(source, "getSource(...)");
        return source;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1
    @NotNull
    public t0 getType() {
        t0 type = this.f47219a.getType();
        g0.o(type, "getType(...)");
        return type;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public List<j1> getTypeParameters() {
        List<j1> typeParameters = this.f47219a.getTypeParameters();
        g0.o(typeParameters, "getTypeParameters(...)");
        return typeParameters;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
    @NotNull
    public s getVisibility() {
        s visibility = this.f47219a.getVisibility();
        g0.o(visibility, "getVisibility(...)");
        return visibility;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    public CallableMemberDescriptor.Kind h() {
        CallableMemberDescriptor.Kind h6 = this.f47219a.h();
        g0.o(h6, "getKind(...)");
        return h6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    @NotNull
    public Modality i() {
        Modality i6 = this.f47219a.i();
        g0.o(i6, "getModality(...)");
        return i6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean i0() {
        return this.f47219a.i0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.s1
    public boolean isConst() {
        return this.f47219a.isConst();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean isExternal() {
        return this.f47219a.isExternal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean n0() {
        return this.f47219a.n0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean q0() {
        return this.f47219a.q0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.s1
    @Nullable
    public kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> t0() {
        return this.f47219a.t0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w0
    @NotNull
    public List<v0> x() {
        List<v0> x5 = this.f47219a.x();
        g0.o(x5, "getAccessors(...)");
        return x5;
    }

    public e() {
        i iVar = i.f47232a;
        k0 K0 = k0.K0(iVar.h(), kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b(), Modality.OPEN, r.f44948e, true, kotlin.reflect.jvm.internal.impl.name.f.k(ErrorEntity.ERROR_PROPERTY.getDebugText()), CallableMemberDescriptor.Kind.DECLARATION, e1.f44683a, false, false, false, false, false, false);
        K0.X0(iVar.k(), f0.J(), null, null, f0.J());
        this.f47219a = K0;
    }
}
