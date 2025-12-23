package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.InetAddress;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultDnsCache implements DnsCache {
    private final int maxTtl;
    private final int minTtl;
    private final int negativeTtl;
    private final Cache<DefaultDnsCacheEntry> resolveCache;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class DefaultDnsCacheEntry implements DnsCacheEntry {
        private final InetAddress address;
        private final Throwable cause;
        private final String hostname;

        DefaultDnsCacheEntry(String str, InetAddress inetAddress) {
            this.hostname = str;
            this.address = inetAddress;
            this.cause = null;
        }

        @Override // io.netty.resolver.dns.DnsCacheEntry
        public InetAddress address() {
            return this.address;
        }

        @Override // io.netty.resolver.dns.DnsCacheEntry
        public Throwable cause() {
            return this.cause;
        }

        String hostname() {
            return this.hostname;
        }

        public String toString() {
            if (this.cause == null) {
                return this.address.toString();
            }
            return this.hostname + '/' + this.cause;
        }

        DefaultDnsCacheEntry(String str, Throwable th) {
            this.hostname = str;
            this.cause = th;
            this.address = null;
        }
    }

    public DefaultDnsCache() {
        this(0, Cache.MAX_SUPPORTED_TTL_SECS, 0);
    }

    @Override // io.netty.resolver.dns.DnsCache
    public DnsCacheEntry cache(String str, DnsRecord[] dnsRecordArr, InetAddress inetAddress, long j6, EventLoop eventLoop) {
        ObjectUtil.checkNotNull(str, "hostname");
        ObjectUtil.checkNotNull(inetAddress, "address");
        ObjectUtil.checkNotNull(eventLoop, "loop");
        DefaultDnsCacheEntry defaultDnsCacheEntry = new DefaultDnsCacheEntry(str, inetAddress);
        if (this.maxTtl != 0 && emptyAdditionals(dnsRecordArr)) {
            this.resolveCache.cache(appendDot(str), defaultDnsCacheEntry, Math.max(this.minTtl, (int) Math.min(this.maxTtl, j6)), eventLoop);
        }
        return defaultDnsCacheEntry;
    }

    @Override // io.netty.resolver.dns.DnsCache
    public void clear() {
        this.resolveCache.clear();
    }

    public DefaultDnsCache(int i6, int i7, int i8) {
        this.resolveCache = new Cache<DefaultDnsCacheEntry>() { // from class: io.netty.resolver.dns.DefaultDnsCache.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.resolver.dns.Cache
            public boolean equals(DefaultDnsCacheEntry defaultDnsCacheEntry, DefaultDnsCacheEntry defaultDnsCacheEntry2) {
                if (defaultDnsCacheEntry.address() != null) {
                    return defaultDnsCacheEntry.address().equals(defaultDnsCacheEntry2.address());
                }
                if (defaultDnsCacheEntry2.address() != null) {
                    return false;
                }
                return defaultDnsCacheEntry.cause().equals(defaultDnsCacheEntry2.cause());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.resolver.dns.Cache
            public boolean shouldReplaceAll(DefaultDnsCacheEntry defaultDnsCacheEntry) {
                return defaultDnsCacheEntry.cause() != null;
            }
        };
        int i9 = Cache.MAX_SUPPORTED_TTL_SECS;
        this.minTtl = Math.min(i9, ObjectUtil.checkPositiveOrZero(i6, "minTtl"));
        this.maxTtl = Math.min(i9, ObjectUtil.checkPositiveOrZero(i7, "maxTtl"));
        if (i6 <= i7) {
            this.negativeTtl = ObjectUtil.checkPositiveOrZero(i8, "negativeTtl");
            return;
        }
        throw new IllegalArgumentException("minTtl: " + i6 + ", maxTtl: " + i7 + " (expected: 0 <= minTtl <= maxTtl)");
    }

    private static String appendDot(String str) {
        if (StringUtil.endsWith(str, '.')) {
            return str;
        }
        return str + '.';
    }

    private static boolean emptyAdditionals(DnsRecord[] dnsRecordArr) {
        return dnsRecordArr == null || dnsRecordArr.length == 0;
    }

    @Override // io.netty.resolver.dns.DnsCache
    public boolean clear(String str) {
        ObjectUtil.checkNotNull(str, "hostname");
        return this.resolveCache.clear(appendDot(str));
    }

    @Override // io.netty.resolver.dns.DnsCache
    public List<? extends DnsCacheEntry> get(String str, DnsRecord[] dnsRecordArr) {
        ObjectUtil.checkNotNull(str, "hostname");
        return !emptyAdditionals(dnsRecordArr) ? Collections.EMPTY_LIST : this.resolveCache.get(appendDot(str));
    }

    public int maxTtl() {
        return this.maxTtl;
    }

    public int minTtl() {
        return this.minTtl;
    }

    public int negativeTtl() {
        return this.negativeTtl;
    }

    public String toString() {
        return "DefaultDnsCache(minTtl=" + this.minTtl + ", maxTtl=" + this.maxTtl + ", negativeTtl=" + this.negativeTtl + ", cached resolved hostname=" + this.resolveCache.size() + ')';
    }

    @Override // io.netty.resolver.dns.DnsCache
    public DnsCacheEntry cache(String str, DnsRecord[] dnsRecordArr, Throwable th, EventLoop eventLoop) {
        ObjectUtil.checkNotNull(str, "hostname");
        ObjectUtil.checkNotNull(th, "cause");
        ObjectUtil.checkNotNull(eventLoop, "loop");
        DefaultDnsCacheEntry defaultDnsCacheEntry = new DefaultDnsCacheEntry(str, th);
        if (this.negativeTtl != 0 && emptyAdditionals(dnsRecordArr)) {
            this.resolveCache.cache(appendDot(str), defaultDnsCacheEntry, this.negativeTtl, eventLoop);
        }
        return defaultDnsCacheEntry;
    }
}
