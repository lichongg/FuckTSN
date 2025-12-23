package xyz.adscope.common.v2.thread.pool;

import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class IRemoveAbleScheduledTask {
    protected final int SCHEDULE_IMMEDIATELY = 0;
    private final Runnable mTask;
    private RunnableScheduledFuture<?> scheduledFuture;

    protected final void stopScheduled() {
        if (this.scheduledFuture != null) {
            IBaseThreadPool orCreateImplement = ScopeThreadPoolManager.getInstance().getOrCreateImplement(null);
            if (orCreateImplement instanceof ScopeThreadPool) {
                ((ScopeThreadPool) orCreateImplement).removeScheduleAtFixedRate(this.scheduledFuture);
                this.scheduledFuture = null;
            }
        }
    }

    public IRemoveAbleScheduledTask(Runnable runnable) {
        this.mTask = runnable;
    }

    protected final void startScheduled(long j6, long j7, TimeUnit timeUnit) {
        IBaseThreadPool orCreateImplement = ScopeThreadPoolManager.getInstance().getOrCreateImplement(null);
        if (orCreateImplement instanceof ScopeThreadPool) {
            ScheduledFuture<?> scheduleWithFixedDelay = ((ScopeThreadPool) orCreateImplement).scheduleWithFixedDelay(this.mTask, j6, j7, timeUnit);
            if (scheduleWithFixedDelay instanceof RunnableScheduledFuture) {
                try {
                    this.scheduledFuture = (RunnableScheduledFuture) scheduleWithFixedDelay;
                } catch (Throwable th) {
                    SDKLog.stack(th);
                    this.scheduledFuture = null;
                }
            }
        }
    }
}
