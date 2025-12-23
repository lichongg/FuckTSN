package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class WorkTimer {
    private static final String TAG = Logger.tagWithPrefix("WorkTimer");
    private final ThreadFactory mBackgroundThreadFactory;
    private final ScheduledExecutorService mExecutorService;
    final Map<String, TimeLimitExceededListener> mListeners;
    final Object mLock;
    final Map<String, WorkTimerRunnable> mTimerMap;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface TimeLimitExceededListener {
        void onTimeLimitExceeded(@NonNull String workSpecId);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class WorkTimerRunnable implements Runnable {
        static final String TAG = "WrkTimerRunnable";
        private final String mWorkSpecId;
        private final WorkTimer mWorkTimer;

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.mWorkTimer.mLock) {
                try {
                    if (this.mWorkTimer.mTimerMap.remove(this.mWorkSpecId) != null) {
                        TimeLimitExceededListener remove = this.mWorkTimer.mListeners.remove(this.mWorkSpecId);
                        if (remove != null) {
                            remove.onTimeLimitExceeded(this.mWorkSpecId);
                        }
                    } else {
                        Logger.get().debug(TAG, String.format("Timer with %s is already marked as complete.", this.mWorkSpecId), new Throwable[0]);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        WorkTimerRunnable(@NonNull WorkTimer workTimer, @NonNull String workSpecId) {
            this.mWorkTimer = workTimer;
            this.mWorkSpecId = workSpecId;
        }
    }

    @NonNull
    @VisibleForTesting
    public synchronized Map<String, TimeLimitExceededListener> getListeners() {
        return this.mListeners;
    }

    @NonNull
    @VisibleForTesting
    public synchronized Map<String, WorkTimerRunnable> getTimerMap() {
        return this.mTimerMap;
    }

    @NonNull
    @VisibleForTesting
    public ScheduledExecutorService getExecutorService() {
        return this.mExecutorService;
    }

    public void onDestroy() {
        if (this.mExecutorService.isShutdown()) {
            return;
        }
        this.mExecutorService.shutdownNow();
    }

    public void startTimer(@NonNull final String workSpecId, long processingTimeMillis, @NonNull TimeLimitExceededListener listener) {
        synchronized (this.mLock) {
            Logger.get().debug(TAG, String.format("Starting timer for %s", workSpecId), new Throwable[0]);
            stopTimer(workSpecId);
            WorkTimerRunnable workTimerRunnable = new WorkTimerRunnable(this, workSpecId);
            this.mTimerMap.put(workSpecId, workTimerRunnable);
            this.mListeners.put(workSpecId, listener);
            this.mExecutorService.schedule(workTimerRunnable, processingTimeMillis, TimeUnit.MILLISECONDS);
        }
    }

    public void stopTimer(@NonNull final String workSpecId) {
        synchronized (this.mLock) {
            try {
                if (this.mTimerMap.remove(workSpecId) != null) {
                    Logger.get().debug(TAG, String.format("Stopping timer for %s", workSpecId), new Throwable[0]);
                    this.mListeners.remove(workSpecId);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public WorkTimer() {
        ThreadFactory threadFactory = new ThreadFactory() { // from class: androidx.work.impl.utils.WorkTimer.1
            private int mThreadsCreated = 0;

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull Runnable r5) {
                Thread newThread = Executors.defaultThreadFactory().newThread(r5);
                newThread.setName("WorkManager-WorkTimer-thread-" + this.mThreadsCreated);
                this.mThreadsCreated = this.mThreadsCreated + 1;
                return newThread;
            }
        };
        this.mBackgroundThreadFactory = threadFactory;
        this.mTimerMap = new HashMap();
        this.mListeners = new HashMap();
        this.mLock = new Object();
        this.mExecutorService = Executors.newSingleThreadScheduledExecutor(threadFactory);
    }
}
