package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultDnsRawRecord extends AbstractDnsRecord implements DnsRawRecord {
    private final ByteBuf content;

    public DefaultDnsRawRecord(String str, DnsRecordType dnsRecordType, long j6, ByteBuf byteBuf) {
        this(str, dnsRecordType, 1, j6, byteBuf);
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return content().release();
    }

    public DefaultDnsRawRecord(String str, DnsRecordType dnsRecordType, int i6, long j6, ByteBuf byteBuf) {
        super(str, dnsRecordType, i6, j6);
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        return this.content;
    }

    @Override // io.netty.buffer.ByteBufHolder
    public DnsRawRecord copy() {
        return replace(content().copy());
    }

    @Override // io.netty.buffer.ByteBufHolder
    public DnsRawRecord duplicate() {
        return replace(content().duplicate());
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i6) {
        return content().release(i6);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public DnsRawRecord replace(ByteBuf byteBuf) {
        return new DefaultDnsRawRecord(name(), type(), dnsClass(), timeToLive(), byteBuf);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public DnsRawRecord retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsRecord
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(StringUtil.simpleClassName(this));
        sb.append('(');
        DnsRecordType type = type();
        if (type != DnsRecordType.OPT) {
            sb.append(name().isEmpty() ? "<root>" : name());
            sb.append(' ');
            sb.append(timeToLive());
            sb.append(' ');
            StringBuilder appendRecordClass = DnsMessageUtil.appendRecordClass(sb, dnsClass());
            appendRecordClass.append(' ');
            appendRecordClass.append(type.name());
        } else {
            sb.append("OPT flags:");
            sb.append(timeToLive());
            sb.append(" udp:");
            sb.append(dnsClass());
        }
        sb.append(' ');
        sb.append(content().readableBytes());
        sb.append("B)");
        return sb.toString();
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return content().refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public DnsRawRecord retain() {
        content().retain();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public DnsRawRecord touch() {
        content().touch();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public DnsRawRecord retain(int i6) {
        content().retain(i6);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public DnsRawRecord touch(Object obj) {
        content().touch(obj);
        return this;
    }
}
