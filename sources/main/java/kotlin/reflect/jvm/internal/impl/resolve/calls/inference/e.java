package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.storage.n;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.a0;
import kotlin.reflect.jvm.internal.impl.types.c2;
import kotlin.reflect.jvm.internal.impl.types.e2;
import kotlin.reflect.jvm.internal.impl.types.f2;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.z0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCapturedTypeConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CapturedTypeConstructor.kt\norg/jetbrains/kotlin/resolve/calls/inference/CapturedTypeConstructorKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,153:1\n1563#2:154\n1634#2,3:155\n37#3:158\n36#3,3:159\n*S KotlinDebug\n*F\n+ 1 CapturedTypeConstructor.kt\norg/jetbrains/kotlin/resolve/calls/inference/CapturedTypeConstructorKt\n*L\n125#1:154\n125#1:155,3\n127#1:158\n127#1:159,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends a0 {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f46660d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(f2 f2Var, boolean z5) {
            super(f2Var);
            this.f46660d = z5;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.a0, kotlin.reflect.jvm.internal.impl.types.f2
        public boolean b() {
            return this.f46660d;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.a0, kotlin.reflect.jvm.internal.impl.types.f2
        public c2 e(t0 key) {
            g0.p(key, "key");
            c2 e6 = super.e(key);
            if (e6 == null) {
                return null;
            }
            f c6 = key.I0().c();
            return e.c(e6, c6 instanceof j1 ? (j1) c6 : null);
        }
    }

    public static /* synthetic */ f2 h(f2 f2Var, boolean z5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z5 = true;
        }
        return g(f2Var, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c2 c(c2 c2Var, j1 j1Var) {
        if (j1Var == null || c2Var.c() == Variance.INVARIANT) {
            return c2Var;
        }
        if (j1Var.l() != c2Var.c()) {
            return new e2(e(c2Var));
        }
        if (!c2Var.b()) {
            return new e2(c2Var.getType());
        }
        n NO_LOCKS = kotlin.reflect.jvm.internal.impl.storage.f.f47092e;
        g0.o(NO_LOCKS, "NO_LOCKS");
        return new e2(new z0(NO_LOCKS, new d(c2Var)));
    }

    @NotNull
    public static final t0 e(@NotNull c2 typeProjection) {
        g0.p(typeProjection, "typeProjection");
        return new kotlin.reflect.jvm.internal.impl.resolve.calls.inference.a(typeProjection, null, false, null, 14, null);
    }

    public static final boolean f(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        return t0Var.I0() instanceof b;
    }

    @NotNull
    public static final f2 g(@NotNull f2 f2Var, boolean z5) {
        g0.p(f2Var, "<this>");
        if (!(f2Var instanceof o0)) {
            return new a(f2Var, z5);
        }
        o0 o0Var = (o0) f2Var;
        j1[] j6 = o0Var.j();
        List<Pair> WA = kotlin.collections.n.WA(o0Var.i(), o0Var.j());
        ArrayList arrayList = new ArrayList(f0.d0(WA, 10));
        for (Pair pair : WA) {
            arrayList.add(c((c2) pair.getFirst(), (j1) pair.getSecond()));
        }
        return new o0(j6, (c2[]) arrayList.toArray(new c2[0]), z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t0 d(c2 c2Var) {
        t0 type = c2Var.getType();
        g0.o(type, "getType(...)");
        return type;
    }
}
