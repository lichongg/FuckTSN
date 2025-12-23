package io.netty.channel.epoll;

import io.netty.channel.ChannelOption;
import io.netty.channel.unix.UnixChannelOption;
import java.net.InetAddress;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class EpollChannelOption<T> extends UnixChannelOption<T> {
    public static final ChannelOption<Boolean> TCP_CORK = ChannelOption.valueOf(EpollChannelOption.class, "TCP_CORK");
    public static final ChannelOption<Long> TCP_NOTSENT_LOWAT = ChannelOption.valueOf(EpollChannelOption.class, "TCP_NOTSENT_LOWAT");
    public static final ChannelOption<Integer> TCP_KEEPIDLE = ChannelOption.valueOf(EpollChannelOption.class, "TCP_KEEPIDLE");
    public static final ChannelOption<Integer> TCP_KEEPINTVL = ChannelOption.valueOf(EpollChannelOption.class, "TCP_KEEPINTVL");
    public static final ChannelOption<Integer> TCP_KEEPCNT = ChannelOption.valueOf(EpollChannelOption.class, "TCP_KEEPCNT");
    public static final ChannelOption<Integer> TCP_USER_TIMEOUT = ChannelOption.valueOf(EpollChannelOption.class, "TCP_USER_TIMEOUT");
    public static final ChannelOption<Boolean> IP_FREEBIND = ChannelOption.valueOf("IP_FREEBIND");
    public static final ChannelOption<Boolean> IP_TRANSPARENT = ChannelOption.valueOf("IP_TRANSPARENT");
    public static final ChannelOption<Boolean> IP_RECVORIGDSTADDR = ChannelOption.valueOf("IP_RECVORIGDSTADDR");
    public static final ChannelOption<Integer> TCP_FASTOPEN = ChannelOption.valueOf(EpollChannelOption.class, "TCP_FASTOPEN");
    public static final ChannelOption<Boolean> TCP_FASTOPEN_CONNECT = ChannelOption.valueOf(EpollChannelOption.class, "TCP_FASTOPEN_CONNECT");
    public static final ChannelOption<Integer> TCP_DEFER_ACCEPT = ChannelOption.valueOf(EpollChannelOption.class, "TCP_DEFER_ACCEPT");
    public static final ChannelOption<Boolean> TCP_QUICKACK = ChannelOption.valueOf(EpollChannelOption.class, "TCP_QUICKACK");
    public static final ChannelOption<Integer> SO_BUSY_POLL = ChannelOption.valueOf(EpollChannelOption.class, "SO_BUSY_POLL");
    public static final ChannelOption<EpollMode> EPOLL_MODE = ChannelOption.valueOf(EpollChannelOption.class, "EPOLL_MODE");
    public static final ChannelOption<Map<InetAddress, byte[]>> TCP_MD5SIG = ChannelOption.valueOf("TCP_MD5SIG");

    private EpollChannelOption() {
    }
}
