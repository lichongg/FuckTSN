package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.handler.codec.dns.DnsRecord;
import java.net.InetAddress;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class NoopDnsCache implements DnsCache {
    public static final NoopDnsCache INSTANCE = new NoopDnsCache();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class NoopDnsCacheEntry implements DnsCacheEntry {
        private final InetAddress address;

        @Override // io.netty.resolver.dns.DnsCacheEntry
        public Throwable cause() {
            return null;
        }

        @Override // io.netty.resolver.dns.DnsCacheEntry
        public InetAddress address() {
            return this.address;
        }

        public String toString() {
            return this.address.toString();
        }

        NoopDnsCacheEntry(InetAddress inetAddress) {
            this.address = inetAddress;
        }
    }

    @Override // io.netty.resolver.dns.DnsCache
    public DnsCacheEntry cache(String str, DnsRecord[] dnsRecordArr, Throwable th, EventLoop eventLoop) {
        return null;
    }

    @Override // io.netty.resolver.dns.DnsCache
    public void clear() {
    }

    @Override // io.netty.resolver.dns.DnsCache
    public DnsCacheEntry cache(String str, DnsRecord[] dnsRecordArr, InetAddress inetAddress, long j6, EventLoop eventLoop) {
        return new NoopDnsCacheEntry(inetAddress);
    }

    @Override // io.netty.resolver.dns.DnsCache
    public boolean clear(String str) {
        return false;
    }

    @Override // io.netty.resolver.dns.DnsCache
    public List<? extends DnsCacheEntry> get(String str, DnsRecord[] dnsRecordArr) {
        return Collections.EMPTY_LIST;
    }

    public String toString() {
        return NoopDnsCache.class.getSimpleName();
    }

    private NoopDnsCache() {
    }
}
