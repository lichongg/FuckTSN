package xyz.adscope.common.v2.thread.timer.cd;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class PauseAbleCountDown {
    private static final int MSG = 1;
    private final long mCountdownInterval;
    private long mLastPauseTime;
    private final long mMillisInFuture;
    private long mPauseInterval;
    private long mStopTimeInFuture;
    private boolean mPaused = false;
    private boolean mCancelled = false;
    private boolean mStarted = false;
    private final Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: xyz.adscope.common.v2.thread.timer.cd.PauseAbleCountDown.1
        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            long j6;
            synchronized (PauseAbleCountDown.this) {
                try {
                    if (PauseAbleCountDown.this.mCancelled) {
                        return;
                    }
                    if (PauseAbleCountDown.this.mPaused) {
                        return;
                    }
                    long elapsedRealtime = (PauseAbleCountDown.this.mStopTimeInFuture + PauseAbleCountDown.this.mPauseInterval) - SystemClock.elapsedRealtime();
                    long j7 = 0;
                    if (elapsedRealtime <= 0) {
                        PauseAbleCountDown.this.mStarted = false;
                        PauseAbleCountDown.this.mPauseInterval = 0L;
                        PauseAbleCountDown.this.onFinish();
                    } else {
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        PauseAbleCountDown.this.onTick(elapsedRealtime);
                        long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                        if (elapsedRealtime < PauseAbleCountDown.this.mCountdownInterval) {
                            j6 = elapsedRealtime - elapsedRealtime3;
                            if (j6 < 0) {
                                sendMessageDelayed(obtainMessage(1), j7);
                            }
                        } else {
                            j6 = PauseAbleCountDown.this.mCountdownInterval - elapsedRealtime3;
                            while (j6 < 0) {
                                j6 += PauseAbleCountDown.this.mCountdownInterval;
                            }
                        }
                        j7 = j6;
                        sendMessageDelayed(obtainMessage(1), j7);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    };

    public final synchronized void cancel() {
        this.mCancelled = true;
        this.mHandler.removeMessages(1);
        onCancel();
    }

    public abstract void onCancel();

    public abstract void onFinish();

    public abstract void onTick(long j6);

    public final synchronized void pause() {
        if (this.mStarted) {
            this.mPaused = true;
            this.mLastPauseTime = SystemClock.elapsedRealtime();
        }
    }

    public final synchronized void resume() {
        if (this.mPaused) {
            this.mPaused = false;
            this.mPauseInterval = (SystemClock.elapsedRealtime() - this.mLastPauseTime) + this.mPauseInterval;
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(1));
        }
    }

    public final synchronized PauseAbleCountDown start() {
        this.mPauseInterval = 0L;
        if (this.mStarted) {
            return this;
        }
        this.mCancelled = false;
        this.mStarted = true;
        if (this.mMillisInFuture <= 0) {
            this.mStarted = false;
            onFinish();
            return this;
        }
        this.mStopTimeInFuture = SystemClock.elapsedRealtime() + this.mMillisInFuture;
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }

    public PauseAbleCountDown(long j6, long j7) {
        this.mMillisInFuture = j6;
        this.mCountdownInterval = j7;
    }
}
