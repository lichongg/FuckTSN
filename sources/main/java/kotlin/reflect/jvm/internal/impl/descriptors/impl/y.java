package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.o1;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.f2;
import kotlin.reflect.jvm.internal.impl.types.h2;
import kotlin.reflect.jvm.internal.impl.types.j2;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class y extends z {

    /* renamed from: h, reason: collision with root package name */
    static final /* synthetic */ boolean f44917h = false;

    /* renamed from: b, reason: collision with root package name */
    private final z f44918b;

    /* renamed from: c, reason: collision with root package name */
    private final h2 f44919c;

    /* renamed from: d, reason: collision with root package name */
    private h2 f44920d;

    /* renamed from: e, reason: collision with root package name */
    private List<j1> f44921e;

    /* renamed from: f, reason: collision with root package name */
    private List<j1> f44922f;

    /* renamed from: g, reason: collision with root package name */
    private w1 f44923g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Function1<j1, Boolean> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(j1 j1Var) {
            return Boolean.valueOf(!j1Var.E());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Function1<e1, e1> {
        b() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e1 invoke(e1 e1Var) {
            return y.this.H0(e1Var);
        }
    }

    private h2 F0() {
        if (this.f44920d == null) {
            if (this.f44919c.k()) {
                this.f44920d = this.f44919c;
            } else {
                List<j1> parameters = this.f44918b.o().getParameters();
                this.f44921e = new ArrayList(parameters.size());
                this.f44920d = kotlin.reflect.jvm.internal.impl.types.d0.b(parameters, this.f44919c.j(), this, this.f44921e);
                this.f44922f = kotlin.collections.f0.r2(this.f44921e, new a());
            }
        }
        return this.f44920d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public e1 H0(@Nullable e1 e1Var) {
        return (e1Var == null || this.f44919c.k()) ? e1Var : (e1) F0().p(e1Var, Variance.INVARIANT);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void p0(int r15) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.y.p0(int):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.k G() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k G = this.f44918b.G();
        if (G == null) {
            p0(28);
        }
        return G;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g1
    @NotNull
    /* renamed from: G0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.d c(@NotNull h2 h2Var) {
        if (h2Var == null) {
            p0(23);
        }
        return h2Var.k() ? this : new y(this, h2.h(h2Var.j(), F0().j()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.k H() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k o02 = o0(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.r(kotlin.reflect.jvm.internal.impl.resolve.i.g(this.f44918b)));
        if (o02 == null) {
            p0(12);
        }
        return o02;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.z
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.k T(@NotNull f2 f2Var, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (f2Var == null) {
            p0(5);
        }
        if (gVar == null) {
            p0(6);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k T = this.f44918b.T(f2Var, gVar);
        if (!this.f44919c.k()) {
            return new kotlin.reflect.jvm.internal.impl.resolve.scopes.t(T, F0());
        }
        if (T == null) {
            p0(7);
        }
        return T;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public z0 V() {
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.l, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.k b() {
        kotlin.reflect.jvm.internal.impl.descriptors.k b6 = this.f44918b.b();
        if (b6 == null) {
            p0(22);
        }
        return b6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> f() {
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> f6 = this.f44918b.f();
        ArrayList arrayList = new ArrayList(f6.size());
        for (kotlin.reflect.jvm.internal.impl.descriptors.c cVar : f6) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.c) cVar.n().i(cVar.a()).q(cVar.i()).p(cVar.getVisibility()).s(cVar.h()).j(false).build()).c(F0()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @Nullable
    public o1<e1> g0() {
        o1<e1> g02 = this.f44918b.g0();
        if (g02 == null) {
            return null;
        }
        return g02.b(new b());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g getAnnotations() {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations = this.f44918b.getAnnotations();
        if (annotations == null) {
            p0(19);
        }
        return annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.f getName() {
        kotlin.reflect.jvm.internal.impl.name.f name = this.f44918b.getName();
        if (name == null) {
            p0(20);
        }
        return name;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.e1 getSource() {
        kotlin.reflect.jvm.internal.impl.descriptors.e1 e1Var = kotlin.reflect.jvm.internal.impl.descriptors.e1.f44683a;
        if (e1Var == null) {
            p0(29);
        }
        return e1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.c0, kotlin.reflect.jvm.internal.impl.descriptors.o
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.s getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.s visibility = this.f44918b.getVisibility();
        if (visibility == null) {
            p0(27);
        }
        return visibility;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public ClassKind h() {
        ClassKind h6 = this.f44918b.h();
        if (h6 == null) {
            p0(25);
        }
        return h6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.c0
    @NotNull
    public Modality i() {
        Modality i6 = this.f44918b.i();
        if (i6 == null) {
            p0(26);
        }
        return i6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean i0() {
        return this.f44918b.i0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean isExternal() {
        return this.f44918b.isExternal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean isInline() {
        return this.f44918b.isInline();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public List<z0> j0() {
        List<z0> list = Collections.EMPTY_LIST;
        if (list == null) {
            p0(17);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g
    public boolean k() {
        return this.f44918b.k();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean l0() {
        return this.f44918b.l0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public w1 o() {
        w1 o5 = this.f44918b.o();
        if (this.f44919c.k()) {
            if (o5 == null) {
                p0(0);
            }
            return o5;
        }
        if (this.f44923g == null) {
            h2 F0 = F0();
            Collection<kotlin.reflect.jvm.internal.impl.types.t0> i6 = o5.i();
            ArrayList arrayList = new ArrayList(i6.size());
            Iterator<kotlin.reflect.jvm.internal.impl.types.t0> it = i6.iterator();
            while (it.hasNext()) {
                arrayList.add(F0.p(it.next(), Variance.INVARIANT));
            }
            this.f44923g = new kotlin.reflect.jvm.internal.impl.types.v(this, this.f44921e, arrayList, kotlin.reflect.jvm.internal.impl.storage.f.f47092e);
        }
        w1 w1Var = this.f44923g;
        if (w1Var == null) {
            p0(1);
        }
        return w1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.z
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.k o0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (gVar == null) {
            p0(13);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k o02 = this.f44918b.o0(gVar);
        if (!this.f44919c.k()) {
            return new kotlin.reflect.jvm.internal.impl.resolve.scopes.t(o02, F0());
        }
        if (o02 == null) {
            p0(14);
        }
        return o02;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean q0() {
        return this.f44918b.q0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.k r0() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k r02 = this.f44918b.r0();
        if (r02 == null) {
            p0(15);
        }
        return r02;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public kotlin.reflect.jvm.internal.impl.descriptors.d s0() {
        return this.f44918b.s0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean u() {
        return this.f44918b.u();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean v() {
        return this.f44918b.v();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.k v0(@NotNull f2 f2Var) {
        if (f2Var == null) {
            p0(10);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k T = T(f2Var, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.r(kotlin.reflect.jvm.internal.impl.resolve.i.g(this)));
        if (T == null) {
            p0(11);
        }
        return T;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean w() {
        return this.f44918b.w();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.c z() {
        return this.f44918b.z();
    }

    public y(z zVar, h2 h2Var) {
        this.f44918b = zVar;
        this.f44919c = h2Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R W(kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> mVar, D d6) {
        return mVar.a(this, d6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.z, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d a() {
        kotlin.reflect.jvm.internal.impl.descriptors.d a6 = this.f44918b.a();
        if (a6 == null) {
            p0(21);
        }
        return a6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public e1 s() {
        e1 o5 = kotlin.reflect.jvm.internal.impl.types.w0.o(kotlin.reflect.jvm.internal.impl.types.y.f47369a.a(getAnnotations(), null, null), o(), j2.g(o().getParameters()), false, H());
        if (o5 == null) {
            p0(16);
        }
        return o5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.g
    @NotNull
    public List<j1> t() {
        F0();
        List<j1> list = this.f44922f;
        if (list == null) {
            p0(30);
        }
        return list;
    }
}
