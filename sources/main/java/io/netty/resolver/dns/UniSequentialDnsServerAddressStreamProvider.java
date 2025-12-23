package io.netty.resolver.dns;

import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
abstract class UniSequentialDnsServerAddressStreamProvider implements DnsServerAddressStreamProvider {
    private final DnsServerAddresses addresses;

    @Override // io.netty.resolver.dns.DnsServerAddressStreamProvider
    public final DnsServerAddressStream nameServerAddressStream(String str) {
        return this.addresses.stream();
    }

    UniSequentialDnsServerAddressStreamProvider(DnsServerAddresses dnsServerAddresses) {
        this.addresses = (DnsServerAddresses) ObjectUtil.checkNotNull(dnsServerAddresses, "addresses");
    }
}
