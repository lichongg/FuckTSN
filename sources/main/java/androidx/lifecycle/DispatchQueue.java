package androidx.lifecycle;

import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.jvm.internal.g0;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.p2;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class DispatchQueue {
    private boolean finished;
    private boolean isDraining;
    private boolean paused = true;

    @NotNull
    private final Queue<Runnable> queue = new ArrayDeque();

    @MainThread
    public final void finish() {
        this.finished = true;
        drainQueue();
    }

    @MainThread
    public final void pause() {
        this.paused = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchAndEnqueue$lambda$2$lambda$1(DispatchQueue this$0, Runnable runnable) {
        g0.p(this$0, "this$0");
        g0.p(runnable, "$runnable");
        this$0.enqueue(runnable);
    }

    @MainThread
    private final void enqueue(Runnable runnable) {
        if (!this.queue.offer(runnable)) {
            throw new IllegalStateException("cannot enqueue any more runnables");
        }
        drainQueue();
    }

    @MainThread
    public final boolean canRun() {
        return this.finished || !this.paused;
    }

    @AnyThread
    public final void dispatchAndEnqueue(@NotNull kotlin.coroutines.i context, @NotNull final Runnable runnable) {
        g0.p(context, "context");
        g0.p(runnable, "runnable");
        p2 t5 = g1.e().t();
        if (t5.isDispatchNeeded(context) || canRun()) {
            t5.dispatch(context, new Runnable() { // from class: androidx.lifecycle.d
                @Override // java.lang.Runnable
                public final void run() {
                    DispatchQueue.dispatchAndEnqueue$lambda$2$lambda$1(DispatchQueue.this, runnable);
                }
            });
        } else {
            enqueue(runnable);
        }
    }

    @MainThread
    public final void drainQueue() {
        if (this.isDraining) {
            return;
        }
        try {
            this.isDraining = true;
            while (!this.queue.isEmpty() && canRun()) {
                Runnable poll = this.queue.poll();
                if (poll != null) {
                    poll.run();
                }
            }
        } finally {
            this.isDraining = false;
        }
    }

    @MainThread
    public final void resume() {
        if (this.paused) {
            if (this.finished) {
                throw new IllegalStateException("Cannot resume a finished dispatcher");
            }
            this.paused = false;
            drainQueue();
        }
    }
}
