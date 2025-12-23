package io.netty.channel;

import io.netty.util.concurrent.CompleteFuture;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
abstract class CompleteChannelFuture extends CompleteFuture<Void> implements ChannelFuture {
    private final Channel channel;

    @Override // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future<Void> await() throws InterruptedException {
        return this;
    }

    @Override // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future<Void> awaitUninterruptibly() {
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Void getNow() {
        return null;
    }

    @Override // io.netty.channel.ChannelFuture
    public boolean isVoid() {
        return false;
    }

    @Override // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future<Void> sync() throws InterruptedException {
        return this;
    }

    @Override // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future<Void> syncUninterruptibly() {
        return this;
    }

    @Override // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future<Void> addListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        super.addListener((GenericFutureListener) genericFutureListener);
        return this;
    }

    @Override // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future<Void> addListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        super.addListeners((GenericFutureListener[]) genericFutureListenerArr);
        return this;
    }

    @Override // io.netty.channel.ChannelFuture
    public Channel channel() {
        return this.channel;
    }

    @Override // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future<Void> removeListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        super.removeListener((GenericFutureListener) genericFutureListener);
        return this;
    }

    @Override // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future<Void> removeListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        super.removeListeners((GenericFutureListener[]) genericFutureListenerArr);
        return this;
    }

    protected CompleteChannelFuture(Channel channel, EventExecutor eventExecutor) {
        super(eventExecutor);
        if (channel != null) {
            this.channel = channel;
            return;
        }
        throw new NullPointerException("channel");
    }

    @Override // io.netty.util.concurrent.CompleteFuture
    protected EventExecutor executor() {
        EventExecutor executor = super.executor();
        if (executor == null) {
            return channel().eventLoop();
        }
        return executor;
    }
}
