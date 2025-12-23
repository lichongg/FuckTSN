package io.netty.resolver.dns;

import io.netty.channel.AddressedEnvelope;
import io.netty.channel.Channel;
import io.netty.handler.codec.dns.DatagramDnsQuery;
import io.netty.handler.codec.dns.DnsQuery;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsResponse;
import io.netty.handler.codec.rtsp.RtspHeaders;
import io.netty.util.concurrent.Promise;
import java.net.InetSocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class DatagramDnsQueryContext extends DnsQueryContext {
    @Override // io.netty.resolver.dns.DnsQueryContext
    protected DnsQuery newQuery(int i6) {
        return new DatagramDnsQuery(null, nameServerAddr(), i6);
    }

    @Override // io.netty.resolver.dns.DnsQueryContext
    protected String protocol() {
        return RtspHeaders.Values.UDP;
    }

    DatagramDnsQueryContext(DnsNameResolver dnsNameResolver, InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, DnsRecord[] dnsRecordArr, Promise<AddressedEnvelope<DnsResponse, InetSocketAddress>> promise) {
        super(dnsNameResolver, inetSocketAddress, dnsQuestion, dnsRecordArr, promise);
    }

    @Override // io.netty.resolver.dns.DnsQueryContext
    protected Channel channel() {
        return parent().ch;
    }
}
