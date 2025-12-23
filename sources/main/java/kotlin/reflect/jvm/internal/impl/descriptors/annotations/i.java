package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i {
    @NotNull
    public static final g a(@NotNull g first, @NotNull g second) {
        g0.p(first, "first");
        g0.p(second, "second");
        return first.isEmpty() ? second : second.isEmpty() ? first : new n(first, second);
    }
}
