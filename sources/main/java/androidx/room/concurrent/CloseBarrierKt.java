package androidx.room.concurrent;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class CloseBarrierKt {
    public static final void ifNotClosed(@NotNull CloseBarrier closeBarrier, @NotNull Function0<n1> action) {
        g0.p(closeBarrier, "<this>");
        g0.p(action, "action");
        if (closeBarrier.block$room_runtime_release()) {
            try {
                action.invoke();
            } finally {
                d0.d(1);
                closeBarrier.unblock$room_runtime_release();
                d0.c(1);
            }
        }
    }
}
