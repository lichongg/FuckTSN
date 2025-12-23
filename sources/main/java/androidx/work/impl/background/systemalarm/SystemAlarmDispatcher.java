package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.SerialExecutor;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class SystemAlarmDispatcher implements ExecutionListener {
    private static final int DEFAULT_START_ID = 0;
    private static final String KEY_START_ID = "KEY_START_ID";
    private static final String PROCESS_COMMAND_TAG = "ProcessCommand";
    static final String TAG = Logger.tagWithPrefix("SystemAlarmDispatcher");
    final CommandHandler mCommandHandler;

    @Nullable
    private CommandsCompletedListener mCompletedListener;
    final Context mContext;
    Intent mCurrentIntent;
    final List<Intent> mIntents;
    private final Handler mMainHandler;
    private final Processor mProcessor;
    private final TaskExecutor mTaskExecutor;
    private final WorkManagerImpl mWorkManager;
    private final WorkTimer mWorkTimer;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class AddRunnable implements Runnable {
        private final SystemAlarmDispatcher mDispatcher;
        private final Intent mIntent;
        private final int mStartId;

        @Override // java.lang.Runnable
        public void run() {
            this.mDispatcher.add(this.mIntent, this.mStartId);
        }

        AddRunnable(@NonNull SystemAlarmDispatcher dispatcher, @NonNull Intent intent, int startId) {
            this.mDispatcher = dispatcher;
            this.mIntent = intent;
            this.mStartId = startId;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface CommandsCompletedListener {
        void onAllCommandsCompleted();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class DequeueAndCheckForCompletion implements Runnable {
        private final SystemAlarmDispatcher mDispatcher;

        @Override // java.lang.Runnable
        public void run() {
            this.mDispatcher.dequeueAndCheckForCompletion();
        }

        DequeueAndCheckForCompletion(@NonNull SystemAlarmDispatcher dispatcher) {
            this.mDispatcher = dispatcher;
        }
    }

    SystemAlarmDispatcher(@NonNull Context context) {
        this(context, null, null);
    }

    @VisibleForTesting
    SystemAlarmDispatcher(@NonNull Context context, @Nullable Processor processor, @Nullable WorkManagerImpl workManager) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mCommandHandler = new CommandHandler(applicationContext);
        this.mWorkTimer = new WorkTimer();
        workManager = workManager == null ? WorkManagerImpl.getInstance(context) : workManager;
        this.mWorkManager = workManager;
        processor = processor == null ? workManager.getProcessor() : processor;
        this.mProcessor = processor;
        this.mTaskExecutor = workManager.getWorkTaskExecutor();
        processor.addExecutionListener(this);
        this.mIntents = new ArrayList();
        this.mCurrentIntent = null;
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }

    private void assertMainThread() {
        if (this.mMainHandler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    Processor getProcessor() {
        return this.mProcessor;
    }

    TaskExecutor getTaskExecutor() {
        return this.mTaskExecutor;
    }

    WorkManagerImpl getWorkManager() {
        return this.mWorkManager;
    }

    WorkTimer getWorkTimer() {
        return this.mWorkTimer;
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(@NonNull String workSpecId, boolean needsReschedule) {
        postOnMainThread(new AddRunnable(this, CommandHandler.createExecutionCompletedIntent(this.mContext, workSpecId, needsReschedule), 0));
    }

    void postOnMainThread(@NonNull Runnable runnable) {
        this.mMainHandler.post(runnable);
    }

    void setCompletedListener(@NonNull CommandsCompletedListener listener) {
        if (this.mCompletedListener != null) {
            Logger.get().error(TAG, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            this.mCompletedListener = listener;
        }
    }

    @MainThread
    private boolean hasIntentWithAction(@NonNull String action) {
        assertMainThread();
        synchronized (this.mIntents) {
            try {
                Iterator<Intent> it = this.mIntents.iterator();
                while (it.hasNext()) {
                    if (action.equals(it.next().getAction())) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @MainThread
    private void processCommand() {
        assertMainThread();
        PowerManager.WakeLock newWakeLock = WakeLocks.newWakeLock(this.mContext, PROCESS_COMMAND_TAG);
        try {
            newWakeLock.acquire();
            this.mWorkManager.getWorkTaskExecutor().executeOnBackgroundThread(new Runnable() { // from class: androidx.work.impl.background.systemalarm.SystemAlarmDispatcher.1
                @Override // java.lang.Runnable
                public void run() {
                    SystemAlarmDispatcher systemAlarmDispatcher;
                    DequeueAndCheckForCompletion dequeueAndCheckForCompletion;
                    synchronized (SystemAlarmDispatcher.this.mIntents) {
                        SystemAlarmDispatcher systemAlarmDispatcher2 = SystemAlarmDispatcher.this;
                        systemAlarmDispatcher2.mCurrentIntent = systemAlarmDispatcher2.mIntents.get(0);
                    }
                    Intent intent = SystemAlarmDispatcher.this.mCurrentIntent;
                    if (intent != null) {
                        String action = intent.getAction();
                        int intExtra = SystemAlarmDispatcher.this.mCurrentIntent.getIntExtra(SystemAlarmDispatcher.KEY_START_ID, 0);
                        Logger logger = Logger.get();
                        String str = SystemAlarmDispatcher.TAG;
                        logger.debug(str, String.format("Processing command %s, %s", SystemAlarmDispatcher.this.mCurrentIntent, Integer.valueOf(intExtra)), new Throwable[0]);
                        PowerManager.WakeLock newWakeLock2 = WakeLocks.newWakeLock(SystemAlarmDispatcher.this.mContext, String.format("%s (%s)", action, Integer.valueOf(intExtra)));
                        try {
                            Logger.get().debug(str, String.format("Acquiring operation wake lock (%s) %s", action, newWakeLock2), new Throwable[0]);
                            newWakeLock2.acquire();
                            SystemAlarmDispatcher systemAlarmDispatcher3 = SystemAlarmDispatcher.this;
                            systemAlarmDispatcher3.mCommandHandler.onHandleIntent(systemAlarmDispatcher3.mCurrentIntent, intExtra, systemAlarmDispatcher3);
                            Logger.get().debug(str, String.format("Releasing operation wake lock (%s) %s", action, newWakeLock2), new Throwable[0]);
                            newWakeLock2.release();
                            systemAlarmDispatcher = SystemAlarmDispatcher.this;
                            dequeueAndCheckForCompletion = new DequeueAndCheckForCompletion(systemAlarmDispatcher);
                        } catch (Throwable th) {
                            try {
                                Logger logger2 = Logger.get();
                                String str2 = SystemAlarmDispatcher.TAG;
                                logger2.error(str2, "Unexpected error in onHandleIntent", th);
                                Logger.get().debug(str2, String.format("Releasing operation wake lock (%s) %s", action, newWakeLock2), new Throwable[0]);
                                newWakeLock2.release();
                                systemAlarmDispatcher = SystemAlarmDispatcher.this;
                                dequeueAndCheckForCompletion = new DequeueAndCheckForCompletion(systemAlarmDispatcher);
                            } catch (Throwable th2) {
                                Logger.get().debug(SystemAlarmDispatcher.TAG, String.format("Releasing operation wake lock (%s) %s", action, newWakeLock2), new Throwable[0]);
                                newWakeLock2.release();
                                SystemAlarmDispatcher systemAlarmDispatcher4 = SystemAlarmDispatcher.this;
                                systemAlarmDispatcher4.postOnMainThread(new DequeueAndCheckForCompletion(systemAlarmDispatcher4));
                                throw th2;
                            }
                        }
                        systemAlarmDispatcher.postOnMainThread(dequeueAndCheckForCompletion);
                    }
                }
            });
        } finally {
            newWakeLock.release();
        }
    }

    @MainThread
    public boolean add(@NonNull final Intent intent, final int startId) {
        Logger logger = Logger.get();
        String str = TAG;
        logger.debug(str, String.format("Adding command %s (%s)", intent, Integer.valueOf(startId)), new Throwable[0]);
        assertMainThread();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            Logger.get().warning(str, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && hasIntentWithAction("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        }
        intent.putExtra(KEY_START_ID, startId);
        synchronized (this.mIntents) {
            try {
                boolean isEmpty = this.mIntents.isEmpty();
                this.mIntents.add(intent);
                if (isEmpty) {
                    processCommand();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    @MainThread
    void dequeueAndCheckForCompletion() {
        Logger logger = Logger.get();
        String str = TAG;
        logger.debug(str, "Checking if commands are complete.", new Throwable[0]);
        assertMainThread();
        synchronized (this.mIntents) {
            try {
                if (this.mCurrentIntent != null) {
                    Logger.get().debug(str, String.format("Removing command %s", this.mCurrentIntent), new Throwable[0]);
                    if (this.mIntents.remove(0).equals(this.mCurrentIntent)) {
                        this.mCurrentIntent = null;
                    } else {
                        throw new IllegalStateException("Dequeue-d command is not the first.");
                    }
                }
                SerialExecutor backgroundExecutor = this.mTaskExecutor.getBackgroundExecutor();
                if (!this.mCommandHandler.hasPendingCommands() && this.mIntents.isEmpty() && !backgroundExecutor.hasPendingTasks()) {
                    Logger.get().debug(str, "No more commands & intents.", new Throwable[0]);
                    CommandsCompletedListener commandsCompletedListener = this.mCompletedListener;
                    if (commandsCompletedListener != null) {
                        commandsCompletedListener.onAllCommandsCompleted();
                    }
                } else if (!this.mIntents.isEmpty()) {
                    processCommand();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void onDestroy() {
        Logger.get().debug(TAG, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.mProcessor.removeExecutionListener(this);
        this.mWorkTimer.onDestroy();
        this.mCompletedListener = null;
    }
}
