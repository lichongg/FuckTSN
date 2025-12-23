package io.netty.channel.epoll;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.ServerSocketChannelConfig;
import io.netty.channel.unix.UnixChannelOption;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class EpollServerSocketChannelConfig extends EpollServerChannelConfig implements ServerSocketChannelConfig {
    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    public EpollServerSocketChannelConfig setPerformancePreferences(int i6, int i7, int i8) {
        return this;
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        return channelOption == UnixChannelOption.SO_REUSEPORT ? (T) Boolean.valueOf(isReusePort()) : channelOption == EpollChannelOption.IP_FREEBIND ? (T) Boolean.valueOf(isFreeBind()) : channelOption == EpollChannelOption.IP_TRANSPARENT ? (T) Boolean.valueOf(isIpTransparent()) : channelOption == EpollChannelOption.TCP_DEFER_ACCEPT ? (T) Integer.valueOf(getTcpDeferAccept()) : (T) super.getOption(channelOption);
    }

    public int getTcpDeferAccept() {
        try {
            return ((EpollServerSocketChannel) this.channel).socket.getTcpDeferAccept();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public boolean isFreeBind() {
        try {
            return ((EpollServerSocketChannel) this.channel).socket.isIpFreeBind();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public boolean isIpTransparent() {
        try {
            return ((EpollServerSocketChannel) this.channel).socket.isIpTransparent();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public boolean isReusePort() {
        try {
            return ((EpollServerSocketChannel) this.channel).socket.isReusePort();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public EpollServerSocketChannelConfig setFreeBind(boolean z5) {
        try {
            ((EpollServerSocketChannel) this.channel).socket.setIpFreeBind(z5);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public EpollServerSocketChannelConfig setIpTransparent(boolean z5) {
        try {
            ((EpollServerSocketChannel) this.channel).socket.setIpTransparent(z5);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public EpollServerSocketChannelConfig setReusePort(boolean z5) {
        try {
            ((EpollServerSocketChannel) this.channel).socket.setReusePort(z5);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public EpollServerSocketChannelConfig setTcpDeferAccept(int i6) {
        try {
            ((EpollServerSocketChannel) this.channel).socket.setTcpDeferAccept(i6);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public EpollServerSocketChannelConfig setTcpMd5Sig(Map<InetAddress, byte[]> map) {
        try {
            ((EpollServerSocketChannel) this.channel).setTcpMd5Sig(map);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    EpollServerSocketChannelConfig(EpollServerSocketChannel epollServerSocketChannel) {
        super(epollServerSocketChannel);
        setReuseAddress(true);
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), UnixChannelOption.SO_REUSEPORT, EpollChannelOption.IP_FREEBIND, EpollChannelOption.IP_TRANSPARENT, EpollChannelOption.TCP_DEFER_ACCEPT);
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    public EpollServerSocketChannelConfig setBacklog(int i6) {
        super.setBacklog(i6);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> channelOption, T t5) {
        validate(channelOption, t5);
        if (channelOption == UnixChannelOption.SO_REUSEPORT) {
            setReusePort(((Boolean) t5).booleanValue());
            return true;
        }
        if (channelOption == EpollChannelOption.IP_FREEBIND) {
            setFreeBind(((Boolean) t5).booleanValue());
            return true;
        }
        if (channelOption == EpollChannelOption.IP_TRANSPARENT) {
            setIpTransparent(((Boolean) t5).booleanValue());
            return true;
        }
        if (channelOption == EpollChannelOption.TCP_MD5SIG) {
            setTcpMd5Sig((Map) t5);
            return true;
        }
        if (channelOption == EpollChannelOption.TCP_DEFER_ACCEPT) {
            setTcpDeferAccept(((Integer) t5).intValue());
            return true;
        }
        return super.setOption(channelOption, t5);
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    public EpollServerSocketChannelConfig setReceiveBufferSize(int i6) {
        super.setReceiveBufferSize(i6);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    public EpollServerSocketChannelConfig setReuseAddress(boolean z5) {
        super.setReuseAddress(z5);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollServerSocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollServerSocketChannelConfig setAutoRead(boolean z5) {
        super.setAutoRead(z5);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollServerSocketChannelConfig setConnectTimeoutMillis(int i6) {
        super.setConnectTimeoutMillis(i6);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public EpollServerSocketChannelConfig setMaxMessagesPerRead(int i6) {
        super.setMaxMessagesPerRead(i6);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollServerSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollServerSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public EpollServerSocketChannelConfig setWriteBufferHighWaterMark(int i6) {
        super.setWriteBufferHighWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public EpollServerSocketChannelConfig setWriteBufferLowWaterMark(int i6) {
        super.setWriteBufferLowWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollServerSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollServerChannelConfig, io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollServerSocketChannelConfig setWriteSpinCount(int i6) {
        super.setWriteSpinCount(i6);
        return this;
    }
}
