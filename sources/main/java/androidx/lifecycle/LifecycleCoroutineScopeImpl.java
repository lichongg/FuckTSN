package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.g0;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.j2;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {

    @NotNull
    private final kotlin.coroutines.i coroutineContext;

    @NotNull
    private final Lifecycle lifecycle;

    public LifecycleCoroutineScopeImpl(@NotNull Lifecycle lifecycle, @NotNull kotlin.coroutines.i coroutineContext) {
        g0.p(lifecycle, "lifecycle");
        g0.p(coroutineContext, "coroutineContext");
        this.lifecycle = lifecycle;
        this.coroutineContext = coroutineContext;
        if (getLifecycle$lifecycle_common().getCurrentState() == Lifecycle.State.DESTROYED) {
            j2.i(getCoroutineContext(), null, 1, null);
        }
    }

    @Override // kotlinx.coroutines.r0
    @NotNull
    public kotlin.coroutines.i getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope
    @NotNull
    public Lifecycle getLifecycle$lifecycle_common() {
        return this.lifecycle;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        g0.p(source, "source");
        g0.p(event, "event");
        if (getLifecycle$lifecycle_common().getCurrentState().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            getLifecycle$lifecycle_common().removeObserver(this);
            j2.i(getCoroutineContext(), null, 1, null);
        }
    }

    public final void register() {
        kotlinx.coroutines.k.f(this, g1.e().v(), null, new LifecycleCoroutineScopeImpl$register$1(this, null), 2, null);
    }
}
