package io.netty.channel;

import io.netty.channel.ChannelFlushPromiseNotifier;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultChannelPromise extends DefaultPromise<Void> implements ChannelPromise, ChannelFlushPromiseNotifier.FlushCheckpoint {
    private final Channel channel;
    private long checkpoint;

    public DefaultChannelPromise(Channel channel) {
        this.channel = (Channel) ObjectUtil.checkNotNull(channel, "channel");
    }

    @Override // io.netty.channel.ChannelFlushPromiseNotifier.FlushCheckpoint
    public long flushCheckpoint() {
        return this.checkpoint;
    }

    @Override // io.netty.channel.ChannelFuture
    public boolean isVoid() {
        return false;
    }

    public boolean trySuccess() {
        return trySuccess(null);
    }

    @Override // io.netty.channel.ChannelPromise, io.netty.channel.ChannelFuture
    public Channel channel() {
        return this.channel;
    }

    @Override // io.netty.channel.ChannelFlushPromiseNotifier.FlushCheckpoint
    public void flushCheckpoint(long j6) {
        this.checkpoint = j6;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise, io.netty.channel.ChannelPromise
    public ChannelPromise setFailure(Throwable th) {
        super.setFailure(th);
        return this;
    }

    public ChannelPromise setSuccess() {
        return setSuccess((Void) null);
    }

    public DefaultChannelPromise(Channel channel, EventExecutor eventExecutor) {
        super(eventExecutor);
        this.channel = (Channel) ObjectUtil.checkNotNull(channel, "channel");
    }

    @Override // io.netty.util.concurrent.DefaultPromise
    protected void checkDeadLock() {
        if (channel().isRegistered()) {
            super.checkDeadLock();
        }
    }

    @Override // io.netty.util.concurrent.DefaultPromise
    protected EventExecutor executor() {
        EventExecutor executor = super.executor();
        if (executor == null) {
            return channel().eventLoop();
        }
        return executor;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.ProgressivePromise
    public ChannelPromise setSuccess(Void r12) {
        super.setSuccess((DefaultChannelPromise) r12);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future<Void> addListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        super.addListener((GenericFutureListener) genericFutureListener);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future<Void> addListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        super.addListeners((GenericFutureListener[]) genericFutureListenerArr);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future<Void> await() throws InterruptedException {
        super.await();
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future<Void> awaitUninterruptibly() {
        super.awaitUninterruptibly();
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future<Void> removeListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        super.removeListener((GenericFutureListener) genericFutureListener);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future<Void> removeListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        super.removeListeners((GenericFutureListener[]) genericFutureListenerArr);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future<Void> sync() throws InterruptedException {
        super.sync();
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future<Void> syncUninterruptibly() {
        super.syncUninterruptibly();
        return this;
    }

    @Override // io.netty.channel.ChannelFlushPromiseNotifier.FlushCheckpoint
    public ChannelPromise promise() {
        return this;
    }

    @Override // io.netty.channel.ChannelPromise
    public ChannelPromise unvoid() {
        return this;
    }
}
