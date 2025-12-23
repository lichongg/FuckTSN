package io.netty.handler.codec.dns;

import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractDnsOptPseudoRrRecord extends AbstractDnsRecord implements DnsOptPseudoRecord {
    protected AbstractDnsOptPseudoRrRecord(int i6, int i7, int i8) {
        super("", DnsRecordType.OPT, i6, packIntoLong(i7, i8));
    }

    protected AbstractDnsOptPseudoRrRecord(int i6) {
        super("", DnsRecordType.OPT, i6, 0L);
    }

    private static long packIntoLong(int i6, int i7) {
        return (((i6 & 255) << 24) | ((i7 & 255) << 16)) & 4294967295L;
    }

    final StringBuilder toStringBuilder() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(StringUtil.simpleClassName(this));
        sb.append('(');
        sb.append("OPT flags:");
        sb.append(flags());
        sb.append(" version:");
        sb.append(version());
        sb.append(" extendedRecode:");
        sb.append(extendedRcode());
        sb.append(" udp:");
        sb.append(dnsClass());
        sb.append(')');
        return sb;
    }

    @Override // io.netty.handler.codec.dns.DnsOptPseudoRecord
    public int extendedRcode() {
        return (short) ((((int) timeToLive()) >> 24) & 255);
    }

    @Override // io.netty.handler.codec.dns.DnsOptPseudoRecord
    public int flags() {
        return (short) (((short) timeToLive()) & 255);
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsRecord
    public String toString() {
        return toStringBuilder().toString();
    }

    @Override // io.netty.handler.codec.dns.DnsOptPseudoRecord
    public int version() {
        return (short) ((((int) timeToLive()) >> 16) & 255);
    }
}
