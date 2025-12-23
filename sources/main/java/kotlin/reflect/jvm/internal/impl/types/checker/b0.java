package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.i1;
import kotlin.reflect.jvm.internal.impl.types.m2;
import kotlin.reflect.jvm.internal.impl.types.n0;
import kotlin.reflect.jvm.internal.impl.types.n1;
import kotlin.reflect.jvm.internal.impl.types.s0;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.t1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nIntersectionType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntersectionType.kt\norg/jetbrains/kotlin/types/checker/TypeIntersector\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,183:1\n1563#2:184\n1634#2,2:185\n1636#2:188\n1803#2,3:189\n1634#2,3:192\n1563#2:195\n1634#2,3:196\n2783#2,7:199\n1761#2,3:206\n1#3:187\n*S KotlinDebug\n*F\n+ 1 IntersectionType.kt\norg/jetbrains/kotlin/types/checker/TypeIntersector\n*L\n80#1:184\n80#1:185,2\n80#1:188\n87#1:189,3\n98#1:192,3\n104#1:195\n104#1:196,3\n104#1:199,7\n137#1:206,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b0 f47159a = new b0();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f47160a = new c("START", 0);

        /* renamed from: b, reason: collision with root package name */
        public static final a f47161b = new C0922a("ACCEPT_NULL", 1);

        /* renamed from: c, reason: collision with root package name */
        public static final a f47162c = new d("UNKNOWN", 2);

        /* renamed from: d, reason: collision with root package name */
        public static final a f47163d = new b("NOT_NULL", 3);

        /* renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ a[] f47164e;

        /* renamed from: f, reason: collision with root package name */
        private static final /* synthetic */ kotlin.enums.a f47165f;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.types.checker.b0$a$a, reason: collision with other inner class name */
        static final class C0922a extends a {
            C0922a(String str, int i6) {
                super(str, i6, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.b0.a
            @NotNull
            public a b(@NotNull m2 nextType) {
                g0.p(nextType, "nextType");
                return c(nextType);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class b extends a {
            b(String str, int i6) {
                super(str, i6, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.b0.a
            @NotNull
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public b b(@NotNull m2 nextType) {
                g0.p(nextType, "nextType");
                return this;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class c extends a {
            c(String str, int i6) {
                super(str, i6, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.b0.a
            @NotNull
            public a b(@NotNull m2 nextType) {
                g0.p(nextType, "nextType");
                return c(nextType);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class d extends a {
            d(String str, int i6) {
                super(str, i6, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.b0.a
            @NotNull
            public a b(@NotNull m2 nextType) {
                g0.p(nextType, "nextType");
                a c6 = c(nextType);
                return c6 == a.f47161b ? this : c6;
            }
        }

        public /* synthetic */ a(String str, int i6, kotlin.jvm.internal.v vVar) {
            this(str, i6);
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{f47160a, f47161b, f47162c, f47163d};
        }

        @NotNull
        public abstract a b(@NotNull m2 m2Var);

        static {
            a[] a6 = a();
            f47164e = a6;
            f47165f = kotlin.enums.c.c(a6);
        }

        private a(String str, int i6) {
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f47164e.clone();
        }

        @NotNull
        protected final a c(@NotNull m2 m2Var) {
            g0.p(m2Var, "<this>");
            return m2Var.J0() ? f47161b : ((m2Var instanceof kotlin.reflect.jvm.internal.impl.types.z) && (((kotlin.reflect.jvm.internal.impl.types.z) m2Var).U0() instanceof n1)) ? f47163d : m2Var instanceof n1 ? f47162c : s.f47194a.a(m2Var) ? f47163d : f47162c;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class b extends FunctionReferenceImpl implements Function2<t0, t0, Boolean> {
        b(Object obj) {
            super(2, obj, b0.class, "isStrictSupertype", "isStrictSupertype(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(t0 p02, t0 p12) {
            g0.p(p02, "p0");
            g0.p(p12, "p1");
            return Boolean.valueOf(((b0) this.receiver).g(p02, p12));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class c extends FunctionReferenceImpl implements Function2<t0, t0, Boolean> {
        c(Object obj) {
            super(2, obj, q.class, "equalTypes", "equalTypes(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(t0 p02, t0 p12) {
            g0.p(p02, "p0");
            g0.p(p12, "p1");
            return Boolean.valueOf(((q) this.receiver).a(p02, p12));
        }
    }

    private final Collection<e1> c(Collection<? extends e1> collection, Function2<? super e1, ? super e1, Boolean> function2) {
        ArrayList arrayList = new ArrayList(collection);
        Iterator it = arrayList.iterator();
        g0.o(it, "iterator(...)");
        while (it.hasNext()) {
            e1 e1Var = (e1) it.next();
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    e1 e1Var2 = (e1) it2.next();
                    if (e1Var2 != e1Var) {
                        g0.m(e1Var2);
                        g0.m(e1Var);
                        if (function2.invoke(e1Var2, e1Var).booleanValue()) {
                            it.remove();
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String f(Set set) {
        return "This collections cannot be empty! input types: " + f0.r3(set, null, null, null, 0, null, null, 63, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean g(t0 t0Var, t0 t0Var2) {
        q a6 = p.f47188b.a();
        return a6.d(t0Var, t0Var2) && !a6.d(t0Var2, t0Var);
    }

    @NotNull
    public final e1 d(@NotNull List<? extends e1> types) {
        g0.p(types, "types");
        types.size();
        ArrayList<e1> arrayList = new ArrayList();
        for (e1 e1Var : types) {
            if (e1Var.I0() instanceof s0) {
                Collection<t0> i6 = e1Var.I0().i();
                g0.o(i6, "getSupertypes(...)");
                Collection<t0> collection = i6;
                ArrayList arrayList2 = new ArrayList(f0.d0(collection, 10));
                for (t0 t0Var : collection) {
                    g0.m(t0Var);
                    e1 d6 = n0.d(t0Var);
                    if (e1Var.J0()) {
                        d6 = d6.M0(true);
                    }
                    arrayList2.add(d6);
                }
                arrayList.addAll(arrayList2);
            } else {
                arrayList.add(e1Var);
            }
        }
        a aVar = a.f47160a;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            aVar = aVar.b((m2) it.next());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (e1 e1Var2 : arrayList) {
            if (aVar == a.f47163d) {
                if (e1Var2 instanceof i) {
                    e1Var2 = i1.k((i) e1Var2);
                }
                e1Var2 = i1.i(e1Var2, false, 1, null);
            }
            linkedHashSet.add(e1Var2);
        }
        List<? extends e1> list = types;
        ArrayList arrayList3 = new ArrayList(f0.d0(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((e1) it2.next()).H0());
        }
        Iterator it3 = arrayList3.iterator();
        if (!it3.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object next = it3.next();
        while (it3.hasNext()) {
            next = ((t1) next).o((t1) it3.next());
        }
        return e(linkedHashSet).O0((t1) next);
    }

    private b0() {
    }

    private final e1 e(Set<? extends e1> set) {
        if (set.size() == 1) {
            return (e1) f0.k5(set);
        }
        new a0(set);
        Collection<e1> c6 = c(set, new b(this));
        c6.isEmpty();
        e1 b6 = kotlin.reflect.jvm.internal.impl.resolve.constants.q.f46674f.b(c6);
        if (b6 != null) {
            return b6;
        }
        Collection<e1> c7 = c(c6, new c(p.f47188b.a()));
        c7.isEmpty();
        if (c7.size() < 2) {
            return (e1) f0.k5(c7);
        }
        return new s0(set).j();
    }
}
