package io.netty.handler.codec.dns;

import io.netty.channel.AddressedEnvelope;
import java.net.InetSocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DatagramDnsQuery extends DefaultDnsQuery implements AddressedEnvelope<DatagramDnsQuery, InetSocketAddress> {
    private final InetSocketAddress recipient;
    private final InetSocketAddress sender;

    public DatagramDnsQuery(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, int i6) {
        this(inetSocketAddress, inetSocketAddress2, i6, DnsOpCode.QUERY);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.channel.AddressedEnvelope
    public DatagramDnsQuery content() {
        return this;
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsMessage
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || !(obj instanceof AddressedEnvelope)) {
            return false;
        }
        AddressedEnvelope addressedEnvelope = (AddressedEnvelope) obj;
        if (sender() == null) {
            if (addressedEnvelope.sender() != null) {
                return false;
            }
        } else if (!sender().equals(addressedEnvelope.sender())) {
            return false;
        }
        if (recipient() == null) {
            if (addressedEnvelope.recipient() != null) {
                return false;
            }
        } else if (!recipient().equals(addressedEnvelope.recipient())) {
            return false;
        }
        return true;
    }

    public DatagramDnsQuery(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, int i6, DnsOpCode dnsOpCode) {
        super(i6, dnsOpCode);
        if (inetSocketAddress2 == null && inetSocketAddress == null) {
            throw new NullPointerException("recipient and sender");
        }
        this.sender = inetSocketAddress;
        this.recipient = inetSocketAddress2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.channel.AddressedEnvelope
    public InetSocketAddress recipient() {
        return this.recipient;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.channel.AddressedEnvelope
    public InetSocketAddress sender() {
        return this.sender;
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsMessage
    public int hashCode() {
        int hashCode = super.hashCode();
        if (sender() != null) {
            hashCode = (hashCode * 31) + sender().hashCode();
        }
        if (recipient() != null) {
            return (hashCode * 31) + recipient().hashCode();
        }
        return hashCode;
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsQuery setId(int i6) {
        return (DatagramDnsQuery) super.setId(i6);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsQuery setOpCode(DnsOpCode dnsOpCode) {
        return (DatagramDnsQuery) super.setOpCode(dnsOpCode);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsQuery setRecord(DnsSection dnsSection, DnsRecord dnsRecord) {
        return (DatagramDnsQuery) super.setRecord(dnsSection, dnsRecord);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsQuery setRecursionDesired(boolean z5) {
        return (DatagramDnsQuery) super.setRecursionDesired(z5);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsQuery setZ(int i6) {
        return (DatagramDnsQuery) super.setZ(i6);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsQuery addRecord(DnsSection dnsSection, DnsRecord dnsRecord) {
        return (DatagramDnsQuery) super.addRecord(dnsSection, dnsRecord);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsQuery clear(DnsSection dnsSection) {
        return (DatagramDnsQuery) super.clear(dnsSection);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsQuery addRecord(DnsSection dnsSection, int i6, DnsRecord dnsRecord) {
        return (DatagramDnsQuery) super.addRecord(dnsSection, i6, dnsRecord);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.handler.codec.dns.DnsMessage
    public DatagramDnsQuery clear() {
        return (DatagramDnsQuery) super.clear();
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public DatagramDnsQuery retain() {
        return (DatagramDnsQuery) super.retain();
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public DatagramDnsQuery touch() {
        return (DatagramDnsQuery) super.touch();
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public DatagramDnsQuery retain(int i6) {
        return (DatagramDnsQuery) super.retain(i6);
    }

    @Override // io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.AbstractDnsMessage, io.netty.util.ReferenceCounted
    public DatagramDnsQuery touch(Object obj) {
        return (DatagramDnsQuery) super.touch(obj);
    }
}
