package io.netty.resolver.dns;

import io.netty.handler.codec.dns.DnsQuestion;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class NoopDnsQueryLifecycleObserverFactory implements DnsQueryLifecycleObserverFactory {
    public static final NoopDnsQueryLifecycleObserverFactory INSTANCE = new NoopDnsQueryLifecycleObserverFactory();

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserverFactory
    public DnsQueryLifecycleObserver newDnsQueryLifecycleObserver(DnsQuestion dnsQuestion) {
        return NoopDnsQueryLifecycleObserver.INSTANCE;
    }

    private NoopDnsQueryLifecycleObserverFactory() {
    }
}
