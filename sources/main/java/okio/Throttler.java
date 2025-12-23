package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bykv.vk.component.ttvideo.player.C;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class Throttler {
    private long allocatedUntil;
    private long bytesPerSecond;

    @NotNull
    private final Condition condition;

    @NotNull
    private final ReentrantLock lock;
    private long maxByteCount;
    private long waitByteCount;

    public Throttler(long j6) {
        this.allocatedUntil = j6;
        this.waitByteCount = 8192L;
        this.maxByteCount = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        Condition newCondition = reentrantLock.newCondition();
        g0.o(newCondition, "newCondition(...)");
        this.condition = newCondition;
    }

    @JvmOverloads
    public final void bytesPerSecond(long j6) {
        bytesPerSecond$default(this, j6, 0L, 0L, 6, null);
    }

    public static /* synthetic */ void bytesPerSecond$default(Throttler throttler, long j6, long j7, long j8, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            j7 = throttler.waitByteCount;
        }
        long j9 = j7;
        if ((i6 & 4) != 0) {
            j8 = throttler.maxByteCount;
        }
        throttler.bytesPerSecond(j6, j9, j8);
    }

    private final long nanosToBytes(long j6) {
        return (j6 * this.bytesPerSecond) / C.NANOS_PER_SECOND;
    }

    public final long byteCountOrWaitNanos$okio(long j6, long j7) {
        if (this.bytesPerSecond == 0) {
            return j7;
        }
        long max = Math.max(this.allocatedUntil - j6, 0L);
        long nanosToBytes = this.maxByteCount - nanosToBytes(max);
        if (nanosToBytes >= j7) {
            this.allocatedUntil = j6 + max + bytesToNanos(j7);
            return j7;
        }
        long j8 = this.waitByteCount;
        if (nanosToBytes >= j8) {
            this.allocatedUntil = j6 + bytesToNanos(this.maxByteCount);
            return nanosToBytes;
        }
        long min = Math.min(j8, j7);
        long bytesToNanos = max + bytesToNanos(min - this.maxByteCount);
        if (bytesToNanos != 0) {
            return -bytesToNanos;
        }
        this.allocatedUntil = j6 + bytesToNanos(this.maxByteCount);
        return min;
    }

    @JvmOverloads
    public final void bytesPerSecond(long j6, long j7) {
        bytesPerSecond$default(this, j6, j7, 0L, 4, null);
    }

    @NotNull
    public final Condition getCondition() {
        return this.condition;
    }

    @NotNull
    public final ReentrantLock getLock() {
        return this.lock;
    }

    @NotNull
    public final Sink sink(@NotNull final Sink sink) {
        g0.p(sink, "sink");
        return new ForwardingSink(sink) { // from class: okio.Throttler$sink$1
            @Override // okio.ForwardingSink, okio.Sink
            public void write(Buffer source, long j6) throws IOException {
                g0.p(source, "source");
                while (j6 > 0) {
                    try {
                        long take$okio = this.take$okio(j6);
                        super.write(source, take$okio);
                        j6 -= take$okio;
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException("interrupted");
                    }
                }
            }
        };
    }

    @NotNull
    public final Source source(@NotNull final Source source) {
        g0.p(source, "source");
        return new ForwardingSource(source) { // from class: okio.Throttler$source$1
            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer sink, long j6) {
                g0.p(sink, "sink");
                try {
                    return super.read(sink, this.take$okio(j6));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException("interrupted");
                }
            }
        };
    }

    public final long take$okio(long j6) {
        if (j6 <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                long byteCountOrWaitNanos$okio = byteCountOrWaitNanos$okio(System.nanoTime(), j6);
                if (byteCountOrWaitNanos$okio >= 0) {
                    return byteCountOrWaitNanos$okio;
                }
                this.condition.awaitNanos(-byteCountOrWaitNanos$okio);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    private final long bytesToNanos(long j6) {
        return (j6 * C.NANOS_PER_SECOND) / this.bytesPerSecond;
    }

    @JvmOverloads
    public final void bytesPerSecond(long j6, long j7, long j8) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (j6 < 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (j7 <= 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (j8 >= j7) {
                this.bytesPerSecond = j6;
                this.waitByteCount = j7;
                this.maxByteCount = j8;
                this.condition.signalAll();
                n1 n1Var = n1.f44123a;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.");
        } finally {
            reentrantLock.unlock();
        }
    }

    public Throttler() {
        this(System.nanoTime());
    }
}
