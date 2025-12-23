package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class z0 extends n2 {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.n f47377b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Function0<t0> f47378c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i<t0> f47379d;

    /* JADX WARN: Multi-variable type inference failed */
    public z0(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull Function0<? extends t0> computation) {
        kotlin.jvm.internal.g0.p(storageManager, "storageManager");
        kotlin.jvm.internal.g0.p(computation, "computation");
        this.f47377b = storageManager;
        this.f47378c = computation;
        this.f47379d = storageManager.e(computation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t0 Q0(kotlin.reflect.jvm.internal.impl.types.checker.g gVar, z0 z0Var) {
        return gVar.a(z0Var.f47378c.invoke());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.n2
    @NotNull
    protected t0 M0() {
        return this.f47379d.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.n2
    public boolean N0() {
        return this.f47379d.e();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    /* renamed from: P0, reason: merged with bridge method [inline-methods] */
    public z0 S0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new z0(this.f47377b, new y0(kotlinTypeRefiner, this));
    }
}
