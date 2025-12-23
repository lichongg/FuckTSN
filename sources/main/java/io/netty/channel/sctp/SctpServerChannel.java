package io.netty.channel.sctp;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ServerChannel;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface SctpServerChannel extends ServerChannel {
    Set<InetSocketAddress> allLocalAddresses();

    ChannelFuture bindAddress(InetAddress inetAddress);

    ChannelFuture bindAddress(InetAddress inetAddress, ChannelPromise channelPromise);

    @Override // io.netty.channel.Channel
    SctpServerChannelConfig config();

    @Override // io.netty.channel.Channel
    InetSocketAddress localAddress();

    ChannelFuture unbindAddress(InetAddress inetAddress);

    ChannelFuture unbindAddress(InetAddress inetAddress, ChannelPromise channelPromise);
}
