package io.netty.channel.socket.oio;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.PreferHeapByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.DefaultSocketChannelConfig;
import io.netty.channel.socket.SocketChannel;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultOioSocketChannelConfig extends DefaultSocketChannelConfig implements OioSocketChannelConfig {
    @Deprecated
    public DefaultOioSocketChannelConfig(SocketChannel socketChannel, Socket socket) {
        super(socketChannel, socket);
        setAllocator((ByteBufAllocator) new PreferHeapByteBufAllocator(getAllocator()));
    }

    @Override // io.netty.channel.DefaultChannelConfig
    protected void autoReadCleared() {
        Channel channel = this.channel;
        if (channel instanceof OioSocketChannel) {
            ((OioSocketChannel) channel).clearReadPending0();
        }
    }

    @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        return channelOption == ChannelOption.SO_TIMEOUT ? (T) Integer.valueOf(getSoTimeout()) : (T) super.getOption(channelOption);
    }

    @Override // io.netty.channel.socket.oio.OioSocketChannelConfig
    public int getSoTimeout() {
        try {
            return this.javaSocket.getSoTimeout();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    public OioSocketChannelConfig setAllowHalfClosure(boolean z5) {
        super.setAllowHalfClosure(z5);
        return this;
    }

    @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    public OioSocketChannelConfig setKeepAlive(boolean z5) {
        super.setKeepAlive(z5);
        return this;
    }

    @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    public OioSocketChannelConfig setPerformancePreferences(int i6, int i7, int i8) {
        super.setPerformancePreferences(i6, i7, i8);
        return this;
    }

    @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    public OioSocketChannelConfig setReceiveBufferSize(int i6) {
        super.setReceiveBufferSize(i6);
        return this;
    }

    @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    public OioSocketChannelConfig setReuseAddress(boolean z5) {
        super.setReuseAddress(z5);
        return this;
    }

    @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    public OioSocketChannelConfig setSendBufferSize(int i6) {
        super.setSendBufferSize(i6);
        return this;
    }

    @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    public OioSocketChannelConfig setSoLinger(int i6) {
        super.setSoLinger(i6);
        return this;
    }

    @Override // io.netty.channel.socket.oio.OioSocketChannelConfig
    public OioSocketChannelConfig setSoTimeout(int i6) {
        try {
            this.javaSocket.setSoTimeout(i6);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    public OioSocketChannelConfig setTcpNoDelay(boolean z5) {
        super.setTcpNoDelay(z5);
        return this;
    }

    @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    public OioSocketChannelConfig setTrafficClass(int i6) {
        super.setTrafficClass(i6);
        return this;
    }

    DefaultOioSocketChannelConfig(OioSocketChannel oioSocketChannel, Socket socket) {
        super(oioSocketChannel, socket);
        setAllocator((ByteBufAllocator) new PreferHeapByteBufAllocator(getAllocator()));
    }

    @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), ChannelOption.SO_TIMEOUT);
    }

    @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public OioSocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public OioSocketChannelConfig setAutoClose(boolean z5) {
        super.setAutoClose(z5);
        return this;
    }

    @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public OioSocketChannelConfig setAutoRead(boolean z5) {
        super.setAutoRead(z5);
        return this;
    }

    @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public OioSocketChannelConfig setConnectTimeoutMillis(int i6) {
        super.setConnectTimeoutMillis(i6);
        return this;
    }

    @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public OioSocketChannelConfig setMaxMessagesPerRead(int i6) {
        super.setMaxMessagesPerRead(i6);
        return this;
    }

    @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public OioSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> channelOption, T t5) {
        validate(channelOption, t5);
        if (channelOption == ChannelOption.SO_TIMEOUT) {
            setSoTimeout(((Integer) t5).intValue());
            return true;
        }
        return super.setOption(channelOption, t5);
    }

    @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public OioSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public OioSocketChannelConfig setWriteBufferHighWaterMark(int i6) {
        super.setWriteBufferHighWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public OioSocketChannelConfig setWriteBufferLowWaterMark(int i6) {
        super.setWriteBufferLowWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public OioSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public OioSocketChannelConfig setWriteSpinCount(int i6) {
        super.setWriteSpinCount(i6);
        return this;
    }
}
