package io.netty.channel.nio;

import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.ServerChannel;
import io.netty.channel.nio.AbstractNioChannel;
import java.io.IOException;
import java.net.PortUnreachableException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractNioMessageChannel extends AbstractNioChannel {
    boolean inputShutdown;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.channel.nio.AbstractNioMessageChannel$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class NioMessageUnsafe extends AbstractNioChannel.AbstractNioUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final List<Object> readBuf;

        private NioMessageUnsafe() {
            super();
            this.readBuf = new ArrayList();
        }

        @Override // io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        public void read() {
            Throwable th;
            boolean z5;
            ChannelConfig config = AbstractNioMessageChannel.this.config();
            ChannelPipeline pipeline = AbstractNioMessageChannel.this.pipeline();
            RecvByteBufAllocator.Handle recvBufAllocHandle = AbstractNioMessageChannel.this.unsafe().recvBufAllocHandle();
            recvBufAllocHandle.reset(config);
            do {
                try {
                    int doReadMessages = AbstractNioMessageChannel.this.doReadMessages(this.readBuf);
                    if (doReadMessages == 0) {
                        break;
                    }
                    if (doReadMessages < 0) {
                        z5 = true;
                        break;
                    }
                    recvBufAllocHandle.incMessagesRead(doReadMessages);
                } catch (Throwable th2) {
                    th = th2;
                    z5 = false;
                }
            } while (recvBufAllocHandle.continueReading());
            z5 = false;
            th = null;
            try {
                int size = this.readBuf.size();
                for (int i6 = 0; i6 < size; i6++) {
                    AbstractNioMessageChannel.this.readPending = false;
                    pipeline.fireChannelRead(this.readBuf.get(i6));
                }
                this.readBuf.clear();
                recvBufAllocHandle.readComplete();
                pipeline.fireChannelReadComplete();
                if (th != null) {
                    z5 = AbstractNioMessageChannel.this.closeOnReadError(th);
                    pipeline.fireExceptionCaught(th);
                }
                if (z5) {
                    AbstractNioMessageChannel abstractNioMessageChannel = AbstractNioMessageChannel.this;
                    abstractNioMessageChannel.inputShutdown = true;
                    if (abstractNioMessageChannel.isOpen()) {
                        close(voidPromise());
                    }
                }
                if (AbstractNioMessageChannel.this.readPending || config.isAutoRead()) {
                    return;
                }
                removeReadOp();
            } catch (Throwable th3) {
                if (!AbstractNioMessageChannel.this.readPending && !config.isAutoRead()) {
                    removeReadOp();
                }
                throw th3;
            }
        }

        /* synthetic */ NioMessageUnsafe(AbstractNioMessageChannel abstractNioMessageChannel, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    protected boolean continueOnWriteError() {
        return false;
    }

    protected abstract int doReadMessages(List<Object> list) throws Exception;

    protected abstract boolean doWriteMessage(Object obj, ChannelOutboundBuffer channelOutboundBuffer) throws Exception;

    @Override // io.netty.channel.nio.AbstractNioChannel, io.netty.channel.AbstractChannel
    protected void doBeginRead() throws Exception {
        if (this.inputShutdown) {
            return;
        }
        super.doBeginRead();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.AbstractChannel
    public AbstractNioChannel.AbstractNioUnsafe newUnsafe() {
        return new NioMessageUnsafe(this, null);
    }

    protected AbstractNioMessageChannel(Channel channel, SelectableChannel selectableChannel, int i6) {
        super(channel, selectableChannel, i6);
    }

    protected boolean closeOnReadError(Throwable th) {
        if (!isActive()) {
            return true;
        }
        if (th instanceof PortUnreachableException) {
            return false;
        }
        if (!(th instanceof IOException)) {
            return true;
        }
        return !(this instanceof ServerChannel);
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        int writeSpinCount;
        SelectionKey selectionKey = selectionKey();
        int interestOps = selectionKey.interestOps();
        while (true) {
            Object current = channelOutboundBuffer.current();
            if (current == null) {
                if ((interestOps & 4) != 0) {
                    selectionKey.interestOps(interestOps & (-5));
                    return;
                }
                return;
            }
            try {
            } catch (Exception e6) {
                if (continueOnWriteError()) {
                    channelOutboundBuffer.remove(e6);
                } else {
                    throw e6;
                }
            }
            for (writeSpinCount = config().getWriteSpinCount() - 1; writeSpinCount >= 0; writeSpinCount--) {
                if (doWriteMessage(current, channelOutboundBuffer)) {
                    channelOutboundBuffer.remove();
                }
            }
            if ((interestOps & 4) == 0) {
                selectionKey.interestOps(interestOps | 4);
                return;
            }
            return;
        }
    }
}
