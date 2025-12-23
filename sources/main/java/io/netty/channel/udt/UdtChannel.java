package io.netty.channel.udt;

import io.netty.channel.Channel;
import java.net.InetSocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public interface UdtChannel extends Channel {
    @Override // io.netty.channel.Channel
    UdtChannelConfig config();

    @Override // io.netty.channel.Channel
    InetSocketAddress localAddress();

    @Override // io.netty.channel.Channel
    InetSocketAddress remoteAddress();
}
