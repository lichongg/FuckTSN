package io.netty.channel.local;

import io.netty.channel.AbstractServerChannel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.EventLoop;
import io.netty.channel.PreferHeapByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.util.concurrent.SingleThreadEventExecutor;
import java.net.SocketAddress;
import java.util.ArrayDeque;
import java.util.Queue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class LocalServerChannel extends AbstractServerChannel {
    private volatile boolean acceptInProgress;
    private final ChannelConfig config;
    private final Queue<Object> inboundBuffer;
    private volatile LocalAddress localAddress;
    private final Runnable shutdownHook;
    private volatile int state;

    /* JADX INFO: Access modifiers changed from: private */
    public void serve0(LocalChannel localChannel) {
        this.inboundBuffer.add(localChannel);
        if (this.acceptInProgress) {
            this.acceptInProgress = false;
            readInbound();
        }
    }

    @Override // io.netty.channel.Channel
    public ChannelConfig config() {
        return this.config;
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBeginRead() throws Exception {
        if (this.acceptInProgress) {
            return;
        }
        if (this.inboundBuffer.isEmpty()) {
            this.acceptInProgress = true;
        } else {
            readInbound();
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        this.localAddress = LocalChannelRegistry.register(this, this.localAddress, socketAddress);
        this.state = 1;
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        if (this.state <= 1) {
            if (this.localAddress != null) {
                LocalChannelRegistry.unregister(this.localAddress);
                this.localAddress = null;
            }
            this.state = 2;
        }
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        return this.state == 1;
    }

    @Override // io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof SingleThreadEventLoop;
    }

    @Override // io.netty.channel.Channel
    public boolean isOpen() {
        return this.state < 2;
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public LocalAddress localAddress() {
        return (LocalAddress) super.localAddress();
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return this.localAddress;
    }

    protected LocalChannel newLocalChannel(LocalChannel localChannel) {
        return new LocalChannel(this, localChannel);
    }

    @Override // io.netty.channel.AbstractServerChannel, io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public LocalAddress remoteAddress() {
        return (LocalAddress) super.remoteAddress();
    }

    public LocalServerChannel() {
        DefaultChannelConfig defaultChannelConfig = new DefaultChannelConfig(this);
        this.config = defaultChannelConfig;
        this.inboundBuffer = new ArrayDeque();
        this.shutdownHook = new Runnable() { // from class: io.netty.channel.local.LocalServerChannel.1
            @Override // java.lang.Runnable
            public void run() {
                LocalServerChannel.this.unsafe().close(LocalServerChannel.this.unsafe().voidPromise());
            }
        };
        config().setAllocator(new PreferHeapByteBufAllocator(defaultChannelConfig.getAllocator()));
    }

    private void readInbound() {
        RecvByteBufAllocator.Handle recvBufAllocHandle = unsafe().recvBufAllocHandle();
        recvBufAllocHandle.reset(config());
        ChannelPipeline pipeline = pipeline();
        do {
            Object poll = this.inboundBuffer.poll();
            if (poll == null) {
                break;
            } else {
                pipeline.fireChannelRead(poll);
            }
        } while (recvBufAllocHandle.continueReading());
        pipeline.fireChannelReadComplete();
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doDeregister() throws Exception {
        ((SingleThreadEventExecutor) eventLoop()).removeShutdownHook(this.shutdownHook);
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doRegister() throws Exception {
        ((SingleThreadEventExecutor) eventLoop()).addShutdownHook(this.shutdownHook);
    }

    LocalChannel serve(LocalChannel localChannel) {
        final LocalChannel newLocalChannel = newLocalChannel(localChannel);
        if (eventLoop().inEventLoop()) {
            serve0(newLocalChannel);
            return newLocalChannel;
        }
        eventLoop().execute(new Runnable() { // from class: io.netty.channel.local.LocalServerChannel.2
            @Override // java.lang.Runnable
            public void run() {
                LocalServerChannel.this.serve0(newLocalChannel);
            }
        });
        return newLocalChannel;
    }
}
