package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Collection;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.descriptors.s;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.f2;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b extends o0 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements y.a<d1> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<d1> c(f2 substitution) {
            g0.p(substitution, "substitution");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public <V> y.a<d1> d(a.InterfaceC0876a<V> userDataKey, V v5) {
            g0.p(userDataKey, "userDataKey");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<d1> f(kotlin.reflect.jvm.internal.impl.name.f name) {
            g0.p(name, "name");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<d1> h(t0 type) {
            g0.p(type, "type");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<d1> k(List<? extends j1> parameters) {
            g0.p(parameters, "parameters");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<d1> l(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g additionalAnnotations) {
            g0.p(additionalAnnotations, "additionalAnnotations");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<d1> n(List<? extends q1> parameters) {
            g0.p(parameters, "parameters");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<d1> p(s visibility) {
            g0.p(visibility, "visibility");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<d1> q(Modality modality) {
            g0.p(modality, "modality");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<d1> r(k owner) {
            g0.p(owner, "owner");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<d1> s(CallableMemberDescriptor.Kind kind) {
            g0.p(kind, "kind");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public d1 build() {
            return b.this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<d1> e() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<d1> g() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<d1> m() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<d1> o() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<d1> t() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<d1> a(z0 z0Var) {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<d1> b(z0 z0Var) {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<d1> i(CallableMemberDescriptor callableMemberDescriptor) {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<d1> j(boolean z5) {
            return this;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean isSuspend() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d containingDeclaration) {
        super(containingDeclaration, null, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b(), kotlin.reflect.jvm.internal.impl.name.f.k(ErrorEntity.ERROR_FUNCTION.getDebugText()), CallableMemberDescriptor.Kind.DECLARATION, e1.f44683a);
        g0.p(containingDeclaration, "containingDeclaration");
        M0(null, null, f0.J(), f0.J(), f0.J(), i.d(ErrorTypeKind.RETURN_TYPE_FOR_FUNCTION, new String[0]), Modality.OPEN, r.f44948e);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.o0, kotlin.reflect.jvm.internal.impl.descriptors.impl.s
    @NotNull
    protected kotlin.reflect.jvm.internal.impl.descriptors.impl.s G0(@NotNull k newOwner, @Nullable y yVar, @NotNull CallableMemberDescriptor.Kind kind, @Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, @NotNull e1 source) {
        g0.p(newOwner, "newOwner");
        g0.p(kind, "kind");
        g0.p(annotations, "annotations");
        g0.p(source, "source");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public <V> V N(@NotNull a.InterfaceC0876a<V> key) {
        g0.p(key, "key");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void R(@NotNull Collection<? extends CallableMemberDescriptor> overriddenDescriptors) {
        g0.p(overriddenDescriptors, "overriddenDescriptors");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.o0, kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public d1 e0(@NotNull k newOwner, @NotNull Modality modality, @NotNull s visibility, @NotNull CallableMemberDescriptor.Kind kind, boolean z5) {
        g0.p(newOwner, "newOwner");
        g0.p(modality, "modality");
        g0.p(visibility, "visibility");
        g0.p(kind, "kind");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.o0, kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.y
    @NotNull
    public y.a<d1> n() {
        return new a();
    }
}
