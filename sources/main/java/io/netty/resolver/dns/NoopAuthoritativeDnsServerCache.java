package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import java.net.InetSocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class NoopAuthoritativeDnsServerCache implements AuthoritativeDnsServerCache {
    public static final NoopAuthoritativeDnsServerCache INSTANCE = new NoopAuthoritativeDnsServerCache();

    @Override // io.netty.resolver.dns.AuthoritativeDnsServerCache
    public void clear() {
    }

    @Override // io.netty.resolver.dns.AuthoritativeDnsServerCache
    public DnsServerAddressStream get(String str) {
        return null;
    }

    @Override // io.netty.resolver.dns.AuthoritativeDnsServerCache
    public boolean clear(String str) {
        return false;
    }

    private NoopAuthoritativeDnsServerCache() {
    }

    @Override // io.netty.resolver.dns.AuthoritativeDnsServerCache
    public void cache(String str, InetSocketAddress inetSocketAddress, long j6, EventLoop eventLoop) {
    }
}
