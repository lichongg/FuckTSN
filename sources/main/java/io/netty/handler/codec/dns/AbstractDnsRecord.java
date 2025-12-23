package io.netty.handler.codec.dns;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.IDN;
import kotlin.j1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractDnsRecord implements DnsRecord {
    private final short dnsClass;
    private int hashCode;
    private final String name;
    private final long timeToLive;
    private final DnsRecordType type;

    protected AbstractDnsRecord(String str, DnsRecordType dnsRecordType, long j6) {
        this(str, dnsRecordType, 1, j6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DnsRecord)) {
            return false;
        }
        DnsRecord dnsRecord = (DnsRecord) obj;
        int i6 = this.hashCode;
        return (i6 == 0 || i6 == dnsRecord.hashCode()) && type().intValue() == dnsRecord.type().intValue() && dnsClass() == dnsRecord.dnsClass() && name().equals(dnsRecord.name());
    }

    protected AbstractDnsRecord(String str, DnsRecordType dnsRecordType, int i6, long j6) {
        ObjectUtil.checkPositiveOrZero(j6, "timeToLive");
        this.name = appendTrailingDot(IDN.toASCII((String) ObjectUtil.checkNotNull(str, CommonNetImpl.NAME)));
        this.type = (DnsRecordType) ObjectUtil.checkNotNull(dnsRecordType, "type");
        this.dnsClass = (short) i6;
        this.timeToLive = j6;
    }

    @Override // io.netty.handler.codec.dns.DnsRecord
    public int dnsClass() {
        return this.dnsClass & j1.f43986d;
    }

    public int hashCode() {
        int i6 = this.hashCode;
        if (i6 != 0) {
            return i6;
        }
        int hashCode = (this.name.hashCode() * 31) + (type().intValue() * 31) + dnsClass();
        this.hashCode = hashCode;
        return hashCode;
    }

    @Override // io.netty.handler.codec.dns.DnsRecord
    public String name() {
        return this.name;
    }

    @Override // io.netty.handler.codec.dns.DnsRecord
    public long timeToLive() {
        return this.timeToLive;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(StringUtil.simpleClassName(this));
        sb.append('(');
        sb.append(name());
        sb.append(' ');
        sb.append(timeToLive());
        sb.append(' ');
        StringBuilder appendRecordClass = DnsMessageUtil.appendRecordClass(sb, dnsClass());
        appendRecordClass.append(' ');
        appendRecordClass.append(type().name());
        appendRecordClass.append(')');
        return sb.toString();
    }

    @Override // io.netty.handler.codec.dns.DnsRecord
    public DnsRecordType type() {
        return this.type;
    }

    private static String appendTrailingDot(String str) {
        if (str.length() > 0 && str.charAt(str.length() - 1) != '.') {
            return str + '.';
        }
        return str;
    }
}
