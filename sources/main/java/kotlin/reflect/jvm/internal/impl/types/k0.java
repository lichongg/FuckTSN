package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class k0 extends m2 implements e4.e {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final e1 f47284b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final e1 f47285c;

    @NotNull
    public abstract e1 P0();

    @NotNull
    public abstract String S0(@NotNull kotlin.reflect.jvm.internal.impl.renderer.m mVar, @NotNull kotlin.reflect.jvm.internal.impl.renderer.u uVar);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(@NotNull e1 lowerBound, @NotNull e1 upperBound) {
        super(null);
        kotlin.jvm.internal.g0.p(lowerBound, "lowerBound");
        kotlin.jvm.internal.g0.p(upperBound, "upperBound");
        this.f47284b = lowerBound;
        this.f47285c = upperBound;
    }

    @NotNull
    public final e1 Q0() {
        return this.f47284b;
    }

    @NotNull
    public final e1 R0() {
        return this.f47285c;
    }

    @NotNull
    public String toString() {
        return kotlin.reflect.jvm.internal.impl.renderer.m.f46584k.T(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public List<c2> G0() {
        return P0().G0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public t1 H0() {
        return P0().H0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public w1 I0() {
        return P0().I0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    public boolean J0() {
        return P0().J0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.k r() {
        return P0().r();
    }
}
