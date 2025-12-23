package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nflexibleTypes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 flexibleTypes.kt\norg/jetbrains/kotlin/types/FlexibleTypeImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,174:1\n1#2:175\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class l0 extends k0 implements x {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f47288e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @JvmField
    public static boolean f47289f;

    /* renamed from: d, reason: collision with root package name */
    private boolean f47290d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(@NotNull e1 lowerBound, @NotNull e1 upperBound) {
        super(lowerBound, upperBound);
        kotlin.jvm.internal.g0.p(lowerBound, "lowerBound");
        kotlin.jvm.internal.g0.p(upperBound, "upperBound");
    }

    private final void U0() {
        if (!f47289f || this.f47290d) {
            return;
        }
        this.f47290d = true;
        n0.b(Q0());
        n0.b(R0());
        kotlin.jvm.internal.g0.g(Q0(), R0());
        kotlin.reflect.jvm.internal.impl.types.checker.e.f47168a.d(Q0(), R0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    public m2 O0(@NotNull t1 newAttributes) {
        kotlin.jvm.internal.g0.p(newAttributes, "newAttributes");
        return w0.e(Q0().O0(newAttributes), R0().O0(newAttributes));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k0
    @NotNull
    public String S0(@NotNull kotlin.reflect.jvm.internal.impl.renderer.m renderer, @NotNull kotlin.reflect.jvm.internal.impl.renderer.u options) {
        kotlin.jvm.internal.g0.p(renderer, "renderer");
        kotlin.jvm.internal.g0.p(options, "options");
        if (!options.d()) {
            return renderer.Q(renderer.T(Q0()), renderer.T(R0()), kotlin.reflect.jvm.internal.impl.types.typeUtil.e.o(this));
        }
        return '(' + renderer.T(Q0()) + ".." + renderer.T(R0()) + ')';
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public k0 S0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        t0 a6 = kotlinTypeRefiner.a(Q0());
        kotlin.jvm.internal.g0.n(a6, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        t0 a7 = kotlinTypeRefiner.a(R0());
        kotlin.jvm.internal.g0.n(a7, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new l0((e1) a6, (e1) a7);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.x
    @NotNull
    public t0 p0(@NotNull t0 replacement) {
        m2 e6;
        kotlin.jvm.internal.g0.p(replacement, "replacement");
        m2 L0 = replacement.L0();
        if (L0 instanceof k0) {
            e6 = L0;
        } else {
            if (!(L0 instanceof e1)) {
                throw new NoWhenBranchMatchedException();
            }
            e1 e1Var = (e1) L0;
            e6 = w0.e(e1Var, e1Var.M0(true));
        }
        return l2.b(e6, L0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k0
    @NotNull
    public String toString() {
        return '(' + Q0() + ".." + R0() + ')';
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.x
    public boolean E0() {
        if ((Q0().I0().c() instanceof kotlin.reflect.jvm.internal.impl.descriptors.j1) && kotlin.jvm.internal.g0.g(Q0().I0(), R0().I0())) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    public m2 M0(boolean z5) {
        return w0.e(Q0().M0(z5), R0().M0(z5));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k0
    @NotNull
    public e1 P0() {
        U0();
        return Q0();
    }
}
