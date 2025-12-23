package io.netty.resolver.dns;

import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class MultiDnsServerAddressStreamProvider implements DnsServerAddressStreamProvider {
    private final DnsServerAddressStreamProvider[] providers;

    public MultiDnsServerAddressStreamProvider(List<DnsServerAddressStreamProvider> list) {
        this.providers = (DnsServerAddressStreamProvider[]) list.toArray(new DnsServerAddressStreamProvider[0]);
    }

    @Override // io.netty.resolver.dns.DnsServerAddressStreamProvider
    public DnsServerAddressStream nameServerAddressStream(String str) {
        for (DnsServerAddressStreamProvider dnsServerAddressStreamProvider : this.providers) {
            DnsServerAddressStream nameServerAddressStream = dnsServerAddressStreamProvider.nameServerAddressStream(str);
            if (nameServerAddressStream != null) {
                return nameServerAddressStream;
            }
        }
        return null;
    }

    public MultiDnsServerAddressStreamProvider(DnsServerAddressStreamProvider... dnsServerAddressStreamProviderArr) {
        this.providers = (DnsServerAddressStreamProvider[]) dnsServerAddressStreamProviderArr.clone();
    }
}
