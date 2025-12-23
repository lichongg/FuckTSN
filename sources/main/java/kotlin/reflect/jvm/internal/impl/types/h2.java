package kotlin.reflect.jvm.internal.impl.types;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class h2 {

    /* renamed from: b, reason: collision with root package name */
    public static final h2 f47263b = g(f2.f47250b);

    /* renamed from: c, reason: collision with root package name */
    static final /* synthetic */ boolean f47264c = false;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final f2 f47265a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements Function1<kotlin.reflect.jvm.internal.impl.name.c, Boolean> {
        private static /* synthetic */ void a(int i6) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", CommonNetImpl.NAME, "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"));
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
            if (cVar == null) {
                a(0);
            }
            return Boolean.valueOf(!cVar.equals(o.a.Q));
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum d {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f47266a;

        static {
            int[] iArr = new int[d.values().length];
            f47266a = iArr;
            try {
                iArr[d.OUT_IN_IN_POSITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47266a[d.IN_IN_OUT_POSITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47266a[d.NO_CONFLICT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class c extends Exception {
        public c(String str) {
            super(str);
        }
    }

    protected h2(@NotNull f2 f2Var) {
        if (f2Var == null) {
            a(7);
        }
        this.f47265a = f2Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x003b A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0021 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void a(int r13) {
        /*
            Method dump skipped, instructions count: 660
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.h2.a(int):void");
    }

    private static void b(int i6, c2 c2Var, f2 f2Var) {
        if (i6 <= 100) {
            return;
        }
        throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + o(c2Var) + "; substitution: " + o(f2Var));
    }

    @NotNull
    public static Variance c(@NotNull Variance variance, @NotNull c2 c2Var) {
        if (variance == null) {
            a(35);
        }
        if (c2Var == null) {
            a(36);
        }
        if (!c2Var.b()) {
            return d(variance, c2Var.c());
        }
        Variance variance2 = Variance.OUT_VARIANCE;
        if (variance2 == null) {
            a(37);
        }
        return variance2;
    }

    @NotNull
    public static Variance d(@NotNull Variance variance, @NotNull Variance variance2) {
        if (variance == null) {
            a(38);
        }
        if (variance2 == null) {
            a(39);
        }
        Variance variance3 = Variance.INVARIANT;
        if (variance == variance3) {
            if (variance2 == null) {
                a(40);
            }
            return variance2;
        }
        if (variance2 == variance3) {
            if (variance == null) {
                a(41);
            }
            return variance;
        }
        if (variance == variance2) {
            if (variance2 == null) {
                a(42);
            }
            return variance2;
        }
        throw new AssertionError("Variance conflict: type parameter variance '" + variance + "' and projection kind '" + variance2 + "' cannot be combined");
    }

    private static d e(Variance variance, Variance variance2) {
        Variance variance3 = Variance.IN_VARIANCE;
        return (variance == variance3 && variance2 == Variance.OUT_VARIANCE) ? d.OUT_IN_IN_POSITION : (variance == Variance.OUT_VARIANCE && variance2 == variance3) ? d.IN_IN_OUT_POSITION : d.NO_CONFLICT;
    }

    @NotNull
    public static h2 f(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(6);
        }
        return g(x1.i(t0Var.I0(), t0Var.G0()));
    }

    @NotNull
    public static h2 g(@NotNull f2 f2Var) {
        if (f2Var == null) {
            a(0);
        }
        return new h2(f2Var);
    }

    @NotNull
    public static h2 h(@NotNull f2 f2Var, @NotNull f2 f2Var2) {
        if (f2Var == null) {
            a(3);
        }
        if (f2Var2 == null) {
            a(4);
        }
        return g(e0.i(f2Var, f2Var2));
    }

    @NotNull
    private static kotlin.reflect.jvm.internal.impl.descriptors.annotations.g i(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        if (gVar == null) {
            a(33);
        }
        return !gVar.l(o.a.Q) ? gVar : new kotlin.reflect.jvm.internal.impl.descriptors.annotations.o(gVar, new a());
    }

    @NotNull
    private static c2 l(@NotNull t0 t0Var, @NotNull c2 c2Var, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.j1 j1Var, @NotNull c2 c2Var2) {
        if (t0Var == null) {
            a(26);
        }
        if (c2Var == null) {
            a(27);
        }
        if (c2Var2 == null) {
            a(28);
        }
        if (!t0Var.getAnnotations().l(o.a.Q)) {
            if (c2Var == null) {
                a(29);
            }
            return c2Var;
        }
        w1 I0 = c2Var.getType().I0();
        if (!(I0 instanceof kotlin.reflect.jvm.internal.impl.types.checker.n)) {
            return c2Var;
        }
        c2 projection = ((kotlin.reflect.jvm.internal.impl.types.checker.n) I0).getProjection();
        Variance c6 = projection.c();
        d e6 = e(c2Var2.c(), c6);
        d dVar = d.OUT_IN_IN_POSITION;
        return e6 == dVar ? new e2(projection.getType()) : (j1Var != null && e(j1Var.l(), c6) == dVar) ? new e2(projection.getType()) : c2Var;
    }

    private List<c2> s(List<kotlin.reflect.jvm.internal.impl.descriptors.j1> list, List<c2> list2, int i6) throws c {
        ArrayList arrayList = new ArrayList(list.size());
        boolean z5 = false;
        for (int i7 = 0; i7 < list.size(); i7++) {
            kotlin.reflect.jvm.internal.impl.descriptors.j1 j1Var = list.get(i7);
            c2 c2Var = list2.get(i7);
            c2 u5 = u(c2Var, j1Var, i6 + 1);
            int i8 = b.f47266a[e(j1Var.l(), u5.c()).ordinal()];
            if (i8 == 1 || i8 == 2) {
                u5 = j2.s(j1Var);
            } else if (i8 == 3) {
                Variance l6 = j1Var.l();
                Variance variance = Variance.INVARIANT;
                if (l6 != variance && !u5.b()) {
                    u5 = new e2(variance, u5.getType());
                }
            }
            if (u5 != c2Var) {
                z5 = true;
            }
            arrayList.add(u5);
        }
        return !z5 ? list2 : arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    private c2 u(@NotNull c2 c2Var, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.j1 j1Var, int i6) throws c {
        if (c2Var == null) {
            a(18);
        }
        b(i6, c2Var, this.f47265a);
        if (!c2Var.b()) {
            t0 type = c2Var.getType();
            if (type instanceof k2) {
                k2 k2Var = (k2) type;
                m2 T = k2Var.T();
                t0 o02 = k2Var.o0();
                c2 u5 = u(new e2(c2Var.c(), T), j1Var, i6 + 1);
                return u5.b() ? u5 : new e2(u5.c(), l2.d(u5.getType().L0(), p(o02, c2Var.c())));
            }
            if (!g0.a(type) && !(type.L0() instanceof d1)) {
                c2 e6 = this.f47265a.e(type);
                c2 l6 = e6 != null ? l(type, e6, j1Var, c2Var) : null;
                Variance c6 = c2Var.c();
                if (l6 == null && n0.b(type) && !v1.b(type)) {
                    k0 a6 = n0.a(type);
                    int i7 = i6 + 1;
                    c2 u6 = u(new e2(c6, a6.Q0()), j1Var, i7);
                    c2 u7 = u(new e2(c6, a6.R0()), j1Var, i7);
                    Variance c7 = u6.c();
                    if (u6.getType() != a6.Q0() || u7.getType() != a6.R0()) {
                        return new e2(c7, w0.e(g2.a(u6.getType()), g2.a(u7.getType())));
                    }
                } else if (!kotlin.reflect.jvm.internal.impl.builtins.j.o0(type) && !x0.a(type)) {
                    if (l6 != null) {
                        d e7 = e(c6, l6.c());
                        if (!kotlin.reflect.jvm.internal.impl.resolve.calls.inference.e.f(type)) {
                            int i8 = b.f47266a[e7.ordinal()];
                            if (i8 == 1) {
                                throw new c("Out-projection in in-position");
                            }
                            if (i8 == 2) {
                                return new e2(Variance.OUT_VARIANCE, type.I0().p().J());
                            }
                        }
                        x a7 = v1.a(type);
                        if (l6.b()) {
                            return l6;
                        }
                        t0 p02 = a7 != null ? a7.p0(l6.getType()) : j2.q(l6.getType(), type.J0());
                        if (!type.getAnnotations().isEmpty()) {
                            p02 = kotlin.reflect.jvm.internal.impl.types.typeUtil.e.D(p02, new kotlin.reflect.jvm.internal.impl.descriptors.annotations.n(p02.getAnnotations(), i(this.f47265a.d(type.getAnnotations()))));
                        }
                        if (e7 == d.NO_CONFLICT) {
                            c6 = d(c6, l6.c());
                        }
                        return new e2(c6, p02);
                    }
                    c2Var = r(c2Var, i6);
                    if (c2Var == null) {
                        a(25);
                    }
                }
            }
        }
        return c2Var;
    }

    @NotNull
    public f2 j() {
        f2 f2Var = this.f47265a;
        if (f2Var == null) {
            a(8);
        }
        return f2Var;
    }

    public boolean k() {
        return this.f47265a.f();
    }

    @NotNull
    public h2 m() {
        f2 f2Var = this.f47265a;
        return ((f2Var instanceof o0) && f2Var.b()) ? new h2(new o0(((o0) this.f47265a).j(), ((o0) this.f47265a).i(), false)) : this;
    }

    @NotNull
    public t0 n(@NotNull t0 t0Var, @NotNull Variance variance) {
        if (t0Var == null) {
            a(9);
        }
        if (variance == null) {
            a(10);
        }
        if (k()) {
            if (t0Var == null) {
                a(11);
            }
            return t0Var;
        }
        try {
            t0 type = u(new e2(variance, t0Var), null, 0).getType();
            if (type == null) {
                a(12);
            }
            return type;
        } catch (c e6) {
            kotlin.reflect.jvm.internal.impl.types.error.g d6 = kotlin.reflect.jvm.internal.impl.types.error.i.d(ErrorTypeKind.UNABLE_TO_SUBSTITUTE_TYPE, e6.getMessage());
            if (d6 == null) {
                a(13);
            }
            return d6;
        }
    }

    @Nullable
    public t0 p(@NotNull t0 t0Var, @NotNull Variance variance) {
        if (t0Var == null) {
            a(14);
        }
        if (variance == null) {
            a(15);
        }
        c2 q5 = q(new e2(variance, j().g(t0Var, variance)));
        if (q5 == null) {
            return null;
        }
        return q5.getType();
    }

    @Nullable
    public c2 q(@NotNull c2 c2Var) {
        if (c2Var == null) {
            a(16);
        }
        c2 t5 = t(c2Var);
        return (this.f47265a.a() || this.f47265a.b()) ? kotlin.reflect.jvm.internal.impl.types.typesApproximation.d.e(t5, this.f47265a.b()) : t5;
    }

    @Nullable
    public c2 t(@NotNull c2 c2Var) {
        if (c2Var == null) {
            a(17);
        }
        if (k()) {
            return c2Var;
        }
        try {
            return u(c2Var, null, 0);
        } catch (c unused) {
            return null;
        }
    }

    private static String o(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (!kotlin.reflect.jvm.internal.impl.utils.c.a(th)) {
                return "[Exception while computing toString(): " + th + "]";
            }
            throw th;
        }
    }

    private c2 r(c2 c2Var, int i6) throws c {
        t0 t0Var;
        t0 type = c2Var.getType();
        Variance c6 = c2Var.c();
        if (type.I0().c() instanceof kotlin.reflect.jvm.internal.impl.descriptors.j1) {
            return c2Var;
        }
        e1 b6 = i1.b(type);
        if (b6 != null) {
            t0Var = m().p(b6, Variance.INVARIANT);
        } else {
            t0Var = null;
        }
        t0 b7 = g2.b(type, s(type.I0().getParameters(), type.G0(), i6), this.f47265a.d(type.getAnnotations()));
        if ((b7 instanceof e1) && (t0Var instanceof e1)) {
            b7 = i1.j((e1) b7, (e1) t0Var);
        }
        return new e2(c6, b7);
    }
}
