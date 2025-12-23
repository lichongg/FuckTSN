package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class Processor implements ExecutionListener, ForegroundProcessor {
    private static final String FOREGROUND_WAKELOCK_TAG = "ProcessorForegroundLck";
    private static final String TAG = Logger.tagWithPrefix("Processor");
    private Context mAppContext;
    private Configuration mConfiguration;
    private List<Scheduler> mSchedulers;
    private WorkDatabase mWorkDatabase;
    private TaskExecutor mWorkTaskExecutor;
    private Map<String, WorkerWrapper> mEnqueuedWorkMap = new HashMap();
    private Map<String, WorkerWrapper> mForegroundWorkMap = new HashMap();
    private Set<String> mCancelledIds = new HashSet();
    private final List<ExecutionListener> mOuterListeners = new ArrayList();

    @Nullable
    private PowerManager.WakeLock mForegroundLock = null;
    private final Object mLock = new Object();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class FutureListener implements Runnable {

        @NonNull
        private ExecutionListener mExecutionListener;

        @NonNull
        private ListenableFuture<Boolean> mFuture;

        @NonNull
        private String mWorkSpecId;

        @Override // java.lang.Runnable
        public void run() {
            boolean z5;
            try {
                z5 = this.mFuture.get().booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z5 = true;
            }
            this.mExecutionListener.onExecuted(this.mWorkSpecId, z5);
        }

        FutureListener(@NonNull ExecutionListener executionListener, @NonNull String workSpecId, @NonNull ListenableFuture<Boolean> future) {
            this.mExecutionListener = executionListener;
            this.mWorkSpecId = workSpecId;
            this.mFuture = future;
        }
    }

    private static boolean interrupt(@NonNull String id, @Nullable WorkerWrapper wrapper) {
        if (wrapper == null) {
            Logger.get().debug(TAG, String.format("WorkerWrapper could not be found for %s", id), new Throwable[0]);
            return false;
        }
        wrapper.interrupt();
        Logger.get().debug(TAG, String.format("WorkerWrapper interrupted for %s", id), new Throwable[0]);
        return true;
    }

    public boolean startWork(@NonNull String id) {
        return startWork(id, null);
    }

    private void stopForegroundService() {
        synchronized (this.mLock) {
            try {
                if (this.mForegroundWorkMap.isEmpty()) {
                    try {
                        this.mAppContext.startService(SystemForegroundDispatcher.createStopForegroundIntent(this.mAppContext));
                    } catch (Throwable th) {
                        Logger.get().error(TAG, "Unable to stop foreground service", th);
                    }
                    PowerManager.WakeLock wakeLock = this.mForegroundLock;
                    if (wakeLock != null) {
                        wakeLock.release();
                        this.mForegroundLock = null;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void addExecutionListener(@NonNull ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.add(executionListener);
        }
    }

    public boolean hasWork() {
        boolean z5;
        synchronized (this.mLock) {
            try {
                z5 = (this.mEnqueuedWorkMap.isEmpty() && this.mForegroundWorkMap.isEmpty()) ? false : true;
            } finally {
            }
        }
        return z5;
    }

    public boolean isCancelled(@NonNull String id) {
        boolean contains;
        synchronized (this.mLock) {
            contains = this.mCancelledIds.contains(id);
        }
        return contains;
    }

    public boolean isEnqueued(@NonNull String workSpecId) {
        boolean z5;
        synchronized (this.mLock) {
            try {
                z5 = this.mEnqueuedWorkMap.containsKey(workSpecId) || this.mForegroundWorkMap.containsKey(workSpecId);
            } finally {
            }
        }
        return z5;
    }

    public boolean isEnqueuedInForeground(@NonNull String workSpecId) {
        boolean containsKey;
        synchronized (this.mLock) {
            containsKey = this.mForegroundWorkMap.containsKey(workSpecId);
        }
        return containsKey;
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(@NonNull final String workSpecId, boolean needsReschedule) {
        synchronized (this.mLock) {
            try {
                this.mEnqueuedWorkMap.remove(workSpecId);
                Logger.get().debug(TAG, String.format("%s %s executed; reschedule = %s", getClass().getSimpleName(), workSpecId, Boolean.valueOf(needsReschedule)), new Throwable[0]);
                Iterator<ExecutionListener> it = this.mOuterListeners.iterator();
                while (it.hasNext()) {
                    it.next().onExecuted(workSpecId, needsReschedule);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void removeExecutionListener(@NonNull ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.remove(executionListener);
        }
    }

    @Override // androidx.work.impl.foreground.ForegroundProcessor
    public void startForeground(@NonNull String workSpecId, @NonNull ForegroundInfo foregroundInfo) {
        synchronized (this.mLock) {
            try {
                Logger.get().info(TAG, String.format("Moving WorkSpec (%s) to the foreground", workSpecId), new Throwable[0]);
                WorkerWrapper remove = this.mEnqueuedWorkMap.remove(workSpecId);
                if (remove != null) {
                    if (this.mForegroundLock == null) {
                        PowerManager.WakeLock newWakeLock = WakeLocks.newWakeLock(this.mAppContext, FOREGROUND_WAKELOCK_TAG);
                        this.mForegroundLock = newWakeLock;
                        newWakeLock.acquire();
                    }
                    this.mForegroundWorkMap.put(workSpecId, remove);
                    ContextCompat.startForegroundService(this.mAppContext, SystemForegroundDispatcher.createStartForegroundIntent(this.mAppContext, workSpecId, foregroundInfo));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean startWork(@NonNull String id, @Nullable WorkerParameters.RuntimeExtras runtimeExtras) {
        Throwable th;
        synchronized (this.mLock) {
            try {
                try {
                    if (isEnqueued(id)) {
                        try {
                            Logger.get().debug(TAG, String.format("Work %s is already enqueued for processing", id), new Throwable[0]);
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    }
                    WorkerWrapper build = new WorkerWrapper.Builder(this.mAppContext, this.mConfiguration, this.mWorkTaskExecutor, this, this.mWorkDatabase, id).withSchedulers(this.mSchedulers).withRuntimeExtras(runtimeExtras).build();
                    ListenableFuture<Boolean> future = build.getFuture();
                    future.addListener(new FutureListener(this, id, future), this.mWorkTaskExecutor.getMainThreadExecutor());
                    this.mEnqueuedWorkMap.put(id, build);
                    this.mWorkTaskExecutor.getBackgroundExecutor().execute(build);
                    Logger.get().debug(TAG, String.format("%s: processing %s", getClass().getSimpleName(), id), new Throwable[0]);
                    return true;
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                th = th;
                throw th;
            }
        }
    }

    public boolean stopAndCancelWork(@NonNull String id) {
        boolean interrupt;
        synchronized (this.mLock) {
            try {
                boolean z5 = true;
                Logger.get().debug(TAG, String.format("Processor cancelling %s", id), new Throwable[0]);
                this.mCancelledIds.add(id);
                WorkerWrapper remove = this.mForegroundWorkMap.remove(id);
                if (remove == null) {
                    z5 = false;
                }
                if (remove == null) {
                    remove = this.mEnqueuedWorkMap.remove(id);
                }
                interrupt = interrupt(id, remove);
                if (z5) {
                    stopForegroundService();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return interrupt;
    }

    @Override // androidx.work.impl.foreground.ForegroundProcessor
    public void stopForeground(@NonNull String workSpecId) {
        synchronized (this.mLock) {
            this.mForegroundWorkMap.remove(workSpecId);
            stopForegroundService();
        }
    }

    public boolean stopForegroundWork(@NonNull String id) {
        boolean interrupt;
        synchronized (this.mLock) {
            Logger.get().debug(TAG, String.format("Processor stopping foreground work %s", id), new Throwable[0]);
            interrupt = interrupt(id, this.mForegroundWorkMap.remove(id));
        }
        return interrupt;
    }

    public boolean stopWork(@NonNull String id) {
        boolean interrupt;
        synchronized (this.mLock) {
            Logger.get().debug(TAG, String.format("Processor stopping background work %s", id), new Throwable[0]);
            interrupt = interrupt(id, this.mEnqueuedWorkMap.remove(id));
        }
        return interrupt;
    }

    public Processor(@NonNull Context appContext, @NonNull Configuration configuration, @NonNull TaskExecutor workTaskExecutor, @NonNull WorkDatabase workDatabase, @NonNull List<Scheduler> schedulers) {
        this.mAppContext = appContext;
        this.mConfiguration = configuration;
        this.mWorkTaskExecutor = workTaskExecutor;
        this.mWorkDatabase = workDatabase;
        this.mSchedulers = schedulers;
    }
}
