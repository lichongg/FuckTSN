package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class a0 extends f2 {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final f2 f47144c;

    public a0(@NotNull f2 substitution) {
        kotlin.jvm.internal.g0.p(substitution, "substitution");
        this.f47144c = substitution;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.f2
    public boolean a() {
        return this.f47144c.a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.f2
    public boolean b() {
        return this.f47144c.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.f2
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations) {
        kotlin.jvm.internal.g0.p(annotations, "annotations");
        return this.f47144c.d(annotations);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.f2
    @Nullable
    public c2 e(@NotNull t0 key) {
        kotlin.jvm.internal.g0.p(key, "key");
        return this.f47144c.e(key);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.f2
    public boolean f() {
        return this.f47144c.f();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.f2
    @NotNull
    public t0 g(@NotNull t0 topLevelType, @NotNull Variance position) {
        kotlin.jvm.internal.g0.p(topLevelType, "topLevelType");
        kotlin.jvm.internal.g0.p(position, "position");
        return this.f47144c.g(topLevelType, position);
    }
}
