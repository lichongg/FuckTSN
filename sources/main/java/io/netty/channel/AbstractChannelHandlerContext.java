package io.netty.channel;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.AbstractChannel;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.Recycler;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ResourceLeakHint;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.OrderedEventExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PromiseNotificationUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
abstract class AbstractChannelHandlerContext implements ChannelHandlerContext, ResourceLeakHint {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ADD_COMPLETE = 2;
    private static final int ADD_PENDING = 1;
    private static final int INIT = 0;
    private static final int REMOVE_COMPLETE = 3;
    private final int executionMask;
    final EventExecutor executor;
    private volatile int handlerState = 0;
    private Tasks invokeTasks;
    private final String name;
    volatile AbstractChannelHandlerContext next;
    private final boolean ordered;
    private final DefaultChannelPipeline pipeline;
    volatile AbstractChannelHandlerContext prev;
    private ChannelFuture succeededFuture;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractChannelHandlerContext.class);
    private static final AtomicIntegerFieldUpdater<AbstractChannelHandlerContext> HANDLER_STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(AbstractChannelHandlerContext.class, "handlerState");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class AbstractWriteTask implements Runnable {
        private static final boolean ESTIMATE_TASK_SIZE_ON_SUBMIT = SystemPropertyUtil.getBoolean("io.netty.transport.estimateSizeOnSubmit", true);
        private static final int WRITE_TASK_OVERHEAD = SystemPropertyUtil.getInt("io.netty.transport.writeTaskSizeOverhead", 48);
        private AbstractChannelHandlerContext ctx;
        private final Recycler.Handle<AbstractWriteTask> handle;
        private Object msg;
        private ChannelPromise promise;
        private int size;

        private void recycle() {
            this.ctx = null;
            this.msg = null;
            this.promise = null;
            this.handle.recycle(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private AbstractWriteTask(Recycler.Handle<? extends AbstractWriteTask> handle) {
            this.handle = handle;
        }

        private void decrementPendingOutboundBytes() {
            if (ESTIMATE_TASK_SIZE_ON_SUBMIT) {
                this.ctx.pipeline.decrementPendingOutboundBytes(this.size);
            }
        }

        protected static void init(AbstractWriteTask abstractWriteTask, AbstractChannelHandlerContext abstractChannelHandlerContext, Object obj, ChannelPromise channelPromise) {
            abstractWriteTask.ctx = abstractChannelHandlerContext;
            abstractWriteTask.msg = obj;
            abstractWriteTask.promise = channelPromise;
            if (!ESTIMATE_TASK_SIZE_ON_SUBMIT) {
                abstractWriteTask.size = 0;
            } else {
                abstractWriteTask.size = abstractChannelHandlerContext.pipeline.estimatorHandle().size(obj) + WRITE_TASK_OVERHEAD;
                abstractChannelHandlerContext.pipeline.incrementPendingOutboundBytes(abstractWriteTask.size);
            }
        }

        void cancel() {
            try {
                decrementPendingOutboundBytes();
            } finally {
                recycle();
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                decrementPendingOutboundBytes();
                write(this.ctx, this.msg, this.promise);
            } finally {
                recycle();
            }
        }

        protected void write(AbstractChannelHandlerContext abstractChannelHandlerContext, Object obj, ChannelPromise channelPromise) {
            abstractChannelHandlerContext.invokeWrite(obj, channelPromise);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Tasks {
        private final AbstractChannelHandlerContext next;
        private final Runnable invokeChannelReadCompleteTask = new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.Tasks.1
            @Override // java.lang.Runnable
            public void run() {
                Tasks.this.next.invokeChannelReadComplete();
            }
        };
        private final Runnable invokeReadTask = new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.Tasks.2
            @Override // java.lang.Runnable
            public void run() {
                Tasks.this.next.invokeRead();
            }
        };
        private final Runnable invokeChannelWritableStateChangedTask = new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.Tasks.3
            @Override // java.lang.Runnable
            public void run() {
                Tasks.this.next.invokeChannelWritabilityChanged();
            }
        };
        private final Runnable invokeFlushTask = new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.Tasks.4
            @Override // java.lang.Runnable
            public void run() {
                Tasks.this.next.invokeFlush();
            }
        };

        Tasks(AbstractChannelHandlerContext abstractChannelHandlerContext) {
            this.next = abstractChannelHandlerContext;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WriteAndFlushTask extends AbstractWriteTask {
        private static final Recycler<WriteAndFlushTask> RECYCLER = new Recycler<WriteAndFlushTask>() { // from class: io.netty.channel.AbstractChannelHandlerContext.WriteAndFlushTask.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.Recycler
            public WriteAndFlushTask newObject(Recycler.Handle<WriteAndFlushTask> handle) {
                return new WriteAndFlushTask(handle);
            }
        };

        private WriteAndFlushTask(Recycler.Handle<WriteAndFlushTask> handle) {
            super(handle);
        }

        static WriteAndFlushTask newInstance(AbstractChannelHandlerContext abstractChannelHandlerContext, Object obj, ChannelPromise channelPromise) {
            WriteAndFlushTask writeAndFlushTask = RECYCLER.get();
            AbstractWriteTask.init(writeAndFlushTask, abstractChannelHandlerContext, obj, channelPromise);
            return writeAndFlushTask;
        }

        @Override // io.netty.channel.AbstractChannelHandlerContext.AbstractWriteTask
        public void write(AbstractChannelHandlerContext abstractChannelHandlerContext, Object obj, ChannelPromise channelPromise) {
            super.write(abstractChannelHandlerContext, obj, channelPromise);
            abstractChannelHandlerContext.invokeFlush();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WriteTask extends AbstractWriteTask implements SingleThreadEventLoop.NonWakeupRunnable {
        private static final Recycler<WriteTask> RECYCLER = new Recycler<WriteTask>() { // from class: io.netty.channel.AbstractChannelHandlerContext.WriteTask.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.Recycler
            public WriteTask newObject(Recycler.Handle<WriteTask> handle) {
                return new WriteTask(handle);
            }
        };

        private WriteTask(Recycler.Handle<WriteTask> handle) {
            super(handle);
        }

        static WriteTask newInstance(AbstractChannelHandlerContext abstractChannelHandlerContext, Object obj, ChannelPromise channelPromise) {
            WriteTask writeTask = RECYCLER.get();
            AbstractWriteTask.init(writeTask, abstractChannelHandlerContext, obj, channelPromise);
            return writeTask;
        }
    }

    private AbstractChannelHandlerContext findContextInbound(int i6) {
        AbstractChannelHandlerContext abstractChannelHandlerContext = this;
        do {
            abstractChannelHandlerContext = abstractChannelHandlerContext.next;
        } while ((abstractChannelHandlerContext.executionMask & i6) == 0);
        return abstractChannelHandlerContext;
    }

    private AbstractChannelHandlerContext findContextOutbound(int i6) {
        AbstractChannelHandlerContext abstractChannelHandlerContext = this;
        do {
            abstractChannelHandlerContext = abstractChannelHandlerContext.prev;
        } while ((abstractChannelHandlerContext.executionMask & i6) == 0);
        return abstractChannelHandlerContext;
    }

    static void invokeChannelActive(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor executor = abstractChannelHandlerContext.executor();
        if (executor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelActive();
        } else {
            executor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.3
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeChannelActive();
                }
            });
        }
    }

    static void invokeChannelInactive(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor executor = abstractChannelHandlerContext.executor();
        if (executor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelInactive();
        } else {
            executor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.4
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeChannelInactive();
                }
            });
        }
    }

    static void invokeChannelRead(AbstractChannelHandlerContext abstractChannelHandlerContext, Object obj) {
        final Object obj2 = abstractChannelHandlerContext.pipeline.touch(ObjectUtil.checkNotNull(obj, "msg"), abstractChannelHandlerContext);
        EventExecutor executor = abstractChannelHandlerContext.executor();
        if (executor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelRead(obj2);
        } else {
            executor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.7
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeChannelRead(obj2);
                }
            });
        }
    }

    static void invokeChannelReadComplete(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor executor = abstractChannelHandlerContext.executor();
        if (executor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelReadComplete();
            return;
        }
        Tasks tasks = abstractChannelHandlerContext.invokeTasks;
        if (tasks == null) {
            tasks = new Tasks(abstractChannelHandlerContext);
            abstractChannelHandlerContext.invokeTasks = tasks;
        }
        executor.execute(tasks.invokeChannelReadCompleteTask);
    }

    static void invokeChannelRegistered(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor executor = abstractChannelHandlerContext.executor();
        if (executor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelRegistered();
        } else {
            executor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.1
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeChannelRegistered();
                }
            });
        }
    }

    static void invokeChannelUnregistered(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor executor = abstractChannelHandlerContext.executor();
        if (executor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelUnregistered();
        } else {
            executor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeChannelUnregistered();
                }
            });
        }
    }

    static void invokeChannelWritabilityChanged(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor executor = abstractChannelHandlerContext.executor();
        if (executor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelWritabilityChanged();
            return;
        }
        Tasks tasks = abstractChannelHandlerContext.invokeTasks;
        if (tasks == null) {
            tasks = new Tasks(abstractChannelHandlerContext);
            abstractChannelHandlerContext.invokeTasks = tasks;
        }
        executor.execute(tasks.invokeChannelWritableStateChangedTask);
    }

    static void invokeExceptionCaught(AbstractChannelHandlerContext abstractChannelHandlerContext, final Throwable th) {
        ObjectUtil.checkNotNull(th, "cause");
        EventExecutor executor = abstractChannelHandlerContext.executor();
        if (executor.inEventLoop()) {
            abstractChannelHandlerContext.invokeExceptionCaught(th);
            return;
        }
        try {
            executor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.5
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeExceptionCaught(th);
                }
            });
        } catch (Throwable th2) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isWarnEnabled()) {
                internalLogger.warn("Failed to submit an exceptionCaught() event.", th2);
                internalLogger.warn("The exceptionCaught() event that was failed to submit was:", th);
            }
        }
    }

    static void invokeUserEventTriggered(AbstractChannelHandlerContext abstractChannelHandlerContext, final Object obj) {
        ObjectUtil.checkNotNull(obj, "event");
        EventExecutor executor = abstractChannelHandlerContext.executor();
        if (executor.inEventLoop()) {
            abstractChannelHandlerContext.invokeUserEventTriggered(obj);
        } else {
            executor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.6
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeUserEventTriggered(obj);
                }
            });
        }
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture bind(SocketAddress socketAddress) {
        return bind(socketAddress, newPromise());
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture close() {
        return close(newPromise());
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress) {
        return connect(socketAddress, newPromise());
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture deregister() {
        return deregister(newPromise());
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture disconnect() {
        return disconnect(newPromise());
    }

    final void setRemoved() {
        this.handlerState = 3;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture write(Object obj) {
        return write(obj, newPromise());
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture writeAndFlush(Object obj, ChannelPromise channelPromise) {
        write(obj, true, channelPromise);
        return channelPromise;
    }

    private boolean invokeHandler() {
        int i6 = this.handlerState;
        return i6 == 2 || (!this.ordered && i6 == 1);
    }

    private boolean isNotValidPromise(ChannelPromise channelPromise, boolean z5) {
        if (channelPromise == null) {
            throw new NullPointerException("promise");
        }
        if (channelPromise.isDone()) {
            if (channelPromise.isCancelled()) {
                return true;
            }
            throw new IllegalArgumentException("promise already done: " + channelPromise);
        }
        if (channelPromise.channel() != channel()) {
            throw new IllegalArgumentException(String.format("promise.channel does not match: %s (expected: %s)", channelPromise.channel(), channel()));
        }
        if (channelPromise.getClass() == DefaultChannelPromise.class) {
            return false;
        }
        if (!z5 && (channelPromise instanceof VoidChannelPromise)) {
            throw new IllegalArgumentException(StringUtil.simpleClassName((Class<?>) VoidChannelPromise.class) + " not allowed for this operation");
        }
        if (!(channelPromise instanceof AbstractChannel.CloseFuture)) {
            return false;
        }
        throw new IllegalArgumentException(StringUtil.simpleClassName((Class<?>) AbstractChannel.CloseFuture.class) + " not allowed in a pipeline");
    }

    private static void notifyOutboundHandlerException(Throwable th, ChannelPromise channelPromise) {
        PromiseNotificationUtil.tryFailure(channelPromise, th, channelPromise instanceof VoidChannelPromise ? null : logger);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture bind(final SocketAddress socketAddress, final ChannelPromise channelPromise) {
        if (socketAddress == null) {
            throw new NullPointerException("localAddress");
        }
        if (isNotValidPromise(channelPromise, false)) {
            return channelPromise;
        }
        final AbstractChannelHandlerContext findContextOutbound = findContextOutbound(512);
        EventExecutor executor = findContextOutbound.executor();
        if (executor.inEventLoop()) {
            findContextOutbound.invokeBind(socketAddress, channelPromise);
            return channelPromise;
        }
        safeExecute(executor, new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.8
            @Override // java.lang.Runnable
            public void run() {
                findContextOutbound.invokeBind(socketAddress, channelPromise);
            }
        }, channelPromise, null);
        return channelPromise;
    }

    final void callHandlerRemoved() throws Exception {
        try {
            if (this.handlerState == 2) {
                handler().handlerRemoved(this);
            }
        } finally {
            setRemoved();
        }
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public Channel channel() {
        return this.pipeline.channel();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture close(final ChannelPromise channelPromise) {
        if (isNotValidPromise(channelPromise, false)) {
            return channelPromise;
        }
        final AbstractChannelHandlerContext findContextOutbound = findContextOutbound(4096);
        EventExecutor executor = findContextOutbound.executor();
        if (executor.inEventLoop()) {
            findContextOutbound.invokeClose(channelPromise);
            return channelPromise;
        }
        safeExecute(executor, new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.11
            @Override // java.lang.Runnable
            public void run() {
                findContextOutbound.invokeClose(channelPromise);
            }
        }, channelPromise, null);
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2) {
        return connect(socketAddress, socketAddress2, newPromise());
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture deregister(final ChannelPromise channelPromise) {
        if (isNotValidPromise(channelPromise, false)) {
            return channelPromise;
        }
        final AbstractChannelHandlerContext findContextOutbound = findContextOutbound(8192);
        EventExecutor executor = findContextOutbound.executor();
        if (executor.inEventLoop()) {
            findContextOutbound.invokeDeregister(channelPromise);
            return channelPromise;
        }
        safeExecute(executor, new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.12
            @Override // java.lang.Runnable
            public void run() {
                findContextOutbound.invokeDeregister(channelPromise);
            }
        }, channelPromise, null);
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture disconnect(final ChannelPromise channelPromise) {
        if (!channel().metadata().hasDisconnect()) {
            return close(channelPromise);
        }
        if (isNotValidPromise(channelPromise, false)) {
            return channelPromise;
        }
        final AbstractChannelHandlerContext findContextOutbound = findContextOutbound(2048);
        EventExecutor executor = findContextOutbound.executor();
        if (executor.inEventLoop()) {
            findContextOutbound.invokeDisconnect(channelPromise);
            return channelPromise;
        }
        safeExecute(executor, new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.10
            @Override // java.lang.Runnable
            public void run() {
                findContextOutbound.invokeDisconnect(channelPromise);
            }
        }, channelPromise, null);
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public EventExecutor executor() {
        EventExecutor eventExecutor = this.executor;
        return eventExecutor == null ? channel().eventLoop() : eventExecutor;
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelActive() {
        invokeChannelActive(findContextInbound(8));
        return this;
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelInactive() {
        invokeChannelInactive(findContextInbound(16));
        return this;
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelRead(Object obj) {
        invokeChannelRead(findContextInbound(32), obj);
        return this;
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelReadComplete() {
        invokeChannelReadComplete(findContextInbound(64));
        return this;
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelRegistered() {
        invokeChannelRegistered(findContextInbound(2));
        return this;
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelUnregistered() {
        invokeChannelUnregistered(findContextInbound(4));
        return this;
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelWritabilityChanged() {
        invokeChannelWritabilityChanged(findContextInbound(256));
        return this;
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireExceptionCaught(Throwable th) {
        invokeExceptionCaught(findContextInbound(1), th);
        return this;
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireUserEventTriggered(Object obj) {
        invokeUserEventTriggered(findContextInbound(128), obj);
        return this;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelHandlerContext flush() {
        AbstractChannelHandlerContext findContextOutbound = findContextOutbound(65536);
        EventExecutor executor = findContextOutbound.executor();
        if (executor.inEventLoop()) {
            findContextOutbound.invokeFlush();
            return this;
        }
        Tasks tasks = findContextOutbound.invokeTasks;
        if (tasks == null) {
            tasks = new Tasks(findContextOutbound);
            findContextOutbound.invokeTasks = tasks;
        }
        safeExecute(executor, tasks.invokeFlushTask, channel().voidPromise(), null);
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public boolean isRemoved() {
        return this.handlerState == 3;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public String name() {
        return this.name;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture newFailedFuture(Throwable th) {
        return new FailedChannelFuture(channel(), executor(), th);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelProgressivePromise newProgressivePromise() {
        return new DefaultChannelProgressivePromise(channel(), executor());
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelPromise newPromise() {
        return new DefaultChannelPromise(channel(), executor());
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture newSucceededFuture() {
        ChannelFuture channelFuture = this.succeededFuture;
        if (channelFuture != null) {
            return channelFuture;
        }
        SucceededChannelFuture succeededChannelFuture = new SucceededChannelFuture(channel(), executor());
        this.succeededFuture = succeededChannelFuture;
        return succeededChannelFuture;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelPipeline pipeline() {
        return this.pipeline;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelHandlerContext read() {
        AbstractChannelHandlerContext findContextOutbound = findContextOutbound(16384);
        EventExecutor executor = findContextOutbound.executor();
        if (executor.inEventLoop()) {
            findContextOutbound.invokeRead();
            return this;
        }
        Tasks tasks = findContextOutbound.invokeTasks;
        if (tasks == null) {
            tasks = new Tasks(findContextOutbound);
            findContextOutbound.invokeTasks = tasks;
        }
        executor.execute(tasks.invokeReadTask);
        return this;
    }

    final boolean setAddComplete() {
        int i6;
        do {
            i6 = this.handlerState;
            if (i6 == 3) {
                return false;
            }
        } while (!HANDLER_STATE_UPDATER.compareAndSet(this, i6, 2));
        return true;
    }

    final void setAddPending() {
        HANDLER_STATE_UPDATER.compareAndSet(this, 0, 1);
    }

    @Override // io.netty.util.ResourceLeakHint
    public String toHintString() {
        return '\'' + this.name + "' will handle the message from this point.";
    }

    public String toString() {
        return StringUtil.simpleClassName((Class<?>) ChannelHandlerContext.class) + '(' + this.name + ", " + channel() + ')';
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture write(Object obj, ChannelPromise channelPromise) {
        write(obj, false, channelPromise);
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture writeAndFlush(Object obj) {
        return writeAndFlush(obj, newPromise());
    }

    AbstractChannelHandlerContext(DefaultChannelPipeline defaultChannelPipeline, EventExecutor eventExecutor, String str, Class<? extends ChannelHandler> cls) {
        this.name = (String) ObjectUtil.checkNotNull(str, CommonNetImpl.NAME);
        this.pipeline = defaultChannelPipeline;
        this.executor = eventExecutor;
        this.executionMask = ChannelHandlerMask.mask(cls);
        this.ordered = eventExecutor == null || (eventExecutor instanceof OrderedEventExecutor);
    }

    private static boolean inExceptionCaught(Throwable th) {
        do {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (stackTraceElement == null) {
                        break;
                    }
                    if ("exceptionCaught".equals(stackTraceElement.getMethodName())) {
                        return true;
                    }
                }
            }
            th = th.getCause();
        } while (th != null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeBind(SocketAddress socketAddress, ChannelPromise channelPromise) {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).bind(this, socketAddress, channelPromise);
                return;
            } catch (Throwable th) {
                notifyOutboundHandlerException(th, channelPromise);
                return;
            }
        }
        bind(socketAddress, channelPromise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeClose(ChannelPromise channelPromise) {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).close(this, channelPromise);
                return;
            } catch (Throwable th) {
                notifyOutboundHandlerException(th, channelPromise);
                return;
            }
        }
        close(channelPromise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeConnect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).connect(this, socketAddress, socketAddress2, channelPromise);
                return;
            } catch (Throwable th) {
                notifyOutboundHandlerException(th, channelPromise);
                return;
            }
        }
        connect(socketAddress, socketAddress2, channelPromise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeDeregister(ChannelPromise channelPromise) {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).deregister(this, channelPromise);
                return;
            } catch (Throwable th) {
                notifyOutboundHandlerException(th, channelPromise);
                return;
            }
        }
        deregister(channelPromise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeDisconnect(ChannelPromise channelPromise) {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).disconnect(this, channelPromise);
                return;
            } catch (Throwable th) {
                notifyOutboundHandlerException(th, channelPromise);
                return;
            }
        }
        disconnect(channelPromise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeFlush() {
        if (invokeHandler()) {
            invokeFlush0();
        } else {
            flush();
        }
    }

    private void invokeFlush0() {
        try {
            ((ChannelOutboundHandler) handler()).flush(this);
        } catch (Throwable th) {
            notifyHandlerException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeRead() {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).read(this);
                return;
            } catch (Throwable th) {
                notifyHandlerException(th);
                return;
            }
        }
        read();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeWrite(Object obj, ChannelPromise channelPromise) {
        if (invokeHandler()) {
            invokeWrite0(obj, channelPromise);
        } else {
            write(obj, channelPromise);
        }
    }

    private void invokeWrite0(Object obj, ChannelPromise channelPromise) {
        try {
            ((ChannelOutboundHandler) handler()).write(this, obj, channelPromise);
        } catch (Throwable th) {
            notifyOutboundHandlerException(th, channelPromise);
        }
    }

    private void invokeWriteAndFlush(Object obj, ChannelPromise channelPromise) {
        if (invokeHandler()) {
            invokeWrite0(obj, channelPromise);
            invokeFlush0();
        } else {
            writeAndFlush(obj, channelPromise);
        }
    }

    private void notifyHandlerException(Throwable th) {
        if (inExceptionCaught(th)) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isWarnEnabled()) {
                internalLogger.warn("An exception was thrown by a user handler while handling an exceptionCaught event", th);
                return;
            }
            return;
        }
        invokeExceptionCaught(th);
    }

    private static boolean safeExecute(EventExecutor eventExecutor, Runnable runnable, ChannelPromise channelPromise, Object obj) {
        try {
            eventExecutor.execute(runnable);
            return true;
        } catch (Throwable th) {
            try {
                channelPromise.setFailure(th);
            } finally {
                if (obj != null) {
                    ReferenceCountUtil.release(obj);
                }
            }
        }
    }

    private void write(Object obj, boolean z5, ChannelPromise channelPromise) {
        AbstractWriteTask newInstance;
        ObjectUtil.checkNotNull(obj, "msg");
        try {
            if (isNotValidPromise(channelPromise, true)) {
                ReferenceCountUtil.release(obj);
                return;
            }
            AbstractChannelHandlerContext findContextOutbound = findContextOutbound(z5 ? 98304 : 32768);
            Object obj2 = this.pipeline.touch(obj, findContextOutbound);
            EventExecutor executor = findContextOutbound.executor();
            if (executor.inEventLoop()) {
                if (z5) {
                    findContextOutbound.invokeWriteAndFlush(obj2, channelPromise);
                    return;
                } else {
                    findContextOutbound.invokeWrite(obj2, channelPromise);
                    return;
                }
            }
            if (z5) {
                newInstance = WriteAndFlushTask.newInstance(findContextOutbound, obj2, channelPromise);
            } else {
                newInstance = WriteTask.newInstance(findContextOutbound, obj2, channelPromise);
            }
            if (safeExecute(executor, newInstance, channelPromise, obj2)) {
                return;
            }
            newInstance.cancel();
        } catch (RuntimeException e6) {
            ReferenceCountUtil.release(obj);
            throw e6;
        }
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ByteBufAllocator alloc() {
        return channel().config().getAllocator();
    }

    @Override // io.netty.channel.ChannelHandlerContext, io.netty.util.AttributeMap
    public <T> Attribute<T> attr(AttributeKey<T> attributeKey) {
        return channel().attr(attributeKey);
    }

    final void callHandlerAdded() throws Exception {
        if (setAddComplete()) {
            handler().handlerAdded(this);
        }
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress, ChannelPromise channelPromise) {
        return connect(socketAddress, null, channelPromise);
    }

    @Override // io.netty.channel.ChannelHandlerContext, io.netty.util.AttributeMap
    public <T> boolean hasAttr(AttributeKey<T> attributeKey) {
        return channel().hasAttr(attributeKey);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelPromise voidPromise() {
        return channel().voidPromise();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(final SocketAddress socketAddress, final SocketAddress socketAddress2, final ChannelPromise channelPromise) {
        if (socketAddress != null) {
            if (isNotValidPromise(channelPromise, false)) {
                return channelPromise;
            }
            final AbstractChannelHandlerContext findContextOutbound = findContextOutbound(1024);
            EventExecutor executor = findContextOutbound.executor();
            if (executor.inEventLoop()) {
                findContextOutbound.invokeConnect(socketAddress, socketAddress2, channelPromise);
                return channelPromise;
            }
            safeExecute(executor, new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.9
                @Override // java.lang.Runnable
                public void run() {
                    findContextOutbound.invokeConnect(socketAddress, socketAddress2, channelPromise);
                }
            }, channelPromise, null);
            return channelPromise;
        }
        throw new NullPointerException("remoteAddress");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelActive() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelActive(this);
                return;
            } catch (Throwable th) {
                notifyHandlerException(th);
                return;
            }
        }
        fireChannelActive();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelInactive() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelInactive(this);
                return;
            } catch (Throwable th) {
                notifyHandlerException(th);
                return;
            }
        }
        fireChannelInactive();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelRegistered() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelRegistered(this);
                return;
            } catch (Throwable th) {
                notifyHandlerException(th);
                return;
            }
        }
        fireChannelRegistered();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelUnregistered() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelUnregistered(this);
                return;
            } catch (Throwable th) {
                notifyHandlerException(th);
                return;
            }
        }
        fireChannelUnregistered();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelRead(Object obj) {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelRead(this, obj);
                return;
            } catch (Throwable th) {
                notifyHandlerException(th);
                return;
            }
        }
        fireChannelRead(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeUserEventTriggered(Object obj) {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).userEventTriggered(this, obj);
                return;
            } catch (Throwable th) {
                notifyHandlerException(th);
                return;
            }
        }
        fireUserEventTriggered(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelReadComplete() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelReadComplete(this);
                return;
            } catch (Throwable th) {
                notifyHandlerException(th);
                return;
            }
        }
        fireChannelReadComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelWritabilityChanged() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelWritabilityChanged(this);
                return;
            } catch (Throwable th) {
                notifyHandlerException(th);
                return;
            }
        }
        fireChannelWritabilityChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeExceptionCaught(Throwable th) {
        if (invokeHandler()) {
            try {
                handler().exceptionCaught(this, th);
                return;
            } catch (Throwable th2) {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("An exception {}was thrown by a user handler's exceptionCaught() method while handling the following exception:", ThrowableUtil.stackTraceToString(th2), th);
                    return;
                } else {
                    if (internalLogger.isWarnEnabled()) {
                        internalLogger.warn("An exception '{}' [enable DEBUG level for full stacktrace] was thrown by a user handler's exceptionCaught() method while handling the following exception:", th2, th);
                        return;
                    }
                    return;
                }
            }
        }
        fireExceptionCaught(th);
    }
}
