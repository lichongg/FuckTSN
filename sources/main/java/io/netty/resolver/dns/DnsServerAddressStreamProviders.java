package io.netty.resolver.dns;

import io.netty.util.internal.PlatformDependent;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class DnsServerAddressStreamProviders {
    private static final long REFRESH_INTERVAL = TimeUnit.MINUTES.toNanos(5);
    private static final DnsServerAddressStreamProvider DEFAULT_DNS_SERVER_ADDRESS_STREAM_PROVIDER = new DnsServerAddressStreamProvider() { // from class: io.netty.resolver.dns.DnsServerAddressStreamProviders.1
        private volatile DnsServerAddressStreamProvider currentProvider = provider();
        private final AtomicLong lastRefresh = new AtomicLong(System.nanoTime());

        @Override // io.netty.resolver.dns.DnsServerAddressStreamProvider
        public DnsServerAddressStream nameServerAddressStream(String str) {
            long j6 = this.lastRefresh.get();
            DnsServerAddressStreamProvider dnsServerAddressStreamProvider = this.currentProvider;
            if (System.nanoTime() - j6 > DnsServerAddressStreamProviders.REFRESH_INTERVAL && this.lastRefresh.compareAndSet(j6, System.nanoTime())) {
                dnsServerAddressStreamProvider = provider();
                this.currentProvider = dnsServerAddressStreamProvider;
            }
            return dnsServerAddressStreamProvider.nameServerAddressStream(str);
        }

        private DnsServerAddressStreamProvider provider() {
            if (PlatformDependent.isWindows()) {
                return DefaultDnsServerAddressStreamProvider.INSTANCE;
            }
            return UnixResolverDnsServerAddressStreamProvider.parseSilently();
        }
    };

    public static DnsServerAddressStreamProvider platformDefault() {
        return DEFAULT_DNS_SERVER_ADDRESS_STREAM_PROVIDER;
    }

    private DnsServerAddressStreamProviders() {
    }
}
