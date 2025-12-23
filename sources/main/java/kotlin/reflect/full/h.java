package kotlin.reflect.full;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.collections.f0;
import kotlin.collections.i1;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.e0;
import kotlin.reflect.jvm.internal.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.h2;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.utils.b;
import kotlin.reflect.jvm.internal.m1;
import kotlin.reflect.jvm.internal.z2;
import kotlin.reflect.o;
import kotlin.reflect.p;
import kotlin.reflect.q;
import kotlin.reflect.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "KClasses")
@SourceDebugExtension({"SMAP\nKClasses.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KClasses.kt\nkotlin/reflect/full/KClasses\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,279:1\n295#2,2:280\n295#2,2:282\n808#2,11:284\n808#2,11:295\n774#2:306\n865#2,2:307\n774#2:309\n865#2,2:310\n808#2,11:312\n774#2:323\n865#2,2:324\n774#2:326\n865#2,2:327\n774#2:329\n865#2,2:330\n774#2:332\n865#2,2:333\n774#2:335\n865#2,2:336\n774#2:338\n865#2,2:339\n774#2:341\n865#2,2:342\n1617#2,9:344\n1869#2:353\n1870#2:355\n1626#2:356\n1563#2:357\n1634#2,3:358\n669#2,4:361\n1740#2,3:365\n673#2,7:368\n1563#2:375\n1634#2,3:376\n1#3:354\n*S KotlinDebug\n*F\n+ 1 KClasses.kt\nkotlin/reflect/full/KClasses\n*L\n36#1:280,2\n47#1:282,2\n87#1:284,11\n94#1:295,11\n101#1:306\n101#1:307,2\n108#1:309\n108#1:310,2\n117#1:312,11\n124#1:323\n124#1:324,2\n131#1:326\n131#1:327,2\n139#1:329\n139#1:330,2\n146#1:332\n146#1:333,2\n153#1:335\n153#1:336,2\n160#1:338\n160#1:339,2\n167#1:341\n167#1:342,2\n182#1:344,9\n182#1:353\n182#1:355\n182#1:356\n221#1:357\n221#1:358,3\n274#1:361,4\n274#1:365,3\n274#1:368,7\n198#1:375\n198#1:376,3\n182#1:354\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends b.f<r, r> {
        @Override // kotlin.reflect.jvm.internal.impl.utils.b.AbstractC0925b, kotlin.reflect.jvm.internal.impl.utils.b.e
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public boolean b(r current) {
            g0.p(current, "current");
            ((LinkedList) this.f47473a).add(current);
            return true;
        }

        a() {
        }
    }

    @NotNull
    public static final Collection<kotlin.reflect.c<?>> A(@NotNull kotlin.reflect.d<?> dVar) {
        g0.p(dVar, "<this>");
        return ((h0.b) ((h0) dVar).j0().getValue()).N();
    }

    @NotNull
    public static final r C(@NotNull kotlin.reflect.d<?> dVar) {
        g0.p(dVar, "<this>");
        e1 s5 = ((h0) dVar).d().s();
        g0.o(s5, "getDefaultType(...)");
        return new z2(s5, new d(dVar));
    }

    @NotNull
    public static final Collection<kotlin.reflect.i<?>> E(@NotNull kotlin.reflect.d<?> dVar) {
        g0.p(dVar, "<this>");
        Collection<kotlin.reflect.c<?>> o5 = dVar.o();
        ArrayList arrayList = new ArrayList();
        for (Object obj : o5) {
            if (obj instanceof kotlin.reflect.i) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final Collection<kotlin.reflect.i<?>> G(@NotNull kotlin.reflect.d<?> dVar) {
        g0.p(dVar, "<this>");
        Collection<e0<?>> J = ((h0.b) ((h0) dVar).j0().getValue()).J();
        ArrayList arrayList = new ArrayList();
        for (Object obj : J) {
            e0 e0Var = (e0) obj;
            if (W(e0Var) && (e0Var instanceof kotlin.reflect.i)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> Collection<q<T, ?, ?>> I(@NotNull kotlin.reflect.d<T> dVar) {
        g0.p(dVar, "<this>");
        Collection<e0<?>> J = ((h0) dVar).j0().getValue().J();
        ArrayList arrayList = new ArrayList();
        for (T t5 : J) {
            e0 e0Var = (e0) t5;
            if (W(e0Var) && (e0Var instanceof q)) {
                arrayList.add(t5);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final Collection<kotlin.reflect.i<?>> K(@NotNull kotlin.reflect.d<?> dVar) {
        g0.p(dVar, "<this>");
        Collection<e0<?>> J = ((h0.b) ((h0) dVar).j0().getValue()).J();
        ArrayList arrayList = new ArrayList();
        for (Object obj : J) {
            e0 e0Var = (e0) obj;
            if (X(e0Var) && (e0Var instanceof kotlin.reflect.i)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> Collection<p<T, ?>> M(@NotNull kotlin.reflect.d<T> dVar) {
        g0.p(dVar, "<this>");
        Collection<e0<?>> J = ((h0) dVar).j0().getValue().J();
        ArrayList arrayList = new ArrayList();
        for (T t5 : J) {
            e0 e0Var = (e0) t5;
            if (X(e0Var) && (e0Var instanceof p)) {
                arrayList.add(t5);
            }
        }
        return arrayList;
    }

    @Nullable
    public static final <T> kotlin.reflect.i<T> O(@NotNull kotlin.reflect.d<T> dVar) {
        T t5;
        g0.p(dVar, "<this>");
        Iterator<T> it = ((h0) dVar).f().iterator();
        while (true) {
            if (!it.hasNext()) {
                t5 = null;
                break;
            }
            t5 = it.next();
            kotlin.reflect.i iVar = (kotlin.reflect.i) t5;
            g0.n(iVar, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KFunctionImpl");
            y e02 = ((m1) iVar).e0();
            g0.n(e02, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ConstructorDescriptor");
            if (((kotlin.reflect.jvm.internal.impl.descriptors.j) e02).m0()) {
                break;
            }
        }
        return (kotlin.reflect.i) t5;
    }

    @NotNull
    public static final Collection<kotlin.reflect.i<?>> Q(@NotNull kotlin.reflect.d<?> dVar) {
        g0.p(dVar, "<this>");
        Collection<e0<?>> K = ((h0.b) ((h0) dVar).j0().getValue()).K();
        ArrayList arrayList = new ArrayList();
        for (Object obj : K) {
            if (obj instanceof kotlin.reflect.i) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final Collection<o<?>> S(@NotNull kotlin.reflect.d<?> dVar) {
        g0.p(dVar, "<this>");
        Collection<e0<?>> K = ((h0.b) ((h0) dVar).j0().getValue()).K();
        ArrayList arrayList = new ArrayList();
        for (Object obj : K) {
            e0 e0Var = (e0) obj;
            if (X(e0Var) && (e0Var instanceof o)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<kotlin.reflect.d<?>> U(@NotNull kotlin.reflect.d<?> dVar) {
        g0.p(dVar, "<this>");
        List<r> i6 = dVar.i();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = i6.iterator();
        while (it.hasNext()) {
            kotlin.reflect.g n6 = ((r) it.next()).n();
            kotlin.reflect.d dVar2 = n6 instanceof kotlin.reflect.d ? (kotlin.reflect.d) n6 : null;
            if (dVar2 != null) {
                arrayList.add(dVar2);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static final boolean Y(@NotNull kotlin.reflect.d<?> dVar, @NotNull kotlin.reflect.d<?> base) {
        g0.p(dVar, "<this>");
        g0.p(base, "base");
        return g0.g(dVar, base) || kotlin.reflect.jvm.internal.impl.utils.b.e(f0.l(dVar), new f(new PropertyReference1Impl() { // from class: kotlin.reflect.full.h.b
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return h.U((kotlin.reflect.d) obj);
            }
        }), new g(base)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type b(kotlin.reflect.d dVar) {
        return ((h0) dVar).c();
    }

    @SinceKotlin(version = "1.1")
    public static final boolean b0(@NotNull kotlin.reflect.d<?> dVar, @NotNull kotlin.reflect.d<?> derived) {
        g0.p(dVar, "<this>");
        g0.p(derived, "derived");
        return Y(derived, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    @Nullable
    public static final <T> T c0(@NotNull kotlin.reflect.d<T> dVar, @Nullable Object obj) {
        g0.p(dVar, "<this>");
        if (!dVar.C(obj)) {
            return null;
        }
        g0.n(obj, "null cannot be cast to non-null type T of kotlin.reflect.full.KClasses.safeCast");
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T> T g(@NotNull kotlin.reflect.d<T> dVar, @Nullable Object obj) {
        g0.p(dVar, "<this>");
        if (dVar.C(obj)) {
            g0.n(obj, "null cannot be cast to non-null type T of kotlin.reflect.full.KClasses.cast");
            return obj;
        }
        throw new TypeCastException("Value cannot be cast to " + dVar.x());
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T> T h(@NotNull kotlin.reflect.d<T> dVar) {
        g0.p(dVar, "<this>");
        Iterator<T> it = dVar.f().iterator();
        T t5 = null;
        boolean z5 = false;
        T t6 = null;
        while (true) {
            if (it.hasNext()) {
                T next = it.next();
                List<KParameter> parameters = ((kotlin.reflect.i) next).getParameters();
                if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
                    Iterator<T> it2 = parameters.iterator();
                    while (it2.hasNext()) {
                        if (!((KParameter) it2.next()).p()) {
                            break;
                        }
                    }
                }
                if (z5) {
                    break;
                }
                z5 = true;
                t6 = next;
            } else if (z5) {
                t5 = t6;
            }
        }
        kotlin.reflect.i iVar = (kotlin.reflect.i) t5;
        if (iVar != null) {
            return (T) iVar.callBy(i1.z());
        }
        throw new IllegalArgumentException("Class should have a single no-arg constructor: " + dVar);
    }

    @NotNull
    public static final Collection<kotlin.reflect.d<?>> i(@NotNull kotlin.reflect.d<?> dVar) {
        g0.p(dVar, "<this>");
        Collection<r> k6 = k(dVar);
        ArrayList arrayList = new ArrayList(f0.d0(k6, 10));
        for (r rVar : k6) {
            kotlin.reflect.g n6 = rVar.n();
            kotlin.reflect.d dVar2 = n6 instanceof kotlin.reflect.d ? (kotlin.reflect.d) n6 : null;
            if (dVar2 == null) {
                throw new KotlinReflectionInternalError("Supertype not a class: " + rVar);
            }
            arrayList.add(dVar2);
        }
        return arrayList;
    }

    @NotNull
    public static final Collection<r> k(@NotNull kotlin.reflect.d<?> dVar) {
        g0.p(dVar, "<this>");
        Object c6 = kotlin.reflect.jvm.internal.impl.utils.b.c(dVar.i(), e.f44228a, new b.h(), new a());
        g0.o(c6, "dfs(...)");
        return (Collection) c6;
    }

    @Nullable
    public static final kotlin.reflect.d<?> m(@NotNull kotlin.reflect.d<?> dVar) {
        Object obj;
        g0.p(dVar, "<this>");
        Iterator<T> it = dVar.y().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((kotlin.reflect.d) obj).B()) {
                break;
            }
        }
        return (kotlin.reflect.d) obj;
    }

    @Nullable
    public static final Object o(@NotNull kotlin.reflect.d<?> dVar) {
        g0.p(dVar, "<this>");
        kotlin.reflect.d<?> m6 = m(dVar);
        if (m6 != null) {
            return m6.A();
        }
        return null;
    }

    @NotNull
    public static final Collection<kotlin.reflect.i<?>> q(@NotNull kotlin.reflect.d<?> dVar) {
        g0.p(dVar, "<this>");
        Collection<e0<?>> N = ((h0.b) ((h0) dVar).j0().getValue()).N();
        ArrayList arrayList = new ArrayList();
        for (Object obj : N) {
            if (obj instanceof kotlin.reflect.i) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final Collection<kotlin.reflect.i<?>> s(@NotNull kotlin.reflect.d<?> dVar) {
        g0.p(dVar, "<this>");
        Collection<e0<?>> O = ((h0.b) ((h0) dVar).j0().getValue()).O();
        ArrayList arrayList = new ArrayList();
        for (Object obj : O) {
            e0 e0Var = (e0) obj;
            if (W(e0Var) && (e0Var instanceof kotlin.reflect.i)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> Collection<q<T, ?, ?>> u(@NotNull kotlin.reflect.d<T> dVar) {
        g0.p(dVar, "<this>");
        Collection<e0<?>> O = ((h0) dVar).j0().getValue().O();
        ArrayList arrayList = new ArrayList();
        for (T t5 : O) {
            e0 e0Var = (e0) t5;
            if (W(e0Var) && (e0Var instanceof q)) {
                arrayList.add(t5);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final Collection<kotlin.reflect.i<?>> w(@NotNull kotlin.reflect.d<?> dVar) {
        g0.p(dVar, "<this>");
        Collection<e0<?>> O = ((h0.b) ((h0) dVar).j0().getValue()).O();
        ArrayList arrayList = new ArrayList();
        for (Object obj : O) {
            e0 e0Var = (e0) obj;
            if (X(e0Var) && (e0Var instanceof kotlin.reflect.i)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> Collection<p<T, ?>> y(@NotNull kotlin.reflect.d<T> dVar) {
        g0.p(dVar, "<this>");
        Collection<e0<?>> O = ((h0) dVar).j0().getValue().O();
        ArrayList arrayList = new ArrayList();
        for (T t5 : O) {
            e0 e0Var = (e0) t5;
            if (X(e0Var) && (e0Var instanceof p)) {
                arrayList.add(t5);
            }
        }
        return arrayList;
    }

    private static final boolean W(e0<?> e0Var) {
        if (e0Var.e0().f0() != null) {
            return true;
        }
        return false;
    }

    private static final boolean X(e0<?> e0Var) {
        return !W(e0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable Z(p pVar, kotlin.reflect.d dVar) {
        return (Iterable) pVar.invoke(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable a(r rVar) {
        kotlin.reflect.d dVar;
        kotlin.reflect.g n6 = rVar.n();
        Function0 function0 = null;
        byte b6 = 0;
        if (n6 instanceof kotlin.reflect.d) {
            dVar = (kotlin.reflect.d) n6;
        } else {
            dVar = null;
        }
        if (dVar != null) {
            List<r> i6 = dVar.i();
            if (rVar.getArguments().isEmpty()) {
                return i6;
            }
            g0.n(rVar, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
            h2 f6 = h2.f(((z2) rVar).getType());
            List<r> list = i6;
            ArrayList arrayList = new ArrayList(f0.d0(list, 10));
            for (r rVar2 : list) {
                g0.n(rVar2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                t0 p5 = f6.p(((z2) rVar2).getType(), Variance.INVARIANT);
                if (p5 != null) {
                    arrayList.add(new z2(p5, function0, 2, b6 == true ? 1 : 0));
                } else {
                    throw new KotlinReflectionInternalError("Type substitution failed: " + rVar2 + " (" + rVar + ')');
                }
            }
            return arrayList;
        }
        throw new KotlinReflectionInternalError("Supertype not a class: " + rVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean a0(kotlin.reflect.d dVar, kotlin.reflect.d dVar2) {
        return Boolean.valueOf(g0.g(dVar2, dVar));
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void B(kotlin.reflect.d dVar) {
    }

    @Deprecated(message = "This function creates a type which rarely makes sense for generic classes. For example, such type can only be used in signatures of members of that class. Use starProjectedType or createType() for clearer semantics.")
    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void D(kotlin.reflect.d dVar) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void F(kotlin.reflect.d dVar) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void H(kotlin.reflect.d dVar) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void J(kotlin.reflect.d dVar) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void L(kotlin.reflect.d dVar) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void N(kotlin.reflect.d dVar) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void P(kotlin.reflect.d dVar) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void R(kotlin.reflect.d dVar) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void T(kotlin.reflect.d dVar) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void V(kotlin.reflect.d dVar) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void j(kotlin.reflect.d dVar) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void l(kotlin.reflect.d dVar) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void n(kotlin.reflect.d dVar) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void p(kotlin.reflect.d dVar) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void r(kotlin.reflect.d dVar) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void t(kotlin.reflect.d dVar) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void v(kotlin.reflect.d dVar) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void x(kotlin.reflect.d dVar) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void z(kotlin.reflect.d dVar) {
    }
}
