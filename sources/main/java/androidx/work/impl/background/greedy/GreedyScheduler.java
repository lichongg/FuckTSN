package androidx.work.impl.background.greedy;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.ProcessUtils;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class GreedyScheduler implements Scheduler, WorkConstraintsCallback, ExecutionListener {
    private static final String TAG = Logger.tagWithPrefix("GreedyScheduler");
    private final Context mContext;
    private DelayedWorkTracker mDelayedWorkTracker;
    Boolean mInDefaultProcess;
    private boolean mRegisteredExecutionListener;
    private final WorkConstraintsTracker mWorkConstraintsTracker;
    private final WorkManagerImpl mWorkManagerImpl;
    private final Set<WorkSpec> mConstrainedWorkSpecs = new HashSet();
    private final Object mLock = new Object();

    public GreedyScheduler(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, @NonNull WorkManagerImpl workManagerImpl) {
        this.mContext = context;
        this.mWorkManagerImpl = workManagerImpl;
        this.mWorkConstraintsTracker = new WorkConstraintsTracker(context, taskExecutor, this);
        this.mDelayedWorkTracker = new DelayedWorkTracker(this, configuration.getRunnableScheduler());
    }

    @Override // androidx.work.impl.Scheduler
    public boolean hasLimitedSchedulingSlots() {
        return false;
    }

    private void checkDefaultProcess() {
        this.mInDefaultProcess = Boolean.valueOf(ProcessUtils.isDefaultProcess(this.mContext, this.mWorkManagerImpl.getConfiguration()));
    }

    private void registerExecutionListenerIfNeeded() {
        if (this.mRegisteredExecutionListener) {
            return;
        }
        this.mWorkManagerImpl.getProcessor().addExecutionListener(this);
        this.mRegisteredExecutionListener = true;
    }

    private void removeConstraintTrackingFor(@NonNull String workSpecId) {
        synchronized (this.mLock) {
            try {
                Iterator<WorkSpec> it = this.mConstrainedWorkSpecs.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    WorkSpec next = it.next();
                    if (next.id.equals(workSpecId)) {
                        Logger.get().debug(TAG, String.format("Stopping tracking for %s", workSpecId), new Throwable[0]);
                        this.mConstrainedWorkSpecs.remove(next);
                        this.mWorkConstraintsTracker.replace(this.mConstrainedWorkSpecs);
                        break;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.work.impl.Scheduler
    public void cancel(@NonNull String workSpecId) {
        if (this.mInDefaultProcess == null) {
            checkDefaultProcess();
        }
        if (!this.mInDefaultProcess.booleanValue()) {
            Logger.get().info(TAG, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        registerExecutionListenerIfNeeded();
        Logger.get().debug(TAG, String.format("Cancelling work ID %s", workSpecId), new Throwable[0]);
        DelayedWorkTracker delayedWorkTracker = this.mDelayedWorkTracker;
        if (delayedWorkTracker != null) {
            delayedWorkTracker.unschedule(workSpecId);
        }
        this.mWorkManagerImpl.stopWork(workSpecId);
    }

    @Override // androidx.work.impl.Scheduler
    public void schedule(@NonNull WorkSpec... workSpecs) {
        if (this.mInDefaultProcess == null) {
            checkDefaultProcess();
        }
        if (!this.mInDefaultProcess.booleanValue()) {
            Logger.get().info(TAG, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        registerExecutionListenerIfNeeded();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (WorkSpec workSpec : workSpecs) {
            long calculateNextRunTime = workSpec.calculateNextRunTime();
            long currentTimeMillis = System.currentTimeMillis();
            if (workSpec.state == WorkInfo.State.ENQUEUED) {
                if (currentTimeMillis < calculateNextRunTime) {
                    DelayedWorkTracker delayedWorkTracker = this.mDelayedWorkTracker;
                    if (delayedWorkTracker != null) {
                        delayedWorkTracker.schedule(workSpec);
                    }
                } else if (workSpec.hasConstraints()) {
                    int i6 = Build.VERSION.SDK_INT;
                    if (i6 >= 23 && workSpec.constraints.requiresDeviceIdle()) {
                        Logger.get().debug(TAG, String.format("Ignoring WorkSpec %s, Requires device idle.", workSpec), new Throwable[0]);
                    } else if (i6 < 24 || !workSpec.constraints.hasContentUriTriggers()) {
                        hashSet.add(workSpec);
                        hashSet2.add(workSpec.id);
                    } else {
                        Logger.get().debug(TAG, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", workSpec), new Throwable[0]);
                    }
                } else {
                    Logger.get().debug(TAG, String.format("Starting work for %s", workSpec.id), new Throwable[0]);
                    this.mWorkManagerImpl.startWork(workSpec.id);
                }
            }
        }
        synchronized (this.mLock) {
            try {
                if (!hashSet.isEmpty()) {
                    Logger.get().debug(TAG, String.format("Starting tracking for [%s]", TextUtils.join(",", hashSet2)), new Throwable[0]);
                    this.mConstrainedWorkSpecs.addAll(hashSet);
                    this.mWorkConstraintsTracker.replace(this.mConstrainedWorkSpecs);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    public void setDelayedWorkTracker(@NonNull DelayedWorkTracker delayedWorkTracker) {
        this.mDelayedWorkTracker = delayedWorkTracker;
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsMet(@NonNull List<String> workSpecIds) {
        for (String str : workSpecIds) {
            Logger.get().debug(TAG, String.format("Constraints met: Scheduling work ID %s", str), new Throwable[0]);
            this.mWorkManagerImpl.startWork(str);
        }
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsNotMet(@NonNull List<String> workSpecIds) {
        for (String str : workSpecIds) {
            Logger.get().debug(TAG, String.format("Constraints not met: Cancelling work ID %s", str), new Throwable[0]);
            this.mWorkManagerImpl.stopWork(str);
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(@NonNull String workSpecId, boolean needsReschedule) {
        removeConstraintTrackingFor(workSpecId);
    }

    @VisibleForTesting
    public GreedyScheduler(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl, @NonNull WorkConstraintsTracker workConstraintsTracker) {
        this.mContext = context;
        this.mWorkManagerImpl = workManagerImpl;
        this.mWorkConstraintsTracker = workConstraintsTracker;
    }
}
