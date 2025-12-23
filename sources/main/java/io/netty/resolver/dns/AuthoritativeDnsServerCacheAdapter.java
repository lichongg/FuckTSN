package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class AuthoritativeDnsServerCacheAdapter implements AuthoritativeDnsServerCache {
    private static final DnsRecord[] EMPTY = new DnsRecord[0];
    private final DnsCache cache;

    @Override // io.netty.resolver.dns.AuthoritativeDnsServerCache
    public void clear() {
        this.cache.clear();
    }

    @Override // io.netty.resolver.dns.AuthoritativeDnsServerCache
    public boolean clear(String str) {
        return this.cache.clear(str);
    }

    @Override // io.netty.resolver.dns.AuthoritativeDnsServerCache
    public DnsServerAddressStream get(String str) {
        List<? extends DnsCacheEntry> list = this.cache.get(str, EMPTY);
        if (list == null || list.isEmpty() || list.get(0).cause() != null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int i6 = 0;
        do {
            arrayList.add(new InetSocketAddress(list.get(i6).address(), 53));
            i6++;
        } while (i6 < list.size());
        return new SequentialDnsServerAddressStream(arrayList, 0);
    }

    AuthoritativeDnsServerCacheAdapter(DnsCache dnsCache) {
        this.cache = (DnsCache) ObjectUtil.checkNotNull(dnsCache, "cache");
    }

    @Override // io.netty.resolver.dns.AuthoritativeDnsServerCache
    public void cache(String str, InetSocketAddress inetSocketAddress, long j6, EventLoop eventLoop) {
        if (!inetSocketAddress.isUnresolved()) {
            this.cache.cache(str, EMPTY, inetSocketAddress.getAddress(), j6, eventLoop);
        }
    }
}
