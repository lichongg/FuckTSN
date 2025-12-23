package androidx.camera.core.impl.utils.executor;

import androidx.annotation.RequiresApi;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
final class DirectExecutor implements Executor {
    private static volatile DirectExecutor sDirectExecutor;

    static Executor getInstance() {
        if (sDirectExecutor != null) {
            return sDirectExecutor;
        }
        synchronized (DirectExecutor.class) {
            try {
                if (sDirectExecutor == null) {
                    sDirectExecutor = new DirectExecutor();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sDirectExecutor;
    }

    DirectExecutor() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
