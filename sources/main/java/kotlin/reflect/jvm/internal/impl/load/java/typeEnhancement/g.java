package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.c2;
import kotlin.reflect.jvm.internal.impl.types.j2;
import kotlin.reflect.jvm.internal.impl.types.m2;
import kotlin.reflect.jvm.internal.impl.types.t1;
import kotlin.reflect.jvm.internal.impl.types.u1;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\ntypeEnhancement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 typeEnhancement.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/JavaTypeEnhancement\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,261:1\n1#2:262\n3544#3,7:263\n1740#3,3:270\n3544#3,7:273\n*S KotlinDebug\n*F\n+ 1 typeEnhancement.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/JavaTypeEnhancement\n*L\n117#1:263,7\n143#1:270,3\n155#1:273,7\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.e f45772a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private final kotlin.reflect.jvm.internal.impl.types.t0 f45773a;

        /* renamed from: b, reason: collision with root package name */
        private final int f45774b;

        public final int a() {
            return this.f45774b;
        }

        @Nullable
        public final kotlin.reflect.jvm.internal.impl.types.t0 getType() {
            return this.f45773a;
        }

        public a(@Nullable kotlin.reflect.jvm.internal.impl.types.t0 t0Var, int i6) {
            this.f45773a = t0Var;
            this.f45774b = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private final kotlin.reflect.jvm.internal.impl.types.e1 f45775a;

        /* renamed from: b, reason: collision with root package name */
        private final int f45776b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f45777c;

        public final boolean a() {
            return this.f45777c;
        }

        public final int b() {
            return this.f45776b;
        }

        @Nullable
        public final kotlin.reflect.jvm.internal.impl.types.e1 getType() {
            return this.f45775a;
        }

        public b(@Nullable kotlin.reflect.jvm.internal.impl.types.e1 e1Var, int i6, boolean z5) {
            this.f45775a = e1Var;
            this.f45776b = i6;
            this.f45777c = z5;
        }
    }

    public g(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.e javaResolverSettings) {
        kotlin.jvm.internal.g0.p(javaResolverSettings, "javaResolverSettings");
        this.f45772a = javaResolverSettings;
    }

    private final b b(kotlin.reflect.jvm.internal.impl.types.e1 e1Var, Function1<? super Integer, h> function1, int i6, TypeComponentPosition typeComponentPosition, boolean z5, boolean z6) {
        kotlin.reflect.jvm.internal.impl.descriptors.f f6;
        Boolean h6;
        w1 I0;
        f fVar;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g e6;
        Boolean bool;
        a aVar;
        c2 s5;
        Function1<? super Integer, h> function12 = function1;
        boolean a6 = m1.a(typeComponentPosition);
        boolean z7 = (z6 && z5) ? false : true;
        kotlin.reflect.jvm.internal.impl.types.t0 t0Var = null;
        if (!a6 && e1Var.G0().isEmpty()) {
            return new b(null, 1, false);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = e1Var.I0().c();
        if (c6 == null) {
            return new b(null, 1, false);
        }
        h invoke = function12.invoke(Integer.valueOf(i6));
        f6 = o1.f(c6, invoke, typeComponentPosition);
        h6 = o1.h(invoke, typeComponentPosition);
        if (f6 == null || (I0 = f6.o()) == null) {
            I0 = e1Var.I0();
        }
        w1 w1Var = I0;
        int i7 = i6 + 1;
        List<c2> G0 = e1Var.G0();
        List<kotlin.reflect.jvm.internal.impl.descriptors.j1> parameters = w1Var.getParameters();
        kotlin.jvm.internal.g0.o(parameters, "getParameters(...)");
        List<kotlin.reflect.jvm.internal.impl.descriptors.j1> list = parameters;
        Iterator<T> it = G0.iterator();
        Iterator<T> it2 = list.iterator();
        ArrayList arrayList = new ArrayList(Math.min(kotlin.collections.f0.d0(G0, 10), kotlin.collections.f0.d0(list, 10)));
        while (it.hasNext() && it2.hasNext()) {
            Object next = it.next();
            kotlin.reflect.jvm.internal.impl.descriptors.j1 j1Var = (kotlin.reflect.jvm.internal.impl.descriptors.j1) it2.next();
            c2 c2Var = (c2) next;
            if (z7) {
                bool = h6;
                if (!c2Var.b()) {
                    aVar = d(c2Var.getType().L0(), function12, i7, z6);
                } else if (function12.invoke(Integer.valueOf(i7)).f() == NullabilityQualifier.FORCE_FLEXIBILITY) {
                    m2 L0 = c2Var.getType().L0();
                    aVar = new a(kotlin.reflect.jvm.internal.impl.types.w0.e(kotlin.reflect.jvm.internal.impl.types.n0.c(L0).M0(false), kotlin.reflect.jvm.internal.impl.types.n0.d(L0).M0(true)), 1);
                } else {
                    aVar = new a(null, 1);
                }
            } else {
                bool = h6;
                aVar = new a(t0Var, 0);
            }
            i7 += aVar.a();
            if (aVar.getType() != null) {
                kotlin.reflect.jvm.internal.impl.types.t0 type = aVar.getType();
                Variance c7 = c2Var.c();
                kotlin.jvm.internal.g0.o(c7, "getProjectionKind(...)");
                s5 = kotlin.reflect.jvm.internal.impl.types.typeUtil.e.l(type, c7, j1Var);
            } else if (f6 == null || c2Var.b()) {
                s5 = f6 != null ? j2.s(j1Var) : null;
            } else {
                kotlin.reflect.jvm.internal.impl.types.t0 type2 = c2Var.getType();
                kotlin.jvm.internal.g0.o(type2, "getType(...)");
                Variance c8 = c2Var.c();
                kotlin.jvm.internal.g0.o(c8, "getProjectionKind(...)");
                s5 = kotlin.reflect.jvm.internal.impl.types.typeUtil.e.l(type2, c8, j1Var);
            }
            arrayList.add(s5);
            function12 = function1;
            h6 = bool;
            t0Var = null;
        }
        Boolean bool2 = h6;
        int i8 = i7 - i6;
        if (f6 == null && bool2 == null) {
            if (!arrayList.isEmpty()) {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    if (((c2) it3.next()) == null) {
                    }
                }
            }
            return new b(null, i8, false);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations = e1Var.getAnnotations();
        fVar = o1.f45822b;
        if (f6 == null) {
            fVar = null;
        }
        e6 = o1.e(kotlin.collections.f0.S(annotations, fVar, bool2 != null ? o1.g() : null));
        t1 b6 = u1.b(e6);
        List<c2> G02 = e1Var.G0();
        Iterator it4 = arrayList.iterator();
        Iterator<T> it5 = G02.iterator();
        ArrayList arrayList2 = new ArrayList(Math.min(kotlin.collections.f0.d0(arrayList, 10), kotlin.collections.f0.d0(G02, 10)));
        while (it4.hasNext() && it5.hasNext()) {
            Object next2 = it4.next();
            c2 c2Var2 = (c2) it5.next();
            c2 c2Var3 = (c2) next2;
            if (c2Var3 != null) {
                c2Var2 = c2Var3;
            }
            arrayList2.add(c2Var2);
        }
        kotlin.reflect.jvm.internal.impl.types.e1 m6 = kotlin.reflect.jvm.internal.impl.types.w0.m(b6, w1Var, arrayList2, bool2 != null ? bool2.booleanValue() : e1Var.J0(), null, 16, null);
        if (invoke.d()) {
            m6 = e(m6);
        }
        return new b(m6, i8, bool2 != null && invoke.g());
    }

    static /* synthetic */ b c(g gVar, kotlin.reflect.jvm.internal.impl.types.e1 e1Var, Function1 function1, int i6, TypeComponentPosition typeComponentPosition, boolean z5, boolean z6, int i7, Object obj) {
        if ((i7 & 8) != 0) {
            z5 = false;
        }
        if ((i7 & 16) != 0) {
            z6 = false;
        }
        return gVar.b(e1Var, function1, i6, typeComponentPosition, z5, z6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x009b, code lost:
    
        if (r1 == null) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.g.a d(kotlin.reflect.jvm.internal.impl.types.m2 r21, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.h> r22, int r23, boolean r24) {
        /*
            r20 = this;
            r0 = r21
            boolean r1 = kotlin.reflect.jvm.internal.impl.types.x0.a(r0)
            r2 = 0
            if (r1 == 0) goto L10
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.g$a r0 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.g$a
            r1 = 1
            r0.<init>(r2, r1)
            return r0
        L10:
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.types.k0
            if (r1 == 0) goto Lb2
            boolean r8 = r0 instanceof kotlin.reflect.jvm.internal.impl.types.d1
            r1 = r0
            kotlin.reflect.jvm.internal.impl.types.k0 r1 = (kotlin.reflect.jvm.internal.impl.types.k0) r1
            kotlin.reflect.jvm.internal.impl.types.e1 r4 = r1.Q0()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r7 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.FLEXIBLE_LOWER
            r3 = r20
            r5 = r22
            r6 = r23
            r9 = r24
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.g$b r10 = r3.b(r4, r5, r6, r7, r8, r9)
            kotlin.reflect.jvm.internal.impl.types.e1 r4 = r1.R0()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r7 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.FLEXIBLE_UPPER
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.g$b r4 = r3.b(r4, r5, r6, r7, r8, r9)
            r10.b()
            r4.b()
            kotlin.reflect.jvm.internal.impl.types.e1 r3 = r10.getType()
            if (r3 != 0) goto L48
            kotlin.reflect.jvm.internal.impl.types.e1 r3 = r4.getType()
            if (r3 != 0) goto L48
            goto La8
        L48:
            boolean r2 = r10.a()
            if (r2 != 0) goto L8a
            boolean r2 = r4.a()
            if (r2 == 0) goto L55
            goto L8a
        L55:
            if (r8 == 0) goto L71
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.j r2 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.j
            kotlin.reflect.jvm.internal.impl.types.e1 r0 = r10.getType()
            if (r0 != 0) goto L63
            kotlin.reflect.jvm.internal.impl.types.e1 r0 = r1.Q0()
        L63:
            kotlin.reflect.jvm.internal.impl.types.e1 r3 = r4.getType()
            if (r3 != 0) goto L6d
            kotlin.reflect.jvm.internal.impl.types.e1 r3 = r1.R0()
        L6d:
            r2.<init>(r0, r3)
            goto La8
        L71:
            kotlin.reflect.jvm.internal.impl.types.e1 r0 = r10.getType()
            if (r0 != 0) goto L7b
            kotlin.reflect.jvm.internal.impl.types.e1 r0 = r1.Q0()
        L7b:
            kotlin.reflect.jvm.internal.impl.types.e1 r2 = r4.getType()
            if (r2 != 0) goto L85
            kotlin.reflect.jvm.internal.impl.types.e1 r2 = r1.R0()
        L85:
            kotlin.reflect.jvm.internal.impl.types.m2 r2 = kotlin.reflect.jvm.internal.impl.types.w0.e(r0, r2)
            goto La8
        L8a:
            kotlin.reflect.jvm.internal.impl.types.e1 r1 = r4.getType()
            if (r1 == 0) goto L9d
            kotlin.reflect.jvm.internal.impl.types.e1 r2 = r10.getType()
            if (r2 != 0) goto L97
            r2 = r1
        L97:
            kotlin.reflect.jvm.internal.impl.types.m2 r1 = kotlin.reflect.jvm.internal.impl.types.w0.e(r2, r1)
            if (r1 != 0) goto La4
        L9d:
            kotlin.reflect.jvm.internal.impl.types.e1 r1 = r10.getType()
            kotlin.jvm.internal.g0.m(r1)
        La4:
            kotlin.reflect.jvm.internal.impl.types.m2 r2 = kotlin.reflect.jvm.internal.impl.types.l2.d(r0, r1)
        La8:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.g$a r0 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.g$a
            int r1 = r10.b()
            r0.<init>(r2, r1)
            return r0
        Lb2:
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.types.e1
            if (r1 == 0) goto Lea
            r12 = r0
            kotlin.reflect.jvm.internal.impl.types.e1 r12 = (kotlin.reflect.jvm.internal.impl.types.e1) r12
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r15 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.INFLEXIBLE
            r18 = 8
            r19 = 0
            r16 = 0
            r11 = r20
            r13 = r22
            r14 = r23
            r17 = r24
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.g$b r1 = c(r11, r12, r13, r14, r15, r16, r17, r18, r19)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.g$a r2 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.g$a
            boolean r3 = r1.a()
            if (r3 == 0) goto Lde
            kotlin.reflect.jvm.internal.impl.types.e1 r3 = r1.getType()
            kotlin.reflect.jvm.internal.impl.types.m2 r0 = kotlin.reflect.jvm.internal.impl.types.l2.d(r0, r3)
            goto Le2
        Lde:
            kotlin.reflect.jvm.internal.impl.types.e1 r0 = r1.getType()
        Le2:
            int r1 = r1.b()
            r2.<init>(r0, r1)
            return r2
        Lea:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.g.d(kotlin.reflect.jvm.internal.impl.types.m2, kotlin.jvm.functions.Function1, int, boolean):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.g$a");
    }

    private final kotlin.reflect.jvm.internal.impl.types.e1 e(kotlin.reflect.jvm.internal.impl.types.e1 e1Var) {
        return this.f45772a.a() ? kotlin.reflect.jvm.internal.impl.types.i1.h(e1Var, true) : new i(e1Var);
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.types.t0 a(@NotNull kotlin.reflect.jvm.internal.impl.types.t0 t0Var, @NotNull Function1<? super Integer, h> qualifiers, boolean z5) {
        kotlin.jvm.internal.g0.p(t0Var, "<this>");
        kotlin.jvm.internal.g0.p(qualifiers, "qualifiers");
        return d(t0Var.L0(), qualifiers, 0, z5).getType();
    }
}
