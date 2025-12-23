package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.types.j2;
import kotlin.reflect.jvm.internal.impl.types.l2;
import kotlin.reflect.jvm.internal.impl.types.m2;
import kotlin.reflect.jvm.internal.impl.types.t1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i extends kotlin.reflect.jvm.internal.impl.types.b0 implements kotlin.reflect.jvm.internal.impl.types.b1 {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.types.e1 f45788b;

    private final kotlin.reflect.jvm.internal.impl.types.e1 U0(kotlin.reflect.jvm.internal.impl.types.e1 e1Var) {
        kotlin.reflect.jvm.internal.impl.types.e1 M0 = e1Var.M0(false);
        return !kotlin.reflect.jvm.internal.impl.types.typeUtil.e.z(e1Var) ? M0 : new i(M0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.x
    public boolean E0() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.b0, kotlin.reflect.jvm.internal.impl.types.t0
    public boolean J0() {
        return false;
    }

    public i(@NotNull kotlin.reflect.jvm.internal.impl.types.e1 delegate) {
        kotlin.jvm.internal.g0.p(delegate, "delegate");
        this.f45788b = delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: P0 */
    public kotlin.reflect.jvm.internal.impl.types.e1 M0(boolean z5) {
        return z5 ? R0().M0(true) : this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.b0
    @NotNull
    protected kotlin.reflect.jvm.internal.impl.types.e1 R0() {
        return this.f45788b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e1
    @NotNull
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public i O0(@NotNull t1 newAttributes) {
        kotlin.jvm.internal.g0.p(newAttributes, "newAttributes");
        return new i(R0().O0(newAttributes));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.b0
    @NotNull
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public i T0(@NotNull kotlin.reflect.jvm.internal.impl.types.e1 delegate) {
        kotlin.jvm.internal.g0.p(delegate, "delegate");
        return new i(delegate);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.x
    @NotNull
    public kotlin.reflect.jvm.internal.impl.types.t0 p0(@NotNull kotlin.reflect.jvm.internal.impl.types.t0 replacement) {
        kotlin.jvm.internal.g0.p(replacement, "replacement");
        m2 L0 = replacement.L0();
        if (!kotlin.reflect.jvm.internal.impl.types.typeUtil.e.z(L0) && !j2.l(L0)) {
            return L0;
        }
        if (L0 instanceof kotlin.reflect.jvm.internal.impl.types.e1) {
            return U0((kotlin.reflect.jvm.internal.impl.types.e1) L0);
        }
        if (!(L0 instanceof kotlin.reflect.jvm.internal.impl.types.k0)) {
            throw new NoWhenBranchMatchedException();
        }
        kotlin.reflect.jvm.internal.impl.types.k0 k0Var = (kotlin.reflect.jvm.internal.impl.types.k0) L0;
        return l2.d(kotlin.reflect.jvm.internal.impl.types.w0.e(U0(k0Var.Q0()), U0(k0Var.R0())), l2.a(L0));
    }
}
