package io.netty.resolver.dns;

import io.netty.channel.ChannelFuture;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsResponseCode;
import java.net.InetSocketAddress;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class NoopDnsQueryLifecycleObserver implements DnsQueryLifecycleObserver {
    static final NoopDnsQueryLifecycleObserver INSTANCE = new NoopDnsQueryLifecycleObserver();

    private NoopDnsQueryLifecycleObserver() {
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public void querySucceed() {
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public DnsQueryLifecycleObserver queryCNAMEd(DnsQuestion dnsQuestion) {
        return this;
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public void queryCancelled(int i6) {
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public void queryFailed(Throwable th) {
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public DnsQueryLifecycleObserver queryNoAnswer(DnsResponseCode dnsResponseCode) {
        return this;
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public DnsQueryLifecycleObserver queryRedirected(List<InetSocketAddress> list) {
        return this;
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public void queryWritten(InetSocketAddress inetSocketAddress, ChannelFuture channelFuture) {
    }
}
