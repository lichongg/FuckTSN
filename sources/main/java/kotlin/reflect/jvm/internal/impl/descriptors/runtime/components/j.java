package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.List;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.v;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j implements v {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final j f44973b = new j();

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.v
    public void a(@NotNull CallableMemberDescriptor descriptor) {
        g0.p(descriptor, "descriptor");
        throw new IllegalStateException("Cannot infer visibility for " + descriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.v
    public void b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d descriptor, @NotNull List<String> unresolvedSuperClasses) {
        g0.p(descriptor, "descriptor");
        g0.p(unresolvedSuperClasses, "unresolvedSuperClasses");
        throw new IllegalStateException("Incomplete hierarchy for class " + descriptor.getName() + ", unresolved classes " + unresolvedSuperClasses);
    }

    private j() {
    }
}
