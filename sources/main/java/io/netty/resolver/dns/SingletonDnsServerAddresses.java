package io.netty.resolver.dns;

import java.net.InetSocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class SingletonDnsServerAddresses extends DnsServerAddresses {
    private final InetSocketAddress address;
    private final DnsServerAddressStream stream = new DnsServerAddressStream() { // from class: io.netty.resolver.dns.SingletonDnsServerAddresses.1
        @Override // io.netty.resolver.dns.DnsServerAddressStream
        public int size() {
            return 1;
        }

        @Override // io.netty.resolver.dns.DnsServerAddressStream
        public InetSocketAddress next() {
            return SingletonDnsServerAddresses.this.address;
        }

        public String toString() {
            return SingletonDnsServerAddresses.this.toString();
        }

        @Override // io.netty.resolver.dns.DnsServerAddressStream
        public DnsServerAddressStream duplicate() {
            return this;
        }
    };

    @Override // io.netty.resolver.dns.DnsServerAddresses
    public DnsServerAddressStream stream() {
        return this.stream;
    }

    public String toString() {
        return "singleton(" + this.address + ")";
    }

    SingletonDnsServerAddresses(InetSocketAddress inetSocketAddress) {
        this.address = inetSocketAddress;
    }
}
