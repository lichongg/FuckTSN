package io.netty.channel;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PromiseNotificationUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class DelegatingChannelPromiseNotifier implements ChannelPromise, ChannelFutureListener {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DelegatingChannelPromiseNotifier.class);
    private final ChannelPromise delegate;
    private final boolean logNotifyFailure;

    public DelegatingChannelPromiseNotifier(ChannelPromise channelPromise) {
        this(channelPromise, !(channelPromise instanceof VoidChannelPromise));
    }

    public DelegatingChannelPromiseNotifier(ChannelPromise channelPromise, boolean z5) {
        this.delegate = (ChannelPromise) ObjectUtil.checkNotNull(channelPromise, "delegate");
        this.logNotifyFailure = z5;
    }

    @Override // io.netty.util.concurrent.Future, java.util.concurrent.Future
    public boolean cancel(boolean z5) {
        return this.delegate.cancel(z5);
    }

    @Override // io.netty.util.concurrent.Future
    public Throwable cause() {
        return this.delegate.cause();
    }

    @Override // io.netty.channel.ChannelPromise, io.netty.channel.ChannelFuture
    public Channel channel() {
        return this.delegate.channel();
    }

    @Override // io.netty.util.concurrent.Future
    public Void getNow() {
        return this.delegate.getNow();
    }

    @Override // io.netty.util.concurrent.Future
    public boolean isCancellable() {
        return this.delegate.isCancellable();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.delegate.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.delegate.isDone();
    }

    @Override // io.netty.util.concurrent.Future
    public boolean isSuccess() {
        return this.delegate.isSuccess();
    }

    @Override // io.netty.channel.ChannelFuture
    public boolean isVoid() {
        return this.delegate.isVoid();
    }

    @Override // io.netty.util.concurrent.GenericFutureListener
    public void operationComplete(ChannelFuture channelFuture) throws Exception {
        InternalLogger internalLogger = this.logNotifyFailure ? logger : null;
        if (channelFuture.isSuccess()) {
            PromiseNotificationUtil.trySuccess(this.delegate, channelFuture.get(), internalLogger);
        } else if (channelFuture.isCancelled()) {
            PromiseNotificationUtil.tryCancel(this.delegate, internalLogger);
        } else {
            PromiseNotificationUtil.tryFailure(this.delegate, channelFuture.cause(), internalLogger);
        }
    }

    @Override // io.netty.util.concurrent.Promise, io.netty.channel.ChannelPromise
    public ChannelPromise setFailure(Throwable th) {
        this.delegate.setFailure(th);
        return this;
    }

    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.ProgressivePromise
    public ChannelPromise setSuccess(Void r22) {
        this.delegate.setSuccess(r22);
        return this;
    }

    @Override // io.netty.util.concurrent.Promise
    public boolean setUncancellable() {
        return this.delegate.setUncancellable();
    }

    @Override // io.netty.util.concurrent.Promise
    public boolean tryFailure(Throwable th) {
        return this.delegate.tryFailure(th);
    }

    @Override // io.netty.channel.ChannelPromise
    public boolean trySuccess() {
        return this.delegate.trySuccess();
    }

    @Override // java.util.concurrent.Future
    public Void get() throws InterruptedException, ExecutionException {
        return this.delegate.get();
    }

    @Override // io.netty.channel.ChannelPromise
    public ChannelPromise setSuccess() {
        this.delegate.setSuccess();
        return this;
    }

    @Override // io.netty.util.concurrent.Promise
    public boolean trySuccess(Void r22) {
        return this.delegate.trySuccess(r22);
    }

    @Override // io.netty.channel.ChannelPromise
    public ChannelPromise unvoid() {
        if (isVoid()) {
            return new DelegatingChannelPromiseNotifier(this.delegate.unvoid());
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<Void> addListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        this.delegate.addListener(genericFutureListener);
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<Void> addListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        this.delegate.addListeners(genericFutureListenerArr);
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<Void> await() throws InterruptedException {
        this.delegate.await();
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<Void> awaitUninterruptibly() {
        this.delegate.awaitUninterruptibly();
        return this;
    }

    @Override // java.util.concurrent.Future
    public Void get(long j6, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.delegate.get(j6, timeUnit);
    }

    @Override // io.netty.util.concurrent.Future
    public Future<Void> removeListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        this.delegate.removeListener(genericFutureListener);
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<Void> removeListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        this.delegate.removeListeners(genericFutureListenerArr);
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<Void> sync() throws InterruptedException {
        this.delegate.sync();
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<Void> syncUninterruptibly() {
        this.delegate.syncUninterruptibly();
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean await(long j6, TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.await(j6, timeUnit);
    }

    @Override // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long j6, TimeUnit timeUnit) {
        return this.delegate.awaitUninterruptibly(j6, timeUnit);
    }

    @Override // io.netty.util.concurrent.Future
    public boolean await(long j6) throws InterruptedException {
        return this.delegate.await(j6);
    }

    @Override // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long j6) {
        return this.delegate.awaitUninterruptibly(j6);
    }
}
