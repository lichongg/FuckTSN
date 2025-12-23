package kotlin.reflect.jvm.internal.impl.resolve;

import e4.w;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.checker.b;
import kotlin.reflect.jvm.internal.impl.types.checker.e;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n implements kotlin.reflect.jvm.internal.impl.types.checker.b {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final Map<w1, w1> f46725a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final e.a f46726b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.types.checker.g f46727c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.types.checker.f f46728d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final Function2<t0, t0, Boolean> f46729e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends TypeCheckerState {

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ n f46730l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z5, boolean z6, boolean z7, n nVar, kotlin.reflect.jvm.internal.impl.types.checker.f fVar, kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            super(z5, z6, z7, true, nVar, fVar, gVar);
            this.f46730l = nVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState
        public boolean f(e4.g subType, e4.g superType) {
            g0.p(subType, "subType");
            g0.p(superType, "superType");
            if (!(subType instanceof t0)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (superType instanceof t0) {
                return ((Boolean) this.f46730l.f46729e.invoke(subType, superType)).booleanValue();
            }
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(@Nullable Map<w1, ? extends w1> map, @NotNull e.a equalityAxioms, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.f kotlinTypePreparator, @Nullable Function2<? super t0, ? super t0, Boolean> function2) {
        g0.p(equalityAxioms, "equalityAxioms");
        g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        g0.p(kotlinTypePreparator, "kotlinTypePreparator");
        this.f46725a = map;
        this.f46726b = equalityAxioms;
        this.f46727c = kotlinTypeRefiner;
        this.f46728d = kotlinTypePreparator;
        this.f46729e = function2;
    }

    private final boolean M0(w1 w1Var, w1 w1Var2) {
        if (this.f46726b.a(w1Var, w1Var2)) {
            return true;
        }
        Map<w1, w1> map = this.f46725a;
        if (map == null) {
            return false;
        }
        w1 w1Var3 = map.get(w1Var);
        w1 w1Var4 = this.f46725a.get(w1Var2);
        return (w1Var3 != null && g0.g(w1Var3, w1Var2)) || (w1Var4 != null && g0.g(w1Var4, w1Var));
    }

    @Nullable
    public e4.b O0(e4.h hVar) {
        g0.p(hVar, "<this>");
        return d(U(hVar));
    }

    @Nullable
    public List<e4.i> P0(e4.h hVar, e4.o constructor) {
        g0.p(hVar, "<this>");
        g0.p(constructor, "constructor");
        return null;
    }

    @NotNull
    public e4.l Q0(e4.k kVar, int i6) {
        g0.p(kVar, "<this>");
        if (kVar instanceof e4.i) {
            return I((e4.g) kVar, i6);
        }
        if (kVar instanceof ArgumentList) {
            e4.l lVar = ((ArgumentList) kVar).get(i6);
            g0.o(lVar, "get(...)");
            return lVar;
        }
        throw new IllegalStateException(("unknown type argument list type: " + kVar + ", " + o0.d(kVar.getClass())).toString());
    }

    @Nullable
    public e4.l R0(e4.h hVar, int i6) {
        g0.p(hVar, "<this>");
        if (i6 < 0 || i6 >= v(hVar)) {
            return null;
        }
        return I(hVar, i6);
    }

    public boolean S0(e4.g gVar) {
        g0.p(gVar, "<this>");
        return B0(r0(gVar)) != B0(o(gVar));
    }

    public boolean T0(e4.g gVar) {
        g0.p(gVar, "<this>");
        e4.h f6 = f(gVar);
        return (f6 != null ? m(f6) : null) != null;
    }

    public boolean U0(e4.h hVar) {
        g0.p(hVar, "<this>");
        return c0(c(hVar));
    }

    public boolean V0(e4.g gVar) {
        g0.p(gVar, "<this>");
        e4.h f6 = f(gVar);
        return (f6 != null ? E(f6) : null) != null;
    }

    public boolean W0(e4.h hVar) {
        g0.p(hVar, "<this>");
        return E(hVar) != null;
    }

    public boolean X0(e4.g gVar) {
        g0.p(gVar, "<this>");
        e4.e a02 = a0(gVar);
        return (a02 != null ? K0(a02) : null) != null;
    }

    @Override // e4.n
    @NotNull
    public TypeCheckerState Y(boolean z5, boolean z6, boolean z7) {
        if (this.f46729e != null) {
            return new a(z5, z6, z7, this, this.f46728d, this.f46727c);
        }
        return kotlin.reflect.jvm.internal.impl.types.checker.a.a(z5, z6, this, this.f46728d, this.f46727c);
    }

    public boolean Y0(e4.g gVar) {
        g0.p(gVar, "<this>");
        return a0(gVar) != null;
    }

    public boolean Z0(e4.g gVar) {
        g0.p(gVar, "<this>");
        return !g0.g(c(r0(gVar)), c(o(gVar)));
    }

    @Override // e4.r
    @NotNull
    public e4.i a(@NotNull e4.h hVar, boolean z5) {
        return b.a.q0(this, hVar, z5);
    }

    public boolean a1(e4.h hVar) {
        g0.p(hVar, "<this>");
        return i(c(hVar));
    }

    public boolean b1(e4.g gVar) {
        g0.p(gVar, "<this>");
        return A0(X(gVar)) && !j0(gVar);
    }

    @NotNull
    public e4.h c1(e4.g gVar) {
        e4.h e6;
        g0.p(gVar, "<this>");
        e4.e a02 = a0(gVar);
        if (a02 != null && (e6 = e(a02)) != null) {
            return e6;
        }
        e4.h f6 = f(gVar);
        g0.m(f6);
        return f6;
    }

    @NotNull
    public e4.g d1(e4.g gVar) {
        g0.p(gVar, "<this>");
        return L(gVar, false);
    }

    @Override // e4.r
    @NotNull
    public e4.i e(@NotNull e4.e eVar) {
        return b.a.c0(this, eVar);
    }

    @NotNull
    public e4.g e1(e4.g gVar) {
        e4.h a6;
        g0.p(gVar, "<this>");
        e4.h f6 = f(gVar);
        return (f6 == null || (a6 = a(f6, true)) == null) ? gVar : a6;
    }

    @Override // e4.r
    @Nullable
    public e4.i f(@NotNull e4.g gVar) {
        return b.a.h(this, gVar);
    }

    @NotNull
    public e4.i f1(e4.h hVar) {
        e4.i g02;
        g0.p(hVar, "<this>");
        e4.c E = E(hVar);
        return (E == null || (g02 = g0(E)) == null) ? (e4.i) hVar : g02;
    }

    public int g1(e4.k kVar) {
        g0.p(kVar, "<this>");
        if (kVar instanceof e4.h) {
            return v((e4.g) kVar);
        }
        if (kVar instanceof ArgumentList) {
            return ((ArgumentList) kVar).size();
        }
        throw new IllegalStateException(("unknown type argument list type: " + kVar + ", " + o0.d(kVar.getClass())).toString());
    }

    @Override // e4.r
    @NotNull
    public e4.i h(@NotNull e4.e eVar) {
        return b.a.o0(this, eVar);
    }

    @NotNull
    public e4.o h1(e4.g gVar) {
        g0.p(gVar, "<this>");
        e4.h f6 = f(gVar);
        if (f6 == null) {
            f6 = r0(gVar);
        }
        return c(f6);
    }

    @NotNull
    public e4.h i1(e4.g gVar) {
        e4.h h6;
        g0.p(gVar, "<this>");
        e4.e a02 = a0(gVar);
        if (a02 != null && (h6 = h(a02)) != null) {
            return h6;
        }
        e4.h f6 = f(gVar);
        g0.m(f6);
        return f6;
    }

    @Override // e4.r
    public boolean q0(@NotNull e4.o c12, @NotNull e4.o c22) {
        g0.p(c12, "c1");
        g0.p(c22, "c2");
        if (!(c12 instanceof w1)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (c22 instanceof w1) {
            return b.a.a(this, c12, c22) || M0((w1) c12, (w1) c22);
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    @Override // e4.r
    public boolean A(@NotNull e4.h hVar) {
        return b.a.Y(this, hVar);
    }

    @Override // e4.r
    public boolean A0(@NotNull e4.o oVar) {
        return b.a.P(this, oVar);
    }

    @Override // e4.r
    @NotNull
    public Collection<e4.g> B(@NotNull e4.o oVar) {
        return b.a.l0(this, oVar);
    }

    @Override // e4.r
    public boolean B0(@NotNull e4.g gVar) {
        return b.a.N(this, gVar);
    }

    @Override // e4.r
    public boolean C(@NotNull e4.p pVar, @Nullable e4.o oVar) {
        return b.a.B(this, pVar, oVar);
    }

    @Override // e4.r
    public boolean C0(@NotNull e4.i iVar) {
        return b.a.S(this, iVar);
    }

    @Override // e4.r
    public boolean D(@NotNull e4.o oVar) {
        return b.a.G(this, oVar);
    }

    @Override // e4.r
    public boolean D0(@NotNull e4.h hVar) {
        return b.a.Z(this, hVar);
    }

    @Override // e4.r
    @Nullable
    public e4.c E(@NotNull e4.h hVar) {
        return b.a.e(this, hVar);
    }

    @Override // e4.r
    public boolean E0(@NotNull e4.g gVar) {
        return T0(gVar);
    }

    @Override // e4.r
    @NotNull
    public List<e4.l> F(@NotNull e4.g gVar) {
        return b.a.n(this, gVar);
    }

    @Override // e4.r
    @Nullable
    public e4.p F0(@NotNull w wVar) {
        return b.a.u(this, wVar);
    }

    @Override // e4.r
    @NotNull
    public e4.g G(@NotNull e4.g gVar, boolean z5) {
        return b.a.p0(this, gVar, z5);
    }

    @Override // e4.r
    public boolean G0(@NotNull e4.g gVar) {
        return Z0(gVar);
    }

    @Override // e4.r
    public boolean H(@NotNull e4.h hVar) {
        return W0(hVar);
    }

    @Override // e4.u
    public boolean H0(@NotNull e4.h hVar, @NotNull e4.h hVar2) {
        return b.a.C(this, hVar, hVar2);
    }

    @Override // e4.r
    @NotNull
    public e4.l I(@NotNull e4.g gVar, int i6) {
        return b.a.m(this, gVar, i6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.i2
    @NotNull
    public e4.g I0(@NotNull e4.p pVar) {
        return b.a.t(this, pVar);
    }

    @Override // e4.r
    public boolean J(@NotNull e4.h hVar) {
        return U0(hVar);
    }

    @Override // e4.r
    public boolean J0(@NotNull e4.o oVar) {
        return b.a.H(this, oVar);
    }

    @Override // e4.r
    public boolean K(@NotNull e4.o oVar) {
        return b.a.E(this, oVar);
    }

    @Override // e4.r
    @Nullable
    public e4.d K0(@NotNull e4.e eVar) {
        return b.a.f(this, eVar);
    }

    @Override // e4.r
    @NotNull
    public e4.g L(@NotNull e4.g gVar, boolean z5) {
        return b.a.e0(this, gVar, z5);
    }

    @Override // e4.r
    @NotNull
    public TypeVariance M(@NotNull e4.l lVar) {
        return b.a.y(this, lVar);
    }

    @Override // e4.r
    public boolean N(@NotNull e4.g gVar) {
        return X0(gVar);
    }

    @Override // e4.r
    @Nullable
    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public e1 O(@NotNull e4.h hVar, @NotNull CaptureStatus captureStatus) {
        return b.a.j(this, hVar, captureStatus);
    }

    @Override // e4.r
    @NotNull
    public Collection<e4.g> P(@NotNull e4.h hVar) {
        return b.a.i0(this, hVar);
    }

    @Override // e4.r
    @NotNull
    public e4.k Q(@NotNull e4.h hVar) {
        return b.a.c(this, hVar);
    }

    @Override // e4.r
    @NotNull
    public List<e4.p> R(@NotNull e4.o oVar) {
        return b.a.q(this, oVar);
    }

    @Override // e4.r
    @Nullable
    public List<e4.i> S(@NotNull e4.h hVar, @NotNull e4.o oVar) {
        return P0(hVar, oVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.i2
    public boolean T(@NotNull e4.o oVar) {
        return b.a.J(this, oVar);
    }

    @Override // e4.r
    @NotNull
    public e4.i U(@NotNull e4.h hVar) {
        return f1(hVar);
    }

    @Override // e4.r
    public int V(@NotNull e4.o oVar) {
        return b.a.h0(this, oVar);
    }

    @Override // e4.r
    public int W(@NotNull e4.k kVar) {
        return g1(kVar);
    }

    @Override // e4.r
    @NotNull
    public e4.o X(@NotNull e4.g gVar) {
        return h1(gVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.i2
    @Nullable
    public PrimitiveType Z(@NotNull e4.o oVar) {
        return b.a.r(this, oVar);
    }

    @Override // e4.r
    @Nullable
    public e4.e a0(@NotNull e4.g gVar) {
        return b.a.g(this, gVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b, e4.r
    public boolean b(@NotNull e4.h hVar) {
        return b.a.V(this, hVar);
    }

    @Override // e4.r
    @Nullable
    public e4.p b0(@NotNull e4.o oVar) {
        return b.a.v(this, oVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b, e4.r
    @NotNull
    public e4.o c(@NotNull e4.h hVar) {
        return b.a.n0(this, hVar);
    }

    @Override // e4.r
    public boolean c0(@NotNull e4.o oVar) {
        return b.a.F(this, oVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b, e4.r
    @Nullable
    public e4.b d(@NotNull e4.i iVar) {
        return b.a.d(this, iVar);
    }

    @Override // e4.r
    public boolean d0(@NotNull e4.g gVar) {
        return V0(gVar);
    }

    @Override // e4.r
    @NotNull
    public List<e4.g> e0(@NotNull e4.p pVar) {
        return b.a.x(this, pVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b
    @NotNull
    public e4.g f0(@NotNull e4.h hVar, @NotNull e4.h hVar2) {
        return b.a.l(this, hVar, hVar2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b, e4.r
    public boolean g(@NotNull e4.l lVar) {
        return b.a.X(this, lVar);
    }

    @Override // e4.r
    @NotNull
    public e4.i g0(@NotNull e4.c cVar) {
        return b.a.g0(this, cVar);
    }

    @Override // e4.r
    @Nullable
    public e4.g getType(@NotNull e4.l lVar) {
        return b.a.getType(this, lVar);
    }

    @Override // e4.r
    public boolean h0(@NotNull e4.o oVar) {
        return b.a.L(this, oVar);
    }

    @Override // e4.r
    public boolean i(@NotNull e4.o oVar) {
        return b.a.K(this, oVar);
    }

    @Override // e4.r
    public boolean i0(@NotNull e4.b bVar) {
        return b.a.T(this, bVar);
    }

    @Override // e4.r
    @NotNull
    public e4.g j(@NotNull e4.g gVar) {
        return d1(gVar);
    }

    @Override // e4.r
    public boolean j0(@NotNull e4.g gVar) {
        return b.a.Q(this, gVar);
    }

    @Override // e4.r
    @NotNull
    public TypeCheckerState.b k(@NotNull e4.h hVar) {
        return b.a.k0(this, hVar);
    }

    @Override // e4.r
    @NotNull
    public CaptureStatus k0(@NotNull e4.b bVar) {
        return b.a.k(this, bVar);
    }

    @Override // e4.r
    public boolean l(@NotNull e4.g gVar) {
        return Y0(gVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.i2
    @NotNull
    public e4.g l0(@NotNull e4.g gVar) {
        return e1(gVar);
    }

    @Override // e4.r
    @Nullable
    public e4.b m(@NotNull e4.h hVar) {
        return O0(hVar);
    }

    @Override // e4.r
    public boolean m0(@NotNull e4.g gVar) {
        return b.a.a0(this, gVar);
    }

    @Override // e4.r
    @NotNull
    public TypeVariance n(@NotNull e4.p pVar) {
        return b.a.z(this, pVar);
    }

    @Override // e4.r
    @NotNull
    public e4.a n0(@NotNull e4.b bVar) {
        return b.a.m0(this, bVar);
    }

    @Override // e4.r
    @NotNull
    public e4.h o(@NotNull e4.g gVar) {
        return i1(gVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.i2
    @Nullable
    public PrimitiveType o0(@NotNull e4.o oVar) {
        return b.a.s(this, oVar);
    }

    @Override // e4.r
    @Nullable
    public e4.g p(@NotNull e4.b bVar) {
        return b.a.d0(this, bVar);
    }

    @Override // e4.r
    public boolean p0(@NotNull e4.b bVar) {
        return b.a.R(this, bVar);
    }

    @Override // e4.r
    @Nullable
    public e4.l q(@NotNull e4.h hVar, int i6) {
        return R0(hVar, i6);
    }

    @Override // e4.r
    public boolean r(@NotNull e4.g gVar) {
        return b.a.U(this, gVar);
    }

    @Override // e4.r
    @NotNull
    public e4.h r0(@NotNull e4.g gVar) {
        return c1(gVar);
    }

    @Override // e4.r
    @NotNull
    public e4.p s(@NotNull e4.o oVar, int i6) {
        return b.a.p(this, oVar, i6);
    }

    @Override // e4.r
    public boolean s0(@NotNull e4.g gVar) {
        return b1(gVar);
    }

    @Override // e4.r
    @NotNull
    public e4.l t(@NotNull e4.k kVar, int i6) {
        return Q0(kVar, i6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.i2
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.d t0(@NotNull e4.o oVar) {
        return b.a.o(this, oVar);
    }

    @Override // e4.r
    @NotNull
    public e4.g u(@NotNull Collection<? extends e4.g> collection) {
        return b.a.D(this, collection);
    }

    @Override // e4.r
    public boolean u0(@NotNull e4.g gVar) {
        return b.a.O(this, gVar);
    }

    @Override // e4.r
    public int v(@NotNull e4.g gVar) {
        return b.a.b(this, gVar);
    }

    @Override // e4.r
    public boolean v0(@NotNull e4.g gVar) {
        return S0(gVar);
    }

    @Override // e4.t
    public boolean w() {
        return b.a.M(this);
    }

    @Override // e4.r
    @NotNull
    public e4.l w0(@NotNull e4.g gVar) {
        return b.a.i(this, gVar);
    }

    @Override // e4.r
    @NotNull
    public e4.l x(@NotNull e4.a aVar) {
        return b.a.j0(this, aVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.i2
    @Nullable
    public e4.g x0(@NotNull e4.g gVar) {
        return b.a.w(this, gVar);
    }

    @Override // e4.r
    public boolean y(@NotNull e4.h hVar) {
        return a1(hVar);
    }

    @Override // e4.r
    public boolean y0(@NotNull e4.g gVar) {
        return b.a.I(this, gVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.i2
    public boolean z(@NotNull e4.o oVar) {
        return b.a.b0(this, oVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.i2
    public boolean z0(@NotNull e4.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
        return b.a.A(this, gVar, cVar);
    }
}
