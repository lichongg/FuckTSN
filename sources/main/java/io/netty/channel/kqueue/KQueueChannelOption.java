package io.netty.channel.kqueue;

import io.netty.channel.ChannelOption;
import io.netty.channel.unix.UnixChannelOption;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class KQueueChannelOption<T> extends UnixChannelOption<T> {
    public static final ChannelOption<Integer> SO_SNDLOWAT = ChannelOption.valueOf(KQueueChannelOption.class, "SO_SNDLOWAT");
    public static final ChannelOption<Boolean> TCP_NOPUSH = ChannelOption.valueOf(KQueueChannelOption.class, "TCP_NOPUSH");
    public static final ChannelOption<AcceptFilter> SO_ACCEPTFILTER = ChannelOption.valueOf(KQueueChannelOption.class, "SO_ACCEPTFILTER");
    public static final ChannelOption<Boolean> RCV_ALLOC_TRANSPORT_PROVIDES_GUESS = ChannelOption.valueOf(KQueueChannelOption.class, "RCV_ALLOC_TRANSPORT_PROVIDES_GUESS");

    private KQueueChannelOption() {
    }
}
