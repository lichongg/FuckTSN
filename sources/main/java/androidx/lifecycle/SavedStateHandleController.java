package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSavedStateHandleController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateHandleController.kt\nandroidx/lifecycle/SavedStateHandleController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,41:1\n1#2:42\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class SavedStateHandleController implements LifecycleEventObserver {

    @NotNull
    private final SavedStateHandle handle;
    private boolean isAttached;

    @NotNull
    private final String key;

    public SavedStateHandleController(@NotNull String key, @NotNull SavedStateHandle handle) {
        g0.p(key, "key");
        g0.p(handle, "handle");
        this.key = key;
        this.handle = handle;
    }

    public final void attachToLifecycle(@NotNull SavedStateRegistry registry, @NotNull Lifecycle lifecycle) {
        g0.p(registry, "registry");
        g0.p(lifecycle, "lifecycle");
        if (this.isAttached) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.isAttached = true;
        lifecycle.addObserver(this);
        registry.registerSavedStateProvider(this.key, this.handle.savedStateProvider());
    }

    @NotNull
    public final SavedStateHandle getHandle() {
        return this.handle;
    }

    public final boolean isAttached() {
        return this.isAttached;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        g0.p(source, "source");
        g0.p(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.isAttached = false;
            source.getLifecycle().removeObserver(this);
        }
    }
}
