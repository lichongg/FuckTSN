package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import java.net.InetSocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface AuthoritativeDnsServerCache {
    void cache(String str, InetSocketAddress inetSocketAddress, long j6, EventLoop eventLoop);

    void clear();

    boolean clear(String str);

    DnsServerAddressStream get(String str);
}
