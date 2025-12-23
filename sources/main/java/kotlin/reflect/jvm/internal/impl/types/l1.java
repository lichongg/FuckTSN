package kotlin.reflect.jvm.internal.impl.types;

import kotlin.LazyThreadSafetyMode;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class l1 extends d2 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.j1 f47291a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.s f47292b;

    @Override // kotlin.reflect.jvm.internal.impl.types.c2
    public boolean b() {
        return true;
    }

    public l1(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.j1 typeParameter) {
        kotlin.jvm.internal.g0.p(typeParameter, "typeParameter");
        this.f47291a = typeParameter;
        this.f47292b = kotlin.t.b(LazyThreadSafetyMode.PUBLICATION, new k1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t0 d(l1 l1Var) {
        return m1.b(l1Var.f47291a);
    }

    private final t0 f() {
        return (t0) this.f47292b.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.c2
    @NotNull
    public c2 a(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.c2
    @NotNull
    public Variance c() {
        return Variance.OUT_VARIANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.c2
    @NotNull
    public t0 getType() {
        return f();
    }
}
