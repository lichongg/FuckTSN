package io.netty.handler.codec.dns;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface DnsQuery extends DnsMessage {
    @Override // io.netty.handler.codec.dns.DnsMessage
    DnsQuery addRecord(DnsSection dnsSection, int i6, DnsRecord dnsRecord);

    @Override // io.netty.handler.codec.dns.DnsMessage
    DnsQuery addRecord(DnsSection dnsSection, DnsRecord dnsRecord);

    @Override // io.netty.handler.codec.dns.DnsMessage
    DnsQuery clear();

    @Override // io.netty.handler.codec.dns.DnsMessage
    DnsQuery clear(DnsSection dnsSection);

    @Override // io.netty.handler.codec.dns.DnsMessage, io.netty.util.ReferenceCounted
    DnsQuery retain();

    @Override // io.netty.handler.codec.dns.DnsMessage, io.netty.util.ReferenceCounted
    DnsQuery retain(int i6);

    @Override // io.netty.handler.codec.dns.DnsMessage
    DnsQuery setId(int i6);

    @Override // io.netty.handler.codec.dns.DnsMessage
    DnsQuery setOpCode(DnsOpCode dnsOpCode);

    @Override // io.netty.handler.codec.dns.DnsMessage
    DnsQuery setRecord(DnsSection dnsSection, DnsRecord dnsRecord);

    @Override // io.netty.handler.codec.dns.DnsMessage
    DnsQuery setRecursionDesired(boolean z5);

    @Override // io.netty.handler.codec.dns.DnsMessage
    DnsQuery setZ(int i6);

    @Override // io.netty.handler.codec.dns.DnsMessage, io.netty.util.ReferenceCounted
    DnsQuery touch();

    @Override // io.netty.handler.codec.dns.DnsMessage, io.netty.util.ReferenceCounted
    DnsQuery touch(Object obj);
}
