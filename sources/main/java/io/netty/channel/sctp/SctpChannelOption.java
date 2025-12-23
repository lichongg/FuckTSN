package io.netty.channel.sctp;

import com.sun.nio.sctp.SctpStandardSocketOptions;
import io.netty.channel.ChannelOption;
import java.net.SocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class SctpChannelOption<T> extends ChannelOption<T> {
    public static final ChannelOption<Boolean> SCTP_DISABLE_FRAGMENTS = ChannelOption.valueOf(SctpChannelOption.class, "SCTP_DISABLE_FRAGMENTS");
    public static final ChannelOption<Boolean> SCTP_EXPLICIT_COMPLETE = ChannelOption.valueOf(SctpChannelOption.class, "SCTP_EXPLICIT_COMPLETE");
    public static final ChannelOption<Integer> SCTP_FRAGMENT_INTERLEAVE = ChannelOption.valueOf(SctpChannelOption.class, "SCTP_FRAGMENT_INTERLEAVE");
    public static final ChannelOption<SctpStandardSocketOptions.InitMaxStreams> SCTP_INIT_MAXSTREAMS = ChannelOption.valueOf(SctpChannelOption.class, "SCTP_INIT_MAXSTREAMS");
    public static final ChannelOption<Boolean> SCTP_NODELAY = ChannelOption.valueOf(SctpChannelOption.class, "SCTP_NODELAY");
    public static final ChannelOption<SocketAddress> SCTP_PRIMARY_ADDR = ChannelOption.valueOf(SctpChannelOption.class, "SCTP_PRIMARY_ADDR");
    public static final ChannelOption<SocketAddress> SCTP_SET_PEER_PRIMARY_ADDR = ChannelOption.valueOf(SctpChannelOption.class, "SCTP_SET_PEER_PRIMARY_ADDR");

    private SctpChannelOption() {
        super(null);
    }
}
