package io.netty.handler.codec.dns;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultDnsPtrRecord extends AbstractDnsRecord implements DnsPtrRecord {
    private final String hostname;

    public DefaultDnsPtrRecord(String str, int i6, long j6, String str2) {
        super(str, DnsRecordType.PTR, i6, j6);
        this.hostname = (String) ObjectUtil.checkNotNull(str2, "hostname");
    }

    @Override // io.netty.handler.codec.dns.DnsPtrRecord
    public String hostname() {
        return this.hostname;
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsRecord
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(StringUtil.simpleClassName(this));
        sb.append('(');
        DnsRecordType type = type();
        sb.append(name().isEmpty() ? "<root>" : name());
        sb.append(' ');
        sb.append(timeToLive());
        sb.append(' ');
        StringBuilder appendRecordClass = DnsMessageUtil.appendRecordClass(sb, dnsClass());
        appendRecordClass.append(' ');
        appendRecordClass.append(type.name());
        sb.append(' ');
        sb.append(this.hostname);
        return sb.toString();
    }
}
