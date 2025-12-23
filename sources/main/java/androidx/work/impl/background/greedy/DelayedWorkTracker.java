package androidx.work.impl.background.greedy;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class DelayedWorkTracker {
    static final String TAG = Logger.tagWithPrefix("DelayedWorkTracker");
    final GreedyScheduler mGreedyScheduler;
    private final RunnableScheduler mRunnableScheduler;
    private final Map<String, Runnable> mRunnables = new HashMap();

    public void schedule(@NonNull final WorkSpec workSpec) {
        Runnable remove = this.mRunnables.remove(workSpec.id);
        if (remove != null) {
            this.mRunnableScheduler.cancel(remove);
        }
        Runnable runnable = new Runnable() { // from class: androidx.work.impl.background.greedy.DelayedWorkTracker.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.get().debug(DelayedWorkTracker.TAG, String.format("Scheduling work %s", workSpec.id), new Throwable[0]);
                DelayedWorkTracker.this.mGreedyScheduler.schedule(workSpec);
            }
        };
        this.mRunnables.put(workSpec.id, runnable);
        this.mRunnableScheduler.scheduleWithDelay(workSpec.calculateNextRunTime() - System.currentTimeMillis(), runnable);
    }

    public void unschedule(@NonNull String workSpecId) {
        Runnable remove = this.mRunnables.remove(workSpecId);
        if (remove != null) {
            this.mRunnableScheduler.cancel(remove);
        }
    }

    public DelayedWorkTracker(@NonNull GreedyScheduler scheduler, @NonNull RunnableScheduler runnableScheduler) {
        this.mGreedyScheduler = scheduler;
        this.mRunnableScheduler = runnableScheduler;
    }
}
