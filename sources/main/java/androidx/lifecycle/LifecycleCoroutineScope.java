package androidx.lifecycle;

import kotlin.Deprecated;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class LifecycleCoroutineScope implements r0 {
    @NotNull
    public abstract Lifecycle getLifecycle$lifecycle_common();

    @Deprecated(message = "launchWhenCreated is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.CREATED.")
    @NotNull
    public final e2 launchWhenCreated(@NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super n1>, ? extends Object> block) {
        e2 f6;
        g0.p(block, "block");
        f6 = kotlinx.coroutines.k.f(this, null, null, new LifecycleCoroutineScope$launchWhenCreated$1(this, block, null), 3, null);
        return f6;
    }

    @Deprecated(message = "launchWhenResumed is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.RESUMED.")
    @NotNull
    public final e2 launchWhenResumed(@NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super n1>, ? extends Object> block) {
        e2 f6;
        g0.p(block, "block");
        f6 = kotlinx.coroutines.k.f(this, null, null, new LifecycleCoroutineScope$launchWhenResumed$1(this, block, null), 3, null);
        return f6;
    }

    @Deprecated(message = "launchWhenStarted is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.STARTED.")
    @NotNull
    public final e2 launchWhenStarted(@NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super n1>, ? extends Object> block) {
        e2 f6;
        g0.p(block, "block");
        f6 = kotlinx.coroutines.k.f(this, null, null, new LifecycleCoroutineScope$launchWhenStarted$1(this, block, null), 3, null);
        return f6;
    }
}
