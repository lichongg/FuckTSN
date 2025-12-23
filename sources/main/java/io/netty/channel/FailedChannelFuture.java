package io.netty.channel;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.internal.PlatformDependent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class FailedChannelFuture extends CompleteChannelFuture {
    private final Throwable cause;

    @Override // io.netty.util.concurrent.Future
    public boolean isSuccess() {
        return false;
    }

    @Override // io.netty.util.concurrent.Future
    public Throwable cause() {
        return this.cause;
    }

    @Override // io.netty.channel.CompleteChannelFuture, io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future<Void> sync() {
        PlatformDependent.throwException(this.cause);
        return this;
    }

    @Override // io.netty.channel.CompleteChannelFuture, io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future<Void> syncUninterruptibly() {
        PlatformDependent.throwException(this.cause);
        return this;
    }

    FailedChannelFuture(Channel channel, EventExecutor eventExecutor, Throwable th) {
        super(channel, eventExecutor);
        if (th != null) {
            this.cause = th;
            return;
        }
        throw new NullPointerException("cause");
    }
}
