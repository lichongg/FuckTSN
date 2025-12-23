package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAsyncTimeout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AsyncTimeout.kt\nokio/AsyncTimeout\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,504:1\n1#2:505\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class AsyncTimeout extends Timeout {
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int STATE_CANCELED = 3;
    private static final int STATE_IDLE = 0;
    private static final int STATE_IN_QUEUE = 1;
    private static final int STATE_TIMED_OUT = 2;
    private static final int TIMEOUT_WRITE_SIZE = 65536;

    @NotNull
    private static final Condition condition;

    @Nullable
    private static AsyncTimeout idleSentinel;

    @NotNull
    private static final ReentrantLock lock;

    @JvmField
    public int index = -1;
    private int state;
    private long timeoutAt;

    @NotNull
    private static final Companion Companion = new Companion(null);

    @NotNull
    private static final PriorityQueue queue = new PriorityQueue();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void insertIntoQueue(AsyncTimeout asyncTimeout, long j6, boolean z5) {
            if (getIdleSentinel() == null) {
                setIdleSentinel(new AsyncTimeout());
                new Watchdog().start();
            }
            long nanoTime = System.nanoTime();
            if (j6 != 0 && z5) {
                asyncTimeout.timeoutAt = nanoTime + Math.min(j6, asyncTimeout.deadlineNanoTime() - nanoTime);
            } else if (j6 != 0) {
                asyncTimeout.timeoutAt = nanoTime + j6;
            } else if (z5) {
                asyncTimeout.timeoutAt = asyncTimeout.deadlineNanoTime();
            } else {
                throw new AssertionError();
            }
            getQueue().add(asyncTimeout);
            if (asyncTimeout.index == 1) {
                getCondition().signal();
            }
        }

        @Nullable
        public final AsyncTimeout awaitTimeout() throws InterruptedException {
            AsyncTimeout first = getQueue().first();
            if (first == null) {
                long nanoTime = System.nanoTime();
                getCondition().await(AsyncTimeout.IDLE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
                if (getQueue().first() != null || System.nanoTime() - nanoTime < AsyncTimeout.IDLE_TIMEOUT_NANOS) {
                    return null;
                }
                return getIdleSentinel();
            }
            long remainingNanos$okio = first.remainingNanos$okio(System.nanoTime());
            if (remainingNanos$okio > 0) {
                getCondition().await(remainingNanos$okio, TimeUnit.NANOSECONDS);
                return null;
            }
            getQueue().remove(first);
            first.state = 2;
            return first;
        }

        @NotNull
        public final Condition getCondition() {
            return AsyncTimeout.condition;
        }

        @Nullable
        public final AsyncTimeout getIdleSentinel() {
            return AsyncTimeout.idleSentinel;
        }

        @NotNull
        public final ReentrantLock getLock() {
            return AsyncTimeout.lock;
        }

        @NotNull
        public final PriorityQueue getQueue() {
            return AsyncTimeout.queue;
        }

        public final void setIdleSentinel(@Nullable AsyncTimeout asyncTimeout) {
            AsyncTimeout.idleSentinel = asyncTimeout;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ReentrantLock lock;
            AsyncTimeout awaitTimeout;
            while (true) {
                try {
                    lock = AsyncTimeout.Companion.getLock();
                    lock.lock();
                    try {
                        awaitTimeout = AsyncTimeout.Companion.awaitTimeout();
                    } finally {
                        lock.unlock();
                    }
                } catch (InterruptedException unused) {
                }
                if (awaitTimeout == AsyncTimeout.Companion.getIdleSentinel()) {
                    AsyncTimeout.Companion.setIdleSentinel(null);
                    return;
                }
                n1 n1Var = n1.f44123a;
                lock.unlock();
                if (awaitTimeout != null) {
                    awaitTimeout.timedOut();
                }
            }
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        lock = reentrantLock;
        Condition newCondition = reentrantLock.newCondition();
        g0.o(newCondition, "newCondition(...)");
        condition = newCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final boolean exit() {
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            int i6 = this.state;
            this.state = 0;
            if (i6 != 1) {
                return i6 == 2;
            }
            queue.remove(this);
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @NotNull
    protected IOException newTimeoutException(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final long remainingNanos$okio(long j6) {
        return this.timeoutAt - j6;
    }

    @NotNull
    public final Sink sink(@NotNull final Sink sink) {
        g0.p(sink, "sink");
        return new Sink() { // from class: okio.AsyncTimeout$sink$1
            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                Sink sink2 = sink;
                asyncTimeout.enter();
                try {
                    sink2.close();
                    n1 n1Var = n1.f44123a;
                    if (asyncTimeout.exit()) {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                } catch (IOException e6) {
                    if (!asyncTimeout.exit()) {
                        throw e6;
                    }
                    throw asyncTimeout.access$newTimeoutException(e6);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                Sink sink2 = sink;
                asyncTimeout.enter();
                try {
                    sink2.flush();
                    n1 n1Var = n1.f44123a;
                    if (asyncTimeout.exit()) {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                } catch (IOException e6) {
                    if (!asyncTimeout.exit()) {
                        throw e6;
                    }
                    throw asyncTimeout.access$newTimeoutException(e6);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @Override // okio.Sink
            public AsyncTimeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + sink + ')';
            }

            @Override // okio.Sink
            public void write(Buffer source, long j6) {
                g0.p(source, "source");
                SegmentedByteString.checkOffsetAndCount(source.size(), 0L, j6);
                while (true) {
                    long j7 = 0;
                    if (j6 <= 0) {
                        return;
                    }
                    Segment segment = source.head;
                    g0.m(segment);
                    while (true) {
                        if (j7 >= 65536) {
                            break;
                        }
                        j7 += segment.limit - segment.pos;
                        if (j7 >= j6) {
                            j7 = j6;
                            break;
                        } else {
                            segment = segment.next;
                            g0.m(segment);
                        }
                    }
                    AsyncTimeout asyncTimeout = AsyncTimeout.this;
                    Sink sink2 = sink;
                    asyncTimeout.enter();
                    try {
                        try {
                            sink2.write(source, j7);
                            n1 n1Var = n1.f44123a;
                            if (asyncTimeout.exit()) {
                                throw asyncTimeout.access$newTimeoutException(null);
                            }
                            j6 -= j7;
                        } catch (IOException e6) {
                            if (!asyncTimeout.exit()) {
                                throw e6;
                            }
                            throw asyncTimeout.access$newTimeoutException(e6);
                        }
                    } catch (Throwable th) {
                        asyncTimeout.exit();
                        throw th;
                    }
                }
            }
        };
    }

    @NotNull
    public final Source source(@NotNull final Source source) {
        g0.p(source, "source");
        return new Source() { // from class: okio.AsyncTimeout$source$1
            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                Source source2 = source;
                asyncTimeout.enter();
                try {
                    source2.close();
                    n1 n1Var = n1.f44123a;
                    if (asyncTimeout.exit()) {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                } catch (IOException e6) {
                    if (!asyncTimeout.exit()) {
                        throw e6;
                    }
                    throw asyncTimeout.access$newTimeoutException(e6);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @Override // okio.Source
            public long read(Buffer sink, long j6) {
                g0.p(sink, "sink");
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                Source source2 = source;
                asyncTimeout.enter();
                try {
                    long read = source2.read(sink, j6);
                    if (asyncTimeout.exit()) {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                    return read;
                } catch (IOException e6) {
                    if (asyncTimeout.exit()) {
                        throw asyncTimeout.access$newTimeoutException(e6);
                    }
                    throw e6;
                } finally {
                    asyncTimeout.exit();
                }
            }

            @Override // okio.Source
            public AsyncTimeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + source + ')';
            }
        };
    }

    public final <T> T withTimeout(@NotNull Function0<? extends T> block) {
        g0.p(block, "block");
        enter();
        try {
            try {
                T invoke = block.invoke();
                d0.d(1);
                if (exit()) {
                    throw access$newTimeoutException(null);
                }
                d0.c(1);
                return invoke;
            } catch (IOException e6) {
                if (exit()) {
                    throw access$newTimeoutException(e6);
                }
                throw e6;
            }
        } catch (Throwable th) {
            d0.d(1);
            exit();
            d0.c(1);
            throw th;
        }
    }

    @PublishedApi
    @NotNull
    public final IOException access$newTimeoutException(@Nullable IOException iOException) {
        return newTimeoutException(iOException);
    }

    @Override // okio.Timeout
    public void cancel() {
        super.cancel();
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            if (this.state == 1) {
                queue.remove(this);
                this.state = 3;
            }
            n1 n1Var = n1.f44123a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void enter() {
        long timeoutNanos = timeoutNanos();
        boolean hasDeadline = hasDeadline();
        if (timeoutNanos == 0 && !hasDeadline) {
            return;
        }
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            if (this.state == 0) {
                this.state = 1;
                Companion.insertIntoQueue(this, timeoutNanos, hasDeadline);
                n1 n1Var = n1.f44123a;
                return;
            }
            throw new IllegalStateException("Unbalanced enter/exit");
        } finally {
            reentrantLock.unlock();
        }
    }

    protected void timedOut() {
    }
}
