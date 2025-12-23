package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RequiresApi;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
final class MainThreadExecutor {
    private static volatile ScheduledExecutorService sInstance;

    static ScheduledExecutorService getInstance() {
        if (sInstance != null) {
            return sInstance;
        }
        synchronized (MainThreadExecutor.class) {
            try {
                if (sInstance == null) {
                    sInstance = new HandlerScheduledExecutorService(new Handler(Looper.getMainLooper()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sInstance;
    }

    private MainThreadExecutor() {
    }
}
