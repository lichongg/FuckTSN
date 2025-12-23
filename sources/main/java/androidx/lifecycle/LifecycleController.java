package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@MainThread
@SourceDebugExtension({"SMAP\nLifecycleController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LifecycleController.kt\nandroidx/lifecycle/LifecycleController\n*L\n1#1,70:1\n57#1,3:71\n57#1,3:74\n*S KotlinDebug\n*F\n+ 1 LifecycleController.kt\nandroidx/lifecycle/LifecycleController\n*L\n49#1:71,3\n36#1:74,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class LifecycleController {

    @NotNull
    private final DispatchQueue dispatchQueue;

    @NotNull
    private final Lifecycle lifecycle;

    @NotNull
    private final Lifecycle.State minState;

    @NotNull
    private final LifecycleEventObserver observer;

    private final void handleDestroy(e2 e2Var) {
        e2.a.b(e2Var, null, 1, null);
        finish();
    }

    public LifecycleController(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State minState, @NotNull DispatchQueue dispatchQueue, @NotNull final e2 parentJob) {
        g0.p(lifecycle, "lifecycle");
        g0.p(minState, "minState");
        g0.p(dispatchQueue, "dispatchQueue");
        g0.p(parentJob, "parentJob");
        this.lifecycle = lifecycle;
        this.minState = minState;
        this.dispatchQueue = dispatchQueue;
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.lifecycle.g
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                LifecycleController.observer$lambda$0(LifecycleController.this, parentJob, lifecycleOwner, event);
            }
        };
        this.observer = lifecycleEventObserver;
        if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
            lifecycle.addObserver(lifecycleEventObserver);
        } else {
            e2.a.b(parentJob, null, 1, null);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observer$lambda$0(LifecycleController this$0, e2 parentJob, LifecycleOwner source, Lifecycle.Event event) {
        g0.p(this$0, "this$0");
        g0.p(parentJob, "$parentJob");
        g0.p(source, "source");
        g0.p(event, "<anonymous parameter 1>");
        if (source.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            e2.a.b(parentJob, null, 1, null);
            this$0.finish();
        } else if (source.getLifecycle().getCurrentState().compareTo(this$0.minState) < 0) {
            this$0.dispatchQueue.pause();
        } else {
            this$0.dispatchQueue.resume();
        }
    }

    @MainThread
    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
