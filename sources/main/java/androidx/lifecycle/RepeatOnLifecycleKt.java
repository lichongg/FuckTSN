package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.s0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class RepeatOnLifecycleKt {
    @Nullable
    public static final Object repeatOnLifecycle(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State state, @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        if (state == Lifecycle.State.INITIALIZED) {
            throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.");
        }
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            return n1.f44123a;
        }
        Object g6 = s0.g(new RepeatOnLifecycleKt$repeatOnLifecycle$3(lifecycle, state, function2, null), eVar);
        return g6 == kotlin.coroutines.intrinsics.a.l() ? g6 : n1.f44123a;
    }

    @Nullable
    public static final Object repeatOnLifecycle(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.State state, @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object repeatOnLifecycle = repeatOnLifecycle(lifecycleOwner.getLifecycle(), state, function2, eVar);
        return repeatOnLifecycle == kotlin.coroutines.intrinsics.a.l() ? repeatOnLifecycle : n1.f44123a;
    }
}
