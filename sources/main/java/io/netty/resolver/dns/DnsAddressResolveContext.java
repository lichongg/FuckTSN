package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.util.concurrent.Promise;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class DnsAddressResolveContext extends DnsResolveContext<InetAddress> {
    private final AuthoritativeDnsServerCache authoritativeDnsServerCache;
    private final boolean completeEarlyIfPossible;
    private final DnsCache resolveCache;

    DnsAddressResolveContext(DnsNameResolver dnsNameResolver, String str, DnsRecord[] dnsRecordArr, DnsServerAddressStream dnsServerAddressStream, DnsCache dnsCache, AuthoritativeDnsServerCache authoritativeDnsServerCache, boolean z5) {
        super(dnsNameResolver, str, 1, dnsNameResolver.resolveRecordTypes(), dnsRecordArr, dnsServerAddressStream);
        this.resolveCache = dnsCache;
        this.authoritativeDnsServerCache = authoritativeDnsServerCache;
        this.completeEarlyIfPossible = z5;
    }

    @Override // io.netty.resolver.dns.DnsResolveContext
    boolean isDuplicateAllowed() {
        return false;
    }

    @Override // io.netty.resolver.dns.DnsResolveContext
    AuthoritativeDnsServerCache authoritativeDnsServerCache() {
        return this.authoritativeDnsServerCache;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.netty.resolver.dns.DnsResolveContext
    public void cache(String str, DnsRecord[] dnsRecordArr, DnsRecord dnsRecord, InetAddress inetAddress) {
        this.resolveCache.cache(str, dnsRecordArr, inetAddress, dnsRecord.timeToLive(), this.parent.ch.eventLoop());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.netty.resolver.dns.DnsResolveContext
    public InetAddress convertRecord(DnsRecord dnsRecord, String str, DnsRecord[] dnsRecordArr, EventLoop eventLoop) {
        return DnsAddressDecoder.decodeAddress(dnsRecord, str, this.parent.isDecodeIdn());
    }

    @Override // io.netty.resolver.dns.DnsResolveContext
    void doSearchDomainQuery(String str, Promise<List<InetAddress>> promise) {
        if (DnsNameResolver.doResolveAllCached(str, this.additionals, promise, this.resolveCache, this.parent.resolvedInternetProtocolFamiliesUnsafe())) {
            return;
        }
        super.doSearchDomainQuery(str, promise);
    }

    @Override // io.netty.resolver.dns.DnsResolveContext
    List<InetAddress> filterResults(List<InetAddress> list) {
        Collections.sort(list, PreferredAddressTypeComparator.comparator(this.parent.preferredAddressType()));
        return list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.netty.resolver.dns.DnsResolveContext
    public boolean isCompleteEarly(InetAddress inetAddress) {
        return this.completeEarlyIfPossible && this.parent.preferredAddressType().addressType() == inetAddress.getClass();
    }

    @Override // io.netty.resolver.dns.DnsResolveContext
    DnsResolveContext<InetAddress> newResolverContext(DnsNameResolver dnsNameResolver, String str, int i6, DnsRecordType[] dnsRecordTypeArr, DnsRecord[] dnsRecordArr, DnsServerAddressStream dnsServerAddressStream) {
        return new DnsAddressResolveContext(dnsNameResolver, str, dnsRecordArr, dnsServerAddressStream, this.resolveCache, this.authoritativeDnsServerCache, this.completeEarlyIfPossible);
    }

    @Override // io.netty.resolver.dns.DnsResolveContext
    DnsCache resolveCache() {
        return this.resolveCache;
    }

    @Override // io.netty.resolver.dns.DnsResolveContext
    void cache(String str, DnsRecord[] dnsRecordArr, UnknownHostException unknownHostException) {
        this.resolveCache.cache(str, dnsRecordArr, unknownHostException, this.parent.ch.eventLoop());
    }
}
