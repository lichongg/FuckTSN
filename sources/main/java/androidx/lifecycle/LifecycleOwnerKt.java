package androidx.lifecycle;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class LifecycleOwnerKt {
    @NotNull
    public static final LifecycleCoroutineScope getLifecycleScope(@NotNull LifecycleOwner lifecycleOwner) {
        g0.p(lifecycleOwner, "<this>");
        return LifecycleKt.getCoroutineScope(lifecycleOwner.getLifecycle());
    }
}
