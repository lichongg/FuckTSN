package androidx.lifecycle;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.g0;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.m0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class PausingDispatcher extends m0 {

    @JvmField
    @NotNull
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    @Override // kotlinx.coroutines.m0
    public void dispatch(@NotNull kotlin.coroutines.i context, @NotNull Runnable block) {
        g0.p(context, "context");
        g0.p(block, "block");
        this.dispatchQueue.dispatchAndEnqueue(context, block);
    }

    @Override // kotlinx.coroutines.m0
    public boolean isDispatchNeeded(@NotNull kotlin.coroutines.i context) {
        g0.p(context, "context");
        if (g1.e().t().isDispatchNeeded(context)) {
            return true;
        }
        return !this.dispatchQueue.canRun();
    }
}
