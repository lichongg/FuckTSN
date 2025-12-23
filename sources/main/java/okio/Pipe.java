package okio;

import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nPipe.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pipe.kt\nokio/Pipe\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Timeout.kt\nokio/Timeout\n*L\n1#1,262:1\n1#2:263\n302#3,26:264\n*S KotlinDebug\n*F\n+ 1 Pipe.kt\nokio/Pipe\n*L\n222#1:264,26\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class Pipe {

    @NotNull
    private final Buffer buffer = new Buffer();
    private boolean canceled;

    @NotNull
    private final Condition condition;

    @Nullable
    private Sink foldedSink;

    @NotNull
    private final ReentrantLock lock;
    private final long maxBufferSize;

    @NotNull
    private final Sink sink;
    private boolean sinkClosed;

    @NotNull
    private final Source source;
    private boolean sourceClosed;

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sink", imports = {}))
    @JvmName(name = "-deprecated_sink")
    @NotNull
    /* renamed from: -deprecated_sink, reason: not valid java name */
    public final Sink m317deprecated_sink() {
        return this.sink;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = SocialConstants.PARAM_SOURCE, imports = {}))
    @JvmName(name = "-deprecated_source")
    @NotNull
    /* renamed from: -deprecated_source, reason: not valid java name */
    public final Source m318deprecated_source() {
        return this.source;
    }

    public final void cancel() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.canceled = true;
            this.buffer.clear();
            this.condition.signalAll();
            n1 n1Var = n1.f44123a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void fold(@NotNull Sink sink) throws IOException {
        Buffer buffer;
        boolean z5;
        g0.p(sink, "sink");
        while (true) {
            this.lock.lock();
            try {
                if (this.foldedSink != null) {
                    throw new IllegalStateException("sink already folded");
                }
                if (this.canceled) {
                    this.foldedSink = sink;
                    throw new IOException("canceled");
                }
                boolean z6 = this.sinkClosed;
                Buffer buffer2 = null;
                if (this.buffer.exhausted()) {
                    this.sourceClosed = true;
                    this.foldedSink = sink;
                    buffer = null;
                    z5 = true;
                } else {
                    buffer = new Buffer();
                    Buffer buffer3 = this.buffer;
                    buffer.write(buffer3, buffer3.size());
                    this.condition.signalAll();
                    z5 = false;
                }
                n1 n1Var = n1.f44123a;
                if (z5) {
                    if (z6) {
                        sink.close();
                        return;
                    }
                    return;
                }
                if (buffer == null) {
                    try {
                        g0.S("sinkBuffer");
                    } catch (Throwable th) {
                        ReentrantLock reentrantLock = this.lock;
                        reentrantLock.lock();
                        try {
                            this.sourceClosed = true;
                            this.condition.signalAll();
                            n1 n1Var2 = n1.f44123a;
                            throw th;
                        } finally {
                            reentrantLock.unlock();
                        }
                    }
                } else {
                    buffer2 = buffer;
                }
                sink.write(buffer2, buffer.size());
                sink.flush();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @NotNull
    public final Buffer getBuffer$okio() {
        return this.buffer;
    }

    public final boolean getCanceled$okio() {
        return this.canceled;
    }

    @NotNull
    public final Condition getCondition() {
        return this.condition;
    }

    @Nullable
    public final Sink getFoldedSink$okio() {
        return this.foldedSink;
    }

    @NotNull
    public final ReentrantLock getLock() {
        return this.lock;
    }

    public final long getMaxBufferSize$okio() {
        return this.maxBufferSize;
    }

    public final boolean getSinkClosed$okio() {
        return this.sinkClosed;
    }

    public final boolean getSourceClosed$okio() {
        return this.sourceClosed;
    }

    public final void setCanceled$okio(boolean z5) {
        this.canceled = z5;
    }

    public final void setFoldedSink$okio(@Nullable Sink sink) {
        this.foldedSink = sink;
    }

    public final void setSinkClosed$okio(boolean z5) {
        this.sinkClosed = z5;
    }

    public final void setSourceClosed$okio(boolean z5) {
        this.sourceClosed = z5;
    }

    @JvmName(name = "sink")
    @NotNull
    public final Sink sink() {
        return this.sink;
    }

    @JvmName(name = SocialConstants.PARAM_SOURCE)
    @NotNull
    public final Source source() {
        return this.source;
    }

    public Pipe(long j6) {
        this.maxBufferSize = j6;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        Condition newCondition = reentrantLock.newCondition();
        g0.o(newCondition, "newCondition(...)");
        this.condition = newCondition;
        if (j6 >= 1) {
            this.sink = new Sink() { // from class: okio.Pipe$sink$1
                private final Timeout timeout = new Timeout();

                @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    ReentrantLock lock = Pipe.this.getLock();
                    Pipe pipe = Pipe.this;
                    lock.lock();
                    try {
                        if (pipe.getSinkClosed$okio()) {
                            lock.unlock();
                            return;
                        }
                        Sink foldedSink$okio = pipe.getFoldedSink$okio();
                        if (foldedSink$okio == null) {
                            if (pipe.getSourceClosed$okio() && pipe.getBuffer$okio().size() > 0) {
                                throw new IOException("source is closed");
                            }
                            pipe.setSinkClosed$okio(true);
                            pipe.getCondition().signalAll();
                            foldedSink$okio = null;
                        }
                        n1 n1Var = n1.f44123a;
                        lock.unlock();
                        if (foldedSink$okio != null) {
                            Pipe pipe2 = Pipe.this;
                            Timeout timeout = foldedSink$okio.timeout();
                            Timeout timeout2 = pipe2.sink().timeout();
                            long timeoutNanos = timeout.timeoutNanos();
                            long minTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
                            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                            timeout.timeout(minTimeout, timeUnit);
                            if (!timeout.hasDeadline()) {
                                if (timeout2.hasDeadline()) {
                                    timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                                }
                                try {
                                    foldedSink$okio.close();
                                    timeout.timeout(timeoutNanos, timeUnit);
                                    if (timeout2.hasDeadline()) {
                                        timeout.clearDeadline();
                                        return;
                                    }
                                    return;
                                } catch (Throwable th) {
                                    timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                    if (timeout2.hasDeadline()) {
                                        timeout.clearDeadline();
                                    }
                                    throw th;
                                }
                            }
                            long deadlineNanoTime = timeout.deadlineNanoTime();
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                            }
                            try {
                                foldedSink$okio.close();
                                timeout.timeout(timeoutNanos, timeUnit);
                                if (timeout2.hasDeadline()) {
                                    timeout.deadlineNanoTime(deadlineNanoTime);
                                }
                            } catch (Throwable th2) {
                                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.hasDeadline()) {
                                    timeout.deadlineNanoTime(deadlineNanoTime);
                                }
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        lock.unlock();
                        throw th3;
                    }
                }

                @Override // okio.Sink, java.io.Flushable
                public void flush() {
                    ReentrantLock lock = Pipe.this.getLock();
                    Pipe pipe = Pipe.this;
                    lock.lock();
                    try {
                        if (pipe.getSinkClosed$okio()) {
                            throw new IllegalStateException("closed");
                        }
                        if (pipe.getCanceled$okio()) {
                            throw new IOException("canceled");
                        }
                        Sink foldedSink$okio = pipe.getFoldedSink$okio();
                        if (foldedSink$okio == null) {
                            if (pipe.getSourceClosed$okio() && pipe.getBuffer$okio().size() > 0) {
                                throw new IOException("source is closed");
                            }
                            foldedSink$okio = null;
                        }
                        n1 n1Var = n1.f44123a;
                        lock.unlock();
                        if (foldedSink$okio != null) {
                            Pipe pipe2 = Pipe.this;
                            Timeout timeout = foldedSink$okio.timeout();
                            Timeout timeout2 = pipe2.sink().timeout();
                            long timeoutNanos = timeout.timeoutNanos();
                            long minTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
                            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                            timeout.timeout(minTimeout, timeUnit);
                            if (!timeout.hasDeadline()) {
                                if (timeout2.hasDeadline()) {
                                    timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                                }
                                try {
                                    foldedSink$okio.flush();
                                    timeout.timeout(timeoutNanos, timeUnit);
                                    if (timeout2.hasDeadline()) {
                                        timeout.clearDeadline();
                                        return;
                                    }
                                    return;
                                } catch (Throwable th) {
                                    timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                    if (timeout2.hasDeadline()) {
                                        timeout.clearDeadline();
                                    }
                                    throw th;
                                }
                            }
                            long deadlineNanoTime = timeout.deadlineNanoTime();
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                            }
                            try {
                                foldedSink$okio.flush();
                                timeout.timeout(timeoutNanos, timeUnit);
                                if (timeout2.hasDeadline()) {
                                    timeout.deadlineNanoTime(deadlineNanoTime);
                                }
                            } catch (Throwable th2) {
                                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.hasDeadline()) {
                                    timeout.deadlineNanoTime(deadlineNanoTime);
                                }
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        lock.unlock();
                        throw th3;
                    }
                }

                @Override // okio.Sink
                public Timeout timeout() {
                    return this.timeout;
                }

                /* JADX WARN: Code restructure failed: missing block: B:34:0x0078, code lost:
                
                    r1 = kotlin.n1.f44123a;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:35:0x007a, code lost:
                
                    r0.unlock();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:36:0x007d, code lost:
                
                    if (r2 == null) goto L59;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:37:0x007f, code lost:
                
                    r0 = r12.this$0;
                    r1 = r2.timeout();
                    r0 = r0.sink().timeout();
                    r3 = r1.timeoutNanos();
                    r5 = okio.Timeout.Companion.minTimeout(r0.timeoutNanos(), r1.timeoutNanos());
                    r7 = java.util.concurrent.TimeUnit.NANOSECONDS;
                    r1.timeout(r5, r7);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:38:0x00a8, code lost:
                
                    if (r1.hasDeadline() == false) goto L46;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:39:0x00aa, code lost:
                
                    r5 = r1.deadlineNanoTime();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:40:0x00b2, code lost:
                
                    if (r0.hasDeadline() == false) goto L68;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:41:0x00b4, code lost:
                
                    r1.deadlineNanoTime(java.lang.Math.min(r1.deadlineNanoTime(), r0.deadlineNanoTime()));
                 */
                /* JADX WARN: Code restructure failed: missing block: B:43:0x00c3, code lost:
                
                    r2.write(r13, r14);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:44:0x00c6, code lost:
                
                    r1.timeout(r3, r7);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:45:0x00cd, code lost:
                
                    if (r0.hasDeadline() == false) goto L80;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:46:0x00cf, code lost:
                
                    r1.deadlineNanoTime(r5);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:47:0x00d2, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:48:?, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:50:0x00d3, code lost:
                
                    r13 = move-exception;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:51:0x00d4, code lost:
                
                    r1.timeout(r3, java.util.concurrent.TimeUnit.NANOSECONDS);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:52:0x00dd, code lost:
                
                    if (r0.hasDeadline() != false) goto L44;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:53:0x00df, code lost:
                
                    r1.deadlineNanoTime(r5);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:54:0x00e2, code lost:
                
                    throw r13;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:56:0x00e7, code lost:
                
                    if (r0.hasDeadline() == false) goto L66;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:57:0x00e9, code lost:
                
                    r1.deadlineNanoTime(r0.deadlineNanoTime());
                 */
                /* JADX WARN: Code restructure failed: missing block: B:59:0x00f0, code lost:
                
                    r2.write(r13, r14);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:60:0x00f3, code lost:
                
                    r1.timeout(r3, r7);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:61:0x00fa, code lost:
                
                    if (r0.hasDeadline() == false) goto L81;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:62:0x00fc, code lost:
                
                    r1.clearDeadline();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:63:0x00ff, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:64:?, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:66:0x0100, code lost:
                
                    r13 = move-exception;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:67:0x0101, code lost:
                
                    r1.timeout(r3, java.util.concurrent.TimeUnit.NANOSECONDS);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:68:0x010a, code lost:
                
                    if (r0.hasDeadline() != false) goto L57;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:69:0x010c, code lost:
                
                    r1.clearDeadline();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:70:0x010f, code lost:
                
                    throw r13;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:71:0x0110, code lost:
                
                    return;
                 */
                @Override // okio.Sink
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void write(okio.Buffer r13, long r14) {
                    /*
                        Method dump skipped, instructions count: 291
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: okio.Pipe$sink$1.write(okio.Buffer, long):void");
                }
            };
            this.source = new Source() { // from class: okio.Pipe$source$1
                private final Timeout timeout = new Timeout();

                @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    ReentrantLock lock = Pipe.this.getLock();
                    Pipe pipe = Pipe.this;
                    lock.lock();
                    try {
                        pipe.setSourceClosed$okio(true);
                        pipe.getCondition().signalAll();
                        n1 n1Var = n1.f44123a;
                    } finally {
                        lock.unlock();
                    }
                }

                @Override // okio.Source
                public long read(Buffer sink, long j7) {
                    g0.p(sink, "sink");
                    ReentrantLock lock = Pipe.this.getLock();
                    Pipe pipe = Pipe.this;
                    lock.lock();
                    try {
                        if (pipe.getSourceClosed$okio()) {
                            throw new IllegalStateException("closed");
                        }
                        if (pipe.getCanceled$okio()) {
                            throw new IOException("canceled");
                        }
                        while (pipe.getBuffer$okio().size() == 0) {
                            if (pipe.getSinkClosed$okio()) {
                                lock.unlock();
                                return -1L;
                            }
                            this.timeout.awaitSignal(pipe.getCondition());
                            if (pipe.getCanceled$okio()) {
                                throw new IOException("canceled");
                            }
                        }
                        long read = pipe.getBuffer$okio().read(sink, j7);
                        pipe.getCondition().signalAll();
                        lock.unlock();
                        return read;
                    } catch (Throwable th) {
                        lock.unlock();
                        throw th;
                    }
                }

                @Override // okio.Source
                public Timeout timeout() {
                    return this.timeout;
                }
            };
        } else {
            throw new IllegalArgumentException(("maxBufferSize < 1: " + j6).toString());
        }
    }

    private final void forward(Sink sink, Function1<? super Sink, n1> function1) {
        Timeout timeout = sink.timeout();
        Timeout timeout2 = sink().timeout();
        long timeoutNanos = timeout.timeoutNanos();
        long minTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout.timeout(minTimeout, timeUnit);
        if (timeout.hasDeadline()) {
            long deadlineNanoTime = timeout.deadlineNanoTime();
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
            }
            try {
                function1.invoke(sink);
                n1 n1Var = n1.f44123a;
                d0.d(1);
                timeout.timeout(timeoutNanos, timeUnit);
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(deadlineNanoTime);
                }
                d0.c(1);
                return;
            } catch (Throwable th) {
                d0.d(1);
                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(deadlineNanoTime);
                }
                d0.c(1);
                throw th;
            }
        }
        if (timeout2.hasDeadline()) {
            timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
        }
        try {
            function1.invoke(sink);
            n1 n1Var2 = n1.f44123a;
            d0.d(1);
            timeout.timeout(timeoutNanos, timeUnit);
            if (timeout2.hasDeadline()) {
                timeout.clearDeadline();
            }
            d0.c(1);
        } catch (Throwable th2) {
            d0.d(1);
            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            if (timeout2.hasDeadline()) {
                timeout.clearDeadline();
            }
            d0.c(1);
            throw th2;
        }
    }
}
