package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class j2 {

    /* renamed from: a, reason: collision with root package name */
    public static final e1 f47277a = kotlin.reflect.jvm.internal.impl.types.error.i.d(ErrorTypeKind.DONT_CARE, new String[0]);

    /* renamed from: b, reason: collision with root package name */
    public static final e1 f47278b = kotlin.reflect.jvm.internal.impl.types.error.i.d(ErrorTypeKind.UNINFERRED_LAMBDA_PARAMETER_TYPE, new String[0]);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final e1 f47279c = new a("NO_EXPECTED_TYPE");

    /* renamed from: d, reason: collision with root package name */
    public static final e1 f47280d = new a("UNIT_EXPECTED_TYPE");

    /* renamed from: e, reason: collision with root package name */
    static final /* synthetic */ boolean f47281e = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a extends b0 {

        /* renamed from: b, reason: collision with root package name */
        private final String f47282b;

        /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x003e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static /* synthetic */ void U0(int r9) {
            /*
                r0 = 4
                r1 = 1
                if (r9 == r1) goto L9
                if (r9 == r0) goto L9
                java.lang.String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
                goto Lb
            L9:
                java.lang.String r2 = "@NotNull method %s.%s must not return null"
            Lb:
                r3 = 3
                r4 = 2
                if (r9 == r1) goto L13
                if (r9 == r0) goto L13
                r5 = 3
                goto L14
            L13:
                r5 = 2
            L14:
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.String r6 = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType"
                r7 = 0
                if (r9 == r1) goto L30
                if (r9 == r4) goto L2b
                if (r9 == r3) goto L26
                if (r9 == r0) goto L30
                java.lang.String r8 = "newAttributes"
                r5[r7] = r8
                goto L32
            L26:
                java.lang.String r8 = "kotlinTypeRefiner"
                r5[r7] = r8
                goto L32
            L2b:
                java.lang.String r8 = "delegate"
                r5[r7] = r8
                goto L32
            L30:
                r5[r7] = r6
            L32:
                java.lang.String r7 = "refine"
                if (r9 == r1) goto L3e
                if (r9 == r0) goto L3b
                r5[r1] = r6
                goto L42
            L3b:
                r5[r1] = r7
                goto L42
            L3e:
                java.lang.String r6 = "toString"
                r5[r1] = r6
            L42:
                if (r9 == r1) goto L56
                if (r9 == r4) goto L52
                if (r9 == r3) goto L4f
                if (r9 == r0) goto L56
                java.lang.String r3 = "replaceAttributes"
                r5[r4] = r3
                goto L56
            L4f:
                r5[r4] = r7
                goto L56
            L52:
                java.lang.String r3 = "replaceDelegate"
                r5[r4] = r3
            L56:
                java.lang.String r2 = java.lang.String.format(r2, r5)
                if (r9 == r1) goto L64
                if (r9 == r0) goto L64
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                r9.<init>(r2)
                goto L69
            L64:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                r9.<init>(r2)
            L69:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.j2.a.U0(int):void");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.m2
        @NotNull
        /* renamed from: P0, reason: merged with bridge method [inline-methods] */
        public e1 M0(boolean z5) {
            throw new IllegalStateException(this.f47282b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.m2
        @NotNull
        /* renamed from: Q0, reason: merged with bridge method [inline-methods] */
        public e1 O0(@NotNull t1 t1Var) {
            if (t1Var == null) {
                U0(0);
            }
            throw new IllegalStateException(this.f47282b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.b0
        @NotNull
        protected e1 R0() {
            throw new IllegalStateException(this.f47282b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.b0
        @NotNull
        public b0 T0(@NotNull e1 e1Var) {
            if (e1Var == null) {
                U0(2);
            }
            throw new IllegalStateException(this.f47282b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.b0
        @NotNull
        /* renamed from: V0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public a S0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            if (gVar == null) {
                U0(3);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.e1
        @NotNull
        public String toString() {
            String str = this.f47282b;
            if (str == null) {
                U0(1);
            }
            return str;
        }

        public a(String str) {
            this.f47282b = str;
        }
    }

    @NotNull
    public static t0 o(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(1);
        }
        return p(t0Var, true);
    }

    public static boolean w(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(0);
        }
        return t0Var == f47279c || t0Var == f47280d;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01c1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void a(int r24) {
        /*
            Method dump skipped, instructions count: 780
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.j2.a(int):void");
    }

    public static boolean b(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(28);
        }
        if (t0Var.J0()) {
            return true;
        }
        return n0.b(t0Var) && b(n0.a(t0Var).R0());
    }

    public static boolean c(@Nullable t0 t0Var, @NotNull Function1<m2, Boolean> function1) {
        if (function1 == null) {
            a(43);
        }
        return d(t0Var, function1, null);
    }

    private static boolean d(@Nullable t0 t0Var, @NotNull Function1<m2, Boolean> function1, kotlin.reflect.jvm.internal.impl.utils.k<t0> kVar) {
        if (function1 == null) {
            a(44);
        }
        if (t0Var == null) {
            return false;
        }
        m2 L0 = t0Var.L0();
        if (w(t0Var)) {
            return function1.invoke(L0).booleanValue();
        }
        if (kVar != null && kVar.contains(t0Var)) {
            return false;
        }
        if (function1.invoke(L0).booleanValue()) {
            return true;
        }
        if (kVar == null) {
            kVar = kotlin.reflect.jvm.internal.impl.utils.k.a();
        }
        kVar.add(t0Var);
        k0 k0Var = L0 instanceof k0 ? (k0) L0 : null;
        if (k0Var != null && (d(k0Var.Q0(), function1, kVar) || d(k0Var.R0(), function1, kVar))) {
            return true;
        }
        if ((L0 instanceof z) && d(((z) L0).U0(), function1, kVar)) {
            return true;
        }
        w1 I0 = t0Var.I0();
        if (I0 instanceof s0) {
            Iterator<t0> it = ((s0) I0).i().iterator();
            while (it.hasNext()) {
                if (d(it.next(), function1, kVar)) {
                    return true;
                }
            }
            return false;
        }
        for (c2 c2Var : t0Var.G0()) {
            if (!c2Var.b()) {
                if (d(c2Var.getType(), function1, kVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    public static t0 e(@NotNull t0 t0Var, @NotNull t0 t0Var2, @NotNull h2 h2Var) {
        if (t0Var == null) {
            a(20);
        }
        if (t0Var2 == null) {
            a(21);
        }
        if (h2Var == null) {
            a(22);
        }
        t0 p5 = h2Var.p(t0Var2, Variance.INVARIANT);
        if (p5 != null) {
            return q(p5, t0Var.J0());
        }
        return null;
    }

    @Nullable
    public static kotlin.reflect.jvm.internal.impl.descriptors.d f(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(30);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = t0Var.I0().c();
        if (c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.d) c6;
        }
        return null;
    }

    @NotNull
    public static List<c2> g(@NotNull List<kotlin.reflect.jvm.internal.impl.descriptors.j1> list) {
        if (list == null) {
            a(16);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.j1> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new e2(it.next().s()));
        }
        List<c2> a6 = kotlin.collections.f0.a6(arrayList);
        if (a6 == null) {
            a(17);
        }
        return a6;
    }

    @NotNull
    public static List<t0> h(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(18);
        }
        h2 f6 = h2.f(t0Var);
        Collection<t0> i6 = t0Var.I0().i();
        ArrayList arrayList = new ArrayList(i6.size());
        Iterator<t0> it = i6.iterator();
        while (it.hasNext()) {
            t0 e6 = e(t0Var, it.next(), f6);
            if (e6 != null) {
                arrayList.add(e6);
            }
        }
        return arrayList;
    }

    @Nullable
    public static kotlin.reflect.jvm.internal.impl.descriptors.j1 i(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(63);
        }
        if (t0Var.I0().c() instanceof kotlin.reflect.jvm.internal.impl.descriptors.j1) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.j1) t0Var.I0().c();
        }
        return null;
    }

    public static boolean j(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(29);
        }
        if (t0Var.I0().c() instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            return false;
        }
        Iterator<t0> it = h(t0Var).iterator();
        while (it.hasNext()) {
            if (l(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean k(@Nullable t0 t0Var) {
        return t0Var != null && t0Var.I0() == f47277a.I0();
    }

    public static boolean l(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(27);
        }
        if (t0Var.J0()) {
            return true;
        }
        if (n0.b(t0Var) && l(n0.a(t0Var).R0())) {
            return true;
        }
        if (i1.c(t0Var)) {
            return false;
        }
        if (m(t0Var)) {
            return j(t0Var);
        }
        if (t0Var instanceof e) {
            kotlin.reflect.jvm.internal.impl.descriptors.j1 b6 = ((e) t0Var).R0().b();
            return b6 == null || j(b6.s());
        }
        w1 I0 = t0Var.I0();
        if (I0 instanceof s0) {
            Iterator<t0> it = I0.i().iterator();
            while (it.hasNext()) {
                if (l(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean m(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(60);
        }
        return i(t0Var) != null || (t0Var.I0() instanceof kotlin.reflect.jvm.internal.impl.types.checker.r);
    }

    @NotNull
    public static t0 n(@NotNull t0 t0Var) {
        if (t0Var == null) {
            a(2);
        }
        return p(t0Var, false);
    }

    @NotNull
    public static t0 p(@NotNull t0 t0Var, boolean z5) {
        if (t0Var == null) {
            a(3);
        }
        m2 M0 = t0Var.L0().M0(z5);
        if (M0 == null) {
            a(4);
        }
        return M0;
    }

    @NotNull
    public static t0 q(@NotNull t0 t0Var, boolean z5) {
        if (t0Var == null) {
            a(8);
        }
        if (z5) {
            return o(t0Var);
        }
        if (t0Var == null) {
            a(9);
        }
        return t0Var;
    }

    @NotNull
    public static e1 r(@NotNull e1 e1Var, boolean z5) {
        if (e1Var == null) {
            a(5);
        }
        if (!z5) {
            if (e1Var == null) {
                a(7);
            }
            return e1Var;
        }
        e1 M0 = e1Var.M0(true);
        if (M0 == null) {
            a(6);
        }
        return M0;
    }

    @NotNull
    public static c2 s(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.j1 j1Var) {
        if (j1Var == null) {
            a(45);
        }
        return new l1(j1Var);
    }

    @NotNull
    public static c2 t(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.j1 j1Var, i0 i0Var) {
        if (j1Var == null) {
            a(46);
        }
        return i0Var.b() == TypeUsage.SUPERTYPE ? new e2(m1.b(j1Var)) : new l1(j1Var);
    }

    @NotNull
    public static e1 v(@NotNull w1 w1Var, @NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.k kVar, @NotNull Function1<kotlin.reflect.jvm.internal.impl.types.checker.g, e1> function1) {
        if (w1Var == null) {
            a(12);
        }
        if (kVar == null) {
            a(13);
        }
        if (function1 == null) {
            a(14);
        }
        e1 p5 = w0.p(t1.f47332b.k(), w1Var, g(w1Var.getParameters()), false, kVar, function1);
        if (p5 == null) {
            a(15);
        }
        return p5;
    }

    @NotNull
    public static e1 u(kotlin.reflect.jvm.internal.impl.descriptors.f fVar, kotlin.reflect.jvm.internal.impl.resolve.scopes.k kVar, Function1<kotlin.reflect.jvm.internal.impl.types.checker.g, e1> function1) {
        if (kotlin.reflect.jvm.internal.impl.types.error.i.m(fVar)) {
            kotlin.reflect.jvm.internal.impl.types.error.g d6 = kotlin.reflect.jvm.internal.impl.types.error.i.d(ErrorTypeKind.UNABLE_TO_SUBSTITUTE_TYPE, fVar.toString());
            if (d6 == null) {
                a(11);
            }
            return d6;
        }
        return v(fVar.o(), kVar, function1);
    }
}
