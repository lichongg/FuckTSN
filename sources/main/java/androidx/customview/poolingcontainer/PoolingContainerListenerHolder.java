package androidx.customview.poolingcontainer;

import java.util.ArrayList;
import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class PoolingContainerListenerHolder {

    @NotNull
    private final ArrayList<PoolingContainerListener> listeners = new ArrayList<>();

    public final void addListener(@NotNull PoolingContainerListener listener) {
        g0.p(listener, "listener");
        this.listeners.add(listener);
    }

    public final void onRelease() {
        for (int L = f0.L(this.listeners); -1 < L; L--) {
            this.listeners.get(L).onRelease();
        }
    }

    public final void removeListener(@NotNull PoolingContainerListener listener) {
        g0.p(listener, "listener");
        this.listeners.remove(listener);
    }
}
