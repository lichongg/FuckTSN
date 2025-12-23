package xyz.adscope.common.v2.thread.timer.task;

import java.util.Timer;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class ICommonTimeoutTask {
    protected final long mTimeoutMillion;
    private final InnerTimerTask mTimer = new InnerTimerTask(this, null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.v2.thread.timer.task.ICommonTimeoutTask$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class InnerTimerTask implements IBaseTimerTask {
        private TimerTask mTask;
        private Timer mTimer;

        private InnerTimerTask() {
        }

        @Override // xyz.adscope.common.v2.thread.timer.task.IBaseTimerTask
        public synchronized void cancel() {
            try {
                TimerTask timerTask = this.mTask;
                if (timerTask != null) {
                    timerTask.cancel();
                }
                Timer timer = this.mTimer;
                if (timer != null) {
                    timer.cancel();
                    this.mTimer.purge();
                }
                this.mTimer = null;
                this.mTask = null;
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // xyz.adscope.common.v2.thread.timer.task.IBaseTimerTask
        public void schedule(long j6) {
            resetTimer();
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.schedule(this.mTask, j6);
            }
        }

        /* synthetic */ InnerTimerTask(ICommonTimeoutTask iCommonTimeoutTask, AnonymousClass1 anonymousClass1) {
            this();
        }

        private void resetTimer() {
            cancel();
            this.mTimer = new Timer();
            this.mTask = new TimerTask() { // from class: xyz.adscope.common.v2.thread.timer.task.ICommonTimeoutTask.InnerTimerTask.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    ICommonTimeoutTask.this.onScheduleTimeout();
                }
            };
        }

        @Override // xyz.adscope.common.v2.thread.timer.task.IBaseTimerTask
        public void schedule(long j6, long j7) {
            resetTimer();
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.schedule(this.mTask, j6, j7);
            }
        }
    }

    protected abstract void onScheduleTimeout();

    public void cancelCountDown() {
        InnerTimerTask innerTimerTask = this.mTimer;
        if (innerTimerTask != null) {
            innerTimerTask.cancel();
        }
    }

    public void startCountDown() {
        InnerTimerTask innerTimerTask = this.mTimer;
        if (innerTimerTask != null) {
            innerTimerTask.schedule(this.mTimeoutMillion);
        }
    }

    public ICommonTimeoutTask(long j6) {
        this.mTimeoutMillion = j6;
    }
}
