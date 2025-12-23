package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.n1;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.g2;
import kotlin.reflect.jvm.internal.impl.types.h2;
import kotlin.reflect.jvm.internal.impl.types.x0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p0 extends kotlin.reflect.jvm.internal.impl.descriptors.impl.g implements t {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private final ProtoBuf.TypeAlias f46898k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.d f46899l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.h f46900m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.j f46901n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    private final s f46902o;

    /* renamed from: p, reason: collision with root package name */
    private e1 f46903p;

    /* renamed from: q, reason: collision with root package name */
    private e1 f46904q;

    /* renamed from: r, reason: collision with root package name */
    private List<? extends j1> f46905r;

    /* renamed from: s, reason: collision with root package name */
    private e1 f46906s;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p0(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.storage.n r12, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.k r13, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g r14, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.name.f r15, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.s r16, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias r17, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d r18, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h r19, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.j r20, @org.jetbrains.annotations.Nullable kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.s r21) {
        /*
            r11 = this;
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            java.lang.String r0 = "storageManager"
            kotlin.jvm.internal.g0.p(r12, r0)
            java.lang.String r0 = "containingDeclaration"
            kotlin.jvm.internal.g0.p(r13, r0)
            java.lang.String r0 = "annotations"
            kotlin.jvm.internal.g0.p(r14, r0)
            java.lang.String r0 = "name"
            kotlin.jvm.internal.g0.p(r15, r0)
            java.lang.String r0 = "visibility"
            r6 = r16
            kotlin.jvm.internal.g0.p(r6, r0)
            java.lang.String r0 = "proto"
            kotlin.jvm.internal.g0.p(r7, r0)
            java.lang.String r0 = "nameResolver"
            kotlin.jvm.internal.g0.p(r8, r0)
            java.lang.String r0 = "typeTable"
            kotlin.jvm.internal.g0.p(r9, r0)
            java.lang.String r0 = "versionRequirementTable"
            kotlin.jvm.internal.g0.p(r10, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.e1 r5 = kotlin.reflect.jvm.internal.impl.descriptors.e1.f44683a
            java.lang.String r0 = "NO_SOURCE"
            kotlin.jvm.internal.g0.o(r5, r0)
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r11.f46898k = r7
            r11.f46899l = r8
            r11.f46900m = r9
            r11.f46901n = r10
            r1 = r21
            r11.f46902o = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.p0.<init>(kotlin.reflect.jvm.internal.impl.storage.n, kotlin.reflect.jvm.internal.impl.descriptors.k, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g, kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.descriptors.s, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias, kotlin.reflect.jvm.internal.impl.metadata.deserialization.d, kotlin.reflect.jvm.internal.impl.metadata.deserialization.h, kotlin.reflect.jvm.internal.impl.metadata.deserialization.j, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.s):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.t
    @NotNull
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.h A() {
        return this.f46900m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.g
    @NotNull
    protected List<j1> M0() {
        List list = this.f46905r;
        if (list != null) {
            return list;
        }
        kotlin.jvm.internal.g0.S("typeConstructorParameters");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.t
    @NotNull
    /* renamed from: P0, reason: merged with bridge method [inline-methods] */
    public ProtoBuf.TypeAlias K() {
        return this.f46898k;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.j Q0() {
        return this.f46901n;
    }

    public final void R0(@NotNull List<? extends j1> declaredTypeParameters, @NotNull e1 underlyingType, @NotNull e1 expandedType) {
        kotlin.jvm.internal.g0.p(declaredTypeParameters, "declaredTypeParameters");
        kotlin.jvm.internal.g0.p(underlyingType, "underlyingType");
        kotlin.jvm.internal.g0.p(expandedType, "expandedType");
        N0(declaredTypeParameters);
        this.f46903p = underlyingType;
        this.f46904q = expandedType;
        this.f46905r = n1.g(this);
        this.f46906s = H0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g1
    @NotNull
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public i1 c(@NotNull h2 substitutor) {
        kotlin.jvm.internal.g0.p(substitutor, "substitutor");
        if (substitutor.k()) {
            return this;
        }
        kotlin.reflect.jvm.internal.impl.storage.n d02 = d0();
        kotlin.reflect.jvm.internal.impl.descriptors.k b6 = b();
        kotlin.jvm.internal.g0.o(b6, "getContainingDeclaration(...)");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations = getAnnotations();
        kotlin.jvm.internal.g0.o(annotations, "<get-annotations>(...)");
        kotlin.reflect.jvm.internal.impl.name.f name = getName();
        kotlin.jvm.internal.g0.o(name, "getName(...)");
        p0 p0Var = new p0(d02, b6, annotations, name, getVisibility(), K(), a0(), A(), Q0(), b0());
        List<j1> t5 = t();
        e1 y02 = y0();
        Variance variance = Variance.INVARIANT;
        kotlin.reflect.jvm.internal.impl.types.t0 n6 = substitutor.n(y02, variance);
        kotlin.jvm.internal.g0.o(n6, "safeSubstitute(...)");
        e1 a6 = g2.a(n6);
        kotlin.reflect.jvm.internal.impl.types.t0 n7 = substitutor.n(Z(), variance);
        kotlin.jvm.internal.g0.o(n7, "safeSubstitute(...)");
        p0Var.R0(t5, a6, g2.a(n7));
        return p0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1
    @NotNull
    public e1 Z() {
        e1 e1Var = this.f46904q;
        if (e1Var != null) {
            return e1Var;
        }
        kotlin.jvm.internal.g0.S("expandedType");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.t
    @NotNull
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.d a0() {
        return this.f46899l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.t
    @Nullable
    public s b0() {
        return this.f46902o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public e1 s() {
        e1 e1Var = this.f46906s;
        if (e1Var != null) {
            return e1Var;
        }
        kotlin.jvm.internal.g0.S("defaultTypeImpl");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1
    @NotNull
    public e1 y0() {
        e1 e1Var = this.f46903p;
        if (e1Var != null) {
            return e1Var;
        }
        kotlin.jvm.internal.g0.S("underlyingType");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.d m() {
        if (x0.a(Z())) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = Z().I0().c();
        if (!(c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d)) {
            return null;
        }
        return (kotlin.reflect.jvm.internal.impl.descriptors.d) c6;
    }
}
