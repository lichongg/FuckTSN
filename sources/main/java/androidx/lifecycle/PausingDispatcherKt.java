package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Deprecated;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class PausingDispatcherKt {
    @Deprecated(message = "whenCreated has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withCreated for non-suspending work that needs to run only once when the Lifecycle changes.")
    @Nullable
    public static final <T> Object whenCreated(@NotNull LifecycleOwner lifecycleOwner, @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super T> eVar) {
        return whenCreated(lifecycleOwner.getLifecycle(), function2, eVar);
    }

    @Deprecated(message = "whenResumed has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withResumed for non-suspending work that needs to run only once when the Lifecycle changes.")
    @Nullable
    public static final <T> Object whenResumed(@NotNull LifecycleOwner lifecycleOwner, @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super T> eVar) {
        return whenResumed(lifecycleOwner.getLifecycle(), function2, eVar);
    }

    @Deprecated(message = "whenStarted has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withStarted for non-suspending work that needs to run only once when the Lifecycle changes.")
    @Nullable
    public static final <T> Object whenStarted(@NotNull LifecycleOwner lifecycleOwner, @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super T> eVar) {
        return whenStarted(lifecycleOwner.getLifecycle(), function2, eVar);
    }

    @Deprecated(message = "whenCreated has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withCreated for non-suspending work that needs to run only once when the Lifecycle changes.")
    @Nullable
    public static final <T> Object whenCreated(@NotNull Lifecycle lifecycle, @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super T> eVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.CREATED, function2, eVar);
    }

    @Deprecated(message = "whenResumed has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withResumed for non-suspending work that needs to run only once when the Lifecycle changes.")
    @Nullable
    public static final <T> Object whenResumed(@NotNull Lifecycle lifecycle, @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super T> eVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.RESUMED, function2, eVar);
    }

    @Deprecated(message = "whenStarted has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withStarted for non-suspending work that needs to run only once when the Lifecycle changes.")
    @Nullable
    public static final <T> Object whenStarted(@NotNull Lifecycle lifecycle, @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super T> eVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.STARTED, function2, eVar);
    }

    @Deprecated(message = "whenStateAtLeast has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withStateAtLeast for non-suspending work that needs to run only once when the Lifecycle changes.")
    @Nullable
    public static final <T> Object whenStateAtLeast(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State state, @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super T> eVar) {
        return kotlinx.coroutines.i.h(g1.e().v(), new PausingDispatcherKt$whenStateAtLeast$2(lifecycle, state, function2, null), eVar);
    }
}
