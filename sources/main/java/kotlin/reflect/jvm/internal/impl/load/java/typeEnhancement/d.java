package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAbstractSignatureParts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractSignatureParts.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/AbstractSignatureParts\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,234:1\n1#2:235\n1#2:258\n1#2:281\n774#3:236\n865#3,2:237\n1740#3,3:239\n1761#3,3:242\n1761#3,3:245\n1617#3,9:248\n1869#3:257\n1870#3:259\n1626#3:260\n1740#3,3:261\n1563#3:264\n1634#3,3:265\n1761#3,3:268\n1617#3,9:271\n1869#3:280\n1870#3:282\n1626#3:283\n1869#3,2:284\n3544#3,7:286\n*S KotlinDebug\n*F\n+ 1 AbstractSignatureParts.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/AbstractSignatureParts\n*L\n162#1:258\n188#1:281\n90#1:236\n90#1:237,2\n159#1:239,3\n161#1:242,3\n162#1:245,3\n162#1:248,9\n162#1:257\n162#1:259\n162#1:260\n165#1:261,3\n175#1:264\n175#1:265,3\n183#1:268,3\n188#1:271,9\n188#1:280\n188#1:282\n188#1:283\n201#1:284,2\n215#1:286,7\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class d<TAnnotation> {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private final e4.g f45756a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private final kotlin.reflect.jvm.internal.impl.load.java.e0 f45757b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        private final e4.p f45758c;

        @Nullable
        public final kotlin.reflect.jvm.internal.impl.load.java.e0 a() {
            return this.f45757b;
        }

        @Nullable
        public final e4.p b() {
            return this.f45758c;
        }

        @Nullable
        public final e4.g getType() {
            return this.f45756a;
        }

        public a(@Nullable e4.g gVar, @Nullable kotlin.reflect.jvm.internal.impl.load.java.e0 e0Var, @Nullable e4.p pVar) {
            this.f45756a = gVar;
            this.f45757b = e0Var;
            this.f45758c = pVar;
        }
    }

    @NotNull
    public abstract e4.r A();

    public abstract boolean B(@NotNull e4.g gVar);

    public abstract boolean C();

    public abstract boolean D(@NotNull e4.g gVar, @NotNull e4.g gVar2);

    public abstract boolean E(@NotNull e4.p pVar);

    public abstract boolean l(@NotNull TAnnotation tannotation, @Nullable e4.g gVar);

    @NotNull
    public abstract kotlin.reflect.jvm.internal.impl.load.java.b<TAnnotation> m();

    @NotNull
    public abstract Iterable<TAnnotation> n(@NotNull e4.g gVar);

    @NotNull
    public abstract Iterable<TAnnotation> p();

    @NotNull
    public abstract AnnotationQualifierApplicabilityType q();

    @Nullable
    public abstract kotlin.reflect.jvm.internal.impl.load.java.e0 r();

    public abstract boolean s();

    @Nullable
    protected abstract j t(@Nullable j jVar, @Nullable kotlin.reflect.jvm.internal.impl.load.java.v vVar);

    public abstract boolean u();

    @Nullable
    public abstract e4.g v(@NotNull e4.g gVar);

    public boolean w() {
        return false;
    }

    @Nullable
    public abstract kotlin.reflect.jvm.internal.impl.name.d x(@NotNull e4.g gVar);

    public abstract boolean z();

    private final j G(j jVar, j jVar2) {
        return jVar == null ? jVar2 : (jVar2 != null && ((jVar.d() && !jVar2.d()) || ((jVar.d() || !jVar2.d()) && (jVar.c().compareTo(jVar2.c()) < 0 || jVar.c().compareTo(jVar2.c()) <= 0)))) ? jVar2 : jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable I(d dVar, e4.r rVar, a it) {
        e4.g type;
        e4.o X;
        List<e4.p> R;
        e4.g type2;
        kotlin.jvm.internal.g0.p(it, "it");
        if ((dVar.z() && (type2 = it.getType()) != null && rVar.r(type2)) || (type = it.getType()) == null || (X = rVar.X(type)) == null || (R = rVar.R(X)) == null) {
            return null;
        }
        List<e4.p> list = R;
        List<e4.l> F = rVar.F(it.getType());
        Iterator<T> it2 = list.iterator();
        Iterator<T> it3 = F.iterator();
        ArrayList arrayList = new ArrayList(Math.min(kotlin.collections.f0.d0(list, 10), kotlin.collections.f0.d0(F, 10)));
        while (it2.hasNext() && it3.hasNext()) {
            e4.p pVar = (e4.p) it2.next();
            e4.g type3 = rVar.getType((e4.l) it3.next());
            arrayList.add(type3 == null ? new a(null, it.a(), pVar) : new a(type3, dVar.f(type3, it.a()), pVar));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h e(n1 n1Var, h[] hVarArr, int i6) {
        Map<Integer, h> b6;
        h hVar;
        return (n1Var == null || (b6 = n1Var.b()) == null || (hVar = b6.get(Integer.valueOf(i6))) == null) ? (i6 < 0 || i6 >= hVarArr.length) ? h.f45780e.a() : hVarArr[i6] : hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(d dVar, a aVar, Object extractNullability) {
        kotlin.jvm.internal.g0.p(extractNullability, "$this$extractNullability");
        return dVar.l(extractNullability, aVar.getType());
    }

    private final <T> List<T> j(T t5, Function1<? super T, ? extends Iterable<? extends T>> function1) {
        ArrayList arrayList = new ArrayList(1);
        k(t5, arrayList, function1);
        return arrayList;
    }

    public boolean F(@NotNull e4.g gVar) {
        kotlin.jvm.internal.g0.p(gVar, "<this>");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006f  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.h> d(@org.jetbrains.annotations.NotNull e4.g r10, @org.jetbrains.annotations.NotNull java.lang.Iterable<? extends e4.g> r11, @org.jetbrains.annotations.Nullable kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.n1 r12, boolean r13) {
        /*
            r9 = this;
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.g0.p(r10, r0)
            java.lang.String r0 = "overrides"
            kotlin.jvm.internal.g0.p(r11, r0)
            java.util.List r0 = r9.H(r10)
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.f0.d0(r11, r2)
            r1.<init>(r2)
            java.util.Iterator r2 = r11.iterator()
        L1d:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L31
            java.lang.Object r3 = r2.next()
            e4.g r3 = (e4.g) r3
            java.util.List r3 = r9.H(r3)
            r1.add(r3)
            goto L1d
        L31:
            boolean r2 = r9.w()
            r3 = 1
            if (r2 != 0) goto L68
            boolean r2 = r9.C()
            if (r2 == 0) goto L63
            boolean r2 = r11 instanceof java.util.Collection
            if (r2 == 0) goto L4c
            r2 = r11
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L4c
            goto L63
        L4c:
            java.util.Iterator r11 = r11.iterator()
        L50:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto L63
            java.lang.Object r2 = r11.next()
            e4.g r2 = (e4.g) r2
            boolean r2 = r9.D(r10, r2)
            if (r2 != 0) goto L50
            goto L68
        L63:
            int r10 = r0.size()
            goto L69
        L68:
            r10 = 1
        L69:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.h[] r11 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.h[r10]
            r2 = 0
            r4 = 0
        L6d:
            if (r4 >= r10) goto Lc7
            java.lang.Object r5 = r0.get(r4)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d$a r5 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d.a) r5
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.h r5 = r9.h(r5)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r7 = r1.iterator()
        L82:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto La8
            java.lang.Object r8 = r7.next()
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r8 = kotlin.collections.f0.b3(r8, r4)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d$a r8 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d.a) r8
            if (r8 == 0) goto La1
            e4.g r8 = r8.getType()
            if (r8 == 0) goto La1
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.h r8 = r9.g(r8)
            goto La2
        La1:
            r8 = 0
        La2:
            if (r8 == 0) goto L82
            r6.add(r8)
            goto L82
        La8:
            if (r4 != 0) goto Lb2
            boolean r7 = r9.C()
            if (r7 == 0) goto Lb2
            r7 = 1
            goto Lb3
        Lb2:
            r7 = 0
        Lb3:
            if (r4 != 0) goto Lbd
            boolean r8 = r9.s()
            if (r8 == 0) goto Lbd
            r8 = 1
            goto Lbe
        Lbd:
            r8 = 0
        Lbe:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.h r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.p1.a(r5, r6, r7, r8, r13)
            r11[r4] = r5
            int r4 = r4 + 1
            goto L6d
        Lc7:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.b r10 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.b
            r10.<init>(r12, r11)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d.d(e4.g, java.lang.Iterable, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.n1, boolean):kotlin.jvm.functions.Function1");
    }

    private final List<a> H(e4.g gVar) {
        return j(new a(gVar, f(gVar, r()), null), new c(this, A()));
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.e0 f(e4.g gVar, kotlin.reflect.jvm.internal.impl.load.java.e0 e0Var) {
        return m().d(e0Var, n(gVar));
    }

    private final h g(e4.g gVar) {
        NullabilityQualifier nullabilityQualifier;
        boolean z5;
        NullabilityQualifier y5 = y(gVar);
        MutabilityQualifier mutabilityQualifier = null;
        if (y5 == null) {
            e4.g v5 = v(gVar);
            if (v5 != null) {
                nullabilityQualifier = y(v5);
            } else {
                nullabilityQualifier = null;
            }
        } else {
            nullabilityQualifier = y5;
        }
        e4.r A = A();
        kotlin.reflect.jvm.internal.impl.builtins.jvm.c cVar = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f44463a;
        if (cVar.l(x(A.r0(gVar)))) {
            mutabilityQualifier = MutabilityQualifier.READ_ONLY;
        } else if (cVar.k(x(A.o(gVar)))) {
            mutabilityQualifier = MutabilityQualifier.MUTABLE;
        }
        boolean z6 = true;
        if (!A().d0(gVar) && !F(gVar)) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (nullabilityQualifier == y5) {
            z6 = false;
        }
        return new h(nullabilityQualifier, mutabilityQualifier, z5, z6);
    }

    private final h h(a aVar) {
        boolean z5;
        List J;
        e4.p pVar;
        boolean z6;
        AnnotationQualifierApplicabilityType q5;
        kotlin.reflect.jvm.internal.impl.load.java.v vVar;
        j jVar;
        NullabilityQualifier nullabilityQualifier;
        boolean z7;
        j jVar2;
        e4.g type;
        e4.o X;
        TypeVariance typeVariance;
        NullabilityQualifier nullabilityQualifier2 = null;
        if (aVar.getType() == null) {
            e4.r A = A();
            e4.p b6 = aVar.b();
            if (b6 != null) {
                typeVariance = A.n(b6);
            } else {
                typeVariance = null;
            }
            if (typeVariance == TypeVariance.IN) {
                return h.f45780e.a();
            }
        }
        boolean z8 = false;
        if (aVar.b() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        e4.g type2 = aVar.getType();
        if (type2 == null || (J = n(type2)) == null) {
            J = kotlin.collections.f0.J();
        }
        e4.r A2 = A();
        e4.g type3 = aVar.getType();
        if (type3 != null && (X = A2.X(type3)) != null) {
            pVar = A2.b0(X);
        } else {
            pVar = null;
        }
        if (q() == AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5) {
            if (!z6 && u() && (type = aVar.getType()) != null && B(type)) {
                Iterable<TAnnotation> p5 = p();
                ArrayList arrayList = new ArrayList();
                for (TAnnotation tannotation : p5) {
                    if (!m().p(tannotation)) {
                        arrayList.add(tannotation);
                    }
                }
                J = kotlin.collections.f0.I4(arrayList, J);
            } else {
                J = kotlin.collections.f0.E4(p(), J);
            }
        }
        MutabilityQualifier g6 = m().g(J);
        j h6 = m().h(J, new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a(this, aVar));
        if (h6 != null) {
            NullabilityQualifier c6 = h6.c();
            if (h6.c() == NullabilityQualifier.NOT_NULL && pVar != null) {
                z8 = true;
            }
            return new h(c6, g6, z8, h6.d());
        }
        if (!z5 && !z6) {
            q5 = AnnotationQualifierApplicabilityType.TYPE_USE;
        } else {
            q5 = q();
        }
        kotlin.reflect.jvm.internal.impl.load.java.e0 a6 = aVar.a();
        if (a6 != null) {
            vVar = a6.a(q5);
        } else {
            vVar = null;
        }
        if (pVar != null) {
            jVar = o(pVar);
        } else {
            jVar = null;
        }
        j t5 = t(jVar, vVar);
        if (jVar != null) {
            nullabilityQualifier = jVar.c();
        } else {
            nullabilityQualifier = null;
        }
        if (nullabilityQualifier != NullabilityQualifier.NOT_NULL && (pVar == null || vVar == null || !vVar.c())) {
            z7 = false;
        } else {
            z7 = true;
        }
        e4.p b7 = aVar.b();
        if (b7 != null && (jVar2 = o(b7)) != null) {
            if (jVar2.c() == NullabilityQualifier.NULLABLE) {
                jVar2 = j.b(jVar2, NullabilityQualifier.FORCE_FLEXIBILITY, false, 2, null);
            }
        } else {
            jVar2 = null;
        }
        j G = G(jVar2, t5);
        if (G != null) {
            nullabilityQualifier2 = G.c();
        }
        if (G != null && G.d()) {
            z8 = true;
        }
        return new h(nullabilityQualifier2, g6, z7, z8);
    }

    private final <T> void k(T t5, List<T> list, Function1<? super T, ? extends Iterable<? extends T>> function1) {
        list.add(t5);
        Iterable<? extends T> invoke = function1.invoke(t5);
        if (invoke != null) {
            Iterator<? extends T> it = invoke.iterator();
            while (it.hasNext()) {
                k(it.next(), list, function1);
            }
        }
    }

    private final j o(e4.p pVar) {
        List<e4.g> list;
        NullabilityQualifier nullabilityQualifier;
        boolean z5;
        e4.r A = A();
        if (!E(pVar)) {
            return null;
        }
        List<e4.g> e02 = A.e0(pVar);
        List<e4.g> list2 = e02;
        boolean z6 = list2 instanceof Collection;
        if (!z6 || !list2.isEmpty()) {
            Iterator<T> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (!A.y0((e4.g) it.next())) {
                    if (!z6 || !list2.isEmpty()) {
                        Iterator<T> it2 = list2.iterator();
                        while (it2.hasNext()) {
                            if (y((e4.g) it2.next()) != null) {
                                list = e02;
                                break;
                            }
                        }
                    }
                    if (!z6 || !list2.isEmpty()) {
                        Iterator<T> it3 = list2.iterator();
                        while (it3.hasNext()) {
                            if (v((e4.g) it3.next()) != null) {
                                list = new ArrayList<>();
                                Iterator<T> it4 = list2.iterator();
                                while (it4.hasNext()) {
                                    e4.g v5 = v((e4.g) it4.next());
                                    if (v5 != null) {
                                        list.add(v5);
                                    }
                                }
                                List<e4.g> list3 = list;
                                if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                                    Iterator<T> it5 = list3.iterator();
                                    while (it5.hasNext()) {
                                        if (!A.j0((e4.g) it5.next())) {
                                            nullabilityQualifier = NullabilityQualifier.NOT_NULL;
                                            break;
                                        }
                                    }
                                }
                                nullabilityQualifier = NullabilityQualifier.NULLABLE;
                                if (list != e02) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                return new j(nullabilityQualifier, z5);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    private final NullabilityQualifier y(e4.g gVar) {
        e4.r A = A();
        if (A.B0(A.r0(gVar))) {
            return NullabilityQualifier.NULLABLE;
        }
        if (!A.B0(A.o(gVar))) {
            return NullabilityQualifier.NOT_NULL;
        }
        return null;
    }
}
