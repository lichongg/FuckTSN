package androidx.camera.core.impl.utils.executor;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
final class IoExecutor implements Executor {
    private static volatile Executor sExecutor;
    private final ExecutorService mIoService = Executors.newFixedThreadPool(2, new ThreadFactory() { // from class: androidx.camera.core.impl.utils.executor.IoExecutor.1
        private static final String THREAD_NAME_STEM = "CameraX-camerax_io_%d";
        private final AtomicInteger mThreadId = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format(Locale.US, THREAD_NAME_STEM, Integer.valueOf(this.mThreadId.getAndIncrement())));
            return thread;
        }
    });

    static Executor getInstance() {
        if (sExecutor != null) {
            return sExecutor;
        }
        synchronized (IoExecutor.class) {
            try {
                if (sExecutor == null) {
                    sExecutor = new IoExecutor();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sExecutor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.mIoService.execute(runnable);
    }

    IoExecutor() {
    }
}
