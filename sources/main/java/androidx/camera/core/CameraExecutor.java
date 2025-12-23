package androidx.camera.core;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CameraFactory;
import androidx.core.util.Preconditions;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
class CameraExecutor implements Executor {
    private static final int DEFAULT_CORE_THREADS = 1;
    private static final int DEFAULT_MAX_THREADS = 1;
    private static final String TAG = "CameraExecutor";
    private static final ThreadFactory THREAD_FACTORY = new ThreadFactory() { // from class: androidx.camera.core.CameraExecutor.1
        private static final String THREAD_NAME_STEM = "CameraX-core_camera_%d";
        private final AtomicInteger mThreadId = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format(Locale.US, THREAD_NAME_STEM, Integer.valueOf(this.mThreadId.getAndIncrement())));
            return thread;
        }
    };
    private final Object mExecutorLock = new Object();

    @NonNull
    @GuardedBy("mExecutorLock")
    private ThreadPoolExecutor mThreadPoolExecutor = createExecutor();

    private static ThreadPoolExecutor createExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), THREAD_FACTORY);
        threadPoolExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler() { // from class: androidx.camera.core.d
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                Logger.e(CameraExecutor.TAG, "A rejected execution occurred in CameraExecutor!");
            }
        });
        return threadPoolExecutor;
    }

    void deinit() {
        synchronized (this.mExecutorLock) {
            try {
                if (!this.mThreadPoolExecutor.isShutdown()) {
                    this.mThreadPoolExecutor.shutdown();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    CameraExecutor() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        synchronized (this.mExecutorLock) {
            this.mThreadPoolExecutor.execute(runnable);
        }
    }

    void init(@NonNull CameraFactory cameraFactory) {
        ThreadPoolExecutor threadPoolExecutor;
        Preconditions.checkNotNull(cameraFactory);
        synchronized (this.mExecutorLock) {
            try {
                if (this.mThreadPoolExecutor.isShutdown()) {
                    this.mThreadPoolExecutor = createExecutor();
                }
                threadPoolExecutor = this.mThreadPoolExecutor;
            } catch (Throwable th) {
                throw th;
            }
        }
        int max = Math.max(1, cameraFactory.getAvailableCameraIds().size());
        threadPoolExecutor.setMaximumPoolSize(max);
        threadPoolExecutor.setCorePoolSize(max);
    }
}
