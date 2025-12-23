package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class FlowExtKt {
    @NotNull
    public static final <T> kotlinx.coroutines.flow.i<T> flowWithLifecycle(@NotNull kotlinx.coroutines.flow.i<? extends T> iVar, @NotNull Lifecycle lifecycle, @NotNull Lifecycle.State minActiveState) {
        g0.p(iVar, "<this>");
        g0.p(lifecycle, "lifecycle");
        g0.p(minActiveState, "minActiveState");
        return kotlinx.coroutines.flow.k.s(new FlowExtKt$flowWithLifecycle$1(lifecycle, minActiveState, iVar, null));
    }

    public static /* synthetic */ kotlinx.coroutines.flow.i flowWithLifecycle$default(kotlinx.coroutines.flow.i iVar, Lifecycle lifecycle, Lifecycle.State state, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            state = Lifecycle.State.STARTED;
        }
        return flowWithLifecycle(iVar, lifecycle, state);
    }
}
