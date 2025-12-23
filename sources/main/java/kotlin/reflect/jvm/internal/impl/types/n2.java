package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class n2 extends t0 {
    public n2() {
        super(null);
    }

    @NotNull
    protected abstract t0 M0();

    public boolean N0() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public List<c2> G0() {
        return M0().G0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public t1 H0() {
        return M0().H0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public w1 I0() {
        return M0().I0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    public boolean J0() {
        return M0().J0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public final m2 L0() {
        t0 M0 = M0();
        while (M0 instanceof n2) {
            M0 = ((n2) M0).M0();
        }
        kotlin.jvm.internal.g0.n(M0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
        return (m2) M0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.k r() {
        return M0().r();
    }

    @NotNull
    public String toString() {
        if (N0()) {
            return M0().toString();
        }
        return "<Not computed yet>";
    }
}
