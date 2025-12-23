package io.netty.handler.timeout;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class IdleStateHandler extends ChannelDuplexHandler {
    private static final long MIN_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(1);
    private final long allIdleTimeNanos;
    private ScheduledFuture<?> allIdleTimeout;
    private boolean firstAllIdleEvent;
    private boolean firstReaderIdleEvent;
    private boolean firstWriterIdleEvent;
    private long lastChangeCheckTimeStamp;
    private long lastFlushProgress;
    private int lastMessageHashCode;
    private long lastPendingWriteBytes;
    private long lastReadTime;
    private long lastWriteTime;
    private final boolean observeOutput;
    private final long readerIdleTimeNanos;
    private ScheduledFuture<?> readerIdleTimeout;
    private boolean reading;
    private byte state;
    private final ChannelFutureListener writeListener;
    private final long writerIdleTimeNanos;
    private ScheduledFuture<?> writerIdleTimeout;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class AllIdleTimeoutTask extends AbstractIdleTask {
        AllIdleTimeoutTask(ChannelHandlerContext channelHandlerContext) {
            super(channelHandlerContext);
        }

        @Override // io.netty.handler.timeout.IdleStateHandler.AbstractIdleTask
        protected void run(ChannelHandlerContext channelHandlerContext) {
            long j6 = IdleStateHandler.this.allIdleTimeNanos;
            if (!IdleStateHandler.this.reading) {
                j6 -= IdleStateHandler.this.ticksInNanos() - Math.max(IdleStateHandler.this.lastReadTime, IdleStateHandler.this.lastWriteTime);
            }
            long j7 = j6;
            if (j7 > 0) {
                IdleStateHandler idleStateHandler = IdleStateHandler.this;
                idleStateHandler.allIdleTimeout = idleStateHandler.schedule(channelHandlerContext, this, j7, TimeUnit.NANOSECONDS);
                return;
            }
            IdleStateHandler idleStateHandler2 = IdleStateHandler.this;
            idleStateHandler2.allIdleTimeout = idleStateHandler2.schedule(channelHandlerContext, this, idleStateHandler2.allIdleTimeNanos, TimeUnit.NANOSECONDS);
            boolean z5 = IdleStateHandler.this.firstAllIdleEvent;
            IdleStateHandler.this.firstAllIdleEvent = false;
            try {
                if (IdleStateHandler.this.hasOutputChanged(channelHandlerContext, z5)) {
                    return;
                }
                IdleStateHandler.this.channelIdle(channelHandlerContext, IdleStateHandler.this.newIdleStateEvent(IdleState.ALL_IDLE, z5));
            } catch (Throwable th) {
                channelHandlerContext.fireExceptionCaught(th);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class ReaderIdleTimeoutTask extends AbstractIdleTask {
        ReaderIdleTimeoutTask(ChannelHandlerContext channelHandlerContext) {
            super(channelHandlerContext);
        }

        @Override // io.netty.handler.timeout.IdleStateHandler.AbstractIdleTask
        protected void run(ChannelHandlerContext channelHandlerContext) {
            long j6 = IdleStateHandler.this.readerIdleTimeNanos;
            if (!IdleStateHandler.this.reading) {
                j6 -= IdleStateHandler.this.ticksInNanos() - IdleStateHandler.this.lastReadTime;
            }
            long j7 = j6;
            if (j7 > 0) {
                IdleStateHandler idleStateHandler = IdleStateHandler.this;
                idleStateHandler.readerIdleTimeout = idleStateHandler.schedule(channelHandlerContext, this, j7, TimeUnit.NANOSECONDS);
                return;
            }
            IdleStateHandler idleStateHandler2 = IdleStateHandler.this;
            idleStateHandler2.readerIdleTimeout = idleStateHandler2.schedule(channelHandlerContext, this, idleStateHandler2.readerIdleTimeNanos, TimeUnit.NANOSECONDS);
            boolean z5 = IdleStateHandler.this.firstReaderIdleEvent;
            IdleStateHandler.this.firstReaderIdleEvent = false;
            try {
                IdleStateHandler.this.channelIdle(channelHandlerContext, IdleStateHandler.this.newIdleStateEvent(IdleState.READER_IDLE, z5));
            } catch (Throwable th) {
                channelHandlerContext.fireExceptionCaught(th);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class WriterIdleTimeoutTask extends AbstractIdleTask {
        WriterIdleTimeoutTask(ChannelHandlerContext channelHandlerContext) {
            super(channelHandlerContext);
        }

        @Override // io.netty.handler.timeout.IdleStateHandler.AbstractIdleTask
        protected void run(ChannelHandlerContext channelHandlerContext) {
            long ticksInNanos = IdleStateHandler.this.writerIdleTimeNanos - (IdleStateHandler.this.ticksInNanos() - IdleStateHandler.this.lastWriteTime);
            if (ticksInNanos > 0) {
                IdleStateHandler idleStateHandler = IdleStateHandler.this;
                idleStateHandler.writerIdleTimeout = idleStateHandler.schedule(channelHandlerContext, this, ticksInNanos, TimeUnit.NANOSECONDS);
                return;
            }
            IdleStateHandler idleStateHandler2 = IdleStateHandler.this;
            idleStateHandler2.writerIdleTimeout = idleStateHandler2.schedule(channelHandlerContext, this, idleStateHandler2.writerIdleTimeNanos, TimeUnit.NANOSECONDS);
            boolean z5 = IdleStateHandler.this.firstWriterIdleEvent;
            IdleStateHandler.this.firstWriterIdleEvent = false;
            try {
                if (IdleStateHandler.this.hasOutputChanged(channelHandlerContext, z5)) {
                    return;
                }
                IdleStateHandler.this.channelIdle(channelHandlerContext, IdleStateHandler.this.newIdleStateEvent(IdleState.WRITER_IDLE, z5));
            } catch (Throwable th) {
                channelHandlerContext.fireExceptionCaught(th);
            }
        }
    }

    public IdleStateHandler(int i6, int i7, int i8) {
        this(i6, i7, i8, TimeUnit.SECONDS);
    }

    private void destroy() {
        this.state = (byte) 2;
        ScheduledFuture<?> scheduledFuture = this.readerIdleTimeout;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.readerIdleTimeout = null;
        }
        ScheduledFuture<?> scheduledFuture2 = this.writerIdleTimeout;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(false);
            this.writerIdleTimeout = null;
        }
        ScheduledFuture<?> scheduledFuture3 = this.allIdleTimeout;
        if (scheduledFuture3 != null) {
            scheduledFuture3.cancel(false);
            this.allIdleTimeout = null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.timeout.IdleStateHandler$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$timeout$IdleState;

        static {
            int[] iArr = new int[IdleState.values().length];
            $SwitchMap$io$netty$handler$timeout$IdleState = iArr;
            try {
                iArr[IdleState.ALL_IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$timeout$IdleState[IdleState.READER_IDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$timeout$IdleState[IdleState.WRITER_IDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class AbstractIdleTask implements Runnable {
        private final ChannelHandlerContext ctx;

        @Override // java.lang.Runnable
        public void run() {
            if (this.ctx.channel().isOpen()) {
                run(this.ctx);
            }
        }

        protected abstract void run(ChannelHandlerContext channelHandlerContext);

        AbstractIdleTask(ChannelHandlerContext channelHandlerContext) {
            this.ctx = channelHandlerContext;
        }
    }

    public IdleStateHandler(long j6, long j7, long j8, TimeUnit timeUnit) {
        this(false, j6, j7, j8, timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasOutputChanged(ChannelHandlerContext channelHandlerContext, boolean z5) {
        if (!this.observeOutput) {
            return false;
        }
        long j6 = this.lastChangeCheckTimeStamp;
        long j7 = this.lastWriteTime;
        if (j6 != j7) {
            this.lastChangeCheckTimeStamp = j7;
            if (!z5) {
                return true;
            }
        }
        ChannelOutboundBuffer outboundBuffer = channelHandlerContext.channel().unsafe().outboundBuffer();
        if (outboundBuffer == null) {
            return false;
        }
        int identityHashCode = System.identityHashCode(outboundBuffer.current());
        long j8 = outboundBuffer.totalPendingWriteBytes();
        if (identityHashCode != this.lastMessageHashCode || j8 != this.lastPendingWriteBytes) {
            this.lastMessageHashCode = identityHashCode;
            this.lastPendingWriteBytes = j8;
            if (!z5) {
                return true;
            }
        }
        long currentProgress = outboundBuffer.currentProgress();
        if (currentProgress == this.lastFlushProgress) {
            return false;
        }
        this.lastFlushProgress = currentProgress;
        return !z5;
    }

    private void initOutputChanged(ChannelHandlerContext channelHandlerContext) {
        ChannelOutboundBuffer outboundBuffer;
        if (!this.observeOutput || (outboundBuffer = channelHandlerContext.channel().unsafe().outboundBuffer()) == null) {
            return;
        }
        this.lastMessageHashCode = System.identityHashCode(outboundBuffer.current());
        this.lastPendingWriteBytes = outboundBuffer.totalPendingWriteBytes();
        this.lastFlushProgress = outboundBuffer.currentProgress();
    }

    private void initialize(ChannelHandlerContext channelHandlerContext) {
        IdleStateHandler idleStateHandler;
        ChannelHandlerContext channelHandlerContext2;
        byte b6 = this.state;
        if (b6 == 1 || b6 == 2) {
            return;
        }
        this.state = (byte) 1;
        initOutputChanged(channelHandlerContext);
        long ticksInNanos = ticksInNanos();
        this.lastWriteTime = ticksInNanos;
        this.lastReadTime = ticksInNanos;
        if (this.readerIdleTimeNanos > 0) {
            idleStateHandler = this;
            channelHandlerContext2 = channelHandlerContext;
            idleStateHandler.readerIdleTimeout = schedule(channelHandlerContext, new ReaderIdleTimeoutTask(channelHandlerContext), this.readerIdleTimeNanos, TimeUnit.NANOSECONDS);
        } else {
            idleStateHandler = this;
            channelHandlerContext2 = channelHandlerContext;
        }
        if (idleStateHandler.writerIdleTimeNanos > 0) {
            idleStateHandler.writerIdleTimeout = idleStateHandler.schedule(channelHandlerContext2, new WriterIdleTimeoutTask(channelHandlerContext2), idleStateHandler.writerIdleTimeNanos, TimeUnit.NANOSECONDS);
        }
        if (idleStateHandler.allIdleTimeNanos > 0) {
            idleStateHandler.allIdleTimeout = idleStateHandler.schedule(channelHandlerContext2, new AllIdleTimeoutTask(channelHandlerContext2), idleStateHandler.allIdleTimeNanos, TimeUnit.NANOSECONDS);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (this.readerIdleTimeNanos > 0 || this.allIdleTimeNanos > 0) {
            this.reading = true;
            this.firstAllIdleEvent = true;
            this.firstReaderIdleEvent = true;
        }
        channelHandlerContext.fireChannelRead(obj);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        if ((this.readerIdleTimeNanos > 0 || this.allIdleTimeNanos > 0) && this.reading) {
            this.lastReadTime = ticksInNanos();
            this.reading = false;
        }
        channelHandlerContext.fireChannelReadComplete();
    }

    public long getAllIdleTimeInMillis() {
        return TimeUnit.NANOSECONDS.toMillis(this.allIdleTimeNanos);
    }

    public long getReaderIdleTimeInMillis() {
        return TimeUnit.NANOSECONDS.toMillis(this.readerIdleTimeNanos);
    }

    public long getWriterIdleTimeInMillis() {
        return TimeUnit.NANOSECONDS.toMillis(this.writerIdleTimeNanos);
    }

    protected IdleStateEvent newIdleStateEvent(IdleState idleState, boolean z5) {
        int i6 = AnonymousClass2.$SwitchMap$io$netty$handler$timeout$IdleState[idleState.ordinal()];
        if (i6 == 1) {
            return z5 ? IdleStateEvent.FIRST_ALL_IDLE_STATE_EVENT : IdleStateEvent.ALL_IDLE_STATE_EVENT;
        }
        if (i6 == 2) {
            return z5 ? IdleStateEvent.FIRST_READER_IDLE_STATE_EVENT : IdleStateEvent.READER_IDLE_STATE_EVENT;
        }
        if (i6 == 3) {
            return z5 ? IdleStateEvent.FIRST_WRITER_IDLE_STATE_EVENT : IdleStateEvent.WRITER_IDLE_STATE_EVENT;
        }
        throw new IllegalArgumentException("Unhandled: state=" + idleState + ", first=" + z5);
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (this.writerIdleTimeNanos > 0 || this.allIdleTimeNanos > 0) {
            channelHandlerContext.write(obj, channelPromise.unvoid()).addListener((GenericFutureListener<? extends Future<? super Void>>) this.writeListener);
        } else {
            channelHandlerContext.write(obj, channelPromise);
        }
    }

    public IdleStateHandler(boolean z5, long j6, long j7, long j8, TimeUnit timeUnit) {
        this.writeListener = new ChannelFutureListener() { // from class: io.netty.handler.timeout.IdleStateHandler.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                IdleStateHandler idleStateHandler = IdleStateHandler.this;
                idleStateHandler.lastWriteTime = idleStateHandler.ticksInNanos();
                IdleStateHandler idleStateHandler2 = IdleStateHandler.this;
                idleStateHandler2.firstWriterIdleEvent = idleStateHandler2.firstAllIdleEvent = true;
            }
        };
        this.firstReaderIdleEvent = true;
        this.firstWriterIdleEvent = true;
        this.firstAllIdleEvent = true;
        if (timeUnit != null) {
            this.observeOutput = z5;
            if (j6 <= 0) {
                this.readerIdleTimeNanos = 0L;
            } else {
                this.readerIdleTimeNanos = Math.max(timeUnit.toNanos(j6), MIN_TIMEOUT_NANOS);
            }
            if (j7 <= 0) {
                this.writerIdleTimeNanos = 0L;
            } else {
                this.writerIdleTimeNanos = Math.max(timeUnit.toNanos(j7), MIN_TIMEOUT_NANOS);
            }
            if (j8 <= 0) {
                this.allIdleTimeNanos = 0L;
                return;
            } else {
                this.allIdleTimeNanos = Math.max(timeUnit.toNanos(j8), MIN_TIMEOUT_NANOS);
                return;
            }
        }
        throw new NullPointerException("unit");
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        initialize(channelHandlerContext);
        super.channelActive(channelHandlerContext);
    }

    protected void channelIdle(ChannelHandlerContext channelHandlerContext, IdleStateEvent idleStateEvent) throws Exception {
        channelHandlerContext.fireUserEventTriggered((Object) idleStateEvent);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        destroy();
        super.channelInactive(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (channelHandlerContext.channel().isActive()) {
            initialize(channelHandlerContext);
        }
        super.channelRegistered(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (channelHandlerContext.channel().isActive() && channelHandlerContext.channel().isRegistered()) {
            initialize(channelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        destroy();
    }

    ScheduledFuture<?> schedule(ChannelHandlerContext channelHandlerContext, Runnable runnable, long j6, TimeUnit timeUnit) {
        return channelHandlerContext.executor().schedule(runnable, j6, timeUnit);
    }

    long ticksInNanos() {
        return System.nanoTime();
    }
}
