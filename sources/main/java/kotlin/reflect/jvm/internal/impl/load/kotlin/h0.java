package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h0 implements g0<s> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h0 f45915a = new h0();

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.g0
    @Nullable
    public String b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor) {
        kotlin.jvm.internal.g0.p(classDescriptor, "classDescriptor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.g0
    @Nullable
    public t0 c(t0 kotlinType) {
        kotlin.jvm.internal.g0.p(kotlinType, "kotlinType");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.g0
    @Nullable
    public String d(kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor) {
        kotlin.jvm.internal.g0.p(classDescriptor, "classDescriptor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.g0
    public void e(@NotNull t0 kotlinType, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d descriptor) {
        kotlin.jvm.internal.g0.p(kotlinType, "kotlinType");
        kotlin.jvm.internal.g0.p(descriptor, "descriptor");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.g0
    @NotNull
    public t0 f(@NotNull Collection<? extends t0> types) {
        kotlin.jvm.internal.g0.p(types, "types");
        throw new AssertionError("There should be no intersection type in existing descriptors, but found: " + kotlin.collections.f0.r3(types, null, null, null, 0, null, null, 63, null));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.g0
    @Nullable
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public s a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor) {
        kotlin.jvm.internal.g0.p(classDescriptor, "classDescriptor");
        return null;
    }

    private h0() {
    }
}
