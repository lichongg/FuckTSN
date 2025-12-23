package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class y implements s1 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final y f47369a = new y();

    @Override // kotlin.reflect.jvm.internal.impl.types.s1
    @NotNull
    public t1 a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, @Nullable w1 w1Var, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        kotlin.jvm.internal.g0.p(annotations, "annotations");
        return annotations.isEmpty() ? t1.f47332b.k() : t1.f47332b.j(kotlin.collections.f0.l(new t(annotations)));
    }

    private y() {
    }
}
