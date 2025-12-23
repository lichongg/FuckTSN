package io.netty.handler.codec.dns;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DnsOpCode implements Comparable<DnsOpCode> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final DnsOpCode QUERY = new DnsOpCode(0, "QUERY");
    public static final DnsOpCode IQUERY = new DnsOpCode(1, "IQUERY");
    public static final DnsOpCode STATUS = new DnsOpCode(2, "STATUS");
    public static final DnsOpCode NOTIFY = new DnsOpCode(4, "NOTIFY");
    public static final DnsOpCode UPDATE = new DnsOpCode(5, "UPDATE");

    private DnsOpCode(int i6) {
        this(i6, "UNKNOWN");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DnsOpCode) && this.byteValue == ((DnsOpCode) obj).byteValue;
    }

    public DnsOpCode(int i6, String str) {
        this.byteValue = (byte) i6;
        this.name = (String) ObjectUtil.checkNotNull(str, CommonNetImpl.NAME);
    }

    public static DnsOpCode valueOf(int i6) {
        return i6 != 0 ? i6 != 1 ? i6 != 2 ? i6 != 4 ? i6 != 5 ? new DnsOpCode(i6) : UPDATE : NOTIFY : STATUS : IQUERY : QUERY;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    @Override // java.lang.Comparable
    public int compareTo(DnsOpCode dnsOpCode) {
        return this.byteValue - dnsOpCode.byteValue;
    }

    public int hashCode() {
        return this.byteValue;
    }

    public String toString() {
        String str = this.text;
        if (str != null) {
            return str;
        }
        String str2 = this.name + '(' + (this.byteValue & 255) + ')';
        this.text = str2;
        return str2;
    }
}
