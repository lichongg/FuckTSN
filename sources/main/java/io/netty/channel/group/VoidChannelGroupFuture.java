package io.netty.channel.group;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class VoidChannelGroupFuture implements ChannelGroupFuture {
    private static final Iterator<ChannelFuture> EMPTY = Collections.EMPTY_LIST.iterator();
    private final ChannelGroup group;

    @Override // io.netty.util.concurrent.Future, java.util.concurrent.Future
    public boolean cancel(boolean z5) {
        return false;
    }

    @Override // io.netty.util.concurrent.Future
    public ChannelGroupException cause() {
        return null;
    }

    @Override // io.netty.channel.group.ChannelGroupFuture
    public ChannelFuture find(Channel channel) {
        return null;
    }

    @Override // io.netty.util.concurrent.Future
    public Void getNow() {
        return null;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean isCancellable() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return false;
    }

    @Override // io.netty.channel.group.ChannelGroupFuture
    public boolean isPartialFailure() {
        return false;
    }

    @Override // io.netty.channel.group.ChannelGroupFuture
    public boolean isPartialSuccess() {
        return false;
    }

    @Override // io.netty.channel.group.ChannelGroupFuture, io.netty.util.concurrent.Future
    public boolean isSuccess() {
        return false;
    }

    private static RuntimeException reject() {
        return new IllegalStateException("void future");
    }

    @Override // io.netty.util.concurrent.Future
    public Future<Void> addListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        throw reject();
    }

    @Override // io.netty.util.concurrent.Future
    public Future<Void> addListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        throw reject();
    }

    @Override // io.netty.util.concurrent.Future
    public Future<Void> await() {
        throw reject();
    }

    @Override // io.netty.util.concurrent.Future
    public Future<Void> awaitUninterruptibly() {
        throw reject();
    }

    @Override // io.netty.channel.group.ChannelGroupFuture
    public ChannelGroup group() {
        return this.group;
    }

    @Override // io.netty.channel.group.ChannelGroupFuture, java.lang.Iterable
    public Iterator<ChannelFuture> iterator() {
        return EMPTY;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<Void> removeListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        throw reject();
    }

    @Override // io.netty.util.concurrent.Future
    public Future<Void> removeListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        throw reject();
    }

    @Override // io.netty.util.concurrent.Future
    public Future<Void> sync() {
        throw reject();
    }

    @Override // io.netty.util.concurrent.Future
    public Future<Void> syncUninterruptibly() {
        throw reject();
    }

    VoidChannelGroupFuture(ChannelGroup channelGroup) {
        this.group = channelGroup;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean await(long j6, TimeUnit timeUnit) {
        throw reject();
    }

    @Override // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long j6, TimeUnit timeUnit) {
        throw reject();
    }

    @Override // java.util.concurrent.Future
    public Void get() {
        throw reject();
    }

    @Override // io.netty.util.concurrent.Future
    public boolean await(long j6) {
        throw reject();
    }

    @Override // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long j6) {
        throw reject();
    }

    @Override // java.util.concurrent.Future
    public Void get(long j6, TimeUnit timeUnit) {
        throw reject();
    }
}
