package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.Collection;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.c2;
import kotlin.reflect.jvm.internal.impl.types.checker.g;
import kotlin.reflect.jvm.internal.impl.types.checker.n;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c implements b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final c2 f46657a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private n f46658b;

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    public boolean d() {
        return false;
    }

    @Nullable
    public Void e() {
        return null;
    }

    public c(@NotNull c2 projection) {
        g0.p(projection, "projection");
        this.f46657a = projection;
        getProjection().c();
        Variance variance = Variance.INVARIANT;
    }

    @Nullable
    public final n f() {
        return this.f46658b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public c a(@NotNull g kotlinTypeRefiner) {
        g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        c2 a6 = getProjection().a(kotlinTypeRefiner);
        g0.o(a6, "refine(...)");
        return new c(a6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b
    @NotNull
    public c2 getProjection() {
        return this.f46657a;
    }

    public final void h(@Nullable n nVar) {
        this.f46658b = nVar;
    }

    @NotNull
    public String toString() {
        return "CapturedTypeConstructor(" + getProjection() + ')';
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    public /* bridge */ /* synthetic */ f c() {
        return (f) e();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    public List<j1> getParameters() {
        return f0.J();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    public Collection<t0> i() {
        t0 J;
        if (getProjection().c() == Variance.OUT_VARIANCE) {
            J = getProjection().getType();
        } else {
            J = p().J();
        }
        g0.m(J);
        return f0.l(J);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    public j p() {
        j p5 = getProjection().getType().I0().p();
        g0.o(p5, "getBuiltIns(...)");
        return p5;
    }
}
