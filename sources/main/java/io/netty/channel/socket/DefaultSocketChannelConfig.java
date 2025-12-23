package io.netty.channel.socket;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.util.internal.PlatformDependent;
import java.net.Socket;
import java.net.SocketException;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultSocketChannelConfig extends DefaultChannelConfig implements SocketChannelConfig {
    private volatile boolean allowHalfClosure;
    protected final Socket javaSocket;

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        return channelOption == ChannelOption.SO_RCVBUF ? (T) Integer.valueOf(getReceiveBufferSize()) : channelOption == ChannelOption.SO_SNDBUF ? (T) Integer.valueOf(getSendBufferSize()) : channelOption == ChannelOption.TCP_NODELAY ? (T) Boolean.valueOf(isTcpNoDelay()) : channelOption == ChannelOption.SO_KEEPALIVE ? (T) Boolean.valueOf(isKeepAlive()) : channelOption == ChannelOption.SO_REUSEADDR ? (T) Boolean.valueOf(isReuseAddress()) : channelOption == ChannelOption.SO_LINGER ? (T) Integer.valueOf(getSoLinger()) : channelOption == ChannelOption.IP_TOS ? (T) Integer.valueOf(getTrafficClass()) : channelOption == ChannelOption.ALLOW_HALF_CLOSURE ? (T) Boolean.valueOf(isAllowHalfClosure()) : (T) super.getOption(channelOption);
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public int getReceiveBufferSize() {
        try {
            return this.javaSocket.getReceiveBufferSize();
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public int getSendBufferSize() {
        try {
            return this.javaSocket.getSendBufferSize();
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public int getSoLinger() {
        try {
            return this.javaSocket.getSoLinger();
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public int getTrafficClass() {
        try {
            return this.javaSocket.getTrafficClass();
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public boolean isAllowHalfClosure() {
        return this.allowHalfClosure;
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public boolean isKeepAlive() {
        try {
            return this.javaSocket.getKeepAlive();
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public boolean isReuseAddress() {
        try {
            return this.javaSocket.getReuseAddress();
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public boolean isTcpNoDelay() {
        try {
            return this.javaSocket.getTcpNoDelay();
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setAllowHalfClosure(boolean z5) {
        this.allowHalfClosure = z5;
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SocketChannelConfig setAutoClose(boolean z5) {
        super.setAutoClose(z5);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SocketChannelConfig setAutoRead(boolean z5) {
        super.setAutoRead(z5);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SocketChannelConfig setConnectTimeoutMillis(int i6) {
        super.setConnectTimeoutMillis(i6);
        return this;
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setKeepAlive(boolean z5) {
        try {
            this.javaSocket.setKeepAlive(z5);
            return this;
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public SocketChannelConfig setMaxMessagesPerRead(int i6) {
        super.setMaxMessagesPerRead(i6);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setPerformancePreferences(int i6, int i7, int i8) {
        this.javaSocket.setPerformancePreferences(i6, i7, i8);
        return this;
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setReceiveBufferSize(int i6) {
        try {
            this.javaSocket.setReceiveBufferSize(i6);
            return this;
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setReuseAddress(boolean z5) {
        try {
            this.javaSocket.setReuseAddress(z5);
            return this;
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setSendBufferSize(int i6) {
        try {
            this.javaSocket.setSendBufferSize(i6);
            return this;
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setSoLinger(int i6) {
        try {
            if (i6 < 0) {
                this.javaSocket.setSoLinger(false, 0);
                return this;
            }
            this.javaSocket.setSoLinger(true, i6);
            return this;
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setTcpNoDelay(boolean z5) {
        try {
            this.javaSocket.setTcpNoDelay(z5);
            return this;
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setTrafficClass(int i6) {
        try {
            this.javaSocket.setTrafficClass(i6);
            return this;
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SocketChannelConfig setWriteBufferHighWaterMark(int i6) {
        super.setWriteBufferHighWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SocketChannelConfig setWriteBufferLowWaterMark(int i6) {
        super.setWriteBufferLowWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SocketChannelConfig setWriteSpinCount(int i6) {
        super.setWriteSpinCount(i6);
        return this;
    }

    public DefaultSocketChannelConfig(SocketChannel socketChannel, Socket socket) {
        super(socketChannel);
        if (socket != null) {
            this.javaSocket = socket;
            if (PlatformDependent.canEnableTcpNoDelayByDefault()) {
                try {
                    setTcpNoDelay(true);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            return;
        }
        throw new NullPointerException("javaSocket");
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), ChannelOption.SO_RCVBUF, ChannelOption.SO_SNDBUF, ChannelOption.TCP_NODELAY, ChannelOption.SO_KEEPALIVE, ChannelOption.SO_REUSEADDR, ChannelOption.SO_LINGER, ChannelOption.IP_TOS, ChannelOption.ALLOW_HALF_CLOSURE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> channelOption, T t5) {
        validate(channelOption, t5);
        if (channelOption == ChannelOption.SO_RCVBUF) {
            setReceiveBufferSize(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == ChannelOption.SO_SNDBUF) {
            setSendBufferSize(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == ChannelOption.TCP_NODELAY) {
            setTcpNoDelay(((Boolean) t5).booleanValue());
            return true;
        }
        if (channelOption == ChannelOption.SO_KEEPALIVE) {
            setKeepAlive(((Boolean) t5).booleanValue());
            return true;
        }
        if (channelOption == ChannelOption.SO_REUSEADDR) {
            setReuseAddress(((Boolean) t5).booleanValue());
            return true;
        }
        if (channelOption == ChannelOption.SO_LINGER) {
            setSoLinger(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == ChannelOption.IP_TOS) {
            setTrafficClass(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == ChannelOption.ALLOW_HALF_CLOSURE) {
            setAllowHalfClosure(((Boolean) t5).booleanValue());
            return true;
        }
        return super.setOption(channelOption, t5);
    }
}
