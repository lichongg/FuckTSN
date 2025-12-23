package kotlin.reflect.jvm.internal.impl.util;

import java.util.List;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.util.g;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class b {
    @NotNull
    public abstract List<h> b();

    @NotNull
    public final g a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.y functionDescriptor) {
        g0.p(functionDescriptor, "functionDescriptor");
        for (h hVar : b()) {
            if (hVar.b(functionDescriptor)) {
                return hVar.a(functionDescriptor);
            }
        }
        return g.a.f47394b;
    }
}
