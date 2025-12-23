package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.collections.f0;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.checker.g;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f46707a = new g();

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar2) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar2) {
        return false;
    }

    public static /* synthetic */ boolean f(g gVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, boolean z5, boolean z6, boolean z7, kotlin.reflect.jvm.internal.impl.types.checker.g gVar2, int i6, Object obj) {
        return gVar.e(aVar, aVar2, z5, (i6 & 8) != 0 ? true : z6, (i6 & 16) != 0 ? false : z7, gVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(boolean z5, kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, w1 c12, w1 c22) {
        g0.p(c12, "c1");
        g0.p(c22, "c2");
        if (g0.g(c12, c22)) {
            return true;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = c12.c();
        kotlin.reflect.jvm.internal.impl.descriptors.f c7 = c22.c();
        if ((c6 instanceof j1) && (c7 instanceof j1)) {
            return f46707a.n((j1) c6, (j1) c7, z5, new f(aVar, aVar2));
        }
        return false;
    }

    public static /* synthetic */ boolean l(g gVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar2, boolean z5, boolean z6, int i6, Object obj) {
        if ((i6 & 8) != 0) {
            z6 = true;
        }
        return gVar.k(kVar, kVar2, z5, z6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean o(g gVar, j1 j1Var, j1 j1Var2, boolean z5, Function2 function2, int i6, Object obj) {
        if ((i6 & 8) != 0) {
            function2 = c.f46652a;
        }
        return gVar.n(j1Var, j1Var2, z5, function2);
    }

    private final e1 r(kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        while (aVar instanceof CallableMemberDescriptor) {
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) aVar;
            if (callableMemberDescriptor.h() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                break;
            }
            Collection<? extends CallableMemberDescriptor> e6 = callableMemberDescriptor.e();
            g0.o(e6, "getOverriddenDescriptors(...)");
            aVar = (CallableMemberDescriptor) f0.n5(e6);
            if (aVar == null) {
                return null;
            }
        }
        return aVar.getSource();
    }

    public final boolean e(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a a6, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a b6, boolean z5, boolean z6, boolean z7, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        g0.p(a6, "a");
        g0.p(b6, "b");
        g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (g0.g(a6, b6)) {
            return true;
        }
        if (!g0.g(a6.getName(), b6.getName())) {
            return false;
        }
        if (z6 && (a6 instanceof c0) && (b6 instanceof c0) && ((c0) a6).q0() != ((c0) b6).q0()) {
            return false;
        }
        if ((g0.g(a6.b(), b6.b()) && (!z5 || !g0.g(r(a6), r(b6)))) || i.E(a6) || i.E(b6) || !q(a6, b6, d.f46692a, z5)) {
            return false;
        }
        OverridingUtil i6 = OverridingUtil.i(kotlinTypeRefiner, new e(z5, a6, b6));
        g0.o(i6, "create(...)");
        OverridingUtil.OverrideCompatibilityInfo.Result c6 = i6.E(a6, b6, null, !z7).c();
        OverridingUtil.OverrideCompatibilityInfo.Result result = OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
        return c6 == result && i6.E(b6, a6, null, z7 ^ true).c() == result;
    }

    public final boolean k(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar2, boolean z5, boolean z6) {
        return ((kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) && (kVar2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d)) ? j((kotlin.reflect.jvm.internal.impl.descriptors.d) kVar, (kotlin.reflect.jvm.internal.impl.descriptors.d) kVar2) : ((kVar instanceof j1) && (kVar2 instanceof j1)) ? o(this, (j1) kVar, (j1) kVar2, z5, null, 8, null) : ((kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.a) && (kVar2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.a)) ? f(this, (kotlin.reflect.jvm.internal.impl.descriptors.a) kVar, (kotlin.reflect.jvm.internal.impl.descriptors.a) kVar2, z5, z6, false, g.a.f47170a, 16, null) : ((kVar instanceof l0) && (kVar2 instanceof l0)) ? g0.g(((l0) kVar).d(), ((l0) kVar2).d()) : g0.g(kVar, kVar2);
    }

    @JvmOverloads
    public final boolean m(@NotNull j1 a6, @NotNull j1 b6, boolean z5) {
        g0.p(a6, "a");
        g0.p(b6, "b");
        return o(this, a6, b6, z5, null, 8, null);
    }

    @JvmOverloads
    public final boolean n(@NotNull j1 a6, @NotNull j1 b6, boolean z5, @NotNull Function2<? super kotlin.reflect.jvm.internal.impl.descriptors.k, ? super kotlin.reflect.jvm.internal.impl.descriptors.k, Boolean> equivalentCallables) {
        g0.p(a6, "a");
        g0.p(b6, "b");
        g0.p(equivalentCallables, "equivalentCallables");
        if (g0.g(a6, b6)) {
            return true;
        }
        return !g0.g(a6.b(), b6.b()) && q(a6, b6, equivalentCallables, z5) && a6.getIndex() == b6.getIndex();
    }

    private g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, kotlin.reflect.jvm.internal.impl.descriptors.k kVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar2) {
        if (g0.g(kVar, aVar) && g0.g(kVar2, aVar2)) {
            return true;
        }
        return false;
    }

    private final boolean j(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, kotlin.reflect.jvm.internal.impl.descriptors.d dVar2) {
        return g0.g(dVar.o(), dVar2.o());
    }

    private final boolean q(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar2, Function2<? super kotlin.reflect.jvm.internal.impl.descriptors.k, ? super kotlin.reflect.jvm.internal.impl.descriptors.k, Boolean> function2, boolean z5) {
        kotlin.reflect.jvm.internal.impl.descriptors.k b6 = kVar.b();
        kotlin.reflect.jvm.internal.impl.descriptors.k b7 = kVar2.b();
        if (!(b6 instanceof CallableMemberDescriptor) && !(b7 instanceof CallableMemberDescriptor)) {
            return l(this, b6, b7, z5, false, 8, null);
        }
        return function2.invoke(b6, b7).booleanValue();
    }
}
