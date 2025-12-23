package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final j1 f47343a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final t0 f47344b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final t0 f47345c;

    public e(@NotNull j1 typeParameter, @NotNull t0 inProjection, @NotNull t0 outProjection) {
        g0.p(typeParameter, "typeParameter");
        g0.p(inProjection, "inProjection");
        g0.p(outProjection, "outProjection");
        this.f47343a = typeParameter;
        this.f47344b = inProjection;
        this.f47345c = outProjection;
    }

    @NotNull
    public final t0 a() {
        return this.f47344b;
    }

    @NotNull
    public final t0 b() {
        return this.f47345c;
    }

    @NotNull
    public final j1 c() {
        return this.f47343a;
    }

    public final boolean d() {
        return kotlin.reflect.jvm.internal.impl.types.checker.e.f47168a.d(this.f47344b, this.f47345c);
    }
}
