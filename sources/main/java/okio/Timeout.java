package okio;

import com.bykv.vk.component.ttvideo.player.C;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nTimeout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Timeout.kt\nokio/Timeout\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,358:1\n1#2:359\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class Timeout {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmField
    @NotNull
    public static final Timeout NONE = new Timeout() { // from class: okio.Timeout$Companion$NONE$1
        @Override // okio.Timeout
        public Timeout timeout(long j6, TimeUnit unit) {
            g0.p(unit, "unit");
            return this;
        }

        @Override // okio.Timeout
        public void throwIfReached() {
        }

        @Override // okio.Timeout
        public Timeout deadlineNanoTime(long j6) {
            return this;
        }
    };

    @Nullable
    private volatile Object cancelMark;
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        public final long minTimeout(long j6, long j7) {
            return (j6 != 0 && (j7 == 0 || j6 < j7)) ? j6 : j7;
        }

        @NotNull
        public final Timeout timeout(@NotNull Timeout timeout, long j6, @NotNull DurationUnit unit) {
            g0.p(timeout, "<this>");
            g0.p(unit, "unit");
            return timeout.timeout(j6, kotlin.time.k.e(unit));
        }

        @NotNull
        /* renamed from: timeout-HG0u8IE, reason: not valid java name */
        public final Timeout m319timeoutHG0u8IE(@NotNull Timeout timeout, long j6) {
            g0.p(timeout, "$this$timeout");
            return timeout.timeout(kotlin.time.h.z(j6), TimeUnit.NANOSECONDS);
        }
    }

    @NotNull
    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline");
    }

    public void awaitSignal(@NotNull Condition condition) throws InterruptedIOException {
        g0.p(condition, "condition");
        try {
            boolean hasDeadline = hasDeadline();
            long timeoutNanos = timeoutNanos();
            if (!hasDeadline && timeoutNanos == 0) {
                condition.await();
                return;
            }
            if (hasDeadline && timeoutNanos != 0) {
                timeoutNanos = Math.min(timeoutNanos, deadlineNanoTime() - System.nanoTime());
            } else if (hasDeadline) {
                timeoutNanos = deadlineNanoTime() - System.nanoTime();
            }
            if (timeoutNanos <= 0) {
                throw new InterruptedIOException("timeout");
            }
            Object obj = this.cancelMark;
            if (condition.awaitNanos(timeoutNanos) <= 0 && this.cancelMark == obj) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public void cancel() {
        this.cancelMark = new Object();
    }

    @NotNull
    public Timeout clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    @NotNull
    public final Timeout deadline(long j6, @NotNull TimeUnit unit) {
        g0.p(unit, "unit");
        if (j6 > 0) {
            return deadlineNanoTime(System.nanoTime() + unit.toNanos(j6));
        }
        throw new IllegalArgumentException(("duration <= 0: " + j6).toString());
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final <T> T intersectWith(@NotNull Timeout other, @NotNull Function0<? extends T> block) {
        g0.p(other, "other");
        g0.p(block, "block");
        long timeoutNanos = timeoutNanos();
        long minTimeout = Companion.minTimeout(other.timeoutNanos(), timeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout(minTimeout, timeUnit);
        if (!hasDeadline()) {
            if (other.hasDeadline()) {
                deadlineNanoTime(other.deadlineNanoTime());
            }
            try {
                T invoke = block.invoke();
                d0.d(1);
                timeout(timeoutNanos, timeUnit);
                if (other.hasDeadline()) {
                    clearDeadline();
                }
                d0.c(1);
                return invoke;
            } catch (Throwable th) {
                d0.d(1);
                timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (other.hasDeadline()) {
                    clearDeadline();
                }
                d0.c(1);
                throw th;
            }
        }
        long deadlineNanoTime = deadlineNanoTime();
        if (other.hasDeadline()) {
            deadlineNanoTime(Math.min(deadlineNanoTime(), other.deadlineNanoTime()));
        }
        try {
            T invoke2 = block.invoke();
            d0.d(1);
            timeout(timeoutNanos, timeUnit);
            if (other.hasDeadline()) {
                deadlineNanoTime(deadlineNanoTime);
            }
            d0.c(1);
            return invoke2;
        } catch (Throwable th2) {
            d0.d(1);
            timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            if (other.hasDeadline()) {
                deadlineNanoTime(deadlineNanoTime);
            }
            d0.c(1);
            throw th2;
        }
    }

    @NotNull
    public Timeout timeout(long j6, @NotNull TimeUnit unit) {
        g0.p(unit, "unit");
        if (j6 >= 0) {
            this.timeoutNanos = unit.toNanos(j6);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j6).toString());
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public void waitUntilNotified(@NotNull Object monitor) throws InterruptedIOException {
        g0.p(monitor, "monitor");
        try {
            boolean hasDeadline = hasDeadline();
            long timeoutNanos = timeoutNanos();
            if (!hasDeadline && timeoutNanos == 0) {
                monitor.wait();
                return;
            }
            long nanoTime = System.nanoTime();
            if (hasDeadline && timeoutNanos != 0) {
                timeoutNanos = Math.min(timeoutNanos, deadlineNanoTime() - nanoTime);
            } else if (hasDeadline) {
                timeoutNanos = deadlineNanoTime() - nanoTime;
            }
            if (timeoutNanos <= 0) {
                throw new InterruptedIOException("timeout");
            }
            Object obj = this.cancelMark;
            long j6 = timeoutNanos / C.MICROS_PER_SECOND;
            Long.signum(j6);
            monitor.wait(j6, (int) (timeoutNanos - (C.MICROS_PER_SECOND * j6)));
            if (System.nanoTime() - nanoTime >= timeoutNanos && this.cancelMark == obj) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public void throwIfReached() throws IOException {
        if (!Thread.currentThread().isInterrupted()) {
            if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        throw new InterruptedIOException("interrupted");
    }

    @NotNull
    public Timeout deadlineNanoTime(long j6) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j6;
        return this;
    }
}
