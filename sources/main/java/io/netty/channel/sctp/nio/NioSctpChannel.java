package io.netty.channel.sctp.nio;

import com.sun.nio.sctp.Association;
import com.sun.nio.sctp.MessageInfo;
import com.sun.nio.sctp.NotificationHandler;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.nio.AbstractNioMessageChannel;
import io.netty.channel.sctp.DefaultSctpChannelConfig;
import io.netty.channel.sctp.SctpChannel;
import io.netty.channel.sctp.SctpChannelConfig;
import io.netty.channel.sctp.SctpMessage;
import io.netty.channel.sctp.SctpNotificationHandler;
import io.netty.channel.sctp.SctpServerChannel;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class NioSctpChannel extends AbstractNioMessageChannel implements SctpChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false);
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) NioSctpChannel.class);
    private final SctpChannelConfig config;
    private final NotificationHandler<?> notificationHandler;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class NioSctpChannelConfig extends DefaultSctpChannelConfig {
        private NioSctpChannelConfig(NioSctpChannel nioSctpChannel, com.sun.nio.sctp.SctpChannel sctpChannel) {
            super(nioSctpChannel, sctpChannel);
        }

        @Override // io.netty.channel.DefaultChannelConfig
        protected void autoReadCleared() {
            NioSctpChannel.this.clearReadPending();
        }
    }

    public NioSctpChannel() {
        this(newSctpChannel());
    }

    @Override // io.netty.channel.sctp.SctpChannel
    public ChannelFuture bindAddress(InetAddress inetAddress) {
        return bindAddress(inetAddress, newPromise());
    }

    @Override // io.netty.channel.sctp.SctpChannel
    public ChannelFuture unbindAddress(InetAddress inetAddress) {
        return unbindAddress(inetAddress, newPromise());
    }

    public NioSctpChannel(com.sun.nio.sctp.SctpChannel sctpChannel) {
        this(null, sctpChannel);
    }

    @Override // io.netty.channel.sctp.SctpChannel
    public ChannelFuture bindAddress(final InetAddress inetAddress, final ChannelPromise channelPromise) {
        if (!eventLoop().inEventLoop()) {
            eventLoop().execute(new Runnable() { // from class: io.netty.channel.sctp.nio.NioSctpChannel.1
                @Override // java.lang.Runnable
                public void run() {
                    NioSctpChannel.this.bindAddress(inetAddress, channelPromise);
                }
            });
            return channelPromise;
        }
        try {
            mo128javaChannel().bindAddress(inetAddress);
            channelPromise.setSuccess();
            return channelPromise;
        } catch (Throwable th) {
            channelPromise.setFailure(th);
            return channelPromise;
        }
    }

    @Override // io.netty.channel.Channel
    public SctpChannelConfig config() {
        return this.config;
    }

    @Override // io.netty.channel.nio.AbstractNioChannel
    protected boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (socketAddress2 != null) {
            mo128javaChannel().bind(socketAddress2);
        }
        try {
            boolean connect = mo128javaChannel().connect(socketAddress);
            if (!connect) {
                selectionKey().interestOps(8);
            }
            return connect;
        } catch (Throwable th) {
            doClose();
            throw th;
        }
    }

    @Override // io.netty.channel.nio.AbstractNioMessageChannel
    protected boolean doWriteMessage(Object obj, ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        SctpMessage sctpMessage = (SctpMessage) obj;
        ByteBuf content = sctpMessage.content();
        int readableBytes = content.readableBytes();
        if (readableBytes == 0) {
            return true;
        }
        ByteBufAllocator alloc = alloc();
        boolean z5 = content.nioBufferCount() != 1;
        if (!z5 && !content.isDirect() && alloc.isDirectBufferPooled()) {
            z5 = true;
        }
        if (z5) {
            content = alloc.directBuffer(readableBytes).writeBytes(content);
        }
        ByteBuffer nioBuffer = content.nioBuffer();
        MessageInfo createOutgoing = MessageInfo.createOutgoing(association(), (SocketAddress) null, sctpMessage.streamIdentifier());
        createOutgoing.payloadProtocolID(sctpMessage.protocolIdentifier());
        createOutgoing.streamNumber(sctpMessage.streamIdentifier());
        createOutgoing.unordered(sctpMessage.isUnordered());
        return mo128javaChannel().send(nioBuffer, createOutgoing) > 0;
    }

    @Override // io.netty.channel.AbstractChannel
    protected final Object filterOutboundMessage(Object obj) throws Exception {
        if (obj instanceof SctpMessage) {
            SctpMessage sctpMessage = (SctpMessage) obj;
            ByteBuf content = sctpMessage.content();
            return (content.isDirect() && content.nioBufferCount() == 1) ? sctpMessage : new SctpMessage(sctpMessage.protocolIdentifier(), sctpMessage.streamIdentifier(), sctpMessage.isUnordered(), newDirectBuffer(sctpMessage, content));
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + " (expected: " + StringUtil.simpleClassName((Class<?>) SctpMessage.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.nio.AbstractNioChannel
    /* renamed from: javaChannel, reason: merged with bridge method [inline-methods] */
    public com.sun.nio.sctp.SctpChannel mo128javaChannel() {
        return super.mo128javaChannel();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public SctpServerChannel parent() {
        return (SctpServerChannel) super.parent();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    @Override // io.netty.channel.sctp.SctpChannel
    public ChannelFuture unbindAddress(final InetAddress inetAddress, final ChannelPromise channelPromise) {
        if (!eventLoop().inEventLoop()) {
            eventLoop().execute(new Runnable() { // from class: io.netty.channel.sctp.nio.NioSctpChannel.2
                @Override // java.lang.Runnable
                public void run() {
                    NioSctpChannel.this.unbindAddress(inetAddress, channelPromise);
                }
            });
            return channelPromise;
        }
        try {
            mo128javaChannel().unbindAddress(inetAddress);
            channelPromise.setSuccess();
            return channelPromise;
        } catch (Throwable th) {
            channelPromise.setFailure(th);
            return channelPromise;
        }
    }

    public NioSctpChannel(Channel channel, com.sun.nio.sctp.SctpChannel sctpChannel) {
        super(channel, sctpChannel, 1);
        try {
            sctpChannel.configureBlocking(false);
            this.config = new NioSctpChannelConfig(this, sctpChannel);
            this.notificationHandler = new SctpNotificationHandler(this);
        } catch (IOException e6) {
            try {
                sctpChannel.close();
            } catch (IOException e7) {
                if (logger.isWarnEnabled()) {
                    logger.warn("Failed to close a partially initialized sctp channel.", (Throwable) e7);
                }
            }
            throw new ChannelException("Failed to enter non-blocking mode.", e6);
        }
    }

    private static com.sun.nio.sctp.SctpChannel newSctpChannel() {
        try {
            return com.sun.nio.sctp.SctpChannel.open();
        } catch (IOException e6) {
            throw new ChannelException("Failed to open a sctp channel.", e6);
        }
    }

    @Override // io.netty.channel.sctp.SctpChannel
    public Set<InetSocketAddress> allLocalAddresses() {
        try {
            Set allLocalAddresses = mo128javaChannel().getAllLocalAddresses();
            LinkedHashSet linkedHashSet = new LinkedHashSet(allLocalAddresses.size());
            Iterator it = allLocalAddresses.iterator();
            while (it.hasNext()) {
                linkedHashSet.add((InetSocketAddress) ((SocketAddress) it.next()));
            }
            return linkedHashSet;
        } catch (Throwable unused) {
            return Collections.EMPTY_SET;
        }
    }

    @Override // io.netty.channel.sctp.SctpChannel
    public Set<InetSocketAddress> allRemoteAddresses() {
        try {
            Set remoteAddresses = mo128javaChannel().getRemoteAddresses();
            HashSet hashSet = new HashSet(remoteAddresses.size());
            Iterator it = remoteAddresses.iterator();
            while (it.hasNext()) {
                hashSet.add((InetSocketAddress) ((SocketAddress) it.next()));
            }
            return hashSet;
        } catch (Throwable unused) {
            return Collections.EMPTY_SET;
        }
    }

    @Override // io.netty.channel.sctp.SctpChannel
    public Association association() {
        try {
            return mo128javaChannel().association();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        mo128javaChannel().bind(socketAddress);
    }

    @Override // io.netty.channel.nio.AbstractNioChannel, io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        mo128javaChannel().close();
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        doClose();
    }

    @Override // io.netty.channel.nio.AbstractNioChannel
    protected void doFinishConnect() throws Exception {
        if (mo128javaChannel().finishConnect()) {
        } else {
            throw new Error();
        }
    }

    @Override // io.netty.channel.nio.AbstractNioMessageChannel
    protected int doReadMessages(List<Object> list) throws Exception {
        com.sun.nio.sctp.SctpChannel mo128javaChannel = mo128javaChannel();
        RecvByteBufAllocator.Handle recvBufAllocHandle = unsafe().recvBufAllocHandle();
        ByteBuf allocate = recvBufAllocHandle.allocate(config().getAllocator());
        try {
            ByteBuffer internalNioBuffer = allocate.internalNioBuffer(allocate.writerIndex(), allocate.writableBytes());
            int position = internalNioBuffer.position();
            MessageInfo receive = mo128javaChannel.receive(internalNioBuffer, (Object) null, this.notificationHandler);
            if (receive == null) {
                allocate.release();
                return 0;
            }
            recvBufAllocHandle.lastBytesRead(internalNioBuffer.position() - position);
            list.add(new SctpMessage(receive, allocate.writerIndex(allocate.writerIndex() + recvBufAllocHandle.lastBytesRead())));
            return 1;
        } catch (Throwable th) {
            try {
                PlatformDependent.throwException(th);
                allocate.release();
                return -1;
            } catch (Throwable th2) {
                allocate.release();
                throw th2;
            }
        }
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        if (mo128javaChannel().isOpen() && association() != null) {
            return true;
        }
        return false;
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        try {
            Iterator it = mo128javaChannel().getAllLocalAddresses().iterator();
            if (it.hasNext()) {
                return (SocketAddress) it.next();
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        try {
            Iterator it = mo128javaChannel().getRemoteAddresses().iterator();
            if (it.hasNext()) {
                return (SocketAddress) it.next();
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }
}
