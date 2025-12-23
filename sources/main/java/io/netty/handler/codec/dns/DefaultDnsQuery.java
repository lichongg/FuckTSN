package io.netty.handler.codec.dns;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultDnsQuery extends AbstractDnsMessage implements DnsQuery {
    public DefaultDnsQuery(int i6) {
        super(i6);
    }

    public DefaultDnsQuery(int i6, DnsOpCode dnsOpCode) {
        super(i6, dnsOpCode);
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DnsQuery setId(int i6) {
        return (DnsQuery) super.setId(i6);
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DnsQuery setOpCode(DnsOpCode dnsOpCode) {
        return (DnsQuery) super.setOpCode(dnsOpCode);
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DnsQuery setRecord(DnsSection dnsSection, DnsRecord dnsRecord) {
        return (DnsQuery) super.setRecord(dnsSection, dnsRecord);
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DnsQuery setRecursionDesired(boolean z5) {
        return (DnsQuery) super.setRecursionDesired(z5);
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DnsQuery setZ(int i6) {
        return (DnsQuery) super.setZ(i6);
    }

    public String toString() {
        return DnsMessageUtil.appendQuery(new StringBuilder(128), this).toString();
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DnsQuery addRecord(DnsSection dnsSection, DnsRecord dnsRecord) {
        return (DnsQuery) super.addRecord(dnsSection, dnsRecord);
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DnsQuery clear(DnsSection dnsSection) {
        return (DnsQuery) super.clear(dnsSection);
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DnsQuery addRecord(DnsSection dnsSection, int i6, DnsRecord dnsRecord) {
        return (DnsQuery) super.addRecord(dnsSection, i6, dnsRecord);
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DnsQuery clear() {
        return (DnsQuery) super.clear();
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public DnsQuery retain() {
        return (DnsQuery) super.retain();
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public DnsQuery touch() {
        return (DnsQuery) super.touch();
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public DnsQuery retain(int i6) {
        return (DnsQuery) super.retain(i6);
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.util.ReferenceCounted
    public DnsQuery touch(Object obj) {
        return (DnsQuery) super.touch(obj);
    }
}
