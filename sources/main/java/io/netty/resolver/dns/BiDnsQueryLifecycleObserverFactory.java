package io.netty.resolver.dns;

import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class BiDnsQueryLifecycleObserverFactory implements DnsQueryLifecycleObserverFactory {

    /* renamed from: a, reason: collision with root package name */
    private final DnsQueryLifecycleObserverFactory f43084a;

    /* renamed from: b, reason: collision with root package name */
    private final DnsQueryLifecycleObserverFactory f43085b;

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserverFactory
    public DnsQueryLifecycleObserver newDnsQueryLifecycleObserver(DnsQuestion dnsQuestion) {
        return new BiDnsQueryLifecycleObserver(this.f43084a.newDnsQueryLifecycleObserver(dnsQuestion), this.f43085b.newDnsQueryLifecycleObserver(dnsQuestion));
    }

    public BiDnsQueryLifecycleObserverFactory(DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory, DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory2) {
        this.f43084a = (DnsQueryLifecycleObserverFactory) ObjectUtil.checkNotNull(dnsQueryLifecycleObserverFactory, "a");
        this.f43085b = (DnsQueryLifecycleObserverFactory) ObjectUtil.checkNotNull(dnsQueryLifecycleObserverFactory2, "b");
    }
}
