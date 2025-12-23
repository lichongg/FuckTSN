package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class CameraXExecutors {
    public static boolean isSequentialExecutor(@NonNull Executor executor) {
        return executor instanceof SequentialExecutor;
    }

    @NonNull
    public static ScheduledExecutorService newHandlerExecutor(@NonNull Handler handler) {
        return new HandlerScheduledExecutorService(handler);
    }

    @NonNull
    public static Executor newSequentialExecutor(@NonNull Executor executor) {
        return new SequentialExecutor(executor);
    }

    private CameraXExecutors() {
    }

    @NonNull
    public static Executor audioExecutor() {
        return AudioExecutor.getInstance();
    }

    @NonNull
    public static Executor directExecutor() {
        return DirectExecutor.getInstance();
    }

    @NonNull
    public static Executor highPriorityExecutor() {
        return HighPriorityExecutor.getInstance();
    }

    @NonNull
    public static Executor ioExecutor() {
        return IoExecutor.getInstance();
    }

    @NonNull
    public static ScheduledExecutorService mainThreadExecutor() {
        return MainThreadExecutor.getInstance();
    }

    @NonNull
    public static ScheduledExecutorService myLooperExecutor() {
        return HandlerScheduledExecutorService.currentThreadExecutor();
    }
}
