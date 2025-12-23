package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.handler.codec.dns.DnsRecord;
import java.net.InetAddress;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface DnsCache {
    DnsCacheEntry cache(String str, DnsRecord[] dnsRecordArr, Throwable th, EventLoop eventLoop);

    DnsCacheEntry cache(String str, DnsRecord[] dnsRecordArr, InetAddress inetAddress, long j6, EventLoop eventLoop);

    void clear();

    boolean clear(String str);

    List<? extends DnsCacheEntry> get(String str, DnsRecord[] dnsRecordArr);
}
