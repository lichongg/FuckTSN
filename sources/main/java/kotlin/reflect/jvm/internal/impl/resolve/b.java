package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class b implements t {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f46651a = new b();

    @Override // kotlin.reflect.jvm.internal.impl.resolve.t
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.d a(@NotNull f0 moduleDescriptor) {
        g0.p(moduleDescriptor, "moduleDescriptor");
        return x.b(moduleDescriptor, kotlin.reflect.jvm.internal.impl.name.i.f46374a.j());
    }

    private b() {
    }
}
