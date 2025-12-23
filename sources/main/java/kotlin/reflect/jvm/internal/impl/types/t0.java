package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class t0 implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.a, e4.g {

    /* renamed from: a, reason: collision with root package name */
    private int f47331a;

    public /* synthetic */ t0(kotlin.jvm.internal.v vVar) {
        this();
    }

    @NotNull
    public abstract List<c2> G0();

    @NotNull
    public abstract t1 H0();

    @NotNull
    public abstract w1 I0();

    public abstract boolean J0();

    @NotNull
    public abstract t0 K0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar);

    @NotNull
    public abstract m2 L0();

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t0)) {
            return false;
        }
        t0 t0Var = (t0) obj;
        return J0() == t0Var.J0() && kotlin.reflect.jvm.internal.impl.types.checker.v.f47197a.a(L0(), t0Var.L0());
    }

    @NotNull
    public abstract kotlin.reflect.jvm.internal.impl.resolve.scopes.k r();

    private t0() {
    }

    public final int hashCode() {
        int i6 = this.f47331a;
        if (i6 != 0) {
            return i6;
        }
        int F0 = F0();
        this.f47331a = F0;
        return F0;
    }

    private final int F0() {
        if (x0.a(this)) {
            return super.hashCode();
        }
        return (((I0().hashCode() * 31) + G0().hashCode()) * 31) + (J0() ? 1 : 0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g getAnnotations() {
        return u.a(H0());
    }
}
