package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.e2;
import kotlin.reflect.jvm.internal.impl.types.g2;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.t1;
import kotlin.reflect.jvm.internal.impl.types.w0;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nIntegerLiteralTypeConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntegerLiteralTypeConstructor.kt\norg/jetbrains/kotlin/resolve/constants/IntegerLiteralTypeConstructor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,181:1\n1740#2,3:182\n1761#2,3:185\n*S KotlinDebug\n*F\n+ 1 IntegerLiteralTypeConstructor.kt\norg/jetbrains/kotlin/resolve/constants/IntegerLiteralTypeConstructor\n*L\n132#1:182,3\n176#1:185,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class q implements w1 {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f46674f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final long f46675a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.f0 f46676b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Set<t0> f46677c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final e1 f46678d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final kotlin.s f46679e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nIntegerLiteralTypeConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntegerLiteralTypeConstructor.kt\norg/jetbrains/kotlin/resolve/constants/IntegerLiteralTypeConstructor$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,181:1\n2783#2,7:182\n*S KotlinDebug\n*F\n+ 1 IntegerLiteralTypeConstructor.kt\norg/jetbrains/kotlin/resolve/constants/IntegerLiteralTypeConstructor$Companion\n*L\n40#1:182,7\n*E\n"})
    public static final class a {

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.constants.q$a$a, reason: collision with other inner class name */
        private static final class EnumC0912a {

            /* renamed from: a, reason: collision with root package name */
            public static final EnumC0912a f46680a = new EnumC0912a("COMMON_SUPER_TYPE", 0);

            /* renamed from: b, reason: collision with root package name */
            public static final EnumC0912a f46681b = new EnumC0912a("INTERSECTION_TYPE", 1);

            /* renamed from: c, reason: collision with root package name */
            private static final /* synthetic */ EnumC0912a[] f46682c;

            /* renamed from: d, reason: collision with root package name */
            private static final /* synthetic */ kotlin.enums.a f46683d;

            private static final /* synthetic */ EnumC0912a[] a() {
                return new EnumC0912a[]{f46680a, f46681b};
            }

            static {
                EnumC0912a[] a6 = a();
                f46682c = a6;
                f46683d = kotlin.enums.c.c(a6);
            }

            public static EnumC0912a valueOf(String str) {
                return (EnumC0912a) Enum.valueOf(EnumC0912a.class, str);
            }

            public static EnumC0912a[] values() {
                return (EnumC0912a[]) f46682c.clone();
            }

            private EnumC0912a(String str, int i6) {
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private final e1 e(e1 e1Var, e1 e1Var2, EnumC0912a enumC0912a) {
            if (e1Var != null && e1Var2 != null) {
                w1 I0 = e1Var.I0();
                w1 I02 = e1Var2.I0();
                boolean z5 = I0 instanceof q;
                if (z5 && (I02 instanceof q)) {
                    return c((q) I0, (q) I02, enumC0912a);
                }
                if (z5) {
                    return d((q) I0, e1Var2);
                }
                if (I02 instanceof q) {
                    return d((q) I02, e1Var);
                }
            }
            return null;
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final /* synthetic */ class b {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f46684a;

            static {
                int[] iArr = new int[EnumC0912a.values().length];
                try {
                    iArr[EnumC0912a.f46680a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC0912a.f46681b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f46684a = iArr;
            }
        }

        private a() {
        }

        private final e1 c(q qVar, q qVar2, EnumC0912a enumC0912a) {
            Set n32;
            int i6 = b.f46684a[enumC0912a.ordinal()];
            if (i6 == 1) {
                n32 = kotlin.collections.f0.n3(qVar.j(), qVar2.j());
            } else {
                if (i6 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                n32 = kotlin.collections.f0.h6(qVar.j(), qVar2.j());
            }
            return w0.f(t1.f47332b.k(), new q(qVar.f46675a, qVar.f46676b, n32, null), false);
        }

        @Nullable
        public final e1 b(@NotNull Collection<? extends e1> types) {
            g0.p(types, "types");
            return a(types, EnumC0912a.f46681b);
        }

        private final e1 a(Collection<? extends e1> collection, EnumC0912a enumC0912a) {
            if (collection.isEmpty()) {
                return null;
            }
            Iterator<T> it = collection.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                while (it.hasNext()) {
                    e1 e1Var = (e1) it.next();
                    next = q.f46674f.e((e1) next, e1Var, enumC0912a);
                }
                return (e1) next;
            }
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }

        private final e1 d(q qVar, e1 e1Var) {
            if (qVar.j().contains(e1Var)) {
                return e1Var;
            }
            return null;
        }
    }

    public /* synthetic */ q(long j6, kotlin.reflect.jvm.internal.impl.descriptors.f0 f0Var, Set set, kotlin.jvm.internal.v vVar) {
        this(j6, f0Var, set);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.f c() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    public boolean d() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private q(long j6, kotlin.reflect.jvm.internal.impl.descriptors.f0 f0Var, Set<? extends t0> set) {
        this.f46678d = w0.f(t1.f47332b.k(), this, false);
        this.f46679e = kotlin.t.c(new o(this));
        this.f46675a = j6;
        this.f46676b = f0Var;
        this.f46677c = set;
    }

    private final List<t0> k() {
        return (List) this.f46679e.getValue();
    }

    private final boolean l() {
        Collection<t0> a6 = w.a(this.f46676b);
        if ((a6 instanceof Collection) && a6.isEmpty()) {
            return true;
        }
        Iterator<T> it = a6.iterator();
        while (it.hasNext()) {
            if (this.f46677c.contains((t0) it.next())) {
                return false;
            }
        }
        return true;
    }

    private final String n() {
        return '[' + kotlin.collections.f0.r3(this.f46677c, ",", null, null, 0, null, p.f46673a, 30, null) + ']';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence o(t0 it) {
        g0.p(it, "it");
        return it.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    public w1 a(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @NotNull
    public final Set<t0> j() {
        return this.f46677c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    public kotlin.reflect.jvm.internal.impl.builtins.j p() {
        return this.f46676b.p();
    }

    @NotNull
    public String toString() {
        return "IntegerLiteralType" + n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List m(q qVar) {
        e1 s5 = qVar.p().y().s();
        g0.o(s5, "getDefaultType(...)");
        List U = kotlin.collections.f0.U(g2.f(s5, kotlin.collections.f0.l(new e2(Variance.IN_VARIANCE, qVar.f46678d)), null, 2, null));
        if (!qVar.l()) {
            U.add(qVar.p().M());
        }
        return U;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    public List<j1> getParameters() {
        return kotlin.collections.f0.J();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    public Collection<t0> i() {
        return k();
    }
}
