package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.o1;
import kotlin.reflect.jvm.internal.impl.descriptors.s1;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.h2;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\ninlineClassesUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 inlineClassesUtils.kt\norg/jetbrains/kotlin/resolve/InlineClassesUtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,90:1\n1563#2:91\n1634#2,3:92\n1563#2:96\n1634#2,3:97\n1761#2,3:100\n1#3:95\n*S KotlinDebug\n*F\n+ 1 inlineClassesUtils.kt\norg/jetbrains/kotlin/resolve/InlineClassesUtilsKt\n*L\n40#1:91\n40#1:92,3\n56#1:96\n56#1:97,3\n67#1:100,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c f46710a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.b f46711b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c f46712c;

    static {
        kotlin.reflect.jvm.internal.impl.name.c cVar = new kotlin.reflect.jvm.internal.impl.name.c("kotlin.jvm.JvmInline");
        f46710a = cVar;
        f46711b = kotlin.reflect.jvm.internal.impl.name.b.f46334d.c(cVar);
        f46712c = new kotlin.reflect.jvm.internal.impl.name.c("kotlin.jvm.JvmName");
    }

    public static final boolean a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        g0.p(aVar, "<this>");
        if (!(aVar instanceof x0)) {
            return false;
        }
        w0 h02 = ((x0) aVar).h0();
        g0.o(h02, "getCorrespondingProperty(...)");
        return f(h02);
    }

    public static final boolean b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        g0.p(kVar, "<this>");
        return (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) && (((kotlin.reflect.jvm.internal.impl.descriptors.d) kVar).g0() instanceof z);
    }

    public static final boolean c(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = t0Var.I0().c();
        if (c6 != null) {
            return b(c6);
        }
        return false;
    }

    public static final boolean d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        g0.p(kVar, "<this>");
        return (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) && (((kotlin.reflect.jvm.internal.impl.descriptors.d) kVar).g0() instanceof kotlin.reflect.jvm.internal.impl.descriptors.g0);
    }

    public static final boolean e(@NotNull s1 s1Var) {
        z<e1> q5;
        g0.p(s1Var, "<this>");
        if (s1Var.f0() != null) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.k b6 = s1Var.b();
        kotlin.reflect.jvm.internal.impl.name.f fVar = null;
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = b6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) b6 : null;
        if (dVar != null && (q5 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.q(dVar)) != null) {
            fVar = q5.c();
        }
        return g0.g(fVar, s1Var.getName());
    }

    public static final boolean f(@NotNull s1 s1Var) {
        o1<e1> g02;
        g0.p(s1Var, "<this>");
        if (s1Var.f0() != null) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.k b6 = s1Var.b();
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = b6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) b6 : null;
        if (dVar == null || (g02 = dVar.g0()) == null) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.name.f name = s1Var.getName();
        g0.o(name, "getName(...)");
        return g02.a(name);
    }

    public static final boolean g(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        g0.p(kVar, "<this>");
        return b(kVar) || d(kVar);
    }

    public static final boolean h(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = t0Var.I0().c();
        if (c6 != null) {
            return g(c6);
        }
        return false;
    }

    public static final boolean i(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = t0Var.I0().c();
        return (c6 == null || !d(c6) || kotlin.reflect.jvm.internal.impl.types.checker.u.f47196a.j0(t0Var)) ? false : true;
    }

    @Nullable
    public static final t0 j(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        t0 k6 = k(t0Var);
        if (k6 != null) {
            return h2.f(t0Var).p(k6, Variance.INVARIANT);
        }
        return null;
    }

    @Nullable
    public static final t0 k(@NotNull t0 t0Var) {
        z<e1> q5;
        g0.p(t0Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = t0Var.I0().c();
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) c6 : null;
        if (dVar == null || (q5 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.q(dVar)) == null) {
            return null;
        }
        return q5.d();
    }
}
