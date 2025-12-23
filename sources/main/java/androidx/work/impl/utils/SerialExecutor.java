package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class SerialExecutor implements Executor {
    private volatile Runnable mActive;
    private final Executor mExecutor;
    private final ArrayDeque<Task> mTasks = new ArrayDeque<>();
    private final Object mLock = new Object();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class Task implements Runnable {
        final Runnable mRunnable;
        final SerialExecutor mSerialExecutor;

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mRunnable.run();
            } finally {
                this.mSerialExecutor.scheduleNext();
            }
        }

        Task(@NonNull SerialExecutor serialExecutor, @NonNull Runnable runnable) {
            this.mSerialExecutor = serialExecutor;
            this.mRunnable = runnable;
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable command) {
        synchronized (this.mLock) {
            try {
                this.mTasks.add(new Task(this, command));
                if (this.mActive == null) {
                    scheduleNext();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    @VisibleForTesting
    public Executor getDelegatedExecutor() {
        return this.mExecutor;
    }

    public boolean hasPendingTasks() {
        boolean z5;
        synchronized (this.mLock) {
            z5 = !this.mTasks.isEmpty();
        }
        return z5;
    }

    void scheduleNext() {
        synchronized (this.mLock) {
            try {
                Task poll = this.mTasks.poll();
                this.mActive = poll;
                if (poll != null) {
                    this.mExecutor.execute(this.mActive);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public SerialExecutor(@NonNull Executor executor) {
        this.mExecutor = executor;
    }
}
