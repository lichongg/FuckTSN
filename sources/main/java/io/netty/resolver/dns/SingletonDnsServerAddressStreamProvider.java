package io.netty.resolver.dns;

import java.net.InetSocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class SingletonDnsServerAddressStreamProvider extends UniSequentialDnsServerAddressStreamProvider {
    public SingletonDnsServerAddressStreamProvider(InetSocketAddress inetSocketAddress) {
        super(DnsServerAddresses.singleton(inetSocketAddress));
    }
}
