package io.netty.handler.codec.dns;

import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultDnsQuestion extends AbstractDnsRecord implements DnsQuestion {
    public DefaultDnsQuestion(String str, DnsRecordType dnsRecordType) {
        super(str, dnsRecordType, 0L);
    }

    public DefaultDnsQuestion(String str, DnsRecordType dnsRecordType, int i6) {
        super(str, dnsRecordType, i6, 0L);
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsRecord
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(StringUtil.simpleClassName(this));
        sb.append('(');
        sb.append(name());
        sb.append(' ');
        StringBuilder appendRecordClass = DnsMessageUtil.appendRecordClass(sb, dnsClass());
        appendRecordClass.append(' ');
        appendRecordClass.append(type().name());
        appendRecordClass.append(')');
        return sb.toString();
    }
}
