package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class DelayMetCommandHandler implements WorkConstraintsCallback, ExecutionListener, WorkTimer.TimeLimitExceededListener {
    private static final int STATE_INITIAL = 0;
    private static final int STATE_START_REQUESTED = 1;
    private static final int STATE_STOP_REQUESTED = 2;
    private static final String TAG = Logger.tagWithPrefix("DelayMetCommandHandler");
    private final Context mContext;
    private final SystemAlarmDispatcher mDispatcher;
    private final int mStartId;

    @Nullable
    private PowerManager.WakeLock mWakeLock;
    private final WorkConstraintsTracker mWorkConstraintsTracker;
    private final String mWorkSpecId;
    private boolean mHasConstraints = false;
    private int mCurrentState = 0;
    private final Object mLock = new Object();

    private void cleanUp() {
        synchronized (this.mLock) {
            try {
                this.mWorkConstraintsTracker.reset();
                this.mDispatcher.getWorkTimer().stopTimer(this.mWorkSpecId);
                PowerManager.WakeLock wakeLock = this.mWakeLock;
                if (wakeLock != null && wakeLock.isHeld()) {
                    Logger.get().debug(TAG, String.format("Releasing wakelock %s for WorkSpec %s", this.mWakeLock, this.mWorkSpecId), new Throwable[0]);
                    this.mWakeLock.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void stopWork() {
        synchronized (this.mLock) {
            try {
                if (this.mCurrentState < 2) {
                    this.mCurrentState = 2;
                    Logger logger = Logger.get();
                    String str = TAG;
                    logger.debug(str, String.format("Stopping work for WorkSpec %s", this.mWorkSpecId), new Throwable[0]);
                    Intent createStopWorkIntent = CommandHandler.createStopWorkIntent(this.mContext, this.mWorkSpecId);
                    SystemAlarmDispatcher systemAlarmDispatcher = this.mDispatcher;
                    systemAlarmDispatcher.postOnMainThread(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher, createStopWorkIntent, this.mStartId));
                    if (this.mDispatcher.getProcessor().isEnqueued(this.mWorkSpecId)) {
                        Logger.get().debug(str, String.format("WorkSpec %s needs to be rescheduled", this.mWorkSpecId), new Throwable[0]);
                        Intent createScheduleWorkIntent = CommandHandler.createScheduleWorkIntent(this.mContext, this.mWorkSpecId);
                        SystemAlarmDispatcher systemAlarmDispatcher2 = this.mDispatcher;
                        systemAlarmDispatcher2.postOnMainThread(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher2, createScheduleWorkIntent, this.mStartId));
                    } else {
                        Logger.get().debug(str, String.format("Processor does not have WorkSpec %s. No need to reschedule ", this.mWorkSpecId), new Throwable[0]);
                    }
                } else {
                    Logger.get().debug(TAG, String.format("Already stopped work for %s", this.mWorkSpecId), new Throwable[0]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @WorkerThread
    void handleProcessWork() {
        this.mWakeLock = WakeLocks.newWakeLock(this.mContext, String.format("%s (%s)", this.mWorkSpecId, Integer.valueOf(this.mStartId)));
        Logger logger = Logger.get();
        String str = TAG;
        logger.debug(str, String.format("Acquiring wakelock %s for WorkSpec %s", this.mWakeLock, this.mWorkSpecId), new Throwable[0]);
        this.mWakeLock.acquire();
        WorkSpec workSpec = this.mDispatcher.getWorkManager().getWorkDatabase().workSpecDao().getWorkSpec(this.mWorkSpecId);
        if (workSpec == null) {
            stopWork();
            return;
        }
        boolean hasConstraints = workSpec.hasConstraints();
        this.mHasConstraints = hasConstraints;
        if (hasConstraints) {
            this.mWorkConstraintsTracker.replace(Collections.singletonList(workSpec));
        } else {
            Logger.get().debug(str, String.format("No constraints for %s", this.mWorkSpecId), new Throwable[0]);
            onAllConstraintsMet(Collections.singletonList(this.mWorkSpecId));
        }
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsMet(@NonNull List<String> workSpecIds) {
        if (workSpecIds.contains(this.mWorkSpecId)) {
            synchronized (this.mLock) {
                try {
                    if (this.mCurrentState == 0) {
                        this.mCurrentState = 1;
                        Logger.get().debug(TAG, String.format("onAllConstraintsMet for %s", this.mWorkSpecId), new Throwable[0]);
                        if (this.mDispatcher.getProcessor().startWork(this.mWorkSpecId)) {
                            this.mDispatcher.getWorkTimer().startTimer(this.mWorkSpecId, TTAdConstant.AD_MAX_EVENT_TIME, this);
                        } else {
                            cleanUp();
                        }
                    } else {
                        Logger.get().debug(TAG, String.format("Already started work for %s", this.mWorkSpecId), new Throwable[0]);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    DelayMetCommandHandler(@NonNull Context context, int startId, @NonNull String workSpecId, @NonNull SystemAlarmDispatcher dispatcher) {
        this.mContext = context;
        this.mStartId = startId;
        this.mDispatcher = dispatcher;
        this.mWorkSpecId = workSpecId;
        this.mWorkConstraintsTracker = new WorkConstraintsTracker(context, dispatcher.getTaskExecutor(), this);
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsNotMet(@NonNull List<String> workSpecIds) {
        stopWork();
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(@NonNull String workSpecId, boolean needsReschedule) {
        Logger.get().debug(TAG, String.format("onExecuted %s, %s", workSpecId, Boolean.valueOf(needsReschedule)), new Throwable[0]);
        cleanUp();
        if (needsReschedule) {
            Intent createScheduleWorkIntent = CommandHandler.createScheduleWorkIntent(this.mContext, this.mWorkSpecId);
            SystemAlarmDispatcher systemAlarmDispatcher = this.mDispatcher;
            systemAlarmDispatcher.postOnMainThread(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher, createScheduleWorkIntent, this.mStartId));
        }
        if (this.mHasConstraints) {
            Intent createConstraintsChangedIntent = CommandHandler.createConstraintsChangedIntent(this.mContext);
            SystemAlarmDispatcher systemAlarmDispatcher2 = this.mDispatcher;
            systemAlarmDispatcher2.postOnMainThread(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher2, createConstraintsChangedIntent, this.mStartId));
        }
    }

    @Override // androidx.work.impl.utils.WorkTimer.TimeLimitExceededListener
    public void onTimeLimitExceeded(@NonNull String workSpecId) {
        Logger.get().debug(TAG, String.format("Exceeded time limits on execution for %s", workSpecId), new Throwable[0]);
        stopWork();
    }
}
