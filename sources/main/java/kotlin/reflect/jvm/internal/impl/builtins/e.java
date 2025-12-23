package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Set;
import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e {
    public static final boolean a(@NotNull d dVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor) {
        g0.p(dVar, "<this>");
        g0.p(classDescriptor, "classDescriptor");
        if (!kotlin.reflect.jvm.internal.impl.resolve.i.x(classDescriptor)) {
            return false;
        }
        Set<kotlin.reflect.jvm.internal.impl.name.b> b6 = dVar.b();
        kotlin.reflect.jvm.internal.impl.name.b n6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.n(classDescriptor);
        return f0.a2(b6, n6 != null ? n6.e() : null);
    }
}
