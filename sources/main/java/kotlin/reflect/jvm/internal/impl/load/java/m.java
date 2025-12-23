package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.resolve.deprecation.DeprecationLevelValue;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m extends kotlin.reflect.jvm.internal.impl.resolve.deprecation.b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.k f45724a;

    public m(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k target) {
        kotlin.jvm.internal.g0.p(target, "target");
        this.f45724a = target;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.deprecation.a
    @NotNull
    public DeprecationLevelValue b() {
        return DeprecationLevelValue.ERROR;
    }
}
