package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAbstractTypeChecker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/AbstractTypeChecker\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/TypeCheckerState\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 TypeSystemContext.kt\norg/jetbrains/kotlin/types/model/TypeSystemContextKt\n*L\n1#1,884:1\n1#2:885\n1#2:899\n1#2:951\n1#2:986\n140#3,13:886\n153#3,13:900\n54#3,8:924\n140#3,13:938\n153#3,13:952\n140#3,13:973\n153#3,13:987\n1634#4,3:913\n1563#4:916\n1634#4,3:917\n1563#4:920\n1634#4,3:921\n1740#4,3:932\n1740#4,3:935\n774#4:965\n865#4:966\n866#4:972\n1374#4:1000\n1460#4,5:1001\n1761#4,3:1006\n1761#4,3:1009\n635#5,5:967\n*S KotlinDebug\n*F\n+ 1 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/AbstractTypeChecker\n*L\n383#1:899\n671#1:951\n741#1:986\n383#1:886,13\n383#1:900,13\n527#1:924,8\n671#1:938,13\n671#1:952,13\n741#1:973,13\n741#1:987,13\n426#1:913,3\n429#1:916\n429#1:917,3\n442#1:920\n442#1:921,3\n609#1:932,3\n620#1:935,3\n716#1:965\n716#1:966\n716#1:972\n750#1:1000\n750#1:1001,5\n336#1:1006,3\n344#1:1009,3\n717#1:967,5\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f47257a = new h();

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    public static boolean f47258b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f47259a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f47260b;

        static {
            int[] iArr = new int[TypeVariance.values().length];
            try {
                iArr[TypeVariance.INV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TypeVariance.OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TypeVariance.IN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f47259a = iArr;
            int[] iArr2 = new int[TypeCheckerState.LowerCapturedTypePolicy.values().length];
            try {
                iArr2[TypeCheckerState.LowerCapturedTypePolicy.CHECK_ONLY_LOWER.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[TypeCheckerState.LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[TypeCheckerState.LowerCapturedTypePolicy.SKIP_LOWER.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            f47260b = iArr2;
        }
    }

    private static final boolean d(e4.r rVar, e4.h hVar) {
        e4.g type;
        e4.h o5;
        return (hVar instanceof e4.b) && (type = rVar.getType(rVar.x(rVar.n0((e4.b) hVar)))) != null && (o5 = rVar.o(type)) != null && rVar.y(o5);
    }

    public static /* synthetic */ boolean v(h hVar, TypeCheckerState typeCheckerState, e4.g gVar, e4.g gVar2, boolean z5, int i6, Object obj) {
        if ((i6 & 8) != 0) {
            z5 = false;
        }
        return hVar.u(typeCheckerState, gVar, gVar2, z5);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean w(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState r18, e4.h r19, e4.h r20) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.h.w(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState, e4.h, e4.h):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 x(Collection collection, TypeCheckerState typeCheckerState, e4.r rVar, e4.h hVar, TypeCheckerState.a runForkingPoint) {
        kotlin.jvm.internal.g0.p(runForkingPoint, "$this$runForkingPoint");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            runForkingPoint.a(new g(typeCheckerState, rVar, (e4.h) it.next(), hVar));
        }
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean y(TypeCheckerState typeCheckerState, e4.r rVar, e4.h hVar, e4.h hVar2) {
        return f47257a.s(typeCheckerState, rVar.Q(hVar), hVar2);
    }

    @Nullable
    public final TypeVariance l(@NotNull TypeVariance declared, @NotNull TypeVariance useSite) {
        kotlin.jvm.internal.g0.p(declared, "declared");
        kotlin.jvm.internal.g0.p(useSite, "useSite");
        TypeVariance typeVariance = TypeVariance.INV;
        if (declared == typeVariance) {
            return useSite;
        }
        if (useSite == typeVariance || declared == useSite) {
            return declared;
        }
        return null;
    }

    public final boolean m(@NotNull TypeCheckerState state, @NotNull e4.g a6, @NotNull e4.g b6) {
        kotlin.jvm.internal.g0.p(state, "state");
        kotlin.jvm.internal.g0.p(a6, "a");
        kotlin.jvm.internal.g0.p(b6, "b");
        e4.r j6 = state.j();
        if (a6 == b6) {
            return true;
        }
        h hVar = f47257a;
        if (hVar.q(j6, a6) && hVar.q(j6, b6)) {
            e4.g p5 = state.p(state.q(a6));
            e4.g p6 = state.p(state.q(b6));
            e4.h r02 = j6.r0(p5);
            if (!j6.q0(j6.X(p5), j6.X(p6))) {
                return false;
            }
            if (j6.v(r02) == 0) {
                return j6.v0(p5) || j6.v0(p6) || j6.B0(r02) == j6.B0(j6.r0(p6));
            }
        }
        return v(hVar, state, a6, b6, false, 8, null) && v(hVar, state, b6, a6, false, 8, null);
    }

    @NotNull
    public final List<e4.h> n(@NotNull TypeCheckerState state, @NotNull e4.h subType, @NotNull e4.o superConstructor) {
        TypeCheckerState.b bVar;
        kotlin.jvm.internal.g0.p(state, "state");
        kotlin.jvm.internal.g0.p(subType, "subType");
        kotlin.jvm.internal.g0.p(superConstructor, "superConstructor");
        e4.r j6 = state.j();
        if (j6.J(subType)) {
            return f47257a.j(state, subType, superConstructor);
        }
        if (!j6.c0(superConstructor) && !j6.i(superConstructor)) {
            return f47257a.i(state, subType, superConstructor);
        }
        kotlin.reflect.jvm.internal.impl.utils.j<e4.h> jVar = new kotlin.reflect.jvm.internal.impl.utils.j();
        state.k();
        ArrayDeque<e4.h> h6 = state.h();
        kotlin.jvm.internal.g0.m(h6);
        Set<e4.h> i6 = state.i();
        kotlin.jvm.internal.g0.m(i6);
        h6.push(subType);
        while (!h6.isEmpty()) {
            e4.h pop = h6.pop();
            kotlin.jvm.internal.g0.m(pop);
            if (i6.add(pop)) {
                if (j6.J(pop)) {
                    jVar.add(pop);
                    bVar = TypeCheckerState.b.c.f47140a;
                } else {
                    bVar = TypeCheckerState.b.C0920b.f47139a;
                }
                if (kotlin.jvm.internal.g0.g(bVar, TypeCheckerState.b.c.f47140a)) {
                    bVar = null;
                }
                if (bVar != null) {
                    e4.r j7 = state.j();
                    Iterator<e4.g> it = j7.B(j7.c(pop)).iterator();
                    while (it.hasNext()) {
                        h6.add(bVar.a(state, it.next()));
                    }
                }
            }
        }
        state.e();
        ArrayList arrayList = new ArrayList();
        for (e4.h hVar : jVar) {
            h hVar2 = f47257a;
            kotlin.jvm.internal.g0.m(hVar);
            kotlin.collections.f0.s0(arrayList, hVar2.j(state, hVar, superConstructor));
        }
        return arrayList;
    }

    public final boolean s(@NotNull TypeCheckerState typeCheckerState, @NotNull e4.k capturedSubArguments, @NotNull e4.h superType) {
        int i6;
        int i7;
        boolean m6;
        int i8;
        TypeCheckerState typeCheckerState2 = typeCheckerState;
        kotlin.jvm.internal.g0.p(typeCheckerState2, "<this>");
        kotlin.jvm.internal.g0.p(capturedSubArguments, "capturedSubArguments");
        kotlin.jvm.internal.g0.p(superType, "superType");
        e4.r j6 = typeCheckerState2.j();
        e4.o c6 = j6.c(superType);
        int W = j6.W(capturedSubArguments);
        int V = j6.V(c6);
        if (W != V || W != j6.v(superType)) {
            return false;
        }
        for (int i9 = 0; i9 < V; i9++) {
            e4.l I = j6.I(superType, i9);
            e4.g type = j6.getType(I);
            if (type != null) {
                e4.l t5 = j6.t(capturedSubArguments, i9);
                j6.M(t5);
                TypeVariance typeVariance = TypeVariance.INV;
                e4.g type2 = j6.getType(t5);
                kotlin.jvm.internal.g0.m(type2);
                h hVar = f47257a;
                TypeVariance l6 = hVar.l(j6.n(j6.s(c6, i9)), j6.M(I));
                if (l6 == null) {
                    return typeCheckerState2.n();
                }
                if (l6 != typeVariance || (!hVar.z(j6, type2, type, c6) && !hVar.z(j6, type, type2, c6))) {
                    i6 = typeCheckerState2.f47134h;
                    if (i6 > 100) {
                        throw new IllegalStateException(("Arguments depth is too high. Some related argument: " + type2).toString());
                    }
                    i7 = typeCheckerState2.f47134h;
                    typeCheckerState2.f47134h = i7 + 1;
                    int i10 = a.f47259a[l6.ordinal()];
                    if (i10 == 1) {
                        m6 = hVar.m(typeCheckerState2, type2, type);
                    } else if (i10 == 2) {
                        typeCheckerState2 = typeCheckerState;
                        m6 = v(hVar, typeCheckerState2, type2, type, false, 8, null);
                    } else {
                        if (i10 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        m6 = v(hVar, typeCheckerState2, type, type2, false, 8, null);
                        typeCheckerState2 = typeCheckerState;
                    }
                    i8 = typeCheckerState2.f47134h;
                    typeCheckerState2.f47134h = i8 - 1;
                    if (!m6) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @JvmOverloads
    public final boolean t(@NotNull TypeCheckerState state, @NotNull e4.g subType, @NotNull e4.g superType) {
        kotlin.jvm.internal.g0.p(state, "state");
        kotlin.jvm.internal.g0.p(subType, "subType");
        kotlin.jvm.internal.g0.p(superType, "superType");
        return v(this, state, subType, superType, false, 8, null);
    }

    @JvmOverloads
    public final boolean u(@NotNull TypeCheckerState state, @NotNull e4.g subType, @NotNull e4.g superType, boolean z5) {
        kotlin.jvm.internal.g0.p(state, "state");
        kotlin.jvm.internal.g0.p(subType, "subType");
        kotlin.jvm.internal.g0.p(superType, "superType");
        if (subType == superType) {
            return true;
        }
        if (state.f(subType, superType)) {
            return k(state, subType, superType, z5);
        }
        return false;
    }

    private h() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<e4.h> A(TypeCheckerState typeCheckerState, List<? extends e4.h> list) {
        e4.e eVar;
        e4.r j6 = typeCheckerState.j();
        if (list.size() >= 2) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                e4.k Q = j6.Q((e4.h) obj);
                int W = j6.W(Q);
                int i6 = 0;
                while (true) {
                    if (i6 < W) {
                        e4.g type = j6.getType(j6.t(Q, i6));
                        if (type != null) {
                            eVar = j6.a0(type);
                        } else {
                            eVar = null;
                        }
                        if (eVar == null) {
                            i6++;
                        }
                    } else {
                        arrayList.add(obj);
                        break;
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
        }
        return list;
    }

    private final Boolean c(TypeCheckerState typeCheckerState, e4.h hVar, e4.h hVar2) {
        e4.r j6 = typeCheckerState.j();
        if (!j6.y(hVar) && !j6.y(hVar2)) {
            return null;
        }
        if (f(j6, hVar) && f(j6, hVar2)) {
            return Boolean.TRUE;
        }
        if (j6.y(hVar)) {
            if (g(j6, typeCheckerState, hVar, hVar2, false)) {
                return Boolean.TRUE;
            }
        } else if (j6.y(hVar2) && (e(j6, hVar) || g(j6, typeCheckerState, hVar2, hVar, true))) {
            return Boolean.TRUE;
        }
        return null;
    }

    private static final boolean e(e4.r rVar, e4.h hVar) {
        e4.o c6 = rVar.c(hVar);
        if (c6 instanceof e4.f) {
            Collection<e4.g> B = rVar.B(c6);
            if (!(B instanceof Collection) || !B.isEmpty()) {
                Iterator<T> it = B.iterator();
                while (it.hasNext()) {
                    e4.h f6 = rVar.f((e4.g) it.next());
                    if (f6 != null && rVar.y(f6)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private static final boolean f(e4.r rVar, e4.h hVar) {
        if (!rVar.y(hVar) && !d(rVar, hVar)) {
            return false;
        }
        return true;
    }

    private static final boolean g(e4.r rVar, TypeCheckerState typeCheckerState, e4.h hVar, e4.h hVar2, boolean z5) {
        TypeCheckerState typeCheckerState2;
        e4.h hVar3;
        Collection<e4.g> P = rVar.P(hVar);
        if ((P instanceof Collection) && P.isEmpty()) {
            return false;
        }
        for (e4.g gVar : P) {
            if (!kotlin.jvm.internal.g0.g(rVar.X(gVar), rVar.c(hVar2))) {
                if (z5) {
                    typeCheckerState2 = typeCheckerState;
                    hVar3 = hVar2;
                    if (v(f47257a, typeCheckerState2, hVar3, gVar, false, 8, null)) {
                        return true;
                    }
                } else {
                    typeCheckerState2 = typeCheckerState;
                    hVar3 = hVar2;
                }
                typeCheckerState = typeCheckerState2;
                hVar2 = hVar3;
            } else {
                return true;
            }
        }
        return false;
    }

    private final Boolean h(TypeCheckerState typeCheckerState, e4.h hVar, e4.h hVar2) {
        e4.g gVar;
        e4.r j6 = typeCheckerState.j();
        boolean z5 = false;
        if (!j6.y0(hVar) && !j6.y0(hVar2)) {
            if (j6.D0(hVar) && j6.D0(hVar2)) {
                if (f47257a.r(j6, hVar, hVar2) || typeCheckerState.o()) {
                    z5 = true;
                }
                return Boolean.valueOf(z5);
            }
            if (!j6.A(hVar) && !j6.A(hVar2)) {
                e4.b m6 = j6.m(hVar2);
                if (m6 != null) {
                    gVar = j6.p(m6);
                } else {
                    gVar = null;
                }
                if (m6 != null && gVar != null) {
                    if (j6.B0(hVar2)) {
                        gVar = j6.G(gVar, true);
                    } else if (j6.H(hVar2)) {
                        gVar = j6.j(gVar);
                    }
                    e4.g gVar2 = gVar;
                    int i6 = a.f47260b[typeCheckerState.g(hVar, m6).ordinal()];
                    if (i6 != 1) {
                        if (i6 != 2) {
                            if (i6 != 3) {
                                throw new NoWhenBranchMatchedException();
                            }
                        } else if (v(f47257a, typeCheckerState, hVar, gVar2, false, 8, null)) {
                            return Boolean.TRUE;
                        }
                    } else {
                        return Boolean.valueOf(v(f47257a, typeCheckerState, hVar, gVar2, false, 8, null));
                    }
                }
                e4.o c6 = j6.c(hVar2);
                if (j6.h0(c6)) {
                    j6.B0(hVar2);
                    Collection<e4.g> B = j6.B(c6);
                    if (!(B instanceof Collection) || !B.isEmpty()) {
                        Iterator<T> it = B.iterator();
                        while (it.hasNext()) {
                            if (!v(f47257a, typeCheckerState, hVar, (e4.g) it.next(), false, 8, null)) {
                                break;
                            }
                        }
                    }
                    z5 = true;
                    return Boolean.valueOf(z5);
                }
                e4.o c7 = j6.c(hVar);
                if (!(hVar instanceof e4.b)) {
                    if (j6.h0(c7)) {
                        Collection<e4.g> B2 = j6.B(c7);
                        if (!(B2 instanceof Collection) || !B2.isEmpty()) {
                            Iterator<T> it2 = B2.iterator();
                            while (it2.hasNext()) {
                                if (!(((e4.g) it2.next()) instanceof e4.b)) {
                                    break;
                                }
                            }
                        }
                    }
                    return null;
                }
                e4.p o5 = f47257a.o(typeCheckerState.j(), hVar2, hVar);
                if (o5 != null && j6.C(o5, j6.c(hVar2))) {
                    return Boolean.TRUE;
                }
                return null;
            }
            return Boolean.valueOf(typeCheckerState.o());
        }
        if (typeCheckerState.n()) {
            return Boolean.TRUE;
        }
        if (j6.B0(hVar) && !j6.B0(hVar2)) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(d.f47201a.b(j6, j6.a(hVar, false), j6.a(hVar2, false)));
    }

    private final List<e4.h> i(TypeCheckerState typeCheckerState, e4.h hVar, e4.o oVar) {
        TypeCheckerState.b k6;
        e4.r j6 = typeCheckerState.j();
        List<e4.i> S = j6.S(hVar, oVar);
        if (S != null) {
            return S;
        }
        if (!j6.c0(oVar) && j6.J(hVar)) {
            return kotlin.collections.f0.J();
        }
        if (j6.D(oVar)) {
            if (j6.q0(j6.c(hVar), oVar)) {
                e4.h O = j6.O(hVar, CaptureStatus.FOR_SUBTYPING);
                if (O != null) {
                    hVar = O;
                }
                return kotlin.collections.f0.l(hVar);
            }
            return kotlin.collections.f0.J();
        }
        kotlin.reflect.jvm.internal.impl.utils.j jVar = new kotlin.reflect.jvm.internal.impl.utils.j();
        typeCheckerState.k();
        ArrayDeque<e4.h> h6 = typeCheckerState.h();
        kotlin.jvm.internal.g0.m(h6);
        Set<e4.h> i6 = typeCheckerState.i();
        kotlin.jvm.internal.g0.m(i6);
        h6.push(hVar);
        while (!h6.isEmpty()) {
            e4.h pop = h6.pop();
            kotlin.jvm.internal.g0.m(pop);
            if (i6.add(pop)) {
                e4.h O2 = j6.O(pop, CaptureStatus.FOR_SUBTYPING);
                if (O2 == null) {
                    O2 = pop;
                }
                if (j6.q0(j6.c(O2), oVar)) {
                    jVar.add(O2);
                    k6 = TypeCheckerState.b.c.f47140a;
                } else if (j6.v(O2) == 0) {
                    k6 = TypeCheckerState.b.C0920b.f47139a;
                } else {
                    k6 = typeCheckerState.j().k(O2);
                }
                if (kotlin.jvm.internal.g0.g(k6, TypeCheckerState.b.c.f47140a)) {
                    k6 = null;
                }
                if (k6 != null) {
                    e4.r j7 = typeCheckerState.j();
                    Iterator<e4.g> it = j7.B(j7.c(pop)).iterator();
                    while (it.hasNext()) {
                        h6.add(k6.a(typeCheckerState, it.next()));
                    }
                }
            }
        }
        typeCheckerState.e();
        return jVar;
    }

    private final List<e4.h> j(TypeCheckerState typeCheckerState, e4.h hVar, e4.o oVar) {
        return A(typeCheckerState, i(typeCheckerState, hVar, oVar));
    }

    private final boolean k(TypeCheckerState typeCheckerState, e4.g gVar, e4.g gVar2, boolean z5) {
        e4.r j6 = typeCheckerState.j();
        e4.g p5 = typeCheckerState.p(typeCheckerState.q(gVar));
        e4.g p6 = typeCheckerState.p(typeCheckerState.q(gVar2));
        if (typeCheckerState.m() && j6.l(p5) && j6.d0(p6)) {
            h hVar = f47257a;
            e4.e a02 = j6.a0(p5);
            kotlin.jvm.internal.g0.m(a02);
            e4.h e6 = j6.e(a02);
            e4.h f6 = j6.f(p6);
            kotlin.jvm.internal.g0.m(f6);
            return hVar.k(typeCheckerState, e6, j6.U(f6), z5);
        }
        h hVar2 = f47257a;
        Boolean h6 = hVar2.h(typeCheckerState, j6.r0(p5), j6.o(p6));
        if (h6 != null) {
            boolean booleanValue = h6.booleanValue();
            typeCheckerState.c(p5, p6, z5);
            return booleanValue;
        }
        Boolean c6 = typeCheckerState.c(p5, p6, z5);
        if (c6 != null) {
            return c6.booleanValue();
        }
        return hVar2.w(typeCheckerState, j6.r0(p5), j6.o(p6));
    }

    private final e4.p o(e4.r rVar, e4.g gVar, e4.g gVar2) {
        e4.g type;
        boolean z5;
        int v5 = rVar.v(gVar);
        int i6 = 0;
        while (true) {
            e4.l lVar = null;
            if (i6 >= v5) {
                return null;
            }
            e4.l I = rVar.I(gVar, i6);
            if (!rVar.g(I)) {
                lVar = I;
            }
            if (lVar != null && (type = rVar.getType(lVar)) != null) {
                if (rVar.E0(rVar.r0(type)) && rVar.E0(rVar.r0(gVar2))) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (kotlin.jvm.internal.g0.g(type, gVar2) || (z5 && kotlin.jvm.internal.g0.g(rVar.X(type), rVar.X(gVar2)))) {
                    break;
                }
                e4.p o5 = o(rVar, type, gVar2);
                if (o5 != null) {
                    return o5;
                }
            }
            i6++;
        }
        return rVar.s(rVar.X(gVar), i6);
    }

    private final boolean p(TypeCheckerState typeCheckerState, e4.h hVar) {
        TypeCheckerState.b bVar;
        e4.r j6 = typeCheckerState.j();
        e4.o c6 = j6.c(hVar);
        if (j6.c0(c6)) {
            return j6.A0(c6);
        }
        if (j6.A0(j6.c(hVar))) {
            return true;
        }
        typeCheckerState.k();
        ArrayDeque<e4.h> h6 = typeCheckerState.h();
        kotlin.jvm.internal.g0.m(h6);
        Set<e4.h> i6 = typeCheckerState.i();
        kotlin.jvm.internal.g0.m(i6);
        h6.push(hVar);
        while (!h6.isEmpty()) {
            e4.h pop = h6.pop();
            kotlin.jvm.internal.g0.m(pop);
            if (i6.add(pop)) {
                if (j6.J(pop)) {
                    bVar = TypeCheckerState.b.c.f47140a;
                } else {
                    bVar = TypeCheckerState.b.C0920b.f47139a;
                }
                if (kotlin.jvm.internal.g0.g(bVar, TypeCheckerState.b.c.f47140a)) {
                    bVar = null;
                }
                if (bVar == null) {
                    continue;
                } else {
                    e4.r j7 = typeCheckerState.j();
                    Iterator<e4.g> it = j7.B(j7.c(pop)).iterator();
                    while (it.hasNext()) {
                        e4.h a6 = bVar.a(typeCheckerState, it.next());
                        if (j6.A0(j6.c(a6))) {
                            typeCheckerState.e();
                            return true;
                        }
                        h6.add(a6);
                    }
                }
            }
        }
        typeCheckerState.e();
        return false;
    }

    private final boolean q(e4.r rVar, e4.g gVar) {
        if (rVar.J0(rVar.X(gVar)) && !rVar.N(gVar) && !rVar.d0(gVar) && !rVar.u0(gVar) && !rVar.G0(gVar)) {
            return true;
        }
        return false;
    }

    private final boolean r(e4.r rVar, e4.h hVar, e4.h hVar2) {
        if (rVar.c(hVar) != rVar.c(hVar2)) {
            return false;
        }
        if (!rVar.H(hVar) && rVar.H(hVar2)) {
            return false;
        }
        if (rVar.B0(hVar) && !rVar.B0(hVar2)) {
            return false;
        }
        return true;
    }

    private final boolean z(e4.r rVar, e4.g gVar, e4.g gVar2, e4.o oVar) {
        e4.w wVar;
        e4.p F0;
        e4.h f6 = rVar.f(gVar);
        if (f6 instanceof e4.b) {
            e4.b bVar = (e4.b) f6;
            if (rVar.p0(bVar) || !rVar.g(rVar.x(rVar.n0(bVar))) || rVar.k0(bVar) != CaptureStatus.FOR_SUBTYPING) {
                return false;
            }
            e4.o X = rVar.X(gVar2);
            if (X instanceof e4.w) {
                wVar = (e4.w) X;
            } else {
                wVar = null;
            }
            if (wVar != null && (F0 = rVar.F0(wVar)) != null && rVar.C(F0, oVar)) {
                return true;
            }
        }
        return false;
    }
}
