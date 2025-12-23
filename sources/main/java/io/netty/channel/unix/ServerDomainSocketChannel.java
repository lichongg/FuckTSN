package io.netty.channel.unix;

import io.netty.channel.ServerChannel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface ServerDomainSocketChannel extends ServerChannel, UnixChannel {
    @Override // io.netty.channel.Channel
    DomainSocketAddress localAddress();

    @Override // io.netty.channel.Channel
    DomainSocketAddress remoteAddress();
}
