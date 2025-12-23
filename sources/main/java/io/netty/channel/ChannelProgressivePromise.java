package io.netty.channel;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ProgressivePromise;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface ChannelProgressivePromise extends ProgressivePromise<Void>, ChannelProgressiveFuture, ChannelPromise {
    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ChannelProgressivePromise addListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener);

    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ChannelProgressivePromise addListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr);

    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ChannelProgressivePromise await() throws InterruptedException;

    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ChannelProgressivePromise awaitUninterruptibly();

    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ChannelProgressivePromise removeListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener);

    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ChannelProgressivePromise removeListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr);

    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.channel.ChannelPromise
    ChannelProgressivePromise setFailure(Throwable th);

    @Override // io.netty.util.concurrent.ProgressivePromise
    ProgressivePromise<Void> setProgress(long j6, long j7);

    @Override // io.netty.channel.ChannelPromise
    ChannelProgressivePromise setSuccess();

    @Override // io.netty.channel.ChannelPromise
    ChannelProgressivePromise setSuccess(Void r12);

    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ChannelProgressivePromise sync() throws InterruptedException;

    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ChannelProgressivePromise syncUninterruptibly();

    @Override // io.netty.channel.ChannelPromise
    ChannelProgressivePromise unvoid();
}
