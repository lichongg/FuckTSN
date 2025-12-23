package io.netty.handler.codec.dns;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface DnsResponse extends DnsMessage {
    @Override // io.netty.handler.codec.dns.DnsMessage
    DnsResponse addRecord(DnsSection dnsSection, int i6, DnsRecord dnsRecord);

    @Override // io.netty.handler.codec.dns.DnsMessage
    DnsResponse addRecord(DnsSection dnsSection, DnsRecord dnsRecord);

    @Override // io.netty.handler.codec.dns.DnsMessage
    DnsResponse clear();

    @Override // io.netty.handler.codec.dns.DnsMessage
    DnsResponse clear(DnsSection dnsSection);

    DnsResponseCode code();

    boolean isAuthoritativeAnswer();

    boolean isRecursionAvailable();

    boolean isTruncated();

    @Override // io.netty.handler.codec.dns.DnsMessage, io.netty.util.ReferenceCounted
    DnsResponse retain();

    @Override // io.netty.handler.codec.dns.DnsMessage, io.netty.util.ReferenceCounted
    DnsResponse retain(int i6);

    DnsResponse setAuthoritativeAnswer(boolean z5);

    DnsResponse setCode(DnsResponseCode dnsResponseCode);

    @Override // io.netty.handler.codec.dns.DnsMessage
    DnsResponse setId(int i6);

    @Override // io.netty.handler.codec.dns.DnsMessage
    DnsResponse setOpCode(DnsOpCode dnsOpCode);

    @Override // io.netty.handler.codec.dns.DnsMessage
    DnsResponse setRecord(DnsSection dnsSection, DnsRecord dnsRecord);

    DnsResponse setRecursionAvailable(boolean z5);

    @Override // io.netty.handler.codec.dns.DnsMessage
    DnsResponse setRecursionDesired(boolean z5);

    DnsResponse setTruncated(boolean z5);

    @Override // io.netty.handler.codec.dns.DnsMessage
    DnsResponse setZ(int i6);

    @Override // io.netty.handler.codec.dns.DnsMessage, io.netty.util.ReferenceCounted
    DnsResponse touch();

    @Override // io.netty.handler.codec.dns.DnsMessage, io.netty.util.ReferenceCounted
    DnsResponse touch(Object obj);
}
